//package jm.task.core.jdbc;
//
//
//import jm.task.core.jdbc.model.User;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
//    private static final String URL = "jdbc:mysql://localhost:3306/database?verifyServerCertificate=false&useSSL=true&serverTimezone=UTC";
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "root";
//    public static Connection connection;
//
//    public static void add (User user) throws SQLException {
//        PreparedStatement preparedStatement = null;
//        String add = "INSERT user(NAME, LAST_NAME, AGE) VALUES (?, ?, ?)";
//
//        try {
//            preparedStatement = connection.prepareStatement(add);
//            preparedStatement.setString(1, user.getName());
//            preparedStatement.setString(2, user.getLastName());
//            preparedStatement.setLong(3, user.getAge());
//            preparedStatement.executeUpdate();
//            System.out.println("User с именем – " + user.getName() + " добавлен в базу данных");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        finally {
//            if (preparedStatement != null){
//                preparedStatement.close();
//            }
//        }
//    }
//
//    public static void getUsers() throws SQLException{
//        List<User> list = new ArrayList<>();
//        String getUsers = "SELECT ID, NAME, LAST_NAME, AGE FROM database.user";
//        Statement statement = null;
//
//        try {
//            statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(getUsers);
//            while (resultSet.next()){
//                User user = new User();
//                user.setId(resultSet.getLong("ID"));
//                user.setName(resultSet.getString("NAME"));
//                user.setLastName(resultSet.getString("LAST_NAME"));
//                user.setAge(resultSet.getByte("AGE"));
//                list.add(user);
//            }
//            System.out.println(list);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (statement != null){
//                statement.close();
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        User user1 = new User("Ivan", "Ivanov", (byte) 25);
//        User user2 = new User("Petr", "Petrov", (byte) 26);
//        User user3 = new User("Sidor", "Sidorov", (byte) 27);
//        User user4 = new User("Mariya", "Ivanova", (byte) 24);
//
//        String create = "CREATE TABLE USER (ID INTEGER NOT NULL AUTO_INCREMENT, NAME VARCHAR(20), LAST_NAME VARCHAR(20), AGE INTEGER, PRIMARY KEY (ID));";
//        String clean = "TRUNCATE TABLE database.user;";
//        String dell = "DROP TABLE database.user;";
//
//        try {
//          connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//            if (!connection.isClosed()){
//                System.out.println("Соединение установлено");
//            }
//            Statement statement = connection.createStatement();
//            statement.executeUpdate(create);
//
//            add(user1);
//            add(user2);
//            add(user3);
//            add(user4);
//
//            getUsers();
//
//            statement.executeUpdate(clean);
//            System.out.println("Таблица очищена");
//
//            statement.executeUpdate(dell);
//            System.out.println("Таблица удалена");
//
//            statement.close();
//            connection.close();
//
//            if (connection.isClosed()){
//                System.out.println("Соединение закрыто");
//            }
//        } catch (SQLException e) {
//            e.getStackTrace();
//            System.out.println("Не удалось установить соединение");
//        }
//    }
//}
//
