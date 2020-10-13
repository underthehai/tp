package seedu.address.storage.travelplanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static seedu.address.testutil.typicals.TypicalTravelPlans.getTypicalTravelPlanner;

import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import seedu.address.commons.core.GuiSettings;
import seedu.address.model.accommodation.Accommodation;
import seedu.address.model.activity.Activity;
import seedu.address.model.friend.Friend;
import seedu.address.model.travelplan.AccommodationList;
import seedu.address.model.travelplan.ActivityList;
import seedu.address.model.travelplan.FriendList;
import seedu.address.model.travelplan.TravelPlan;
import seedu.address.model.travelplanner.ReadOnlyTravelPlanner;
import seedu.address.model.travelplanner.TravelPlanner;
import seedu.address.model.travelplanner.UserPrefs;
import seedu.address.testutil.builders.AccommodationBuilder;
import seedu.address.testutil.builders.ActivityBuilder;
import seedu.address.testutil.builders.FriendBuilder;
import seedu.address.testutil.builders.TravelPlanBuilder;

public class StorageManagerTest {

    @TempDir
    public Path testFolder;

    private StorageManager storageManager;

    @BeforeEach
    public void setUp() {
        JsonTravelPlannerStorage travelPlannerStorage = new JsonTravelPlannerStorage(getTempFilePath("tp"));
        JsonUserPrefsStorage userPrefsStorage = new JsonUserPrefsStorage((getTempFilePath("prefs")));
        storageManager = new StorageManager(travelPlannerStorage, userPrefsStorage);
    }

    private Path getTempFilePath(String fileName) {
        return testFolder.resolve(fileName);
    }

    @Test
    public void prefsReadSave() throws Exception {
        /*
         * Note: This is an integration test that verifies the StorageManager is properly wired to the
         * {@link JsonUserPrefsStorage} class.
         * More extensive testing of UserPref saving/reading is done in {@link JsonUserPrefsStorageTest} class.
         */
        UserPrefs original = new UserPrefs();
        original.setGuiSettings(new GuiSettings(300, 600, 4, 6));
        storageManager.saveUserPrefs(original);
        UserPrefs retrieved = storageManager.readUserPrefs().get();
        assertEquals(original, retrieved);
    }

    // Need Help Here!!
    @Test
    public void travelPlannerReadSave() throws Exception {
        /*
         * Note: This is an integration test that verifies the StorageManager is properly wired to the
         * {@link JsonTravelPlannerStorage} class.
         * More extensive testing of UserPref saving/reading is done in {@link JsonTravelPlannerStorageTest} class.
         */
        TravelPlanner original = getTypicalTravelPlanner();
        storageManager.saveTravelPlanner(original);
        ReadOnlyTravelPlanner retrieved = storageManager.readTravelPlanner().get();
        assertEquals(original, new TravelPlanner(retrieved));
    }

    @Test
    public void getTravelPlannerFilePath() {
        assertNotNull(storageManager.getTravelPlannerFilePath());
    }
}
