/*
 * Copyright (c) 2014-2015 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2016-2018 JSR 371 expert group and contributors
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
package javax.mvc.security;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <p>A controller annotation to validate a CSRF token value received
 * in a request whenever the property {@link javax.mvc.security.Csrf#CSRF_PROTECTION}
 * is set to {@link javax.mvc.security.Csrf.CsrfOptions#EXPLICIT}. If the
 * property {@link javax.mvc.security.Csrf#CSRF_PROTECTION} is set to
 * {@link javax.mvc.security.Csrf.CsrfOptions#IMPLICIT}, then the use of this
 * annotation is redundant. MVC implementations are only REQUIRED to enforce CSRF
 * for POST controllers that consume payloads of type
 * {@link javax.ws.rs.core.MediaType#APPLICATION_FORM_URLENCODED_TYPE}, but
 * other HTTP methods and payloads may be optionally supported by the
 * underlying implementation. If declared at the type level, it applies 
 * to all methods in the type.</p>
 *
 * @author Santiago Pericas-Geertsen
 * @see javax.mvc.security.Csrf
 * @since 1.0
 */
@Target({METHOD, TYPE})
@Retention(RUNTIME)
@Documented
@Inherited
public @interface CsrfProtected {
}
