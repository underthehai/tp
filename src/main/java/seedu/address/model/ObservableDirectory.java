package seedu.address.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.accommodation.Accommodation;
import seedu.address.model.activity.Activity;
import seedu.address.model.friend.Friend;
import seedu.address.model.travelplan.TravelPlan;

/**
 * Represents an observable view of the current directory.
 */
public class ObservableDirectory {
    private static final String TOTAL_COST = "Total Cost: $";

    private ObservableList<Activity> observableActivityList = FXCollections.observableArrayList();
    private ObservableList<Accommodation> observableAccommodationList = FXCollections.observableArrayList();
    private ObservableList<Friend> observableFriendList = FXCollections.observableArrayList();
    private ObservableList<Object> observableDirectoryInformation = FXCollections.observableArrayList();
    private ObjectProperty<Directory> dir = new SimpleObjectProperty<>();
    private StringProperty observableCost = new SimpleStringProperty();


    /**
     * Instantiates an observable view of the current directory.
     * @param directory the directory representing the default directory.
     */
    public ObservableDirectory(Directory directory) {
        dir.setValue(directory);
        observableCost.setValue(TOTAL_COST + directory.getTotalCost());
        this.observableActivityList.setAll(directory.getObservableActivityList());
        if (directory instanceof TravelPlan) {
            this.observableAccommodationList.setAll(((TravelPlan) directory).getObservableAccommodationList());
            this.observableFriendList.setAll(((TravelPlan) directory).getObservableFriendList());
        }
    }

    public StringProperty getObservableCost() {
        return observableCost;
    }

    public ObjectProperty<Directory> get() {
        return dir;
    }

    public ObservableList<Activity> getObservableActivityList() {
        return this.observableActivityList;
    }

    public ObservableList<Accommodation> getObservableAccommodationList() {
        return this.observableAccommodationList;
    }

    public ObservableList<Friend> getObservableFriendList() {
        return this.observableFriendList;
    }

    public void setObservableDirectory(Directory directory) {
        dir.setValue(directory);
        observableCost.setValue(TOTAL_COST + directory.getTotalCost());
        setObservableActivityList(directory.getObservableActivityList());
        if (directory instanceof TravelPlan) {
            setObservableAccommodationList(((TravelPlan) directory).getObservableAccommodationList());
            setObservableFriendList(((TravelPlan) directory).getObservableFriendList());
        } else {
            clearObservableAccommodationList();
            clearObservableFriendList();
        }
    }

    private void setObservableActivityList(ObservableList<Activity> newActivities) {
        this.observableActivityList.setAll(newActivities);
    }

    private void setObservableFriendList(ObservableList<Friend> newFriends) {
        this.observableFriendList.setAll(newFriends);
    }

    private void setObservableAccommodationList(ObservableList<Accommodation> newAccommodations) {
        this.observableAccommodationList.setAll(newAccommodations);
    }

    private void clearObservableActivityList() {
        this.observableActivityList.clear();
    }

    private void clearObservableFriendList() {
        this.observableFriendList.clear();
    }

    private void clearObservableAccommodationList() {
        this.observableAccommodationList.clear();
    }

}
