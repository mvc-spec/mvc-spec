/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2014-2015 Oracle and/or its affiliates. All rights reserved.
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
package javax.mvc.security;

/**
 * Interface that provides encoders to <em>escape</em> code in JavaScript, HTML,
 * etc. Encoding data that may be mis-interpreted in a client (e.g., a browser)
 * can prevent XSS attacks. Instances of this interface are injectable and also
 * accessible from EL using the name {@code encoders}.
 *
 * @author Santiago Pericas-Geertsen
 * @since 1.0
 */
public interface Encoders {

    /**
     * <p>Encoding for JavaScript code in attributes or script blocks. It MUST support
     * encoding of (at least) the following characters:</p>
     *
     * <table summary="Encoding Table">
     *     <thead>
     *      <tr><th>Input Character</th><th>Encoding</th></tr>
     *     </thead>
     *     <tbody>
     *      <tr><td>U+0008 (BS)</td><td>\b</td></tr>
     *      <tr><td>U+0009 (HT)</td><td>\t</td></tr>
     *      <tr><td>U+000A (LF)</td><td>\n</td></tr>
     *      <tr><td>U+000C (FF)</td><td>\f</td></tr>
     *      <tr><td>U+000D (CR)</td><td>\r</td></tr>
     *      <tr><td>/</td><td>\/</td></tr>
     *      <tr><td>\</td><td>\\</td></tr>
     *      <tr><td>"</td><td>\x22</td></tr>
     *      <tr><td>&amp;</td><td>\x26</td></tr>
     *      <tr><td>'</td><td>\x27</td></tr>
     *      <tr><td>U+0000-U001F</td><td>\x##</td></tr>
     *     </tbody>
     * </table>
     *
     * @param s string to encode.
     * @return encoded string.
     */
    String js(String s);

    /**
     * <p>Encoding for HTML code in attributes or content. It MUST support encoding of
     * (at least) the following characters:</p>
     *
     * <table summary="Encoding Table">
     *     <thead>
     *      <tr><th>Input Character</th><th>Encoding</th></tr>
     *     </thead>
     *     <tbody>
     *      <tr><td>&amp;</td><td>&amp;amp;</td></tr>
     *      <tr><td>&lt;</td><td>&amp;lt;</td></tr>
     *      <tr><td>&gt;</td><td>&amp;gt;</td></tr>
     *      <tr><td>"</td><td>&amp;#34;</td></tr>
     *      <tr><td>'</td><td>&amp;#39;</td></tr>
     *     </tbody>
     * </table>
     *
     * @param s string to encode.
     * @return encoded string.
     */
    String html(String s);
}
