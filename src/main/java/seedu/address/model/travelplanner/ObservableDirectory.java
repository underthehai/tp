package seedu.address.model.travelplanner;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class ObservableDirectory  {
    ObjectProperty<Directory> dir = new SimpleObjectProperty<>();

    public ObservableDirectory(Directory directory) {
        dir.setValue(directory);
    }

    public ObjectProperty<Directory> get() {
        return dir;
    }
}
