package designPatterns;


//EG: Logistics app, web browser rendering , game development (to spawn enemies, NPCs based upon level etc.)


// loose coupling
// scalable
// flexible
// open for extension closed for modification
// encapsulation of object creation
// it lets subclasses decide which object to instantiate
public class Factory {

}

//The Factory Method separates product construction code from the code
// that actually uses the product.
// Therefore, it’s easier to extend the product construction code independently from the rest
//of the code.


// use factory when you want to provide users
// of your library or framework with a way to extend its internal components.


// Product Abstract Class
abstract class Button {
    public abstract void render();
}

class IosButton extends Button {
    @Override
    public void render() {
        System.out.println("iOS Button");
    }
}

class AndroidButton extends Button {
    @Override
    public void render() {
        System.out.println("Android Button");
    }
}

// Factory Interface
interface Dialog{
    Button createButton();
}

class iOS implements Dialog {
    @Override
    public Button createButton() {
        return new IosButton();
    }
}

class Android implements Dialog {
    @Override
    public Button createButton() {
        return new AndroidButton();
    }
}



