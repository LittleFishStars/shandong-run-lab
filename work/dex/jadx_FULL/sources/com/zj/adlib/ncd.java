package com.zj.adlib;

import com.facebook.imagepipeline.producers.DecodeProducer;
import com.google.android.gms.internal.mlkit_vision_barcode.j0;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ncd implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FieldDescriptor f43494a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ncd f18389a = new ncd();
    public static final FieldDescriptor b;
    public static final FieldDescriptor c;
    public static final FieldDescriptor d;
    public static final FieldDescriptor e;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("inferenceCommonLogEvent");
        j0 j0Var = new j0();
        j0Var.a(1);
        f43494a = builder.withProperty(j0Var.b()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("imageInfo");
        j0 j0Var2 = new j0();
        j0Var2.a(2);
        b = builder2.withProperty(j0Var2.b()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("captionCount");
        j0 j0Var3 = new j0();
        j0Var3.a(4);
        c = builder3.withProperty(j0Var3.b()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("highestScore");
        j0 j0Var4 = new j0();
        j0Var4.a(5);
        d = builder4.withProperty(j0Var4.b()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder(DecodeProducer.d);
        j0 j0Var5 = new j0();
        j0Var5.a(6);
        e = builder5.withProperty(j0Var5.b()).build();
    }

    @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
