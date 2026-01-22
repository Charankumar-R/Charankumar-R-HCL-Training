# Charankumar-R-HCL-Training

This repository contains a collection of Java projects demonstrating various testing frameworks, automation techniques, and Java programming concepts. These projects were developed as part of HCL training.

## Project Structure

### 📁 BDD_SauceDemo
**Behavior-Driven Development (BDD) testing project for SauceDemo application**

A comprehensive BDD framework implementation using Cucumber and Selenium WebDriver for testing the SauceDemo web application. This project demonstrates test automation best practices with Gherkin feature files and step definitions.

- **Framework**: Cucumber, TestNG, Selenium WebDriver
- **Reports**: Cucumber HTML reports, Extent Reports
- **Location**: `BDD_SauceDemo/`

### 📁 Flipkart
**Selenium-based automation framework for Flipkart application testing**

An automation testing framework for the Flipkart e-commerce platform using Selenium WebDriver with Maven as the build tool.

- **Framework**: Selenium WebDriver, Maven
- **Focus**: Web automation, page interactions
- **Location**: `Flipkart/`

### 📁 Java_Contents
**Core Java programming concepts and examples**

A collection of fundamental Java programs covering essential programming concepts including basic programs, collections, exception handling, OOP principles, regular expressions, Selenium programs, and streams.

- **Topics**:
  - Basic Programs
  - Collections Framework
  - Exception Handling
  - Object-Oriented Programming (OOPS)
  - Regular Expressions (Regex)
  - Selenium Programming
  - Java Streams API
- **Location**: `Java_Contents/`

### 📁 POM_SauceDemo
**Page Object Model (POM) implementation for SauceDemo testing**

A well-structured automation framework implementing the Page Object Model pattern for testing the SauceDemo application. This project demonstrates best practices in test code organization and maintainability.

- **Framework**: Selenium WebDriver, TestNG, Maven
- **Pattern**: Page Object Model
- **Reports**: Extent Reports, TestNG reports
- **Location**: `POM_SauceDemo/`

### 📁 sauceDemoPageFactory
**Page Factory pattern implementation for SauceDemo application**

An advanced automation framework using the Page Factory pattern with Selenium WebDriver to test the SauceDemo application. This project showcases modern element location and initialization techniques.

- **Framework**: Selenium WebDriver, Page Factory, TestNG, Maven
- **Structure**: Object Repository, Page Classes, Test Classes, Utilities
- **Reports**: Extent Reports, TestNG reports
- **Location**: `sauceDemoPageFactory/`

### 📁 Selenium
**Comprehensive Selenium WebDriver automation framework**

A complete Selenium WebDriver automation framework with multiple test scenarios, screenshot capabilities, and reporting features.

- **Framework**: Selenium WebDriver, TestNG, Maven
- **Features**: Screenshots, ExtentReports, Logging
- **Reports**: Extent Reports, TestNG reports
- **Location**: `Selenium/`

## Common Technologies Used

- **Languages**: Java
- **Build Tool**: Maven
- **Testing Frameworks**: TestNG, Cucumber
- **Automation**: Selenium WebDriver
- **Reporting**: Extent Reports, Cucumber Reports, TestNG Reports

## Getting Started

Each project is a Maven-based Java application. To run any project:

1. Navigate to the project folder
2. Run: `mvn clean install`
3. Execute tests: `mvn test`

## Project Reports

Each project generates test reports in:
- `target/` - Maven build artifacts
- `test-output/` - TestNG reports
- `reports/` - Extent Reports and custom reports

---

For detailed information about each project, refer to the individual project folders.
