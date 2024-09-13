package jpaHibernate04Generators.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "empTab")
public class Employee {

	/*
	@Id
	@Column(name = "eid")
	@GenericGenerator(name="gen1",strategy = "assigned")
	@GeneratedValue(generator = "gen1")
	private Integer empId;
	*/

	/*
	@Id
	@GenericGenerator(name="gen1",strategy = "increment")
	@GeneratedValue(generator = "gen1")
	private Integer empId;
	*/

	/*
	@Id
	@GenericGenerator(name = "gen1", strategy = "identity")
	@GeneratedValue(generator = "gen1")
	@Column(name="eid")
	private Integer empId;
	*/

	/*
	@Id
	@Column(name = "eid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;
	*/

	@Id
	@Column(name = "eid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;



	@Column(name = "ename", length = 20)
	private String empName;

	@Column(name = "esal")
	private Double empSal;

	static {
		System.out.println("Employee.class is loading...");
	}

	public Employee() {
		System.out.println("Zero parameter consturctor is used by Hibernate....");
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
		System.out.println("Employee.setEmpId()");
	}

	public void setEmpName(String empName) {
		this.empName = empName;
		System.out.println("Employee.setEmpName()");
	}

	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
		System.out.println("Employee.setEmpSal()");
		System.out.println();
	}

	public Double getEmpSal() {
		System.out.println("Employee.getEmpSal()" + empSal);
		System.out.println();
		return empSal;
	}

	public Integer getEmpId() {
		System.out.println("Employee.getEmpId()" + empId);
		return empId;
	}

	public String getEmpName() {
		System.out.println("Employee.getEmpName()" + empName);
		return empName;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + "]";
	}

}


/*

Generators

The generation of primary key values are made automatic.

While creating a table, we can inform hibernate to create a columns with primary key value using @Id.
It is also possible to set the values to these primary key columns using Generators in hibernate.

There are 3 types of generators in hibernate
a. Hibernate supplied generators
b. JPA generators
c. Custom generators

Hibernate supplied generators:
a. assigned
b. increment
c. identity
d. sequence
e. hilo

assigned
========
> If we use this algorithm then explicitly we need to specify the primary key value to the table.
> It works with all databases as we need to give the primary key value.
	assigned => org.hibernate.id.Assigned
@Id
@Column(name = "eid")
@GenericGenerator(name="gen1",strategy = "assigned")
@GeneratedValue(generator = "gen1")
private Integer empId;

increment
=========
> It uses max(value) + 1 to generate the primary key value which is of int type.
> Works with all Database.
> If dbTable is empty it will generate 1 as the identity value.
	increment => org.hibernate.id.IncrementGenerator
@Id
@Column(name = "eid")
@GenericGenerator(name="gen1",strategy = "increment")
@GeneratedValue(generator = "gen1")
private Integer empId;

identity
========
Generates the value which are of type int,long,short.
This generator can be used only in such databases that supports "identity" columns.
This generator works for MySQL,DB2,SQlServer,...
it wont work in Oracle,PostgreSQL....
		MySQL=> AutoIncrement feature
@Id
@GenericGenerator(name = "gen1", strategy = "identity")
@GeneratedValue(generator = "gen1")
private Integer empId;

JPA generators: These are given by Sun MS JPA specification and works with all ORM Frameworks
a. IDENTITY
b. SEQUENCE
c. TABLE
d. AUTO

identity
=======
> It works with MySQL database.
> It is similar to AutoIncrement feature of primary key column.

@Id
@Column(name = "eid")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer empId;

auto
====
> It works with all database
> Depending upon the db engine platform, automatically hibernate will use
 hiberanate_sequence algorithm to generate the primary key value.

@Id
@Column(name = "eid")
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer empId;

 */