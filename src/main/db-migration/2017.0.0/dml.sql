
/* creating the CLIENT table */

CREATE TABLE client (
  id INT (10) NOT NULL AUTO_INCREMENT,
  first_name varchar (50),
  last_name varchar (50),
  email varchar (50) not null unique,
  password varchar (50),
  phone varchar (30) not null unique,
  entry_date timestamp,
  primary key (id)
);

/* creating the user table */

CREATE TABLE user (
  id INT (10) NOT NULL AUTO_INCREMENT,
  first_name varchar (50),
  last_name varchar (50),
  email varchar (50) not null unique,
  password varchar (50),
  phone varchar (30) not null unique,
  designation varchar (20),
  address varchar (100),
  created timestamp,
  primary key (id)
);
