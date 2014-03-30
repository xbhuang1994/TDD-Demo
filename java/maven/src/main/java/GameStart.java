import com.javafx.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by xbhuang on 14-3-29.
 */
public class GameStart {

    private Guess guess;

    private int count = 6;
    HashMap<Integer,Boolean> map = new HashMap<Integer, Boolean>();
    private GameModel gameModel;

    public int getCount() {
        return count;
    }

    public void seCount(int count) {
        this.count = count;
    }

    public void setGuess(Guess guess) {
        this.guess = guess;
    }

    public String gameRun(String s) {
        String res = guess.guess(s);
        String random = guess.getRandom();
        if (res.equals("4A0B")) {
            count = -1;
        } else {
            if(gameModel.equals(GameModel.Hard) && "0A0B".equals(res)){
                count -= 2;
            }else  if(gameModel.equals(GameModel.Impossible)){
                for(int i = s.length() -1 ;i >= 0 ;i--)
                if(random.substring(i).equals(s.substring(i))){
                    this.map.put(i,true);
                }
            }
            else{
                count --;
            }
        }
        return res;
    }


    public static void main(String[] args) throws IOException {
        System.out.println("Welcome!");
        GameStart gameStart = new GameStart();
        Guess guess = new Guess();
        guess.setAnswerGenerator(new AnswerGenerator());
        guess.setCompareNumber(new CompareNumber());
        gameStart.setGuess(guess);

        gameStart.seCount(6);

        while (gameStart.getCount() > 0) {
            System.out.println(String.format("Please is input your number(%d):", gameStart.getCount()));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = gameStart.gameRun(br.readLine());
            switch (gameStart.getCount()) {
                case -1:
                    System.out.println("Congratulations!");
                    break;
                case 0:
                    System.out.println("Game Over!");
                    break;
                default:
                    System.out.println(str);
                    break;
            }

        }
    }

    public void choseModel(String s) {
        if (s.equals("1")) {
            count = 12;
            gameModel = GameModel.Easy;
        } else if (s.equals("2")) {
            count = 6;
            gameModel = GameModel.Normal;
        } else if("3".equals(s)){
            count = 6;
            gameModel = GameModel.Hard;
        } else if("4".equals(s)){
            count = 7;
            gameModel = GameModel.Impossible;
        }
    }

    public GameModel getGameModel() {
        return gameModel;
    }
}
