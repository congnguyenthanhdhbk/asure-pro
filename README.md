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
1. Jenkins
2. Linux, CentOS
3. Kubernetes, Docker
4. Terraform
5. GitOps
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
2. Check Line of code for PR before reviewing
- If Line of code greater than 400 then I will reject. The main reason is too many code to review effectively
- Only review code less than 400 LOC
3. Run sonarqueber to check smell code. Sonarque is tool which setup to check code quality
4. Review business checklist, after that, running unit test to ensure all business is cover by developer
