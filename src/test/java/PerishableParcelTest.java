package test.java;

import Parcel.PerishableParcel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PerishableParcelTest {
    PerishableParcel perishableParcel = new PerishableParcel(5, "Frauda 2", 40, "Tortiki", 10);

    @Test
    void parcelIsNotExpired() {
        Assertions.assertFalse(perishableParcel.isExpired(15), "Что-то не так");
    }

    @Test
    void parcelIsExpired() {
        Assertions.assertTrue(perishableParcel.isExpired(16));
    }

}