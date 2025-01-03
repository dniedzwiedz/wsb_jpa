package com.jpacourse.dto;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import com.fasterxml.jackson.annotation.JsonFormat;

public class VisitTO {
    @NotNull
    @PastOrPresent(message = "Visit time must be in the past or present.")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime visitTime;

    @NotBlank(message = "Doctor name is required.")
    private String doctorName;

    private List<String> treatmentTypes; // Considered non-nullable for this example

    public LocalDateTime getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(LocalDateTime visitTime) {
        this.visitTime = visitTime;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public List<String> getTreatmentTypes() {
        return treatmentTypes != null ? Collections.unmodifiableList(treatmentTypes) : Collections.emptyList();
    }

    public void setTreatmentTypes(List<String> treatmentTypes) {
        this.treatmentTypes = treatmentTypes; // Handling immutability can be done here if needed.
    }
}