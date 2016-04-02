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
package javax.mvc.engine;

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
}
