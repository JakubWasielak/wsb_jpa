insert into address (id, address_line1, address_line2, city, postal_code)
            values (1, 'xx', 'yy', 'city', '62-030');

-- ADDRESS --
INSERT INTO ADDRESS (city, address_line1, address_line2, postal_code)
VALUES ('New York', '123 Main Street', 'Apt 1', '10001');
INSERT INTO ADDRESS (city, address_line1, address_line2, postal_code)
VALUES ('Los Angeles', '456 Elm Street', 'Unit 2', '90001');
INSERT INTO ADDRESS (city, address_line1, address_line2, postal_code)
VALUES ('Chicago', '789 Oak Street', 'Suite 100', '60601');
INSERT INTO ADDRESS (city, address_line1, address_line2, postal_code)
VALUES ('Houston', '321 Maple Street', 'Apt B', '77002');
INSERT INTO ADDRESS (city, address_line1, address_line2, postal_code)
VALUES ('Miami', '654 Pine Street', 'Unit C', '33101');
INSERT INTO ADDRESS (city, address_line1, address_line2, postal_code)
VALUES ('San Francisco', '987 Walnut Street', 'Apt 3', '94102');
INSERT INTO ADDRESS (city, address_line1, address_line2, postal_code)
VALUES ('Boston', '741 Cedar Street', 'Suite 50', '02101');
INSERT INTO ADDRESS (city, address_line1, address_line2, postal_code)
VALUES ('Dallas', '369 Birch Street', 'Apt X', '75201');
INSERT INTO ADDRESS (city, address_line1, address_line2, postal_code)
VALUES ('Seattle', '852 Oak Street', 'Apt F', '98101');
INSERT INTO ADDRESS (city, address_line1, address_line2, postal_code)
VALUES ('Atlanta', '147 Maple Street', 'Apt A', '30301');


-- PATIENT --
INSERT INTO PATIENT (first_name, last_name, telephone_number, email, patient_number, date_of_birth, has_insurance, address_id)
VALUES ('John', 'Doe', '+1234567890', 'john.doe@example.com', 'P001', '1990-05-15', 'true', 2);
INSERT INTO PATIENT (first_name, last_name, telephone_number, email, patient_number, date_of_birth, has_insurance, address_id)
VALUES ('Jane', 'Smith', '+1987654321', 'jane.smith@example.com', 'P002', '1985-10-20', 'true', 3);
INSERT INTO PATIENT (first_name, last_name, telephone_number, email, patient_number, date_of_birth, has_insurance, address_id)
VALUES ('Michael', 'Johnson', '+1122334455', 'michael.johnson@example.com', 'P003', '1978-03-25', 'true', 4);
INSERT INTO PATIENT (first_name, last_name, telephone_number, email, patient_number, date_of_birth, has_insurance, address_id)
VALUES ('Emily', 'Williams', '+1555666777', 'emily.williams@example.com', 'P004', '1995-12-10', 'false', 5);
INSERT INTO PATIENT (first_name, last_name, telephone_number, email, patient_number, date_of_birth, has_insurance, address_id)
VALUES ('David', 'Brown', '+1444333222', 'david.brown@example.com', 'P005', '1980-08-05', 'false', 6);

-- DOCTOR --
INSERT INTO DOCTOR (first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
VALUES ('John', 'Doe', '+1234567890', 'john.doe@example.com', 'D001', 'SURGEON', 7);
INSERT INTO DOCTOR (first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
VALUES ('Jane', 'Smith', '+1987654321', 'jane.smith@example.com', 'D002', 'GP', 8);
INSERT INTO DOCTOR (first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
VALUES ('Michael', 'Johnson', '+1122334455', 'michael.johnson@example.com', 'D003', 'DERMATOLOGIST', 9);
INSERT INTO DOCTOR (first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
VALUES ('Emily', 'Williams', '+1555666777', 'emily.williams@example.com', 'D004', 'OCULIST', 10);
INSERT INTO DOCTOR (first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
VALUES ('David', 'Brown', '+1444333222', 'david.brown@example.com', 'D005', 'SURGEON', 11);

-- VISIT --
INSERT INTO VISIT (description, time, patient_id, doctor_id)
VALUES ('Check-up', '2024-04-15 10:00:00', 1, 1);
INSERT INTO VISIT (description, time, patient_id, doctor_id)
VALUES ('Dental Cleaning', '2024-04-20 14:30:00', 2, 2);
INSERT INTO VISIT (description, time, patient_id, doctor_id)
VALUES ('Dermatology Consultation', '2024-04-25 11:15:00', 3, 3);
INSERT INTO VISIT (description, time, patient_id, doctor_id)
VALUES ('Eye Exam', '2024-05-02 09:45:00', 4, 4);
INSERT INTO VISIT (description, time, patient_id, doctor_id)
VALUES ('Surgery Consultation', '2024-05-10 08:00:00', 5, 5);
INSERT INTO VISIT (description, time, patient_id, doctor_id)
VALUES ('Surgery', '2024-04-20 12:00:00', 1, 1);

-- MEDICAL_TREATMENT --
INSERT INTO MEDICAL_TREATMENT (description, type, visit_id)
VALUES ('Ultrasound scan', 'USG', 1);
INSERT INTO MEDICAL_TREATMENT (description, type, visit_id)
VALUES ('Electrocardiogram', 'EKG', 2);
INSERT INTO MEDICAL_TREATMENT (description, type, visit_id)
VALUES ('X-ray', 'RTG', 3);
INSERT INTO MEDICAL_TREATMENT (description, type, visit_id)
VALUES ('Ultrasound scan', 'USG', 4);
INSERT INTO MEDICAL_TREATMENT (description, type, visit_id)
VALUES ('X-ray', 'RTG', 5);
