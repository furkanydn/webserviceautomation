package pageAction;

import base.Base;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("deprecation")
public class PageActions extends Base {
    protected static RequestSpecification requestSpec;
    protected static Response response;
    protected String boardId;

    private List<String> cardId = new ArrayList<>();
    JsonObject jsonObject = new JsonObject();
    JsonParser jsonParser = new JsonParser();

    public enum CardOrBoard{ CARD, BOARD }
    public enum Methods{ POST, PUT, DELETE }

    /**
     * The TrelloProcess method was designed and written as a method where all expected operations can be performed.
     * This method should be executed before all tests in the current test class.
     *
     *@param   cb  These are enum types used to specify which operation should be performed on.
     *Constants can be used as <code>CARD and BOARD</code>
     *@param   methodType  HTTP works as a request-response protocol between a client and server. It may be necessary to use markers that indicate what to do in it.
     *Constants can be used as <code>POST, PUT and DELETE</code>
     *@param   cbName  These are the variable used to specify the header values of the action.
     *@param   num  These are the variable used to specify the content values of the action.
     *
     *@since 1.0.0
     *@see <a href="https://developer.atlassian.com/cloud/trello/guides/rest-api/action-types/">for more details.</a>
     *@author Furkan AYDIN
     */
    public void TrelloProcess(CardOrBoard cb, Methods methodType, @Nullable String cbName,@Nullable Integer num){
        try {
            jsonObject.add("key",jsonParser.parse(KEY));
            jsonObject.add("token",jsonParser.parse(TOKEN));
            switch (cb){
                case BOARD:
                    switch (methodType){
                        case POST:
                            jsonObject.add("name",jsonParser.parse(cbName));
                            requestSpec = RestAssured.given();
                            requestSpec.header("Content-type", "application/json");
                            requestSpec.body(jsonObject.toString());
                            response = requestSpec.request(Method.POST,"/boards");
                            boardId=response.jsonPath().getString("id");
                            break;
                        case DELETE:
                            requestSpec.header("Content-type", "application/json");
                            requestSpec.body(jsonObject.toString());
                            response = requestSpec.request(Method.DELETE,"/boards/"+boardId);
                            break;
                    }
                    break;
                case CARD:
                    switch (methodType){
                        case POST:
                            jsonObject.add("name",jsonParser.parse(cbName));
                            jsonObject.add("idlist",jsonParser.parse(boardId));
                            requestSpec.header("Content-type", "application/json");
                            requestSpec.body(jsonObject.toString());
                            response = requestSpec.request(Method.POST,"/cards");
                            cardId= Collections.singletonList(response.jsonPath().getString("id"));
                            break;
                        case PUT:
                            String id = cardId.get(num);
                            jsonObject.add("name",jsonParser.parse(cbName));
                            requestSpec.header("Content-type", "application/json");
                            requestSpec.body(jsonObject.toString());
                            response = requestSpec.request(Method.PUT,"/cards/"+id);
                            break;
                        case DELETE:
                            String cardID = cardId.get(num);
                            requestSpec.header("Content-type", "application/json");
                            requestSpec.body(jsonObject.toString());
                            response = requestSpec.request(Method.DELETE,"/cards/"+cardID);
                            break;
                    }
                    break;
            }
        } catch (Exception e){
            throw new RuntimeException("Some parameter is null");
        }
    }
}
