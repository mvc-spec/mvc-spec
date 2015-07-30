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
package javax.mvc;

import javax.mvc.engine.ViewEngine;

/**
 * <p>An abstraction that includes information about a view as well as an instance
 * of {@link javax.mvc.Models} and a {@link javax.mvc.engine.ViewEngine} class, in
 * which only the view information is mandatory. Instances of this class can be
 * returned by controller methods.
 *
 * <p>If no {@link javax.mvc.Models} is specified, the view engine is required to
 * inject it; if no {@link javax.mvc.engine.ViewEngine} is specified, then
 * the default selection mechanism to associate views and view engines is used.
 * Thus, a controller method returning an instance of this class can override
 * the {@link javax.mvc.Models} in request scope as well as the default lookup
 * mechanism for view engines.
 *
 *
 * @author Santiago Pericas-Geertsen
 * @see javax.mvc.Models
 * @see javax.mvc.annotation.Controller
 * @see javax.mvc.engine.ViewEngine
 * @since 1.0
 */
public class Viewable {

    private String view;

    private Models models;

    private Class<? extends ViewEngine> viewEngine;

    /**
     * Constructs an instance specifying only a view.
     *
     * @param view the view.
     */
    public Viewable(String view) {
        this(view, null, null);
    }

    /**
     * Constructs an instance using a view and a view engine.
     *
     * @param view the view.
     * @param viewEngine the view engine class.
     */
    public Viewable(String view, Class<? extends ViewEngine> viewEngine) {
        this(view, null, viewEngine);
    }

    /**
     * Constructs an instance using a view and a models.
     *
     * @param view the view.
     * @param models the models instance.
     */
    public Viewable(String view, Models models) {
        this(view, models, null);
    }

    /**
     * Constructs an instance using a view, a models and a view engine.
     *
     * @param view the view.
     * @param models the models instance.
     * @param viewEngine the view engine class.
     */
    public Viewable(String view, Models models, Class<? extends ViewEngine> viewEngine) {
        this.view = view;
        this.models = models;
        this.viewEngine = viewEngine;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public Models getModels() {
        return models;
    }

    public void setModels(Models models) {
        this.models = models;
    }

    public Class<? extends ViewEngine> getViewEngine() {
        return viewEngine;
    }

    public void setViewEngine(Class<? extends ViewEngine> viewEngine) {
        this.viewEngine = viewEngine;
    }
}
