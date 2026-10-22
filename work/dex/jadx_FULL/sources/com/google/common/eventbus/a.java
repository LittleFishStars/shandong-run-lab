package com.google.common.eventbus;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
public class a extends c {
    public a(String str, Executor executor) {
        super(str, executor, Dispatcher.c(), c.a.f32033a);
    }

    public a(Executor executor, SubscriberExceptionHandler subscriberExceptionHandler) {
        super("default", executor, Dispatcher.c(), subscriberExceptionHandler);
    }

    public a(Executor executor) {
        super("default", executor, Dispatcher.c(), c.a.f32033a);
    }
}
