SQL script:

/* Create the schema tables. Add keys by yourself */

create table Movie(id int, title text, director text);
create table User(id int, name text);
create table Rating(id int, userId int, movieId int, rating int, ratingDate date);

/* Populate the tables with data */
insert into Movie values(1, 'Gone with the Wind', null);
insert into Movie values(2, 'Star Wars', 'George Lucas');
insert into Movie values(3, 'The Sound of Music', 'George Lucas'');
insert into Movie values(4, 'E.T.', 'Steven Spielberg');
insert into Movie values(5, 'Titanic', 'James Cameron');
insert into Movie values(6, 'Snow White', null);
insert into Movie values(7, 'Avatar', 'James Cameron');
insert into Movie values(8, 'Raiders of the Lost Ark', 'Steven Spielberg');
insert into User values(11, 'Sarah Martinez');
insert into User values(12, 'Daniel Lewis');
insert into User values(13, 'Brittany Harris');
insert into User values(14, 'Mike Anderson');
insert into User values(15, 'Chris Jackson');
insert into User values(16, 'Elizabeth Thomas');
insert into User values(17, 'James Cameron');
insert into User values(18, 'Ashley White');
insert into Rating values(21, 11, 1, 2, '2016-02-29');
insert into Rating values(22, 11, 1, 4, '2016-03-01');
insert into Rating values(23, 12, 6, 4, null);
insert into Rating values(24, 13, 3, 2, '2016-02-26');
insert into Rating values(25, 13, 8, 4, '2016-02-25');
insert into Rating values(26, 13, 8, 2, '2016-02-24');
insert into Rating values(27, 14, 1, 3, '2016-02-13');
insert into Rating values(28, 15, 3, 3, '2016-02-22');
insert into Rating values(29, 15, 4, 2, '2016-02-11');
insert into Rating values(30, 15, 8, 4, null);
insert into Rating values(31, 16, 7, 3, '2016-02-19');
insert into Rating values(32, 16, 6, 5, '2016-02-22');
insert into Rating values(33, 18, 4, 3, '2016-02-22');