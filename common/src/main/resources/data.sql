
-- users data
-- ----------------------------------------------
-- password is admin
insert into users (email, password, name, role_type)
    values ('admin@example.com', 'GxYwsAZTqS1PiS6cE0A+nwHEv6T5S0Hrp5ec9Kfhogezy94wzO2E59KkLhD+CxS0', 'admin', 'ADMIN');

-- books data
-- ----------------------------------------------
insert into books (
    title,
    authors,
    publisher,
    published_date,
    created_at,
    updated_at
) values (
    'なんかの本1',
    '[ "著者1", "著者2", "著者3" ]',
    'どこかの出版社',
    1735052400,
    1735052400,
    1735052400
);
