import java.util.List;

/**
 * Created by xbhuang on 14-3-29.
 */
public class CompareResult {
    private String result;
    private final List<Integer> correctPos;

    public CompareResult(String result, List<Integer> correctPos) {
        this.result = result;
        this.correctPos = correctPos;
    }

    public String getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompareResult that = (CompareResult) o;

        if (correctPos != null ? !correctPos.equals(that.correctPos) : that.correctPos != null) return false;
        if (result != null ? !result.equals(that.result) : that.result != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = result != null ? result.hashCode() : 0;
        result1 = 31 * result1 + (correctPos != null ? correctPos.hashCode() : 0);
        return result1;
    }
}
