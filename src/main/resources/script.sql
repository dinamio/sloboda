create database sloboda_db;

create table sloboda_db.users (
id int key not null auto_increment,
login varchar(100) not null,
password varchar(100) not null 
);

create table sloboda_db.photos (
path varchar(300) not null,
description varchar(200) not null,
position int not null
);

insert into users(login,password) values ('admin','admin');

insert into photos(path,description, position) values ('resources/img/1.jpg','�����',1);
insert into photos(path,description, position) values ('resources/img/2.jpg','����',2);
insert into photos(path,description, position) values ('resources/img/3.jpg','�������',3);
insert into photos(path,description, position) values ('resources/img/5.jpg','�������',4);

create table sloboda_db.news_photos (
id int key not null auto_increment,
path varchar(300) not null
);

create table sloboda_db.news (
id int key not null auto_increment,
title varchar(300) not null,
text_news text not null,
photo_id int,
INDEX photo_ind (photo_id),
	     FOREIGN KEY (photo_id) REFERENCES news_photos(id)
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

insert into news_photos(path) values ('resources/img/news/rogan.jpg');

insert into news(title,text_news,photo_id) values ('��� ���������� � ��������� - � 16:00 � ������� ������ � "�������"','����� ��-���� ����� ������� ��� �� 3-4 ������, ������ ��� �� �������, ��� 3-�� (�������) � 16:00 �� ������ � "�������" � 4-� ����. ���������� ���� �� 100%! ������ ���� ���� ������������ � ����� �������, ��� ��� ��� ����� � ������, �.�. ��� ������� ��� � ��������� "��-����". �������� ���������� � ������������! ps ������ � ����� ���������!',1);