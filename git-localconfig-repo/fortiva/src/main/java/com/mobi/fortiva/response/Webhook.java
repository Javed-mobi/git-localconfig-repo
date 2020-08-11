package com.mobi.fortiva.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "address",
    "topic",
    "created_at",
    "updated_at",
    "format",
    "fields",
    "metafield_namespaces",
    "api_version",
    "private_metafield_namespaces"
})
public class Webhook {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("address")
    private String address;
    @JsonProperty("topic")
    private String topic;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("format")
    private String format;
    @JsonProperty("fields")
    private List<Object> fields = null;
    @JsonProperty("metafield_namespaces")
    private List<Object> metafieldNamespaces = null;
    @JsonProperty("api_version")
    private String apiVersion;
    @JsonProperty("private_metafield_namespaces")
    private List<Object> privateMetafieldNamespaces = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("topic")
    public String getTopic() {
        return topic;
    }

    @JsonProperty("topic")
    public void setTopic(String topic) {
        this.topic = topic;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    @JsonProperty("fields")
    public List<Object> getFields() {
        return fields;
    }

    @JsonProperty("fields")
    public void setFields(List<Object> fields) {
        this.fields = fields;
    }

    @JsonProperty("metafield_namespaces")
    public List<Object> getMetafieldNamespaces() {
        return metafieldNamespaces;
    }

    @JsonProperty("metafield_namespaces")
    public void setMetafieldNamespaces(List<Object> metafieldNamespaces) {
        this.metafieldNamespaces = metafieldNamespaces;
    }

    @JsonProperty("api_version")
    public String getApiVersion() {
        return apiVersion;
    }

    @JsonProperty("api_version")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("private_metafield_namespaces")
    public List<Object> getPrivateMetafieldNamespaces() {
        return privateMetafieldNamespaces;
    }

    @JsonProperty("private_metafield_namespaces")
    public void setPrivateMetafieldNamespaces(List<Object> privateMetafieldNamespaces) {
        this.privateMetafieldNamespaces = privateMetafieldNamespaces;
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
