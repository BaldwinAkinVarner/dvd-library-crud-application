
# dvd-library-crud-application

This is a simple CRUD application that represents a physical DVD Library. See directory and description below for more details on project file purposes.

## Directory Layout

```bash
.
├── src
│   ├── main
│       ├── java
│           ├── com
│               ├── sg
│                   ├── dvdlibrary
│                   │   ├── controller
│                   │   │   ├── dao
│                   │   │   │   ├── DVDLibraryDao.java              // DAO Interface
│                   │   │   │   ├── DVDLibraryDaoException.java     // DAO Exceptions
│                   │   │   │   └── DVDLibraryDaoFileImpl.java      // DAO Implementation
│                   │   │   └── DVDLibraryController.java           // Application Controller
│                   │   ├── dto
│                   │   │   └── DVD.java                            // DVD Object
│                   │   └── ui
│                   │       ├── DVDLibraryView.java                 // Application View
│                   │       ├── UserIO.java                         // I/O Interface
│                   │       └── UserIOConsoleImpl.java              // I/O Implementation
│                   └── App.java                                    // Entry Point
├── library.txt                                                     // Read/Write File
└── pom.xml                                                         // Configuration File
```

## Description

This project is a CRUD Application built using Maven meant to represent a physical DVD Library. The application follows MVC Architecture. The application configurations can be changed using the pom.xml file in the root directory.

## To start the app

Compile and rund the App.java file nested inside of the source folder. 

---
Made by Baldwin-Akin Varner

##### This project was done through Wiley Edge Academy as part of a bootcamp