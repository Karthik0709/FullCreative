Feature: Initial testing of api

Background:
* url 'https://reqres.in/'

Scenario Outline: Initial Get check of sample API
Given path '/api/users'
And param pages = '<pageno>'
When method get
Then status 200

Examples:
|pageno|
|  1 	 |