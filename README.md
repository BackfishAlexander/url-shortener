# URL Shortener
---
#### Full Project stack:
- Angular version `16.2.0`.
- Spring Boot version `3.1.4` on Java `17`.
- PostgreSQL database version `2.6.5`.
  
#### Project: 
This project is a url-shortening service much like https://bit.ly or https://goo.gl. The service aims to take long and ugly URLs and make them into a small and simple URL.

This project contains two `Angular` components. 

The first is the url-shortener which is the interface used to call a POST request to the `Spring Boot` `REST API` which takes an input of a URL, generates a shortened url, saves the link between these two URLs into the `PostgreSQL` database, and then returns that URL to the user who generated it. 

The second is the redirect component which is activated whenever the frontend URL has any subdirectory that it is attempting to navigate to. This component calls a GET request to the REST API that checks if the subdirectory code is contained within the database. If it is, the application will automatically redirect users to the linked website. 
