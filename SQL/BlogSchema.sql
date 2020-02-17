drop database if exists blog;

create database blog;

use blog;

create table `user`(
userId int not null primary key auto_increment,
firstName varchar(25) not null,
lastName varchar(25) not null,
userName varchar(25) not null
);

create table post(
postId int not null primary key auto_increment,
userId int not null,
post varchar(5000),
postTime timestamp,
foreign key (userId) references `user`(userId)
);
