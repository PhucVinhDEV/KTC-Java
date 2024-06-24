package Sevice;

import Model.Company;

public interface EmplyeeService {
    public void insert(Company company);
    public void update(Company company);
    public void delete(Company company);
    public void prinfDetailEmployee(Company company);
    public void prinfEmployeeDefault(Company company);
}
