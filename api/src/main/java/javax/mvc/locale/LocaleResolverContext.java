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
