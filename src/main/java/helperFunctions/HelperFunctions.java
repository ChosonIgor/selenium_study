package helperFunctions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelperFunctions {

    public static String getRandomEmail() {
        Date dateNow = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("ddMMyyHHmm");
        return  "choson" + formater.format(dateNow) + "@bk.ru";
    }

    public static String getNameProduct() {
        Date dateNow = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("ddMMyyHHmm");
        return  "Tager" + formater.format(dateNow);

    }

}
