package com.intere.generator.builder.orchestration.language.utility;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;

import com.intere.generator.App;
import com.intere.generator.metadata.ModelClass;
import com.intere.generator.metadata.ModelClassProperty;

public abstract class AbstractLanguageUtility implements LanguageUtility {

	
	/**
	 * Reads a resource (from the classpath) to a string for you.
	 * @param resourceName
	 * @return
	 * @throws IOException
	 */
	public String readResource(String resourceName) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream in = App.class.getResourceAsStream(resourceName);
		IOUtils.copy(in, out);
		
		return new String(out.toByteArray());
	}
	
	public String readFile(String filename) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream in = new FileInputStream(filename);
		IOUtils.copy(in, out);
		
		return new String(out.toByteArray());
	}
	
	/**
	 * Reads the provided resource and performs the substitution specified by 
	 * {{@link #replaceHeaderVariables(String)}.
	 * @param resourceName The resource you would like to read.
	 * @return
	 * @throws IOException
	 */
	public String readResourceAndReplaceHeaders(String resourceName) throws IOException {
		return replaceHeaderVariables(readResource(resourceName));
	}
	
	/**
	 * Replaces the "${version}" string with the version and "${date}" with the date/time.
	 * @param input
	 * @return
	 */
	protected String replaceHeaderVariables(String input) {
		return input.replaceAll(Pattern.quote("${version}"), App.getVersion())
				.replaceAll(Pattern.quote("${date}"), new Date().toString());
	}
}
