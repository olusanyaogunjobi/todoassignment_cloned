package se.lexicon.functions;

public class Product {
    private String productName;
    private double prise;
    private int stock;


    public Product(String productNumber, double prise, int stock) {
        this.productName = productNumber;
        this.prise = prise;
        this.stock = stock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrise() {
        return prise;
    }

    public void setPrise(double prise) {
        this.prise = prise;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productNumber='" + productName + '\'' +
                ", prise=" + prise +
                ", stock=" + stock +
                '}';
    }
}
