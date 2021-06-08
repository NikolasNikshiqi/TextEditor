import javax.swing.*;
import java.awt.*;

public class TextArea extends JTextArea {


    TextArea(){
        this.setWrapStyleWord(true);
        this.setLineWrap(true);
        //this.setBackground(new Color(72, 66, 74));
    }
}
