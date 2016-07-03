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
     * @param param name of the paramater
     * @param value value of the parameter
     * @return a reference to this MvcUriBuilder
     */
    MvcUriBuilder param(String param, Object value);

    /**
     * <p>Adds a map of parameters which will substitute any {@link javax.ws.rs.PathParam},
     * {@link javax.ws.rs.QueryParam} and {@link javax.ws.rs.MatrixParam} with a matching name.</p>
     *
     * @param params a map of params
     * @return a reference to this MvcUriBuilder
     */
    MvcUriBuilder params(Map<String, Object> params);

    /**
     * <p>Builds a URI using the given parameters.</p>
     *
     * @return the URI built from the Builder
     *
     * @see javax.ws.rs.core.UriBuilder#buildFromMap(Map)
     */
    URI build();

}
