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

import javax.ws.rs.NameBinding;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.*;
import static java.lang.annotation.ElementType.*;

/**
 * <p>Declares a method as a <i>controller</i>. If declared at the type level,
 * it applies to all methods in the type. A controller method returns a view as a
 * {@link java.lang.String}, as part of a {@link javax.mvc.Viewable} or as a
 * {@link javax.ws.rs.core.Response} whose entity is a {@link javax.mvc.Viewable}.
 * If a controller method returns void, then the view must be specified using
 * the {@link javax.mvc.View} annotation.
 *
 * <p>Example:
 * <pre><code>
 *     &#64;Controller
 *     public String sayHello() {
 *         return "hello.jsp";
 *     }
 * </code></pre>
 *
 * @author Santiago Pericas-Geertsen
 * @see javax.mvc.View
 * @see javax.mvc.Viewable
 * @see javax.ws.rs.core.Response
 * @since 1.0
 */
@NameBinding
@Target( { METHOD, TYPE } )
@Retention( RUNTIME )
@Documented
@Inherited
public @interface Controller {
}

