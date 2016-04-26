package usermanage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hsenid on 4/26/16.
 */
public class UserValidate {

    //validate the date validity
    public static boolean isValidDate(String date)

    {
        // set date format, this can be changed to whatever format

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        // declare and initialize testDate variable, this is what will hold converted date

        Date testDate = null;

        // we will now try to parse the string into date form

        try

        {
            testDate = sdf.parse(date);

        }

        // if the format of the string provided doesn't match the format we

        // declared in SimpleDateFormat() we will get an exception

        catch (ParseException e)

        {
          /*  errorMessage = "the date you provided is in an invalid date" +

            " format.";*/
            return false;
        }


        // This statement will make sure that once the string

        // has been checked for proper formatting that the date is still the

        // date that was entered, if it's not, we assume that the date is invalid


        if (!sdf.format(testDate).equals(date))

        {
          /*  errorMessage = "The date that you provided is invalid.";*/
            return false;

        }
        // if we make it to here without getting an error it is assumed that
        // the date was a valid one and that it's in the proper format

        return true;

    }



}
