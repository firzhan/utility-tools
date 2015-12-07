package jaxb2;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

    @XmlAnyElement(lax = true)
    protected List<Object> any;

}