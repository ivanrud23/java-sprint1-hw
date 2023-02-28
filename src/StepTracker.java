import java.util.Scanner;

class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay;
    Converter converter = new Converter();

    StepTracker (Scanner scan){
        scanner = scan;
        goalByStepsPerDay = 10000;

        for (int i = 0; i < monthToData.length; i ++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        int monthNumber = Main.enterMonth();
        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Введён некорректный номер месяца.");
            return;
        }

        int dayNumber = Main.enterDay();
        if (dayNumber < 1 || dayNumber > 30) {
            System.out.println("Введён некорректный день.");
            return;
        }

        System.out.println("Введите количество шагов");
        int stepsInDay = scanner.nextInt();
        if (stepsInDay < 1) {
            System.out.println("Введено некорректное количсетво шагов.");
            return;
        }

        MonthData monthData = monthToData[monthNumber - 1];
        monthData.days[dayNumber - 1] = stepsInDay;
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
        int month = Main.enterMonth();
        if (month < 1 || month > 12) {
            System.out.println("Введён некорректный номер месяца.");
            return;
        }
        MonthData monthData = monthToData[month - 1];
        monthData.printDaysAndStepsFromMonth(monthData.days); // количество пройденных шагов по дням;
        System.out.println(monthData.sumStepsFromMonth(monthData.days) + " - общее количество шагов за месяц");
        System.out.println(monthData.maxSteps(monthData.days) + " - максимальное пройденное количество шагов в месяце");
        System.out.println((monthData.sumStepsFromMonth(monthData.days) / 30) + " - среднее количество шагов");
        System.out.println(converter.convertToKm(monthData.sumStepsFromMonth(monthData.days)) + " - пройденная дистанция (в км)");
        System.out.println(converter.convertStepsToKilocalories(monthData.sumStepsFromMonth(monthData.days)) + " - количество сожжённых килокалорий");
        System.out.println(monthData.bestSeries(monthData.days, goalByStepsPerDay) + " - лучшая серия");
    }
}
