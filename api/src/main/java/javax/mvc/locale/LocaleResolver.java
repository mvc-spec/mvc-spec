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
package javax.mvc.locale;

import javax.mvc.MvcContext;
import java.util.Locale;

/**
 * <p>Locale resolvers are used to determine the locale of the current request and are discovered
 * using CDI.</p>
 *
 * <p>The MVC implementation is required to resolve the locale for each request following this
 * algorithm:</p>
 *
 * <ol>
 * <li>Gather the set of all implementations of this interface available for injection via
 * CDI.</li>
 * <li>Sort the set of implementations using priorities in descending order. Locale resolvers
 * can be decorated with {@link javax.annotation.Priority} to indicate their priority. If no
 * priority is explicitly defined, the priority is assumed to be <code>1000</code>.</li>
 * <li>Call the method {@link #resolveLocale(LocaleResolverContext)}. If the resolver returns
 * a valid locale, use this locale as the request locale. If the resolver returns
 * <code>null</code>, proceed with the next resolver in the ordered set.</li>
 * </ol>
 *
 * <p>Controllers, view engines and other components can access the resolved locale by calling
 * {@link MvcContext#getLocale()}.</p>
 *
 * <p>The MVC implementation is required to provide a default locale resolver with a priority
 * of <code>0</code> which uses the <code>Accept-Language</code> request header to obtain the
 * locale. If resolving the locale this way isn't possible, the implementation should return
 * the application default locale specified via the {@link #DEFAULT_LOCALE} configuration
 * property. If the application default locale hasn't been set, the resolver must return
 * {@link Locale#getDefault()}.</p>
 *
 * @author Christian Kaltepoth
 * @see javax.mvc.locale.LocaleResolverContext
 * @see MvcContext#getLocale()
 * @see java.util.Locale
 * @since 1.0
 */
public interface LocaleResolver {

    /**
     * Name of the property that can be set in an application's {@link javax.ws.rs.core.Configuration}
     * to set a application default locale. This locale will be used if the locale cannot be
     * determined via the <code>Accept-Language</code> header sent by the client.
     *
     * @see javax.ws.rs.core.Application#getProperties()
     */
    String DEFAULT_LOCALE = "javax.mvc.locale.LocaleResolver.defaultLocale";

    /**
     * <p>Resolve the locale of the current request given a {@link LocaleResolverContext}.</p>
     *
     * <p>If the implementation is able to resolve the locale for the request, the corresponding
     * locale must be returned. If the implementation cannot resolve the locale, it must return
     * <code>null</code>. In this case the resolving process will continue with the next
     * resolver.</p>
     *
     * @param context the context needed for processing.
     * @return The resolved locale or <code>null</code>.
     */
    Locale resolveLocale(LocaleResolverContext context);

}
