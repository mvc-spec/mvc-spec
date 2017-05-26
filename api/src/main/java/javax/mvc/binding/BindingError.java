/*
 * Copyright © 2017 Ivar Grimstad (ivar.grimstad@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package javax.mvc.binding;

/**
 * <p>Represents a single error that occurred while binding a parameter to a controller
 * method argument or controller field using a binding annotation like {@link
 * javax.ws.rs.FormParam}. Binding error message templates are read from a
 * {@link java.util.ResourceBundle} named <code>BindingMessages</code>.</p>
 *
 * @author Christian Kaltepoth
 * @since 1.0
 */
public interface BindingError {

    /**
     * Returns the interpolated error message for this binding error.
     *
     * @return The human-readable error message
     */
    String getMessage();

    /**
     * The parameter name of the value that caused the binding error. This is usually
     * the name specified with the binding annotation (i.e. {@link javax.ws.rs.FormParam}).
     *
     * @return The name of the parameter which caused the error
     */
    String getParamName();

}
