create database sloboda_db character set utf8 collate utf8_unicode_ci;

CREATE TABLE sloboda_db.positions(
id INT NOT NULL AUTO_INCREMENT,
position VARCHAR(40) NOT NULL,
 PRIMARY KEY (id)
);

create table sloboda_db.photos (
id int key not null auto_increment,
path varchar(300) not null
);

create table sloboda_db.video (
id int not null auto_increment,
link varchar(300),
primary key(id)
);

CREATE TABLE sloboda_db.players(
   id INT NOT NULL AUTO_INCREMENT,
   number INT(100),
   surname VARCHAR(40) NOT NULL,
   name VARCHAR(40) NOT NULL,
   birthday_date DATE,
   is_rightleg bool not null,
   is_display bool not null,
   position_id INT(40) NOT NULL,
   photo_id INT(40),
   video_id int,
   FOREIGN KEY (position_id) references positions(id),
   FOREIGN KEY (photo_id) references photos(id),
   FOREIGN KEY (video_id) references video(id),
   
   PRIMARY KEY (id)
   
);

CREATE TABLE sloboda_db.tournaments_type(
	id INT NOT NULL AUTO_INCREMENT,
    tournament_type VARCHAR(40),
    PRIMARY KEY (id)

);

create table sloboda_db.users (
id int key not null auto_increment,
login varchar(100) not null,
password varchar(100) not null,
email varchar(100) not null,
name varchar(100)  not null,
surname varchar(100) not null,
avatar_id int,
is_administrator bool,
FOREIGN KEY (avatar_id) REFERENCES photos(id)
ON DELETE SET NULL
);

create table sloboda_db.main_photos (
photo_id int,
description varchar(100) not null,
FOREIGN KEY (photo_id) REFERENCES photos(id)
ON DELETE SET NULL
);

create table sloboda_db.news (
id int key not null auto_increment,
title varchar(300) not null,
text_news text not null,
author_id int,
photo_id int,
created_date datetime,
FOREIGN KEY (photo_id) REFERENCES photos(id)
ON DELETE SET NULL,
FOREIGN KEY (author_id) REFERENCES users(id)
ON DELETE SET NULL
);

create table sloboda_db.comments (
id int key not null auto_increment,
text_comment text not null,
created_date datetime,
news_id int,
user_id int,
FOREIGN KEY (news_id) REFERENCES news(id)
	     ON DELETE SET NULL,
FOREIGN KEY (user_id) REFERENCES users(id)
	     ON DELETE SET NULL         
);

create table sloboda_db.tournaments(
id INT NOT NULL AUTO_INCREMENT,
   title VARCHAR(100),
   type_id int(40) NOT NULL,
  start_date DATE not null,
  end_date DATE not null,
   place VARCHAR(100), 
   description VARCHAR(500),
   photo_id int(40),
   is_print_table bool not null,
   FOREIGN KEY (type_id) references tournaments_type(id),
   FOREIGN KEY (photo_id) references photos(id)
   ON DELETE SET NULL,
   
   PRIMARY KEY (id)
);

create table sloboda_db.team(
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(40) NOT NULL,
type_id int(40) NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (type_id) references tournaments_type(id)

);
CREATE TABLE sloboda_db.team_tournament(
team_id int not null,
tournament_id int not null,
foreign key (team_id) references team(id),
foreign key (tournament_id) references tournaments(id)

);

create table sloboda_db.game(
id int not null auto_increment,
tournament_id int not null,
first_team_id int not null,
second_team_id int not null,
goals_first int not null,
goals_second int not null,
game_date date not null,
tour_number int not null,
foreign key(tournament_id) references tournaments(id),
foreign key(first_team_id) references team(id),
foreign key(second_team_id) references team(id),
primary key(id)
);

create table sloboda_db.player_game(
player_id int not null,
game_id int not null,
goals_in_game int,
goals_missed int,
foreign key (player_id) references players(id),
foreign key (game_id) references game(id)
);
create table sloboda_db.tournament_application(
player_id int not null,
tournament_id int not null,
foreign key (player_id) references players(id),
foreign key (tournament_id) references tournaments(id)
);
create table sloboda_db.rewards(
id int not null auto_increment,
player_id int not null, 
tournament_id int not null,
reward varchar(100) not null,
foreign key (player_id) references players(id),
foreign key (tournament_id) references tournaments(id),
primary key(id)
);

create table sloboda_db.game_content_photo(
game_id int not null,
photo_id int not null,
foreign key (game_id) references game(id),
foreign key (photo_id) references photos(id)
);

create table sloboda_db.game_content_video(
game_id int not null,
video_id int not null,
foreign key (game_id) references game(id),
foreign key (video_id) references video(id)
);

create table sloboda_db.tournament_table(
tournament_id int not null,
team_name varchar (100) not null,
place int not null,
games int not null,
wins int not null,
draws int not null,
loses int not null,
goals_scored int null,
goals_missed int not null,
points int not null,
foreign key (tournament_id) references tournaments(id)
);
