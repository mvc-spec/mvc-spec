/*
 * Copyright (c) 2016-2018 JSR 371 expert group and contributors
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

import javax.validation.ConstraintViolation;

/**
 * <p>Represents a single validation error detected for a parameter. A validation error always
 * corresponds to exactly one {@link ConstraintViolation}.</p>
 *
 * @author Christian Kaltepoth
 * @since 1.0
 */
public interface ValidationError extends ParamError {

    /**
     * The underlying {@link ConstraintViolation} detected for the parameter.
     *
     * @return The violation detected for the parameter
     */
    ConstraintViolation<?> getViolation();

}
