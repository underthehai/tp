package seedu.address.logic.travelplanner;

import java.nio.file.Path;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.activity.Activity;
import seedu.address.model.commons.TravelPlanObject;
import seedu.address.model.travelplan.TravelPlan;
import seedu.address.model.travelplanner.Directory;
import seedu.address.model.travelplanner.ReadOnlyTravelPlanner;

/**
 * API of the Logic component
 */
public interface Logic {
    /**
     * Executes the command and returns the result.
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws ParseException If an error occurs during parsing.
     */
    CommandResult execute(String commandText) throws CommandException, ParseException;

    /**
     * Returns the TravelPlanner.
     *
     * @see seedu.address.model.travelplanner.Model#getTravelPlanner()
     */
    ReadOnlyTravelPlanner getTravelPlanner();

    /** Returns an unmodifiable view of the filtered list of travelPlans. */
    ObservableList<TravelPlan> getFilteredTravelPlanList();

    /** Returns an unmodifiable view of the filtered list of wishlist activities. */
    ObservableList<Activity> getFilteredWishlist();
    
    /** Returns an unmodifiable view of the filtered list of travelPlanObjects. */
    ObservableList<? extends TravelPlanObject> getFilteredTravelPlanObjectList();

    /**
     * Returns the current directory.
     */
    Directory getDirectory();

    /**
     * Returns the user prefs' address book file path.
     */
    Path getTravelPlannerFilePath();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Set the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);
}
