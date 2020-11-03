package seedu.address.logic.command;

import static seedu.address.commons.core.Messages.*;
import static seedu.address.testutil.typicals.TypicalTravelPlans.getTypicalTravelPlanner;
import static seedu.address.logic.command.CommandTestUtil.assertFindCommandSuccess;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.logic.parser.FindCommandParser;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.TravelPlanner;
import seedu.address.model.UserPrefs;
import seedu.address.model.commons.NameContainsKeywordsPredicate;

/**
 * Tests the properties of find command
 * Only full words will be matched e.g. `Han` will not match `Hans`
 */
public class FindCommandTest {

    private Model model;

    @BeforeEach
    public void setup() {
        model = new ModelManager(getTypicalTravelPlanner(), new UserPrefs());
        model.setDirectory(0);
    }

    @Test
    public void execute_findFriend_success() {
        List<String> keywords = Arrays.asList("Alice");
        NameContainsKeywordsPredicate predicate = new NameContainsKeywordsPredicate(keywords);

        ModelManager expectedModel = new ModelManager(new TravelPlanner(model.getTravelPlanner()), new UserPrefs());
        expectedModel.setDirectory(0);
        expectedModel.updateFilteredFriendList(predicate);
        int expectedSize = expectedModel.getFilteredFriendList().size();
        String expectedMessage = String.format(MESSAGE_FRIENDS_LISTED_OVERVIEW, expectedSize);

        FindCommand findFriendCommand = new FindCommand(new NameContainsKeywordsPredicate(keywords), ParserUtil.FRIEND_INDEX);
        assertFindCommandSuccess(findFriendCommand, ParserUtil.FRIEND_INDEX, model, expectedMessage, expectedModel);
    }

    /**
     * Travel Plan Object matching at least one keyword will be returned.
     * 'Alice Meier' and 'Daniel Meier' matches keyword 'Meier'.
     */
    @Test
    public void execute_findMatchMultiple_success() {
        List<String> keywords = Arrays.asList("Meier");
        NameContainsKeywordsPredicate predicate = new NameContainsKeywordsPredicate(keywords);

        ModelManager expectedModel = new ModelManager(new TravelPlanner(model.getTravelPlanner()), new UserPrefs());
        expectedModel.setDirectory(0);
        expectedModel.updateFilteredFriendList(predicate);
        int expectedSize = expectedModel.getFilteredFriendList().size(); //2 matches Alice Meier and Daniel Meier

        assertTrue(expectedSize == 2);
    }

    /**
     * The search is case-insensitive. `alice` will match `Alice`
     */
    @Test
    public void execute_findCaseInsensitive_success() {

        NameContainsKeywordsPredicate predicate = new NameContainsKeywordsPredicate(Arrays.asList("alice"));
        NameContainsKeywordsPredicate testPredicate = new NameContainsKeywordsPredicate(Arrays.asList("Alice"));

        ModelManager expectedModel = new ModelManager(new TravelPlanner(model.getTravelPlanner()), new UserPrefs());
        expectedModel.setDirectory(0);
        expectedModel.updateFilteredFriendList(predicate); //expected model uses testPredicate
        int expectedSize = expectedModel.getFilteredFriendList().size();
        String expectedMessage = String.format(MESSAGE_FRIENDS_LISTED_OVERVIEW, expectedSize);

        FindCommand findFriendCommand = new FindCommand(testPredicate, ParserUtil.FRIEND_INDEX); //actual model uses predicate
        assertFindCommandSuccess(findFriendCommand, ParserUtil.FRIEND_INDEX, model, expectedMessage, expectedModel);
    }

    /**
     * The order of the keywords does not matter. e.g. `alice benson` will match `benson alice`
     */
    @Test
    public void execute_findDifferentOrder_success() {

        NameContainsKeywordsPredicate predicate = new NameContainsKeywordsPredicate(Arrays.asList("alice benson"));
        NameContainsKeywordsPredicate testPredicate = new NameContainsKeywordsPredicate(Arrays.asList("benson alice"));

        ModelManager expectedModel = new ModelManager(new TravelPlanner(model.getTravelPlanner()), new UserPrefs());
        expectedModel.setDirectory(0);
        expectedModel.updateFilteredFriendList(predicate); //expected model uses testPredicate
        int expectedSize = expectedModel.getFilteredFriendList().size();
        String expectedMessage = String.format(MESSAGE_FRIENDS_LISTED_OVERVIEW, expectedSize);

        FindCommand findFriendCommand = new FindCommand(testPredicate, ParserUtil.FRIEND_INDEX); //actual model uses predicate
        assertFindCommandSuccess(findFriendCommand, ParserUtil.FRIEND_INDEX, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_findAccommodation_success() {
        List<String> keywords = Arrays.asList("inn");
        NameContainsKeywordsPredicate predicate = new NameContainsKeywordsPredicate(keywords);

        ModelManager expectedModel = new ModelManager(new TravelPlanner(model.getTravelPlanner()), new UserPrefs());
        expectedModel.setDirectory(0);
        expectedModel.updateFilteredAccommodationList(predicate);
        int expectedSize = expectedModel.getFilteredAccommodationList().size();
        String expectedMessage = String.format(MESSAGE_ACCOMMODATIONS_LISTED_OVERVIEW, expectedSize);

        FindCommand findAccommodation = new FindCommand(new NameContainsKeywordsPredicate(keywords), ParserUtil.ACCOMMODATION_INDEX);
        assertFindCommandSuccess(findAccommodation, ParserUtil.ACCOMMODATION_INDEX, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_findActivity_success() {
        List<String> keywords = Arrays.asList("archery");
        NameContainsKeywordsPredicate predicate = new NameContainsKeywordsPredicate(keywords);

        ModelManager expectedModel = new ModelManager(new TravelPlanner(model.getTravelPlanner()), new UserPrefs());
        expectedModel.setDirectory(0);
        expectedModel.updateFilteredActivityList(predicate);
        int expectedSize = expectedModel.getFilteredActivityList().size();
        String expectedMessage = String.format(MESSAGE_ACTIVITIES_LISTED_OVERVIEW, expectedSize);

        FindCommand findAccommodation = new FindCommand(new NameContainsKeywordsPredicate(keywords), ParserUtil.ACTIVITY_INDEX);
        assertFindCommandSuccess(findAccommodation, ParserUtil.ACTIVITY_INDEX, model, expectedMessage, expectedModel);
    }

}
