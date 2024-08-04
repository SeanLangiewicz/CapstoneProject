package model;

public class Titles
{


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    int id;


    String title;
    int salary;
    public String toString()
    {
        return (title);
    }
    public Titles(int id, String title, int salary) {
        this.id = id;
        this.title = title;
        this.salary = salary;
    }


}
