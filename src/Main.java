import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        List<Integer> ll = new LinkedList<>();

        Set<Integer> set = new HashSet();
        Set<Integer> set2 = new LinkedHashSet<>();

        Queue<Integer> q = new ArrayDeque<>();
        Queue<Integer> q1 = new PriorityQueue();

        Map<Integer, Integer> map = new WeakHashMap();

        
        
    }
}

interface InnerMain {
    private String i(){
        return "";
    };
    
}

class A {
    public void doSomething(){

    }
    
}

class B  extends A {
    @Override
    public void doSomething() {
        super.doSomething();
    }
}