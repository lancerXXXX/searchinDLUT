package dao;

import entity.InformationTable;

import java.sql.SQLException;
import java.util.List;

public interface PersonDao {
    List<InformationTable> ListAll(String[] information);
    List<InformationTable> ListAllof(int startIndex,int offset);
    void AddInformation(String [] informations) throws SQLException;

    void DeleteInformation(String[] informatins)throws SQLException;

    void UpdateInformation(String[] information) throws SQLException;
}
