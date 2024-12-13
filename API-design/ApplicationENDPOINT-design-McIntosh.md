
Get Mapping
  - The GET method retrieves adoption applications based on various filters such as pet name, applicant name, and status. If no filters are applied, it returns all adoption applications
  - GET /api/applications

Parameters
  - petName (String): Filter by the name of the pet being adopted.
  - applicantName (String): Filter by the name of the applicant.
  - status (String): Filter by application status (e.g., "Pending", "Approved", "Rejected").

Post Mapping
  - The POST method allows users to submit new adoption applications by providing necessary details about the pet and the applicant.
  - POST /api/applications
  - Returns the newly created adoption application, including its generated id

Put Mapping
  - The PUT method allows users to update an adoption application’s status, pet name, or other relevant details. The application ID is required in the URL
  - PUT /api/applications/{id}

Delete Mapping
  - The DELETE method allows users to delete an adoption application by providing its id.
  - DELETE /api/applications/{id}


