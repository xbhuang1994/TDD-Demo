import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by BMM on 14-3-29.
 */
public class AnswerGeneratorTest {


    @Test
    public void generate_return_4_length_test(){
        assertThat(new AnswerGenerator().generate().length()).isEqualTo(4);
    }

    @Test
    public void generate_result_char_no_be_same_test() {
        String result = (new AnswerGenerator()).generate();
        for(int i = 0; i < 4; i++) {
            assertThat(result.lastIndexOf(result.charAt(i))).isEqualTo(i);
        }
    }
}
