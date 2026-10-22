package com.zj.adlib;

import com.beizi.fusion.asnp.adn.ad.model.impl.db.StrategyEventDBModel;
import com.google.android.gms.internal.mlkit_vision_barcode.j0;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ugd implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FieldDescriptor f45147a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ugd f20065a = new ugd();
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
        j0 j0Var = new j0();
        j0Var.a(1);
        f45147a = builder.withProperty(j0Var.b()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("appVersion");
        j0 j0Var2 = new j0();
        j0Var2.a(2);
        b = builder2.withProperty(j0Var2.b()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("firebaseProjectId");
        j0 j0Var3 = new j0();
        j0Var3.a(3);
        c = builder3.withProperty(j0Var3.b()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("mlSdkVersion");
        j0 j0Var4 = new j0();
        j0Var4.a(4);
        d = builder4.withProperty(j0Var4.b()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("tfliteSchemaVersion");
        j0 j0Var5 = new j0();
        j0Var5.a(5);
        e = builder5.withProperty(j0Var5.b()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("gcmSenderId");
        j0 j0Var6 = new j0();
        j0Var6.a(6);
        f = builder6.withProperty(j0Var6.b()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder(StrategyEventDBModel.COLUMN_API_KEY);
        j0 j0Var7 = new j0();
        j0Var7.a(7);
        g = builder7.withProperty(j0Var7.b()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("languages");
        j0 j0Var8 = new j0();
        j0Var8.a(8);
        h = builder8.withProperty(j0Var8.b()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("mlSdkInstanceId");
        j0 j0Var9 = new j0();
        j0Var9.a(9);
        i = builder9.withProperty(j0Var9.b()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("isClearcutClient");
        j0 j0Var10 = new j0();
        j0Var10.a(10);
        j = builder10.withProperty(j0Var10.b()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("isStandaloneMlkit");
        j0 j0Var11 = new j0();
        j0Var11.a(11);
        k = builder11.withProperty(j0Var11.b()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("isJsonLogging");
        j0 j0Var12 = new j0();
        j0Var12.a(12);
        l = builder12.withProperty(j0Var12.b()).build();
        FieldDescriptor.Builder builder13 = FieldDescriptor.builder("buildLevel");
        j0 j0Var13 = new j0();
        j0Var13.a(13);
        m = builder13.withProperty(j0Var13.b()).build();
        FieldDescriptor.Builder builder14 = FieldDescriptor.builder("optionalModuleVersion");
        j0 j0Var14 = new j0();
        j0Var14.a(14);
        n = builder14.withProperty(j0Var14.b()).build();
    }

    @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        xqd xqdVar = (xqd) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(f45147a, xqdVar.g());
        objectEncoderContext2.add(b, xqdVar.h());
        objectEncoderContext2.add(c, (Object) null);
        objectEncoderContext2.add(d, xqdVar.j());
        objectEncoderContext2.add(e, xqdVar.k());
        objectEncoderContext2.add(f, (Object) null);
        objectEncoderContext2.add(g, (Object) null);
        objectEncoderContext2.add(h, xqdVar.a());
        objectEncoderContext2.add(i, xqdVar.i());
        objectEncoderContext2.add(j, xqdVar.b());
        objectEncoderContext2.add(k, xqdVar.d());
        objectEncoderContext2.add(l, xqdVar.c());
        objectEncoderContext2.add(m, xqdVar.e());
        objectEncoderContext2.add(n, xqdVar.f());
    }
}
