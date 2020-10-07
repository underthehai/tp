package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.activity.Activity;
import seedu.address.model.travelplan.ActivityList;
import seedu.address.model.wishlist.Wishlist;

public class TypicalActivities {

    public static final Activity ARCHERY = new ActivityBuilder().withName("Archery!")
            .withCost("100.50").withLevelOfImportance("1")
            .withLocation("92 Archery Avenue")
            .withDateTime("2020-09-09 09:00").build();
    public static final Activity BUNGEEJUMPING = new ActivityBuilder().withName("Bungee Jumping")
            .withCost("225.99").withLevelOfImportance("5")
            .withLocation("1 BungeeJump Gateway")
            .withDateTime("2020-01-01 14:00").build();
    public static final Activity CAMPING = new ActivityBuilder().withName("Camping")
            .withCost("10").withLevelOfImportance("2")
            .withLocation("100 Secret Woods")
            .withDateTime("2020-10-11 20:00").build();
    public static final Activity DONUTDATE = new ActivityBuilder().withName("Donut Date")
            .withCost("2").withLevelOfImportance("1")
            .withLocation("Dunkin Donut Palace")
            .withDateTime("2020-11-11 11:00").build();
    
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
     * Returns a {@code Wishlist} with all the typical activities.
     */
    public static Wishlist getTypicalWishlist() {
        Wishlist wl = new Wishlist();
        for (Activity activity : getTypicalActivities1()) {
            wl.addActivity(activity);
        }
        for (Activity activity : getTypicalActivities2()) {
            wl.addActivity(activity);
        }
        return wl;
    }

    /**
     * Returns an {@code ActivityList} with a set of typical activities (either set 1 or set 2).
     */
    public static ActivityList getTypicalActivityList(int set) {
        if (set != 1 && set != 2) {
            throw new IllegalArgumentException("getTypicalActivityList only takes in set 1 or 2 as argument.");
        }
        List<Activity> activities = set == 1 ? getTypicalActivities1() : getTypicalActivities2();
        ActivityList al = new ActivityList();
        for (Activity activity : activities) {
            al.addActivity(activity);
        }
        return al;
    }
    
    public static List<Activity> getTypicalActivities1() {
        return new ArrayList<>(Arrays.asList(ARCHERY, BUNGEEJUMPING, CAMPING, DONUTDATE));
    }

    public static List<Activity> getTypicalActivities2() {
        return new ArrayList<>(Arrays.asList(ZOO, THEMEPARK, SKIING, HIKING));
    }
}