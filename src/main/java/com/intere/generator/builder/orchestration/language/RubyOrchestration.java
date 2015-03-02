package com.intere.generator.builder.orchestration.language;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.intere.generator.builder.orchestration.OrchestrationTree;
import com.intere.generator.builder.orchestration.language.utility.LanguageUtility;
import com.intere.generator.builder.orchestration.language.utility.RubyLanguageUtility;
import com.intere.generator.metadata.ModelClass;

public class RubyOrchestration implements LanguageOrchestrator {
	private static final Logger LOGGER = LogManager.getLogger(RubyOrchestration.class);
	LanguageUtility languageUtil = new RubyLanguageUtility();
	
	@Override
	public List<File> generateModels(File outputDirectory, OrchestrationTree tree) throws IOException {
		List<File> generatedClasses = new ArrayList<>();
		languageUtil.enforceFilenames(tree);
		for(ModelClass modelClass : tree.getModelClasses()) {
			generatedClasses.add(buildModelClassFile(outputDirectory, modelClass));
		}
		return generatedClasses;
	}

	@Override
	public List<File> generateModelUnitTests(File testPath, OrchestrationTree tree) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<File> generateServices(File servicePath, OrchestrationTree tree) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<File> generateViews(File viewPath, OrchestrationTree tree) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<File> generateRestServices(File restPath, OrchestrationTree tree) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	private File buildModelClassFile(File outputDirectory, ModelClass modelClass) throws IOException {
		String fileContents = buildModelClass(modelClass);
		File outputFile = new File(outputDirectory, modelClass.getFileName() + ".rb");
		LOGGER.info("About to create Model Class: " + outputFile.getAbsolutePath());
		FileOutputStream fout = new FileOutputStream(outputFile);
		IOUtils.write(fileContents, fout);
		fout.close();
		return outputFile;
	}

	private String buildModelClass(ModelClass modelClass) {
		StringBuilder builder = new StringBuilder();
		builder.append(languageUtil.buildNamespace(modelClass));
		builder.append(languageUtil.buildFileComment(modelClass.getFileName() + ".rb"));
		builder.append(languageUtil.buildImports(modelClass));
		builder.append(languageUtil.buildClassDeclaration(modelClass));
		builder.append(languageUtil.buildPropertyDeclarations(modelClass));
		builder.append(languageUtil.buildGettersAndSetters(modelClass));
		builder.append(languageUtil.buildModelUtilityDefinitionMethods(modelClass));
		builder.append(languageUtil.finishClass(modelClass, false));
		return builder.toString();
	}

	@Override
	public List<File> copyResources(File sourcePath, OrchestrationTree tree) throws IOException {
		List<File> generatedResources = new ArrayList<>();
		Map<File, String> resources = languageUtil.copyModelResources(sourcePath, tree);
		for(File f : resources.keySet()) {
			LOGGER.info("About to copy resource: " + f.getAbsolutePath());
			FileOutputStream fout = new FileOutputStream(f);
			IOUtils.write(resources.get(f), fout);
			fout.close();
			generatedResources.add(f);
		}
		return generatedResources;
	}
}
