package com.zj.adlib;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.ObjectEncoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class xpc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObjectEncoder f45875a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map f20701a;
    public final Map b;

    public xpc(Map map, Map map2, ObjectEncoder objectEncoder) {
        this.f20701a = map;
        this.b = map2;
        this.f45875a = objectEncoder;
    }

    @NonNull
    public final byte[] a(@NonNull Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new mpc(byteArrayOutputStream, this.f20701a, this.b, this.f45875a).f(obj);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
