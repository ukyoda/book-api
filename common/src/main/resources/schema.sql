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
  isbn varchar(16) UNIQUE,
  description text,
  small_image_url text,
  medium_image_url text,
  large_image_url text,
  publisher varchar(128) NOT NULL,
  published_date bigint,
  created_at bigint NOT NULL,
  updated_at bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS book_authors (
  id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
  book_id bigint NOT NULL,
  name varchar(128) NOT NULL,
  INDEX idx_book_id(book_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

