package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode.j0;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class pfd implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FieldDescriptor f43976a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final pfd f18840a = new pfd();
    public static final FieldDescriptor b;
    public static final FieldDescriptor c;
    public static final FieldDescriptor d;
    public static final FieldDescriptor e;
    public static final FieldDescriptor f;
    public static final FieldDescriptor g;
    public static final FieldDescriptor h;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("inferenceCommonLogEvent");
        j0 j0Var = new j0();
        j0Var.a(1);
        f43976a = builder.withProperty(j0Var.b()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("options");
        j0 j0Var2 = new j0();
        j0Var2.a(2);
        b = builder2.withProperty(j0Var2.b()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("inputLength");
        j0 j0Var3 = new j0();
        j0Var3.a(3);
        c = builder3.withProperty(j0Var3.b()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("outputLength");
        j0 j0Var4 = new j0();
        j0Var4.a(4);
        d = builder4.withProperty(j0Var4.b()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("loadDictionaryErrorCode");
        j0 j0Var5 = new j0();
        j0Var5.a(5);
        e = builder5.withProperty(j0Var5.b()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("translateResultStatusCode");
        j0 j0Var6 = new j0();
        j0Var6.a(6);
        f = builder6.withProperty(j0Var6.b()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("status");
        j0 j0Var7 = new j0();
        j0Var7.a(7);
        g = builder7.withProperty(j0Var7.b()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("downloadHttpResponseCode");
        j0 j0Var8 = new j0();
        j0Var8.a(8);
        h = builder8.withProperty(j0Var8.b()).build();
    }

    @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
