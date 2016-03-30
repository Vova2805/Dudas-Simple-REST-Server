# Dudas-Simple-REST-Server

This is simple REST web service on Java. 
Tecnologies:
  -Java 8
  
  -MySQL
  
  -Hibernate/JPA
  
  -Spring framework
  
  -Apatche Tomcat 8.0.33

#Task description:
#Task 0. (/task0users; /task0movies; /task0ratings)
  Return all users, movies, ratings.
#Task 1. (/task1)
  Some date in rating is lost. Find the userId of all users who have ratings with a NULL value for the date. Set it to today's date in database. 
  Return all ratings.
#Task 2. (/task2)
Insert the following movies into the Movie table: 9 Deadpool Tim Miller 
                                                  10 The 300 spartans Zak Snyder
Return all movies.
#Task 3. (/task3)
Return the movieID, ratingDate of all movies that received a rating of 4 or 5, and sort them in increasing order by ratingDate.
#Task 4. (/task4)
Return the titles of all movies that have no ratings. 
#Task 5. (/task5)
Delete the movies you added in task 2 (by id 9 and 10).
Return all movies
#Task 6. (/task6)
Return the title of the movie, user name and rating for every rating.
