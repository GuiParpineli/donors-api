package br.com.donor.donorsapi.domain.model;

public enum BloodType {
    A_POSITIVE("A+"),
    A_NEGATIVE("A-"),
    B_POSITIVE("B+"),
    B_NEGATIVE("B-"),
    AB_POSITIVE("AB+"),
    AB_NEGATIVE("AB-"),
    O_POSITIVE("O+"),
    O_NEGATIVE("O-");

    private final String description;

    BloodType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static BloodType of(String type) {
        for (BloodType bloodType : BloodType.values()) {
            if (bloodType.description.equals(type)) {
                return bloodType;
            }
        }
        throw new IllegalArgumentException("Tipo sanguíneo inválido: " + type);
    }
}
