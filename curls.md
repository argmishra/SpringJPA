## Sample
Search with named query annotation
```curl
curl -X GET "http://localhost:8080/users/namedquery/27"
```

Search with query annotation
```curl
curl -X GET "http://localhost:8080/users/query/true"
```

Search with one parameter
```curl
curl -X GET -H "Content-Type:application/json" -d "{\"firstname\": \"Anurag\"}" http://localhost:8080/users/one
```

Search with two parameters and And keyword
```curl
curl -X GET -H "Content-Type:application/json" -d "{\"firstname\": \"Anurag\", \"lastname\": \"Mishra\"}" http://localhost:8080/users/two
```

Search with date, integer and boolean parameters with And keyword
```curl
curl -X GET -H "Content-Type:application/json" -d "{\"age\":29, \"active\": true, \"startDate\": \"2021-05-30\"}" http://localhost:8080/users/three
```

Search with string, integer and boolean parameters with Or keyword
```curl
curl -X GET -H "Content-Type:application/json" -d "{\"age\":29, \"active\": false, \"firstname\": \"Anurag\"}" http://localhost:8080/users/four
```

Search with string, integer and boolean parameters with Or and And keyword
```curl
curl -X GET -H "Content-Type:application/json" -d "{\"age\":29, \"active\": false, \"firstname\": \"Anurag\"}" http://localhost:8080/users/five
```

Search with integer and boolean parameters with Is keyword
```curl
curl -X GET -H "Content-Type:application/json" -d "{\"age\":29, \"active\": false}" http://localhost:8080/users/six
```

Search with integer and boolean parameters with Equals keyword
```curl
curl -X GET -H "Content-Type:application/json" -d "{\"age\":29, \"active\": false}" http://localhost:8080/users/seven
```

Search with Between keyword
```curl
curl -X GET "http://localhost:8080/users/eight?start=27&end=33"
```

Search with LessThan keyword
```curl
curl -X GET "http://localhost:8080/users/nine/27"
```

Search with LessThanEqual keyword
```curl
curl -X GET "http://localhost:8080/users/ten/27"
```

Search with GreaterThan keyword
```curl
curl -X GET "http://localhost:8080/users/eleven/27"
```

Search with GreaterThanEqual keyword
```curl
curl -X GET "http://localhost:8080/users/twelve/27"
```

Search with After keyword
```curl
curl -X GET -H "Content-Type:application/json" -d "{\"startDate\": \"2021-03-05\"}" http://localhost:8080/users/thirteen
```

Search with Before keyword
```curl
curl -X GET -H "Content-Type:application/json" -d "{\"startDate\": \"2021-03-05\"}" http://localhost:8080/users/fourteen
```

Search with After and GreaterThanEqual keyword
```curl
curl -X GET -H "Content-Type:application/json" -d "{\"startDate\": \"2021-03-05\", \"age\":27 }" http://localhost:8080/users/fifteen
```