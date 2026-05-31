### 3-legged authentication
```
User
  |
Client App
  |
Google

Three parties exist:
1. User
2. Client Application
3. Authorization Server (Google, Microsoft, etc.)
```

### 2-legged authentication
```
But what if no user exists?
Example: Order Service → Payment Service
There is no human.

Only two parties:
1. Client Application / Service
2. Authorization Server

Order Service
      |
Authorization Server
      |
Gets Access Token
      |
Calls Payment Service
```
