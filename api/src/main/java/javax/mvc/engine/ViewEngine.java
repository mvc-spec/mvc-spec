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

/**
 * <p>View engines are responsible for processing views and are discovered
 * using CDI. Implementations must look up all instances of this interface,
 * and process a view as follows:
 * <ol>
 *     <li>Gather the set of candidate view engines by calling {@link #supports(String)}
 *     and discarding engines that return <code>false</code>.</li>
 *     <li>Sort the resulting set of candidates using priorities. View engines
 *     can be decorated with {@link javax.annotation.Priority} to indicate
 *     their priority; otherwise the priority is assumed to be {@link ViewEngine#PRIORITY_DEFAULT}.</li>
 *     <li>If more than one candidate is available, choose one in an
 *     implementation-defined manner.</li>
 *     <li>Fire a {@link javax.mvc.event.BeforeProcessViewEvent} event.</li>
 *     <li>Call method {@link #processView(ViewEngineContext)} to process view.</li>
 *     <li>Fire a {@link javax.mvc.event.AfterProcessViewEvent} event.</li>
 * </ol>
 * <p>The default view engines for JSPs and Facelets use file extensions to determine
 * support. Namely, the default JSP view engine supports views with extensions <code>jsp</code>
 * and <code>jspx</code>, and the one for Facelets supports views with extension
 * <code>xhtml</code>.</p>
 *
 * @author Santiago Pericas-Geertsen
 * @see javax.annotation.Priority
 * @see javax.mvc.event.BeforeProcessViewEvent
 * @since 1.0
 */
@SuppressWarnings("unused")
public interface ViewEngine {

    /**
     * Name of property that can be set to override the root location for views in an archive.
     *
     * @see javax.ws.rs.core.Application#getProperties()
     */
    String VIEW_FOLDER = "javax.mvc.engine.ViewEngine.viewFolder";

    /**
     * Default value for property {@link #VIEW_FOLDER}.
     */
    String DEFAULT_VIEW_FOLDER = "/WEB-INF/views/";

    /**
     * Default priority for all built-in view engines.
     */
    int PRIORITY_DEFAULT = 1000;

    /**
     * Recommended priority for all view engines provided by frameworks built
     * on top of MVC implementations.
     */
    int PRIORITY_FRAMEWORK = 2000;

    /**
     * Recommended priority for all application-provided view engines.
     */
    int PRIORITY_APPLICATION = 3000;

    /**
     * Returns <code>true</code> if this engine can process the view or <code>false</code>
     * otherwise.
     *
     * @param view the view.
     * @return outcome of supports test.
     */
    boolean supports(String view);

    /**
     * <p>Process a view given a {@link javax.mvc.engine.ViewEngineContext}. Processing
     * a view involves <i>merging</i> the model and template data and writing
     * the result to an output stream.</p>
     *
     * <p>Following the Java EE threading model, the underlying view engine implementation
     * must support this method being called by different threads. Any resources allocated
     * during view processing must be released before the method returns.</p>
     *
     * @param context the context needed for processing.
     * @throws ViewEngineException if an error occurs during processing.
     */
    void processView(ViewEngineContext context) throws ViewEngineException;
}
