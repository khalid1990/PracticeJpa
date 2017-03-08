/* creating the CLIENT table */

CREATE TABLE client (
  id        INT(10)     NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  email     VARCHAR(50) NOT NULL UNIQUE,
  password  VARCHAR(50),
  phone     VARCHAR(30) NOT NULL UNIQUE,
  entry_date TIMESTAMP,

  PRIMARY KEY (id)
);

/* a join table for client to question_paper oneToMany relationship */

CREATE TABLE client_question_paper (
  client_id         INT(10) NOT NULL,
  question_paper_id INT(10) NOT NULL UNIQUE
);

/* creating the user table */

CREATE TABLE user (
  id         INT(10)     NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(50),
  last_name  VARCHAR(50),
  email      VARCHAR(50) NOT NULL UNIQUE,
  password   VARCHAR(50),
  phone      VARCHAR(30) NOT NULL UNIQUE,
  designation VARCHAR(20),
  address    VARCHAR(100),
  created    TIMESTAMP,

  PRIMARY KEY (id)
);

/* creating the QuestionPaper table */

CREATE TABLE question_paper (
  id                          INT(10)      NOT NULL AUTO_INCREMENT,
  exam_title                  VARCHAR(100) NOT NULL,
  exam_serial                 INT(10),
  exam_date                   TIMESTAMP,
  institution_id  INT(10),
  lang                        VARCHAR(20),
  exam_type                   VARCHAR(20),
  total_time_in_seconds       INT(10),
  total_questions             INT(10),
  marks_per_question          INT(10),
  total_marks                 INT(10),
  negative_marking_percentage DOUBLE(10, 2),
  instruction                 VARCHAR(500),

  status                      INT(2)       NOT NULL,
  created_by_id  INT(10),
  created                     TIMESTAMP,
  updated_by_id  INT(10),
  updated                     TIMESTAMP,
  approved_by_id INT(10),
  approve_date                TIMESTAMP,
  returned_by_id INT(10),
  return_date                    TIMESTAMP,
  deleted_by_id  INT(10),
  delete_date                     TIMESTAMP,
  return_reason               VARCHAR(200),
  delete_reason               VARCHAR(200),

  PRIMARY KEY (id),
  CONSTRAINT FOREIGN KEY (fk_created_by_id_user_id) references user(id),
  CONSTRAINT FOREIGN KEY (fk_updated_by_id_user_id) references user(id),
  CONSTRAINT FOREIGN KEY (fk_approved_by_id_user_id) references user(id),
  CONSTRAINT FOREIGN KEY (fk_returned_by_id_user_id) references user(id),
  CONSTRAINT FOREIGN KEY (fk_deleted_by_id_user_id) references user(id)

);

/* creating institution table */

CREATE TABLE institution (
  id INT(10) NOT NULL AUTO_INCREMENT,
  institutionName VARCHAR(200) NOT NULL UNIQUE,
  PRIMARY KEY (id)
);


































