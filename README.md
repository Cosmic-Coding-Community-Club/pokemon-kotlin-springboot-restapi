<a name="readme-top"></a>

![Language](https://img.shields.io/badge/Language-kotlin-blue) ![Language](https://img.shields.io/badge/Framework-SpringBoot-blue) ![License](https://img.shields.io/badge/License-Apache%202%2E0-green) ![Author](https://img.shields.io/badge/Author-Jordi%20Jiménez%20Guil-green)


<br />
<div align="center">

![Logo](etc/images/pokemon.png)

<h1 align="center">Pokemon Kotlin SpringBoot Restful API</h1>
  <p align="center">
     Example of simple crud restful api using Kotlin Spring Boot application.
    <br/>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li><a href="#about-the-project">About The Project</a></li>
    <li><a href="#getting-started">Getting Started</a></li>
    <li><a href="#how-use-api">How use API</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#learning-resources">Learning Resources</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->

## About The Project

This project is a CRUD restful API example using kotlin and Springboot Application.
The layers definition is based in hexagonal architecture and DDD.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Getting Started

To start this project use gradle tasks in application.

#### How to build and run application

##### Using Intellij IDEA:

1. Import the project as Gradle project.
2. To build the project and to run app use `bootRun` task on the Gradle tool window
   (`View | Tool Windows | Gradle`).

Here https://www.jetbrains.com/help/idea/gradle.html#gradle_tasks you can read
how to run Gradle task from the Gradle toolbar in IntelliJ IDEA.

##### Using commandline

You can also build the project and run all tests in the terminal:

```
./gradlew bootRun
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## How use API

The pokemon api is published in localhost and in 8080 port.

This CRUD allows performs four types of http methods:

##### GET
Obtain pokemon using identifier (pokemon name)
```
   url: http://localhost:8080/pokemon/charmander
```

##### POST
Create pokemon
```
   url: http://localhost:8080/pokemon
   
   headers: Content-Type application/json
      
   body:
      {  
           "name":"charmander",
           "attach":12,
           "defense":31,
           "speed":23
       }
```


##### PUT
Update pokemon using identifier (pokemon name)
```
   url: http://localhost:8080/pokemon/charmander
   
   headers: Content-Type application/json
      
   body:
      {
           "name": "charmander",
           "attack" : 31,
           "defense" : 31,
           "speed": 31
       }
```

##### DELETE
Delete pokemon using identifier (pokemon name)
```
   url: http://localhost:8080/pokemon/charmander
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any
contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also
simply open an issue with the tag "enhancement".

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

**Don't forget to give the project a star! Thanks again!**

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## License

Distributed under the APACHE License. See `LICENSE-2.0.txt` for more information.
<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Contact

Jordi Jiménez Guil - info@cosmiccodingcommunityclub.com
<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Learning resources

The following resources may be helpful in your learning:

* [Official Spring Framework web](https://spring.io/)
* [Official Spring code starter](https://start.spring.io/)
* [Official Spring Boot reference docs](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
* [Restfull API convention reference docs](https://restfulapi.net/)

<p align="right">(<a href="#readme-top">back to top</a>)</p>