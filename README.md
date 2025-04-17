# Papyrus Query API
API for Papyrus Query Web Application to Search Wikipedia Documents Using Advanced Querys With Elasticsearch

# Getting Started



### 1 - Start ElasticSearch Docker Container
```bash
docker compose up -d
```

### 2 - Populate the Database
```bash
make populate_database
```
### Obs: Make shure the `./mvnw` executable have the right permissions
```bash
chmod +x ./mvnw
```

### 3 - Start the application
```bash
./mvnw spring-boot:run
```

### 4 - Acces the API Docs in Swagger URL to see more about the endpoints
```bash
http://localhost:8080/swagger/index.html
```