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
package javax.mvc.security;

/**
 * Cross Site Request Forgery (CSRF) interface with access to the CSRF header name
 * and the CSRF token value. Implementations of this interface are injectable
 * and accessible from EL via the {@link javax.mvc.MvcContext} class as {@code mvc.csrf}.
 *
 * @author Santiago Pericas-Geertsen
 * @see CsrfProtected
 * @since 1.0
 */
public interface Csrf {

    /**
     * Property that can be used to globally enable CSRF protection for an application.
     * Values of this property must be of type {@link Csrf.CsrfOptions}.
     */
    String CSRF_PROTECTION = "javax.mvc.security.CsrfProtection";

    /**
     * Options for property {@link Csrf#CSRF_PROTECTION}.
     */
    enum CsrfOptions {
        /**
         * CSRF protection not enabled.
         */
        OFF,
        /**
         * Enabling CSRF requires use of {@link CsrfProtected} explicitly (default).
         */
        EXPLICIT,
        /**
         * CSRF enabled automatically for all controllers.
         */
        IMPLICIT
    };

    /**
     * Returns the name of the CSRF form field or HTTP request header. This name is typically a constant.
     *
     * @return name of CSRF header.
     */
    String getName();

    /**
     * Returns the value of the CSRF token.
     *
     * @return value of CSRF token.
     */
    String getToken();
}
