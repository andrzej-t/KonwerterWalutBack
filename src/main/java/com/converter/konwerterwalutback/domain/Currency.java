package com.converter.konwerterwalutback.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class Currency {

    @JsonProperty("table")
    String table;
    @JsonProperty("no")
    String no;
    @JsonProperty("effectiveDate")
    LocalDate effectiveDate;
    @JsonProperty("rates")
    List<Rates> rates;
}
