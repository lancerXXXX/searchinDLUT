package dao.impl;

import DB.DBManager;
import dao.PersonDao;
import entity.InformationTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao {
    private Connection connection;

    public PersonDaoImpl() {
        connection = DBManager.getConn();
    }


    @Override
    public List<InformationTable> ListAll(String[] information) {
        List<InformationTable> informationTableList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT telephone,student_id,teacher_id,qq,name,email FROM information_table WHERE telephone like ? and student_id like ? and teacher_id like ? and qq like ? and name like ? and email like ?");
            int i = 0;
            for (String a : information) {
                statement.setString(i + 1, "%" + information[i] + "%");
                i++;
            }
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                InformationTable informationTable = new InformationTable();
                informationTable.setTelephone(resultSet.getString(1));
                informationTable.setStudentId(resultSet.getString(2));
                informationTable.setTeacherId(resultSet.getString(3));
                informationTable.setQq(resultSet.getString(4));
                informationTable.setName(resultSet.getString(5));
                informationTable.setEmail(resultSet.getString(6));
                informationTableList.add(informationTable);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return informationTableList;
    }

    public List<InformationTable> find(String student_id,String teacher_id) throws SQLException {
        List<InformationTable> informationTableList=new ArrayList<>();
        PreparedStatement statement=connection.prepareStatement("SELECT telephone,student_id,teacher_id,qq,name,email FROM information_table WHERE student_id=? and teacher_id=?");
        statement.setString(1,student_id);
        statement.setString(2,teacher_id);
        ResultSet resultSet=statement.executeQuery();
        while (resultSet.next()){
            InformationTable informationTable=new InformationTable();
            informationTable.setTelephone(resultSet.getString(1));
            informationTable.setStudentId(resultSet.getString(2));
            informationTable.setTeacherId(resultSet.getString(3));
            informationTable.setQq(resultSet.getString(4));
            informationTable.setName(resultSet.getString(5));
            informationTable.setEmail(resultSet.getString(6));
            informationTableList.add(informationTable);
        }
        return informationTableList;
    }

    @Override
    public List<InformationTable> ListAllof(int startIndex, int offset) {
        List<InformationTable> informationTableList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT telephone,student_id,teacher_id,qq,name,email FROM information_table LIMIT ?,?");
            statement.setInt(1, startIndex);
            statement.setInt(2, offset);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                InformationTable informationTable = new InformationTable();
                informationTable.setTelephone(resultSet.getString(1));
                informationTable.setStudentId(resultSet.getString(2));
                informationTable.setTeacherId(resultSet.getString(3));
                informationTable.setQq(resultSet.getString(4));
                informationTable.setName(resultSet.getString(5));
                informationTable.setEmail(resultSet.getString(6));
                informationTableList.add(informationTable);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return informationTableList;
    }

    @Override
    public void AddInformation(String[] informations) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO information_table VALUES (?,?,?,?,?,?)");
        int i = 1;
        for (String str : informations) {
            if (2 == i || 3 == i) {
                if (0 == str.length()) {
                    statement.setString(i, "-1");
                }else {
                    statement.setString(i,str);
                }
            } else {
                System.out.println(str);
                statement.setString(i, str);
            }
            i++;
        }
        statement.executeUpdate();
    }
    @Override
    public void DeleteInformation(String[] informatins) throws SQLException{
        PreparedStatement statement=connection.prepareStatement("DELETE FROM information_table WHERE student_id=? AND teacher_id=?");
        statement.setString(1,informatins[0]);
        statement.setString(2,informatins[1]);
        System.out.println(informatins[0]);
        System.out.println(informatins[1]);
        statement.executeUpdate();
    }

    @Override
    public void UpdateInformation(String[] information) throws SQLException{
        PreparedStatement statement = connection.prepareStatement("UPDATE information_table SET telephone=? ,student_id=?,teacher_id=?,qq=?,name=?,email=? WHERE student_id=? and teacher_id=?");
        for(int i=0;i<6;i++){
            statement.setString(i+1,information[i]);
        }
        statement.setString(7,information[1]);
        statement.setString(8,information[2]);
        statement.executeUpdate();
    }
}
