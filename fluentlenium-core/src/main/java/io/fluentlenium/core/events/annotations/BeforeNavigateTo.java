package io.fluentlenium.core.events.annotations;

import io.fluentlenium.core.events.EventsRegistry;
import io.fluentlenium.core.events.NavigateToListener;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Add this annotation on a method to register it in {@link EventsRegistry}.
 * <p>
 * Can be used in test adapter or injected pages only.
 * <p>
 * Parameters from {@link NavigateToListener} will be injected in the method based on parameters types.
 *
 * @see EventsRegistry#beforeNavigateTo(NavigateToListener)
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BeforeNavigateTo {
    /**
     * Priority of the method. Higher priority will be executed first.
     *
     * @return priority value
     */
    int value() default 0;
}
