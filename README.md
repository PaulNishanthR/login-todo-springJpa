# login-todo-springJpa
 
REST API with the following HttpRequests using JPA:
    * Login - Existing User
        * POST
    * Register - New User
        * POST
     *Todo Items
        * GET
        * GET with Id
        * POST
        * PUT
        * DELETE

Steps followed to develop the API:-
    * Used Model for information, Controller for Mapping, Service for business logics and Repository for Database queries.
    * Added the required maven dependency for Sql and Spring with JPA (Java Persistance API).
    * Mapped the Models to table using @Entity annotation.
    * Used '@RestController' for creating RESTful web services using Spring MVC.
    * Used required Annotations for handling HttpRequests like @GetMapping, @PostMapping etc..
    * Achieved Dependency Injection via constructor using @Autowired annotation.
    * Used 'JpaRepository<>' for connecting database mapping for executing query.
    * Used application.properties file for storing the connection URL.
    * Used save(), findById(), findAll() methods to get query results.
    * Used JPQL for named queries.
    * Used "OneToMany" and "ManyToOne" relationships to map the tables by using annotations.
