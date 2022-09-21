show tables;

/*Cremos tabla*/
create table USERS (

id       int,
name     varchar(255),
lastname varchar(255),
username varchar(20),
pass     varchar(100),
tipDoc   char(5),
nroDoc   varchar(20),
enable   int

)

/*Añadimos id como primary key*/
alter table USERS add primary key (id);

/*Hacemos el campo id autoincrememtal y que no permita resgistros null*/
ALTER TABLE moduloseg.users MODIFY COLUMN id int auto_increment NOT NULL;

/*Insertar*/
insert into users(name,lastname,username,pass,tipDoc,nroDoc,enable)
values('Jose','Zuniga','DNI73267572', '123456','DNI','73267572',1);

insert into users(name,lastname,username,pass,tipDoc,nroDoc,enable)
values('Maria','Santillan','DNI45869274', '123456','DNI','45869274',1);


/*Actualizar*/
update users set name='Mariana' where  username='DNI45869274';


/*Eliminar*/
delete from users where username='DNI73267572';

/*Consultar*/
select * from users