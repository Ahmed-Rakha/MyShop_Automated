# Automation Website Test Project

This repository contains automated tests for E-commerce website using Selenium WebDriver and TestNG. The framework provides reusable components for performing various test actions
such as logging in, navigating between pages, filling up forms, and verifying form submissions.

## Table of Contents
- [Introduction](#introduction)
- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Running Tests](#running-tests)


## Introduction

This project aims to automate the testing of "**My Shop**" Website to ensure its functionality is working as expected. The tests are written in Java using Selenium WebDriver and
TestNG framework.Besides generating fake data in test cases using third party liberary "Faker". 

## Mechanism used: 
In this project I used:
1- design patterns like POM & Fluent Interface.
2- Also I used a data provider making my test cases more organized and easier to maintain.
3- WAITS 
4- Error Handling
5- Third party liberaries for fake random data. 

## Prerequisites

Before running the tests, make sure you have the following installed on your machine:
- Java Development Kit (JDK)
- Maven
- WebDriver-compatible browser (e.g., Chrome, Firefox)
- Access to the website: http://www.automationpractice.pl/index.php
- Dependencies: Selenium WebDriver & TestNG & Faker (for generating fake data in test cases)
  
## Setup

1. Clone the Repository:git clone https://github.com/Ahmed-Rakha/MyShop_Automated
2. Import Project into IDE: Open your preferred IDE and import the cloned project as a Maven or Gradle project.
3. Download WebDriver Executable: Download the WebDriver executable for your desired browser and place it in a directory accessible to your project.
4. Update WebDriver Path:Update the WebDriver path in the BaseTest class to point to the location of the WebDriver executable on your system.
5. Install Dependencies.

## [Running Tests](#running-tests): 


1. BaseTest: This class sets up the WebDriver instance before each test and navigates to the specified website URL.
2. LoginPage: Represents the page where users can log in. It provides methods for logging in and verifying successful login.
3. Authentication_Page: Represents the authentication page. It provides methods for checking email patterns and navigating to the sign-up form.
4. SignUpForm: Represents the sign-up form page. It provides methods for filling up the form and verifying successful submission or error messages.
5. TestLoginPage: Contains test cases related to the login functionality, such as testing navigation to the authentication page and checking for broken URLs.
6. TestAuthenticationPage: Contains test cases related to the authentication page, such as testing email pattern validation.
7. TestSignUpForm: Contains test cases related to the sign-up form, such as testing form submission with valid and invalid data.

Author,
Ahmed Rakha 
