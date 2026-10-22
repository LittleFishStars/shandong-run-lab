package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode.j0;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class x9d implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FieldDescriptor f45773a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final x9d f20621a = new x9d();

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("errorCode");
        j0 j0Var = new j0();
        j0Var.a(1);
        f45773a = builder.withProperty(j0Var.b()).build();
    }

    @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        objectEncoderContext.add(f45773a, ((rnd) obj).a());
    }
}
