package com.zj.adlib;

import com.google.android.gms.internal.mlkit_common.d;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class rrc implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FieldDescriptor f44524a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final rrc f19404a = new rrc();
    public static final FieldDescriptor b;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("scoreType");
        d dVar = new d();
        dVar.a(1);
        f44524a = builder.withProperty(dVar.b()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("score");
        d dVar2 = new d();
        dVar2.a(2);
        b = builder2.withProperty(dVar2.b()).build();
    }

    @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
