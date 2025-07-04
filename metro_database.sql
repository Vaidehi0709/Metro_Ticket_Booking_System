create database metrosystem;

show databases;

use metrosystem;

create table account(username varchar(30), name varchar(30), password varchar(30), securityQue varchar(100), answer varchar(50))

select * from account;

create table stations(departure varchar(50), destination varchar(50), singleJourney varchar(30), returnJourney varchar(30))
 
select * from stations;

update stations set destination = 'Mangalwar Peth' where destination = 'Managalwar Peth';


