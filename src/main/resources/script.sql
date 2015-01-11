create database sloboda_db;

create table sloboda_db.photos (
id int key not null auto_increment,
path varchar(300) not null
);

create table sloboda_db.users (
id int key not null auto_increment,
login varchar(100) not null,
password varchar(100) not null,
email varchar(100) not null,
name varchar(100)  not null,
surname varchar(100) not null,
avatar_id int,
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


insert into sloboda_db.photos(path) values ('resources/img/1.jpg');
insert into sloboda_db.photos(path) values ('resources/img/2.jpg');
insert into sloboda_db.photos(path) values ('resources/img/3.jpg');
insert into sloboda_db.photos(path) values ('resources/img/5.jpg');
insert into sloboda_db.photos(path) values ('resources/images/gravatar.jpg');
insert into sloboda_db.photos(path) values ('resources/img/news/rogan.jpg');

insert into sloboda_db.main_photos(photo_id,description) values (1,'�����');
insert into sloboda_db.main_photos(photo_id,description) values (2,'����');
insert into sloboda_db.main_photos(photo_id,description) values (3,'�������');
insert into sloboda_db.main_photos(photo_id,description) values (4,'�������');

insert into sloboda_db.users(login,password,name,surname,email,avatar_id) values ('admin','admin','�������','�����','dinamio@ukr.net',5);

insert into sloboda_db.news(title,text_news,photo_id,author_id,created_date) values ('��� ���������� � ��������� - � 16:00 � ������� ������ � "�������"','����� ��-���� ����� ������� ��� �� 3-4 ������, ������ ��� �� �������, ��� 3-�� (�������) � 16:00 �� ������ � "�������" � 4-� ����. ���������� ���� �� 100%! ������ ���� ���� ������������ � ����� �������, ��� ��� ��� ����� � ������, �.�. ��� ������� ��� � ��������� "��-����". �������� ���������� � ������������! ps ������ � ����� ���������!',6,1,'2015-10-01');
insert into sloboda_db.news(title,text_news,photo_id,author_id,created_date) values ('������� 2','����� ��-���� ����� ������� ��� �� 3-4 ������, ������ ��� �� �������, ��� 3-�� (�������) � 16:00 �� ������ � "�������" � 4-� ����. ���������� ���� �� 100%! ������ ���� ���� ������������ � ����� �������, ��� ��� ��� ����� � ������, �.�. ��� ������� ��� � ��������� "��-����". �������� ���������� � ������������! ps ������ � ����� ���������!',2,1,'2015-09-01');
insert into sloboda_db.news(title,text_news,photo_id,author_id,created_date) values ('������ �������','����� � 17:00 ������� ��� ������ �������� "�������" �������� ������ � ����� ������� ������ ����� �������! 8-� ����, ������� ��������� ����� ��������� ���������� � ���� ��� ������� ��������, ��-���� ���������� ����������! 

"�������": ��������� - ��������, �����, �������, ������� - ������, �����������, ��������, ���������� - �������� 

� ��������� ��� �� ����� � � ������ ��� �� ��������� ����� ��� �������� ������ � "���������". ��� ������� ����������� ������� ���� �����, � �������� ������ ���� �������� � ��������� ����� � �������� �� ���������� �������. ��� ����������� ���� � ���� � ������, �� �� ����� ������ ���� �����. �������� ������� ����� �������� � ���������� - ����� ����������������. �� �������� ����� ������ ���� ������� ����� ������ �� ���������� ������� - �� ������ ������� �����, ������ ������ �������, ���� ���� ��������� � 6 ������ ��.. 

�� ������ �������� ������� ����������� �������� � ������ ��������� �������. ���� ���� ���������� ����, ����� ��� ��������� � �� ������ ������� - ��������. � ��� ���������� � ����� ���������� ���������� ��� - ������ ��� ����� ����� ���������� 13-� ����� "��������", ������� ������ � ��������� ������ � ������ ���� - 0:1. ���������, ������, ���� - �� �� ��������, � ������� �� "�������" ������ ������ �����. �������� ��������� � ������ ������ ������, ������� �� 6-�� ������ ������� �������� ��������� � ������ ����, �������� ������ �� ����, ����� ���� � �����.. ���-�� �� 8 ����� �� ����� ����� �������������� ��� ����� �����, �� ����� ������� ��������� � ������ � ������� ������� - 1:1. ������� ����� ����������� ����������, � �������� ��������� �� ��������� ������. �� 40 ������ �� ������ "�������" ����� ������ �� ����� �������, �� ����������� ��� ��������. �������� ����� 20 ������ � "�������" ���� � ���� �����, ����� ��������� ��� ������ � �������, ��������������� � ��������� ���������, ��������� ��� � ������ ���� - 2:1 � 10 ������ �� �������. ��������� ���� �� ����� ��������� � ������. 

������� ������, ������� ���������� ��������! ������� ������� ����, ��� ����� ������ - ������, ������������ - ������� �� ��������� ���� � �� ���� ������! ���-�� ���� ��� � ���� ������, � �� �� ���������! ��� ������������!',3,1,'2015-08-01');