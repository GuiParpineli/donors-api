package br.com.donor.donorsapi.web.controller.auth.dto;

public record TokenDto(String accessToken, long expireIn) {
}
