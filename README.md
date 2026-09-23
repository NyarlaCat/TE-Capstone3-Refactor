# National Park Capstone (TE-Capstone3)

A full-stack Spring MVC web application displaying information about U.S. National Parks with weather forecasts. Originally created as part of the Tech Elevator coding bootcamp (2019).

## Table of Contents

- [Requirements](#requirements)
- [Getting started](#getting-started)
- [Initial Setup](#initial-setup)
- [Running the Application](#running-the-application)
- [Database Reset](#database-reset)
- [Architecture Overview](#architecture-overview)
- [Testing](#testing)

---

## Requirements

| Dependency | Version | Purpose |
|------------|---------|---------|
| Java JDK | 8 (1.8.x) | Compilation & runtime |
| Maven | 3.x | Build tool |
| PostgreSQL | 9.x or higher | Database backend |
| Git | 2.x | Repository cloning |

---

## Getting started

### Install dependencies  
Note that these instructions are for macOS

1. Install Homebrew (if not already installed)
```
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```

2. Install and setup JDK 8 (Temurin from Adoptium)
```bash
brew install --cask temurin@8
export JAVA_HOME=$(/usr/libexec/java_home -v 1.8)
echo 'export JAVA_HOME=$(/usr/libexec/java_home -v 1.8)' >> ~/.zshrc
echo 'export PATH="$JAVA_HOME/bin:$PATH"' >> ~/.zshrc
```

3. Install Maven
```bash
brew install maven
```

4. Install and setup PostgreSQL
```bash
brew install postgresql@16
brew services start postgresql@16
echo 'export PATH="/usr/local/opt/postgresql@16/bin:$PATH"' >> ~/.zshrc
source ~/.zshrc
```

5. Git
```bash
brew install git
```

### Initial Setup
1. Clone the Repository
```bash
git clone https://github.com/NyarlaCat/TE-Capstone3.git
cd TE-Capstone3
```

2. Ensure PostgreSQL is Running

```bash
brew services start postgresql@16
# pg_isready if the command returns "accepting connections"
```


3. Create the Application Database
```bash
createdb npgeek
psql -d npgeek -f database/npgeek.sql
```

4. Create Application User & Grant Permissions
The application config expects a user named postgres with password postgres1.

    Create the user (connects as default superuser)
    ```bash
    psql -d postgres -c "CREATE USER postgres WITH PASSWORD 'postgres1';"
    psql -d postgres -c "GRANT ALL PRIVILEGES ON DATABASE npgeek TO postgres;"
    ```

    Grant schema/table permissions (run from your OS superuser)
    ```bash
    psql -d npgeek -c "GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO postgres;"
    psql -d npgeek -c "GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO postgres;"
    psql -d npgeek -c "ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON TABLES TO postgres;"
    psql -d npgeek -c "ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON SEQUENCES TO postgres;"
    ```

5. Verify Database Connection
```bash
PGPASSWORD=postgres1 psql -h localhost -d npgeek -U postgres -c "SELECT COUNT(*) FROM park;"
# Expected output: 10

PGPASSWORD=postgres1 psql -h localhost -d npgeek -U postgres -c "SELECT COUNT(*) FROM weather;"
# Expected output: 50
```

6. Build the Application
```bash
mvn clean package -DskipTests
# Expected output includes [INFO] BUILD SUCCESS
```

## Running the Application
### Starting the Java backend

1. Ensure PostgreSQL is running
```bash
brew services start postgresql@16 
```

2. Launch the server
```bash
java -jar target/dependency/webapp-runner.jar target/m3-java-capstone-1.0.war
```

3. Wait for Tomcat startup log
Wait for terminal to say Tomcat started on port(s): 8080

5. To stop the server 
Press `Ctrl+C` in the terminal

**Note**  
The original Spring MVC project can be viewed at `http://localhost:8080/`. 

#### Rebuilding After Code Changes
If you modify any .java files or pom.xml you must rebuild the running application to see the changes take effect.

1. Recompile the code 
```bash
mvn clean package -DskipTests
```

2. Restart the server
```bash
java -jar target/dependency/webapp-runner.jar target/m3-java-capstone-1.0.war
```

### Starting the Vite front end
1. Change directories to `npgeek-app`

2. If this is the first time running, install dependencies
```bash
npm ci
```

3. Start the project
```bash
npm run dev
```
## Database Reset
Use this to wipe all data and restore the original state.

1. Ensure PostgreSQL is running
```bash
brew services start postgresql@16
```

2. Drop the database
```bash
psql -c "DROP DATABASE IF EXISTS npgeek;"
```

3. Recreate and load fresh data
```bash
createdb npgeek
psql -d npgeek -f database/npgeek.sql
```

4. Verify the data has been removed
```bash
PGPASSWORD=postgres1 psql -h localhost -d npgeek -U postgres -c "SELECT COUNT(*) FROM park;"
```

## Architecture Overview
```
┌─────────────────────────────────────────────────────────────┐
│                     Frontend (JSP)                          │
│               src/main/webapp/WEB-INF/jsp/                  │
│                   .jsp files (views)                        │
└─────────────────────────────────────────────────────────────┘
                           ↓
┌─────────────────────────────────────────────────────────────┐
│              Spring MVC Controllers                         │
│         src/main/java/com/techelevator/npgeek/controller/   │
└─────────────────────────────────────────────────────────────┘
                           ↓
┌─────────────────────────────────────────────────────────────┐
│              Data Access Layer (DAO)                        │
│   src/main/java/com/techelevator/npgeek/model/*Dao.java     │
└─────────────────────────────────────────────────────────────┘
                           ↓
┌─────────────────────────────────────────────────────────────┐
│                PostgreSQL Database                          │
│                    localhost:5432/npgeek                    │
│           Tables: park, weather, survey_result              │
└─────────────────────────────────────────────────────────────┘
```

## Testing
### Frontend
This project uses React Testing Library to test front end code. Make sure to save test files in directories called `tests` and that the test file name is `ComponentName.test.tsx` or `correspondingFileName.test.ts`. It must contain `test` before the file extension.

### Running tests
From within npgeek-app directory run:

```bash
# To run all tests
npm run test

# To run one test
npm run test FileName.test.tsx

# To run all tests with headed test runner that will auto run on save
npm run test:watch

# To run one tests with headed test runner that will auto run on save
npm run test:watch FileName.test.tsx
```