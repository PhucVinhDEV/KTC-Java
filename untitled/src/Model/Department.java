package Model;

import java.util.List;

public class Department {
    private String Id;
    private String Name;
    private List<Employee> listEmployee;

    public Department() {

    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Department(String id, String name, List<Employee> listEmployee) {
        Id = id;
        Name = name;
        this.listEmployee = listEmployee;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Employee> getListEmployee() {
        return listEmployee;
    }

    public void setListEmployee(List<Employee> listEmployee) {
        this.listEmployee = listEmployee;
    }



    public void removeEmployee(String employeeId) {
        listEmployee.removeIf(e -> e.getId() == employeeId);
    }
}
