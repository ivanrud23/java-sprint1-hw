import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);


        while (true) {
            System.out.println();
            printMenu();
            int command;

            command = scanUserInputSafely(scanner);
            if (command == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (command == 2) {
                stepTracker.changeStepGoal();
            } else if (command == 3) {
                stepTracker.printStatistic();
            } else if (command == 0) {
                System.out.println("Выход");
                return;
            } else if (command == -1){
                System.out.println("Введен некорректный символ");
            } else {
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
    static int enterMonth () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер месяца от 1 до 12");
        return scanner.nextInt();
    }
    static int enterDay () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите день от 1 до 30");
        return scanner.nextInt();
    }
    static int scanUserInputSafely(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("Введен некорректный символ");
            return -1;
        }
    }
}
