package oop.encapsulation;

public class Person {

    private  String firstName;
    private String lastName;
    private int age;

    public static void main(String[] args) {
        Person person = new Person();

        person.setAge(-5);
        System.out.println(person.getAge());
    }

    public  boolean isTeen(){
        if(age >= 12 && age <= 20){
            return true;
        }

        return false;
    }

    public String fullName(){
        String fullName;
        if(firstName.isEmpty() && lastName.isEmpty()){
             fullName =  "";;
        } else if(firstName.isEmpty()){
            fullName = "" + lastName;
        } else if(lastName.isEmpty()){
            fullName = firstName + "";
        } else {
           fullName = firstName + " " + lastName;
        }
        return fullName;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
       if(age < 0 || age > 100){
           age = 0;
       }

        this.age = age;
    }
}
