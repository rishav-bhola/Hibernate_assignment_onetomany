import java.util.*;
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageEmployee {
   private static SessionFactory factory; 
   public static void main(String[] args) {
      try{
         factory = new Configuration().configure().buildSessionFactory();
      }catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
      ManageEmployee ME = new ManageEmployee();
      HashSet set1 = new HashSet();

      set1.add(new Bank(112233,"J&K","JAKA0LINKRO"));
      set1.add(new Bank(112244,"Axis","Axis0LINKRO"));
      set1.add(new Bank(112255,"SBI","SBI0LINKRO"));
      /* Add bank records in the database */
      Integer perID1 = ME.addPerson("Rishav Bhola",set1);

      /* Another set of certificates for the second employee  */
      HashSet set2 = new HashSet();

      set2.add(new Bank(112266,"ICICI","ICICI0LINKRO"));
      set2.add(new Bank(112277,"UNION","UNION0LINKRO"));
      Integer perID2 = ME.addPerson("Veena Bhola",set2);


      /* List down all the employees */
     // ME.listEmployees();


      /* Update employee's salary records */
      //ME.updateEmployee(empID1, 5000);

      /* Delete an employee from the database */
      //ME.deleteEmployee(empID2);

      /* List down all the employees */
      //ME.listEmployees();

   }

   public Integer addPerson(String name,Set bank){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer personID = null;
      try{
         tx = session.beginTransaction();
         Person person = new Person(name);
         person.setBank(bank);
         personID = (Integer) session.save(person);
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace();
      }finally {
         session.close();
      }
      return personID;
   }


   /* Method to list all the employees detail */
  /* public void listEmployees( ){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         List employees = session.createQuery("FROM Employee").list(); 
         for (Iterator iterator1 = 
                           employees.iterator(); iterator1.hasNext();){
            Employee employee = (Employee) iterator1.next(); 
            System.out.print("First Name: " + employee.getFirstName()); 
            System.out.print("  Last Name: " + employee.getLastName()); 
            System.out.println("  Salary: " + employee.getSalary());
            Set certificates = employee.getCertificates();
            for (Iterator iterator2 = 
                         certificates.iterator(); iterator2.hasNext();){
                  Certificate certName = (Certificate) iterator2.next(); 
                  System.out.println("Certificate: " + certName.getName()); 
            }
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }

   */
   /* Method to update salary for an employee */
  /* public void updateEmployee(Integer EmployeeID, int salary ){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Employee employee = 
                    (Employee)session.get(Employee.class, EmployeeID); 
         employee.setSalary( salary );
         session.update(employee);
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }

   */

  /* Method to delete an employee from the records */
  /* public void deleteEmployee(Integer EmployeeID){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Employee employee = 
                   (Employee)session.get(Employee.class, EmployeeID); 
         session.delete(employee); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }

   */
}
