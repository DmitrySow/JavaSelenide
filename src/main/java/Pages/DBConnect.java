package Pages;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String pas = "31415";

    public static DSLContext getDslContext() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, pas);
        return DSL.using(connection, SQLDialect.POSTGRES);
    }
}
