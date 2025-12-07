package Parcel;

public class StandardParcel extends Parcel {

    public static final int UNIT_COST_STANDARD_PARCEL = 2;

    public StandardParcel(int sendDay, String deliveryAddress, int weight, String description) {
        super(sendDay, deliveryAddress, weight, description);
    }

    @Override
    public int getUnitCost() {
        return ParcelType.STANDARD.getUnitCost();
    }

    @Override
    public String getType() {
        return ParcelType.STANDARD.name();
    }

}
