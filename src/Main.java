import dataaccess.EmployeeDatabaseAccess;
import dataaccess.WorkUnitDatabaseAccess;
import model.Employee;
import model.WorkUnit;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        EmployeeDatabaseAccess employeeDatabaseAccess = new EmployeeDatabaseAccess();
        WorkUnitDatabaseAccess workUnitDatabaseAccess = new WorkUnitDatabaseAccess();
        employeeDatabaseAccess.resetEmployeeDataBase();
        workUnitDatabaseAccess.resetWorkUnitDataBase();
        workUnitDatabaseAccess.createEmployeeDataBase();
        WorkUnit it = new WorkUnit("it", 44332211);
        WorkUnit barnameRizi = new WorkUnit("barnameRizi", 55667788);
        WorkUnit manabeEnsani = new WorkUnit("manabeEnsani", 99887700);
        workUnitDatabaseAccess.save(it);
        workUnitDatabaseAccess.save(barnameRizi);
        workUnitDatabaseAccess.save(manabeEnsani);
        Employee mary = new Employee("mary", "smith", 456
                , Date.valueOf("1991-5-12"), manabeEnsani.getId());
        Employee atieh = new Employee(
                "atieh", "rahbari", 123, Date.valueOf("1400-09-12"), it.getId());

        Employee reza = new Employee("reza", "asghari", 677
                , Date.valueOf("1380-9-7"), it.getId());

        employeeDatabaseAccess.save(atieh);
        employeeDatabaseAccess.save(mary);
        employeeDatabaseAccess.save(reza);
        workUnitDatabaseAccess.update(it);
        employeeDatabaseAccess.update(reza);
        List<WorkUnit> allWorkUnits = workUnitDatabaseAccess.getAllWorkUnits();
        System.out.println("workunits list: ");
        for (WorkUnit workUnit : allWorkUnits) {
            System.out.print(allWorkUnits.indexOf(workUnit) + 1);
            System.out.print(") " + workUnit + "\n");

        }
        System.out.println("enter workunit number: ");
        String workUnitNumber = scanner.nextLine().trim();
        if (workUnitNumber.matches("[0-9]+") && 0 < Integer.parseInt(workUnitNumber)
                && Integer.parseInt(workUnitNumber) < allWorkUnits.size()) {
            WorkUnit selectedItem = allWorkUnits.get(Integer.parseInt(workUnitNumber) - 1);
            System.out.println(selectedItem);
            employeeDatabaseAccess.displayEmployeesPerWorkUnit(selectedItem);
            for (Employee employee : selectedItem.getEmployees()) {
                System.out.println(employee);
            }
        } else {
            System.out.println("only numbers in range is acceptable! ");
        }
    }
}
