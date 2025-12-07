package Parcel;

public class FragileParcel extends Parcel  implements Trackable {

    public FragileParcel(int sendDay, String deliveryAddress, int weight, String description) {
        super(sendDay, deliveryAddress, weight, description);
    }

    @Override
    public void packageItem() {
        System.out.printf("Посылка <<%s>> обёрнута в защитную плёнку", description);
        super.packageItem();
    }

    @Override
    public int getUnitCost() {
        return ParcelType.FRAGILE.getUnitCost();
    }
    @Override
    public String getType() {
        return ParcelType.FRAGILE.name();
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.printf("Хрупкая посылка <<%s>> изменила местоположение на %s" + "\n", description, newLocation);
    }
}
