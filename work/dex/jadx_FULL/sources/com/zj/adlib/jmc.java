package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_common.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class jmc implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FieldDescriptor f42619a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final jmc f17433a = new jmc();
    public static final FieldDescriptor b;
    public static final FieldDescriptor c;
    public static final FieldDescriptor d;
    public static final FieldDescriptor e;
    public static final FieldDescriptor f;
    public static final FieldDescriptor g;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("durationMs");
        a aVar = new a();
        aVar.a(1);
        f42619a = builder.withProperty(aVar.b()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("imageSource");
        a aVar2 = new a();
        aVar2.a(2);
        b = builder2.withProperty(aVar2.b()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("imageFormat");
        a aVar3 = new a();
        aVar3.a(3);
        c = builder3.withProperty(aVar3.b()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("imageByteSize");
        a aVar4 = new a();
        aVar4.a(4);
        d = builder4.withProperty(aVar4.b()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("imageWidth");
        a aVar5 = new a();
        aVar5.a(5);
        e = builder5.withProperty(aVar5.b()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("imageHeight");
        a aVar6 = new a();
        aVar6.a(6);
        f = builder6.withProperty(aVar6.b()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("rotationDegrees");
        a aVar7 = new a();
        aVar7.a(7);
        g = builder7.withProperty(aVar7.b()).build();
    }

    @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        f2d f2dVar = (f2d) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(f42619a, f2dVar.g());
        objectEncoderContext2.add(b, f2dVar.b());
        objectEncoderContext2.add(c, f2dVar.a());
        objectEncoderContext2.add(d, f2dVar.c());
        objectEncoderContext2.add(e, f2dVar.e());
        objectEncoderContext2.add(f, f2dVar.d());
        objectEncoderContext2.add(g, f2dVar.f());
    }
}
