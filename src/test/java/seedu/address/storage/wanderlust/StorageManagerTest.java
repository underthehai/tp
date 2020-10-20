package seedu.address.storage.wanderlust;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static seedu.address.testutil.typicals.TypicalTravelPlans.getTypicalTravelPlanner;

import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import seedu.address.commons.core.GuiSettings;
import seedu.address.model.wanderlust.ReadOnlyTravelPlanner;
import seedu.address.model.wanderlust.TravelPlanner;
import seedu.address.model.wanderlust.UserPrefs;
import seedu.address.storage.JsonTravelPlannerStorage;
import seedu.address.storage.JsonUserPrefsStorage;
import seedu.address.storage.StorageManager;

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
