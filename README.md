
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
│                   │   │   │   ├── DVDLibraryDao.java
│                   │   │   │   ├── DVDLibraryDaoException.java
│                   │   │   │   └── DVDLibraryDaoFileImpl.java
│                   │   │   └── DVDLibraryController.java
│                   │   ├── dto
│                   │   │   └── DVD.java
│                   │   └── ui
│                   │       ├── DVDLibraryView.java
│                   │       ├── UserIO.java
│                   │       └── UserIOConsoleImpl.java
│                   └── App.java
├── library.txt
└── pom.xml
```

## Getting Started

```javascript
yarn
```

## To start the app
```javascript
npm start
```

### Routes

* http://localhost:4000
* http://localhost:4000/api

GET
* http://localhost:4000/api/wolves

POST
* http://localhost:4000/api/wolves/Coyote

---
Made with ♥ by Chetan
