package Tests;

import Pages.DBConnect;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import static org.assertj.core.api.Assertions.assertThat;

public class DBTest {

    private DSLContext dsl;

    @BeforeEach
    void setUp() throws SQLException {
        dsl = DBConnect.getDslContext();
        System.out.println("Подключение к БД есть");
    }

    @Test
    void getUsers() {
        Result<Record> result = dsl.select()
                .from("users")
                .fetch();

        assertThat(result).isNotEmpty();

        System.out.print(result.get(0));
        System.out.print(result.get(1));
    }

}
