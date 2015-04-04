package com.intere.generator.metadata;

/**
 * MetadataClassesListSummary.java
 * 
 * Generated by JSON Model Generator v0.0.4 on Thu Apr 02 08:37:29 MDT 2015.
 * https://github.com/intere/generator-json-models
 * 
 * The generator tool is licensed under the LGPL: http://www.gnu.org/licenses/lgpl-3.0.html#content
*/

import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class MetadataClassesListSummary implements Serializable {
	private String className;
	private List<String> propertyList = new ArrayList<String>();

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
	 * Setter for propertyList property
	*/
	public void setPropertyList(List<String> propertyList) {
		this.propertyList = propertyList;
	}

	/**
	 * Getter for propertyList property
	*/
	public List<String> getPropertyList() {
		return this.propertyList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((className == null) ? 0 : className.hashCode());
		result = prime * result + ((propertyList == null) ? 0 : propertyList.hashCode());
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
		MetadataClassesListSummary other = (MetadataClassesListSummary)obj;
		if(className == null) {
			if(other.className != null)
				return false;
		} else if(!className.equals(other.className))
			return false;
		if(propertyList == null) {
			if(other.propertyList != null)
				return false;
		} else if(!propertyList.equals(other.propertyList))
			return false;
		return true;
	}

}	// end MetadataClassesListSummary

