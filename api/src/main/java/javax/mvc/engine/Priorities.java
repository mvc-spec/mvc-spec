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
package javax.mvc.engine;

/**
 * <p>Defines priority classes that can used together with the {@link javax.annotation.Priority}
 * annotation to decorate {@link javax.mvc.engine.ViewEngine} implementations. When
 * multiple view engines are available to process a view, the one with the highest
 * priority is chosen. If two or more view engines can process the same view and they
 * all have the same priority, one is chosen in an implementation-defined manner.</p>
 *
 * <p>Applications can define observers for {@link javax.mvc.event.BeforeProcessViewEvent}
 * and {@link javax.mvc.event.AfterProcessViewEvent} to get additional information about
 * view processing.</p>
 *
 * @author Santiago Pericas-Geertsen
 * @see javax.annotation.Priority
 * @see javax.mvc.engine.ViewEngine
 * @since 1.0
 */
@SuppressWarnings("unused")
public interface Priorities {

    /**
     * Default priority for all built-in view engines.
     */
    int DEFAULT = 1000;

    /**
     * Recommended priority for all view engines provided by frameworks built
     * on top of MVC implementations.
     */
    int FRAMEWORK = 2000;

    /**
     * Recommended priority for all application-provided view engines.
     */
    int APPLICATION = 3000;
}
