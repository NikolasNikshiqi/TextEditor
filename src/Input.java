import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Input {
    File file;

    private String content = "";
    Input(File path)  {
        file = path;
        try {
            content = new Scanner(file).useDelimiter("\\A").next();

        }catch (FileNotFoundException e){
            e.toString();
        }
    }
    public String getString(){
        return content;
    }
    public void setString(String newContent){
        content = newContent;
    }
}
