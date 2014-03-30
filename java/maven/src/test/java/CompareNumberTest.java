/**
 * Created by BMM on 14-3-29.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CompareNumberTest {
    @Test
    public void compare_all_right_test() {
        CompareResult expectedResult = new CompareResult("4A0B", Arrays.asList(0, 1, 2, 3));
        assertThat(new CompareNumber().newCompare("1234", "1234")).isEqualTo(expectedResult);
    }

    @Test
    public void compare_number_right_but_location_wrong_test() {
        assertThat(new CompareNumber().compare("1234", "4321")).isEqualTo("0A4B");
    }

    @Test
    public void compare_number_some_right_and_some_wrong_test() {
        assertThat(new CompareNumber().compare("1234", "1356")).isEqualTo("1A1B");
    }

    @Test
    public void compare_all_wrong_test() {
        assertThat(new CompareNumber().compare("1234", "5678")).isEqualTo("0A0B");
    }


}
