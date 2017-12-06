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
package javax.mvc.binding;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is used to enable MVC-specific binding rules for a JAX-RS parameter binding. It can
 * be placed on fields and method parameters together with JAX-RS binding annotations such as
 * {@link javax.ws.rs.FormParam}, {@link javax.ws.rs.QueryParam}, etc.
 * <p>
 * MVC parameter binding differs from traditional JAX-RS parameter binding in the following aspects:
 * <ul>
 * <li>In JAX-RS binding and validation errors result in an exception being thrown which can
 * only be handled by a corresponding exception mapper. This usually doesn't make sense for web
 * applications, because errors must be processed by the controller, so they can be
 * displayed on the resulting HTML page. In case of MVC bindings such errors don't prevent the controller
 * from being invoked and are instead made available via the injectable {@link BindingResult} class.</li>
 * <li>JAX-RS parameter type conversion isn't locale-aware. The standard JAX-RS converters
 * always use a fixed locale to parse numbers and dates. In MVC applications users typically
 * enter data into forms in their native locale. Therefore, MVC bindings perform data type
 * conversion by respecting the request locale resolved via {@link javax.mvc.locale.LocaleResolver}.</li>
 * </ul>
 *
 * @author Christian Kaltepoth
 * @see BindingResult
 * @see javax.mvc.locale.LocaleResolver
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Documented
public @interface MvcBinding {}

