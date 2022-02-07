import java.util.HashMap;

public class StepTracker {

    HashMap<Integer,MonthData> monthToData = new HashMap<>();
    Converter converter = new Converter();
    Integer goalStep = 10000;

    public StepTracker(){
        for(int month=1; month<=12; month++){
            monthToData.put(month, new MonthData());
        }
    }


    void saveSteps(int monthNum,int DayNum,int numberOfSteps){
        monthToData.get(monthNum).addMonthData(DayNum,numberOfSteps);
    }

    void statistic (int monthNum){
        MonthData currentMonth = monthToData.get(monthNum);
        currentMonth.printMonthData();
        System.out.println("Общее количество шагов за месяц: " + currentMonth.MonthSumSteps());
        System.out.println("Максимальное пройденное количество шагов в месяце: " + currentMonth.MonthMaxSteps());

        if (currentMonth.MonthNumDayWithSteps() != 0) { //проверка деления на 0
            System.out.println("Среднее количество шагов:" + (currentMonth.MonthSumSteps())/(currentMonth.MonthNumDayWithSteps()));
        }else {
            System.out.println("Среднее количество шагов: 0");
        }
        System.out.println("Пройденная дистанция: " + converter.convertStepToDist(currentMonth.MonthSumSteps()) + " км.");
        System.out.println("Количество сожженных килокалорий: " + converter.convertStepToCcal(currentMonth.MonthSumSteps()) + " Ккал.");
        System.out.println("Лучшая серия дней с выполненной целью: " + currentMonth.MonthBestSeries(goalStep));

    }

    void setGoalStep(int goal){
        goalStep = goal;
    }

}
