package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public class Base {
    //
    protected static RequestSpecBuilder requestSpecBuilder;
    protected static RequestSpecification requestSpecification;
    //
    protected static final String TOKEN="8003c5b82c32140fee51cca74e2643e225094b26ae73c44abc289e52c43c02a5";
    protected static final String KEY="d10bc5b299129d70ec40618453d73a36";
    //
    protected static final String BASEURL="https://api.trello.com/1";
    protected static final String BOARDS = "/boards";
    protected static final String LISTS = "/lists";
    protected static final String CARDS = "/cards";
    protected static final String ORGANIZATIONS = "/organizations";

    /**
     * BeforeAll is used to signal that the annotated method should be executed before all tests in the current test class.
     *
     * @see <a href="https://junit.org/junit5/docs/current/api/org.junit.jupiter.api/org/junit/jupiter/api/BeforeAll.html">Annotation Interface BeforeAll</a>
     * for more details.
     */
    @BeforeAll
    public static void BeforeMethod(){
        //todo
        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addQueryParam("key", KEY);
        requestSpecBuilder.addQueryParam("token",TOKEN);
        requestSpecification = requestSpecBuilder.build();
    }
}
