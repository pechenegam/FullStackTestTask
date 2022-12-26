
## To start app
**Run this in the project**
```
docker-compose up
```
This will launch the database in PostgreSQL
____
After that, run
```
DemoApplication.java
```
____
## Users credentials in migration 
| User | Password |
|:----------------|:----------------|
| User1 | 41241241 |
| User2 | 41241241 |

____
## API endpoints 
| Endpoint | Access | Type|
|:----------------|:----------------|:----------------|
| /api/v1/auth/sign-in | all requests | POST |
| /api/v1/auth/refresh | all requests | POST |
| /api/v1/conversions | authorized users | GET |
| /api/v1/conversions | authorized users | POST |
| /api/v1/conversions/all | authorized users | GET |
| /api/v1/exchange | authorized users  | GET |
