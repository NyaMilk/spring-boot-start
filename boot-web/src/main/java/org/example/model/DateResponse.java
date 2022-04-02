package org.example.model;

import javax.annotation.Generated;
import java.sql.Timestamp;
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
        "createat"
})
@Generated("jsonschema2pojo")
public class DateResponse {
    @JsonProperty("name")
    private String name;
    @JsonProperty("createat")
    private Timestamp createat;
    @JsonProperty("xml")
    private Object xml;

    public DateResponse(String name, Timestamp createat, Object xml) {
        this.name = name;
        this.createat = createat;
        this.xml = xml;
    }
}
