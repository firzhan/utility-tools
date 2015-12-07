package inheritance;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) throws JAXBException {
        File file = new File("/home/firzhan/wso2/PUBLIC_BRANCH/training/jaxb/src/main/resources/abc2.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(ProcessInstanceActionRequest.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        ProcessInstanceActionRequest processInstanceActionRequest= (ProcessInstanceActionRequest) jaxbUnmarshaller.unmarshal(file);

        RestActionRequest restActionRequest = (RestActionRequest)processInstanceActionRequest;
        System.out.println(restActionRequest.getAction());
        /*System.out.println(processInstanceCreateRequest.getProcessDefinitionId() + " List Size: " +
                processInstanceCreateRequest.getVariables().size());*/


      /*  List<RestVariable> restVariableList = processInstanceCreateRequest.getVariables();
        for (RestVariable restVariable: restVariableList){
            System.out.println(restVariable.getName());
        }*/
    }
}
