# stock-project

Stock Project, a basic web service implementing REST API, is built with Spring Boot framework of version 3.<br>
I am going to explain briefly about the following details.
- Preparation
- Packages
- Features

# 1. Preparation
One of the choices to start a Spring Boot is to enter https://start.spring.io/ and select<br>
(1) packages/libraries manager: Maven or Gradle<br>
(2) Language<br>
(3) JDK version<br>
(4) dependencies (also know as libraries if you are working with other languages)

It is worth paying attention to choosing dependencies. I choose <b>Spring Web</b> and <b>Lombok</b> for now.<br>
They serve as containers that come with what I need to build web service and REST API, especially built-in web server like Apache Tomcat.<br>
After the dependencies are downloaded, you will find the folder structure like this. It is standard folder structure of Maven.

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
'---.mvn<br>
'---mvnw.cmd<br>
mvnw.cmd และ .wvn ที่ถูกดาวน์โหลดมาด้วยนี้คือ Maven โปรเจคจะทำงานด้วย Maven ที่ Spring Initializer ให้มา ในกรณีที่เครื่องของเราไม่เคยหรือไม่มี Maven ติดตั้งอยู่ 
