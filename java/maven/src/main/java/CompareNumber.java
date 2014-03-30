import java.util.ArrayList;
import java.util.List;

/**
 * Created by BMM on 14-3-29.
 */
public class CompareNumber {
    public String compare(String origin, String input) {
        return newCompare(origin, input).getResult();
    }

    public CompareResult newCompare(String origin, String input) {
        int aCount = 0, bCount = 0;
        List<Integer> aCorrectPos = new ArrayList<Integer>();
        for(int i = 0; i < 4; i++) {
            char c = input.charAt(i);
            if (c == origin.charAt(i)) {
                aCorrectPos.add(i);
                aCount ++;
            } else if(origin.indexOf(c) != -1) {
                bCount ++;
            }
        }
        return new CompareResult(String.format("%dA%dB",aCount,bCount),aCorrectPos);

    }
}
