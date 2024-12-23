CREATE TABLE IF NOT EXISTS user_app (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        email VARCHAR(55) NOT NULL UNIQUE,
                                        password VARCHAR(255) NOT NULL,
                                        role VARCHAR(50) NOT NULL,
                                        username VARCHAR(55) NOT NULL
);

INSERT INTO mydatabase.user_app(id,email, password, role, username)
VALUES (1,'admin@email.com', '$2a$12$C/uEs7RtUumBBUOzAfVbVuGs7lewRIphJw7vKIPxi2wQkaFl8cpIW', 'ADMIN', 'admin')
