package com.beizi.fusion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface j6 {
    String column();

    boolean encode() default true;
}
