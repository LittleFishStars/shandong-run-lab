package com.zj.adlib;

import com.beizi.fusion.asnp.adn.ad.model.impl.db.StrategyEventDBModel;
import com.google.android.gms.internal.mlkit_common.d;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class j4d implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FieldDescriptor f42510a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final j4d f17327a = new j4d();
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
    public static final FieldDescriptor m;
    public static final FieldDescriptor n;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("appId");
        d dVar = new d();
        dVar.a(1);
        f42510a = builder.withProperty(dVar.b()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("appVersion");
        d dVar2 = new d();
        dVar2.a(2);
        b = builder2.withProperty(dVar2.b()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("firebaseProjectId");
        d dVar3 = new d();
        dVar3.a(3);
        c = builder3.withProperty(dVar3.b()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("mlSdkVersion");
        d dVar4 = new d();
        dVar4.a(4);
        d = builder4.withProperty(dVar4.b()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("tfliteSchemaVersion");
        d dVar5 = new d();
        dVar5.a(5);
        e = builder5.withProperty(dVar5.b()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("gcmSenderId");
        d dVar6 = new d();
        dVar6.a(6);
        f = builder6.withProperty(dVar6.b()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder(StrategyEventDBModel.COLUMN_API_KEY);
        d dVar7 = new d();
        dVar7.a(7);
        g = builder7.withProperty(dVar7.b()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("languages");
        d dVar8 = new d();
        dVar8.a(8);
        h = builder8.withProperty(dVar8.b()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("mlSdkInstanceId");
        d dVar9 = new d();
        dVar9.a(9);
        i = builder9.withProperty(dVar9.b()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("isClearcutClient");
        d dVar10 = new d();
        dVar10.a(10);
        j = builder10.withProperty(dVar10.b()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("isStandaloneMlkit");
        d dVar11 = new d();
        dVar11.a(11);
        k = builder11.withProperty(dVar11.b()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("isJsonLogging");
        d dVar12 = new d();
        dVar12.a(12);
        l = builder12.withProperty(dVar12.b()).build();
        FieldDescriptor.Builder builder13 = FieldDescriptor.builder("buildLevel");
        d dVar13 = new d();
        dVar13.a(13);
        m = builder13.withProperty(dVar13.b()).build();
        FieldDescriptor.Builder builder14 = FieldDescriptor.builder("optionalModuleVersion");
        d dVar14 = new d();
        dVar14.a(14);
        n = builder14.withProperty(dVar14.b()).build();
    }

    @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        mkd mkdVar = (mkd) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(f42510a, mkdVar.g());
        objectEncoderContext2.add(b, mkdVar.h());
        objectEncoderContext2.add(c, (Object) null);
        objectEncoderContext2.add(d, mkdVar.j());
        objectEncoderContext2.add(e, mkdVar.k());
        objectEncoderContext2.add(f, (Object) null);
        objectEncoderContext2.add(g, (Object) null);
        objectEncoderContext2.add(h, mkdVar.a());
        objectEncoderContext2.add(i, mkdVar.i());
        objectEncoderContext2.add(j, mkdVar.b());
        objectEncoderContext2.add(k, mkdVar.d());
        objectEncoderContext2.add(l, mkdVar.c());
        objectEncoderContext2.add(m, mkdVar.e());
        objectEncoderContext2.add(n, mkdVar.f());
    }
}
