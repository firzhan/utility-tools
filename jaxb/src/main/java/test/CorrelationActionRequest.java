package test;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "CorrelationActionRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class CorrelationActionRequest extends ExecutionActionRequest {

    private String processDefinitionId;
    private String processDefinitionKey;
    private String signalEventSubscriptionName;
    private String messageEventSubscriptionName;;
    @XmlElementWrapper(name = "QueryVariables")
    @XmlElement(name = "QueryVariable", type = QueryVariable.class)
    private List<QueryVariable> variables;
    @XmlElementWrapper(name = "ProcessInstanceVariables")
    @XmlElement(name = "QueryVariable", type = QueryVariable.class)
    private List<QueryVariable> processInstanceVariables;
    @XmlElementWrapper(name = "CorrelationRestVariables")
    @XmlElement(name = "QueryVariable", type = QueryVariable.class)
    private List<QueryVariable> correlationVariables;
    private String activityId;
    private String tenantId;


    public CorrelationActionRequest(){}

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public String getProcessDefinitionKey() {
        return processDefinitionKey;
    }

    public void setProcessDefinitionKey(String processDefinitionKey) {
        this.processDefinitionKey = processDefinitionKey;
    }

    /*public List<QueryVariable> getVariables() {
        return variables;
    }

    public void setVariables(List<QueryVariable> variables) {
        this.variables = variables;
    }*/

    public List<QueryVariable> getCorrelationVariables() {
        return correlationVariables;
    }

    public void setCorrelationVariables(List<QueryVariable> correlationVariables) {
        this.correlationVariables = correlationVariables;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }


    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getSignalEventSubscriptionName() {
        return signalEventSubscriptionName;
    }

    public void setSignalEventSubscriptionName(String signalEventSubscriptionName) {
        this.signalEventSubscriptionName = signalEventSubscriptionName;
    }


    public String getMessageEventSubscriptionName() {
        return messageEventSubscriptionName;
    }

    public void setMessageEventSubscriptionName(String messageEventSubscriptionName) {
        this.messageEventSubscriptionName = messageEventSubscriptionName;
    }

    public List<QueryVariable> getProcessInstanceVariables() {
        return processInstanceVariables;
    }

    public void setProcessInstanceVariables(List<QueryVariable> processInstanceVariables) {
        this.processInstanceVariables = processInstanceVariables;
    }
}
