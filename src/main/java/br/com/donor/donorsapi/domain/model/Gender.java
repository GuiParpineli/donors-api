package br.com.donor.donorsapi.domain.model;

public enum Gender {
    MALE("Masculino"), FEMALE("Feminino");
    private final String gender;


    Gender(String gender) {
        this.gender = gender;
    }

    public static Gender of(String gender) {
        for (Gender g : Gender.values()) {
            if (g.gender.equals(gender)) return g;
        }
        throw new IllegalArgumentException("Tipo sanguíneo inválido: " + gender);
    }

    public String getGender() {
        return gender;
    }
}
