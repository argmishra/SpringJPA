## Spring JPA
Spring Data JPA API provides JpaTemplate class to integrate spring application with JPA.

## Supported Keywords
| **Keyword**       |         **Description**               |
|-------------------| --------------------------------------|
| And               | Search with all given parameters      |


## Sample
1. Search with one parameter
```curl
curl -X GET -H "Content-Type:application/json" -d "{\"firstname\": \"Anurag\"}" http://localhost:8080/users/one
```

2. Search with two parameters and AND keyword
```curl
curl -X GET -H "Content-Type:application/json" -d "{\"firstname\": \"Anurag\", \"lastname\": \"Mishra\"}" http://localhost:8080/users/two
```

2. Search with string, date, integer and Boolean parameters with AND keyword
```curl
curl -X GET -H "Content-Type:application/json" -d "{\"age\":29, \"active\": true, \"startDate\": \"2021-05-30\"}" http://localhost:8080/users/three
```