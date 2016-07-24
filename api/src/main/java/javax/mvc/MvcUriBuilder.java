package javax.mvc;

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
