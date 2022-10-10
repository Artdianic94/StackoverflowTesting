package staticdata;

import static staticdata.WebUrl.STACKEXCHANGE_URL;

public class Endpoints {
    public static final String ST_EX_10ANSWERS = "/answers?site=stackoverflow&page=1&pagesize=10&order=desc&sort=activity";
    public String getStackExchangeAnswers() {
        String StackExchangeAnswersURL = STACKEXCHANGE_URL.concat(ST_EX_10ANSWERS);
        return StackExchangeAnswersURL;
    }
}
