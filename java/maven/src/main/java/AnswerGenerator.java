import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by BMM on 14-3-29.
 */
public class AnswerGenerator {
    public String generate() {
        String ret = "";
        Random rand = new Random();
        for(int i = 0; i < 4; i++) {
            int random;
            while(true) {
                random = rand.nextInt(10);
                if (ret.indexOf(""+random) == -1) {
                    ret += random;
                    break;
                }
            }
        }
        return ret;
    }
}
