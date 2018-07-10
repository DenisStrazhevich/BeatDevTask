CREATE TABLE IF NOT EXISTS users (
  id INT AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(50) NOT NULL ,
  surname VARCHAR(50) NOT NULL ,
  age DOUBLE NOT NULL ,
  email VARCHAR(100) NOT NULL ,
  status VARCHAR(50) NOT NULL
);

INSERT INTO users VALUES (1, 'Denis', 'Strazhevich', 20, 'denisstrazhevich@gmail.com', 'offline')