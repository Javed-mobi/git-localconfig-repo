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
    "recurring_application_charge"
})
public class RecurringApplicationChargeRequest {

    @JsonProperty("recurring_application_charge")
    private RecurringApplicationCharge recurringApplicationCharge;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    public RecurringApplicationChargeRequest(String name, BigDecimal price, String returnUrl, Integer cappedAmount, String terms, Boolean p_test) {
    	
    	this.setRecurringApplicationCharge(new RecurringApplicationCharge(name, price, returnUrl, cappedAmount, terms, p_test));
        
    }

    @JsonProperty("recurring_application_charge")
    public RecurringApplicationCharge getRecurringApplicationCharge() {
        return recurringApplicationCharge;
    }

    @JsonProperty("recurring_application_charge")
    public void setRecurringApplicationCharge(RecurringApplicationCharge recurringApplicationCharge) {
        this.recurringApplicationCharge = recurringApplicationCharge;
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
