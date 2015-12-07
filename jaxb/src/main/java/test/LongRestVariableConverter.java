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
public class LongRestVariableConverter implements RestVariableConverter {


  public String getRestTypeName() {
    return "long";
  }


  public Class< ? > getVariableType() {
    return Long.class;
  }


  public Object getVariableValue(RestVariable result) {
    if(result.getValue() != null) {
      if(!(result.getValue() instanceof Number)) {
        System.out.println("Converter can only convert longs");
      }
      return ((Number) result.getValue()).longValue();
    }
    return null;
  }


  public void convertVariableValue(Object variableValue, RestVariable result) {
    if(variableValue != null) {
      if(!(variableValue instanceof Long)) {
        System.out.println("Converter can only convert integers");
      }
      result.setValue(variableValue);
    } else {
      result.setValue(null);
    }
  }

}