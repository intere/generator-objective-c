package com.intere.generator.builder.orchestration.language;

import java.util.Date;

import com.intere.generator.App;
import com.intere.generator.metadata.ModelClass;
import com.intere.generator.metadata.ModelClassProperty;

public abstract class AbstractLanguageOrchestrator implements LanguageOrchestrator.LanguageUtility {
	@Override
	public String tabs(int tabCount) {
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<tabCount; i++) {
			builder.append("\t");
		}
		return builder.toString();
	}
	
	@Override
	public String singleLineComment(String comment) {
		return singleLineComment(comment, 0);
	}
	
	@Override
	public String singleLineComment(String comment, int tabCount) {
		return tabs(tabCount) + "// " + comment;
	}
	
	@Override
	public String multiLineComment(String comment) {
		return multiLineComment(comment, 0);
	}

	@Override
	public String multiLineComment(String comment, int tabCount) {
		comment = comment.trim();
		String nlReplacement = "\n" + tabs(tabCount) + " * ";
		return tabs(tabCount) + "/**\n" + tabs(tabCount) + " * " + comment.replaceAll("\\\n", nlReplacement) + "\n" + tabs(tabCount) + "*/";
	}
	
	@Override
	public String buildFileComment(ModelClass modelClass, String extension) {
		return multiLineComment("\n" +
				modelClass.getFileName() + extension + "\n" +
				"\n" +
				"Generated by JSON Model Generator v" + App.getVersion() + " on " + getDate() + ".\n" +
				"https://github.com/intere/generator-json-models\n" +
				"\n" +
				"The generator tool is licensed under the LGPL: http://www.gnu.org/licenses/lgpl-3.0.html#content\n" +
				"\n") + "\n\n";
	}
	
	@Override
	public String buildPropertyDeclarations(ModelClass modelClass) {
		StringBuilder builder = new StringBuilder();
		for(ModelClassProperty prop : modelClass.getProperty()) {
			builder.append(buildSinglePropertyDeclaration(prop));
		}
		builder.append("\n");
		return builder.toString();
	}
	
	public static String getDate() {
		return new Date().toString();
	}
}
