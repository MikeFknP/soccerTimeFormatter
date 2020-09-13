import org.apache.commons.lang3.time.DateUtils;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    // 1-Receber input
    // 2-Validar input DONE
    // 3-

    public static void main(String[] args) throws ParseException {

        HashMap<String, String> periods = new HashMap<String, String>();
        periods.put("[PM]", "PRE_MATCH");
        periods.put("[H1]", "FIRST_HALF");
        periods.put("[HT]", "HALF_TIME");
        periods.put("[H2]", "SECOND_HALF");
        periods.put("[FT]", "FULL_TIME");

        FormatPeriodAndTime formattor = new FormatPeriodAndTime();
        Scanner scanner = new Scanner(System.in);
        InputValidator ip = new InputValidator();
        System.out.println("Welcome!");
        System.out.println("please type: ");
        while (scanner.hasNextLine()) {



            String input = scanner.nextLine();
            boolean isValid = ip.validateInput(input);
            String[] inputs = input.split(" ");

            //Validate the format
            if (!isValid) {
                System.out.println(" ");
                System.out.println("INVALID");
                System.out.println(" ");
                System.out.println("please type: ");
                continue;
            }

            if(inputs[0].equals("[PM]") && !inputs[1].equals("0:00.000")){
                System.out.println(" ");
                System.out.println("INVALID");
                System.out.println(" ");
                System.out.println("please type: ");
                continue;
            }

            if(inputs[0].equals("[HT]") && !inputs[1].equals("45:00.000")){
                System.out.println(" ");
                System.out.println("INVALID");
                System.out.println(" ");
                System.out.println("please type: ");
                continue;
            }

            if(inputs[0].equals("[FT]") && !inputs[1].equals("90:00.000")){
                System.out.println(" ");
                System.out.println("INVALID");
                System.out.println(" ");
                System.out.println("please type: ");
                continue;
            }

            //Validate if period exists
            if (!periods.containsKey(inputs[0])) {
                System.out.println(" ");
                System.out.println("INVALID");
                System.out.println(" ");
                System.out.println("please type: ");
                continue;
            }


            String periodLongForm = "";

            //Gets the period correct fotmat
            if (periods.containsKey(inputs[0])) {
                periodLongForm = periods.get(inputs[0]);

            }


            String timeAbs = inputs[1];


            String prefix = inputs[0];
            String time = "";


           String finalTime = formattor.getFormmatedTime(prefix,timeAbs,periodLongForm);


           String finalResult = buildFinalString(finalTime,periodLongForm);
            System.out.println(" ");
           System.out.println(finalResult);
            System.out.println(" ");
           System.out.println("please type: ");

        }

    }

    public static String buildFinalString(String time, String period){

        return time + " - " + period;

    }




}
