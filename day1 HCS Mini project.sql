create database miniprojecttwo;
use miniprojecttwo;

-------------------------------------------------------------------------------------------------------- 
 -- Roles table  
create table roles (role_id int not null auto_increment , role_name varchar(255), primary key (role_id));
insert into roles (role_name) values ('Admin');
insert into roles (role_name) values ('Doctor');
insert into roles (role_name) values ('Patient');
insert into roles (role_name) values ('Nurse');
insert into roles (role_name) values('Receptionist');
select * from roles;

--------------------------------------------------------------------------------------------------------
-- Users table
create table users ( 
user_id bigint not null auto_increment, role_id int not null, firstname varchar(255) not null, 
lastname varchar(255) not null, email varchar(255) not null, mobile bigint not null,
password varchar(255) not null, active int not null,  profile_url varchar(255),
city varchar(100), primary key (user_id) );
select * from users;


insert into users 
(role_id, firstname, lastname, email, mobile, password, active, profile_url,city)
values(2, 'Chaitanya', 'Deshmukh', 'chaitanya@cybage.com', 789654123, 'pass@321', 1, null, 'Nagpur');

insert into users 
(role_id, firstname, lastname, email, mobile, password, active, profile_url,city)
values(3, 'Swaraj', 'Motiwale', 'swaraj@cybage.com', 789654123, 'pass@321', 1, null, 'Pune');

insert into users 
(role_id, firstname, lastname, email, mobile, password, active, profile_url,city)
values(2, 'Sunidhi', 'Bhandhari', 'sunidhi@cybage.com', 789654123, 'pass@321', 1, null, 'Nagpur');

insert into users 
(role_id, firstname, lastname, email, mobile, password, active, profile_url,city)
values(3, 'Stuti', 'Shahu', 'stuti@cybage.com', 789654123, 'pass@321', 1, null, 'Nagpur');

insert into users 
(role_id, firstname, lastname, email, mobile, password, active, profile_url,city)
values(1, 'Ray', 'Holt', 'ray@cybage.com', 1234561234, 'admin@123', 1, null, 'Brooklyn');

insert into users 
(role_id, firstname, lastname, email, mobile, password, active, profile_url,city)
values(1, 'Barney', 'Stinson', 'barney@cybage.com', 1234569877, 'admin2@123', 1, null, 'Mumbai');

insert into users 
(role_id, firstname, lastname, email, mobile, password, active, profile_url,city)
values(3, 'Amy', 'Santiago', 'amy@cybage.com', 123457, 'amy@123', 1, null, 'Brooklyn');


--------------------------------------------------------------------------------------------------------
-- Appointments table
create table appointments (
appointment_id bigint not null auto_increment, patient_id bigint not null, doctor_id bigint not null,
appointment_date date not null, appointment_time time not null, appointments_status varchar(255) not null,
feedback mediumtext, ratings int, patient_notes mediumtext, primary key (appointment_id) );
select * from appointments;

insert into appointments(patient_id, doctor_id, appointment_date, appointment_time,appointments_status,
feedback , ratings, patient_notes) values(2, 1, '2022-11-15', '12:00:00', 'Pending', 'Some feedback here', '4', 'patients notes here' );

insert into appointments(patient_id, doctor_id, appointment_date, appointment_time,appointments_status,
feedback , ratings, patient_notes) values(2, 3, '2022-11-15', '13:00:00', 'Pending', 'Some feedback here', '4', 'patients notes here' );

insert into appointments(patient_id, doctor_id, appointment_date, appointment_time,appointments_status,
feedback , ratings, patient_notes) values(3, 1, '2022-11-15', '14:00:00', 'Pending', 'Some feedback here', '4', 'patients notes here' );

insert into appointments(patient_id, doctor_id, appointment_date, appointment_time,appointments_status,
feedback , ratings, patient_notes) values(2, 3, '2022-11-16', '12:00:00', 'Pending', 'Some feedback here', '4', 'patients notes here' );

--------------------------------------------------------------------------------------------------------
-- Specialization table
create table specialization (specialization_id bigint not null auto_increment, category text not null, 
primary key(specialization_id) );
select * from specialization;
insert into specialization (category) values ('Cardiologist');
insert into specialization (category) values ('General Pediatrician');
insert into specialization (category) values ('Physician');
insert into specialization (category) values ('Dermatologists');
insert into specialization (category) values ('Ophthalmologists');
insert into specialization (category) values ('Neurologists');
insert into specialization (category) values ('Radiologists');
insert into specialization (category) values ('General Surgeons');
insert into specialization (category) values ('Oncologists');
insert into specialization (category) values ('Allergists');

--------------------------------------------------------------------------------------------------------
-- Doctor's Specialization table
create table doctors_specialization (doctors_specialization_id bigint not null auto_increment, 
specialization_id bigint not null, doctor_id bigint not null, primary key(doctors_specialization_id));
select * from doctors_specialization;
insert into doctors_specialization(specialization_id, doctor_id)values(3, 1);
insert into doctors_specialization(specialization_id, doctor_id)values(1, 1);
insert into doctors_specialization(specialization_id, doctor_id)values(6, 4);
insert into doctors_specialization(specialization_id, doctor_id)values(6, 3);
insert into doctors_specialization(specialization_id, doctor_id)values(9, 4);
insert into doctors_specialization(specialization_id, doctor_id)values(1, 3);
insert into doctors_specialization(specialization_id, doctor_id)values(8, 3);
insert into doctors_specialization(specialization_id, doctor_id)values(7, 1);


-- --------**********----------***********--------**********----------***********--------**********----------***********--------**********
-- ------------------------------------------------------------------------------------------------------------------------------------- -- 
   -- Queries--  
select user_id, firstname, lastname, email, mobile, role_name,  password, active, profile_url,city from users u inner join roles r on u.role_id = r.role_id;

select category from specialization s inner join doctors_specialization ds on s.specialization_id = ds.specialization_id where ds.doctor_id = 18;

select * from users where users.user_id in (
select doctor_id from doctors_specialization ds inner join
specialization s on ds.specialization_id = s.specialization_id where s.category = "Cardiologist");

-- --------------------------------------------Find Appointments of a doctor----------------------------------------------   
select  appointment_id, user_id,  patient_id, firstname as patients_firstname, lastname as patients_lastname,
email, doctor_id, 
(select firstname from users where users.user_id = appointments.doctor_id) as doctors_firstname,
(select lastname from users where users.user_id = appointments.doctor_id) as doctors_lastname,
(select email from users where users.user_id = appointments.doctor_id) as doctors_email,
appointment_date, appointment_time,appointments_status,
feedback , ratings, patient_notes from users inner join appointments on appointments.doctor_id = users.user_id where users.user_id = 19;


--   --------------------------------------------Find Appointments of a patient ----------------------------------------------   
select  appointment_id, user_id,  patient_id, firstname as patients_firstname, lastname as patients_lastname,
email, doctor_id, 
(select firstname from users where users.user_id = appointments.doctor_id) as doctors_firstname,
(select lastname from users where users.user_id = appointments.doctor_id) as doctors_lastname,
(select email from users where users.user_id = appointments.doctor_id) as doctors_email,
appointment_date, appointment_time,appointments_status,
feedback , ratings, patient_notes from users inner join appointments on appointments.patient_id = users.user_id where appointments.doctor_id = 1;

-- --------------------Find all detailed appointments of all doctors and patients-------------------------------------------- -- 
select  appointment_id, user_id,  patient_id, firstname as patients_firstname, lastname as patients_lastname,
email, doctor_id, 
(select firstname from users where users.user_id = appointments.doctor_id) as doctors_firstname,
(select lastname from users where users.user_id = appointments.doctor_id) as doctors_lastname,
(select email from users where users.user_id = appointments.doctor_id) as doctors_email,
appointment_date, appointment_time,appointments_status,
feedback , ratings, patient_notes from users inner join appointments on appointments.patient_id = users.user_id;

-- ------------------------------------------- Update Appointment Status ------------------------------------------- -- 
update appointments set appointments_status = 'Approve' where appointment_id = 1;
select * from users;

select * from users;
select * from roles;
select * from doctors_specialization;


















