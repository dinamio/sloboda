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

insert into sloboda_db.main_photos(photo_id,description) values (1,'Пелих');
insert into sloboda_db.main_photos(photo_id,description) values (2,'Зява');
insert into sloboda_db.main_photos(photo_id,description) values (3,'Пильгуй');
insert into sloboda_db.main_photos(photo_id,description) values (4,'Команда');

insert into sloboda_db.users(login,password,name,surname,email,avatar_id) values ('admin','admin','Евгений','Годун','dinamio@ukr.net',5);

insert into sloboda_db.news(title,text_news,photo_id,author_id,created_date) values ('Год начинается с сюрпризов - в 16:00 в субботу играем с "Роганью"','Костя всё-таки решил ставить тур на 3-4 января, потому так уж выходит, что 3-го (суббота) в 16:00 мы играем с "Роганью" в 4-м туре. Похмельную явку на 100%! Завтра буду всех прозванивать и очень надеюсь, что Фат это видит и читает, т.к. его телефон уже в привычной "не-зоне". Отзовись пожалуйста в комментариях! ps играем в синих футболках!',6,1,'2015-10-01');
insert into sloboda_db.news(title,text_news,photo_id,author_id,created_date) values ('Новость 2','Костя всё-таки решил ставить тур на 3-4 января, потому так уж выходит, что 3-го (суббота) в 16:00 мы играем с "Роганью" в 4-м туре. Похмельную явку на 100%! Завтра буду всех прозванивать и очень надеюсь, что Фат это видит и читает, т.к. его телефон уже в привычной "не-зоне". Отзовись пожалуйста в комментариях! ps играем в синих футболках!',2,1,'2015-09-01');
insert into sloboda_db.news(title,text_news,photo_id,author_id,created_date) values ('Золото универа','Вчера в 17:00 золотой гол Тимура позволил "Слободе" оформить первое в нашей истории золото Кубка Универа! 8-я лига, которая оказалась очень серьезным испытанием и дала нам хорошую встряску, всё-таки покорилась слобожанам! 

"Слобода": Завадский - Зурдунов, Пелих, Тамбиев, Тельной - Фатеев, Арсланалиев, Москалец, Авксентьев - Михайлов 

В четвертый раз за осень и в третий раз за последний месяц нам довелось играть с "Хартроном". Обе команды досконально изучили друг друга, и ожидаемо первый тайм проходил в невысоком темпе с акцентом на надежность обороны. Два полумомента было у Саши и Пелиха, но их удары прошли мимо ворот. Соперник ответил своим моментом в контратаке - также безрезультативно. По большому счету первый тайм выдался очень скупым на интересные события - мы больше владели мячом, играли первым номером, даже били свободный с 6 метров но.. 

Во второй половине команды задвигались активнее и начали создавать моменты. Была пара панических смен, когда нас прижимали и мы теряли игроков - выстояли. А вот пропустили в итоге совершенно нелогичный мяч - зубрин пас через центр перехватил 13-й номер "Хартрона", отыграл Дениса и прицельно пробил в нижний угол - 0:1. Атаковали, давили, били - всё не заходило, и однажды за "Хартрон" сыграл каркас ворот. Особенно врезались в память момент Пелиха, который на 6-ти метрах отыграл корпусом защитника и пробил мимо, прострел Тимура на Фата, удары Саши и Зубры.. Где-то за 8 минут до конца чисто индивидуальный гол забил Гарик, на месте обыграв защитника и пробив в дальнюю девятку - 1:1. Команды стали действовать осторожнее, и развязка наступила на последней минуте. За 40 секунд до сирены "Хартрон" берет минуту на своем угловом, но разыгрывает его неудачно. Остается около 20 секунд и "Слобода" идет в свою атаку, Тимур принимает мяч спиной к воротам, разворачивается и прошивает защитника, отправляя мяч в нижний угол - 2:1 и 10 секунд до свистка. Соперники даже не стали разводить с центра. 

Волевая победа, которая запомнится навсегда! Большое спасибо всем, кто вчера пришел - играть, поддерживать - спасибо за вчерашний матч и за весь турнир! Что-то вело нас к этой победе, и мы ее заслужили! Мои поздравления!',3,1,'2015-08-01');