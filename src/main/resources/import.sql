
INSERT INTO areas (name) VALUES ('Team playe');
INSERT INTO areas (name) VALUES ('Technical referent');
INSERT INTO areas (name) VALUES ('Key Player');
INSERT INTO areas (name) VALUES ('Client satisfaction');
INSERT INTO areas (name) VALUES ('Motivation');
INSERT INTO areas (name) VALUES ('Fun');

INSERT INTO employes (username, password, enabled, first_name, last_name, email) VALUES ('marco','$2a$10$O.rvunSHecxX7irLv2vlz.RpMBSKEJtJeHnmy/uURk8nfFmeYGq7K',true, 'Marco', 'Yuquilima','myuquilima@yuqmettal.com');
INSERT INTO employes (username, password, enabled, first_name, last_name, email) VALUES ('admin','$2a$10$cwPHZMy1YpIZ2hKqpdgRSev2qONVi8ro.98ZAFjvyPUbeKM2ugerK',true, 'John', 'Doe','jhon.doe@bolsadeideas.com');

INSERT INTO roles (name) VALUES ('ROLE_EMPLOYEE');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

INSERT INTO employe_roles (employe_id, role_id) VALUES (1, 1);
INSERT INTO employe_roles (employe_id, role_id) VALUES (2, 2);
INSERT INTO employe_roles (employe_id, role_id) VALUES (2, 1);