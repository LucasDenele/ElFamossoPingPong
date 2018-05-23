create database if not exists el_famoso_bdd; 
use el_famoso_bdd; 

create table if not exists PLAYER
(
	FIRST_NAME 	VARCHAR(32),
    LAST_NAME 	VARCHAR(32),
	COUNTRY VARCHAR(32),
    POINTS INTEGER,
    GENDER VARCHAR(32),
    ENDURANCE INTEGER, 
    POWER INTEGER,
    primary key(LAST_NAME)
    
);