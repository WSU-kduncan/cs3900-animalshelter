1. Get Pets
Endpoint: GET /pets

Description:
Retrieves a list of pets based on optional search and filter criteria. Supports pagination and sorting.

Parameters:

 > search (optional, String): Filters pets by attributes like age, breed, name, etc.
 > page (optional, Integer, default: 1): Specifies the page number to retrieve.
 > rpp (optional, Integer, default: 10): Number of results per page.
 > sortField (optional, String, default: "dateLastUpdated"): Field to sort results by.
 > sortOrder (optional, String, default: "desc"): Sort order, either "asc" for ascending or "desc" for descending.

2. Add a New Pet
Endpoint: POST /pets

Description:
Creates a new pet record in the database if the petId does not already exist.

Request Body:

PetDTO (JSON): Contains the details of the pet to be added, including petId (required).

3. Update Pet Information
Endpoint: PUT /pets/{petId}

Description:
Updates the information of an existing pet identified by petId.

Path Parameters:

petId (required, Integer): The unique ID of the pet to update.
Request Body:

PetDTO (JSON): Contains the updated pet details.


4. Deactivate Pet (Planned)
Endpoint: PUT /pets/{petId}/deactivate

Description:
Marks a pet as deactivated or unavailable for adoption.

Path Parameters:

petId (required, Integer): The unique ID of the pet to deactivate.
