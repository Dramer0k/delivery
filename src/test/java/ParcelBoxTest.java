package test.java;
import box.ParcelBox;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import Parcel.*;

import java.util.List;

class ParcelBoxTest {
    ParcelBox<StandardParcel> parcelBox;

    @BeforeEach
    void setUp() {
         parcelBox = new ParcelBox<StandardParcel>(30);
    }

    @Test
    void addParcelToBoxWithoutExceedingWeight10() {
        StandardParcel standardParcel = new StandardParcel(1, "Gogolya 24", 20, "Kotiki");

        parcelBox.addParcel(standardParcel);
        Assertions.assertEquals(1, parcelBox.size());
    }

    @Test
    void addParcelToBoxExceedingWeight50() {
        StandardParcel standardParcel = new StandardParcel(1, "Gogolya 24", 50, "Kotiki");

        parcelBox.addParcel(standardParcel);
        Assertions.assertEquals(0, parcelBox.size());
    }

    @Test
    void addParcelToBoxWithoutExceedingWeight30() {
        StandardParcel standardParcel = new StandardParcel(1, "Gogolya 24", 30, "Kotiki");

        parcelBox.addParcel(standardParcel);
        Assertions.assertEquals(1, parcelBox.size());
    }

}