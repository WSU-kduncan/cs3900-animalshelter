-- View all pets that are not adopted

SELECT pet_ID, name, species, breed, age, status
FROM pet
WHERE status = 'Not Adopted';


