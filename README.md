# bottlesofbeer

The project is the build a script that efficiently build the lyrics of the song "99 Bottles of
beer"
For the record, here are the lyrics http://www.99-bottles-of-beer.net/lyrics.html

# Repo state
|Service|State|
|-------|----:|
|CI|Master [![CircleCI](https://circleci.com/gh/foutoucour/bottlesofbeer/tree/master.svg?style=shield)](https://circleci.com/gh/foutoucour/bottlesofbeer/tree/master) Dev [![CircleCI](https://circleci.com/gh/foutoucour/bottlesofbeer/tree/dev.svg?style=shield)](https://circleci.com/gh/foutoucour/bottlesofbeer/tree/dev)|
|Code Quality|[![Codacy Badge](https://api.codacy.com/project/badge/Grade/5fe9b22b3f214927bf25c200421e10e5)](https://www.codacy.com/app/kender-jr/bottlesofbeer?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=foutoucour/bottlesofbeer&amp;utm_campaign=Badge_Grade)|

# How to

The project is managed by [Maven](https://maven.apache.org/). Follow the instructions of the
official website to install maven on your environment.

## Build & Test

No special instruction for this steps. The project follows the common way to use maven:

    ?> mvn package

## Execute the script

The execution of the script should be done using maven, to ease the setup of the environment.
While being in the root folder of the project:

    ?> mvn exec:java -Dexec.mainClass="coveo.qatest.Main" -s "./pom.xml"


