import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by xbhuang on 14-3-29.
 */
public class GameStartTest {

    private GameStart gameStart;
    private Guess guess;
    private CompareNumber compareNumber;
    private AnswerGenerator answerGenerator;

    @Before
    public void setUp() throws Exception {
        gameStart = new GameStart();
        guess = mock(Guess.class);
        compareNumber = mock(CompareNumber.class);
        answerGenerator = mock(AnswerGenerator.class);
        guess.setAnswerGenerator(answerGenerator);
        guess.setCompareNumber(compareNumber);
        gameStart.setGuess(guess);
        gameStart.seCount(6);
    }

    @Test
    public void game_model_should_be_easy_when_user_chose_1() throws Exception {
        gameStart.choseModel("1");
        assertThat(gameStart.getCount()).isEqualTo(12);
        assertThat(gameStart.getGameModel()).isEqualTo(GameModel.Easy);
    }



    @Test
    public void game_model_should_be_Normal_when_user_chose_2() throws  Exception{
        gameStart.choseModel("2");
        assertThat(gameStart.getCount()).isEqualTo(6);
        assertThat(gameStart.getGameModel()).isEqualTo(GameModel.Normal);

    }

    @Test
    public void gameRunWinTrueTest(){
        when(answerGenerator.generate()).thenReturn("1234");
        when(compareNumber.compare("1234", "1234")).thenReturn("4A0B");
        when(guess.guess("1234")).thenReturn("4A0B");
        gameStart.choseModel("1");
        gameStart.gameRun("1234");
        assertThat(gameStart.getCount()).isEqualTo(-1);
    }

    @Test
    public void gameRunReturnFalseForHardTest(){
        when(answerGenerator.generate()).thenReturn("1234");
        when(compareNumber.compare("1234", "4321")).thenReturn("0A4B");
        when(guess.guess("4321")).thenReturn("0A4B");
        gameStart.choseModel("3");
        gameStart.gameRun("4321");
        assertThat(gameStart.getCount()).isEqualTo(5);
    }

    @Test
    public void gameRunReturnAllFalseForHardTest(){
        when(answerGenerator.generate()).thenReturn("1234");
        when(compareNumber.compare("1234", "5678")).thenReturn("0A0B");
        when(guess.guess("5678")).thenReturn("0A0B");
        gameStart.choseModel("3");
        gameStart.gameRun("5678");
        assertThat(gameStart.getCount()).isEqualTo(4);
    }

//    @Test
//    public void gameRunReturnFalseForImpossibleTest(){
//        when(answerGenerator.generate()).thenReturn("1234");
//        when(compareNumber.compare("1234", "1256")).thenReturn("2A0B");
//        when(guess.guess("1256")).thenReturn("2A0B");
//        gameStart.choseModel("4");
//        gameStart.gameRun("1256");
//        assertThat(gameStart.getCount()).isEqualTo(3);
//
//
//        when(compareNumber.compare("1234", "1246")).thenReturn("2A1B");
//        when(guess.guess("1246")).thenReturn("2A1B");
//        gameStart.gameRun("1246");
//        assertThat(gameStart.getCount()).isEqualTo(2);
//
//        when(compareNumber.compare("1234", "6234")).thenReturn("3A0B");
//        when(guess.guess("6234")).thenReturn("3A0B");
//        gameStart.gameRun("6234");
//        assertThat(gameStart.getCount()).isEqualTo(-1);
//    }

//    @Test
//    public void gameRunReturnOverTest(){
//        gameStart.seCount(1);
//        when(answerGenerator.generate()).thenReturn("1234");
//        when(compareNumber.compare("1234", "5678")).thenReturn("0A0B");
//        when(guess.guess("5678")).thenReturn("0A0B");
//        gameStart.choseModel("3");
//        gameStart.gameRun("5678");
//        assertThat(gameStart.getCount()).isEqualTo(-1);
//    }

}
