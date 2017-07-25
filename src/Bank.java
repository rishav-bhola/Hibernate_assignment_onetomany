public class Bank {
private int id;
private int accountno;
private String bankname;
private String ifsc;

   public Bank() {
   }

   public Bank(int accountno, String bankname, String ifsc) {
      this.accountno = accountno;
      this.bankname = bankname;
      this.ifsc = ifsc;
   }


   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getAccountno() {
      return accountno;
   }

   public void setAccountno(int accountno) {
      this.accountno = accountno;
   }

   public String getBankname() {
      return bankname;
   }

   public void setBankname(String bankname) {
      this.bankname = bankname;
   }

   public String getIfsc() {
      return ifsc;
   }

   public void setIfsc(String ifsc) {
      this.ifsc = ifsc;
   }

   public boolean equals(Object obj) {
      if (obj == null) return false;
      if (!this.getClass().equals(obj.getClass())) return false;

      Bank obj2 = (Bank) obj;
      if((this.id == obj2.getId()) && (this.bankname.equals(obj2.getBankname())))
      {
         return true;
      }
      return false;
   }

}
