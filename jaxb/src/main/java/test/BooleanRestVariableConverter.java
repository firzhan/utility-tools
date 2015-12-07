package test;


public class BooleanRestVariableConverter implements RestVariableConverter {

    public String getRestTypeName() {
        return "boolean";
    }

    public Class< ? > getVariableType() {
        return Boolean.class;
    }

    public Object getVariableValue(RestVariable result) {
        if(result.getValue() != null) {
            if(!(result.getValue() instanceof Boolean)) {
                System.out.println("Converter can only convert booleans");
            }
            return result.getValue();
        }
        return null;
    }

    public void convertVariableValue(Object variableValue, RestVariable result) {
        if(variableValue != null) {
            if(!(variableValue instanceof Boolean)) {
                System.out.println("Converter can only convert booleans");
            }
            result.setValue(variableValue);
        } else {
            result.setValue(null);
        }
    }
}
