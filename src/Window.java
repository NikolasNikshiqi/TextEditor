import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;


public class Window {
    JFrame frame = new JFrame();
    TextArea textArea = new TextArea();
    File chosen;

    public void init() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setTitle("Text editor");
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        frame.add(menuBar, BorderLayout.NORTH);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem menuOpen = new JMenuItem("Open");
        menuOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Opened");
                open();
            }
        });
        menu.add(menuOpen);

        JMenuItem menuSave = new JMenuItem("Save");
        menuSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Saved");
                save();
            }
        });
        menu.add(menuSave);

        JMenuItem menuNew = new JMenuItem("Save as");
        menuNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("New");
                saveAs();
            }
        });
        menu.add(menuNew);

        JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(scroll);

    }

    public void saveAs() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Create new document");
        fileChooser.showSaveDialog(null);

        String text = textArea.getText();
        try {
            Formatter formater = new Formatter(fileChooser.getSelectedFile());
            formater.format("%s",text);
            formater.close();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void open() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a file to open");
        fileChooser.showOpenDialog(null);

        chosen = fileChooser.getSelectedFile();
        textArea.setText(new Input(chosen).getString());


    }

    public void save() {

        String info = textArea.getText();
        try {
            Formatter formater = new Formatter(chosen);
            formater.format("%s", info);
            formater.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
