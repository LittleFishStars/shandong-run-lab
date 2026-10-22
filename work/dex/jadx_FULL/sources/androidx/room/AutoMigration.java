package androidx.room;

import androidx.annotation.RestrictTo;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public @interface AutoMigration {
    int from();

    int to();
}
