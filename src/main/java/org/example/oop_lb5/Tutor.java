package org.example.oop_lb5;
public class Tutor {
    private String name;
    private String lastname;
    private String subject;
    private int age;
    private String contact;

    public Tutor(String name, String lastname, String subject, int age, String contact){
        this.name = name;
        this.lastname = lastname;
        this.subject = subject;
        this.age = age;
        this.contact = contact;
    }
    //getters
    public String getName(){
        return name;
    }
    public String getLastname(){
        return lastname;
    }
    public String getSubject(){
        return subject;
    }
    public int getAge(){
        return age;
    }
    public String getContact(){
        return contact;
    }

    //setters
    public void setName(String name){
        this.name = name;
    }
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    public void setSubject(String subject){
        this.subject = subject;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setContact(String contact){
        this.contact = contact;
    }

    @Override
    public String toString(){
        return "Tutor [name=" + name + ", lastname=" + lastname + ", subject=" + subject +", age=" + age +", contact=" + contact + "]";
    }
}
