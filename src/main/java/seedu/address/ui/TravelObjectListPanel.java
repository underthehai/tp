package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;

/**
 * Panel containing the list of persons.
 */
public class TravelObjectListPanel extends UiPart<Region> {
    private static final String FXML = "TravelObjectListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(TravelObjectListPanel.class);

    @FXML
    private ListView<Person> travelObjectListView;

    /**
     * Creates a {@code TravelObjectListPanel} with the given {@code ObservableList}.
     */
    public TravelObjectListPanel(ObservableList<Person> personList) {
        super(FXML);
        travelObjectListView.setItems(personList);
        travelObjectListView.setCellFactory(listView -> new PersonListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class PersonListViewCell extends ListCell<Person> {
        @Override
        protected void updateItem(Person person, boolean empty) {
            super.updateItem(person, empty);

            if (empty || person == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new PersonCard(person, getIndex() + 1).getRoot());
            }
        }
    }

}
