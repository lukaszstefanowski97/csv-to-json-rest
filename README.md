# csv-to-json-rest



**PREREQUISITES:**
- [Node.js](https://nodejs.org/en/)
- [csvtojson](https://www.npmjs.com/package/csvtojson)
- Java
- Maven

**Creation of project environment**

1. Please install csvtojson package. You can do it by typing:

    
        npm i -g csvtojson
    
    
        In some cases you may need sudo option.
    


2. Build your Maven project by typing:
    
    
        mvn install



If everything went properly you should be able to run Spring application.

CSV files are located in /data directory. Each of them is exposed on localhost:8080 alongside with json file created by merging them.


        http://localhost:8080/attributes
        
        http://localhost:8080/options
        
        http://localhost:8080/merged

