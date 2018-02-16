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
 * This exception is thrown by the MVC implementation if the CSRF token validation fails.
 * By default this will result in a 403 status code sent to the client. The application
 * can provide a custom exception mapper for this exception type to customize this
 * default behavior.
 *
 * @author Christian Kaltepoth
 * @since 1.0
 */
public class CsrfValidationException extends RuntimeException {

    private static final long serialVersionUID = -1083828917314728056L;

    /**
     * Create a new CsrfValidationException
     *
     * @param message the detail message
     */
    public CsrfValidationException(String message) {
        super(message);
    }

}
