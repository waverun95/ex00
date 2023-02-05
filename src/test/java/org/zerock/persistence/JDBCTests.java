package org.zerock.persistence;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.sql.DriverManager;
import java.sql.Connection;


import static org.junit.Assert.fail;

@Log4j
public class JDBCTests {

    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testConnetion(){

        try(
            Connection con =
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost/spring",
                            "root",
                            "!gksrmf13"
                    )
        ){
            log.info(con);
        }catch (Exception e){
            fail(e.getMessage());
        }
    }
}
