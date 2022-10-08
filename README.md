# management-student
Spring Boot Multiple Microservices
A springboot application to store, modulate and manage Grades of students in a college.
1. enter grades of each student based on subjects in bifurcation of theory/practical/oral
2. subjects can be mandatory or electives
3. students can be from any year across a course of 4 years
4. pass fail criteria should be 0-30 : fail, 30-45 : 3rd division, 45-60 : second division, 60-85: first dvisions, 85-100 : 1st division and distinction
5. provide scope for raising request for correction of grades based on teacher's approval (only can be done by the administrator)
6. provide results for each class and toppers of each language and each class and each gender separately
7. request for subject change provided each subject has maximum capacity of 60 students per semester
8. provide scope to see details of each student and each subject and history of each student based on his past performance
9. application should be archived and dockerised and deployed in a kube container in local and tunneled so that any user can hit the APIs from their own laptop via postman (use NGROK)
10. Database : MYSQL
11. Design Pattern : MVC
12. JUNIT Test Cases for all modules
13. Role based authentications for Teacher Student and Administrator (Teacher Student and Admin Login) and Profile creation of each as well
