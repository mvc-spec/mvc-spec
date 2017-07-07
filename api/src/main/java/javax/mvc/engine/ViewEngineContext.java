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
package javax.mvc.engine;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.mvc.Models;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.UriInfo;

/**
 * <p>Contextual data used by a {@link javax.mvc.engine.ViewEngine} to process a view.
 * This includes the view name, the models instance and the request and response
 * objects from the Servlet container, among other data.</p>
 *
 * @author Santiago Pericas-Geertsen
 * @author Ivar Grimstad
 * @see javax.mvc.engine.ViewEngine
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
    
    /**
     * Returns the outputstream for the response.
     * 
     * @see java.io.OutputStream
     * @return an outputstream suitable to send binary data to the client
     * @throws IOException if an output stream could not be obtained
     */
    OutputStream getOutputStream() throws IOException;
    
    /**
     * Returns the writer for the response.
     * 
     * @see java.io.PrintWriter
     * @return a PrintWriter object that can send character text to the client
     * @throws IOException if a writer couldn't be obtained
     */
    PrintWriter getWriter() throws IOException;
}
