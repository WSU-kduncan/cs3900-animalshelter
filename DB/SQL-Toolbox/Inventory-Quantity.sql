--Lists all inventory that is below 5 or below

SELECT item_ID, quantity, locations, cost, expiration
FROM inventory
WHERE quantity <= 5;
