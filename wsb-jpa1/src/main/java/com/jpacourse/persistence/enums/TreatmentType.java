package com.jpacourse.persistence.enums;

public enum TreatmentType {
    PHYSICAL("Physical Therapy"),
    CHEMICAL("Chemical Treatment"),
    PSYCHOLOGICAL("Psychological Therapy");

    private final String displayName;

    TreatmentType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}
