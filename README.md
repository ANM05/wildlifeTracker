## Wildlife Tracker

#### By:
Antony Ng'ang'a
#### App Description
A java spark app for the Forest Service to conduct an environmental impact study and record number of animals listing whether they are endangered or not.

#### Technologies and frameworks used
* 1. java 11
* 2. spark core 2.12
* 3. Gradle 4.10
* 4. Spark Template Velocity
* 5. Junit 5
* 6. Postgres database
#### Database setup.
In PSQL:

* CREATE DATABASE wildlife_tracker;
* CREATE TABLE animals(id SERIAL PRIMARY KEY,name varchar, endangered boolean, age varchar);
* CREATE TABLE sightings(id SERIAL PRIMARY KEY, rangername varchar , location varchar, spotted timestamp, animalid int);
#### Testing
Use junit testing framework with the command below:
* gradle test
#### App setup Instructions
Follow the following instructions to run the application:
* clone this repo https://github.com/ANM05/wildlifeTracker
* cd into the cloned directory
* Open with preferred java text editor incase you are interested in making some modifications
* Run the application using gradle

#### Contact Details
Incase of any questions or comments you can reach me: @antonynganga05@gmail.com

Copyright (c) 2019 Antony Ng'ang'a

#### License
[MIT](https://choosealicense.com/licenses/mit/)
