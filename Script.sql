CREATE TABLE users (
  id int primary key AUTO_INCREMENT,
  first_name varchar(25),
  last_name varchar(25),
  username varchar(45),
  password varchar(25)
);

CREATE TABLE todos (
  id int primary key AUTO_INCREMENT,
  title varchar(25),
  description varchar(255),
  status varchar(25),
  target_date date
);
