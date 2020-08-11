package com.mobi.fortiva.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "topic", "address", "format" })
public class Webhook {
	
	public Webhook(String p_topic, String p_address, String p_format) {
		this.topic = p_topic;
		this.address = p_address;
		this.format = p_format;
	}

	@JsonProperty("topic")
	private String topic;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("format")
	private String format;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("topic")
	public String getTopic() {
		return topic;
	}

	@JsonProperty("topic")
	public void setTopic(String topic) {
		this.topic = topic;
	}

	@JsonProperty("address")
	public String getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(String address) {
		this.address = address;
	}

	@JsonProperty("format")
	public String getFormat() {
		return format;
	}

	@JsonProperty("format")
	public void setFormat(String format) {
		this.format = format;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}