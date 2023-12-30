package gui.prototype;

import entity.Player;
import gui.prototype.Game;
import java.sql.*;
import java.util.logging.*;

public class SaveDB {

    private static final String URL = "jdbc:sqlite:save.db";

    static {
        // Initialize the logger at the beginning
        Logger.getLogger("").setLevel(Level.OFF);
    }

    public static void main(String[] args) {
        saveGame();
    }

    public static void saveGame() {
        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("1");

            try ( Connection connection = DriverManager.getConnection("jdbc:sqlite:save.db")) {
                System.out.println("3");

                // Check the current number of saves
                int currentSaveCount = getCurrentSaveCount(connection);
                System.out.println("4");

                // Check if the maximum save limit has been reached
                if (currentSaveCount >= 5) {
                    // Delete the oldest save file (you need to implement this logic)
                    System.out.println("a");
                    deleteOldestSave(connection);
                }

                // Proceed with the save operation
                
                savePlayer(connection);
                System.out.println("5");
                saveMonsters(connection);
                System.out.println("6");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("oop");
        }
    }

    private static int getCurrentSaveCount(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM player");

            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
            return 0;
        }
    }

    private static void deleteOldestSave(Connection connection) throws SQLException {
        // Implement logic to identify and delete the oldest save (e.g., based on date or ID)
        // For simplicity, let's assume there's an "id" column that represents the order of saves

        try (Statement statement = connection.createStatement()) {

            statement.executeUpdate("DELETE FROM goblin WHERE id = (SELECT MIN(id) FROM player)");
            statement.executeUpdate("DELETE FROM harpy WHERE id = (SELECT MIN(id) FROM player)");
            statement.executeUpdate("DELETE FROM dragon WHERE id = (SELECT MIN(id) FROM player)");
            statement.executeUpdate("DELETE FROM gnoll WHERE id = (SELECT MIN(id) FROM player)");
            statement.executeUpdate("DELETE FROM skeleton WHERE id = (SELECT MIN(id) FROM player)");
            statement.executeUpdate("DELETE FROM witch WHERE id = (SELECT MIN(id) FROM player)");
            statement.executeUpdate("DELETE FROM ogre WHERE id = (SELECT MIN(id) FROM player)");
            statement.executeUpdate("DELETE FROM player WHERE id = (SELECT MIN(id) FROM player)");
        }
    }

    private static void savePlayer(Connection connection) throws SQLException {
        if (Game.p.id == -1) {
            // Player ID not set, insert a new row
            try (PreparedStatement insertStatement = connection.prepareStatement(
                    "INSERT INTO player (name, x, y, major, credits) VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            )) {
                insertStatement.setString(1, Player.name);
                insertStatement.setInt(2, Game.p.x);
                insertStatement.setInt(3, Game.p.y);
                insertStatement.setString(4, Player.chosenMajor.id);
                insertStatement.setInt(5, Game.p.credits);
                String selectSQL = "SELECT last_insert_rowid() AS id";
                  int rowsAffected = insertStatement.executeUpdate();

                if (rowsAffected > 0) {
                 // Execute a separate select statement to get the auto-incremented ID
                    try (Statement selectStatement = connection.createStatement();
                         ResultSet resultSet = selectStatement.executeQuery(selectSQL)) {
                    if (resultSet.next()) {
                        int generatedId = resultSet.getInt("id");
                        Game.p.setId(generatedId);
            }
            }
                }}} else {
            // Player ID is set, update the existing row
            try (PreparedStatement updateStatement = connection.prepareStatement(
                    "UPDATE player SET name = ?, x = ?, y = ?, major = ?, credits = ? WHERE id = ?"
            )) {
                updateStatement.setString(1, Player.name);
                updateStatement.setInt(2, Game.p.x);
                updateStatement.setInt(3, Game.p.y);
                updateStatement.setString(4, Player.chosenMajor.id);
                updateStatement.setInt(5, Game.p.credits);
                updateStatement.setInt(6, Game.p.id);

                updateStatement.executeUpdate();
            }
        }
            }
        
    

    private static void saveMonsters(Connection connection) throws SQLException {
        saveMonster(connection, "harpy");
        saveMonster(connection, "goblin");
        saveMonster(connection, "skeleton");
        saveMonster(connection, "gnoll");
        saveMonster(connection, "ogre");
        saveMonster(connection, "dragon");
        saveMonster(connection, "witch");
    }

 private static void saveMonster(Connection connection, String tableName) throws SQLException {
    // Check if the row with the specified ID exists
    boolean rowExists = rowExists(connection, tableName, Game.p.id);

    if (rowExists) {
        // Update the existing row
        String updateStatement = String.format(
                "UPDATE %s SET x = ?, y = ?, isDead = ? WHERE id = ?",
                tableName
        );

        try (PreparedStatement statement = connection.prepareStatement(updateStatement)) {
            // Assuming you have methods in Game to retrieve monster information
            statement.setInt(1, Game.getMonsterX(tableName));
            statement.setInt(2, Game.getMonsterY(tableName));
            statement.setInt(3, Game.isMonsterDead(tableName) ? 1 : 0);
            statement.setInt(4, Game.p.id);

            statement.executeUpdate();
        }
    } else {
        // Insert a new row
        String insertStatement = String.format(
                "INSERT INTO %s (id, x, y, isDead) VALUES (?, ?, ?, ?)",
                tableName
        );

        try (PreparedStatement statement = connection.prepareStatement(insertStatement)) {
            // Assuming you have methods in Game to retrieve monster information
            statement.setInt(1, Game.p.id);
            statement.setInt(2, Game.getMonsterX(tableName));
            statement.setInt(3, Game.getMonsterY(tableName));
            statement.setInt(4, Game.isMonsterDead(tableName) ? 1 : 0);

            statement.executeUpdate();
        }
    }
}

    private static boolean rowExists(Connection connection, String tableName, int id) throws SQLException {
        String query = String.format("SELECT 1 FROM %s WHERE id = ?", tableName);

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        }
    }
    public static void deletePlayerAndMonsters( int playerId) throws SQLException {
         Connection connection = DriverManager.getConnection("jdbc:sqlite:save.db");
    // Delete rows from each monster table
    deleteRowsFromMonsterTable(connection, "harpy", playerId);
    deleteRowsFromMonsterTable(connection, "goblin", playerId);
    deleteRowsFromMonsterTable(connection, "skeleton", playerId);
    deleteRowsFromMonsterTable(connection, "gnoll", playerId);
    deleteRowsFromMonsterTable(connection, "ogre", playerId);
    deleteRowsFromMonsterTable(connection, "dragon", playerId);
    deleteRowsFromMonsterTable(connection, "witch", playerId);

    // Delete row from the player table
    deleteRowFromPlayerTable(connection, playerId);
}

private static void deleteRowsFromMonsterTable(Connection connection, String tableName, int playerId) throws SQLException {
    String deleteStatement = String.format("DELETE FROM %s WHERE id = ?", tableName);

    try (PreparedStatement statement = connection.prepareStatement(deleteStatement)) {
        statement.setInt(1, playerId);
        statement.executeUpdate();
    }
}

private static void deleteRowFromPlayerTable(Connection connection, int playerId) throws SQLException {
    String deleteStatement = "DELETE FROM player WHERE id = ?";

    try (PreparedStatement statement = connection.prepareStatement(deleteStatement)) {
        statement.setInt(1, playerId);
        statement.executeUpdate();
    }
}

}

