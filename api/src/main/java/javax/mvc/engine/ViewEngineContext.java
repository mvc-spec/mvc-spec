/*
 * Copyright © 2017 Ivar Grimstad
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
package javax.mvc.engine;

import javax.mvc.Models;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.UriInfo;

/**
 * <p>Contextual data used by a {@link javax.mvc.engine.ViewEngine} to process a view.
 * This includes the view name, the models instance and the request and response
 * objects from the Servlet container, among other data.</p>
 *
 * @author Santiago Pericas-Geertsen
 * @see javax.mvc.engine.ViewEngine
 * @see javax.servlet.http.HttpServletRequest
 * @see javax.servlet.http.HttpServletResponse
 * @since 1.0
 */
public interface ViewEngineContext {

    /**
     * Returns the view.
     *
     * @return the view.
     */
    String getView();

    /**
     * Returns the models instance needed to process the view.
     *
     * @return the models instance.
     */
    Models getModels();

    /**
     * Returns HTTP request object from the Servlet container.
     *
     * @return HTTP request object.
     */
    HttpServletRequest getRequest();

    /**
     * Returns HTTP response object from the servlet container. The underlying
     * output stream should be used to write the result of processing a view.
     *
     * @return HTTP response object.
     */
    HttpServletResponse getResponse();

    /**
     * Returns the {@link javax.ws.rs.core.UriInfo} instance containing information
     * about the current request URI.
     *
     * @return the URI info for the current request.
     * @see javax.ws.rs.core.UriInfo
     */
    UriInfo getUriInfo();

    /**
     * Returns the {@link javax.ws.rs.container.ResourceInfo} instance containing
     * information about the controller method matched in the current request.
     *
     * @return the resource info for the current request.
     * @see javax.ws.rs.container.ResourceInfo
     */
    ResourceInfo getResourceInfo();

    /**
     * Returns the application's configuration. The configuration provides access
     * to properties such as {@link javax.mvc.engine.ViewEngine#VIEW_FOLDER}, which
     * view engines must use to locate views.
     *
     * @return application's configuration.
     * @see javax.ws.rs.core.Configuration
     */
    Configuration getConfiguration();
}
