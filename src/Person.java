import java.util.*;

public class Person {
   private int id;
   private String name;
   private Set bank;


   public Person() {
   }

   public Person( String name) {

      this.name = name;

   }


   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }


   public Set getBank() {
      return bank;
   }

   public void setBank(Set bank) {
      this.bank = bank;
   }
}
