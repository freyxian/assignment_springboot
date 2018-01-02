CREATE TABLE user_tbl (
   id BIGINT NOT NULL,
   username VARCHAR(50) NOT NULL,
   password VARCHAR(256) NOT NULL,
   role VARCHAR(20) NOT NULL,
   status VARCHAR(20) NOT NULL,
  
   PRIMARY KEY (id)
);

ALTER TABLE user_tbl ADD UNIQUE (username);

ALTER TABLE user_tbl ADD CHECK (status = 'Activated' or status='Deactivated');
