package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.Logic;
import seedu.address.model.Directory;
import seedu.address.model.travelplan.TravelPlan;
import seedu.address.model.wishlist.Wishlist;


/**
 * Panel containing basic information of a Travel Plan.
 */
public class TravelPlanPanel extends UiPart<Region> {
    private static final String TravelPlanFXML = "TravelPlanPanel.fxml";
    private static final String TOTAL_COST = "Total Cost: ";
    private final Logger logger = LogsCenter.getLogger(TravelPlanPanel.class);

    private Directory directory;

    private Logic logic;

    @FXML
    private Label name;
    @FXML
    private Label startDateToEndDate;
    @FXML
    private Label totalCost;

    /**
     * Creates a {@code TravelPlanObjectListPanel} with the given {@code ObservableList}.
     */
    public TravelPlanPanel(Directory directory) {
        super(TravelPlanFXML);
        this.directory = directory;
        update();
    }

    /**
     * Updates the JavaFX properties of {@code TravelPlanPanel} according to the directory.
     */
    public void update() {
        if (directory instanceof TravelPlan) {
            TravelPlan travelPlan = (TravelPlan) directory;
            String cost = travelPlan.getTotalCost();
            name.setText(travelPlan.getName().toString());
            totalCost.setText(TOTAL_COST + cost);
            startDateToEndDate.setText(travelPlan.getStartDate().toString() + " to "
                    + travelPlan.getEndDate().toString());
        } else {
            name.setText("Wishlist");
            Wishlist wishlist = (Wishlist) directory;
            String cost = wishlist.getTotalCost();
            totalCost.setText(TOTAL_COST + cost);
            startDateToEndDate.setText("");
        }
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
        update();
    }
}
