package Sevice;

import Model.Company;
import Model.Employee;

public interface CompanyService {
    public void inputDataStart(Company company);
    public void prinfData(Company company);
    public void addEmployee(Company company, Employee employee);
}
