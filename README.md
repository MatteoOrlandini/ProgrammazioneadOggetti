# Exam

The purpose of the code is to visualize the assigned data-set and create a set of classes that represent it.
Our data-set describes a list of pharmacies.
The JAVA application has the following features:

##

**On start-up**: download the data-set (zip or csv) which contains data in CSV format starting from the address provided after decoding the JSON containing the URL useful for downloading the file.  This phase will come performed when the application is first started.

This is done by reading from a external configuration file the url and the name of the data-set destination file.
The JSON contained in the url is then scanned by the class *JSONParser* that identify the location of the second url, allowing the download the data-set.
There is a file presence check that can prevent to download an existing file.

##

**When the download is completed**: parse the data by creating appropriate data structures based on the above classes (each data-set record corresponds to an object of a class).

The class *CSVParser* is used to read and parse the CSV file and to fill a vector of *Pharmacy* and one of *Metadata*.
Each row represents a *Pharmacy* and each field of columns represents a *Metadata*.
A pharmacy is described by the following fields:
 - id (CODICEIDENTIFICATIVOSITO)
 - name (DENOMINAZIONESITOLOGISTICO)
 - address (INDIRIZZO)
 - vatNumber (PARTITAIVA)
 - postalCode (CAP)
 - cityCode (CODICECOMUNEISTAT)
 - city (DESCRIZIONECOMUNE)
 - provinceCode (CODICEPROVINCIAISTAT)
 - provinceAbbreviation (SIGLAPROVINCIA)
 - provinceName (DESCRIZIONEPROVINCIA)
 - regionCode (CODICEREGIONE)
 - regionName (DESCRIZIONEREGIONE)
 - beginValidity (DATAINIZIOVALIDITA)
 - endValidity (DATAFINEVALIDITA)
 - latitude (LATITUDINE)
 - longitude (LONGITUDINE)
 - localize (LOCALIZE)

##

**On request**: return statistics and filtered dataset using API REST GET or POST.
Afterwards the various requests that can be carried out with relevant examples will be listed.
The examples refer to the body of the POST (JSON).

GET requests:
 - **/data**
 returns all the data-set.
 - **/metadata**
 returns all the fields

POST requests:
 - **/stats**
 returns the counts of how many times a string occoured.
 It is not necessary to give any other stats for the specific dataset because only latitude and longitude and numbers.

example:

> {
    "fieldName": "beginValidity",
    "value": "01/10/2006"
}

>count : 9

- **/localize**
Using a POST request it looks in the body for a latitude, a longitude and a range (in Km) and returns those that are in the specified area. 

The formula used to calculate the distance is:
$p1 = (lon1, lat1)$ longitude and latitude in radians.
$p2 = (lon2, lat2)$ longitude and latitude in radians.
$dist = arccos( sin(lat1) * sin(lat2) + cos(lat1) * cos(lat2) * cos(lon2-lon1) ) * 6371$
(6371 in the Earth radius in Km; dist is expressed in Km).

example:

> {
    "latitude": 41.55,
    "longitude": 15.22,
    "range": 10
}

- **/filter**
 Generic filter using a POST. If the body of the JSON is a single object it searches for a field, an operator and an input value and returns the filtered dataset. If it is found an attribute called "\$or" or "\$and" it applies multiple filters to the following array of object based on the attribute. The "\$or" filter does a filter for each object and then unites them. The "\$and" filter just recursively filter the result of the previous decimation.

or:

    for (Object obj : jsonArray) {
    				filterParam.readFields(obj);
    				tempOr = pharmacyService.filter(pharmacyService.getPharmacies(), filterParam);
    				for (Pharmacy item : tempOr) {
    					if (!temp.contains(item))
    						temp.add(item);
    				} 		
    	}

and:
 

    for (Object obj : jsonArray) {
    					filterParam.readFields(obj);
    					// iteration on .filter
    					temp = pharmacyService.filter(temp, filterParam);
    				}



examples:

 1. >{
    "fieldName": "city",
    "operator": "==",
    "value": "Ancona"
}

2. >{
    "$or": [
        {
            "fieldName": "latitude",
            "operator": "<=",
            "value": "43.1"
        },
        {
            "fieldName": "provinceName",
            "operator": "==",
            "value": "Ancona"
        }
	]
}

3. >{
    "$and": [
        {
            "fieldName": "postalCode",
            "operator": "==",
            "value": "28021"
        },
        {
            "fieldName": "beginValidity",
            "operator": "<",
            "value": "02/05/2015"
        }
    ]
}

4. >{
    "$and": [
        {
            "fieldName": "regionName",
            "operator": "==",
            "value": "Puglia"
        },
        {
            "fieldName": "endValidity",
            "operator": ">",
            "value": "20/04/2012"
        },
        {
            "fieldName": "endValidity",
            "operator": "<",
            "value": "20/05/2012"
        }
    ]
}

#

[UML CLass Diagram](https://drive.google.com/open?id=1mm4TOyTvOkuXTh9-gx_YGpTbR7DFwZFr)

[UML USE Case Diagram](https://drive.google.com/open?id=14CkKrcjyybDNvNPgcg8gnntwBIUatB8H)


<!--stackedit_data:
eyJoaXN0b3J5IjpbMTM3NTU4MDA4NF19
-->