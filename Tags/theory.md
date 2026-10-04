Spring Boot: Mastering REST API Development


MVC: is  framework within the prring ecosystem that is designed for buildin web applications 
Http: is a set of rules that computers follow to send and receive data over the internet 
Bean : is an object that is managed by spring when we mark this calss with the annotation we are telling spring that this is a bean so when the app starts spring will be able to create an instance of this calss and manage that instance.
Tempate engine : is a tool that allows to create dynamic web pages by embedding variables and logic inside HTML files.

How the Web Works
When we browse a website, our browser (the client) sends a request to a server. The
server processes the request and returns a response.
This communication happens using HTTP (HyperText Transfer Protocol), which defines
how data is exchanged over the web.

Key Parts of an HTTP Request
• Method – Specifies what action we want to perform (GET, POST, PUT, DELETE).
• URL – The address of the resource being requested.
• Headers – Extra information (e.g., content type, authentication tokens).
• Body (Optional) – Contains data for the server (e.g., form submissions)

Key Parts of an HTTP Response
• Status Code – Indicates if the request was successful (200 OK, 404 Not Found).
• Headers – Metadata about the response.
• Body – The actual content returned by the server. It can contain
• HTML markup (used in traditional web applications)
• Data in JSON format (used in APIs)

On the Server – The server generates the full HTML page and sends it to the
client. This technique is referred to as Server-Side Rendering (SSR).
• On the Client – The server sends only raw data (JSON), and the client dynamically
generates web page using JavaScript. This technique is referred to as Client-Side
Rendering (CSR).

JSON (JavaScript Object Notation) is a lightweight format used to structure data.
API (Application Programming Interface) is a way for applications to
communicate with each other.

Model – Represents data and business logic. Typically, these are Java objects
mapped to database entities.
• View – Defines how data is displayed. In traditional web apps, this is an HTML page
generated using a template engine like Thymeleaf.
• Controller – Handles HTTP requests, processes data, and returns a response.

@Controller for returning HTML views.
• @RestController for returning data. Spring MVC automatically convert Java objects
to JSON objects
itrable : is an interface that represnts a collecction of elements that can be iterated over. it is the parnt interface for lists
DTO is a simple java object used to transter data between different layers of an application

MVC (Model–View–Controller) in Spring Boot is a design pattern that separates an application into three parts:
Model: Handles the application’s data and business logic.
View: Displays data to the user, usually an HTML page.
Controller: Receives user requests, processes them, and returns a view or response.
Example: In a Spring Boot web application, a controller receives a request for a home page, gets the necessary data from the model, and returns an HTML view to display it.

@Controller returns view names, while @RestController = @Controller + @ResponseBody and returns data (JSON) directly.

Template Engine (Thymeleaf) in Spring Boot is a tool that combines data from Java with HTML templates to generate dynamic web pages.
Example: Display a user's name in an HTML page using ${name} in Thymeleaf.

Thymeleaf: A server-side Java template engine used to render HTML, XML, CSS, and JavaScript. It injects dynamic backend data into standard HTML templates before serving them to the user's browser.
API (Application Programming Interface): A general contract or set of rules that allows one piece of software to talk to another.


http://localhost:8080/api/products/5?sort=price&page=0
└─┬─┘ └────┬──────┘ └──────┬──────┘└─────────┬────────┘
scheme   host:port        path          query params

URL (Uniform Resource Locator): The address of the resource you want to access, such as /api/products/1.
Headers: Additional information about an HTTP request or response, such as the content type or authorization token.
Body: The data sent in an HTTP request or returned in an HTTP response, often in JSON format.
Status code: A number that indicates the result of an HTTP request, such as 200 (OK), 201 (Created), 400 (Bad Request), or 404 (Not Found).


Concept

	

One-line definition

API

	

Allows software applications to communicate.

REST API

	

Provides access to resources through HTTP requests.

HTTP methods

	

Define the action to perform on a resource.

URL

	

Identifies the resource or endpoint.

Headers

	

Carry additional request or response information.

Body

	

Contains the data sent or returned.

Status code

	

Indicates the result of an HTTP request.

SSR

	

The server generates the HTML page.

CSR

	

The browser generates the page using JavaScript.
HTTP Methods: Define the action to perform on a resource, such as GET, POST, PUT, PATCH, or DELETE.
URL: The address used to identify and access a resource.
Headers: Provide additional information about an HTTP request or response.
Body: Contains the data sent in a request or returned in a response.
SSR (Server-Side Rendering): The server generates HTML and sends the finished page to the browser.
CSR (Client-Side Rendering): The browser uses JavaScript to generate and update the page, often using data from an API.
REST API (Representational State Transfer API) is a way for applications to communicate over HTTP by using URLs to represent resources and HTTP methods to perform actions on those resources.

An API is the general concept of software interfaces (like a steering wheel in a car). A REST API is a specific, standardized design for web services using HTTP verbs (GET, POST, PUT, DELETE) to manipulate data resources over the web.
"API" describes what (a way for programs to communicate), and "REST" describes how (a specific set of conventions over HTTP).
Iterable means "something you can loop over," and it's the weakest collection type in Java. In Spring Boot you mostly meet it in CrudRepository, and the usual fix is to extend JpaRepository instead so you get a List.
Iterable means a collection of objects that you can loop through one by one.

ResponseEntity is a Spring class used to control the complete HTTP response, including the response body, status code, and headers.

DTO (Data Transfer Object) is a simple Java object used to transfer data between different parts of an application, especially between the backend and the client.
HTTP Request (JSON) ──> Request DTO ──> Controller ──> Service (Map to Entity) ──> Database (JPA Entity)
                                                                                       │
HTTP Response (JSON) <── Response DTO <── Controller <── Service (Map to DTO) <────────┘

ModelMapper is a Java library that automatically maps (converts) data from one object to another, commonly from an Entity to a DTO or from a DTO to an Entity.
ModelMapper automatically converts one Java object into another, especially Entity ↔ DTO.

mapping means copying data between objects such as Entity and DTO, and ModelMapper does it automatically by matching field names. It's quick to start with, but MapStruct is the safer and faster choice for real projects.

Layer	Job	Knows about	Never does
Controller	Handles HTTP: URL, method, status, request/response	DTOs, Service	Business logic, database access
Service	Business logic, rules, transactions, Entity ↔ DTO mapping	Entities, DTOs, Repository, Mapper	HTTP stuff (ResponseEntity, headers)
Repository	Talks to the database	Entities only	Business logic, DTOs
Mapper	Converts Entity ↔ DTO	Entities, DTOs	Anything else


Client (Angular)
   │  JSON
   ▼
Controller      ← receives ProductRequest (DTO), returns ProductResponse (DTO) The controller handles the HTTP request.
   │
   ▼
Service         ← business logic + uses Mapper: DTO (represents the data you want to send/receive through your API.)↔ Entity (represents your database table.)
   │
   ▼
Repository      ← saves/loads Product (Entity) The repository talks to the database.
   │
   ▼
Database



1. The Core Layers & ObjectsConceptRoleWhy & When to UseHow to DefineEntityDatabase Table RepresentationRepresents raw database tables/columns. Use only for database operations (JPA/Hibernate).Annotated with @Entity and @Table.DTOAPI Data StructureContracts for HTTP requests/responses. Use to hide sensitive database fields, validate input, or shape response data.Java record or POJO with validation annotations.MapperObject ConverterConverts Entity $\leftrightarrow$ DTO. Use to avoid repetitive getter/setter code in your business logic.@Component using ModelMapper, MapStruct, or manual methods.RepositoryDatabase LayerExecutes SQL queries and database CRUD operations. Use when reading or writing persistent data.Interface extending JpaRepository or CrudRepository.ServiceBusiness Logic LayerCoordinates transactions, applies business rules, and calls Mappers/Repositories. Use for all app rules.Class annotated with @Service.ControllerAPI Gateway LayerReceives HTTP requests, calls the Service layer, and returns HTTP status codes/responses.Class annotated with @RestController.


| Layer          | Responsibility                           |
| -------------- | ---------------------------------------- |
| **Controller** | Handles HTTP requests/responses          |
| **Service**    | Contains business logic                  |
| **Repository** | Talks to the database                    |
| **Entity**     | Represents database data                 |
| **DTO**        | Represents data sent/received by the API |
| **Mapper**     | Converts Entity ↔ DTO                    |



[ START ] Client / Browser
    │
    ▼ 1. HTTP Request (JSON)
┌─────────────────────────────────────────┐
│ CONTROLLER LAYER                        │  1. Receives HTTP request
│  └─ Request DTO                         │  2. Validates incoming DTO
└───────────────────┬─────────────────────┘
                    │ Request DTO
                    ▼
┌─────────────────────────────────────────┐
│ SERVICE LAYER                           │  3. Receives DTO from Controller
│  ├─ MAPPER                              │  4. Uses Mapper to convert DTO ➔ Entity
│  │   └─ Entity                          │  5. Applies business rules & logic
│  ├─ REPOSITORY                          │  6. Passes Entity to Repository
│  │   └─ Database SQL                    │  7. Gets updated Entity back from DB
│  └─ MAPPER                              │  8. Uses Mapper to convert Entity ➔ Response DTO
│      └─ Response DTO                    │
└───────────────────┬─────────────────────┘
                    │ Response DTO
                    ▼
┌─────────────────────────────────────────┐
│ CONTROLLER LAYER                        │  9. Receives Response DTO from Service
│  └─ Response DTO + HTTP Status          │ 10. Wraps in ResponseEntity (e.g. 200 OK, 201 Created)
└───────────────────┬─────────────────────┘
                    │
                    ▼ 11. HTTP Response (JSON)
[ END ] Client / Browser


 [CLIENT] 
   │ 
   │  1. HTTP Request (JSON)
   ▼ 
[CONTROLLER] ──(Passes Request DTO)──┐
                                     │
                                     ▼
                                [SERVICE] ──(Uses Mapper: Request DTO ➔ Entity)──┐
                                                                                 │
                                                                                 ▼
                                                                           [REPOSITORY] ──► [DATABASE]
                                                                                                 │
                                                                           [REPOSITORY] ◄────────┘
                                                                                 │
                                                                                 │ (Returns Entity)
                                                                                 ▼
                                [SERVICE] ◄──────────────────────────────────────┘
                                   │
                                   ├─► (Uses Mapper: Entity ➔ Response DTO)
                                   │
[CONTROLLER] ◄──(Returns Response DTO)─┘
   │
   │  2. HTTP Response (JSON)
   ▼
[CLIENT]

REQUEST:
Client → Controller → Service → Mapper (DTO → Entity) → Repository → Database

RESPONSE:
Database → Repository → Service → Mapper (Entity → DTO) → Controller → Client

                 MAPPER
              ↙         ↘
           Entity  ↔  DTO
             ↓           ↓
         Database       API

Entity: the full data as stored in the database (internal). "What is stored in the database?" (DB row)
DTO: the limited data that goes in or out through the API (external). "What do I want to send to the client?" (JSON shape)
Mapper: the translator that copies fields from one to the other, inside the Service. "How do I convert between them?" (copies fields)

serializaeion meaning converting a java object into a json representation. Java → JSON
Deserializaeion converting json back into a java object  JSON → Java

Deserialization Trigger: The @RequestBody annotation tells Spring Boot to deserialize incoming JSON into a Java object.

Serialization Trigger: Returning an object from a @RestController method automatically tells Spring Boot to serialize it into JSON.
AnnotationPurposeExample@JsonProperty("custom_name")Renames a field during serialization/deserializationMaps Java firstName $\leftrightarrow$ JSON first_name@JsonIgnorePrevents a field from ever being serialized or deserializedHides sensitive fields like passwordHash@JsonInclude(Include.NON_NULL)Ignores null fields during serializationKeeps output JSON clean without empty fields@JsonFormatDefines custom date or time formatting rules@JsonFormat(pattern = "yyyy-MM-dd")
Serialization (Java Object $\rightarrow$ JSON): The process of converting a backend Java object (like a DTO) into a stream of bytes or a text format (typically a JSON string) so it can be sent over the network as an HTTP Response to a browser, mobile app, or client.Deserialization (JSON $\rightarrow$ Java Object): The process of reading an incoming HTTP Request body (JSON text) and converting/parsing it back into a strongly typed Java Object (like a Request DTO) inside your Controller.

Query Parameters (or Query Strings) are key-value pairs appended to the end of a URL after a question mark (?) and separated by ampersands (&). They are used to pass non-hierarchical options—like filtering, searching, sorting, or pagination criteria—in HTTP requests (typically GET).  [https://api.example.com/users?role=admin&page=1] 
@RequestParam: Query parameters are values added to the end of a URL to send extra information to a REST API.
Query parameters are optional values in the URL used to provide additional information to an API request.

@PathVariable – Extracts values from the URL to handle requests like fetching a
product by ID
@RequestParam – Extracts query parameters from the URL, commonly used for
filtering and sorting
@RequestHeader – Reads HTTP headers, often used for authentication or
metadata.
@RequestBody – Extracts data from the request body, typically for creating or
updating resources
ResponseEntity – Customizes API responses, including status codes, headers,
and body content.
• HTTP Status Codes
• 200 OK
• 201 Created
• 400 Bad Request
• 404 Not Found

Data Transfer Objects (DTOs) – Prevent exposing database entities directly by
defining structured response objects.
• MapStruct – Automatically converts entities to DTOs without manual mapping
code.
CRUD Operations
• Creating resources (POST) – Adds new data to the database.
• Fetching resources (GET) – Retrieves data from the database, optionally with
filtering and sorting.
• Updating resources (PUT/PATCH) – Modifies existing records.
• Deleting resources (DELETE) – Removes data while handling errors properly.
• Action-Based Updates (POST) – Used for operations that modify state but don’t fit
traditional CRUD actions (e.g., changing a password).

===================
what is definition of query parameters  spring boot ?

@RequestMapping 
@RestController
@PathVariable
@RequestParam 
@RequestHeader
@RequestBody 
ResponseEntity



i am here 
https://members.codewithmosh.com/courses/spring-boot-mastering-apis/lectures/60577204
