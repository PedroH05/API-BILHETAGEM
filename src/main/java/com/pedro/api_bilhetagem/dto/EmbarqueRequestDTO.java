package com.pedro.api_bilhetagem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.OffsetDateTime;

public record EmbarqueRequestDTO(
        @NotBlank String idCartao,
        @PositiveOrZero Float valor,
        @PastOrPresent OffsetDateTime dataHora
) {}
