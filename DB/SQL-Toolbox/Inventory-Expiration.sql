--Shows all inventory that will Expire within 30 days

SELECT item_ID, quantity, locations, cost, expiration
FROM inventory
WHERE expiration BETWEEN NOW() AND DATE_ADD(NOW(), INTERVAL 30 DAY);


