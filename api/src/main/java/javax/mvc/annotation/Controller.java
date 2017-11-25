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
package javax.mvc.annotation;

import javax.ws.rs.NameBinding;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.*;
import static java.lang.annotation.ElementType.*;

/**
 * <p>Declares a method as a controller. If declared at the type level,
 * it applies to all methods in the type.</p>
 *
 * <p>A controller method that returns void is required to be annotated with
 * {@link javax.mvc.annotation.View}. A controller method can return a view path
 * as a {@link java.lang.String} or a {@link javax.ws.rs.core.Response}. If a controller
 * returns {@code null} and it is annotated with {@link javax.mvc.annotation.View},
 * then the value of this annotation is used as a default.</p>
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
 * @see javax.mvc.annotation.View
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

