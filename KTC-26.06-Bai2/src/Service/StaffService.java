package Service;

import Model.Staff;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public interface StaffService {
    public void printStaff(List<Staff> list);

    void print5Staff(List<Staff> list);

    public void inputStaff(List<Staff> list);
    public void update(List<Staff> list);
    public void delete(List<Staff> list);
    public void find(List<Staff> list);
    public void SortByName(List<Staff> list);
    public void SortByIncome(List<Staff> list);

    void FindByRangeIncome(List<Staff> list);
}
