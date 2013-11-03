# Djavu

## Development Notes

This project consists of two other sub projects:

###djavu-web
Client-side AngularJS application.
In order to build and run this project, follow the steps:
- npm install
- bower install
- grunt server
- [http://localhost:9000](http://localhost:9000)

For production, run task "grunt build" and point your server to djavu-web/dist directory.

###djavu-core
Java spring web application for RESTful services.
For development, there are two options for running:
- gradle run (starts embedded tomcat and deploys it)
- gradle tomcatRunWar (uses gradle tomcat plugin to run and deploy in a tomcat server)

Available at [http://localhost:5000](http://localhost:5000)
