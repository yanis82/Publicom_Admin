package sql;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license Click
 * nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to
 * edit this template
 */
import java.sql.SQLException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Column;
import utils.QueryBuilder;
import utils.enums.Operator;
import utils.enums.OrderBy;

/**
 *
 * @author l.sanchez
 */
public class QueryBuilderTest {

    public QueryBuilderTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void QueryBuilderTest() throws SQLException {
        QueryBuilder queryBuilder = new QueryBuilder();
        String query = queryBuilder
                .select(Column.ofString("utilisateur"))
                .from("users")
                .where("name", Operator.EQUAL, "John")
                .where("age", Operator.GREATER_THAN, 25)
                .orderBy("age", OrderBy.DESC)
                .limit(10)
                .getQuery();
        System.out.println(query);
        assertTrue(true);
    }
    
    
}
