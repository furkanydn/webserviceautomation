package test;

import base.Base;
import org.junit.jupiter.api.*;
import pageAction.PageActions;

import java.util.logging.Level;
import java.util.logging.Logger;

import static pageAction.PageActions.Methods;
import static pageAction.PageActions.CardOrBoard;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TrelloApiTest extends Base {
    Logger logger = Logger.getLogger(TrelloApiTest.class.getName());
    PageActions pageActions = new PageActions();

    @BeforeAll
    public void BeforeAll() {
        BeforeAll();
        logger.setLevel(Level.FINE);
    }

    @Test @Order(0)
    public void CheckAbilityToCreateBoard(){
        logger.log(Level.INFO,"CheckAbilityToCreateBoard test started.");
        pageActions.TrelloProcess(CardOrBoard.BOARD, Methods.POST,"createBoard",null);
        logger.log(Level.INFO,"CheckAbilityToCreateBoard test finished.");
    }

    @Test @Order(1)
    public void CheckAbilityToCreateCardInsideBoard(){
        logger.log(Level.INFO,"CheckAbilityToCreateCardInsideBoard test started.");
        for (int i = 0; i < 2; i++) {
            pageActions.TrelloProcess(CardOrBoard.CARD, Methods.POST,"createTestCard"+i,null);
        }
        logger.log(Level.INFO,"CheckAbilityToCreateCardInsideBoard test finished.");
    }

    @Test @Order(2)
    public void CheckAbilityToEditRandomCard(){
        logger.log(Level.INFO,"CheckAbilityToEditRandomCard test started.");
        pageActions.TrelloProcess(CardOrBoard.CARD, Methods.PUT,"updateRandomCard", (int) (Math.random() * 2));
        logger.log(Level.INFO,"CheckAbilityToEditRandomCard test finished.");
    }

    @Test @Order(3)
    public void CheckAbilityToDeleteCards(){
        logger.log(Level.INFO,"CheckAbilityToDeleteCards test started.");
        for (int i = 0; i < 2; i++) {
            pageActions.TrelloProcess(CardOrBoard.CARD, Methods.DELETE,null,i);
        }
        logger.log(Level.INFO,"CheckAbilityToDeleteCards test finished.");
    }

    @Test @Order(4)
    public void CheckAbilityToDeleteBoard(){
        logger.log(Level.INFO,"CheckAbilityToDeleteBoard test started.");
        pageActions.TrelloProcess(CardOrBoard.BOARD, Methods.DELETE,null,null);
        logger.log(Level.INFO,"CheckAbilityToDeleteBoard test finished.");
    }
}