package designPatterns;

public class AbstractFactory {
}

//Abstract Factory is a creational design pattern that
//lets you produce families of related objects without specifying their concrete classes.

// if you want inter related components like sofa, chair, table, and these belong
// to like Modern, Vintage , then abstract factory can be used

// Another example:

// abstract factory interface declare methods for creation for related components
interface GUIFactory{
    Buttonn createButton();
    CheckBox createCheckBox();
}

// Concrete Factories
// produce family of products that belong to a single variant
class WinFactory implements GUIFactory {
    @Override
    public Buttonn createButton() {
        return new WinButtonn();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WinCheck();
    }
}

class MacFactory implements GUIFactory {
    @Override
    public CheckBox createCheckBox() {
        return new MacCheck();
    }

    @Override
    public Buttonn createButton() {
        return new MacButtonn();
    }
}

// interface for each product
interface Buttonn{
    void render();
}

class WinButtonn implements Buttonn {
    @Override
    public void render() {
        System.out.println("Windows Button");
    }
}

class MacButtonn implements Buttonn {
    @Override
    public void render() {
        System.out.println("Mac Button");
    }
}

//for second product

interface CheckBox {
    void renderCheck();
}

class WinCheck implements CheckBox {
    @Override
    public void renderCheck() {
        System.out.println("Windows Checkbox");
    }
}

class MacCheck implements CheckBox {
    @Override
    public void renderCheck() {
        System.out.println("Mac Checkbox");
    }
}
