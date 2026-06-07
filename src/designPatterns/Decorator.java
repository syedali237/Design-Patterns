package designPatterns;

public class Decorator {
}

// structural design pattern that lets you attach new behaviors to
// objects by placing these objects inside special wrapper objects that contain the behaviors

// also known as Wrapper

// Inheritance comes to mind
// Inheritance is static. You can’t alter the behavior of an existing object at runtime.
// You can only replace the whole object with another one that’s created from a different subclass.

// Aggregation/composition is the key principle behind many design patterns, including Decorator.

// The client code would need to wrap a basic notifier object into a set of decorators that
// match the client’s preferences. The resulting objects will be structured as a stack.

// The last decorator in the stack would be the object that the client actually works with.
// Since all decorators implement the same interface as the base notifier, the rest of the client
// code won’t care whether it works with the “pure” notifier object or the decorated one.

// In this example, the Decorator pattern lets you compress and encrypt sensitive data
// independently from the code that actually uses this data.

// Use the Decorator pattern when you need to be able to assign extra
// behaviors to objects at runtime without breaking the code that uses these objects.

// FOLLOWS SINGLE RESPONSIBILITY PRINCIPLE

// component interface : that can be altered
interface DataSource {
    String readData();
    void writeData();
}

// Concrete Components for default implementation
class FileDataSource implements DataSource {
    @Override
    public String readData() {
        return "Reading Data from Concrete";
    }

    @Override
    public void writeData() {
        System.out.println("Writing data in concrete component");
    }
}

// The base decorator class follows the same interface as the
// other components. The primary purpose of this class is to
// define the wrapping interface for all concrete decorators.
// The default implementation of the wrapping code might include
// a field for storing a wrapped component and the means to
// initialize it
class DataSourceDecorator implements DataSource {
    protected DataSource dataSource;

    public DataSourceDecorator(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public String readData() {
        return dataSource.readData();
    }

    @Override
    public void writeData() {
        dataSource.writeData();
    }
}

// concrete decorators

class EncryptionDecorator extends DataSourceDecorator {
    public EncryptionDecorator(DataSource dataSource){
        super(dataSource);
    }

    @Override
    public String readData() {
        return dataSource.readData() + " ---> Encrypting";
    }

    @Override
    public void writeData() {
        dataSource.writeData();
    }
}

class CompressionDecorator extends DataSourceDecorator{

    public CompressionDecorator(DataSource dataSource){
        super(dataSource);
    }
    @Override
    public String readData() {
        return dataSource.readData() + "---- compressing ----";
    }

    @Override
    public void writeData() {
        dataSource.writeData();
    }
}