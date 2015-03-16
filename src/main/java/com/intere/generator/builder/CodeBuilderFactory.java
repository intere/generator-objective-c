package com.intere.generator.builder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import com.intere.generator.Language;

/**
 * Factory creator for the appropriate type of code builder.
 * @author einternicola
 *
 */
public class CodeBuilderFactory {

	/**
	 * Performs the actual writing of the generated files.
	 * @param generatedCode
	 * @throws IOException
	 */
	public static void generateCode(HashMap<File, String> generatedCode) throws IOException {
		for(File f : generatedCode.keySet()) {
			new File(f.getParent()).mkdirs();
			FileOutputStream out = new FileOutputStream(f);
			out.write(generatedCode.get(f).getBytes());
			out.close();
			System.out.println("Generated Source File: " + f.getAbsolutePath());
		}
	}

	/**
	 * Performs the writing of the generated test files to disk.
	 * @param generatedCode
	 * @throws IOException
	 */
	public static void generateTests(HashMap<File, String> generatedCode) throws IOException {
		if(null != generatedCode) {
			for(File f : generatedCode.keySet()) {
				FileOutputStream out = new FileOutputStream(f);
				out.write(generatedCode.get(f).getBytes());
				out.close();
				System.out.println("Generated TestFile: " + f.getAbsolutePath());
			}
		}
	}

	public static CodeBuilder getCodeBuilderFactory(Language lang, String namespace, String className, String jsonFilename) throws IOException {
		if(null != lang) {
			switch(lang) {
			case ObjC: {
				return new ObjectiveCCodeBuilder(className, jsonFilename);
			}
			case Java: {
				return new JavaCodeBuilder(namespace, className, jsonFilename);
			}
			case Ruby: {
				return new RubyCodeBuilder(namespace, className, jsonFilename);
			}
			}
		}

		throw new IllegalArgumentException("Unsupported Language: " + lang.getFullName());
	}
}
