# Impact Assessment

Instructions are based on Intellij Ultimate 2021.2.4

Developed using:

JDK 8
Maven 3.6.3
Windows 10

Build/Run Instructions:

Import project as Maven project.
In IntelliJ Maven menu, under the lifecycle menu, double click "clean", then double click "install".
The "target" folder will generate the "impact-1.0-SNAPSHOT.jar".
Navigate to the "target" folder in your file explorer.
Open a powershell window in the directory (SHIFT + Right click).
Paste this command: "java -jar impact-1.0-SNAPSHOT.jar"
The jar file will run in the powershell window.

Alternatively:

Import project as Maven project.
Right click on "Impact.java" and select "Run Impact.main()".
The application will start within IntelliJ.
