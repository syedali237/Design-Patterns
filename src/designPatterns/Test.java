package designPatterns;

public class Test {
    
    public static void main(String[] args) {
        Factory modular = new ModualarFactory();
        Factory vintage = new VintageFactory();

        modular.buildSofa().createSofa();
        modular.buildTable().createTable();
    }
}

interface Sofa {
    void createSofa();
}

class ModularSofa implements Sofa {
    @Override
    public void createSofa() {
        // TODO Auto-generated method stub
        System.out.println("Modular Sofa");
    }
}

class VintageSofa implements Sofa {
    @Override
    public void createSofa() {
        // TODO Auto-generated method stub
        System.out.println("Vintage Sofa");
    }
}

interface Table {
    void createTable();
}

class ModularTable implements Table {
    @Override
    public void createTable() {
        // TODO Auto-generated method stub
        System.out.println("Modualar table");
    }
}

class VintageTable implements Table {
    @Override
    public void createTable() {
        // TODO Auto-generated method stub
        System.out.println("Vintage Table");
    }
}

interface Factory {
    Sofa buildSofa();
    Table buildTable();
}

class ModualarFactory implements Factory {
    @Override
    public Sofa buildSofa() {
        // TODO Auto-generated method stub
        return new ModularSofa();
    }

    @Override
    public Table buildTable() {
        // TODO Auto-generated method stub
        return new ModularTable();
    }
}

class VintageFactory implements Factory {
    @Override
    public Sofa buildSofa() {
        // TODO Auto-generated method stub
        return new VintageSofa();
    }

    @Override
    public Table buildTable() {
        // TODO Auto-generated method stub
        return new VintageTable();
    }
}
