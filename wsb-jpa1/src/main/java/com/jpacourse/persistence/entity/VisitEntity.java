package com.jpacourse.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import java.util.Collection;


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
	private DoctorEntity doctor;

	// relacja dwustronna po stronie dziecka
	@ManyToOne
	private PatientEntity patient;

	// relacja jednostronna
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "VISITS_TO_TREATMENTS",
			joinColumns = @JoinColumn(name = "VISIT_ID"),
			inverseJoinColumns = @JoinColumn(name = "TREATMENT_ID"))
	private Collection<MedicalTreatmentEntity> treatments;


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

	public Collection<MedicalTreatmentEntity> getTreatments() {
		return treatments;
	}
	public void setTreatments(Collection<MedicalTreatmentEntity> treatments) {
		this.treatments = treatments;
	}
	public PatientEntity getPatient() {
		return patient;
	}
	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

}
