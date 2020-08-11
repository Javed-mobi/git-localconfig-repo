package com.mobi.fortiva.request;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "price",
    "return_url",
    "capped_amount",
    "terms"
})
public class RecurringApplicationCharge {

    @JsonProperty("name")
    private String name;
    
    @JsonProperty("price")
    private BigDecimal price;
    
    @JsonProperty("return_url")
    private String returnUrl;
    
    @JsonProperty("capped_amount")
    private Integer cappedAmount;
    
    @JsonProperty("terms")
    private String terms;
    
    @JsonProperty("test")
    private Boolean test;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    
    public RecurringApplicationCharge(String p_name, BigDecimal p_price, String p_returnUrl, Integer p_cappedAmount, String p_terms, Boolean p_test) {
    	this.name = p_name;
    	this.price = p_price;
    	this.returnUrl = p_returnUrl;
    	this.cappedAmount = p_cappedAmount;
    	this.terms = p_terms;
    	this.test=p_test;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("price")
    public BigDecimal getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @JsonProperty("return_url")
    public String getReturnUrl() {
        return returnUrl;
    }

    @JsonProperty("return_url")
    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    @JsonProperty("capped_amount")
    public Integer getCappedAmount() {
        return cappedAmount;
    }

    @JsonProperty("capped_amount")
    public void setCappedAmount(Integer cappedAmount) {
        this.cappedAmount = cappedAmount;
    }

    @JsonProperty("terms")
    public String getTerms() {
        return terms;
    }

    @JsonProperty("terms")
    public void setTerms(String terms) {
        this.terms = terms;
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
