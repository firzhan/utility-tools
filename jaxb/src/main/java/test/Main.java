package test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) throws JAXBException {
        File file = new File("/home/firzhan/wso2/PUBLIC_BRANCH/training/jaxb/src/main/resources/abc.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(ProcessInstanceCreateRequest.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        ProcessInstanceCreateRequest processInstanceCreateRequest= (ProcessInstanceCreateRequest) jaxbUnmarshaller.unmarshal(file);

        System.out.println(processInstanceCreateRequest.getProcessDefinitionId() + " List Size: " +
                processInstanceCreateRequest.getVariables().size());


        List<RestVariable> restVariableList = processInstanceCreateRequest.getVariables();
        for (RestVariable restVariable: restVariableList){
            System.out.println(restVariable.getName());
            System.out.println(restVariable.getValue());
        }

    }

}
