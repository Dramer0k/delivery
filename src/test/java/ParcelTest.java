package test.java;

import Parcel.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParcelTest {

    Parcel parcel;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getPriceStandardParcel() {
        parcel = new StandardParcel(1, "Gogolya 2", 20, "Top");
        Assertions.assertEquals(40, parcel.calculateDeliveryCost());
    }

    @Test
    void getPriceFragileParcel() {
        parcel = new FragileParcel(1, "Gogolya 2", 20, "Top");
        Assertions.assertEquals(80, parcel.calculateDeliveryCost());
    }

    @Test
    void getPricePerishableParcel() {
        parcel = new PerishableParcel(1, "Gogolya 2", 20, "Top", 10);
        Assertions.assertEquals(60, parcel.calculateDeliveryCost());
    }
}