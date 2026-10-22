package com.zj.adlib;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.ObjectEncoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class kdc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObjectEncoder f42796a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map f17664a;
    public final Map b;

    public kdc(Map map, Map map2, ObjectEncoder objectEncoder) {
        this.f17664a = map;
        this.b = map2;
        this.f42796a = objectEncoder;
    }

    @NonNull
    public final byte[] a(@NonNull Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new bdc(byteArrayOutputStream, this.f17664a, this.b, this.f42796a).f(obj);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
