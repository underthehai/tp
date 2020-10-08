package seedu.address.ui;

import java.util.logging.Logger;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.accommodation.Accommodation;
import seedu.address.model.activity.Activity;
import seedu.address.model.commons.TravelPlanObject;
import seedu.address.model.friend.Friend;
import seedu.address.ui.cards.AccommodationCard;
import seedu.address.ui.cards.ActivityCard;
import seedu.address.ui.cards.FriendCard;

/**
 * Panel containing the list of travel plan objects.
 */
public class TravelPlanObjectListPanel extends UiPart<Region> {
    private static final String FXML = "TravelPlanObjectListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(TravelPlanObjectListPanel.class);

    @FXML
    private ListView<TravelPlanObject> travelPlanObjectListView;

    /**
     * Creates a {@code TravelPlanObjectListPanel} with the given {@code ObservableList}.
     */
    public TravelPlanObjectListPanel(ObservableList<? extends TravelPlanObject> travelPlanObjectList) {
        super(FXML);
        travelPlanObjectListView.setItems(toObservableTpoList(travelPlanObjectList));
        travelPlanObjectListView.setCellFactory(listView -> new TravelPlanObjectListViewCell());
    }

    private ObservableList<TravelPlanObject> toObservableTpoList(ObservableList<? extends TravelPlanObject> list) {
        return list.stream().map(item -> (TravelPlanObject) item)
                .collect(Collectors.collectingAndThen(Collectors.toList(), l -> FXCollections.observableArrayList(l)));
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code TravelPlanObject} using the respective
     * {@code ActivityCard}, {@code FriendCard} or {@code AccommodationCard}.
     */
    class TravelPlanObjectListViewCell extends ListCell<TravelPlanObject> {
        @Override
        protected void updateItem(TravelPlanObject travelPlanObject, boolean empty) {
            super.updateItem(travelPlanObject, empty);

            if (empty || travelPlanObject == null) {
                setGraphic(null);
                setText(null);
            } else {
                if (travelPlanObject instanceof Activity) {
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
