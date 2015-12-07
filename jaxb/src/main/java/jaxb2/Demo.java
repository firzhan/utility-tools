package jaxb2;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Demo {
    public static void main(String[] args) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Root.class, Foo.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("/home/firzhan/wso2/PUBLIC_BRANCH/training/jaxb/src/main/resources/input.xml");
        Root payload = (Root) unmarshaller.unmarshal(xml);

        for(Object o : payload.any) {
            System.out.println(o.getClass());
        }

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(payload, System.out);
    }
}
