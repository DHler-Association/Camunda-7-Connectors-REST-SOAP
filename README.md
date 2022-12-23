# Camunda-7-Connectors-REST-SOAP

Camunda 7 Application making REST and SOAP Calls in Java code (CallWebserviceDelegate.java) or in the Model itself (TwitterQAProcess.bpmn).

The standart behavior is a REST Call via Java code. Adjust the comments in the CallWebserviceDelegate.java file to switch between different Calls in Java Code.

To utelize REST and SOAP calls in the modeler itself, adjust the arrow in the center.

![image](https://user-images.githubusercontent.com/101417551/209144285-9dfc1fc3-4e25-4b1b-a44c-fb00619dc0be.png)

# Possibilities

- Modeler
  - REST Connector
  - SOAP Connector
- Java Code
  - REST Connector via method calls
  - REST Connector via generic API
  - SOAP Connector via mehtod calls
  - SOAP Connector via generic API
  
The effect is mostly the same. Response processing is simpler in Java Code.

# Specification of Connectors in Camunda Modeler

## SOAP-Connector

### Implementation

![image](https://user-images.githubusercontent.com/101417551/209148564-28725146-fcd0-4e89-8cb9-f490a541b9f3.png)

### Connector Inputs

![image](https://user-images.githubusercontent.com/101417551/209148018-aa5ce8ba-4ec2-4bf2-aaae-76fd80c673ef.png)

### Connector Outputs

![image](https://user-images.githubusercontent.com/101417551/209148095-700ae305-3fc8-48fd-9897-ce7c70085bc5.png)

## REST-Connector

### Implementation

![image](https://user-images.githubusercontent.com/101417551/209148608-28ea1752-2558-42be-b725-b33effcea30a.png)

### Connector Inputs

![image](https://user-images.githubusercontent.com/101417551/209148244-5dab89e9-a860-4177-a231-0838cd513e01.png)

### Connector Outputs

![image](https://user-images.githubusercontent.com/101417551/209148286-ea40724e-3244-4162-b3db-5f073588d53f.png)

# Features in the Java Code version

## Maven dependencies

Although the Camunda documentation says that only the top two dependencies are necessary, the process only runs through without errors, if all four dependencies have been added to the pom.

```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>org.camunda.connect</groupId>
      <artifactId>camunda-connect-bom</artifactId>
      <scope>import</scope>
      <type>pom</type>
      <version>1.5.6</version>
    </dependency> 
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>org.camunda.connect</groupId>
    <artifactId>camunda-connect-core</artifactId>
    </dependency>
	
  <dependency>
    <groupId>org.camunda.connect</groupId>
    <artifactId>camunda-connect-connectors-all</artifactId>
  </dependency>
	
  <dependency>
    <groupId>org.camunda.bpm</groupId>
    <artifactId>camunda-engine-plugin-connect</artifactId>
  </dependency>

  <dependency>
    <groupId>org.camunda.bpm</groupId>
    <artifactId>camunda-engine-plugin-spin</artifactId>
  </dependency>
  
</dependencies>
```

## REST 

### Create HttpConnector

```java
HttpConnector connector = Connectors.getConnector(HttpConnector.ID);
```

### Create HttpRequest

```java
HttpRequest request = connector.createRequest();
```

### Edit the HttpRequest Object

#### Via method calls

```java
.post()
.get()
.url("http://camunda.org")
.contentType("text/plain")
.payload("Hello World!")
.header("Accept", "application/json")
```

#### Via generic API

```java
.setRequestParameter("method", "GET")
.setRequestParameter("url", "http://camunda.org")
.setRequestParameter("payload", "hello world!")
```

### Execute HttpRequest

HttpResponse response = request.execute()

### Get data from HttpResponse Object

#### Via method calls

```java
.getStatusCode()
.getHeader("Content-Type")
.getResponse()
```

#### Via generic API

```java
.getResponseParameter("statusCode")
.getResponseParameter("headers")
.getResponseParameter("response")
```

### Close HttpResponse Object after processing

```java
.close()
```

## SOAP

### Create SoapHttpConnector 

```java
SoapHttpConnector soap = Connectors.getConnector(SoapHttpConnector.ID);
```

### Create SoapHttpRequest

```java
SoapHttpRequest request = connector.createRequest();
```

### Edit the SoapHttpRequest Object

#### Via method calls

```java
.url("http://camunda.org/soap")
.soapAction("doIt")
.contentType("application/soap+xml")
.header("Accept", "application/xml")
.payload(soap_envelope)
```

#### Via generic API

```java
.setRequestParameter("method", "GET")
.setRequestParameter("url", "http://camunda.org")
setRequestParameter("payload", "hello world!")
```

### Execute SoapHttpRequest

SoapHttpResponse response = request.execute()

### Get data from SoapHttpResponse Object

#### Via method calls

```java
.getStatusCode()
.getHeader("Content-Type")
.getResponse()
```

#### Via generic API

```java
.getResponseParameter("statusCode")
.getResponseParameter("headers")
.getResponseParameter("response")
```

### Close HttpResponse Object after processing

```java
.close()
```

## Extending connect

https://docs.camunda.org/manual/7.17/reference/connect/extending-connect/

# Sources

- [Official documentation](https://docs.camunda.org/manual/7.17/reference/connect/)
