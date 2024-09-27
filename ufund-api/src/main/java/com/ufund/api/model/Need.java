package com.ufund.api.model;
import java.util.logging.Logger;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Need {

    @JsonProperty("title") private String title;
    @JsonProperty("description") private String description;
    
    public Need(@JsonProperty("title") String title){
        this.title = title;
        this.description = "";
    }

    @Override
    public String toString(){
        return title + "\n" + description;
    }
}
