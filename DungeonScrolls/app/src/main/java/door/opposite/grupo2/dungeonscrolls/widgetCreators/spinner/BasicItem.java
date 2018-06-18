package door.opposite.grupo2.dungeonscrolls.widgetCreators.spinner;

/**
 * Created by Drayton80 on 18/06/18.
 */

public class BasicItem {
    private String text;
    private int image;

    public BasicItem(String text, int image){
        this.text  = text;
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
