package seedu.address.ui.cards;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.address.ui.UiPart;

public class NameCard extends UiPart<Region> {
    private static final String FXML = "NameCard.fxml";

    @FXML
    private Label name;
    
    public NameCard(String value) {
        super(FXML);
        name.setText(value);
    }
}
