class PhysicalOrder extends Order {
    private final double shippingWeight;

    public PhysicalOrder(String orderId, String customerName, double baseAmount, double shippingWeight) {
        super(orderId, customerName, baseAmount);
        this.shippingWeight = shippingWeight;
    }

    public double getShippingWeight() {
        return shippingWeight;
    }

    @Override
    public double calculateTotal() {
        double shippingFee = shippingWeight * 4.5;
        return getBaseAmount() + shippingFee;
    }
}