# Hibernate

This project demonstrates basic CRUD (Create, Read, Update, Delete) operations using Hibernate, a popular Java-based Object-Relational Mapping (ORM) framework. The program interacts with a MySQL database to perform operations on a Student table.

# Features 
**Insert Student:** Adds a new student record to the database.
**Update Student**: Modifies an existing student's details.
**Delete Student**: Removes a student record from the database.
**Fetch Student**: Retrieves and displays a student's details by ID.
@ Key Concepts in Hibernate
Hibernate Configuration File (hibernate.cfg.xml)

This file contains the database configuration and Hibernate properties.
Example configuration for MySQL:
xml
<hibernate-configuration>
    <session-factory>
        <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/your_database</property>
        <property name="hibernate.connection.username">your_username</property>
        <property name="hibernate.connection.password">your_password</property>
        <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
        <property name="hibernate.show_sql">true</property>
        <property name="hibernate.hbm2ddl.auto">update</property>
    </session-factory>
</hibernate-configuration>
**SessionFactory**
The SessionFactory is a heavyweight object responsible for creating Session objects.
Configured using Configuration and hibernate.cfg.xml.

**Session**
A Session represents the connection between the application and the database.
It is used to perform CRUD operations (e.g., save, get, update, delete).

**Transaction**
A Transaction ensures that operations on the database are atomic and consistent.
For every set of operations (e.g., insert, update), a Transaction is started and committed.

**Annotations**
The @Entity annotation maps a class to a database table.
