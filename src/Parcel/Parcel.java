package Parcel;

public abstract class Parcel {

    protected String description;
    protected int weight;
    protected String deliveryAddress;
    protected int sendDay;

    public Parcel(int sendDay, String deliveryAddress, int weight, String description) {
        this.sendDay = sendDay;
        this.deliveryAddress = deliveryAddress;
        this.weight = weight;
        this.description = description;
    }


    public void packageItem() {
        System.out.printf("Посылка <<%s>> упакована" + "\n", description);
    }

    public void deliver() {
        System.out.printf("Посылка <<%s>> доставлена по адресу %s" + "\n", description, deliveryAddress);
    }

    public String getDescription() {
        return description;
    }
    public int getWeight() {
        return weight;
    }

    protected abstract int getUnitCost();

    protected abstract String getType();

    public int calculateDeliveryCost() {
        return weight * getUnitCost();

    }


}

