import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by BMM on 14-3-29.
 */
public class GuessTest {

    private Guess guess;
    private CompareNumber compareNumber;
    AnswerGenerator answerGenerator;

    @Before
    public void setUp() throws Exception {
        guess = new Guess();
        compareNumber = mock(CompareNumber.class);
        answerGenerator = mock(AnswerGenerator.class);
        guess.setAnswerGenerator(answerGenerator);
        guess.setCompareNumber(compareNumber);


    }

    @Test
    public void guess_should_return_compare_result() {
        when(answerGenerator.generate()).thenReturn("1234");
        when(compareNumber.compare("1234", "1234")).thenReturn("4A0B");
        assertThat(guess.guess("1234")).isEqualTo("4A0B");
    }


    @Test
    public void guess_should_use_number_compare() {
        when(answerGenerator.generate()).thenReturn("1234");
        when(compareNumber.compare("1234","4321")).thenReturn("0A4B");
        assertThat(guess.guess("4321")).isEqualTo("0A4B");
    }


}
