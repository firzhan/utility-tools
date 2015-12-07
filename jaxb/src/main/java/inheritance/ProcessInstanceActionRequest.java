package inheritance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "actionRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProcessInstanceActionRequest extends RestActionRequest {

    public static final String ACTION_SUSPEND = "suspend";
    public static final String ACTION_ACTIVATE = "activate";
}

