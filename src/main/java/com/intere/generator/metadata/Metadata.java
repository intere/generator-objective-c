package com.intere.generator.metadata;

/**
 * Metadata.java
 * 
 * Generated by JSON Model Generator v0.0.4 on Thu Apr 02 07:32:25 MDT 2015.
 * https://github.com/intere/generator-json-models
 * 
 * The generator tool is licensed under the LGPL: http://www.gnu.org/licenses/lgpl-3.0.html#content
*/

import org.codehaus.jackson.annotate.JsonIgnore;
import java.lang.String;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Metadata implements Serializable {
	private String language;
	private String namespace;
	private List<MetadataClasses> classes = new ArrayList<MetadataClasses>();
	private MetadataGenerate generate;
	@JsonIgnore
	private Metadata self;		// Transient Property

	/**
	 * Setter for language property
	*/
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Getter for language property
	*/
	public String getLanguage() {
		return this.language;
	}

	/**
	 * Setter for namespace property
	*/
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	/**
	 * Getter for namespace property
	*/
	public String getNamespace() {
		return this.namespace;
	}

	/**
	 * Setter for classes property
	*/
	public void setClasses(List<MetadataClasses> classes) {
		this.classes = classes;
	}

	/**
	 * Getter for classes property
	*/
	public List<MetadataClasses> getClasses() {
		return this.classes;
	}

	/**
	 * Setter for generate property
	*/
	public void setGenerate(MetadataGenerate generate) {
		this.generate = generate;
	}

	/**
	 * Getter for generate property
	*/
	public MetadataGenerate getGenerate() {
		return this.generate;
	}

	/**
	 * Setter for self property
	*/
	public void setSelf(Metadata self) {
		this.self = self;
	}

	/**
	 * Getter for self property
	*/
	public Metadata getSelf() {
		return this.self;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((namespace == null) ? 0 : namespace.hashCode());
		result = prime * result + ((classes == null) ? 0 : classes.hashCode());
		result = prime * result + ((generate == null) ? 0 : generate.hashCode());
		result = prime * result + ((self == null) ? 0 : self.hashCode());
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
		Metadata other = (Metadata)obj;
		if(language == null) {
			if(other.language != null)
				return false;
		} else if(!language.equals(other.language))
			return false;
		if(namespace == null) {
			if(other.namespace != null)
				return false;
		} else if(!namespace.equals(other.namespace))
			return false;
		if(classes == null) {
			if(other.classes != null)
				return false;
		} else if(!classes.equals(other.classes))
			return false;
		if(generate == null) {
			if(other.generate != null)
				return false;
		} else if(!generate.equals(other.generate))
			return false;
		if(self == null) {
			if(other.self != null)
				return false;
		} else if(!self.equals(other.self))
			return false;
		return true;
	}

}	// end Metadata

