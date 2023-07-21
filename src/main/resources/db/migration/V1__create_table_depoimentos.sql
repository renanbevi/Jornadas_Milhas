CREATE TABLE depoimentos(
        id bigint not null auto_increment,
        nome varchar(100) not null,
        foto varchar(200) not null unique,
        depoimento varchar(200) not null unique,



        PRIMARY KEY(id)

);