package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode.j0;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class h7d implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FieldDescriptor f42070a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final h7d f16944a = new h7d();
    public static final FieldDescriptor b;
    public static final FieldDescriptor c;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("modelType");
        j0 j0Var = new j0();
        j0Var.a(1);
        f42070a = builder.withProperty(j0Var.b()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("isDownloaded");
        j0 j0Var2 = new j0();
        j0Var2.a(2);
        b = builder2.withProperty(j0Var2.b()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("modelName");
        j0 j0Var3 = new j0();
        j0Var3.a(3);
        c = builder3.withProperty(j0Var3.b()).build();
    }

    @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
