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

# Sources

- [Official documentation](https://docs.camunda.org/manual/7.17/reference/connect/) (not that good)
