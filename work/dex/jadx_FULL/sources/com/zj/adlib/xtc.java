package com.zj.adlib;

import com.google.android.gms.internal.mlkit_common.d;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class xtc implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FieldDescriptor f45897a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final xtc f20732a = new xtc();
    public static final FieldDescriptor b;
    public static final FieldDescriptor c;
    public static final FieldDescriptor d;
    public static final FieldDescriptor e;
    public static final FieldDescriptor f;
    public static final FieldDescriptor g;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("options");
        d dVar = new d();
        dVar.a(1);
        f45897a = builder.withProperty(dVar.b()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("roughDownloadDurationMs");
        d dVar2 = new d();
        dVar2.a(2);
        b = builder2.withProperty(dVar2.b()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("errorCode");
        d dVar3 = new d();
        dVar3.a(3);
        c = builder3.withProperty(dVar3.b()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("exactDownloadDurationMs");
        d dVar4 = new d();
        dVar4.a(4);
        d = builder4.withProperty(dVar4.b()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("downloadStatus");
        d dVar5 = new d();
        dVar5.a(5);
        e = builder5.withProperty(dVar5.b()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("downloadFailureStatus");
        d dVar6 = new d();
        dVar6.a(6);
        f = builder6.withProperty(dVar6.b()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("mddDownloadErrorCodes");
        d dVar7 = new d();
        dVar7.a(7);
        g = builder7.withProperty(dVar7.b()).build();
    }

    @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        hdd hddVar = (hdd) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(f45897a, hddVar.c());
        objectEncoderContext2.add(b, hddVar.f());
        objectEncoderContext2.add(c, hddVar.a());
        objectEncoderContext2.add(d, hddVar.e());
        objectEncoderContext2.add(e, hddVar.b());
        objectEncoderContext2.add(f, hddVar.d());
        objectEncoderContext2.add(g, (Object) null);
    }
}
