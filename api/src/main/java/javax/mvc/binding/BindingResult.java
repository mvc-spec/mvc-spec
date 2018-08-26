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

import java.util.List;
import java.util.Set;

/**
 * <p>Describes the binding result of all controller fields and controller
 * method parameters which are annotated with a binding annotation like
 * {@link javax.ws.rs.FormParam}.</p>
 *
 * <p>A binding can fail because of type conversion issues or in case of validation
 * errors. The former can for example happen if the binding annotation is placed on
 * a numeric type but the value cannot be converted to that type. The latter may be
 * caused by constraint violations detected during validation.
 * </p>
 *
 * <p>Controller methods which declare a parameter of this type will be executed
 * even if the binding for fields and method parameters fails.</p>
 *
 * @author Christian Kaltepoth
 * @since 1.0
 */
public interface BindingResult {

    /**
     * Returns <code>true</code> if there is at least one parameter error.
     *
     * @return <code>true</code> if there is at least one parameter error
     */
    boolean isFailed();

    /**
     * Returns an immutable list of all messages representing both binding and
     * validation errors. This method is a shortcut for:
     *
     * <pre>
     * getAllErrors().stream().map(ParamError::getMessage).collect(Collectors.toList())
     * </pre>
     *
     * @return A list of human-readable messages
     */
    List<String> getAllMessages();

    /**
     * Returns an immutable set of all binding and validation errors.
     *
     * @return All binding and validation errors.
     */
    Set<ParamError> getAllErrors();

    /**
     * Returns an immutable set of all binding and validation errors for
     * a specific parameter.
     *
     * @return All binding and validation errors for the parameter.
     */
    Set<ParamError> getErrors(String param);

}
