package com.intere.generator.builder.orchestration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.intere.generator.Language;
import com.intere.generator.builder.CodeBuilder;
import com.intere.generator.builder.CodeBuilderFactory;
import com.intere.generator.metadata.Metadata;
import com.intere.generator.metadata.MetadataClasses;

public class CodeOrchestration {
	private Metadata metadata;
	private File outputDirectory;
	private File jsonDirectory;
	private HashMap<String, MetadataClasses> nodeMap = new HashMap<>();
	private Language language;
	private List<CodeBuilder> builders = new ArrayList<>();

	public CodeOrchestration(String orchestrationFilePath, File outputDirectory) throws IOException {
		this.outputDirectory = outputDirectory;
		readMetadata(orchestrationFilePath);
		createGenerationModels();
		generateCode();
	}
	
	private void generateCode() throws IOException {
		if(metadata.getGenerate().getModels()) {
			for(CodeBuilder builder : builders) {
				CodeBuilderFactory.generateCode(builder.buildSourceFiles(outputDirectory));
			}
		}
		if(metadata.getGenerate().getTests()) {
			for(CodeBuilder builder : builders) {
				CodeBuilderFactory.generateTests(builder.buildTestFiles(outputDirectory));
			}
		}
		if(metadata.getGenerate().getServices()) {
			for(CodeBuilder builder : builders) {
				CodeBuilderFactory.generateCode(builder.buildServiceFiles(outputDirectory));
			}
		}
		if(metadata.getGenerate().getViews()) {
			for(CodeBuilder builder : builders) {
				CodeBuilderFactory.generateCode(builder.buildViewFiles(outputDirectory));
			}
		}
//		// TODO
//		if(metadata.getGenerate().getRestServices()) {		
//			for(CodeBuilder builder : builders) {
//				CodeBuilderFactory.generateCode(builder.buildRestServices(outputDirectory));
//			}
//		}
	}

	private void createGenerationModels() throws JsonProcessingException, IOException {
		for(MetadataClasses metaClass : metadata.getClasses()) {
			if(nodeMap.containsKey(metaClass.getClassName())) {
				throw new IllegalArgumentException("Error: There are multiple Metadata Classes with the name: " + metaClass.getClassName());
			} else {
				nodeMap.put(metaClass.getClassName(), metaClass);
				builders.add(createBuilderFactoryForMetadataClass(metaClass));
			}
		}
		
		System.out.println("Language: " + language.getFullName());
		System.out.println("We have the following classes loaded:");
		for(String key : nodeMap.keySet()) {
			System.out.println(key);
		}
	}	

	private CodeBuilder createBuilderFactoryForMetadataClass(MetadataClasses metaClass) throws IOException {
		String jsonFilename = getJsonFilename(metaClass);
		return CodeBuilderFactory.getCodeBuilderFactory(language, metadata.getNamespace(), metaClass.getClassName(),  jsonFilename);
	}
	
	private String getJsonFilename(MetadataClasses metaClass) {
		return new File(jsonDirectory, metaClass.getJson()).getAbsolutePath();
	}

	private void readMetadata(String metadataPath) throws IOException {
		ObjectMapper jsonMapper = new ObjectMapper();
		metadata = jsonMapper.readValue(new FileInputStream(metadataPath), Metadata.class);
		jsonDirectory = new File(metadataPath).getParentFile();
		language = Language.fromFullName(metadata.getLanguage());
	}
}
