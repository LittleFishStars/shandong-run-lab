package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_common.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class eic implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FieldDescriptor f41445a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final eic f16322a = new eic();
    public static final FieldDescriptor b;
    public static final FieldDescriptor c;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("inferenceCommonLogEvent");
        a aVar = new a();
        aVar.a(1);
        f41445a = builder.withProperty(aVar.b()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("options");
        a aVar2 = new a();
        aVar2.a(2);
        b = builder2.withProperty(aVar2.b()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("imageInfo");
        a aVar3 = new a();
        aVar3.a(3);
        c = builder3.withProperty(aVar3.b()).build();
    }

    @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
