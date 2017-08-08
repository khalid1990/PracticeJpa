-- starting

DROP DATABASE IF EXISTS QBank;

CREATE DATABASE IF NOT EXISTS QBank;

use QBank;

DROP TABLE IF EXISTS client_question_paper;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS question_option;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS question_paper;
DROP TABLE IF EXISTS institution;
DROP TABLE IF EXISTS user;

-- creating the user table
CREATE TABLE user (
  id          INT (10) NOT NULL AUTO_INCREMENT,
  first_name  VARCHAR(50),
  last_name   VARCHAR(50),
  email       VARCHAR(50) NOT NULL,
  password    VARCHAR(50),
  phone       VARCHAR(30) NOT NULL,
  designation VARCHAR(20),
  address     VARCHAR(100),
  created     TIMESTAMP,
  active       INT (1)

  CONSTRAINT pk_user_id PRIMARY KEY (id),

  CONSTRAINT uk_user_email UNIQUE (email),
  CONSTRAINT uk_user_phone UNIQUE (phone)
);

-- creating institution table


CREATE TABLE institution (
  id                INT(10) NOT NULL AUTO_INCREMENT,
  institution_name  VARCHAR(200) NOT NULL UNIQUE,

  status                      VARCHAR (50)       NOT NULL,
  created_by_id  INT(10),
  created                     TIMESTAMP,
  updated_by_id  INT(10),
  updated                     TIMESTAMP,
  approved_by_id INT(10),
  approve_date                TIMESTAMP,
  returned_by_id INT(10),
  return_date                 TIMESTAMP,
  deleted_by_id  INT(10),
  delete_date                 TIMESTAMP,
  return_reason               VARCHAR(200),
  delete_reason               VARCHAR(200),

  CONSTRAINT pk_institution PRIMARY KEY (id),

  CONSTRAINT fk_inst_created_by_id FOREIGN KEY (created_by_id) references user(id),
  CONSTRAINT fk_inst_updated_by_id FOREIGN KEY (updated_by_id) references user(id),
  CONSTRAINT fk_inst_approved_by_id FOREIGN KEY (approved_by_id) references user(id),
  CONSTRAINT fk_inst_returned_by_id FOREIGN KEY (returned_by_id) references user(id),
  CONSTRAINT fk_inst_deleted_by_id FOREIGN KEY (deleted_by_id) references user(id)
);

-- creating the client table

CREATE TABLE client (
  id          INT(10) NOT NULL AUTO_INCREMENT,
  first_name  VARCHAR(50),
  last_name   VARCHAR(50),
  email       VARCHAR(50) NOT NULL UNIQUE,
  password    VARCHAR(50),
  phone       VARCHAR(30) NOT NULL UNIQUE,
  entry_date  TIMESTAMP,

  CONSTRAINT pk_client PRIMARY KEY (id)
);

-- creating the question_paper table

CREATE TABLE question_paper (
  id                          INT(10) NOT NULL AUTO_INCREMENT,
  exam_title                  VARCHAR(100) NOT NULL,
  exam_serial                 INT(10),
  exam_date                   TIMESTAMP,
  institution_id  INT(10),
  lang                        VARCHAR(20),
  exam_type                   VARCHAR(20),
  exam_category VARCHAR (100),
  total_time_in_seconds       INT(10),
  total_questions             INT(10),
  marks_per_question          INT(10),
  total_marks                 INT(10),
  negative_marking_percentage DOUBLE(10, 2),
  instruction                 VARCHAR(500),

  status                      VARCHAR (50)       NOT NULL,
  created_by_id  INT(10),
  created                     TIMESTAMP,
  updated_by_id  INT(10),
  updated                     TIMESTAMP,
  approved_by_id INT(10),
  approve_date                TIMESTAMP,
  returned_by_id INT(10),
  return_date                 TIMESTAMP,
  deleted_by_id  INT(10),
  delete_date                 TIMESTAMP,
  return_reason               VARCHAR(200),
  delete_reason               VARCHAR(200),

  CONSTRAINT pk_question_paper PRIMARY KEY (id),

  CONSTRAINT fk_institution_id FOREIGN KEY (institution_id) references institution (id),

  CONSTRAINT fk_qp_created_by_id FOREIGN KEY (created_by_id) references user(id),
  CONSTRAINT fk_qp_updated_by_id FOREIGN KEY (updated_by_id) references user(id),
  CONSTRAINT fk_qp_approved_by_id FOREIGN KEY (approved_by_id) references user(id),
  CONSTRAINT fk_qp_returned_by_id FOREIGN KEY (returned_by_id) references user(id),
  CONSTRAINT fk_qp_deleted_by_id FOREIGN KEY (deleted_by_id) references user(id)
);

-- There is a uni directional ManyToMany relationship between Client and QuestionPaper,
-- where the Client side is the owner, and QuestionPaper doesn't have any reference to
-- Client. As it is a ManyToMany relationship we need a separate table for the association
-- a join table for client to question_paper ManyToMany relationship

CREATE TABLE client_question_paper (
  client_id         INT(10) NOT NULL,
  question_paper_id INT(10) NOT NULL,

  CONSTRAINT pk_client_question_paper PRIMARY KEY (client_id, question_paper_id),

  CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES client(id),
  CONSTRAINT fk_question_paper FOREIGN KEY (question_paper_id) REFERENCES question_paper(id)
);

-- creating question table

CREATE TABLE question (
  id                INT NOT NULL AUTO_INCREMENT,
  title             VARCHAR (500) NOT NULL,
  question_paper_id INT (10) NOT NULL,
  exam_sub_category VARCHAR (100) NOT NULL,
  hint              VARCHAR (500),
  serial_number     INT (10),
  total_options     INT (10),

  status            VARCHAR (50) NOT NULL,
  created_by_id     INT(10),
  created           TIMESTAMP,
  updated_by_id     INT(10),
  updated           TIMESTAMP,
  approved_by_id    INT(10),
  approve_date      TIMESTAMP,
  returned_by_id    INT(10),
  return_date       TIMESTAMP,
  deleted_by_id     INT(10),
  delete_date       TIMESTAMP,
  return_reason     VARCHAR(200),
  delete_reason     VARCHAR(200),

  CONSTRAINT pk_question PRIMARY KEY (id),

  CONSTRAINT fk_question_paper_id FOREIGN KEY (question_paper_id) REFERENCES question_paper(id),

  CONSTRAINT fk_ques_created_by_id FOREIGN KEY (created_by_id) REFERENCES user(id),
  CONSTRAINT fk_ques_updated_by_id FOREIGN KEY (updated_by_id) REFERENCES user(id),
  CONSTRAINT fk_ques_approved_by_id FOREIGN KEY (approved_by_id) REFERENCES user(id),
  CONSTRAINT fk_ques_returned_by_id FOREIGN KEY (returned_by_id) REFERENCES user(id),
  CONSTRAINT fk_ques_deleted_by_id FOREIGN KEY (deleted_by_id) REFERENCES user(id)
);

-- creating question_option table

CREATE TABLE question_option (
  id            INT (10) NOT NULL AUTO_INCREMENT,
  text          VARCHAR (500),
  serial_number INT (10),
  question_id   INT (10) NOT NULL,
  correct       INT (1),

  CONSTRAINT pk_question_option PRIMARY KEY (id),

  CONSTRAINT fk_question_id FOREIGN KEY (question_id) REFERENCES question(id)
);
