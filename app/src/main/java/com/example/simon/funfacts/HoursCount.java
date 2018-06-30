package com.example.simon.funfacts;

public class HoursCount {
    private int hours;

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int calculateHours(String inputHours){
        String[] inputHoursSplitted = inputHours.split(" ");
        int[] inputHoursInts = new int[inputHoursSplitted.length];

        for (int i = 0; i<inputHoursInts.length; i++){
            inputHoursInts[i] = Integer.parseInt(inputHoursSplitted[i]);
        }
        for (int hour : inputHoursInts) {
            hours += hour;
        }
        return hours;
    }

    public boolean checkHours(String inputHours){
        String[] inputHoursSplitted = inputHours.split(" ");
        int[] inputHoursInts = new int[inputHoursSplitted.length];
        boolean check = true;
        for (int i = 0; i<inputHoursInts.length; i++){
            try {
                inputHoursInts[i] = Integer.parseInt(inputHoursSplitted[i]);
            } catch (NumberFormatException e){
                check =  false;
            }
        }
        return check;
    }

    public int clearHours() {
        hours = 0;
        return hours;
    }
}
