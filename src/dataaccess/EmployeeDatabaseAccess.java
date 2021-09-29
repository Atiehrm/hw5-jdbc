package dataaccess;

import model.Employee;
import model.WorkUnit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDatabaseAccess extends DatabaseUtilities {

    public EmployeeDatabaseAccess() throws ClassNotFoundException, SQLException {
        super();

    }

    public int save(Employee employee) throws SQLException {
        if (getConnection() != null) {
            Statement statement = getConnection().createStatement();
            String sqlQuery = String.format("insert into employee (first_name,last_name,employee_number,birth_day,workunit_id) values ('%s','%s','%s','%s','%s')"
                    , employee.getFirstName(), employee.getLastName(), employee.getEmployeeNumber()
                    , employee.getBirthDay().toString(), employee.getWorkUnitId());
            PreparedStatement preparedStatement = getConnection().prepareStatement(sqlQuery,
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
                employee.setId(generatedKey);
            }
        }
        return 0;
    }

    public int update(Employee employee) throws SQLException {
        if (getConnection() != null) {
            PreparedStatement prepareStatement = getConnection().prepareStatement(
                    "update employee set first_name =?,last_name =? where id =?;");
            prepareStatement.setString(1, "ali");
            prepareStatement.setString(2, "abbasi");
            prepareStatement.setInt(3, employee.getId());
            int index = prepareStatement.executeUpdate();
            return index;
        } else {
            return 0;
        }
    }

    public void displayEmployeesPerWorkUnit(WorkUnit workUnit) throws SQLException {
        System.out.println(" ****");
        List<Employee> employees = new ArrayList<>();
        if (getConnection() != null) {
            Statement statement = getConnection().createStatement();
            String sqlQuery = String.format("select * from employee where workunit_id = '%d'", workUnit.getId());
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Date birthDay = resultSet.getDate("birth_day");
                int employeeNumber = resultSet.getInt("employee_number");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                Employee employee = new Employee(id, firstName, lastName, employeeNumber, birthDay, workUnit.getId());
                employees.add(employee);
            }
        }
        workUnit.setEmployees(employees);
    }
}
