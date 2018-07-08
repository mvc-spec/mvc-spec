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
package javax.mvc;

import javax.mvc.Controller;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <p>Declares a view for a controller that returns void, or for a controller
 * that may return {@code null} and wants to declare a default value.
 * If declared at the type level, it applies to all controller methods in the type and
 * can be overridden by another instance of this annotation at the method level.
 *
 * <p>Example:
 * <pre><code>
 *     &#64;Controller
 *     &#64;View("hello.jsp")
 *     public void sayHello() {
 *         ...
 *     }
 * </code></pre>
 *
 * @author Santiago Pericas-Geertsen
 * @see Controller
 * @since 1.0
 */
@Target({METHOD, TYPE})
@Retention(RUNTIME)
@Documented
@Inherited
public @interface View {

    /**
     * The name of the view
     *
     * @return view name
     */
    String value();

}

