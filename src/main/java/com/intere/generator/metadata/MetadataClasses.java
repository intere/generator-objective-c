package com.intere.generator.metadata;

/**
 * MetadataClasses.java
 * 
 * Generated by JSON Model Generator v0.0.4 on Tue Mar 31 08:38:11 MDT 2015.
 * https://github.com/intere/generator-json-models
 * 
 * The generator tool is licensed under the LGPL: http://www.gnu.org/licenses/lgpl-3.0.html#content
*/

import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class MetadataClasses implements Serializable {
	private String className;
	private String jsonFile;
	private String key;
	private String urlPath;
	private Boolean readonly;
	private List<MetadataClassesPropertyMap> propertyMap = new ArrayList<MetadataClassesPropertyMap>();
	private List<MetadataClassesTransientProperty> transientProperty = new ArrayList<MetadataClassesTransientProperty>();
	private List<MetadataClassesImports> imports = new ArrayList<MetadataClassesImports>();
	private List<MetadataClassesListSummary> listSummary = new ArrayList<MetadataClassesListSummary>();

	/**
	 * Setter for className property
	*/
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * Getter for className property
	*/
	public String getClassName() {
		return this.className;
	}

	/**
	 * Setter for jsonFile property
	*/
	public void setJsonFile(String jsonFile) {
		this.jsonFile = jsonFile;
	}

	/**
	 * Getter for jsonFile property
	*/
	public String getJsonFile() {
		return this.jsonFile;
	}

	/**
	 * Setter for key property
	*/
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Getter for key property
	*/
	public String getKey() {
		return this.key;
	}

	/**
	 * Setter for urlPath property
	*/
	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}

	/**
	 * Getter for urlPath property
	*/
	public String getUrlPath() {
		return this.urlPath;
	}

	/**
	 * Setter for readonly property
	*/
	public void setReadonly(Boolean readonly) {
		this.readonly = readonly;
	}

	/**
	 * Getter for readonly property
	*/
	public Boolean getReadonly() {
		return this.readonly;
	}

	/**
	 * Setter for propertyMap property
	*/
	public void setPropertyMap(List<MetadataClassesPropertyMap> propertyMap) {
		this.propertyMap = propertyMap;
	}

	/**
	 * Getter for propertyMap property
	*/
	public List<MetadataClassesPropertyMap> getPropertyMap() {
		return this.propertyMap;
	}

	/**
	 * Setter for transientProperty property
	*/
	public void setTransientProperty(List<MetadataClassesTransientProperty> transientProperty) {
		this.transientProperty = transientProperty;
	}

	/**
	 * Getter for transientProperty property
	*/
	public List<MetadataClassesTransientProperty> getTransientProperty() {
		return this.transientProperty;
	}

	/**
	 * Setter for imports property
	*/
	public void setImports(List<MetadataClassesImports> imports) {
		this.imports = imports;
	}

	/**
	 * Getter for imports property
	*/
	public List<MetadataClassesImports> getImports() {
		return this.imports;
	}

	/**
	 * Setter for listSummary property
	*/
	public void setListSummary(List<MetadataClassesListSummary> listSummary) {
		this.listSummary = listSummary;
	}

	/**
	 * Getter for listSummary property
	*/
	public List<MetadataClassesListSummary> getListSummary() {
		return this.listSummary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((className == null) ? 0 : className.hashCode());
		result = prime * result + ((jsonFile == null) ? 0 : jsonFile.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((urlPath == null) ? 0 : urlPath.hashCode());
		result = prime * result + ((readonly == null) ? 0 : readonly.hashCode());
		result = prime * result + ((propertyMap == null) ? 0 : propertyMap.hashCode());
		result = prime * result + ((transientProperty == null) ? 0 : transientProperty.hashCode());
		result = prime * result + ((imports == null) ? 0 : imports.hashCode());
		result = prime * result + ((listSummary == null) ? 0 : listSummary.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MetadataClasses other = (MetadataClasses)obj;
		if(className == null) {
			if(other.className != null)
				return false;
		} else if(!className.equals(other.className))
			return false;
		if(jsonFile == null) {
			if(other.jsonFile != null)
				return false;
		} else if(!jsonFile.equals(other.jsonFile))
			return false;
		if(key == null) {
			if(other.key != null)
				return false;
		} else if(!key.equals(other.key))
			return false;
		if(urlPath == null) {
			if(other.urlPath != null)
				return false;
		} else if(!urlPath.equals(other.urlPath))
			return false;
		if(readonly == null) {
			if(other.readonly != null)
				return false;
		} else if(!readonly.equals(other.readonly))
			return false;
		if(propertyMap == null) {
			if(other.propertyMap != null)
				return false;
		} else if(!propertyMap.equals(other.propertyMap))
			return false;
		if(transientProperty == null) {
			if(other.transientProperty != null)
				return false;
		} else if(!transientProperty.equals(other.transientProperty))
			return false;
		if(imports == null) {
			if(other.imports != null)
				return false;
		} else if(!imports.equals(other.imports))
			return false;
		if(listSummary == null) {
			if(other.listSummary != null)
				return false;
		} else if(!listSummary.equals(other.listSummary))
			return false;
		return true;
	}

}	// end MetadataClasses

