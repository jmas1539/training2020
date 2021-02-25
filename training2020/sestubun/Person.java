package training2020.sestubun;

public class Person { 
    public static final String DECORATIONLON_S = "＊＊＊";
    
    private int age;
    private String name;
    public Person (String name, int age) {
        this.age = age;
        this.name = name;
    }
    public void sayEatBeans(){
        System.out.println( DECORATIONLON_S + name + "は豆を" + age + "粒食べました。" + DECORATIONLON_S );
    }
    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }


}
