//
//  ModelClassPropertyTest
//
//  Generated by JSON Model Generator v0.0.3 on Mon Feb 23 08:50:23 MST 2015.
//    https://github.com/intere/generator-json-models
//
//    The generator tool is licensed under the LGPL: http://www.gnu.org/licenses/lgpl-3.0.html#content
//
//

package com.intere.generator.metadata;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

public class ModelClassPropertyTest {

	private static final ObjectMapper jsonMapper = new ObjectMapper();
	private ModelClassProperty modelClassProperty;

	@Before
	public void setUp() throws JsonParseException, JsonMappingException, IOException {
		InputStream in = getClass().getResourceAsStream("/com/intere/generator/metadata/model_class_property.json");
		modelClassProperty = jsonMapper.readValue(in, ModelClassProperty.class);
	}

	@Test
	public void testName() {
		assertEquals("The name property didn't deserialize properly", "id", modelClassProperty.getName());
	}

	@Test
	public void testKey() {
		assertTrue("The key property didn't deserialize properly", modelClassProperty.getKey());
	}

	@Test
	public void testType() {
		assertEquals("The type property didn't deserialize properly", "String", modelClassProperty.getType());
	}

	@Test
	public void testPrimitive() {
		assertFalse("The primitive property didn't deserialize properly", modelClassProperty.getPrimitive());
	}

	@Test
	public void testVisible() {
		assertTrue("The visible property didn't deserialize properly", modelClassProperty.getVisible());
	}

	@Test
	public void testReadonly() {
		assertTrue("The readonly property didn't deserialize properly", modelClassProperty.getReadonly());
	}

	@Test
	public void testArray() {
		assertTrue("The array property didn't deserialize properly", modelClassProperty.getArray());
	}

	@Test
	public void testArraySubType() {
		assertEquals("The arraySubType property didn't deserialize properly", "String", modelClassProperty.getArraySubType());
	}


}
