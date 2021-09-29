package dataaccess;

import model.WorkUnit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkUnitDatabaseAccess extends DatabaseUtilities {

    public WorkUnitDatabaseAccess() throws ClassNotFoundException, SQLException {
        super();
    }

    public int save(WorkUnit workUnit) throws SQLException {
        if (getConnection() != null) {
            String sqlQuery = String.format("insert into workunit (name,phone) values ('%s','%s')"
                    , workUnit.getName(), workUnit.getPhone());
            PreparedStatement ps = getConnection().prepareStatement(sqlQuery,
                    Statement.RETURN_GENERATED_KEYS);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
                workUnit.setId(generatedKey);
            }
        }
        return 0;
    }

    public int update(WorkUnit workUnit) throws SQLException {
        if (getConnection() != null) {
            Statement statement = getConnection().createStatement();
            PreparedStatement prepareStatement = getConnection().prepareStatement(
                    "update workunit set name =? where id = ?;");
            prepareStatement.setString(1, "fanavariEtelaat");
            prepareStatement.setInt(2, workUnit.getId());
            int index = prepareStatement.executeUpdate();
            return index;
        } else {
            return 0;
        }
    }

    public List<WorkUnit> getAllWorkUnits() throws SQLException {
        List<WorkUnit> workUnits = new ArrayList<>();
        if (getConnection() != null) {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select  * from workunit");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int phone = resultSet.getInt("phone");
                WorkUnit workUnit = new WorkUnit(id, name, phone);
                workUnits.add(workUnit);
            }
        }
        return workUnits;

    }

}
