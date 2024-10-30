package mail;

import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class RoomBox extends VBox {
    final static int SPACING = 10;
    private TextArea number;
    private TextArea name;

    public RoomBox(int number, String name) {
        super(SPACING);
        this.number = new TextArea("" + number);
        this.name = new TextArea(name);

        this.getChildren().addAll(this.number, this.name);
    }
}
