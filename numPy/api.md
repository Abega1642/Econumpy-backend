## API documentation

#   User - Endpoints:
-   user login :
    - Individual login 
      -   `POST / http://ip:8080/api/individual/authentication`
        - status code: 
          - `200` (success) or `403`(wrong inputs)
    
    - Individual login
        -   `POST / http://ip:8080/api/organization/authentication`
        - status code:
            - `200` (success) or `403`(wrong inputs)
      - Request body:
      ````
         {
            "email" : "...",
             "password" : "******"
         } 
      ````
    
-   get all users :
    -  `GET / http://ip:8080/individual`
    - `Or :` `GET / http://ip:8080/organization`
    - return type : 
      - status code: `200`
        - body: list of users
          - Example for individual:
          ```
          [
            {
              "email" : "...",
              "password": "*******",
              "address": "...",
              "phoneNumber: "...",
              "username": "...",
              "birthdate": "..."
            }
          ]
          ```
          - Example for organization:
        ```
          [
            {
                "email" : "...",
                "password": "*******",
                "address": "...",
                "phoneNumber: "...",
                "username": "...",
                "birthDate": "...",
                "NIF" : "...",
                "STAT" : "...",
                "accreditation": "...",
                "creationDate": "..."
            }
          ]
        ```
    
-   create a user :
    -  `POST / http://ip:8080/back/data/users/add`
    - status code : `201`
    - body type :
      ```
           {
              "email" : "...",
              "password": "*******",
              "address": "...",
              "phoneNumber: "...",
              "username": "...",
              "birthdate": "..."
           }

-   update a user information :
    -  `PUT / http://ip:8080/back/data/users/update/username`
    - status code : `200`
    - body type :
    ```
            {
              "uname" : "...",
              "userName": "...",
              "email" : "...",
              "password" : "******",
              "toDoListDtos" = []
            }

-   delete a user :
    -   `DELETE / http://ip:8080/api/organization/delete/id` or `DELETE / http://ip:8080/api/individual/delete/id`
    - return type : `string`

#   Post _ Event - Endpoints :

-   all to do lists : 
    -   `GET / http://ip:8080/api/events`
    - status code : `200`
    - return type : List of all event posts.
      - Example :
    ```
       {
            "postId" : "...",
            "title": "...",
            "description" : "...",
            "like" : "...",
            "dislike": "...",
            "publishedDate": "...",
            "authorEmail": "...",
            "status": "..."
       }
    ```
    

-   get a specific event post by its id :
    -   `GET / http://ip:8080/back/data/todoLists/id`
    - status code : `200`
    - return type :
    ```
    {
        "postId" : "...",
        "title": "...",
        "description" : "...",
        "like" : "...",
        "dislike": "...",
        "publishedDate": "...",
        "authorEmail": "...",
        "status": "..."
    }

-   add a new event to a user :
    -   `GET / http://ip:8080/api/event/add/userMail`
    - status code : `201`
    - body type :
    ```
    {
        "postId" : "...",
        "title": "...",
        "description" : "...",
        "like" : "...",
        "dislike": "...",
        "publishedDate": "...",
        "authorEmail": "...",
        "status": "..."
    }
    

-   update an event post by its id :
    -   `PUT / http://ip:8080/api/event/update/postId`
    - status code : `200`
    - body type :
    ```
    {
        "postId" : "...",
        "title": "...",
        "description" : "...",
        "like" : "...",
        "dislike": "...",
        "publishedDate": "...",
        "authorEmail": "...",
        "status": "..."
    }
    ```

-   delete a specific to do list by its id :
    -    `DELETE / http://ip:8080/api/event/delete/eventId`