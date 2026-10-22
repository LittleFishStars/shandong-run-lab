package com.facebook.imagepipeline.producers;

import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface ProducerListener {
    void c(String str, String str2, @Nullable Map<String, String> map);

    void d(String str, String str2, String str3);

    void g(String str, String str2);

    boolean h(String str);

    void i(String str, String str2, @Nullable Map<String, String> map);

    void j(String str, String str2, Throwable th, @Nullable Map<String, String> map);
}
