package test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Kohsuke Kawaguchi
 */
public class Foo implements Serializable {
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.writeObject("hello");
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        Object x = ois.readObject();
        System.out.println(x);
    }

    private static final long serialVersionUID = 1L;
}
