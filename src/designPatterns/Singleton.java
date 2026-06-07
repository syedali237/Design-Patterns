package designPatterns;
public class Singleton {
    public static void main(String[] args) {

        // Method 1: Lazy Initialization
        System.out.println("Method A:");
        A a1 = A.getInstance();
        A a2 = A.getInstance();
        System.out.println(a1 == a2); // true

        // Method 2: Synchronized
        System.out.println("\nMethod B:");
        B b1 = B.getInstance();
        B b2 = B.getInstance();
        System.out.println(b1 == b2); // true

        // Method 3: Eager Initialization
        System.out.println("\nMethod C:");
        C c1 = C.getInstance();
        C c2 = C.getInstance();
        System.out.println(c1 == c2); // true

        // Method 4: Double Checked Locking
        System.out.println("\nMethod D:");
        D d1 = D.getInstance();
        D d2 = D.getInstance();
        System.out.println(d1 == d2); // true

        // Method 5: Static Inner Class
        System.out.println("\nMethod E:");
        E e1 = E.getInstance();
        E e2 = E.getInstance();
        System.out.println(e1 == e2); // true

        // Method 6: Enum Singleton
        System.out.println("\nMethod F:");
        F f1 = F.INSTANCE;
        F f2 = F.INSTANCE;
        System.out.println(f1 == f2); // true
    }
}

// Method 1:
// Lazy Initialization
// Classic
// not thread safe

class A{
    private static A a;

    private A(){
        System.out.println("running");
    }

    public static A getInstance(){

        if (a == null){
            a = new A();
        }
        return a;
    }
}


// Method 2:
// Thread-safe
// Synchronized (only one thread at a time can execute getInstance())
// causes overhead
class B {
    private static B b;

    private B(){

    }

    public static synchronized B getInstance(){

        if (b == null){
            b = new B();
        }
        return b;
    }
}

// Method 3: Static Block
// Eager initialization
// Thread-safe because JVM handles static initialization
// unnecessary resource usage
class C {
    private static C obj = new C();

    private C(){}

    public static C getInstance(){
        return obj;
    }
}

// Method 4 :
// Double check locking
// reduces overhead
class D {
    private static volatile D d = null; // volatile: to make sure correct handling by multiple threads
    private D(){};

    public static D getInstance(){
        if (d == null){
            // to make thread safe
            synchronized (D.class){
                if (d == null){ // check again as multiple threads can reach above step
                    d = new D();
                }
            }
        }
        return d;
    }
}

// Method 5:
// Static inner class
// Class loaded only once
// Inner class loaded when referenced
// Lazy initialization
// thread-safe
class E {
    private E(){};

    private static class InnerClass {
        private final static E INSTANCE = new E();
    }

    public static E getInstance(){
        System.out.println("call inner class");
        return InnerClass.INSTANCE;
    }

}

// Method 6:
// Enum Singleton
//Enums are loaded by the JVM only once,
//and each enum constant is created exactly one time.
//Therefore, the Singleton instance is created safely
//when the enum is first accessed.
// thread-safe
// initialized only once
enum F {
    INSTANCE;
}



