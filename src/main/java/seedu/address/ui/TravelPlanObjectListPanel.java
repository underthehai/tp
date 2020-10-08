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
    private ListView<Activity> activityListView;

    @FXML
    private ListView<Accommodation> accommodationListView;

    @FXML
    private ListView<Friend> friendListView;

    /**
     * Creates a {@code TravelPlanObjectListPanel} with the given {@code ObservableList}.
     */
    public TravelPlanObjectListPanel(ObservableList<Activity> activities, ObservableList<Accommodation> accommodations,
            ObservableList<Friend> friends) {
        super(FXML);
        activityListView.setItems(activities);
        activityListView.setCellFactory(listView -> new ActivityListViewCell());
        accommodationListView.setItems(accommodations);
        accommodationListView.setCellFactory(listView -> new AccommodationListViewCell());
        friendListView.setItems(friends);
        friendListView.setCellFactory(listView -> new FriendListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code TravelPlanObject} using the {@code ActivityCard}.
     */
    class ActivityListViewCell extends ListCell<Activity> {
        @Override
        protected void updateItem(Activity activity, boolean empty) {
            super.updateItem(activity, empty);

            if (empty || activity == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new ActivityCard(activity, getIndex() + 1).getRoot());
            }
        }
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code TravelPlanObject} using the
     * {@code AccommodationCard}.
     */
    class AccommodationListViewCell extends ListCell<Accommodation> {
        @Override
        protected void updateItem(Accommodation accommodation, boolean empty) {
            super.updateItem(accommodation, empty);

            if (empty || accommodation == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new AccommodationCard(accommodation, getIndex() + 1).getRoot());
            }
        }
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code TravelPlanObject} using the {@code FriendCard}.
     */
    class FriendListViewCell extends ListCell<Friend> {
        @Override
        protected void updateItem(Friend friend, boolean empty) {
            super.updateItem(friend, empty);

            if (empty || friend == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new FriendCard(friend, getIndex() + 1).getRoot());
            }
        }
    }

}
