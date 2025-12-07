package Parcel;

public class PerishableParcel extends Parcel {

    int timeToLive;


    public PerishableParcel(int sendDay, String deliveryAddress, int weight, String description, int timeToLive) {
        super(sendDay, deliveryAddress, weight, description);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay) {
        if ((sendDay + timeToLive) >= currentDay) {
            return false;
        }
        return true;
    }

    @Override
    public int getUnitCost() {
        return ParcelType.PERISHABLE.getUnitCost();
    }

    @Override
    public String getType() {
        return ParcelType.PERISHABLE.name();
    }

}
