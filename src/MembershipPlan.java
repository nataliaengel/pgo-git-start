public abstract class MembershipPlan implements Billable {
   private String planCode;
   private String clientName;
   private int months;
   private double baseMonthlyFee;
   private boolean autoRenew;
   public MembershipPlan(String planCode, String clientName,
                         int months, double baseMonthlyFee,
                         boolean autoRenew) {
       this.planCode = planCode;
       this.clientName = clientName;
       this.months = months;
       this.baseMonthlyFee = baseMonthlyFee;
       this.autoRenew = autoRenew;
   }
   public String getPlanCode()       { return planCode; }
   public String getClientName()     { return clientName; }
   public int getMonths()            { return months; }
   public double getBaseMonthlyFee() { return baseMonthlyFee; }
   public boolean isAutoRenew()      { return autoRenew; }
   // Metody abstrakcyjne - każda klasa potomna MUSI je zaimplementować
   public abstract String getPlanType();
   public abstract double calculateMonthlyNetPrice();
   // Metody z logiką wspólną dla wszystkich
   @Override
   public double calculateMonthlyGrossPrice() {
       return Math.round(calculateMonthlyNetPrice() * 1.23 * 100.0) / 100.0;
   }
   public double calculateTotalNetPrice() {
       return Math.round(calculateMonthlyNetPrice() * months * 100.0) / 100.0;
   }
   public final void printSummary() {
       System.out.println("=== " + getPlanType() + " ===");
       System.out.println("Plan: " + planCode + " | Klient: " + clientName);
       System.out.println("Miesiece: " + months + " | AutoRenew: " + autoRenew);
       System.out.println("Cena netto/mies: " + calculateMonthlyNetPrice());
       System.out.println("Cena brutto/mies: " + calculateMonthlyGrossPrice());
       System.out.println("Cena netto calego planu: " + calculateTotalNetPrice());
   }
   @Override
   public String toString() {
       return "MembershipPlan{code='" + planCode + "', client='" + clientName
            + "', type=" + getPlanType()
            + ", netPrice=" + calculateMonthlyNetPrice() + "}";
   }
}
