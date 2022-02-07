public class Converter {
    double distStep = 0.00075;
    double ccalStep = 50*0.001;

   // Converter (){};

    double convertStepToDist (int steps){
     return steps*distStep;
    }

    double convertStepToCcal (int steps){
        return steps*ccalStep;
    }
}
