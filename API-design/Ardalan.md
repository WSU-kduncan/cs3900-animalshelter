**GET /api/adopters**

**Purpose:** Fetch a list of adopters. You can filter by name or email.

**Parameters:**

name : Filter by adopter’s name.

email : Filter by adopter’s email.

page (default: 1): Page number for pagination.

rpp (default: 10): Results per page.

**Response:**

Returns a list of adopters with fields like Adopter_ID, Name, Email, and Phone_Number.

**Query Outline:**

SELECT * FROM Adopter WHERE [filters] LIMIT [rpp] OFFSET [page];


-----------------------------------------------------------------------------------------------------------

**POST /api/adopters**

**Purpose:** Add a new adopter to the system.

**Required Data:**

Name - The adopter’s full name.

Email - Contact email.

Phone_Number - Contact phone number.

**Response:**

Returns the new adopter's details includes their unique Adopter_ID.

**Query Outline:**

INSERT INTO Adopter (Name, Email, Phone_Number) VALUES (name, email, phone) RETURNING *;


-----------------------------------------------------------------------------------------------------------

**PUT /api/adopters/{id}**

**Purpose:** Update existing adopter details by their ID.

**Required Data:**

id  - The adopter’s ID.

JSON body with fields to update: Name, Email, Phone_Number.

**Response:**

Returns the updated adopter info.

**Query Outline:**

UPDATE Adopter SET [fields to update] WHERE Adopter_ID = [id] RETURNING *;

-----------------------------------------------------------------------------------------------------------

**DELETE /api/adopters/{id}**

**Purpose:** Delete an adopter by their ID.

**Required Data:**

id  - The ID of the adopter to delete.

**Response:**

Just a confirmation message saying the delete process was successful.

**Query Outline:**

DELETE FROM Adopter WHERE Adopter_ID = [id];
