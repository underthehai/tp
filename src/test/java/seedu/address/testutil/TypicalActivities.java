package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.activity.Activity;
import seedu.address.model.commons.Name;
import seedu.address.model.commons.WanderlustDate;
import seedu.address.model.travelplan.TravelPlan;

public class TypicalActivities {

    public static final Activity ZOO = new ActivityBuilder().withName("Singapore Mandai Zoo")
            .withCost("100").withLevelOfImportance("3")
            .withLocation("124 Mandai Road")
            .withDateTime("2020-10-10 12:00").build();
    public static final Activity THEMEPARK = new ActivityBuilder().withName("Universal Studios Singapore")
            .withCost("80").withLevelOfImportance("5")
            .withLocation("8 Sentosa Gateway")
            .withDateTime("2020-10-11 12:00").build();
    public static final Activity SKIING = new ActivityBuilder().withName("Gore Mountain Skiing Resort")
            .withCost("300").withLevelOfImportance("4")
            .withLocation("793 Peaceful Valley Rd")
            .withDateTime("2020-12-12 12:00").build();
    public static final Activity HIKING = new ActivityBuilder().withName("Treetop Walk")
            .withCost("0").withLevelOfImportance("2")
            .withLocation("601 Island Club Rd")
            .withDateTime("2020-01-10 12:00").build();

    private TypicalActivities() {} // prevents instantiation

    /**
     * Returns an {@code TravelPlan} with all the typical activities.
     */
    public static TravelPlan getTypicalTravelPlan() {
        TravelPlan tp = new TravelPlan(new Name("plan"), new WanderlustDate("10-10-2020"),
                new WanderlustDate("20-10-2020"), null);
        for (Activity activity : getTypicalActivities()) {
            tp.addTravelPlanObject(activity);
        }
        return tp;
    }

    public static List<Activity> getTypicalActivities() {
        return new ArrayList<>(Arrays.asList(ZOO, THEMEPARK, SKIING, HIKING));
    }
}
