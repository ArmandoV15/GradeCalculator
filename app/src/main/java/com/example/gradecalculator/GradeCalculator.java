package com.example.gradecalculator;

public class GradeCalculator {
    private float minAverage;
    private float currAverage;
    private float finPercentage;

    /**
     DVC for GradeCalculator class
     */
    public GradeCalculator(){
        minAverage = 0;
        currAverage= 0;
        finPercentage=0;
    }

    /**
     EVC for GradeCalculator class
     * @param minAverage Takes the minAverage entered by the user and sets it equal to this.minAverage
     * @param currAverage Takes the currAverage entered by the user and sets it equal to this.currAverage
     * @param finPercentage Takes the finPercentage entered by the user and sets it equal to this.finPercentage
     */
    public GradeCalculator(float minAverage, float currAverage, float finPercentage){
        this.minAverage = minAverage;
        this.currAverage = currAverage;
        this.finPercentage = finPercentage;
    }

    /**
     Uses values in minAverage, currAverage, and finPercentage to calculate the the percentage needed on the users final
     for them to get their desired grade
     * @return result * 100 which is there calculated percentage
     */
    public double calculateFinalGrade(){
        double finalPercent = this.finPercentage / 100;
        double numerator = this.minAverage - ((1 - finalPercent) * this.currAverage);

        double result = numerator / this.finPercentage;

        return result * 100;
    }

    /**
     Used to get the current value of minAverage
     * @return Value in minAverage
     */
    public double getMinAverage() {
        return minAverage;
    }

    /**
     Used to set the value of minAverage to any specific value
     * @param minAverage Users desired value
     */
    public void setMinAverage(float minAverage) {
        this.minAverage = minAverage;
    }

    /**
     Used to get the current value of currAverage
     * @return Value in currAverage
     */
    public double getCurrAverage() {
        return currAverage;
    }

    /**
     Used to set the value of currAverage to any specific value
     * @param currAverage Users desired value
     */
    public void setCurrAverage(float currAverage) {
        this.currAverage = currAverage;
    }

    /**
     Used to get the current value of finPercentage
     * @return Value in finPercentage
     */
    public double getFinPercentage() {
        return finPercentage;
    }

    /**
     Used to set the value of finPercentage to any specific value
     * @param finPercentage Users desired value
     */
    public void setFinPercentage(float finPercentage) {
        this.finPercentage = finPercentage;
    }
}
