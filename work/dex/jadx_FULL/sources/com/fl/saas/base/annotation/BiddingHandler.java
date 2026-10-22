package com.fl.saas.base.annotation;

import com.fl.saas.base.base.AdapterAPI;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface BiddingHandler {
    Class<? extends AdapterAPI>[] extend() default {AdapterAPI.class};

    int value();
}
