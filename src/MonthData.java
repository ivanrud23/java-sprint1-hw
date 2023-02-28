class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth(int[] days) {
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + " день: " + (days[i]));
        }
    }

    int sumStepsFromMonth(int[] days) {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i ++) {
            sumSteps = sumSteps + days[i];
        }
        return sumSteps;
    }

    int maxSteps(int[] days) {
        int stepsMax = 0;
        for (int i = 0; i < days.length; i ++) {
            if (days[i] > stepsMax) {
                stepsMax = days[i];
            }
        }
        return  stepsMax;
    }

    int bestSeries(int[] days, int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goalByStepsPerDay) {
                currentSeries++;
                if (currentSeries > finalSeries) {
                    finalSeries = currentSeries;
                }
            } else {
                currentSeries = 0;
            }
        }
        return finalSeries;
    }
}
