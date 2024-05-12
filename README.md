# library-management
## Prerequisites
Before you begin, ensure you have Docker installed on your local machine. Download and install Docker from [Docker's official website](https://www.docker.com/products/docker-desktop).

## Local Setup

### 1. Pull the MySQL Docker Image
Start by pulling the latest MySQL image from Docker Hub. Open your terminal and run the following command:
```
docker pull mysql:latest
```
### 2. Start MySQL conatiner
Start a MySQL container with predefined configurations by executing the command below:
```
docker run --name db-mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=librarymanagement -e MYSQL_USER=user -e MYSQL_PASSWORD=pass123 -p 3306:3306 -d mysql
```
### 3. Fill environment variables
Fill in the environment variables which are referenced in the application.properties:
* url - this will be your db url, for the container with mysql run with the previous commands on your local it will be: jdbc:mysql://localhost:3306/librarymanagement
* user - your mysql user which will be "user" for the previous commands
* password - your mysql password setup in the previous command. 

