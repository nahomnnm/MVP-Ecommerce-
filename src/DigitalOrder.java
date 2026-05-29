class DigitalOrder extends Order {
    private final String downloadLink;

    public DigitalOrder(String orderId, String customerName, double baseAmount, String downloadLink) {
        super(orderId, customerName, baseAmount);
        this.downloadLink = downloadLink;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    @Override
    public double calculateTotal() {
        double processingTax = 1.50;
        return getBaseAmount() + processingTax;
    }
}