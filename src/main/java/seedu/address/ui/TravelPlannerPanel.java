package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.travelplan.TravelPlan;
import seedu.address.model.travelplanner.ReadOnlyTravelPlanner;
import seedu.address.ui.cards.NameCard;

/**
 * Panel containing basic information of a Travel Plan.
 */
public class TravelPlannerPanel extends UiPart<Region> {
    private static final String FXML = "TravelPlannerPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(TravelPlanPanel.class);

    @FXML
    private ListView<TravelPlan> travelPlanListView;

    /**
     * Creates a {@code TravelPlanObjectListPanel} with the given {@code ObservableList}.
     */
    public TravelPlannerPanel(ReadOnlyTravelPlanner travelPlanner) {
        super(FXML);
        travelPlanListView.setItems(travelPlanner.getTravelPlanList());
        travelPlanListView.setCellFactory(travelPlan -> new TravelPlanListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class TravelPlanListViewCell extends ListCell<TravelPlan> {
        @Override
        protected void updateItem(TravelPlan travelPlan, boolean empty) {
            super.updateItem(travelPlan, empty);

            if (empty || travelPlan == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new NameCard(travelPlan.getName().toString()).getRoot());
            }
        }
    }

}
