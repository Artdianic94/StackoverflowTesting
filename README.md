# StackoverflowTesting
## Description
An application that sends a request to stackoverflow to receive the last 10 responses on the site
and checks that the correct data is returned in the response.
LastTenAnswersTest checks that the following conditions are met:
1) status code,
2) the array contains no more than 10 notes,
3) each element of the array contains an Owner object,
4) that for each Owner object, the link is formed using the display_name and user_id fields.
### Dependencies
Programming language: Java

| Automation Feature (Tool) |                             Links                              |
|---------------------------|:--------------------------------------------------------------:|
| Rest-Assured              |    https://github.com/rest-assured/rest-assured/wiki/Usage     |
| Allure                    |                   http://allure.qatools.ru/                    |
| TestNG                    |         https://testng.org/doc/documentation-main.html         |
| Maven                     |                   https://maven.apache.org/                    |
