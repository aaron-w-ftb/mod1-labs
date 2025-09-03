package lab6;

class RegistrationPlateFactory {
    private static String[] registrationPlates = {
        "LAM XYZ",
        "MK58 3AL",
        "MU3 HVT",
        "SG69 TXY",
        "KT12 QWE",
        "LS60 PQR",
        "BN21 MNL",
        "CA67 RST",
        "SM4 UVW",
        "LV22 ABC",
        "MV19 XYZ"
    };

    private static int currentIndex = 0;

    public static RegistrationPlate getNextRegistrationPlate() {
        if (currentIndex >= registrationPlates.length) {
            currentIndex = 0;
        }
        
        RegistrationPlate plate = new RegistrationPlate(registrationPlates[currentIndex]);
        currentIndex++;
        
        return plate;
    }
}