package com.cleansolution.general.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import java.io.Serializable;



public class CitiesDTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CitiesDTO.class);
    
    private Integer cityId;
    private String name;
    private String abbreviation;
    private Integer stateId;

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

}
