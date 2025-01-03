-- Insert Data into Address Table
INSERT INTO ADDRESS (id, address_line1, address_line2, city, postal_code)
VALUES
    (1, 'ul. jagodowa 21/2', 'skrytka pod schodami', 'Wroclaw', '12-345'),
    (2, 'ul. poziomkowa 22/3', 'trzecie drzwi na prawo', 'Hamburg', '11-111'),
    (3, 'ul. bananowa 23/4', NULL, 'Oswiecim', '21-370');

-- Insert Data into Patient Table
INSERT INTO PATIENT (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
VALUES
    (1, 'Dawid', 'Niedzwiedz', '+48123456789', 'dawid.niedzwiedz@dell.com', 'c123', '2000-01-01', 1),
    (2, 'Agata', 'klauza', '+48987654321', 'a.kaluza@agata.pl', 'c321', '2001-01-01', 2),
    (3, 'Sebastian', 'kotel', '+48666666666', 'seba420@test.org', 'c231', '2002-02-02', 3);

-- Insert Data into Doctor Table
INSERT INTO DOCTOR (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
VALUES
    (1, 'Tytus', 'Bomba', '+48111111111', 'tytusbomba@lekarz.com', 'l1', 'psychologist', 1),
    (2, 'Jan', 'Baran', '+48222222222', 'testowymail@lekarz.com', 'l2', 'Psychiatrist', 2),
    (3, 'Jaroslaw', 'Walentowski', '+48222222222', 'l3@lekarz.com', 'l3', 'Patologist', 3);

-- Insert Data into Medical Treatment Table
INSERT INTO MEDICAL_TREATMENT (id, description, type)
VALUES
    (1, 'Elektrody', 'PRAD'),
    (2, 'Terapia', 'THERAPY'),
    (3, 'Izolatka', 'ASYLUM');

-- Insert Data into Visit Table
INSERT INTO VISIT (id, description, time, doctor_id, patient_id)
VALUES
    (1, 'Elektrody', '2003-12-03 21:37:00', 1, 1),
    (2, 'Terapia', '2003-12-02 09:40:01', 2, 2),
    (3, 'Izolatka', '2003-12-01 06:05:05', 3, 3);

-- Insert Data into VISITS_TO_TREATMENTS Table (for Many-to-Many Relationship)
INSERT INTO VISITS_TO_TREATMENTS (visit_id, treatment_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);