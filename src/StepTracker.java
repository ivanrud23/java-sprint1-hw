import java.util.Scanner;

class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay;
    private static final int INDEX_COMPENSATOR = 1;
    Converter converter = new Converter();

    StepTracker(Scanner scan) {
        scanner = scan;
        goalByStepsPerDay = 10000;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        int monthNumber = getMonthNumber();
        if (isInvalidMonthNumber(monthNumber)) {
            System.out.println("Введён некорректный номер месяца.");
            return;
        }

        int dayNumber = getDayNumber();
        if (isInvalidDay(dayNumber)) {
            System.out.println("Введён некорректный день.");
            return;
        }

        System.out.println("Введите количество шагов");
        int stepsInDay = scanner.nextInt();
        if (stepsInDay < 1) {
            System.out.println("Введено некорректное количсетво шагов.");
            return;
        }

        MonthData monthData = monthToData[monthNumber - INDEX_COMPENSATOR];
        monthData.days[dayNumber - INDEX_COMPENSATOR] = stepsInDay;
    }

    void changeStepGoal() {
        System.out.println("Какое количество шагов вы планируете сделать?");
        int newGoal = scanner.nextInt();
        if (newGoal < 1) {
            System.out.println("Введено некорректное количество шагов.");
            return;
        }
        goalByStepsPerDay = newGoal;
    }

    void printStatistic() {
        int month = getMonthNumber();
        if (isInvalidMonthNumber(month)) {
            System.out.println("Введён некорректный номер месяца.");
            return;
        }
        MonthData monthData = monthToData[month - INDEX_COMPENSATOR];
        monthData.printDaysAndStepsFromMonth(monthData.days); // количество пройденных шагов по дням;
        System.out.println(monthData.sumStepsFromMonth(monthData.days) + " - общее количество шагов за месяц");
        System.out.println(monthData.maxSteps(monthData.days) + " - максимальное пройденное количество шагов в месяце");
        System.out.println((monthData.sumStepsFromMonth(monthData.days) / 30) + " - среднее количество шагов");
        System.out.println(converter.convertToKm(monthData.sumStepsFromMonth(monthData.days)) + " - пройденная дистанция (в км)");
        System.out.println(converter.convertStepsToKilocalories(monthData.sumStepsFromMonth(monthData.days)) + " - количество сожжённых килокалорий");
        System.out.println(monthData.bestSeries(monthData.days, goalByStepsPerDay) + " - лучшая серия");
    }

    private int getMonthNumber() {
        System.out.println("Введите номер месяца от 1 до 12");
        return Main.scanUserInputSafely(scanner);
    }
    private boolean isInvalidMonthNumber (int month) {
        return month < 1 || month > 12;
    }

    private int getDayNumber() {
        System.out.println("Введите день от 1 до 30");
        return Main.scanUserInputSafely(scanner);
    }
    private boolean isInvalidDay(int dayNumber) {
        return dayNumber < 1 || dayNumber > 30;
    }

}