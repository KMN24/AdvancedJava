package otherThemes.lesson42;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD , ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Author {
    String name(); // это поле а не метод

    int dateOfCreation(); // поле (attribute)
}
