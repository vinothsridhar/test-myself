## DR Activity
**failover:**
1. stopped all the services in east - reduced task count to 0 in east
2. check no activity in rds
3. check sqs is halted - no more messages are processing
4. check no replication lag in rds
5. promote west to primary
6. start services in west 
7. check services are healthy in west

**failback:**
1. stopped all the services in west - reduced task count to 0 in west
2. check no activity in rds
3. check sqs is halted - no more messages are processing
4. check no replication lag in rds
5. promote east to primary
6. start services in east
7. check services are healthy in east

## Db Cleanup framework
- we had a big postgres table(Audit table). More than 2 months data we don't want to keep for the business requirement. it wasn't cleanup for long time so it grew to 500GB.
- we had to cleanup that table along with few other tables.
- I created a framework in java using spring scheduler which will run a job with the configured table at given intervals.
- The framework configuration works on multiple tables. configuration includes: table_name, retention_column(created_at), retention_days, batch_count, cron_expression
- During the job run it will generate a delete query dynamically and run for the given batch_count so that it will delete the old records in a given batches instead of deleting all at once.

## Rule description generator
- we had payer specific rules which is written in DMN rule engine.
- DMN rules are created in xml format.
- Normally product team will generate business description for those rules.
- we wanted to automate this process using AI powered system
- First I created a intermidiate metadata extractor which will extract rule details from the XML (payername, kickcode, claim amount, billed amount)
- Then using this metadata we will generate a prompt with some example rule description for the given metadata and response format.
- Then this prompt will be sent to LLM models to generate rule description for the given metadata
