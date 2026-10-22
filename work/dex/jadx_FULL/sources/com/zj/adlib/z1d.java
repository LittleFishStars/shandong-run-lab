package com.zj.adlib;

import com.google.android.gms.internal.mlkit_common.d;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class z1d implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FieldDescriptor f46167a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final z1d f20957a = new z1d();

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("confidence");
        d dVar = new d();
        dVar.a(1);
        f46167a = builder.withProperty(dVar.b()).build();
    }

    @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
