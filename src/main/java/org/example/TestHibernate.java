package org.example;

import org.hibernate.Session;

public class TestHibernate {
    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            AddressEntity address = new AddressEntity();
            address.setState("Test");
            address.setCity("Test");

            EmployeeEntity employee = new EmployeeEntity();
            employee.setFname("test");
            employee.setLname("test");
            employee.setEmail("test@demo.com");
            employee.setAddress(address);

            session.save(address);
            session.save(employee);
            session.getTransaction().commit();

            var employees = session.createQuery("from EmployeeEntity").list();
            //noinspection unchecked
            employees.forEach(System.out::println);
        }
        HibernateUtil.shutdown();
    }
}
