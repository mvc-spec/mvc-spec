/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2014-2015 Oracle and/or its affiliates. All rights reserved.
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
package javax.mvc.security;

/**
 * Cross Site Request Forgery (CSRF) interface with access to the CSRF header name
 * and the CSRF token value. Implementations of this interface are injectable
 * and accessible from EL via the {@link javax.mvc.MvcContext} class as {@code mvc.csrf}.
 * It is RECOMMENDED for instances of this class to be in session scope.
 *
 * @author Santiago Pericas-Geertsen
 * @see javax.mvc.annotation.CsrfValid
 * @since 1.0
 */
public interface Csrf {

    /**
     * Property that can be used to globally enable CSRF protection for an application.
     * Values of this property must be of type {@link Csrf.CsrfOptions}.
     *
     * @see javax.ws.rs.core.Application#getProperties
     */
    static final String CSRF_PROTECTION = "javax.mvc.security.CsrfProtection";

    /**
     * Options for property {@link Csrf#CSRF_PROTECTION}.
     */
    enum CsrfOptions {
        /**
         * CSRF protection not enabled.
         */
        OFF,
        /**
         * Enabling CSRF requires use of {@link javax.mvc.annotation.CsrfValid} explicitly.
         */
        EXPLICIT,
        /**
         * CSRF enabled automatically.
         */
        IMPLICIT
    };

    /**
     * Returns the name of the CSRF header. This header is typically a constant.
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
