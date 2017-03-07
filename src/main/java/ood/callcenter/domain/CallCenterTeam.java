package ood.callcenter.domain;

import ood.callcenter.domain.employee.Employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Reshetuyk on 19.02.2017.
 */
public class CallCenterTeam implements Iterable<Employee> {
    private List<Employee> team = new ArrayList<>();

    public void addTeamMember(Employee employee) {
        team.add(employee);
    }

    @Override
    public Iterator<Employee> iterator() {
        return team.iterator();
    }

    public Stream<Employee> stream() {
        return team.stream();
    }

    public Employee findAnyBy(Class<? extends Employee> employeeClass) {
        return stream().filter(e -> e.getClass().equals(employeeClass)).findAny().get();
    }
}
