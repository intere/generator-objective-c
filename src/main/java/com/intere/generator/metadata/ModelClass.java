//
//  ModelClass
//
//  Generated by JSON Model Generator v0.0.3 on Thu Feb 19 07:52:41 MST 2015.
//    https://github.com/intere/generator-json-models
//
//    The generator tool is licensed under the LGPL: http://www.gnu.org/licenses/lgpl-3.0.html#content
//
//

package com.intere.generator.metadata;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;


@SuppressWarnings("serial")
public class ModelClass implements Serializable {
	private String uniqueId;
	private String className;
	private String fileName;
	private String testClassName;
	private Boolean readonly;
	private String namespace;
	private Boolean hasSubClasses;
	private List<ModelClassProperty> property = new ArrayList<ModelClassProperty>();
	private String restUrl;
	private List<String> imports;

	/**
	 * Setter for uniqueId property.
	 */
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	/**
	 * Getter for uniqueId property.
	 */
	public String getUniqueId() {
		return uniqueId;
	}

	/**
	 * Setter for className property.
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * Getter for className property.
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * Setter for fileName property.
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Getter for fileName property.
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Setter for testClassName property.
	 */
	public void setTestClassName(String testClassName) {
		this.testClassName = testClassName;
	}

	/**
	 * Getter for testClassName property.
	 */
	public String getTestClassName() {
		return testClassName;
	}

	/**
	 * Setter for readonly property.
	 */
	public void setReadonly(Boolean readonly) {
		this.readonly = readonly;
	}

	/**
	 * Getter for readonly property.
	 */
	public Boolean getReadonly() {
		return readonly;
	}

	/**
	 * Setter for namespace property.
	 */
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	/**
	 * Getter for namespace property.
	 */
	public String getNamespace() {
		return namespace;
	}

	/**
	 * Setter for hasSubClasses property.
	 */
	public void setHasSubClasses(Boolean hasSubClasses) {
		this.hasSubClasses = hasSubClasses;
	}

	/**
	 * Getter for hasSubClasses property.
	 */
	public Boolean getHasSubClasses() {
		return hasSubClasses;
	}

	/**
	 * Setter for property property.
	 */
	public void setProperty(List<ModelClassProperty> property) {
		this.property = property;
	}

	/**
	 * Getter for property property.
	 */
	public List<ModelClassProperty> getProperty() {
		return property;
	}

	/**
	 * Setter for restUrl property.
	 */
	public void setRestUrl(String restUrl) {
		this.restUrl = restUrl;
	}

	/**
	 * Getter for restUrl property.
	 */
	public String getRestUrl() {
		return restUrl;
	}

	/**
	 * Setter for imports property.
	 */
	public void setImports(List<String> imports) {
		this.imports = imports;
	}

	/**
	 * Getter for imports property.
	 */
	public List<String> getImports() {
		return imports;
	}

}
