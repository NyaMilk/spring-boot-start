package org.example.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.json.JSONObject;

import javax.annotation.Generated;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "createat"
})
@Generated("jsonschema2pojo")
public class DatasResponse {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("createat")
    private Date date;
    @JsonProperty("data")
    private String data;

    public DatasResponse(Long id, Date date, String data) {
        this.id = id;
        this.date = date;
        this.data = data;
    }
}
