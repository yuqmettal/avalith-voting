
INSERT INTO departments (name) VALUES ('IT');
INSERT INTO departments (name) VALUES ('SALES');

INSERT INTO employes (username, password, enabled, first_name, last_name, email, department_id) VALUES ('marco','$2a$04$Bn3UVpMaH65PWb5yVqial.xFzFgcucvoR5sg4tpA/wbprGFFi7sxm',true, 'Marco', 'Yuquilima','myuquilima@yuqmettal.com', 1);
INSERT INTO employes (username, password, enabled, first_name, last_name, email, department_id) VALUES ('admin','$2a$04$t78hYPjiY2enNx0HwpSK3.aZmDUXArthOcD6a7CbogeKEFY22H7DO',true, 'John', 'Doe','jhon.doe@bolsadeideas.com', 2);

INSERT INTO roles (name) VALUES ('ROLE_EMPLOYEE');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

INSERT INTO employe_roles (employe_id, role_id) VALUES (1, 1);
INSERT INTO employe_roles (employe_id, role_id) VALUES (2, 2);
INSERT INTO employe_roles (employe_id, role_id) VALUES (2, 1);