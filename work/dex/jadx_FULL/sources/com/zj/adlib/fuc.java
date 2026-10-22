package com.zj.adlib;

import com.google.android.gms.internal.mlkit_common.d;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class fuc implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FieldDescriptor f41760a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final fuc f16620a = new fuc();
    public static final FieldDescriptor b;
    public static final FieldDescriptor c;
    public static final FieldDescriptor d;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("modelInfo");
        d dVar = new d();
        dVar.a(1);
        f41760a = builder.withProperty(dVar.b()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("initialDownloadConditions");
        d dVar2 = new d();
        dVar2.a(2);
        b = builder2.withProperty(dVar2.b()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("updateDownloadConditions");
        d dVar3 = new d();
        dVar3.a(3);
        c = builder3.withProperty(dVar3.b()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("isModelUpdateEnabled");
        d dVar4 = new d();
        dVar4.a(4);
        d = builder4.withProperty(dVar4.b()).build();
    }

    @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(f41760a, ((led) obj).a());
        objectEncoderContext2.add(b, (Object) null);
        objectEncoderContext2.add(c, (Object) null);
        objectEncoderContext2.add(d, (Object) null);
    }
}
