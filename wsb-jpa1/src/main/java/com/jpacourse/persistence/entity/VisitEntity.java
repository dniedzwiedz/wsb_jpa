package com.jpacourse.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	// relacja dwustronna po stronie dziecka
	@ManyToOne
	@JoinColumn(name = "doctor_id", nullable = false)
	private DoctorEntity doctor;

	// relacja dwustronna po stronie dziecka
	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	private PatientEntity patient;

	@OneToMany(mappedBy = "visit", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MedicalTreatmentEntity> medicalTreatments;

	public List<MedicalTreatmentEntity> getMedicalTreatments() {
		return medicalTreatments;
	}

	// public void setMedicalTreatments(List<MedicalTreatmentEntity>
	// medicalTreatments) {
	// this.medicalTreatments = medicalTreatments;
	// }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public DoctorEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

	// public Collection<MedicalTreatmentEntity> getMTreatments() {return
	// treatments;}

	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	// public DoctorEntity getDoctor() {return doctor;}
	// public void setDoctor(DoctorEntity doctor) {this.doctor = doctor;}
	// public List<MedicalTreatmentEntity> getMedicalTreatments() {return
	// medicalTreatments;}
	public void setMedicalTreatments(List<MedicalTreatmentEntity> medicalTreatments) {
		this.medicalTreatments = medicalTreatments;
	}

}
