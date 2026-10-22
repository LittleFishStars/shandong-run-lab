package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_common.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ckc implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FieldDescriptor f40988a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ckc f15845a = new ckc();
    public static final FieldDescriptor b;
    public static final FieldDescriptor c;
    public static final FieldDescriptor d;
    public static final FieldDescriptor e;
    public static final FieldDescriptor f;
    public static final FieldDescriptor g;
    public static final FieldDescriptor h;
    public static final FieldDescriptor i;
    public static final FieldDescriptor j;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("sdkVersion");
        a aVar = new a();
        aVar.a(1);
        f40988a = builder.withProperty(aVar.b()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("osBuild");
        a aVar2 = new a();
        aVar2.a(2);
        b = builder2.withProperty(aVar2.b()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("brand");
        a aVar3 = new a();
        aVar3.a(3);
        c = builder3.withProperty(aVar3.b()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("device");
        a aVar4 = new a();
        aVar4.a(4);
        d = builder4.withProperty(aVar4.b()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder(ze1.l);
        a aVar5 = new a();
        aVar5.a(5);
        e = builder5.withProperty(aVar5.b()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder(ze1.p);
        a aVar6 = new a();
        aVar6.a(6);
        f = builder6.withProperty(aVar6.b()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder(ze1.k);
        a aVar7 = new a();
        aVar7.a(7);
        g = builder7.withProperty(aVar7.b()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder(ze1.n);
        a aVar8 = new a();
        aVar8.a(8);
        h = builder8.withProperty(aVar8.b()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("soc");
        a aVar9 = new a();
        aVar9.a(9);
        i = builder9.withProperty(aVar9.b()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("socMetaBuildId");
        a aVar10 = new a();
        aVar10.a(10);
        j = builder10.withProperty(aVar10.b()).build();
    }

    @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
