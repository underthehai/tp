package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;
import seedu.address.model.travelplan.TravelPlan;

/**
 * Panel containing basic information of a Travel Plan.
 */
public class TravelPlanPanel extends UiPart<Region> {
    private static final String FXML = "TravelPlanPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(TravelPlanPanel.class);

    @FXML
    private Label name;
    @FXML
    private Label startDate;
    @FXML
    private Label endDate;

    /**
     * Creates a {@code TravelPlanObjectListPanel} with the given {@code ObservableList}.
     */
    public TravelPlanPanel(TravelPlan travelPlan) {
        super(FXML);
        name.setText(travelPlan.getName().toString());
        startDate.setText(travelPlan.getStartDate().toString());
        endDate.setText(travelPlan.getEndDate().toString());
    }

}
