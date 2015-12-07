package test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "RestActionRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class RestActionRequest {

    protected String action;

    public void setAction(String action) {
        this.action = action;
    }
    public String getAction() {
        return action;
    }

}