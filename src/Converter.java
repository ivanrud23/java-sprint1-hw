class Converter {
    private static final int stepSantimLength = 75;
    private static final int stepKiloCalor = 50;

    int convertToKm(int steps){
        int km = steps * stepSantimLength / 100000;
        return km;
    }

    int convertStepsToKilocalories(int steps){
        int kilocalories = steps * stepKiloCalor / 1000;
        return kilocalories;
    }
}
