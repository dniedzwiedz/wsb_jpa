package com.jpacourse.persistence.entity;

import java.time.LocalDate;

import javax.persistence.*;

<<<<<<< HEAD
import java.util.Collection;

=======
import java.util.List;
>>>>>>> 2612bab58510d8f72bb0ae2913228c35e65ae561

@Entity
@Table(name = "patients")
public class PatientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String telephoneNumber;

	private String email;

	@Column(nullable = false)
	private String patientNumber;

	@Column(nullable = false)
	private LocalDate dateOfBirth;

<<<<<<< HEAD
	// relacja dwustronna po stronie rodzica
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	private Collection<VisitEntity> visits;

	// relacja dwustronna po stronie rodzica
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
=======
	private Boolean diabetes; // New field

	// relacja dwustronna po stronie rodzica
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	private List<VisitEntity> visits;

	// relacja dwustronna po stronie rodzica
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
>>>>>>> 2612bab58510d8f72bb0ae2913228c35e65ae561
	private AddressEntity address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(String patientNumber) {
		this.patientNumber = patientNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

<<<<<<< HEAD
=======
	public Boolean getDiabetes() {
		return diabetes;
	}

	public void setDiabetes(Boolean diabetes) {
		this.diabetes = diabetes;
	}

>>>>>>> 2612bab58510d8f72bb0ae2913228c35e65ae561
	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

<<<<<<< HEAD
	public Collection<VisitEntity> getVisits() {
		return visits;
	}
	public void setVisits(Collection<VisitEntity> visits) {
=======
	public List<VisitEntity> getVisits() {
		return visits;
	}

	public void setVisits(List<VisitEntity> visits) {
>>>>>>> 2612bab58510d8f72bb0ae2913228c35e65ae561
		this.visits = visits;
	}

}
