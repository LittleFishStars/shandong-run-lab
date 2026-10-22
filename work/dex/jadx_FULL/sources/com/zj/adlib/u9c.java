package com.zj.adlib;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.ObjectEncoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class u9c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObjectEncoder f45098a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map f20016a;
    public final Map b;

    public u9c(Map map, Map map2, ObjectEncoder objectEncoder) {
        this.f20016a = map;
        this.b = map2;
        this.f45098a = objectEncoder;
    }

    @NonNull
    public final byte[] a(@NonNull Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new k9c(byteArrayOutputStream, this.f20016a, this.b, this.f45098a).f(obj);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
