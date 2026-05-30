## Pessimistic locking
```
//Assume conflict will happen, so I lock the row first.

BEGIN;

SELECT * 
FROM accounts 
WHERE id = 1
FOR UPDATE;

UPDATE accounts
SET balance = balance + 500
WHERE id = 1;

COMMIT;

//Other transactions wait, so performance can reduce.
```
**usecases**: wallet debit, stock deduction, booking seat

## Optimistic locking
```
//assume conflict is rare. I will not lock first. But before saving, I will check if someone changed the row.

UPDATE accounts
SET balance = 1500,
    version = 2
WHERE id = 1
AND version = 1;

//If conflict happens, one transaction fails and you need retry/error handling.
```
**usecases**: profile edit, metadata update, description edit
