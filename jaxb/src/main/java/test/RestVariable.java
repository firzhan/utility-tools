package test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "RestVariable")
@XmlAccessorType(XmlAccessType.FIELD)
public class RestVariable {


    public RestVariable(){}
    public enum RestVariableScope {
        LOCAL, GLOBAL
    }

    private String name;
    private String type;
    private RestVariableScope variableScope;
    @XmlElements(value = {
            @XmlElement(type = String.class),
            @XmlElement(type = Double.class),
            @XmlElement(type = Integer.class),
            @XmlElement(type = Long.class),
            @XmlElement(type = Float.class),
            @XmlElement(type = Boolean.class)
    })
    private Object value;
    private String valueUrl;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    @JsonIgnore
    public RestVariableScope getVariableScope() {
        return variableScope;
    }
    public void setVariableScope(RestVariableScope variableScope) {
        this.variableScope = variableScope;
    }
    public Object getValue() {
        return value;
    }
    public void setValue(Object value) {
        this.value = value;
    }
    public String getScope() {
        String scope = null;
        if (variableScope != null) {
            scope = variableScope.name().toLowerCase();
        }
        return scope;
    }
    public void setScope(String scope) {
        setVariableScope(getScopeFromString(scope));
    }
    public void setValueUrl(String valueUrl) {
        this.valueUrl = valueUrl;
    }
    @JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
    public String getValueUrl() {
        return valueUrl;
    }

    public static RestVariableScope getScopeFromString(String scope) {
        if (scope != null) {
            for (RestVariableScope s : RestVariableScope.values()) {
                if (s.name().equalsIgnoreCase(scope)) {
                    return s;
                }
            }
            System.out.println("Invalid variable scope: '" + scope + "'");
        } else {
            return null;
        }
        return null;
    }
}
