package Project;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class connectionFact {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mysqltut";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Kiran*123#";

    private static final int MAX_POOL_SIZE = 10; // Adjust this based on your application's needs

    private HikariDataSource dataSource;

    // Private constructor to prevent instantiation
    private connectionFact() {
    	
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(JDBC_URL);
        config.setUsername(USERNAME);
        config.setPassword(PASSWORD);
        config.setMaximumPoolSize(MAX_POOL_SIZE);
        dataSource = new HikariDataSource(config);
    }

    // Singleton instance holder
    private static class ConnectionPoolHolder {
        private static final connectionFact INSTANCE = new connectionFact();
    }

    public static connectionFact getInstance() {
        return ConnectionPoolHolder.INSTANCE;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void close() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}
