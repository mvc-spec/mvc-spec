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

import java.util.Map;

/**
 * <p>A map of name to model instances used by a {@link javax.mvc.engine.ViewEngine}
 * to process a view. Instances implementing this interface must be injectable using
 * {@link javax.inject.Inject} and are {@link javax.enterprise.context.RequestScoped}.
 *
 * <p>Note that certain view engines, such as engines for JSPs and Facelets, support
 * model binding via {@link javax.inject.Named} in which case the use of Models is
 * optional.
 *
 * @author Santiago Pericas-Geertsen
 * @author Christian Kaltepoth
 * @see javax.inject.Named
 * @see javax.enterprise.context.RequestScoped
 * @since 1.0
 */
public interface Models extends Iterable<String> {

    /**
     * Stores a new model in the map.
     *
     * @param name  name of the model
     * @param model model to store in the map
     * @return the current instance to allow method chaining
     */
    Models put(String name, Object model);

    /**
     * Retrieve a model by name.
     *
     * @param name name of the model
     * @return the model or <code>null</code>
     */
    Object get(String name);

    /**
     * Retrieve a model by name in a type-safe way.
     *
     * @param name  name of the model
     * @param clazz type of the model
     * @param <T>   type of the model
     * @return The model or <code>null</code>
     */
    <T> T get(String name, Class<T> clazz);

    /**
     * Returns a unmodifiable view of the models map.
     *
     * @return unmodifiable map
     */
    Map<String, Object> asMap();

}
