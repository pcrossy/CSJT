package logic.main.csjt.csjt;

/**
 * Created by JB on 28.04.2016.
 */
public class TextObject {
    public String text;
    public float x;
    public float y;
    public float[] color;

    public TextObject()
    {
        text = "default";
        x = 0f;
        y = 0f;
        color = new float[] {1f, 1f, 1f, 1.0f};
    }

    public TextObject(String txt, float xcoord, float ycoord)
    {
        text = txt;

        x = xcoord;
        y = ycoord;
        color = new float[] {1f, 1f, 1f, 1.0f};
    }
}

