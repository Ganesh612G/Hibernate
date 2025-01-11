package hibernate.New;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Query;

import java.util.Scanner;

public class hibernateCurd {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);

		SessionFactory sf = cfg.buildSessionFactory();

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Choose an operation:");
			System.out.println("1. Insert Student");
			System.out.println("2. Update Student");
			System.out.println("3. Delete Student");
			System.out.println("4. fetch Student");
			int choice = sc.nextInt();

			Session session = sf.openSession();
			Transaction tr = session.beginTransaction();

			switch (choice) {
			case 1: // Insert Operation
				System.out.println("Enter Student Details for Insert:");
				System.out.print("ID: ");
				int id = sc.nextInt();
				sc.nextLine();

				System.out.print("Name: ");
				String name = sc.nextLine();

				System.out.print("Email: ");
				String email = sc.nextLine();

				System.out.print("Age: ");
				int age = sc.nextInt();

				Student ns = new Student();
				ns.setId(id);
				ns.setName(name);
				ns.setEmail(email);
				ns.setAge(age);

				session.save(ns);
				System.out.println("Student inserted successfully!");
				break;

			case 2: // Update Operation
				System.out.println("Enter Student Details for Update:");
				System.out.print("ID of Student to Update: ");
				int updateId = sc.nextInt();
				sc.nextLine();

				System.out.print("Updated Name: ");
				String updatedName = sc.nextLine();

				System.out.print("Updated Email: ");
				String updatedEmail = sc.nextLine();

				System.out.print("Updated Age: ");
				int updatedAge = sc.nextInt();

				Student us = session.get(Student.class, updateId);
				if (us != null) {
					us.setName(updatedName);
					us.setEmail(updatedEmail);
					us.setAge(updatedAge);

					session.update(us);
					System.out.println("Student updated successfully!");
				} else {
					System.out.println("Student with ID " + updateId + " not found.");
				}
				break;
			case 3: // Delete Operation
				System.out.println("Enter Student Details for Deletion:");
				System.out.print("ID of Student to Delete: ");
				int deleteId = sc.nextInt();

				Student sd = session.get(Student.class, deleteId);
				if (sd != null) {
					session.delete(sd);
					System.out.println("Student with ID " + deleteId + " deleted successfully!");
				} else {
					System.out.println("Student with ID " + deleteId + " not found.");
				}
				break;
			case 4: // Fetch Operation
				System.out.println("Enter Student ID to Fetch:");
				int fetchId = sc.nextInt();

				Student fs = session.get(Student.class, fetchId);
				if (fs != null) {
					System.out.println("Student Details:");
//					System.out.println("ID: " + fs.getId());
					System.out.println("Name: " + fs.getName());
					System.out.println("Email: " + fs.getEmail());
					System.out.println("Age: " + fs.getAge());
				} else {
					System.out.println("Student with ID " + fetchId + " not found.");
				}
				break;

			default:
				System.out.println("Invalid choice. Please select 1, 2, 3, OR 4");
			}

			tr.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sf.close();
		}
	}
}
