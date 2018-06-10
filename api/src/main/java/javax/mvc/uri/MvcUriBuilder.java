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
package javax.mvc.uri;

import javax.mvc.MvcContext;
import java.net.URI;
import java.util.Map;

/**
 * <p>Fluent interface for adding parameters to a URI-template
 * retrieved by {@link MvcContext#uriBuilder(String)}.</p>
 *
 * @author Florian Hirsch
 * @see MvcContext#uriBuilder(String)
 * @since 1.0
 */
public interface MvcUriBuilder {

    /**
     * <p>Adds a parameter which will substitute any {@link javax.ws.rs.PathParam},
     * {@link javax.ws.rs.QueryParam} and {@link javax.ws.rs.MatrixParam} with a matching name.</p>
     *
     * @param name   the parameter name.
     * @param values the parameter value(s), each object will be converted
     *               to a {@code String} using its {@code toString()} method.
     * @return a reference to this MvcUriBuilder
     */
    MvcUriBuilder param(String name, Object... values);

    /**
     * <p>Builds a URI using the given parameters.</p>
     *
     * @return the URI built from the Builder
     * @see javax.ws.rs.core.UriBuilder#buildFromMap(Map)
     */
    URI build();

}
