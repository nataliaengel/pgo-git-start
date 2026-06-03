public abstract class ShipmentOrder implements SummaryPrintable {
   private String orderNumber;
   private String customerName;
   private int distanceKm;
   private double baseFee;
   private boolean insured;
   protected double lastCalculatedPrice;
   public ShipmentOrder(String orderNumber, String customerName,
                        int distanceKm, double baseFee, boolean insured) {
       this.orderNumber = orderNumber;
       this.customerName = customerName;
       this.distanceKm = distanceKm;
       this.baseFee = baseFee;
       this.insured = insured;
   }
   public String getOrderNumber()  { return orderNumber; }
   public String getCustomerName() { return customerName; }
   public int getDistanceKm()      { return distanceKm; }
   public double getBaseFee()      { return baseFee; }
   public boolean isInsured()      { return insured; }
   // Template Method - final, klasy potomne NIE mogą nadpisać!
   public final void processOrder() {
       validateOrder();
       validateSpecificRules();
       double price = calculateBasePrice();
       price += calculateAdditionalFee();
       price = applyInsurance(price);
       price = applyBusinessDiscount(price);
       lastCalculatedPrice = price;
       printProcessingResult();
   }
   // Wspólna walidacja
   private void validateOrder() {
       if (orderNumber == null || orderNumber.isEmpty()) {
           throw new IllegalArgumentException("Order number cannot be empty!");
       }
       if (distanceKm <= 0) {
           throw new IllegalArgumentException("Distance must be positive!");
       }
   }
   // Metoda hakowa - klasy potomne mogą nadpisać
   protected void validateSpecificRules() {}
   // Wspólna logika ubezpieczenia
   private double applyInsurance(double price) {
       if (insured) price *= 1.07;
       return price;
   }
   // Metoda hakowa - domyślnie zwraca tę samą cenę
   protected double applyBusinessDiscount(double price) {
       return price;
   }
   private void printProcessingResult() {
       System.out.println("Processed: " + orderNumber
            + " | Type: " + getShipmentType()
            + " | Price: " + Math.round(lastCalculatedPrice * 100.0) / 100.0);
   }
   @Override
   public String buildSummaryLine() {
       return "Order " + orderNumber + " | " + customerName
            + " | " + getShipmentType()
            + " | Price: " + Math.round(lastCalculatedPrice * 100.0) / 100.0;
   }
   // Metody abstrakcyjne - każda klasa potomna MUSI zaimplementować
   public abstract String getShipmentType();
   protected abstract double calculateBasePrice();
   protected abstract double calculateAdditionalFee();
}
