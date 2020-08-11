package com.mobi.fortiva.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mobi.fortiva.constant.ApplicationConstant;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "webhook"
})
public class FortivaWebhookConfigureRequest {
	
	public FortivaWebhookConfigureRequest(String p_topic, String p_address) {
		
		this.setWebhook(new Webhook(p_topic, p_address, ApplicationConstant.API_DATA_FORMAT_JSON));
	}

    @JsonProperty("webhook")
    private Webhook webhook;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("webhook")
    public Webhook getWebhook() {
        return webhook;
    }

    @JsonProperty("webhook")
    public void setWebhook(Webhook webhook) {
        this.webhook = webhook;
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
