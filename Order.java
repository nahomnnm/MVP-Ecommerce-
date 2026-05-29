abstract class Order {
    private final String orderId;
    private final String customerName;
    private double baseAmount;

    public Order(String orderId, String customerName, double baseAmount) {
        this.orderId = orderId;
        this.customerName = customerName;
        setBaseAmount(baseAmount);
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(double baseAmount) {
        if (baseAmount >= 0) {
            this.baseAmount = baseAmount;
        } else {
            this.baseAmount = 0.0;
        }
    }

    public abstract double calculateTotal();

    public void displayOrderSummary() {
        System.out.println("Order ID: " + orderId + " | Customer: " + customerName + " | Base Amount: $" + baseAmount);
    }
}