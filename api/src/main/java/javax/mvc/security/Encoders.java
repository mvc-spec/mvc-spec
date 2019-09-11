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
package javax.mvc.security;

/**
 * Interface that provides encoders to <em>escape</em> code in JavaScript, HTML,
 * etc. Encoding data is a way to prevent XSS attacks by ensuring it is not
 * misinterpreted as running code. Implementations of this interface are injectable
 * and accessible from EL via the {@link javax.mvc.MvcContext} class as {@code mvc.encoders}.
 *
 * @author Santiago Pericas-Geertsen
 * @see <a href="https://www.owasp.org/index.php/OWASP_Java_Encoder_Project">OWASP Encoder Project</a>
 * @since 1.0
 */
public interface Encoders {

    /**
     * <p>Encoding for JavaScript code in attributes or script blocks. It MUST support
     * encoding of (at least) the following characters:</p>
     *
     * <table>
     * <caption>Encoding Table</caption>
     * <thead>
     * <tr><th>Input Character</th><th>Encoding</th></tr>
     * </thead>
     * <tbody>
     * <tr><td>U+0008 (BS)</td><td>\b</td></tr>
     * <tr><td>U+0009 (HT)</td><td>\t</td></tr>
     * <tr><td>U+000A (LF)</td><td>\n</td></tr>
     * <tr><td>U+000C (FF)</td><td>\f</td></tr>
     * <tr><td>U+000D (CR)</td><td>\r</td></tr>
     * <tr><td>/</td><td>\/</td></tr>
     * <tr><td>\</td><td>\\</td></tr>
     * <tr><td>"</td><td>\x22</td></tr>
     * <tr><td>&amp;</td><td>\x26</td></tr>
     * <tr><td>'</td><td>\x27</td></tr>
     * <tr><td>U+0000-U001F</td><td>\x##</td></tr>
     * </tbody>
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
     * <table>
     * <caption>Encoding Table</caption>
     * <thead>
     * <tr><th>Input Character</th><th>Encoding</th></tr>
     * </thead>
     * <tbody>
     * <tr><td>&amp;</td><td>&amp;amp;</td></tr>
     * <tr><td>&lt;</td><td>&amp;lt;</td></tr>
     * <tr><td>&gt;</td><td>&amp;gt;</td></tr>
     * <tr><td>"</td><td>&amp;#34;</td></tr>
     * <tr><td>'</td><td>&amp;#39;</td></tr>
     * </tbody>
     * </table>
     *
     * @param s string to encode.
     * @return encoded string.
     */
    String html(String s);
}
