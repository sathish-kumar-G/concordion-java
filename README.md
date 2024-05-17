# Concordion Overview

Concordion is a powerful open-source framework for Behavior-Driven Development (BDD) in Java. It enables teams to create executable specifications that serve as both documentation and automated tests for their software projects.

## Key Features:

### 1. Executable Specifications:
Concordion allows you to write specifications in a human-readable format (such as Markdown or HTML) that can be executed as automated tests. This ensures that your specifications remain in sync with your actual system behavior.

### 2. Living Documentation:
By keeping your specifications executable, Concordion generates living documentation that automatically reflects the current state of your system. This helps to bridge the gap between business requirements and technical implementation.

### 3. Integration-Friendly:
Concordion seamlessly integrates with various testing frameworks and libraries, making it easy to incorporate into your existing development ecosystem. It works well with tools like JUnit, TestNG, and Spring Framework.

### 4. Rich Reporting:
Concordion produces rich HTML reports that provide detailed insights into the behavior of your system. These reports make it easy to identify failures, errors, and areas for improvement.

# Concordion for Behavior-Driven Development (BDD) in Spring Boot

## Integrating Concordion with Spring Boot

### Step 1: Add Concordion Dependencies to Your Project

Add the Concordion dependencies to your `pom.xml` (if you're using Maven) or `build.gradle` (if using Gradle).

```xml
<dependencies>
    
<dependency>
    <groupId>org.concordion</groupId>
    <artifactId>concordion</artifactId>
    <version>{{version}}</version>
    <scope>test</scope>
</dependency>

<dependency>
<groupId>org.junit.vintage</groupId>
<artifactId>junit-vintage-engine</artifactId>
<version>5.9.3</version>
<scope>test</scope>
</dependency>
    
</dependencies>

<build>
<plugins>
    <plugin>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>2.19.1</version>
        <configuration>
            <systemPropertyVariables>
                <concordion.output.dir>target/concordion</concordion.output.dir>
            </systemPropertyVariables>
        </configuration>
    </plugin>
</plugins>
</build>
```

### Step 2: Write Your Concordion Specifications

Create Markdown or HTML files for your Concordion specifications. These files will contain the behavior you want to test. 
#### Here's an example in HTML format:

```html
<!DOCTYPE html>
<html xmlns:concordion="http://www.concordion.org/2007/concordion">
<head>
    <title>Create User Test</title>
    <meta charset="UTF-8"/>
</head>
<body>

<h1>Let's test the Split User Full Name functionality.</h1>


<div>
    <h3>Examples</h3>
    <table>
        <tr>
            <th>Full Name</th>
            <th>First Name</th>
            <th>Last Name</th>
        </tr>
        <tr concordion:execute="#result = split(#fullName)">
            <td concordion:set="#fullName">John Smith</td>
            <td concordion:assert-equals="#result.firstName">John</td>
            <td concordion:assert-equals="#result.lastName">Smith</td>
        </tr>
        <tr concordion:execute="#result = split(#fullName)">
            <td concordion:set="#fullName">David Peterson</td>
            <td concordion:assert-equals="#result.firstName">David</td>
            <td concordion:assert-equals="#result.lastName">Peterson</td>
        </tr>
    </table>

</div>

</body>
</html>
```

#### Here's an example in Markdown format:
```md
### [Example]



The full name [Jane Smith](- "#name") is [broken](- "#result = split(#name)") into first name [Jane](- "?=#result.firstName") and last name [Smith](- "?=#result.lastName").

### [Example]

The full name [John Smith](- "#name") is [broken](- "#result = split(#name)") into first name [John](- "?=#result.firstName") and last name [Smith](- "?=#result.lastName").
```

### Step 3: Create Test Fixtures
Create a test fixture class to execute your Concordion specifications. Annotate it with @RunWith(ConcordionRunner.class)

```java
@RunWith(ConcordionRunner.class)
@FullOGNL
public class SplittingNamesTest {
    public User split(String fullName) {
        User result = new User();
        String[] words = fullName.split(" ");
        result.setFirstName(words[0]);
        result.setLastName(words[1]);
        return result;
    }
}
```

### Step 4: Run Your Tests
When you run your tests, an HTML output file will be generated in the target/concordion folder of your project.

### Output

```html
<?xml version="1.0" encoding="UTF-8"?><html xmlns:concordion="http://www.concordion.org/2007/concordion">
<head><style>* {
  font-family: Arial;
}
body {
  padding: 32px;  
}
pre {
  padding: 6px 28px 6px 28px;
  background-color: #E8EEF7;
}
pre, pre *, code, code *, kbd {
  font-family: Courier New, Courier;
  font-size: 10pt;
}
h1, h1 * {
  font-size: 24pt;	
}
p, td, th, li, .breadcrumbs {
  font-size: 10pt;
}
p, li {
  line-height: 140%;
  max-width: 720px;
}
table {
  border-collapse: collapse;
  empty-cells: show;
  margin: 8px 0px 8px 0px;
}
th, td {
  border: 1px solid black;
  padding: 3px;
}
td {
  background-color: white;
  vertical-align: top;
}
th {
  background-color: #C3D9FF;
}
li {
  margin-top: 6px;
  margin-bottom: 6px; 
}

.example, :not(th)[concordion\:example] {
  padding: 6px 16px 6px 16px;
  border: 1px solid #C3D9FF;
  margin: 6px 0px 28px 0px;
  background-color: #F5F9FD;
}
.example h3, [concordion\:example] h3 {
  margin-top: 8px;
  margin-bottom: 8px;
  font-size: 12pt;
}

p.success {
  padding: 2px;
}
.success, .success * {
  background-color: #afa !important;
}
.success pre {
  background-color: #bbffbb;
}
.failure, .failure * {
  background-color: #ffb0b0;
  padding: 1px;
}
.failure .expected {
  text-decoration: line-through;
  color: #bb5050;
}
.ignored, .ignored * {
  background-color: #f0f0f0 !important;	
}

ins {
  text-decoration: none;	
}

.exceptionMessage {
  background-color: #fdd;
  font-family: Courier New, Courier, Monospace;
  font-size: 10pt;
  display: block;
  font-weight: normal;
  padding: 4px;
  text-decoration: none !important;
}
.stackTrace, .stackTrace * {
  font-weight: normal;
}
.stackTrace {
  display: none;
  padding: 1px 4px 4px 4px;
  background-color: #fdd;
  border-top: 1px dotted black;
}
.stackTraceExceptionMessage {
  display: block;
  font-family: Courier New, Courier, Monospace;
  font-size: 8pt;
  white-space: wrap;
  padding: 1px 0px 1px 0px;
}
.stackTraceEntry {
  white-space: nowrap;
  font-family: Courier New, Courier, Monospace;
  display: block;
  font-size: 8pt;
  padding: 1px 0px 1px 32px;
}
.stackTraceButton {
  font-size: 8pt;
  margin: 2px 8px 2px 0px;
  font-weight: normal;
  font-family: Arial;
}

.special {
  font-style: italic;
}
.missing, .missing * {
  background-color: #ff9999;
  color:#bb5050;
  text-decoration: line-through;
}
.surplus, .surplus * {
  background-color: #ff9999;
}
.footer {
  text-align: right;
  margin-top: 40px;
  font-size: 8pt;
  width: 100%;
  color: #999;
}
.footer .testTime {
  padding: 2px 10px 0px 0px;
}

.idea {
  font-size: 9pt;
  color: #888;
  font-style: italic;	
}
.tight li {
  margin-top: 1px;
  margin-bottom: 1px; 
}
.commentary {
  float: right;
  width: 200px;
  background-color: #ffffd0;
  padding:8px;
  border: 3px solid #eeeeb0;	 
  margin: 10px 0px 10px 10px;	 
}
.commentary, .commentary * {
  font-size: 8pt;
}
</style><meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <title>Create User Test</title>
    <meta charset="UTF-8" />
</head>
<style>
    body {
         font-family: Arial, sans-serif;
     }
     form {
         max-width: 400px;
         margin: 50px auto;
         background-color: #fff;
         padding: 20px;
         border-radius: 8px;
         box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
     }
     form label {
         display: block;
         font-weight: bold;
         margin-bottom: 5px;
     }
     form p {
         position: relative;
         margin-bottom: 20px;
     }
     form span {
         display: block;
         padding: 8px;
         border: 1px solid #ccc;
         border-radius: 4px;
         box-sizing: border-box;
         width: calc(100% - 18px);
     }
     form input {
         position: absolute;
         top: 0;
         left: 0;
         opacity: 0;
         width: 100%;
         height: 100%;
         padding: 8px;
         border: none;
         border-radius: 4px;
         box-sizing: border-box;
     }
     button {
         display: block;
         width: 100%;
         padding: 10px;
         background-color: #007bff;
         color: #fff;
         border: none;
         border-radius: 4px;
         cursor: pointer;
     }

    #success,#fail{
         text-align:center
    }
</style>
<body>

<h1>Let's test the Split User Full Name functionality.</h1>


<div>
    
    <h3>Examples</h3>

    <table>
        <tr>
            <th>Full Name</th>
            <th>First Name</th>
            <th>Last Name</th>
        </tr>
        <tr concordion:execute="#result = split(#fullName)">
            <td concordion:set="#fullName">John Smith</td>
            <td concordion:assert-equals="#result.firstName" class="success">John</td>
            <td concordion:assert-equals="#result.lastName" class="success">Smith</td>
        </tr>
        <tr concordion:execute="#result = split(#fullName)">
            <td concordion:set="#fullName">David Peterson</td>
            <td concordion:assert-equals="#result.firstName" class="success">David</td>
            <td concordion:assert-equals="#result.lastName" class="success">Peterson</td>
        </tr>
    </table>

</div>
</html>
```

### Advantages of Using Concordion:

- **Clarity**: Specifications are written in plain language, making them accessible to non-technical stakeholders.
- **Maintainability**: Since specifications are executable, they are more likely to be kept up-to-date with changes in the system.
- **Flexibility**: Concordion supports various parameter types, including numeric types, strings, and booleans. This flexibility allows you to handle different types of data effectively in your tests.
- **Versatile Return Types**: Methods in Concordion fixtures can return void, primitives, or objects, providing flexibility in handling test logic and data. This versatility allows you to design fixtures tailored to your specific testing requirements.
- **Test Automation**: Concordion promotes test automation by integrating specifications seamlessly into the testing process.
- **Collaboration**: By providing living documentation, Concordion encourages collaboration between business analysts, developers, and testers.



### Disadvantages of Using Concordion:

- **Learning Curve**:
  While Concordion simplifies the process of writing executable specifications, there is still a learning curve involved, especially for teams new to Behavior-Driven Development (BDD) or automated testing frameworks.

- **Complexity**: Specifying parameter types may introduce additional complexity to your fixtures, especially when dealing with multiple parameter types or complex data structures. This complexity can increase the cognitive load on developers and make the code harder to understand.

- **Maintenance Overhead**:
  Maintaining a large suite of Concordion specifications can become challenging, especially if there are frequent changes to the system under test. Keeping specifications up-to-date requires ongoing effort and coordination.

- **Integration Complexity**:
  While Concordion integrates well with various testing frameworks and libraries, setting up and configuring these integrations may require additional effort and expertise, particularly in complex development environments.

- **Limited Community Support**:
  Compared to more widely adopted testing frameworks, Concordion may have a smaller community of users and contributors. This could lead to limited resources, documentation, and community support available for troubleshooting and problem-solving.

- **Execution Speed**:
  Since Concordion specifications are executed as automated tests, the execution speed may be slower compared to traditional manual testing methods. This could impact the overall efficiency of the testing process, especially for large-scale projects.

It's essential for teams to carefully evaluate their specific project requirements, team skillsets, and available resources before deciding to adopt Concordion for their testing needs.
Concordion empowers teams to embrace BDD principles and deliver high-quality software that meets both business and technical requirements.

The output of the tests will be displayed in HTML format, showing whether the specifications passed or failed based on the assertions made.

### Conclusion
Concordion provides a seamless way to write executable specifications for your Spring Boot applications. 
By integrating Concordion into your testing framework, you can ensure that your documentation remains up-to-date and serves as 
a reliable source of truth for your project's behavior. With its integration-friendly nature, Concordion makes it easy to 
incorporate BDD principles into your Spring Boot development process.
