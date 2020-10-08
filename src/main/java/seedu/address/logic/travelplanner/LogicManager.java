package seedu.address.logic.travelplanner;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.AddressBookParser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.activity.Activity;
import seedu.address.model.commons.TravelPlanObject;
import seedu.address.model.travelplan.TravelPlan;
import seedu.address.model.travelplanner.Directory;
import seedu.address.model.travelplanner.Model;
import seedu.address.model.travelplanner.ReadOnlyTravelPlanner;
import seedu.address.storage.travelplanner.Storage;

/**
 * The main LogicManager of the app.
 */
public class LogicManager implements Logic {
    public static final String FILE_OPS_ERROR_MESSAGE = "Could not save data to file: ";
    private final Logger logger = LogsCenter.getLogger(LogicManager.class);

    private final Model model;
    private final Storage storage;
    private final AddressBookParser addressBookParser; /** TO BE UPDATED TO WANDERLUSTPARSER */

    /**
     * Constructs a {@code LogicManager} with the given {@code Model} and {@code Storage}.
     */
    public LogicManager(Model model, Storage storage) {
        this.model = model;
        this.storage = storage;
        addressBookParser = new AddressBookParser();
    }

    @Override
    public CommandResult execute(String commandText) throws CommandException, ParseException {
        logger.info("----------------[USER COMMAND][" + commandText + "]");

        CommandResult commandResult;
        Command command = addressBookParser.parseCommand(commandText);
        commandResult = command.execute(model);

        try {
            storage.saveTravelPlanner(model.getTravelPlanner());
        } catch (IOException ioe) {
            throw new CommandException(FILE_OPS_ERROR_MESSAGE + ioe, ioe);
        }

        return commandResult;
    }

    @Override
    public ReadOnlyTravelPlanner getTravelPlanner() {
        return model.getTravelPlanner();
    }

    @Override
    public ObservableList<TravelPlan> getFilteredTravelPlanList() {
        return model.getFilteredTravelPlanList();
    }

    @Override
    public ObservableList<Activity> getFilteredWishlist() {
        return model.getFilteredWishlist();
    }

    @Override
    public ObservableList<? extends TravelPlanObject> getFilteredTravelPlanObjectList() {
        return model.getFilteredTravelPlanObjectList();
    }
    
    @Override
    public Directory getDirectory() {
        return model.getDirectory();
    }

    @Override
    public Path getTravelPlannerFilePath() {
        return model.getTravelPlannerFilePath();
    }

    @Override
    public GuiSettings getGuiSettings() {
        return model.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        model.setGuiSettings(guiSettings);
    }
}
