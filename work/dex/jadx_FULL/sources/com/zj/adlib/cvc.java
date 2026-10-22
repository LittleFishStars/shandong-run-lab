package com.zj.adlib;

import com.beizi.fusion.asnp.adn.ad.model.impl.db.StrategyEventDBModel;
import com.google.android.gms.internal.mlkit_vision_common.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class cvc implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FieldDescriptor f41051a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final cvc f15894a = new cvc();
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
        a aVar = new a();
        aVar.a(1);
        f41051a = builder.withProperty(aVar.b()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("appVersion");
        a aVar2 = new a();
        aVar2.a(2);
        b = builder2.withProperty(aVar2.b()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("firebaseProjectId");
        a aVar3 = new a();
        aVar3.a(3);
        c = builder3.withProperty(aVar3.b()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("mlSdkVersion");
        a aVar4 = new a();
        aVar4.a(4);
        d = builder4.withProperty(aVar4.b()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("tfliteSchemaVersion");
        a aVar5 = new a();
        aVar5.a(5);
        e = builder5.withProperty(aVar5.b()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("gcmSenderId");
        a aVar6 = new a();
        aVar6.a(6);
        f = builder6.withProperty(aVar6.b()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder(StrategyEventDBModel.COLUMN_API_KEY);
        a aVar7 = new a();
        aVar7.a(7);
        g = builder7.withProperty(aVar7.b()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("languages");
        a aVar8 = new a();
        aVar8.a(8);
        h = builder8.withProperty(aVar8.b()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("mlSdkInstanceId");
        a aVar9 = new a();
        aVar9.a(9);
        i = builder9.withProperty(aVar9.b()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("isClearcutClient");
        a aVar10 = new a();
        aVar10.a(10);
        j = builder10.withProperty(aVar10.b()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("isStandaloneMlkit");
        a aVar11 = new a();
        aVar11.a(11);
        k = builder11.withProperty(aVar11.b()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("isJsonLogging");
        a aVar12 = new a();
        aVar12.a(12);
        l = builder12.withProperty(aVar12.b()).build();
        FieldDescriptor.Builder builder13 = FieldDescriptor.builder("buildLevel");
        a aVar13 = new a();
        aVar13.a(13);
        m = builder13.withProperty(aVar13.b()).build();
        FieldDescriptor.Builder builder14 = FieldDescriptor.builder("optionalModuleVersion");
        a aVar14 = new a();
        aVar14.a(14);
        n = builder14.withProperty(aVar14.b()).build();
    }

    @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        cbd cbdVar = (cbd) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(f41051a, cbdVar.g());
        objectEncoderContext2.add(b, cbdVar.h());
        objectEncoderContext2.add(c, (Object) null);
        objectEncoderContext2.add(d, cbdVar.j());
        objectEncoderContext2.add(e, cbdVar.k());
        objectEncoderContext2.add(f, (Object) null);
        objectEncoderContext2.add(g, (Object) null);
        objectEncoderContext2.add(h, cbdVar.a());
        objectEncoderContext2.add(i, cbdVar.i());
        objectEncoderContext2.add(j, cbdVar.b());
        objectEncoderContext2.add(k, cbdVar.d());
        objectEncoderContext2.add(l, cbdVar.c());
        objectEncoderContext2.add(m, cbdVar.e());
        objectEncoderContext2.add(n, cbdVar.f());
    }
}
