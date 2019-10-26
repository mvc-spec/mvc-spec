/*
 * Copyright (c) 2016-2017 JSR 371 expert group and contributors
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
 * locale. If resolving the locale this way isn't possible, the default resolver must return
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
