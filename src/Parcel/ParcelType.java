package Parcel;

public enum ParcelType {
    STANDARD(2),
    FRAGILE(4),
    PERISHABLE(3);

    private int unitCost = 1;

    ParcelType(Integer unitCost) {
        this.unitCost = unitCost;
    }

    public int getUnitCost() {
        return unitCost;
    }
}
