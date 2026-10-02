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
===================

MVC 
REST API and API
Tempate engine thymeleaf
HTTP methods and url headers body status and sever side rendering (ssr) and client side rendering (csr)
itrable 

