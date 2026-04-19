# Smart Campus API

## Overview

This project is a RESTful API developed for managing smart campus data such as sensors and rooms.
It is built using Java and JAX-RS (Jersey) and follows a simple architecture using an in-memory data store.

---

## Features

* Manage sensors
* Manage sensor readings
* REST API endpoints
* Lightweight design (no database, uses DataStore)

---

## Technologies Used

* Java
* JAX-RS (Jersey)
* Maven

---

## Project Structure

```id="g7t3la"
src/
 └── main/
     └── java/
         └── com/example/smartcampus/
```

---

## How to Run

1. Clone the repository:

```id="9o5xrf"
git clone https://github.com/your-username/smart-campus-api.git
```

2. Open the project in your IDE (NetBeans / IntelliJ)

3. Run the main class:

```id="j2c8nv"
SmartCampusAPI.java
```

4. The server will start on:

```id="d2m6aa"
http://localhost:8080/
```

---

## Notes

* This project uses an in-memory data store (DataStore), so data will reset when the server restarts.
* Developed as part of coursework.

---

## Author

Burak Artkın
BSc Computer Science, University of Westminster
