package fdmc.domain.models.binding;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class CatRegisterBindingModel {
    private String name;
    private String breed;
    private String color;
    private int age;
    private BigDecimal price;
    private String gender;
    private boolean hasPassport;
    private Date addedOn;

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @NotNull
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @NotNull
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @NotNull
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @NotNull
    public boolean isHasPassport() {
        return hasPassport;
    }

    public void setHasPassport(boolean hasPassport) {
        this.hasPassport = hasPassport;
    }

    @NotNull
    public Date getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }
}
