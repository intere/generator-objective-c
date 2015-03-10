package com.intere.generator.metadata;

/**
 * MetadataClassesTransientPropertyTest.java
 * 
 * Generated by JSON Model Generator v0.0.3 on Tue Mar 10 07:56:21 MDT 2015.
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


public class MetadataClassesTransientPropertyTest {
	private static final ObjectMapper jsonMapper = new ObjectMapper();
	private MetadataClassesTransientProperty instance;

	@Before
	public void setUp() throws JsonParseException, JsonMappingException, IOException {
		InputStream in = new ByteArrayInputStream("{}".getBytes());
		instance = jsonMapper.readValue(in, MetadataClassesTransientProperty.class);
	}

	protected String serialize(MetadataClassesTransientProperty object)  throws JsonGenerationException, JsonMappingException, IOException {
		return jsonMapper.writeValueAsString(object);
	}

	protected MetadataClassesTransientProperty deserialize(String json) throws JsonParseException, JsonMappingException, IOException {
		return jsonMapper.readValue(json, MetadataClassesTransientProperty.class);
	}

	@Test
	public void testClassName() throws Exception {
		final String expected = "test";
		instance.setClassName(expected);
		String serialized = serialize(instance);
		instance = deserialize(serialized);
		assertEquals("The className property didn't deserialize properly", expected, instance.getClassName());
	}

	@Test
	public void testName() throws Exception {
		final String expected = "test";
		instance.setName(expected);
		String serialized = serialize(instance);
		instance = deserialize(serialized);
		assertEquals("The name property didn't deserialize properly", expected, instance.getName());
	}

	@Test
	public void testType() throws Exception {
		final String expected = "test";
		instance.setType(expected);
		String serialized = serialize(instance);
		instance = deserialize(serialized);
		assertEquals("The type property didn't deserialize properly", expected, instance.getType());
	}

}	// end MetadataClassesTransientPropertyTest

