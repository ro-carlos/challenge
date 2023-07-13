<br/>
<p align="center">
  <a href="https://github.com/ro-carlos/challenge">
    <img src="https://upload.wikimedia.org/wikipedia/commons/d/d5/Selenium_Logo.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">Challenge</h3>

  <p align="center">
    Custom Automation Framework
    <br/>
    <br/>
    <a href="https://github.com/ro-carlos/challenge"><strong>Explore the docs »</strong></a>
    <br/>
    <br/>
  </p>
</p>

![Downloads](https://img.shields.io/github/downloads/ro-carlos/challenge/total) ![Contributors](https://img.shields.io/github/contributors/ro-carlos/challenge?color=dark-green) ![Issues](https://img.shields.io/github/issues/ro-carlos/challenge) ![License](https://img.shields.io/github/license/ro-carlos/challenge) 

## Table Of Contents

* [About the Project](#about-the-project)
* [Built With](#built-with)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Usage](#usage)
* [Authors](#authors)

## About The Project

![Screen Shot](https://drive.google.com/uc?export=view&id=1Ioi2nQvrn--pz3Tq1_3RW5Riq4K8AVpX)

This is an automation framework to run test cases using selenium and java.

## Built With

Java 11, Selenium 4.8.0, TestNG 7.7.1

## Getting Started

You just need the Java 11 version on your local machine.

### Prerequisites

Install Java 11.

* java

_Check Oracle, please refer to the [Java Versions](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)_

### Installation

1. Clone the repo

```sh
git clone https://github.com/ro-carlos/challenge.git
```

2. Install Maven Packages

```sh
mvn clean install
```

## Usage

1. Run all the unit test classes.
```sh
mvn test
```

2. Run a single test class.
```sh
mvn -Dtest=HomeTest test
```

 3. Run multiple test classes.
```sh
mvn -Dtest=HomeTest,CodingChallengeTest test
```

 4. Run a single test method from a test class.
```sh
mvn -Dtest=HomeTest#verifyPageTitleTest test
```

## Authors

* **Carlos Rodríguez** - *Software Engineer* - [Carlos Rodríguez](https://github.com/ro-carlos/) - *Challenge*

