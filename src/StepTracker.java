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

        System.out.println("Введите номер месяца");
        int monthNumber = scanner.nextInt();
        if (monthNumber < 1) {
            System.out.println("Введён некорректный номер месяца.");
            return;
        } else if (monthNumber > 12) {
            System.out.println("Введён некорректный номер месяца.");
            return;
        }

        System.out.println("Введите день от 1 до 30");
        int dayNumber = scanner.nextInt();
        if (dayNumber < 1) {
            System.out.println("Введён некорректный день.");
            return;
        } else if (dayNumber > 30) {
            System.out.println("Введён некорректный день.");
            return;
        }

        System.out.println("Введите количество шагов");
        int stepsInDay = scanner.nextInt();
        if (stepsInDay < 1) {
            System.out.println("Введёно некорректное количсетво шагов.");
            return;
        }
        MonthData monthData = monthToData[monthNumber - 1];
        monthData.days[dayNumber - 1] = stepsInDay;



    }

    void changeStepGoal() {
        System.out.println("Какое количесвто шагов вы планируете сделать?");
        int newGoal = scanner.nextInt();
        if (newGoal < 1) {
            System.out.println("Введёно некорректное количсетво шагов.");
            return;
        }
        goalByStepsPerDay = newGoal;
    }

    void printStatistic() {
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();
        if (month < 1) {
            System.out.println("Введён некорректный номер месяца.");
            return;
        } else if (month > 12) {
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
