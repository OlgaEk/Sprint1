import java.util.Scanner;

public class Main {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        boolean stopMenu = false;
        int monthNum = 0;
        int DayNum = 0;
        int numberOfSteps = 0;

        while (!stopMenu) {
            menuPrint();
            System.out.println("Введите номер пункта меню: ");
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    boolean state = true;
                    while (state) {
                        System.out.println("Введите номер месяца (от 1 до 12) : ");
                        monthNum = scanner.nextInt();
                        if (monthNum < 1 || monthNum > 12) {
                            System.out.println("!!!Номер месяца должен быть от 1 до 12");
                        } else {
                            state = false;
                        }
                    }

                    state = true;
                    while (state){
                        System.out.println("Введите день (от 1 до 30) : ");
                        DayNum = scanner.nextInt();
                        if (DayNum<1 || DayNum>30){
                            System.out.println("!!!День должен быть от 1 до 30");
                        }else {
                            state = false;
                        }
                    }

                    state = true;
                    while (state){
                        System.out.println("Введите колличество шагов : ");
                        numberOfSteps = scanner.nextInt();
                        if (numberOfSteps<0){
                            System.out.println("!!!Колличество шагов должно быть больше 0.");
                        }else {
                            state = false;
                        }
                    }

                    stepTracker.saveSteps(monthNum, DayNum, numberOfSteps);

                    break;
                case 2:
                    monthNum = 0;
                    state = true;
                    while (state) {
                        System.out.println("Введите номер месяца (от 1 до 12) за который нужна статистка : ");
                        monthNum = scanner.nextInt();
                        if (monthNum < 1 || monthNum > 12) {
                            System.out.println("!!!Номер месяца должен быть от 1 до 12");
                        } else {
                            state = false;
                        }
                    }
                    stepTracker.statistic(monthNum);
                    break;
                case 3:
                    System.out.println("Текущая цель: " + stepTracker.goalStep);
                    int goal = 0;
                    state = true;
                    while (state) {
                        System.out.println("Введите новую цель: ");
                        goal = scanner.nextInt();
                        if (goal<0) {
                            System.out.println("!!! Цель должна быть больше 0");
                        } else {
                            state = false;
                        }
                    }
                    stepTracker.setGoalStep(goal);
                    break;
                case 4:
                    stopMenu = true;
                    break;
                default :
                    System.out.println("Такого пункта нет в меню.");
            }

        }
    }

        public static void menuPrint() {
            System.out.println("Меню программы <<Счетчик калорий>>:");
            System.out.println("1.  Ввести количество шагов за определённый день");
            System.out.println("2.  Напечатать статистику за определённый месяц");
            System.out.println("3.  Изменить цель по количеству шагов в день");
            System.out.println("4.  Выйти из приложения.");
        }


}
