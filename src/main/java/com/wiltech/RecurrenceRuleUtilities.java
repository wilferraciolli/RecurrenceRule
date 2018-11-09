package com.wiltech;

import net.fortuna.ical4j.model.*;
import net.fortuna.ical4j.model.component.VTimeZone;
import net.fortuna.ical4j.model.parameter.Value;

import java.text.ParseException;

/**
 * The type Recurrence rule utilities.
 */
public class RecurrenceRuleUtilities {

    public static void main(String[] args) {
        Recur recur;

            try {
                recur = new Recur("FREQ=WEEKLY;INTERVAL=1;BYDAY=FR;WKST=MO;UNTIL=20170428T00000Z;");
                //recur = new Recur("FREQ=WEEKLY;BYDAY=FR;INTERVAL=1;UNTIL=20170428");
                DateTime startDate = new DateTime("20160727T090000Z");
                Date endDate = recur.getUntil();
                DateTime baseDate = new DateTime( "20160727T130000Z");

                DateList dateList = recur.getDates(baseDate, startDate, endDate, Value.DATE_TIME);
                DateList dateListWithoutBaseDate = recur.getDates(startDate, endDate, Value.DATE_TIME);

                System.out.println(dateList);
                System.out.println("Th size of the list should be 40, but is is " + dateList.size());
               // System.out.println(endDate);

                System.out.println(dateListWithoutBaseDate);
                System.out.println("Th size of the list should be 40, but is is " + dateListWithoutBaseDate.size());
                System.out.println(endDate);

            } catch (ParseException e) {
                e.printStackTrace();
            }
    }
}
