package dataLayer.dataMappers.UserMapper;

import dataLayer.ConnectionPool;
import dataLayer.DBCPDBConnectionPool;
import dataLayer.dataMappers.Mapper;
import dataLayer.dbConnectionPool.BasicDBConnectionPool;
import model.Repo.GetRepo;
import model.User.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserMapper extends Mapper<User, java.lang.String> implements IUserMapper {
    private static final java.lang.String COLUMNS = " u.userId, u.firstName, u.lastName," +
            " u.jobTitle, u.bio, u.isLogin";
    private static final String CULUMNS_USER_SKILL = " name, userId";
    private static final String CULUMNS_USER_ENDORSE = " name, endorserUserId, endorsedUserId";
    private static final String CULUMNS_USER_BID = " userId, projectId, bidAmount";


    public UserMapper() throws SQLException {
        Connection con1 = DBCPDBConnectionPool.getConnection();
        Statement st =
                con1.createStatement();
//        st.executeUpdate("CREATE TABLE IF NOT EXISTS " + "user" + " " + "(userId TEXT PRIMARY KEY, firstName TEXT," +
//                " firstname TEXT, gpa FLOAT)");
        st.executeUpdate("    Create Table IF NOT EXISTS\n" +
                "                user (\n" +
                "                        userId VARCHAR(20) PRIMARY KEY,\n" +
                "                        firstName VARCHAR(100),\n" +
                "                        lastName VARCHAR(100),\n" +
                "                        isLogin BOOLEAN,\n" +
                "                        bio VARCHAR(10000),\n" +
                "                        jobTitle VARCHAR(300)\n" +
                "                )");

        st.close();
        con1.close();

    }

    @Override
    protected String getFindStatement() {
        return "SELECT " + COLUMNS +
                " FROM user u" +
                " WHERE u.userId = ? ";
    }
    protected String getFindSkillsStatement(){
        return "SELECT " + CULUMNS_USER_SKILL +
                " FROM userSkill" +
                " WHERE u.userId = ? ";
    }

    protected String getFindََUserWithPrefixFirstName(String prefix){
        return "SELECT " + COLUMNS +
                " FROM user u" +
                " WHERE u.firstName LIKE \"" + prefix + "%\"";
    }
    protected String getFindََUserWithPrefixLastName(String prefix){
        return "SELECT " + COLUMNS +
                " FROM user u" +
                " WHERE u.lastName LIKE \"" + prefix + "%\"";
    }
    protected String getFindََLoginUserStatement(){
        return "SELECT " + COLUMNS +
                " FROM user u" +
                " WHERE u.isLogin = 1 ";
    }
    @Override
    public User find(String userId) throws SQLException {
        User result = loadedMap.get(userId);
        if (result != null)
            return result;

        try (Connection con = DBCPDBConnectionPool.getConnection();
             PreparedStatement st = con.prepareStatement(getFindStatement())
        ) {
            st.setString(1, userId.toString());
            ResultSet resultSet;
            try {
                resultSet = st.executeQuery();
                return convertResultSetToDomainModel(resultSet);
            } catch (SQLException ex) {
                System.out.println("error in Mapper.findByID query.");
                throw ex;
            }
        }
    }

    @Override
    protected User convertResultSetToDomainModel(ResultSet rs) throws SQLException {
        return  new User(rs.getString("userId"), rs.getString("firstName"),
                rs.getString("lastName"), rs.getString("jobTitle"), rs.getString("bio"), rs.getBoolean("isLogin"));
    }

    protected List<User> convertResultSetToListDomainModel(ResultSet rs) throws SQLException{
        List<User> users = new ArrayList<>();
        while(rs.next()){
            User user = new User(rs.getString("userId"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("jobTitle"),
                    rs.getString("bio")
                    , rs.getBoolean("isLogin"));
            users.add(user);

        }
        return users;
    }

    @Override
    protected String getFindAllStatement() {
        return "SELECT " + COLUMNS +
                " FROM user u";
    }

    @Override
    protected String getInsertStatement() {

        return "insert into user (userId, firstName, lastName, jobTitle, bio, isLogin)\n" +
                " Select ?, ?, ?, ?, ?, ? Where not exists(select * from user where userId=?)";
    }
    protected  String getSetLoginStatement(){
        return "update user SET isLogin = 1 Where userId = ?";
    }
    public void setLogin(String userId) throws SQLException {
        Connection con = DBCPDBConnectionPool.getConnection();
        String sql = getSetLoginStatement();
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, userId);

            st.executeUpdate();
        }
        con.close();
    }
    @Override
    public void insertObjectToDB(User object) throws SQLException {
        Connection con = DBCPDBConnectionPool.getConnection();
        String sql = getInsertStatement();
        System.out.println("id = " + object.getId());
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, object.getId());
            st.setString(2, object.getFirstName());
            st.setString(3, object.getLastName());
            st.setString(4, object.getJobTitle());
            st.setString(5, object.getBio());
            st.setBoolean(6, object.isLogin());
            st.setString(7, object.getId());
            st.executeUpdate();
        }
        con.close();
    }


    @Override
    public List<model.User.User> findWithFirstName(java.lang.String prefixUserName) throws SQLException {


        try (Connection con = DBCPDBConnectionPool.getConnection();
             PreparedStatement st = con.prepareStatement(getFindََUserWithPrefixFirstName(prefixUserName))
        ) {
            ResultSet resultSet;
            try {
                resultSet = st.executeQuery();
//                resultSet.next();
                return convertResultSetToListDomainModel(resultSet);
            } catch (SQLException ex) {
                System.out.println("error in Mapper.findByID query.");
                throw ex;
            }
        }
    }


    @Override
    public List<model.User.User> findWithLastName(java.lang.String prefixLastName) throws SQLException {
        try (Connection con = DBCPDBConnectionPool.getConnection();
             PreparedStatement st = con.prepareStatement(getFindََUserWithPrefixLastName(prefixLastName))
        ) {
            ResultSet resultSet;
            try {
                resultSet = st.executeQuery();
//                resultSet.next();
                return convertResultSetToListDomainModel(resultSet);
            } catch (SQLException ex) {
                System.out.println("error in Mapper.findByID query.");
                throw ex;
            }
        }
    }

    @Override
    public List<model.User.User> findWithJobTitle(java.lang.String prefixJobTitle) throws  SQLException {
        return null;
    }

    @Override
    public List<model.User.User> findLoginUsers() throws SQLException{
        try (Connection con = DBCPDBConnectionPool.getConnection();
             PreparedStatement st = con.prepareStatement(getFindََLoginUserStatement())
        ) {
            ResultSet resultSet;
            try {
                resultSet = st.executeQuery();
//                resultSet.next();
                return convertResultSetToListDomainModel(resultSet);
            } catch (SQLException ex) {
                System.out.println("error in Mapper.findByID query.");
                throw ex;
            }
        }
    }



}