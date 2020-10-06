package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.accommodation.Accommodation;
import seedu.address.model.activity.Activity;
import seedu.address.model.friend.Friend;
import seedu.address.model.person.Person;
import seedu.address.model.commons.TravelPlanObject;
import seedu.address.ui.cards.AccommodationCard;
import seedu.address.ui.cards.ActivityCard;
import seedu.address.ui.cards.FriendCard;

/**
 * Panel containing the list of persons.
 */
public class TravelPlanObjectListPanel extends UiPart<Region> {
    private static final String FXML = "TravelPlanObjectListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(TravelPlanObjectListPanel.class);

    @FXML
    private ListView<TravelPlanObject> travelPlanObjectListView;

    /**
     * Creates a {@code TravelPlanObjectListPanel} with the given {@code ObservableList}.
     */
    public TravelPlanObjectListPanel(ObservableList<TravelPlanObject> travelPlanObjectList) {
        super(FXML);
        travelPlanObjectListView.setItems(travelPlanObjectList);
        travelPlanObjectListView.setCellFactory(listView -> new TravelPlanObjectListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class TravelPlanObjectListViewCell extends ListCell<TravelPlanObject> {
        @Override
        protected void updateItem(TravelPlanObject travelPlanObject, boolean empty) {
            super.updateItem(travelPlanObject, empty);

            if (empty || travelPlanObject == null) {
                setGraphic(null);
                setText(null);
            } else {
                if (travelPlanObject instanceof Person) { // For testing purposes only, to be removed
                    setGraphic(new PersonCard((Person) travelPlanObject, getIndex() + 1).getRoot());   
                } else if (travelPlanObject instanceof Activity) {
                    setGraphic(new ActivityCard((Activity) travelPlanObject, getIndex() + 1).getRoot());
                } else if (travelPlanObject instanceof Accommodation) {
                    setGraphic(new AccommodationCard((Accommodation) travelPlanObject, getIndex() + 1).getRoot());
                } else { // if travelPlanObject instanceof Friend
                    setGraphic(new FriendCard((Friend) travelPlanObject, getIndex() + 1).getRoot());
                }
            }
        }
    }

}
