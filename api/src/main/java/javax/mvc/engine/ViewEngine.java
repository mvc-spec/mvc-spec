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

/**
 * <p>View engines are responsible for processing views and are discovered
 * using CDI. Implementations must inject all instances of this interface,
 * and process a view as follows:
 * <ol>
 *     <li>Gather the set of candidate view engines by calling {@link #supports(String)}
 *     and discarding engines that return <code>false</code>.</li>
 *     <li>Sort the resulting set of candidates using priorities. View engines
 *     can be decorated with {@link javax.annotation.Priority} to indicate
 *     their priority; otherwise the priority is assumed to be {@link Priorities#DEFAULT}.</li>
 *     <li>If more than one candidate is available, choose one in an
 *     implementation-defined manner.</li>
 *     <li>Fire a {@link javax.mvc.event.ViewEngineSelected} event to inform observers
 *     of the selection.</li>
 * </ol>
 * <p>Once a view engine is selected, the method {@link #processView(ViewEngineContext)} is
 * called to process the view.
 * <p>The default view engines for JSPs and Facelets use file extensions to determine
 * support. Namely, the default JSP view engine supports views with extensions <code>jsp</code>
 * and <code>jspx</code>, and the one for Facelets supports views with extension
 * <code>xhtml</code>.</p>
 *
 * @author Santiago Pericas-Geertsen
 * @see javax.annotation.Priority
 * @see javax.mvc.event.ViewEngineSelected
 * @since 1.0
 */
@SuppressWarnings("unused")
public interface ViewEngine {

    /**
     * Name of property that can be set in an application's {@link javax.ws.rs.core.Configuration}
     * to override the root location for views in an archive.
     *
     * @see javax.ws.rs.core.Application#getProperties()
     */
    final String VIEW_FOLDER = "javax.mvc.engine.ViewEngine.viewFolder";

    /**
     * Default value for property {@link #VIEW_FOLDER}.
     */
    final String DEFAULT_VIEW_FOLDER = "/WEB-INF/views/";

    /**
     * Returns <code>true</code> if this engine can process the view or <code>false</code>
     * otherwise.
     *
     * @param view the view.
     * @return outcome of supports test.
     */
    boolean supports(String view);

    /**
     * Process a view given a {@link javax.mvc.engine.ViewEngineContext}. Processing
     * a view involves <i>merging</i> the model and template data and writing
     * the result to an output stream.
     *
     * @param context the context needed for processing.
     * @throws ViewEngineException if an error occurs during processing.
     */
    void processView(ViewEngineContext context) throws ViewEngineException;
}
