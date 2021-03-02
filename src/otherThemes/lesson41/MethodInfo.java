package otherThemes.lesson41;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target({ElementType.METHOD, ElementType.TYPE})
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME) // Можем исп-ть аннотоцию входе выполнения программы
public @interface MethodInfo {
    // Это поле но реализация как у метода
    String author() default "Tom" ; // это будет дефолтным значением, если мы не дадим значения
    int dateOfCreation() default 2021 ;
    String purpose();
}
