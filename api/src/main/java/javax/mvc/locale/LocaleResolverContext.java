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
package javax.mvc.locale;

import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.Locale;

/**
 * <p>Contextual data used by a {@link javax.mvc.locale.LocaleResolver} to resolve the request
 * locale.</p>
 *
 * @author Christian Kaltepoth
 * @see javax.mvc.locale.LocaleResolver
 * @since 1.0
 */
public interface LocaleResolverContext {

    /**
     * Returns the application's configuration.
     *
     * @return application's configuration.
     * @see javax.ws.rs.core.Configuration
     */
    Configuration getConfiguration();

    /**
     * Get a list of languages that are acceptable for the response according to the
     * <code>Accept-Language</code> HTTP header sent by the client.
     *
     * @return a read-only list of languages ordered by their q-value.
     * @see Locale
     */
    List<Locale> getAcceptableLanguages();

    /**
     * Get the JAX-RS {@link Request} instance.
     *
     * @return the JAX-RS {@link Request} instance.
     * @see Request
     */
    Request getRequest();

    /**
     * Get request URI information.
     *
     * @return request URI information
     * @see UriInfo
     */
    UriInfo getUriInfo();

    /**
     * Returns the cookie with the given name.
     *
     * @param name the name of the cookie
     * @return the cookie or <code>null</code> if no cookie with this name exists
     * @see Cookie
     */
    Cookie getCookie(String name);

    /**
     * Get the request header as a single string value.
     *
     * @param name the name of the request header
     * @return the request header value. If the request header is not present then
     * {@code null} is returned. If the request header is present more than once then the values
     * of joined together and separated by a ',' character.
     */
    String getHeaderString(String name);

}
