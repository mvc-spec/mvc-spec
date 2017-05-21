/*
 * Copyright © 2017 Ivar Grimstad
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

import javax.validation.ConstraintViolation;
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
     * Returns <code>true</code> if there is at least one binding error or
     * constraint violation.
     *
     * @return <code>true</code> if there is at least one binding error
     * constraint violation.
     */
    boolean isFailed();

    /**
     * Returns an immutable list of all messages representing both binding errors and
     * constraint violations. The implementation will use {@link BindingError#getMessage()}
     * and {@link ConstraintViolation#getMessage()} to create the individual messages.
     *
     * @return A list of human-readable messages
     */
    List<String> getAllMessages();

    /**
     * Returns an immutable set of all binding errors detected while processing
     * parameter bindings.
     *
     * @return All binding errors detected
     */
    Set<BindingError> getAllBindingErrors();

    /**
     * Returns the binding error for the binding specified by the given
     * parameter name. Will return <code>null</code> if no binding error
     * was detected.
     *
     * @param param The parameter name
     * @return The binding error or <code>null</code>
     */
    BindingError getBindingError(String param);

    /**
     * Returns an immutable set of all validation errors detected.
     *
     * @return All validation errors detected
     */
    Set<ValidationError> getAllValidationErrors();

    /**
     * Returns an immutable set of all validation errors detected
     * for a parameter binding specified by the given parameter name.
     *
     * @param param The parameter name
     * @return All validation errors for this parameter
     * @see #getValidationError(String)
     */
    Set<ValidationError> getValidationErrors(String param);

    /**
     * Returns a single validation error detected for a parameter binding
     * specified by the given parameter name. Will return the first if there
     * is more than one and <code>null</code> if no error was detected.
     *
     * @param param The parameter name
     * @return The first validation error for the parameter or <code>null</code>
     * @see #getValidationErrors(String)
     */
    ValidationError getValidationError(String param);

}
