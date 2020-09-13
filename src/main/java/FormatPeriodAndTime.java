import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class FormatPeriodAndTime {

    public String getExtraTime(String roundedTimeIn, float periodTimeInFloat) {

        String roundedTime = getRoundedTime(roundedTimeIn);
        String[] finalMinutesAndSeconds = roundedTime.split(":");


        //Get the minutes to get ExtraTime
        float periodTime = periodTimeInFloat;
        String finalMinutes = finalMinutesAndSeconds[0];
        String finalSeconds = finalMinutesAndSeconds[1];

        //Convert to calculate extra timea
        float minutesInFloat = Float.parseFloat(finalMinutes);
        float secondsInFlat = (Float.parseFloat(finalSeconds));

        float extraMinutes = minutesInFloat - periodTime;

        String finalMinutesInString = String.valueOf(Math.round(extraMinutes));
        String finalSecondsInString = String.valueOf(Math.round(secondsInFlat));


        if(finalMinutesInString.length() == 1){
            finalMinutesInString = "0" + finalMinutesInString;
        }

        if(finalSecondsInString.length() == 1){
            finalSecondsInString = "0" + finalSecondsInString;
        }

        String finalExtraTimeString = finalMinutesInString + ":" + finalSecondsInString;
        return finalExtraTimeString;
    }




    //Get formatted Time
    public String getFormmatedTime(String prefix,String timeAbs,String periodLongForm) {
        String time = "";

        if (prefix.equals("[PM]")) {
            time = "00:00";

            return time;
        }

        if (prefix.equals("[HT]")) {
            time = "45:00";
            return time;
        }

        if (prefix.equals("[FT]")) {
            time = "90:00 +00:00";

            return time;
        }

        if (prefix.equals("[H1]")) {
            String periodTime = "45:00";
            time = getRoundedTime(timeAbs);
            String[] timeStr = time.split(":");

            float timeInF = Float.parseFloat(timeStr[0]) + Float.parseFloat(timeStr[1]);
            if (timeInF >= 45.00f) {
                time = getExtraTime(time, 45);
                return periodTime + " +" +time;
            }


        }

        if (prefix.equals("[H2]")) {
            String periodTime = "90:00";
            time = getRoundedTime(timeAbs);
            String[] timeStr = time.split(":");
            float timeInF = Float.parseFloat(timeStr[0]) + Float.parseFloat("0." + timeStr[1]);

            if (timeInF > 90.00f) {
                time = getExtraTime(time, 90);

                return periodTime + " +" +time;
            }

            return time;

        }

        return time;

    }

    public String getRoundedTime(String timeInput){

        String[] splitTime = timeInput.split(":");
        String secondsAndMilli = splitTime[1];
        String minutes = splitTime[0];
        float time = Float.parseFloat(secondsAndMilli);
        float roundedSecond = Math.round(Float.parseFloat(secondsAndMilli));

        DecimalFormat df = new DecimalFormat("#.##");

        String formattedSeconds = df.format(roundedSecond);

        String finalRoundedSecs = "";
        String finalRoundedMins = "";

        if(formattedSeconds.length() == 1){
            finalRoundedSecs = "0"+formattedSeconds;
        }

        if(formattedSeconds.length() == 2){
            finalRoundedSecs = formattedSeconds;
        }

        if(minutes.length() == 1){
            finalRoundedMins= "0"+minutes;
        }

        if(minutes.length() == 2){
            finalRoundedMins = minutes;
        }

        return finalRoundedMins + ":" +finalRoundedSecs;

    }

}
