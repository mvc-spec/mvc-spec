package javax.mvc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>Defines a symbolic name for a controller method to be referenced by one of the
 * {@link javax.mvc.MvcContext#uri} methods.</p>
 *
 * <p>The same value of @UriRef can only be used multiple times on different methods
 * if these methods are using the same URI-template with different HTTP verbs.</p>
 *
 * @author Florian Hirsch
 * @see javax.mvc.MvcContext#uri
 * @since 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UriRef {

    String value();

}
