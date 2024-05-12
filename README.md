# library-management
Local Startup:
You need to have the local mysql db. You can set it up with Docker:
docker pull mysql:latest
docker run --name db-mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=librarymanagement -e MYSQL_USER=user -e MYSQL_PASSWORD=pass123 -p 3306:3306 -d mysql
Fill in the environment variables which are referenced in the application.properties:
url - this will be your db url, for the container with mysql run with the previous commands on your local it will be: jdbc:mysql://localhost:3306/librarymanagement
user - your mysql user which will be "user" for the previous commands
password - your mysql password setup in the previous command. 
