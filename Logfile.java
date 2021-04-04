import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Logfile extends Observer {
    private String filename;
    private Logger logger;
    private FileHandler fh;

    public Logfile(String filename) {
        try {
            this.filename = filename;
            fh = new FileHandler("./" + this.filename + ".log");
            logger = Logger.getLogger(filename);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.addHandler(fh);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(Object detail) {
        logger.info((String) detail);
    }

}