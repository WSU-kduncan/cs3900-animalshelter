--Shows the number of pets that have been adopted

SELECT COUNT(*) AS total_adopted_pets
FROM pet
WHERE pet_status = 'Adopted';

