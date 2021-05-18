create database KosAlbDiscovery
use KosAlbDiscovery

create table Tourist(
tourist_id int auto_increment primary key,
name varchar(255) not null,
surname varchar(255) not null,
birthday date not null,
username varchar(255) not null,
email varchar(255) not null,
password varchar(255) not null,
role varchar(255) not null,

)