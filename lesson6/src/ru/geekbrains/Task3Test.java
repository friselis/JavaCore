import com.sun.org.apache.regexp.internal.RE;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.*;

public class Task3Test {
    private static Connection connection;
    private static Savepoint savepoint;
    private static Statement statement;

    private static final int INITIAL_NUMBER_OF_PETROV = 1;
    private static final int INITIAL_NUMBER_OF_IVANOV = 1;
    private static final int SCORE_OF_SIDOROV = 3;

    @BeforeClass
    public static void connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:MainDB1.db");
        statement = connection.createStatement();
        savepoint = connection.setSavepoint("Savepoint");
    }

    @Test
    public void testInsertData() throws SQLException {
            statement.execute("INSERT INTO Students (surname, score) VALUES ('PETROV', 3)");
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) as count FROM Students WHERE surname = 'PETROV'");
            int numOfId = resultSet.getInt("count");
            Assert.assertEquals(INITIAL_NUMBER_OF_PETROV + 1, numOfId);
    }

    @Test
    public void testUpdateData() throws SQLException {
        ResultSet resultSetBefore = statement.executeQuery("SELECT COUNT(*) AS count FROM Students WHERE surname = 'IVANOV'");
        Assert.assertEquals(INITIAL_NUMBER_OF_IVANOV, resultSetBefore.getInt("count"));
        statement.executeUpdate("UPDATE Students SET surname = 'IVANOVCHANGED' WHERE surname = 'IVANOV'");
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS count FROM Students WHERE surname = 'IVANOV'");
        Assert.assertEquals(0, resultSet.getInt("count"));
        ResultSet resultSetAfter = statement.executeQuery("SELECT COUNT(*) AS count FROM Students WHERE surname = 'IVANOVCHANGED'");
        Assert.assertEquals(INITIAL_NUMBER_OF_IVANOV, resultSet.getInt("count"));
    }

    @Test
    public void testReadData() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT score FROM Students WHERE surname = 'SIDOROV'");
        Assert.assertEquals(SCORE_OF_SIDOROV, resultSet.getInt(1));
    }

    @AfterClass
    public static void disconnect() throws SQLException {
        connection.rollback(savepoint);
        connection.close();
    }

}
