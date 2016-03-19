/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2015 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * http://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
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
