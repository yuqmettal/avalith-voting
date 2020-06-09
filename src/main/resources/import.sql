
INSERT INTO areas (name) VALUES ('Team player');
INSERT INTO areas (name) VALUES ('Technical referent');
INSERT INTO areas (name) VALUES ('Key Player');
INSERT INTO areas (name) VALUES ('Client satisfaction');
INSERT INTO areas (name) VALUES ('Motivation');
INSERT INTO areas (name) VALUES ('Fun');

INSERT INTO employes (username, password, enabled, first_name, last_name, email) VALUES ('marco','$2a$10$O.rvunSHecxX7irLv2vlz.RpMBSKEJtJeHnmy/uURk8nfFmeYGq7K',true, 'Marco', 'Yuquilima','myuquilima@yuqmettal.com');
INSERT INTO employes (username, password, enabled, first_name, last_name, email) VALUES ('admin','$2a$10$cwPHZMy1YpIZ2hKqpdgRSev2qONVi8ro.98ZAFjvyPUbeKM2ugerK',true, 'John', 'Doe','admin@yuqmettal.com');
INSERT INTO employes (username, password, enabled, first_name, last_name, email) VALUES ('hugo','$2a$10$cwPHZMy1YpIZ2hKqpdgRSev2qONVi8ro.98ZAFjvyPUbeKM2ugerK',true, 'Hugo', 'Doe','hugo@yuqmettal.com');
INSERT INTO employes (username, password, enabled, first_name, last_name, email) VALUES ('paco','$2a$10$cwPHZMy1YpIZ2hKqpdgRSev2qONVi8ro.98ZAFjvyPUbeKM2ugerK',true, 'Paco', 'Doe','paco@yuqmettal.com');
INSERT INTO employes (username, password, enabled, first_name, last_name, email) VALUES ('luis','$2a$10$cwPHZMy1YpIZ2hKqpdgRSev2qONVi8ro.98ZAFjvyPUbeKM2ugerK',true, 'Luis', 'Doe','luis@yuqmettal.com');

INSERT INTO roles (name) VALUES ('ROLE_EMPLOYEE');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

INSERT INTO employe_roles (employe_id, role_id) VALUES (1, 1);
INSERT INTO employe_roles (employe_id, role_id) VALUES (2, 2);
INSERT INTO employe_roles (employe_id, role_id) VALUES (2, 1);