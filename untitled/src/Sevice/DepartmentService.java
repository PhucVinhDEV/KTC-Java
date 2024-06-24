package Sevice;

import Model.Company;

public interface DepartmentService {
    public void insert(Company company);
    public void update(Company company);
    public void delete(Company company);
    public void prinfDetailDepartment(Company company);
}
