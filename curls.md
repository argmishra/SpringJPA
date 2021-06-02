## Sample
Search with named query annotation with parameter
```curl
curl -X GET "http://localhost:8080/users/parameternamedquery/27"
```

Search with named query annotation without parameter
```curl
curl -X GET "http://localhost:8080/users/namedquery"
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

Search with Containing keyword
```curl
curl -X GET "http://localhost:8080/users/sixteen/arm"
```

Search with NotLike keyword
```curl
curl -X GET "http://localhost:8080/users/seventeen/Sharma"
```

Search with StartingWith keyword
```curl
curl -X GET "http://localhost:8080/users/eighteen/Him"
```

Search with EndingWith keyword
```curl
curl -X GET "http://localhost:8080/users/nineteen/rag"
```

Search with IgnoreCase keyword
```curl
curl -X GET "http://localhost:8080/users/twenty/ANURAG"
```

Search with IgnoreCase and StartingWith keyword
```curl
curl -X GET "http://localhost:8080/users/twentyone/AbH"
```

Search with True keyword
```curl
curl -X GET "http://localhost:8080/users/twentytwo"
```

Search with False keyword
```curl
curl -X GET "http://localhost:8080/users/twentythree"
```

Search with Not keyword
```curl
curl -X GET "http://localhost:8080/users/twentyfour/Himani"
```

Search with In keyword
```curl
curl -X GET -H "Content-Type:application/json" -d" ["27","29"]" http://localhost:8080/users/twentyfive
```

Search with NotIn keyword
```curl
curl -X GET -H "Content-Type:application/json" -d" ["27","29"]" http://localhost:8080/users/twentysix
```

Search with OrderBy and Asc keyword
```curl
curl -X GET "http://localhost:8080/users/twentyseven/Anurag"
```

Search with Like keyword
```curl
curl -X GET "http://localhost:8080/users/twentyeight/%25nu%25"
```

Search with StartsWith keyword
```curl
curl -X GET "http://localhost:8080/users/twentynine/Abh"
```

Search with EndsWith keyword
```curl
curl -X GET "http://localhost:8080/users/thirty/av"
```

Search with First keyword
```curl
curl -X GET "http://localhost:8080/users/thirtyone"
```

Search with Top keyword
```curl
curl -X GET "http://localhost:8080/users/thirtytwo"
```

Search with Distinct keyword
```curl
curl -X GET "http://localhost:8080/users/thirtythree/Sharma"
```

Search with Count keyword
```curl
curl -X GET "http://localhost:8080/users/thirtyfour/23"
```

Search with Find keyword
```curl
curl -X GET "http://localhost:8080/users/thirtyfive"
```

Search with Read keyword
```curl
curl -X GET "http://localhost:8080/users/thirtysix"
```

Search with Query keyword
```curl
curl -X GET "http://localhost:8080/users/thirtyseven"
```

Search with Get keyword
```curl
curl -X GET "http://localhost:8080/users/thirtyeight"
```

Search with Null keyword
```curl
curl -X GET "http://localhost:8080/users/thirtynine"
```

Search with isNot keyword
```curl
curl -X GET "http://localhost:8080/users/fourty/Anurag"
```