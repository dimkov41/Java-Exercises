package CoffeeMachine;

public enum CoffeeSize {
    SMALL(50,50), NORMAL(100,75), DOUBLE(200,100);

    private int dosage;
    private int price;

    CoffeeSize(int dosage, int price) {
        this.dosage = dosage;
        this.price = price;
    }

    public int getDosage() {
        return dosage;
    }

    public int getPrice() {
        return price;
    }

    //that has dosage and price – Small (50 ml, 50 c), Normal (100 ml, 75 c), Double (200 ml, 100 c)
}
