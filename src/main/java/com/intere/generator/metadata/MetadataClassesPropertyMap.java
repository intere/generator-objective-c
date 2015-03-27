package com.intere.generator.metadata;

/**
 * MetadataClassesPropertyMap.java
 * 
 * Generated by JSON Model Generator v0.0.4 on Thu Mar 26 08:14:39 MDT 2015.
 * https://github.com/intere/generator-json-models
 * 
 * The generator tool is licensed under the LGPL: http://www.gnu.org/licenses/lgpl-3.0.html#content
*/

import java.io.Serializable;

@SuppressWarnings("serial")
public class MetadataClassesPropertyMap implements Serializable {
	private String property;
	private String mapClassName;
	private String mapClassProperty;

	/**
	 * Setter for property property
	*/
	public void setProperty(String property) {
		this.property = property;
	}

	/**
	 * Getter for property property
	*/
	public String getProperty() {
		return this.property;
	}

	/**
	 * Setter for mapClassName property
	*/
	public void setMapClassName(String mapClassName) {
		this.mapClassName = mapClassName;
	}

	/**
	 * Getter for mapClassName property
	*/
	public String getMapClassName() {
		return this.mapClassName;
	}

	/**
	 * Setter for mapClassProperty property
	*/
	public void setMapClassProperty(String mapClassProperty) {
		this.mapClassProperty = mapClassProperty;
	}

	/**
	 * Getter for mapClassProperty property
	*/
	public String getMapClassProperty() {
		return this.mapClassProperty;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((property == null) ? 0 : property.hashCode());
		result = prime * result + ((mapClassName == null) ? 0 : mapClassName.hashCode());
		result = prime * result + ((mapClassProperty == null) ? 0 : mapClassProperty.hashCode());
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
		MetadataClassesPropertyMap other = (MetadataClassesPropertyMap)obj;
		if(property == null) {
			if(other.property != null)
				return false;
		} else if(!property.equals(other.property))
			return false;
		if(mapClassName == null) {
			if(other.mapClassName != null)
				return false;
		} else if(!mapClassName.equals(other.mapClassName))
			return false;
		if(mapClassProperty == null) {
			if(other.mapClassProperty != null)
				return false;
		} else if(!mapClassProperty.equals(other.mapClassProperty))
			return false;
		return true;
	}

}	// end MetadataClassesPropertyMap

