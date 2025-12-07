package box;
import Parcel.*;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {

    private int boxWeight = 0;
    private final int maxWeight;
    ArrayList<T> parcelBox = new ArrayList<>();

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addParcel(T parcel) {
        if ((parcel.getWeight() + boxWeight) > maxWeight) {
            System.out.println("Не получилось добавить посылку. Максимальный вес контейнера превышен!");
            return;
        }
        parcelBox.add(parcel);
        boxWeight += parcel.getWeight();
    }

    public void getAllParcels() {
        for (T parcel : parcelBox) {
            System.out.println(parcel.getDescription());
        }
    }

    public int size() {
        return parcelBox.size();
    }
}
