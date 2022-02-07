import java.util.HashMap;

public class MonthData {

    HashMap<Integer,Integer> stepByDay;

    MonthData() {
        stepByDay = new HashMap<>();
        for(int day=1; day<=30; day++) {
            stepByDay.put(day, 0);
        }
    }

    void addMonthData(int DayNum,int numberOfSteps){
        stepByDay.put(DayNum,numberOfSteps);
        //System.out.println(stepByDay);
    }

    void printMonthData(){
        for(int day : stepByDay.keySet()){
            System.out.print(day + " день: " + stepByDay.get(day) + ", ");
        }
        System.out.print("\n");
    }
    int MonthSumSteps(){
        int sumSteps = 0;
        for(int stepInDay : stepByDay.values()){
            sumSteps+=stepInDay;
        }
        return sumSteps;
    }

    int MonthMaxSteps(){
        int maxSteps = 0;
        for(int stepInDay : stepByDay.values()){
            if(stepInDay>maxSteps){
                maxSteps = stepInDay;
            }
        }
        return maxSteps;
    }

    int MonthNumDayWithSteps(){
        int numDayWithSteps = 0;
        for(int stepInDay : stepByDay.values()){
            if(stepInDay !=0){
                numDayWithSteps+=1;
            }
        }
        return numDayWithSteps;
    }

    int MonthBestSeries(Integer goalStep){
        int BestSeries = 0;
        int Series = 0;
        for(int stepInDay : stepByDay.values()){
            if(stepInDay>=goalStep){
                Series++;
            } else {
                Series = 0;
            }
            if(BestSeries < Series){
                BestSeries = Series;
             }
        }
        return BestSeries;
    }


}
