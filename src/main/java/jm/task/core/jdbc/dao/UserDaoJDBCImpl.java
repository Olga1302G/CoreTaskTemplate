package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private Connection connection = getConnection();
    public void createUsersTable() throws SQLException {
       // PreparedStatement preparedStatement = null;
        String sql = "CREATE TABLE IF NOT EXISTS userTable ("+("ID bigint auto_increment primary key,"+
                " NAME varchar (30) not null, "+
                "LASTNAME varchar (30) not null,"+
                "AGE MEDIUMINT not null)");
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.executeUpdate();
            System.out.println("Таблица создана");
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }

    public void dropUsersTable() throws SQLException {

        String sql = "DROP TABLE IF EXISTS userTable";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.executeUpdate();
            System.out.println("Таблица удалена");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {

        User user = new User();

        String sql = "INSERT INTO userTable (NAME, LASTNAME, AGE)"+ " values ('" + name + "', '" + lastName + "', '" + age + "')";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {



            preparedStatement.executeUpdate();
            System.out.println("User "+name+" успешно добавлен!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeUserById(long id) throws SQLException {

        User user = new User();

        String sql = "DELETE FROM userTable WHERE ID= " + Long.toString(id);

        try (PreparedStatement  preparedStatement = connection.prepareStatement(sql)){


           preparedStatement.executeUpdate();
           System.out.println("User под "+ id+ " удален");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<User> getAllUsers() throws SQLException {

        List<User> usersList = new ArrayList<>();

        String sql = "SELECT ID, NAME , LASTNAME, AGE FROM userTable";


        try (Statement statement = connection.createStatement()) {


            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("ID"));
                user.setName(resultSet.getString("NAME"));
                user.setLastName(resultSet.getString("LASTNAME"));
                user.setAge(resultSet.getByte("AGE"));
                usersList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return usersList;
    }

    public void cleanUsersTable() throws SQLException {

        String sql = "TRUNCATE TABLE userTable";
        try (PreparedStatement  preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.executeUpdate();
            System.out.println("Таблица очищена");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
