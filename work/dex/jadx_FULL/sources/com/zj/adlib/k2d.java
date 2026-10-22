package com.zj.adlib;

import com.google.android.gms.internal.mlkit_common.d;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class k2d implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FieldDescriptor f42731a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final k2d f17561a = new k2d();
    public static final FieldDescriptor b;
    public static final FieldDescriptor c;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("languageOption");
        d dVar = new d();
        dVar.a(3);
        f42731a = builder.withProperty(dVar.b()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("isUsingLegacyApi");
        d dVar2 = new d();
        dVar2.a(4);
        b = builder2.withProperty(dVar2.b()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("sdkVersion");
        d dVar3 = new d();
        dVar3.a(5);
        c = builder3.withProperty(dVar3.b()).build();
    }

    @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
