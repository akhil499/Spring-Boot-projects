This is a simple springboot project with two endoints to add and list users.

Database used is MySQL. MySQL DB is hosted on https://aiven.io/ 

To run this in a docker container do the following:

1. Go to the project directory where the Dockerfile is created and run the command:
   docker build -t your-app-name .

2. Below command will run the docker container:
   docker run -p 8080:8080 your-app-name
