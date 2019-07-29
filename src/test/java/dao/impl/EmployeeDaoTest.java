package dao.impl;

import dto.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.LinkedHashSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class EmployeeDaoTest {

    private final EmployeeDao employeeDao = new EmployeeDao();

    @Test
    public void addEmployeeFindUpdateAndDelete() {
        String lastName;
        Employee employee = new Employee(1, "Sasha", "Klimov",
                new Date(), "+375441112121", "waiter", 1.1, new LinkedHashSet<>(),
                new LinkedHashSet<>());
        employeeDao.add(employee);
        Employee receivedEmployee = employeeDao.findById(1);
        lastName = receivedEmployee.getLastName();
        assertThat(lastName, is("Sasha"));

        employee.setLastName("Slav");
        employeeDao.update(employee);
        receivedEmployee = employeeDao.findById(1);
        lastName = receivedEmployee.getLastName();
        assertThat(lastName, is("Slav"));

        employeeDao.delete(employee);
        receivedEmployee = employeeDao.findById(1);
        assertNull(receivedEmployee);
    }
}