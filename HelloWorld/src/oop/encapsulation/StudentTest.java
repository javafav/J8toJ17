package oop.encapsulation;

public class StudentTest {
    public static void main(String[] args) {
        for(int i = 1; i<= 5; i++){
            Student student = new Student("S0392"+ i,
                    switch (i){
                case 1 -> "Marry";
                case 2 -> "Lisa" ;
                case 3 -> "Ana";
                case 4 -> "Sara";
                case 5 -> "Tina";
                default -> "Anonymous";
                    },
                    "01/01/200" + i,
                    "Java Mastery Class");

            System.out.println(student);
        }
    }
}
