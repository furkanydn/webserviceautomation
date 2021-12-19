# WebServiceAutomation

This project is an open source framework integrating java and maven and offers automatic service automatonization for api testing on a given site in REST-assured target libraries 

## Features

- Changes in configs as can't fully set up REST-assured logic.
- Logging events and levels will be more regular.
- Switch from one service provider to multiple service providers from the Maven libraries.

## Tech

TestiSelenium uses a number of open source projects to work properly:

- [REST-assured](https://github.com/rest-assured/rest-assured) - Java DSL for easy testing of REST services
- [Gson](https://github.com/google/gson/) - A Java serialization/deserialization library to convert Java Objects into JSON and back
- [JUnit 5](https://junit.org/junit5/) - Used for developer-side testing.

## Installation

WebServiceAutomation requires 
- [Maven](https://maven.apache.org/download.cgi) v3.3+ to run.
- [JDK](https://openjdk.java.net/) v1.8+ to run.


Install the dependencies and start the test.

```sh
mvn install
mvn test TrelloApiTest
```

## Development

Want to contribute?  Great!

- Create a personal fork of the project on Github.
- Clone the fork on your local machine. Your remote repo on Github is called origin.
- Add the original repository as a remote called upstream.
- If you created your fork a while ago be sure to pull upstream changes into your local repository.
- Create a new branch to work on! Branch from develop if it exists, else from master.
- Implement/fix your feature, comment your code.
- Follow the code style of the project, including indentation.
- If the project has tests run them!
- Write or adapt tests as needed.
- Add or change the documentation as needed.
- Squash your commits into a single commit with git's interactive rebase.      
- Create a new branch if necessary.
- Push your branch to your fork on Github, the remote origin.
- From your fork open a pull request in the correct branch. Target the project's develop branch if there is one, else go for master!
- Once the pull request is approved and merged you can pull the changes from upstream to your local repo and delete your extra branch(es).

## License

/ MIT /
