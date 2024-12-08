## Starting the DB container
To start off, open up Docker Desktop. Make sure there are no containers running on the port you're going to connect to. Next, in your folder with your "docker-compose.yml" and "init_shelter.sql", run the command `docker compose up`. Give it some time and it will start up and tell you what port it's running on.

## Connecting to the database/validating the database configuration
After the container has started running, open up DBeaver. From there, start a new connection, which you can do by clicking on "Database" in the top menu bar, and select "New Database Connection". It will open up a new smaller window, from which it'll ask you to select a database driver. In our case, select "MariaDB". Set the username to "user" and password to "password". To test the connection, click on "Test Connection" in the bottom left part of the window. This will tell you whether or not you can successfully connect to the database. Once everything looks good, click finish to create the connection.

## Description of SQL query scripts  
> ![Adopted Pets](SQL-Toolbox/Adopted-Pets.sql)  
> Returns the number of pets that have been adopted  
![Adopters](SQL-Toolbox/Adopters.sql)  
> Returns all adopters including their first name, last name, email, and phone number  
![Inventory Expiration](SQL-Toolbox/Inventory-Expiration.sql)  
> Returns all items in inventory along with their details that expires within 30 days  
![Inventory Quantity](SQL-Toolbox/Inventory-Quantity.sql)  
> Returns all items in inventory that there are 5 or less of  
![Pending Applications](SQL-Toolbox/Pending-Applications.sql)  
> Returns all pending applications with the Adopters and Pets associated with them  
![Pets](SQL-Toolbox/Pets.sql)  
> Returns all pets along with their details that haven't been adopted