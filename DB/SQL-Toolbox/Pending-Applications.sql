-- Lists all pending applications with Adopters and Pets associated with them

SELECT aa.application_ID, p.pet_name AS pet_name, a.first_name AS adopter_first_name, a.last_name AS adopter_last_name, aa.application_status
FROM adoption_application aa
JOIN pet p ON aa.pet_ID = p.pet_ID
JOIN adopter a ON aa.adopter_ID = a.adopter_ID
WHERE aa.application_status = 'Pending';

