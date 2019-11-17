/*
 * Copyright (c) 2015 Oracle and/or its affiliates. All rights reserved.
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
package javax.mvc.engine;

/**
 * <p>Exception thrown by {@link javax.mvc.engine.ViewEngine#processView(ViewEngineContext)}
 * when unable to process a view.</p>
 *
 * @author Santiago Pericas-Geertsen
 * @see Exception#getMessage()
 * @see Exception#getCause()
 * @since 1.0
 */
public class ViewEngineException extends Exception {

    private static final long serialVersionUID = -429507729780110056L;

    /**
     * Construct an instance using a message.
     *
     * @param message the message.
     */
    public ViewEngineException(String message) {
        super(message);
    }

    /**
     * Construct an instance using a message and a cause.
     *
     * @param message the message.
     * @param cause the underlying cause.
     */
    public ViewEngineException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construct an instance using a cause.
     *
     * @param cause the underlying cause.
     */
    public ViewEngineException(Throwable cause) {
        super(cause);
    }
}
