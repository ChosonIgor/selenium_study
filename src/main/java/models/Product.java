package models;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private String name;
    private BigDecimal campaignPrice;
    private BigDecimal regularPrice;

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getCampaignPrice() {
        return campaignPrice;
    }

    public Product setCampaignPrice(BigDecimal campaignPrice) {
        this.campaignPrice = campaignPrice;
        return this;
    }

    public BigDecimal getRegularPrice() {
        return regularPrice;
    }

    public Product setRegularPrice(BigDecimal regularPrice) {
        this.regularPrice = regularPrice;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(campaignPrice, product.campaignPrice) && Objects.equals(regularPrice, product.regularPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, campaignPrice, regularPrice);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", campaignPrice=" + campaignPrice +
                ", regularPrice=" + regularPrice +
                '}';
    }
}
