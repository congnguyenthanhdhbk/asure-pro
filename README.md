# The testing assigment
Software Engineers Interview Questionnaire
Please answer these in your own words as part of English communication assessment.
1. Which programming languages are you most comfortable working with? Why?
2. Any Mobile programming experiences? If yes, please cite examples and name
   the languages you are familiar with.
3. Do you have DevOPS experience? If yes, please cite examples and name some
   best practices.
4. Do you have cloud computing setup experience? If yes, please name the
   service providers you are familiar with.
5. What process do you use to review application codes?
6. What do you consider to be the most important criteria for the success of a
   software development?

Software Engineers Interview Test Task
Develop a responsive web application
Requirements
1. Create 3 logins
   a. Super Admin
   To be able to add or remove student or mentor
   b. Student
   To be able to view mentor details
   c. Mentor
   To be able to view student details
2. To use GIT and commit at regular intervals
3. To use encryption for all passwords
4. To host in AWS
5. To use load balancer, EC2 and RDS
6. To provide related comments in codes
# Answer
## Part 1: Questionnaire
### Q1: I am most comfortable for working with Java 11. For this below reason:
1. Strongly support for OOP. I can fully apply SOLID principal
2. Collection framework was built strongly to resolve complicated problem
regarding data structure as List, Map, Tree, Queue etc in real project
3. Object Relation mapping framework as Hibernate is strongly support for interact with Relational database well. It's also support for developer developing easily 
4. Spring framework was built to support for developing any system as Monolith, Microservice. It's provide a lot of package libs to work with another opensource as Message Queue, NoSql, Relational database
5. Strongly support functional programing which help developer to develop easily
6. It's support for performing structure well by following domain driven design or Hexagon Patten to structure clearly.
For example:
- UI layer: by using rest API to expose for interact with client side as Mobile app, web etc
- Service layer: Focus on handling business
- Repository or Data Access Layer: Interact with directly database by SQL or ORM frame work
- Adapters: Support fot interact with another system by using rest API, message queue etc
7. Java have various ecosystem tools to apply in project as Jenkins, Sonaqueber, Gradle, Maven etc
### Q2: I have no experience for developing mobile application. I am only focus on developing as backend developer by using java
### Q3: I have 2 years experience for applying devops to develop CI/CD. I can hand on below tools:
1. Implement CI/CD to build and deploy service. I am always following tools:
- Jenkins 
- Linux, CentOS 
- Kubernetes, Docker 
- Terraform 
- GitOps
2. Implement test automation
3. Always monitor system by applying tools Prometheus, Grafana, Cloudwatch
4. Build alert system to trigger any issue regarding the system
5. Monitor logs, tracing and another metrics on prometheus, grafana, cloudwatch
## Q4: I have experiences for setup AWS cloud and apply below service for my project
1. SNS (simple Notification Service) and SQS (Simple Queue Service) as queue to delivery message in system
2. EKS (Elastic Kubernetes Service) to host a Kubernetes for build service by using Helm, Kubectl to deploy specific service
3. ECR (Elastic Registry Repository) to storage docker image which build successfully
4. AppSync to build application regarding realtime task as Chat, Realtime reaction etc
5. API gateway support for connect from outside to inside of microservice. It's help to connect to APIs internal service
6. AppMesh By setting virtual service, router, gateway, post which support for balance traffic well in mesh
7. RDS (Relational Database Service) By applying postgres core engine to storage data to ensure ACID when developing system
8. IAM (Identifier Account Management) By apply this service to grant permission and running service
9. Open search by using Elastic search 7.10 for indexing all business data for searching base on text search
10. EC2 (Elastic Cloud Compute) It's a service to host linux or another OS to serve build every application
## Q5: Review process will be separate for many phase as below
1. Perform review checklist focus on 4 term
- Readability: Are there any redundant comments in the code?
- Security: Does the code expose the system to a cyber attack? follow OWASP top 10
- Test coverage: Is there a need to test more cases?
- Architecture: Does the code use encapsulation and modularization to achieve separation of concerns?
- Reusability: Does the code use reusable components, functions, and services?
2. Check LOC (Line Of Code) for PR (Pull Request) before reviewing
- If Line of code greater than 400 for each reviewing session then I will reject. The main reason is too many code to review effectively
- Only review code less than 400 LOC
3. Feedback for reviewing
- Use tools as Bitbucket, Gitlab, Github to check code change to feedback for reviewing
- Use git tool to check code version and history to feedback for scope change of code
- Review focus on find a defect and suggest many solution to resolve this concern in code.
It can regard performance, architecture, mistake business, security as step 1
4. Finally, Double check to ensure any problem in reviewing to completely resolve before releasing
## Q6: I focus on the most important criteria as below
1. Having career path clearly
2. Working as team
3. Being able to communicate effectively
4. Having knowledge domain strongly
5. Having Technical expert
6. Have an extensive background in software development
# PART2: Backend
Prepare
1. postgres
2. Run below script to insert role
```
INSERT INTO roles(name) VALUES('ROLE_STUDENT');
INSERT INTO roles(name) VALUES('ROLE_MENTOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```
## API BE
1. API add mentor or student
This API is only accept for role admin to add mentor or student
### curl request
```
curl --location --request POST 'http://localhost:8080/api/v1/auth/signup' \
--header 'Content-Type: application/json' \
--header 'Cookie: asureprouser=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtZW50b3IiLCJpYXQiOjE2NTc4MTcwNjgsImV4cCI6MTY1NzkwMzQ2OH0.r2MWWJUlihzMSOG-4deTtOOsznP_rY65XJhEJgcpTTT4cUVucRRQOhBt6gfwIgjVmCSBJPAGxE4Hb_9owaRFpg' \
--data-raw '{
    "username": "student",
    "email": "student@asure-pro.com",
    "password": "1234556666",
    "role": ["student"]
}'
```
### response
```
{
    "message": "User registered successfully!"
}
```
2. API login
This API for 3 role
```
curl --location --request POST 'http://localhost:8080/api/v1/auth/signin' \
--header 'Content-Type: application/json' \
--header 'Cookie: asureprouser=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY1NzgxOTM0NCwiZXhwIjoxNjU3OTA1NzQ0fQ.izMm0a1FT-wwDIeM8K9svoikiHaIGzGCqympXofeZneYLNdgMH5PK6prxPkw-1g_-kK2aanLC1ovexR0rJxxxQ' \
--data-raw '{
    "username": "admin",
    "password": "1234556666"
}'
```
### Response
```
{
    "id": 1,
    "username": "admin",
    "email": "admin@asure-pro.com",
    "roles": [
        "ROLE_ADMIN"
    ]
}
```
3. API to sign out
```
curl --location --request POST 'http://localhost:8080/api/v1/auth/signout' \
--header 'Content-Type: application/json' \
--header 'Cookie: asureprouser=' \
--data-raw '{
    "username": "admin",
    "password": "1234556666"
}'
```
4. API get list member base on role student and mentor
```
curl --location --request GET 'http://localhost:8080/api/v1/students?role=mentor&page=0&size=10' \
--header 'Cookie: asureprouser=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50IiwiaWF0IjoxNjU3ODE5NTE2LCJleHAiOjE2NTc5MDU5MTZ9.WDT4i4VvZ-CMZ8Zp2pS72VzWaS48aa5-Ncfmgsm0CSsMM6l-X0punRjtK-73aGgONXKAIf_Dgq-jyY9AFT1jbQ'
```
## FE (TODO)