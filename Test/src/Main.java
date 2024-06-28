// Định nghĩa lớp Person
class Person implements Cloneable {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter và setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Phương thức để sao chép đối tượng (override từ Cloneable)
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // Phương thức toString để hiển thị thông tin của đối tượng
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class Main {
    public static void main(String[] args) {
        // Tạo một đối tượng Person
        Person person1 = new Person("Alice", 30);

        try {
            // Clone đối tượng person1
            Person person2 = (Person) person1.clone();

            // In ra thông tin của person2
            System.out.println("Person 2: " + person2);

            System.out.println(person1.equals(person2)); // false

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
