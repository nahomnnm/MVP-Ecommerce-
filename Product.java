class Product {
    private final String productId;
    private final String name;
    private final double price;
    private final String type;        // "physical" or "digital"
    private double weight;      // only for physical
    private String downloadLink; // only for digital

    // Physical product constructor
    public Product(String productId, String name, double price, double weight) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.type = "physical";
        this.weight = weight;
    }

    // Digital product constructor
    public Product(String productId, String name, double price, String downloadLink) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.type = "digital";
        this.downloadLink = downloadLink;
    }

    public String getProductId()   { return productId; }
    public String getName()        { return name; }
    public double getPrice()       { return price; }
    public String getType()        { return type; }
    public double getWeight()      { return weight; }
    public String getDownloadLink(){ return downloadLink; }

    public void display(int index) {
        System.out.println("  [" + index + "] " + name + " | $" + price + " | " + type);
    }
}