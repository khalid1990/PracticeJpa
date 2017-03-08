
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

/* creating the QuestionPaper table */

CREATE TABLE question_paper {
  id int (10) NOT NULL AUTO_INCREMENT,
  exam_title varchar (100) not null,
  exam_serial int (10),
  exam_date timestamp,
  lang varchar (20),
  exam_type varchar (20),
  total_time_in_seconds int (10),
  total_questions int (10),
  marks_per_question int (10),
  total_marks int (10),
  negative_marking_percentage double (10,2),
  instruction varchar (500),

  status int (2) not null,
  created_by int (10),
  created timestamp,
  updated_by int (10),
  updated timestamp ,
  approved_by int (10),
  approved_date timestamp ,
  returned_by int (10),
  returned timestamp,
  deleted_by int (10),
  deleted timestamp,
  return_reason varchar (200),
  delete_reason varchar (200),

  primary key (id)
};

/* creating institution table */

CREATE TABLE institution {
  id int (10)  not null auto_increment,
  institutionName varchar (200) not null unique,
  primary key (id)
};


































