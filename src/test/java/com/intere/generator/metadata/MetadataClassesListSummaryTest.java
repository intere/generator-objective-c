package com.intere.generator.metadata;

/**
 * MetadataClassesListSummaryTest.java
 * 
 * Generated by JSON Model Generator v0.0.4 on Thu Apr 02 07:32:25 MDT 2015.
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
import java.util.ArrayList;
import java.util.List;


public class MetadataClassesListSummaryTest {
	private static final ObjectMapper jsonMapper = new ObjectMapper();
	private MetadataClassesListSummary instance;

	@Before
	public void setUp() throws JsonParseException, JsonMappingException, IOException {
		InputStream in = new ByteArrayInputStream("{}".getBytes());
		instance = jsonMapper.readValue(in, MetadataClassesListSummary.class);
	}

	protected String serialize(MetadataClassesListSummary object)  throws JsonGenerationException, JsonMappingException, IOException {
		return jsonMapper.writeValueAsString(object);
	}

	protected MetadataClassesListSummary deserialize(String json) throws JsonParseException, JsonMappingException, IOException {
		return jsonMapper.readValue(json, MetadataClassesListSummary.class);
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
	public void testPropertyList() throws Exception {
		final String object = new String();
		final List<String> expected = new ArrayList<String>();
		expected.add(object);
		instance.setPropertyList(expected);
		String serialized = serialize(instance);
		instance = deserialize(serialized);
		assertEquals("The propertyList property didn't deserialize properly", expected, instance.getPropertyList());
	}

}	// end MetadataClassesListSummaryTest

