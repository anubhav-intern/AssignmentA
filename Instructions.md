# AssignmentA
Run the RestTest1Application.java file in assignment1 package as a Spring Boot App and the use the following rest requests :-

GET requests :-

/customers :- to fetch all the customers
/customers/country/{name} :- to list customers in a particular country
/country/tag/{name} :- to list customers having a particular tag
/customers/country?name=NAME1,NAME2.....,NAMEn :- to get customers from a list of countries
/customers/country?name=NAME1,NAME2.....,NAMEn :- to get customers from a list of tags


POST requests :-

/customers?name=NAME&adrress=ADDRESS&state=STATE&country=COUNTRY&mobile=MOBILE&email=EMAIL :- to create a new untagged customer

/taggedCustomer?name=NAME&adrress=ADDRESS&state=STATE&country=COUNTRY&mobile=MOBILE&email=EMAIL&tag=TAG_NAME :- to craete a tagged customer

/customers/tag?email=EMAIL&name=TAG_NAME :- to create a new tag for a particular customer

PUT request :-

/customers?email=EMAIL&mobile=MOBILE :- to update a customer's mobile number

/customers/tag?email=EMAIL&oldTag=OLD_TAG_NAME&newTag=NEW_TAG_NAME :- to update a customers tag


