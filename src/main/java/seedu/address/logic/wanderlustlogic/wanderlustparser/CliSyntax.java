package seedu.address.logic.wanderlustlogic.wanderlustparser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_LOCATION = new Prefix("l/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");
    public static final Prefix PREFIX_IMPORTANCE = new Prefix("i/");
    public static final Prefix PREFIX_COST = new Prefix("c/");
    public static final Prefix PREFIX_DATETIME = new Prefix("d/");
    public static final Prefix PREFIX_PASSPORT = new Prefix("P/");
    public static final Prefix PREFIX_START = new Prefix("sd/");
    public static final Prefix PREFIX_END = new Prefix("ed/");
    public static final Prefix PREFIX_MOBILE = new Prefix("m/");

    // keep so it compiles, delete later_
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
}
