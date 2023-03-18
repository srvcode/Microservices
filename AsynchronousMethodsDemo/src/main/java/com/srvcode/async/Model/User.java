package com.srvcode.async.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
/*
 * @JsonIgnoreProperties(ignoreUnknown=true) indicates to spring that
 * JSON response will contains properties we're not interested in &
 * it should simply ignore those.
 * 
 * Imp. points these properties in class must be matched
 * with properties coming from response.
 * 
 * Spring will use reflection to access class member variable name.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class User {

	private String name;
	private String blog;
	private String type;
	private String url;
}
