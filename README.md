# stock-project
Stock Project, a basic web service implementing REST API, is built with Spring Boot framework of version 3.<br>
I am going to explain briefly about the following details.
- Setting
- Implementation
- Testing CRUD operations

# 1. Setting
One of the choices to start a Spring Boot is to enter https://start.spring.io/ and select the following<br>
(1) packages/libraries manager: Maven or Gradle<br>
(2) Language<br>
(3) JDK version<br>
(4) Project Metadata: <b>Group</b> represents company's name, <b>Artifact</b> represents your project's name.
(4) dependencies (also know as libraries if you are working with other languages)

Alternatively, developers can generate the project structure locally on their machine rather than utilizing Spring Initialzr's web interface.

It is worth paying attention to choosing <b>dependencies</b>. I choose <b>`Spring Web`</b> and <b>`Lombok`</b> for this project.<br>
The Spring Web dependency serves as a container that come with what I need to build a web service and REST API, especially built-in web server like Apache Tomcat.<br>
Note that there is another way of 
The installation process downloads all dependencies, resulting in the following folder structure, which is the standard folder structure of Maven.

'<br>
'---src<br>
'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'---main<br>
'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'&nbsp;&nbsp;&nbsp;&nbsp;'---java<br>
'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'&nbsp;&nbsp;&nbsp;&nbsp;'&nbsp;&nbsp;&nbsp;&nbsp;'---Main.java<br>
'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'&nbsp;&nbsp;&nbsp;&nbsp;'<br>
'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'&nbsp;&nbsp;&nbsp;&nbsp;'---resources<br>
'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'&nbsp;&nbsp;&nbsp;&nbsp;'&nbsp;&nbsp;&nbsp;&nbsp;'---static<br>
'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'&nbsp;&nbsp;&nbsp;&nbsp;'&nbsp;&nbsp;&nbsp;&nbsp;'---template<br>
'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'&nbsp;&nbsp;&nbsp;&nbsp;<br>
'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'---test<br>
'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'---java<br>
'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'&nbsp;&nbsp;&nbsp;&nbsp;'---Test.java<br>
'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
'---pom.xml<br>
'---.mvn<br>
'---mvnw.cmd<br><br>
mvnw.cmd and '

`mvnw.cmd` and `.wvn` are Maven file, with which I do not need to install Maven by myself. Maven is neccessary for building a project.<br>
`pom.xml` is the collection of package configuration in XML format.<br>
For example, spring-boot-starter-web will be defined, which contains built-in Apache Tomcat in it.
```
<dependency>  
    <groupId>org.springframework.boot</groupId>  
    <artifactId>spring-boot-starter-web</artifactId>  
</dependency>  
```
<br>
<h1>2. Implementation</h1>
<br>This project facilitates stocking tracking through CRUD operations. View this project as MVC concept.<br>
M (Model) -> handling business logic-related data.
V (view) -> means user interface which is not implemented in this project.
C (controller) -> handle interactions and inputs.
<br>
In Model, there are implementations of POJO Java Product class with field variables.
<br>


```
public class Product {
    private long id;
    private String name;
    private String image;
    private int price;
    private int stock;
}
```
<br>
`id` is a unique identifier<br>`name` is product name<br>`image` is an image of the product<br>`price` is price value<br>`stock` is available stock<br>
Later at the end, I will change the data type of `image` from String to <b>`MultiPartFile`</b>, a Spring Boot library that handles file uploading. 
<br><br>
In <b>Controller</b>, there are implementations of methods related to CRUD operations and HTTP method to handle interactions and inputs.<br>
For example, the `addProduct` method expects a JSON payload containing attributes: product id, product name, image, price value, and stock quantity<br>

```
@PostMapping("/product")
    public Product addProduct(@RequestBody Product product){
        // @RequestBody does mapping between model and JSON
        // get param and return as JSON
        
        Product data = new Product(counter.incrementAndGet(), product.getName(), 
                                   product.getImage(), product.getPrice(), product.getStock());
        products.add(data);
        return product;
    }
```

<br><br>
As mentioned ealier, I change the data type of image from String to MultiPartFile. Image files are uploaded and a folder named images is created to store the images.

<img src="https://github.com/mratchapol/stock-project/blob/021ed3f868f9da07996d5cc7370b4b33d5c3e733/readme-images/images.png" width="600">
<img src="https://github.com/mratchapol/stock-project/blob/fab560c162e533ba2c4d5a3bf053b41135bd4f27/readme-images/images-folder.png" width="600">

# 3. Testing
In this section, CRUD operations are tested.<br>This is the POST HTTP method, sending data to the server. The requested parameters are sent into the program. You can see that the image parameter accepts a file-type input.<br><br>
<img src="https://github.com/mratchapol/stock-project/blob/fab560c162e533ba2c4d5a3bf053b41135bd4f27/readme-images/POST-1.png" width="600"><br><br>
After doing POST, I try doing GET to display the stock.<br><br>
<img src="https://github.com/mratchapol/stock-project/blob/fab560c162e533ba2c4d5a3bf053b41135bd4f27/readme-images/GET.png" width="600"><br><br>
Then I try deleting the product of id 2 from the stock.<br><br>
<img src="https://github.com/mratchapol/stock-project/blob/fab560c162e533ba2c4d5a3bf053b41135bd4f27/readme-images/DELETE.png" width="600"><br><br>
After deletion, I do GET again to ensure the product of id 2 is removed.<br><br>
<img src="https://github.com/mratchapol/stock-project/blob/fab560c162e533ba2c4d5a3bf053b41135bd4f27/readme-images/GET-2.png" width="600">

