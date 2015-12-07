package test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "QueryVariable")
@XmlAccessorType(XmlAccessType.FIELD)
public class QueryVariable {

    private String name;
    private String operation;
    private Object value;
    private String type;

    public QueryVariable(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public QueryVariableOperation getVariableOperation() {
        if(operation == null) {
            return null;
        }
        return QueryVariableOperation.forFriendlyName(operation);
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public enum QueryVariableOperation {
        EQUALS("equals"),
        NOT_EQUALS("notEquals"),
        EQUALS_IGNORE_CASE("equalsIgnoreCase"),
        NOT_EQUALS_IGNORE_CASE("notEqualsIgnoreCase"),
        LIKE("like"),
        GREATER_THAN("greaterThan"),
        GREATER_THAN_OR_EQUALS("greaterThanOrEquals"),
        LESS_THAN("lessThan"),
        LESS_THAN_OR_EQUALS("lessThanOrEquals");

        private String friendlyName;

        private QueryVariableOperation(String friendlyName) {
            this.friendlyName = friendlyName;
        }

        public String getFriendlyName() {
            return friendlyName;
        }

        public static QueryVariableOperation forFriendlyName(String friendlyName) {
            for(QueryVariableOperation type : values()) {
                if(type.friendlyName.equals(friendlyName)) {
                    return type;
                }
            }
           return null;
        }
    }

}
