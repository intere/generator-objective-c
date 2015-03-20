package com.intere.generator.metadata;

/**
 * ModelClassImportsTest.java
 * 
 * Generated by JSON Model Generator v0.0.3 on Wed Mar 11 06:37:40 MDT 2015.
 * https://github.com/intere/generator-json-models
 * 
 * The generator tool is licensed under the LGPL: http://www.gnu.org/licenses/lgpl-3.0.html#content
*/

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


public class ModelClassImportsTest {
	private static final ObjectMapper jsonMapper = new ObjectMapper();
	private ModelClassImports instance;

	@Before
	public void setUp() throws JsonParseException, JsonMappingException, IOException {
		InputStream in = new ByteArrayInputStream("{}".getBytes());
		instance = jsonMapper.readValue(in, ModelClassImports.class);
	}

	protected String serialize(ModelClassImports object)  throws JsonGenerationException, JsonMappingException, IOException {
		return jsonMapper.writeValueAsString(object);
	}

	protected ModelClassImports deserialize(String json) throws JsonParseException, JsonMappingException, IOException {
		return jsonMapper.readValue(json, ModelClassImports.class);
	}

	@Test
	public void testImportName() throws Exception {
		final String expected = "test";
		instance.setImportName(expected);
		String serialized = serialize(instance);
		instance = deserialize(serialized);
		assertEquals("The importName property didn't deserialize properly", expected, instance.getImportName());
	}

	@Test
	public void testTargetClassName() throws Exception {
		final String expected = "test";
		instance.setTargetClassName(expected);
		String serialized = serialize(instance);
		instance = deserialize(serialized);
		assertEquals("The targetClassName property didn't deserialize properly", expected, instance.getTargetClassName());
	}

}	// end ModelClassImportsTest
