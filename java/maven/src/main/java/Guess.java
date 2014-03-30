/**
 * Created by BMM on 14-3-29.
 */
public class Guess {
    private CompareNumber compareNumber;
    private String random;
    private AnswerGenerator answerGenerator;


    public String guess(String input) {
        if(random == null){
            random = answerGenerator.generate();
        }
        return compareNumber.compare(random, input);
    }

    public void setCompareNumber(CompareNumber compareNumber) {
        this.compareNumber = compareNumber;
    }

    public void setAnswerGenerator(AnswerGenerator answerGenerator) {

        this.answerGenerator = answerGenerator;
    }

    public String getRandom(){
        return this.random;
    }
}
