package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_common.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class fnc implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FieldDescriptor f41716a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final fnc f16586a = new fnc();
    public static final FieldDescriptor b;
    public static final FieldDescriptor c;
    public static final FieldDescriptor d;
    public static final FieldDescriptor e;
    public static final FieldDescriptor f;
    public static final FieldDescriptor g;
    public static final FieldDescriptor h;
    public static final FieldDescriptor i;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("name");
        a aVar = new a();
        aVar.a(1);
        f41716a = builder.withProperty(aVar.b()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("version");
        a aVar2 = new a();
        aVar2.a(2);
        b = builder2.withProperty(aVar2.b()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("source");
        a aVar3 = new a();
        aVar3.a(3);
        c = builder3.withProperty(aVar3.b()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("uri");
        a aVar4 = new a();
        aVar4.a(4);
        d = builder4.withProperty(aVar4.b()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("hash");
        a aVar5 = new a();
        aVar5.a(5);
        e = builder5.withProperty(aVar5.b()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("modelType");
        a aVar6 = new a();
        aVar6.a(6);
        f = builder6.withProperty(aVar6.b()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("size");
        a aVar7 = new a();
        aVar7.a(7);
        g = builder7.withProperty(aVar7.b()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("hasLabelMap");
        a aVar8 = new a();
        aVar8.a(8);
        h = builder8.withProperty(aVar8.b()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("isManifestModel");
        a aVar9 = new a();
        aVar9.a(9);
        i = builder9.withProperty(aVar9.b()).build();
    }

    @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
