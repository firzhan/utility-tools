package test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class Main2 {

    public static void main(String[] args) throws JAXBException {
        File file = new File("/home/firzhan/wso2/PUBLIC_BRANCH/training/jaxb/src/main/resources/abc3.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(ExecutionActionRequest.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        ExecutionActionRequest executionActionRequest= (ExecutionActionRequest) jaxbUnmarshaller.unmarshal(file);

        System.out.println(executionActionRequest.getSignalName() + " \nList Size: " +
                executionActionRequest.getVariables().size());


        List<RestVariable> restVariableList = executionActionRequest.getVariables();
        for (RestVariable restVariable: restVariableList){
            System.out.println(restVariable.getName());
        }

    }
}
