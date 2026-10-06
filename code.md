https://github.com/mosh-hamedani/spring-api-starter
https://github.com/mosh-hamedani/spring-api-finished 

# 0. first add dependency and than build it  
# 1. Build the project (downloads deps, compiles, tests, packages)
mvn clean install 

# 2. (Optional) Build without running tests
mvn clean install -DskipTests

clean	Deletes the target/ folder (removes old builds)
install	Compiles, tests, packages, and installs the JAR into your local Maven repo 
1. clean     → delete target/
2. validate  → sanity-check the project
3. compile   → src/main/java → target/classes/*.class
4. test      → run JUnit tests in src/test/java
5. package   → target/my-app-0.0.1.jar
6. verify    → (optional) integration checks
7. install   → copy JAR to ~/.m2/repository

# 3. run directly via Maven (dev mode)
mvn spring-boot:run

# 4.run xampp database 
sudo /opt/lampp/lampp start
http://localhost:8080/phpmyadmin/

sudo /opt/lampp/bin/mysql -u root -p
SHOW DATABASES;



mvn spring-boot:runhttp://localhost:8080/phpmyadmin/


flay way dependcy 
mvn flyway:migrate
mvn flyway:info
mvn flyway:repair
mvn flyway:clean
add maven 
code --install-extension vscjava.vscode-maven

mvn clean spring-boot:run
mvn clean install && mvn spring-boot:run


one more time 
https://members.codewithmosh.com/courses/spring-boot-mastering-apis/lectures/60593304


git checkout -b validating_api_requests   
git push -u origin validating_api_requests