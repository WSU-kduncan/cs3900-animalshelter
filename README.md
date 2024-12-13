# Pet Shelter Pro

## Project Overview
The goal of this project was to create a working application that shelters could use to manage pet adoptions. It has three main features, the database, the web design and the api. 

## Business Case and Agile Requirements
[Link to Business Case Document](#)  
https://github.com/WSU-kduncan/cs3900-animalshelter/blob/main/BR/BR-ProjectRequirementsDocument.md
[Link to Agile Requirements Document](#)
https://github.com/WSU-kduncan/cs3900-animalshelter/tree/main/Agile

## Build Documentation
### How to Build the Project

### Major Components
1. **Database**  
   - Description: The database stores the necessary information applicable to the shelter. It holds the data about pets, adopters, adoption application and the staff.
   - Build Instructions:
       - To build the database we needed to set up a connection to MariaDB
       - Write a sql script that creates the tables and inserts the data
       - Create a docker container 

2. **API**  
   - Description: This is the component that communicates between the database and the web design. It controls the http requests which allows for grabbing, updating, deleting, and adding information between each component.
   - Build Instructions:
      - Create endpoints for each entity (Pet, Staff, Adopter, Application)

3. **Web Design**  
   - Description: This is the visual component of the project. Allows the user an easy way to interact with the database. Can search through data, delete, update, and add information without making confusing queries. 
   - Build Instructions:
      - Install Angular
      - Set up major components and services
      - Create http call request from microservices
     

## Application Checklist
### Database
- The database runs and can be connected to. 

### Microservice
- it builds and runs.
- Can respond to the resources in pet. 

### Web Design
- User can navigate between each page. Navigation bar on the top of each page.
- User can add to pets.
- User can delete a pet.  
  

## Future Work
### Remaining TODOs
List of tasks that need to be completed for the application to be considered complete.


### Partially Implemented Features
- The pet resource works but we weren't able to connect the web design to the microservices. 

### Unfulfilled Features from the Business Requirements
- Don't have running resources for Staff, Adopter or Application
- Would like to add a search implementation for the whole application



