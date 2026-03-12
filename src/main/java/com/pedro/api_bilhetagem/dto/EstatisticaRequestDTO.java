package com.pedro.api_bilhetagem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EstatisticaRequestDTO (
        @JsonProperty("count") long count,
        @JsonProperty("sum") double sum,
        @JsonProperty("avg") double avg,
        @JsonProperty("min") double min,
        @JsonProperty("max") double max
){}
