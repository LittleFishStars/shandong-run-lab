package com.zj.adlib;

import com.google.android.gms.internal.mlkit_common.d;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class osc implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FieldDescriptor f43828a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final osc f18718a = new osc();
    public static final FieldDescriptor b;
    public static final FieldDescriptor c;
    public static final FieldDescriptor d;
    public static final FieldDescriptor e;
    public static final FieldDescriptor f;
    public static final FieldDescriptor g;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("durationMs");
        d dVar = new d();
        dVar.a(1);
        f43828a = builder.withProperty(dVar.b()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("imageSource");
        d dVar2 = new d();
        dVar2.a(2);
        b = builder2.withProperty(dVar2.b()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("imageFormat");
        d dVar3 = new d();
        dVar3.a(3);
        c = builder3.withProperty(dVar3.b()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("imageByteSize");
        d dVar4 = new d();
        dVar4.a(4);
        d = builder4.withProperty(dVar4.b()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("imageWidth");
        d dVar5 = new d();
        dVar5.a(5);
        e = builder5.withProperty(dVar5.b()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("imageHeight");
        d dVar6 = new d();
        dVar6.a(6);
        f = builder6.withProperty(dVar6.b()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("rotationDegrees");
        d dVar7 = new d();
        dVar7.a(7);
        g = builder7.withProperty(dVar7.b()).build();
    }

    @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
