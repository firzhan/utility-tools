package inheritance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "suspendRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProcessInstanceSuspendRequest extends RestActionRequest{

    public static final String ACTION_SUSPEND2 = "suspend";
    public static final String ACTION_ACTIVATE2 = "activate";
}
