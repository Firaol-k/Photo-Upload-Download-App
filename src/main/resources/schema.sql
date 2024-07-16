create table if not exists photoz(
    id INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY(id),
    file_name varchar(255),
    content_type varchar(255),
    data binary
);