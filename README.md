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

# Sources

- [Official documentation](https://docs.camunda.org/manual/7.17/reference/connect/) (not that good)
