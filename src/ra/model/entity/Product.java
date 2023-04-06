package ra.model.entity;

import java.io.Serializable;
import java.util.StringJoiner;

public class Product implements Serializable {
    private int productId;
    private Catalog productCatalog;
    private String productName;
    private Float productPrice;
    private Boolean productStatus;

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Catalog getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(Catalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public Boolean getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Boolean productStatus) {
        this.productStatus = productStatus;
    }

    public Product(int productId, Catalog productCatalog, String productName, Float productPrice, Boolean productStatus) {
        this.productId = productId;
        this.productCatalog = productCatalog;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStatus = productStatus;

    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
                .add("productId: " + productId)
                .add("productCatalog: " + productCatalog.getName())
                .add("productName: " + productName + "")
                .add("productPrice: " + productPrice)
                .add("productStatus: " + productStatus)
                .toString();
    }
}
