# csv-to-json-rest



**PREREQUISITES:**
- Java 8 or higher
- Spring
- Maven

**Creation of project environment**

Build your Maven project by typing:
    
    
        mvn install


If everything went properly you should be able to run Spring application.

CSV files are located in /src/main/resources directory. Each of them is exposed on localhost:8080 as a json file created by merging them.

You can receive it from endpoint:

        http://localhost:8080/mergedCSV
        

