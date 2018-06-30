package com.example.simon.funfacts;

public class MinutesCount {

    private int minutes;

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int calculateMinutes(String inputMinutes){
        String[] inputMinutesSplitted = inputMinutes.split(" ");
        int[] inputMinutesInts = new int[inputMinutesSplitted.length];

        for (int i = 0; i<inputMinutesInts.length; i++){
            inputMinutesInts[i] = Integer.parseInt(inputMinutesSplitted[i]);
        }
        for (int minute : inputMinutesInts) {
            minutes += minute;
        }
        return minutes;
    }

    public boolean checkMinutes(String inputMinutes){
        String[] inputMinutesSplitted = inputMinutes.split(" ");
        int[] inputMinutesInts = new int[inputMinutesSplitted.length];
        boolean check = true;
        for (int i = 0; i<inputMinutesInts.length; i++){
            try {
                inputMinutesInts[i] = Integer.parseInt(inputMinutesSplitted[i]);
                if (inputMinutesInts[i] > 59) {
                    check = false;
                }
            } catch (NumberFormatException e){
                check =  false;
            }
        }
        return check;
    }

    public int clearMinutes(){
        minutes = 0;
        return minutes;
    }

}
