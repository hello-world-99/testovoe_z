# Login demo project(Practice)

## App features :
- if the login/password is incorrect, we display an "error"
- it is necessary to provide the possibility of logout
- correct display of a list of payments in case of erroneous data (missing fields, type mismatch)

## Code stack:
- jetpack compose
- Kotlin
- Retrofit
- Coroutines
- simple architecture and logic

## API:
- Base URL https://easypay.world/api-test/, app-key=12345 and v=1 should be passed in headers
  
- POST /login - login, we pass the parameters to json ({"login": "demo", "password": "12345"}), if the request is correct, a token is received in response.
  
- GET /payments - list of payments; for a correct request, we pass the previously received token token='...' in the headers
