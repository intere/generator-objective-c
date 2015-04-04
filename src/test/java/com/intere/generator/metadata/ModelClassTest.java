package com.intere.generator.metadata;

/**
 * ModelClassTest.java
 * 
 * Generated by JSON Model Generator v0.0.4 on Thu Apr 02 08:37:30 MDT 2015.
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


public class ModelClassTest {
	private static final ObjectMapper jsonMapper = new ObjectMapper();
	private ModelClass instance;

	@Before
	public void setUp() throws JsonParseException, JsonMappingException, IOException {
		InputStream in = new ByteArrayInputStream("{}".getBytes());
		instance = jsonMapper.readValue(in, ModelClass.class);
	}

	protected String serialize(ModelClass object)  throws JsonGenerationException, JsonMappingException, IOException {
		return jsonMapper.writeValueAsString(object);
	}

	protected ModelClass deserialize(String json) throws JsonParseException, JsonMappingException, IOException {
		return jsonMapper.readValue(json, ModelClass.class);
	}

	@Test
	public void testUniqueId() throws Exception {
		final String expected = "test";
		instance.setUniqueId(expected);
		String serialized = serialize(instance);
		instance = deserialize(serialized);
		assertEquals("The uniqueId property didn't deserialize properly", expected, instance.getUniqueId());
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
	public void testFileName() throws Exception {
		final String expected = "test";
		instance.setFileName(expected);
		String serialized = serialize(instance);
		instance = deserialize(serialized);
		assertEquals("The fileName property didn't deserialize properly", expected, instance.getFileName());
	}

	@Test
	public void testTestClassName() throws Exception {
		final String expected = "test";
		instance.setTestClassName(expected);
		String serialized = serialize(instance);
		instance = deserialize(serialized);
		assertEquals("The testClassName property didn't deserialize properly", expected, instance.getTestClassName());
	}

	@Test
	public void testViewClassName() throws Exception {
		final String expected = "test";
		instance.setViewClassName(expected);
		String serialized = serialize(instance);
		instance = deserialize(serialized);
		assertEquals("The viewClassName property didn't deserialize properly", expected, instance.getViewClassName());
	}

	@Test
	public void testSingleControllerName() throws Exception {
		final String expected = "test";
		instance.setSingleControllerName(expected);
		String serialized = serialize(instance);
		instance = deserialize(serialized);
		assertEquals("The singleControllerName property didn't deserialize properly", expected, instance.getSingleControllerName());
	}

	@Test
	public void testListControllerName() throws Exception {
		final String expected = "test";
		instance.setListControllerName(expected);
		String serialized = serialize(instance);
		instance = deserialize(serialized);
		assertEquals("The listControllerName property didn't deserialize properly", expected, instance.getListControllerName());
	}

	@Test
	public void testServiceClassName() throws Exception {
		final String expected = "test";
		instance.setServiceClassName(expected);
		String serialized = serialize(instance);
		instance = deserialize(serialized);
		assertEquals("The serviceClassName property didn't deserialize properly", expected, instance.getServiceClassName());
	}

	@Test
	public void testRestClientClassName() throws Exception {
		final String expected = "test";
		instance.setRestClientClassName(expected);
		String serialized = serialize(instance);
		instance = deserialize(serialized);
		assertEquals("The restClientClassName property didn't deserialize properly", expected, instance.getRestClientClassName());
	}

	@Test
	public void testRestServiceClassName() throws Exception {
		final String expected = "test";
		instance.setRestServiceClassName(expected);
		String serialized = serialize(instance);
		instance = deserialize(serialized);
		assertEquals("The restServiceClassName property didn't deserialize properly", expected, instance.getRestServiceClassName());
	}

	@Test
	public void testReadonly() throws Exception {
		final Boolean expected = true;
		instance.setReadonly(expected);
		String serialized = serialize(instance);
		instance = deserialize(serialized);
		assertEquals("The readonly property didn't deserialize properly", expected, instance.getReadonly());
	}

	@Test
	public void testNamespace() throws Exception {
		final String expected = "test";
		instance.setNamespace(expected);
		String serialized = serialize(instance);
		instance = deserialize(serialized);
		assertEquals("The namespace property didn't deserialize properly", expected, instance.getNamespace());
	}

	@Test
	public void testHasSubClasses() throws Exception {
		final Boolean expected = true;
		instance.setHasSubClasses(expected);
		String serialized = serialize(instance);
		instance = deserialize(serialized);
		assertEquals("The hasSubClasses property didn't deserialize properly", expected, instance.getHasSubClasses());
	}

	@Test
	public void testProperty() throws Exception {
		final ModelClassProperty object = new ModelClassProperty();
		final List<ModelClassProperty> expected = new ArrayList<ModelClassProperty>();
		expected.add(object);
		instance.setProperty(expected);
		String serialized = serialize(instance);
		instance = deserialize(serialized);
		assertEquals("The property property didn't deserialize properly", expected, instance.getProperty());
	}

	@Test
	public void testRelatedClassList() throws Exception {
		final ModelClassRelatedClassList object = new ModelClassRelatedClassList();
		final List<ModelClassRelatedClassList> expected = new ArrayList<ModelClassRelatedClassList>();
		expected.add(object);
		instance.setRelatedClassList(expected);
		String serialized = serialize(instance);
		instance = deserialize(serialized);
		assertEquals("The relatedClassList property didn't deserialize properly", expected, instance.getRelatedClassList());
	}

	@Test
	public void testRestUrl() throws Exception {
		final String expected = "test";
		instance.setRestUrl(expected);
		String serialized = serialize(instance);
		instance = deserialize(serialized);
		assertEquals("The restUrl property didn't deserialize properly", expected, instance.getRestUrl());
	}

	@Test
	public void testImports() throws Exception {
		final ModelClassImports object = new ModelClassImports();
		final List<ModelClassImports> expected = new ArrayList<ModelClassImports>();
		expected.add(object);
		instance.setImports(expected);
		String serialized = serialize(instance);
		instance = deserialize(serialized);
		assertEquals("The imports property didn't deserialize properly", expected, instance.getImports());
	}

	@Test
	public void testSummaryProperties() throws Exception {
		final String object = new String();
		final List<String> expected = new ArrayList<String>();
		expected.add(object);
		instance.setSummaryProperties(expected);
		String serialized = serialize(instance);
		instance = deserialize(serialized);
		assertEquals("The summaryProperties property didn't deserialize properly", expected, instance.getSummaryProperties());
	}

}	// end ModelClassTest

