package helperFunctions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelperFunctions {

    public static String getRandomEmail() {
        Date dateNow = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("ddMMyyHHmmss");
        return  "choson" + formater.format(dateNow) + "@bk.ru";
    }



}
