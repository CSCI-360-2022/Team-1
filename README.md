# How to run
1. Download the source code
2. Open a terminal window and navigate to the project folder
3. Run ./mvnw clean install
4. Run ./mvnw spring-boot run
5. Open a browser and connect to localhost:8080



**Database**
----
Utilizes Prisma and Sql lite

under the util's folder there are various differnt .server.ts files that interact with the database in various ways such as creating, updating, and querying enteries.

--------

**JobPosting** - the job posting object is the datatype object that keeps track of the different job listings created by each company and keeps track of all the needed data for each post
----

|data|datatype|description|
|----|--------|--------|
|id|string|the valuse that stores the id for the job|
|*jobTitle*| string | value that stores the name of the job| 
|*qualifications*| string | value storing the specified qualifications requested by the employer for the job| 
|*responsibilities*|  string| value storing the specified responsibilities decied by the employer |
|*salary*| integer | value storing the salary for the position|
|*jobLocation*| string | value storing the location of the position|
|*jobType*| string | value storing the location of the position|
|*workStyle*| string | specifies wether the job is on site, remote or hybrid|
|createdBy | User relation| a relation that keeps track of which user creates the instance of the JobPosting storing the user *id* into the *createdById* |
|createdById| String| stores the value of the *id* given from the user who created the JobPosting instance|
|company|Company relation| a relation that keeps track of which company creates the instance of the JobPosting storing the Company *id* into the *companyId*
|companyId|string|stores the value of the *id* given from the company who created the JobPosting instance|

------
**Company** - The Company database object stores the companies in the system and all the info to go with them  
----

|data|datatype|description|
|----|--------|--------|
|id|string|the valuse that stores the id for the company|
|jobPostings|jobposting[]|a list of jobPost objects that the company has created|
|users|User[]|a list of User objects that represents the employees that belong to the copany|
|companyName|string|value that stores the name of the company|
|companyBio|string|value that stores the contents of the bio for the company|
|companyWebsite|string|value that stores the url's for the website of the company|

-----
**User** - The User database object stores the users in the system and all the info related to them
---

|data|datatype|description|
|----|--------|--------|
|id|string|value that stores the user id|
|clerkId| string|value that stores unique id used with Clerk Api used for loging in|
|company|string relaiton| relation that keeps track of which company a given user is with and stores the company's id in the companyId field|
|companyId| string | value storing the id given from teh company relation|
|firstName|string|value that stores the first name of the user|
|lastName|string|value that stores the last name of the user|
|jobPostings|JobPostings[]|a list of JobPostings objects that keeps track of which JobPostings the given user has created|
