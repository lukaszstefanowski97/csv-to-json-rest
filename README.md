# csv-to-json-rest



**PREREQUISITES:**
- Java 8 or higher
- Spring
- Maven

**Creation of project environment**

2. Build your Maven project by typing:
    
    
        mvn install


If everything went properly you should be able to run Spring application.

CSV files are located in /src/main/resources directory. Each of them is exposed on localhost:8080 as a json file created by merging them.


        http://localhost:8080/mergedCSV
        

