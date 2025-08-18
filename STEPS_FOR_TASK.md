# Steps to Complete Homework (CI + Checkstyle)

This document explains all the steps I followed to complete the task with GitHub Actions, Maven, and Checkstyle.  
The pull request link will include this file so that the mentor can review the full process.

---

## 1. Initialize the project

- Created a new **Spring Boot project** with Maven.
- Added base structure: `model`, `repository`, `service`, `controller`.

## 2. Setup Git and GitHub

- Initialized Git in the project.
- Pushed the code to a new **GitHub repository**.

## 3. Create GitHub Actions workflow

- Created `.github/workflows/ci.yml` file.
- Configured workflow to build and test project on every push and pull request.

```yaml
name: Java CI

on:
  - push
  - pull_request

jobs:
  build:
    runs-on: ubuntu-latest
    
    steps:
      - uses: actions/checkout@v4
      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          java-version: '17'
          distribution: 'temurin'
          cache: maven
      - name: Build with Maven
        run: mvn --batch-mode --update-snapshots verify
      - name: Check style
        run: mvn checkstyle:check

checkstyle:
  runs-on: ubuntu-latest
  steps:
    - uses: actions/checkout@v3
    - name: Set up JDK 17
      uses: actions/setup-java@v3
      with:
        java-version: '17'
        distribution: 'temurin'
    - name: Run Checkstyle
      run: mvn checkstyle:check
      
4. Add dependencies
Added spring-boot-starter dependencies to pom.xml.

Configured project structure to work with Maven and Spring Boot.

5. Create model
Implemented Book class in model package.

6. Create repository
Created BookRepository interface.

Implemented BookRepositoryImpl with annotation @Repository.

7. Create service
Created BookService interface.

Implemented BookServiceImpl with annotation @Service.

8. Create application entry point
Added BookstoreApplication class with main() method.

9. Configure resources
Added application.properties in src/main/resources.

10. Add tests
Added BookstoreApplicationTests (default Spring Boot test).

Created additional test classes to check CI pipeline.

11. Install Checkstyle plugin(See my Actions please!)
Configured maven-checkstyle-plugin in pom.xml.

		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-checkstyle-plugin</artifactId>
				<version>3.6.0</version>
				<configuration>
					<configLocation>google_checks.xml</configLocation>
					<consoleOutput>true</consoleOutput>
					<failsOnError>true</failsOnError>
				</configuration>
				<executions>
					<execution>
						<phase>verify</phase>
						<goals>
							<goal>check</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
		</plugins>
		
12. Create checkstyle.xml
Added custom rules (indentation, braces, line length, whitespace, etc.).

<module name="Checker">
    <module name="TreeWalker">
        <module name="WhitespaceAround"/>
        <module name="WhitespaceAfter"/>
        <module name="LeftCurly"/>
        <module name="RightCurly"/>
        <module name="NeedBraces"/>
        <module name="LineLength">
            <property name="max" value="120"/>
        </module>

        <module name="Indentation">
            <property name="basicOffset" value="4"/>
            <property name="braceAdjustment" value="0"/>
            <property name="caseIndent" value="4"/>
            <property name="throwsIndent" value="4"/>
            <property name="lineWrappingIndentation" value="8"/>
        </module>
    </module>
</module>

13. Run Checkstyle locally
Command:

mvn checkstyle:check
Verified that the build fails if there are style violations.

14. Add Checkstyle to GitHub Actions
Updated ci.yml to include Checkstyle step:

- name: Checkstyle
  run: mvn checkstyle:check
  
Now if code style is violated, the job fails and PR is blocked.