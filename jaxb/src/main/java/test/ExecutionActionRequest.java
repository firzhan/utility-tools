package test;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "ExecutionActionRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExecutionActionRequest extends RestActionRequest{

    public static final String ACTION_SIGNAL = "signal";
    public static final String ACTION_SIGNAL_EVENT_RECEIVED = "signalEventReceived";
    public static final String ACTION_MESSAGE_EVENT_RECEIVED = "messageEventReceived";

    protected String signalName;
    protected String messageName;
    @XmlElementWrapper(name = "RestVariables")
    @XmlElement(name = "RestVariable", type = RestVariable.class)
    private List<RestVariable> variables;

    public void setVariables(List<RestVariable> variables) {
        this.variables = variables;
    }

    @JsonTypeInfo(use= JsonTypeInfo.Id.CLASS, defaultImpl=RestVariable.class)
    public List<RestVariable> getVariables() {
        return variables;
    }

    public String getSignalName() {
        return signalName;
    }

    public void setSignalName(String signalName) {
        this.signalName = signalName;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

}
