package br.com.donor.donorsapi.web.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record DonorDto(
         @JsonProperty("nome") String name,
         @JsonProperty("cpf") String cpf,
         @JsonProperty("rg") String rg,
         @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
         @JsonProperty("data_nasc") LocalDate birthDate,
         @JsonProperty("sexo") String gender,
         @JsonProperty("mae") String motherName,
         @JsonProperty("pai") String fatherName,
         @JsonProperty("email") String email,
         @JsonProperty("cep") String zipCode,
         @JsonProperty("endereco") String address,
         @JsonProperty("numero") Integer number,
         @JsonProperty("bairro") String district,
         @JsonProperty("cidade") String city,
         @JsonProperty("estado") String state,
         @JsonProperty("telefone_fixo") String landline,
         @JsonProperty("celular") String mobile,
         @JsonProperty("altura") Double height,
         @JsonProperty("peso") Integer weight,
         @JsonProperty("tipo_sanguineo") String bloodType
) {
}
