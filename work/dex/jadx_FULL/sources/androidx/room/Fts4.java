package androidx.room;

import androidx.annotation.RequiresApi;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Target({ElementType.TYPE})
@RequiresApi(16)
@Retention(RetentionPolicy.CLASS)
public @interface Fts4 {
    Class<?> contentEntity() default Object.class;

    String languageId() default "";

    FtsOptions.MatchInfo matchInfo() default FtsOptions.MatchInfo.FTS4;

    String[] notIndexed() default {};

    FtsOptions.Order order() default FtsOptions.Order.ASC;

    int[] prefix() default {};

    String tokenizer() default "simple";

    String[] tokenizerArgs() default {};
}
