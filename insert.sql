USE btl;
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fullname VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    username VARCHAR(100) NOT NULL
);

INSERT INTO users (id, fullname, password,username)
VALUES (1, 'admin', 'admin','admin');
INSERT INTO users (id, fullname, password,username)
VALUES (2, 'nguoidung', 'nguoidung','nguoidung');