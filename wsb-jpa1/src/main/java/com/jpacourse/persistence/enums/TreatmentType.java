package com.jpacourse.persistence.enums;

public enum TreatmentType {
    PHYSICAL("Physical Therapy"),
    CHEMICAL("Chemical Treatment"),
    PSYCHOLOGICAL("Psychological Therapy"),
    SURGICAL("Surgical Treatment"),
    PREVENTIVE("Preventive Care"),
    RADIATION("Radiation Therapy"),
    REHABILITATION("Rehabilitation"),
    CARDIOLOGICAL("Cardiological Therapy"),
    PAIN_RELIEF("Pain Relief"),
    DIETARY("Dietary Consult");

    private final String displayName;

    TreatmentType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}
