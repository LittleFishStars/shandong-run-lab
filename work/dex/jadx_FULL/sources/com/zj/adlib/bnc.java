package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_common.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class bnc implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FieldDescriptor f40788a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final bnc f15586a = new bnc();
    public static final FieldDescriptor b;
    public static final FieldDescriptor c;
    public static final FieldDescriptor d;
    public static final FieldDescriptor e;
    public static final FieldDescriptor f;
    public static final FieldDescriptor g;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("options");
        a aVar = new a();
        aVar.a(1);
        f40788a = builder.withProperty(aVar.b()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("roughDownloadDurationMs");
        a aVar2 = new a();
        aVar2.a(2);
        b = builder2.withProperty(aVar2.b()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("errorCode");
        a aVar3 = new a();
        aVar3.a(3);
        c = builder3.withProperty(aVar3.b()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("exactDownloadDurationMs");
        a aVar4 = new a();
        aVar4.a(4);
        d = builder4.withProperty(aVar4.b()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("downloadStatus");
        a aVar5 = new a();
        aVar5.a(5);
        e = builder5.withProperty(aVar5.b()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("downloadFailureStatus");
        a aVar6 = new a();
        aVar6.a(6);
        f = builder6.withProperty(aVar6.b()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("mddDownloadErrorCodes");
        a aVar7 = new a();
        aVar7.a(7);
        g = builder7.withProperty(aVar7.b()).build();
    }

    @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
