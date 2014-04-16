package test;

import org.jboss.marshalling.Marshaller;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;
import org.jboss.marshalling.Unmarshaller;
import org.jboss.marshalling.river.RiverMarshallerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws Exception {
        final MarshallerFactory marshallerFactory = new RiverMarshallerFactory();

        // Create a configuration
        final MarshallingConfiguration configuration = new MarshallingConfiguration();

        final Marshaller marshaller = marshallerFactory.createMarshaller(configuration);
        final ByteArrayOutputStream os = new ByteArrayOutputStream();
        marshaller.start(Marshalling.createByteOutput(os));
        marshaller.writeObject(new Foo());
        marshaller.finish();
        os.close();

        final Unmarshaller unmarshaller = marshallerFactory.createUnmarshaller(configuration);
        unmarshaller.start(Marshalling.createByteInput(new ByteArrayInputStream(os.toByteArray())));
        System.out.println("Read object: " + unmarshaller.readObject());
        unmarshaller.finish();
    }
}
