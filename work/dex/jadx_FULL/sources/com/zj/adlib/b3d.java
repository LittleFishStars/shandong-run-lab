package com.zj.adlib;

import com.google.android.gms.internal.mlkit_common.d;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b3d implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FieldDescriptor f40672a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final b3d f15431a = new b3d();
    public static final FieldDescriptor b;
    public static final FieldDescriptor c;
    public static final FieldDescriptor d;
    public static final FieldDescriptor e;
    public static final FieldDescriptor f;
    public static final FieldDescriptor g;
    public static final FieldDescriptor h;
    public static final FieldDescriptor i;
    public static final FieldDescriptor j;
    public static final FieldDescriptor k;
    public static final FieldDescriptor l;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("deviceInfo");
        d dVar = new d();
        dVar.a(1);
        f40672a = builder.withProperty(dVar.b()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("nnapiInfo");
        d dVar2 = new d();
        dVar2.a(2);
        b = builder2.withProperty(dVar2.b()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("gpuInfo");
        d dVar3 = new d();
        dVar3.a(3);
        c = builder3.withProperty(dVar3.b()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("pipelineIdentifier");
        d dVar4 = new d();
        dVar4.a(4);
        d = builder4.withProperty(dVar4.b()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("acceptedConfigurations");
        d dVar5 = new d();
        dVar5.a(5);
        e = builder5.withProperty(dVar5.b()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("action");
        d dVar6 = new d();
        dVar6.a(6);
        f = builder6.withProperty(dVar6.b()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("status");
        d dVar7 = new d();
        dVar7.a(7);
        g = builder7.withProperty(dVar7.b()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("customErrors");
        d dVar8 = new d();
        dVar8.a(8);
        h = builder8.withProperty(dVar8.b()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("benchmarkStatus");
        d dVar9 = new d();
        dVar9.a(9);
        i = builder9.withProperty(dVar9.b()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("validationTestResult");
        d dVar10 = new d();
        dVar10.a(10);
        j = builder10.withProperty(dVar10.b()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("timestampUs");
        d dVar11 = new d();
        dVar11.a(11);
        k = builder11.withProperty(dVar11.b()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("elapsedUs");
        d dVar12 = new d();
        dVar12.a(12);
        l = builder12.withProperty(dVar12.b()).build();
    }

    @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
