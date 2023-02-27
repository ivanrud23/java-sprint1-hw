import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        System.out.println();

        while (true) {
            printMenu();
            int command;
            String line;

            try {
                line = scanner.nextLine();
                command = Integer.parseInt(line);
                if (command == 1) {
                    stepTracker.addNewNumberStepsPerDay();
                } else if (command == 2) {
                    stepTracker.changeStepGoal();
                } else if (command == 3) {
                    stepTracker.printStatistic();
                } else if (command == 0) {
                    System.out.println("Выход");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Введен некорректный символ");
            }
        }
    }


    static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 — Ввести количество шагов за определённый день");
        System.out.println("2 — Изменить цель по количеству шагов в день");
        System.out.println("3 — Напечатать статистику за определённый месяц");
        System.out.println("0 — Выйти из приложения");
        System.out.println();
    }
}
