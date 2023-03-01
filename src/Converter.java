class Converter {
    private static final int STEP_SANTIM_LENGTH = 75;
    private static final int SANTIM_IN_KILOMETER = 100000;
    private static final int STEP_KILO_CALOR = 50;
    private static final int CALOR_IN_KILOCALOR = 1000;

    int convertToKm(int steps){
        return steps * STEP_SANTIM_LENGTH / SANTIM_IN_KILOMETER;

    }

    int convertStepsToKilocalories(int steps){
        return steps * STEP_KILO_CALOR / CALOR_IN_KILOCALOR;
    }
}
