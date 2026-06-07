package designPatterns;

public class Single {
    public static void main(String[] args) {
        
        A.getInstance();
    }
}

class A {
    private static A a;

    private A(){}

    public static A getInstance(){
        if (a == null) {
            a = new A();
        }

        return a;
    }
}


