CREATE TABLE IF NOT EXISTS users (
  id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
  email varchar(256) UNIQUE NOT NULL,
  password varchar(128) NOT NULL,
  name varchar(128) NOT NULL,
  role_type enum('ADMIN', 'USER') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS books (
  id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
  title varchar(128) NOT NULL,
  author varchar(64) NOT NULL,
  release_date bigint NOT NULL,
  created_at bigint NOT NULL,
  updated_at bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS reserved_books (
   id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
   book_id bigint NOT NULL,
   user_id bigint NOT NULL,
   rental_datetime bigint NOT NULL,
   expire_datetime bigint NOT NULL,
   return_datetime bigint DEFAULT NULL,
   created_at bigint NOT NULL,
   updated_at bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
