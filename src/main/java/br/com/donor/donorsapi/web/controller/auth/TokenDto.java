package br.com.donor.donorsapi.web.controller.auth;

public record TokenDto(String accessToken, long expireIn) {
}
