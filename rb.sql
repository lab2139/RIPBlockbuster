drop table if exists movies;
drop table if exists cust;
drop table if exists admins;

create table movies
(title	varchar(100) NOT NULL,
genre	varchar(20) NOT NULL,
lead_role	varchar(30) NOT NULL, 
director	varchar(30) NOT NULL, 
year		numeric(4) NOT NULL,
qty			INT NOT NULL,
mpaa_rating varchar(5) NOT NULL,
movie_image    varchar(10000) NOT NULL,
primary key(title)

);

create table cust
(C_ID		numeric(3),
c_first		varchar(20),
c_last		varchar(20),
phone_num char(12),
email    varchar(30),
password varchar(50),
primary key(C_ID)

);


create table admins
(A_ID		numeric(5),
a_first		varchar(20),
a_last		varchar(20),
primary key(A_ID)
);	
		






