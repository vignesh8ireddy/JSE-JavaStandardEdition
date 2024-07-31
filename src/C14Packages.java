//package com.facebook; this creates com/facebook folders and .class file is put there.

public class C14Packages {

	/*
	 In the real-time coding a java application coding is divided into
	 following three layers: controller layer, Service layer, DAO(Data Access Object) layer
	 So that maintainability and ease to handle application becomes better
	 */
    //packaging : grouping all the associated classes/interfaces/enum files using directories
    //package = directory = folder
    //It is a good programming practice to name a package as per internet domain (actually reverse of it)
    //internet domain of facebook : facebook.com, it's reverse is com.facebook

	/*
	 Packaging is an encapsulation mechanism to group all the related classes and interfaces in a single module.
	 Using packages name conflicts can also	 be reduced, modularity of application is improved
	 While using the inbuilt classes also, internally SunMicrosystems use the packages to keep the classes and interfaces.
	 */


	/*

	 Running java code with packages using command prompt:

	 To compile the code use : javac -d . C16Packages.java

	 		-d => tells to create the file in designated directory
	 		. => indication of directory as current directory; instead you can specify directory path

	 The above command creates the package present in C16Packages.java code and places the .class file in that package


	 */


	/*
	 Packages Hierarchy:

	 --------------------------------------------------------------------------------------------------------------------------------(main package)
	 									java
	 --------------------------------------------------------------------------------------------------------------------------------(subpackages)
	 				lang			util			io			sql		......
	 ------------------------------------------------------------------------------------------------------------------------------------(classes)
	 				StringBuilder		Scanner			File	         	Driver
	 				StringBuffer		Date		        FileReader		DriverManager
	 				String			Random	         	FileWriter		Connection
	 				System


	 lang package is so frequently used, so sunMicrosystems decided it to be default package i.e no need
	 of importing explicitly. It is inbuilt imported. That is the reason you can use System.out.println(),
	 String class and many others without importing lang package.
	 */

	/*

	 Few tricky questions on Package concept:

	 How many .class files are created upon compiling the following files,

	 1. A file named Test.java with zero statements in it i.e no code : no class file but no compile time error also
	 2. A java file with only one package statement in it: one class file and no error
	 3. A java file with only one import statement in it: one class file and no error
	 4. A java file with one package statement followed by one import statement: one class and no error
	 5. A java file with two package statements: no class file, compile time error is generated

	 only one package statement is allowed in java
	 any no. of import statements is/are allowed
	 any no. of declaration of statements is/are allowed (but only one should be public and it is class with file name)

	 */
}
