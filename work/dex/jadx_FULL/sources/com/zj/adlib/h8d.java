package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode.j0;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class h8d implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FieldDescriptor f42074a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final h8d f16949a = new h8d();
    public static final FieldDescriptor b;
    public static final FieldDescriptor c;
    public static final FieldDescriptor d;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("options");
        j0 j0Var = new j0();
        j0Var.a(1);
        f42074a = builder.withProperty(j0Var.b()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("latencyMs");
        j0 j0Var2 = new j0();
        j0Var2.a(2);
        b = builder2.withProperty(j0Var2.b()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("frameCount");
        j0 j0Var3 = new j0();
        j0Var3.a(3);
        c = builder3.withProperty(j0Var3.b()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("errorCode");
        j0 j0Var4 = new j0();
        j0Var4.a(4);
        d = builder4.withProperty(j0Var4.b()).build();
    }

    @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
