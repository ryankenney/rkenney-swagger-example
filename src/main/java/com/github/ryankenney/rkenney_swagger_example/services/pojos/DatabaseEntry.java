package com.github.ryankenney.rkenney_swagger_example.services.pojos;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

// JAB Annotations define the base schema
@XmlRootElement
// Swagger annotations can be used to enhance the schema definition
@ApiModel(value = "DatabaseEntry")
public class DatabaseEntry {

	public DatabaseEntry() {}
	
	public DatabaseEntry(int id, String type, String data) {
		this.id = id;
		this.type = type;
		this.data = data; 
	}
	
	@XmlElement
	@ApiModelProperty(required = true, example = "41")
	public int id;

	@XmlElement
	@ApiModelProperty(required = true, example = "dog")
	public String type;
	
	@XmlElement
	@ApiModelProperty(required = true, example = "ralph")
	public String data;
}
