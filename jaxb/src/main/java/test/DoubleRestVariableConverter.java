/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package test;



/**
 * @author Frederik Heremans
 */
public class DoubleRestVariableConverter implements RestVariableConverter {
  public String getRestTypeName() {
    return "double";
  }


  public Class< ? > getVariableType() {
    return Double.class;
  }


  public Object getVariableValue(RestVariable result) {
    if(result.getValue() != null) {
      if(!(result.getValue() instanceof Number)) {
        System.out.println("Converter can only convert doubles");
      }
      return ((Number) result.getValue()).doubleValue();
    }
    return null;
  }


  public void convertVariableValue(Object variableValue, RestVariable result) {
    if(variableValue != null) {
      if(!(variableValue instanceof Double)) {
        System.out.println("Converter can only convert doubles");
      }
      result.setValue(variableValue);
    } else {
      result.setValue(null);
    }
  }

}
