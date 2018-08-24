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
package javax.mvc;

import javax.mvc.security.Csrf;
import javax.mvc.security.Encoders;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.Locale;
import java.util.Map;

/**
 * <p>This class provides contextual information such as context and application
 * paths as well as access to the JAX-RS application configuration object.
 * In addition, it provides access to the security-related beans {@link
 * javax.mvc.security.Csrf} and {@link javax.mvc.security.Encoders}.</p>
 *
 * <p>Implementations of this class are injectable, must be
 * {@link javax.enterprise.context.RequestScoped} and accessible from EL using
 * the name {@code mvc}. For example, the CSRF token name and value can be
 * accessed in EL using the expressions {@code mvc.csrf.name} and {@code
 * mvc.csrf.token}, respectively.</p>
 *
 * @author Santiago Pericas-Geertsen
 * @see javax.ws.rs.core.Configuration
 * @since 1.0
 */
public interface MvcContext {

    /**
     * Get the JAX-RS application configuration object. All application-defined properties
     * are accessible via this object.
     *
     * @return the configuration object.
     */
    Configuration getConfig();

    /**
     * <p>Get the application's base path which is defined as the concatenation of context
     * and application paths. It follows that the value returned by this method always
     * starts with a slash but never ends with one.</p>
     *
     * @return the application's base path.
     */
    String getBasePath();

    /**
     * Get the CSRF object.
     *
     * @return the CSRF object.
     */
    Csrf getCsrf();

    /**
     * Get the built-in encoders.
     *
     * @return instance of encoders.
     */
    Encoders getEncoders();

    /**
     * Returns the locale of the current request.
     *
     * @return The request locale
     */
    Locale getLocale();

    /**
     * <p>Creates an URI to be matched by a controller method. This is aimed primarily
     * for use in view rendering technologies to avoid duplicating the values of the
     * {@link javax.ws.rs.Path} annotations.</p>
     *
     * <p>The controller method can either be identified by the simple name of the controller class
     * and the method name separated by '#' (MyController#myMethod) <em>or</em> by the value
     * of the {@link UriRef} annotation.</p>
     *
     * <p>The created URI includes context- and application path.</p>
     *
     * <p>This method assumes that there is no parameter in the URI-template.</p>
     *
     * <p>For example in JSP:</p>
     * <pre><code>${mvc.uri('MyController#myMethod')}</code></pre>
     *
     * @param identifier for the controller method.
     * @return the constructed URI including context- and application path.
     */
    URI uri(String identifier);

    /**
     * <p>Creates an URI to be matched by a controller method. This is aimed primarily
     * for use in view rendering technologies to avoid duplicating the values of the
     * {@link javax.ws.rs.Path} annotations.</p>
     *
     * <p>The controller method can either be identified by the simple name of the controller class
     * and the method name separated by '#' (MyController#myMethod) <em>or</em> by the value
     * of the {@link UriRef} annotation.</p>
     *
     * <p>The created URI includes context- and application path.</p>
     *
     * <p>Any {@link javax.ws.rs.PathParam}, {@link javax.ws.rs.QueryParam}
     * and {@link javax.ws.rs.MatrixParam} which could apply for given target
     * method will be replaced if a matching key is found in the supplied Map.
     * Please note that the map must contain values for all path parameters
     * as they are required for building the URI. All other parameters are optional.</p>
     * 
     * <p>For example in JSP:</p>
     * <pre><code>${mvc.uri('MyController#myMethod', {'foo': 'bar', 'id': 42})}</code></pre>
     *
     * @param identifier for the controller method.
     * @param params a map of path-, query- and matrix parameters.
     * @return the constructed URI including context- and application path.
     * @throws IllegalArgumentException if there are any URI template parameters without a supplied value, or if a value is {@code null}.
     */
    URI uri(String identifier, Map<String, Object> params);

    /**
     * <p>Returns a {@link UriBuilder} for building URIs to be matched
     * by a controller method. This is aimed primarily for use in Java classes.</p>
     *
     * <p>The controller method can either be identified by the simple name of the controller class
     * and the method name separated by '#' (MyController#myMethod) <em>or</em> by the value
     * of the {@link UriRef} annotation.</p>
     *
     * @param identifier for the controller method.
     * @return a reference to a {@link UriBuilder}.
     */
    UriBuilder uriBuilder(String identifier);

}
