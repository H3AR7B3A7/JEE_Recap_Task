package be.steven.d.dog.recapjee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * PRODUCT MODEL
 *
 * @author d.Dog
 */
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 3, max = 50, message = "{name_error}")
    private String productName;

    @NotBlank(message = "{blank_error}")
    private String description;

    @NotBlank(message = "{blank_error}")
    private String contact;

    @Pattern(regexp = "/^[-!#-\\'*+\\\\/-9=?^-~]+(?:\\\\.[-!#-\\'*+\\\\/-9=?^-~]+)*@[-!#-\\'*+\\\\/-9=?^-~]+(?:\\\\.[-!#-\\'*+\\\\/-9=?^-~]+)+$/i",message = "{mail_error}")
    private String contactMail;

    @NotNull(message = "{blank_error}")
    @DecimalMin(value = "0.01", message = "{price_error}")
    private BigDecimal price;

    public Product() {
        // Not empty
    }

    public BigDecimal getPrice() { return price; }

    public void setPrice(BigDecimal price) { this.price = price; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactMail() {
        return contactMail;
    }

    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
    }
}
