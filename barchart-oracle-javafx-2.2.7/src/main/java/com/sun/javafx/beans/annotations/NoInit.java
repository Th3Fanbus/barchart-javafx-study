package com.sun.javafx.beans.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD})
public @interface NoInit
{
}

/* Location:           /home/user1/Temp/jfxrt/jfxrt.jar
 * Qualified Name:     com.sun.javafx.beans.annotations.NoInit
 * JD-Core Version:    0.6.2
 */