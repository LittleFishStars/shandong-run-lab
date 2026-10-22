package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode.j0;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class dxc implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FieldDescriptor f41304a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final dxc f16161a = new dxc();
    public static final FieldDescriptor b;
    public static final FieldDescriptor c;
    public static final FieldDescriptor d;
    public static final FieldDescriptor e;
    public static final FieldDescriptor f;
    public static final FieldDescriptor g;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("errorCode");
        j0 j0Var = new j0();
        j0Var.a(1);
        f41304a = builder.withProperty(j0Var.b()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("hasResult");
        j0 j0Var2 = new j0();
        j0Var2.a(2);
        b = builder2.withProperty(j0Var2.b()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("isColdCall");
        j0 j0Var3 = new j0();
        j0Var3.a(3);
        c = builder3.withProperty(j0Var3.b()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("imageInfo");
        j0 j0Var4 = new j0();
        j0Var4.a(4);
        d = builder4.withProperty(j0Var4.b()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("options");
        j0 j0Var5 = new j0();
        j0Var5.a(5);
        e = builder5.withProperty(j0Var5.b()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("detectedBarcodeFormats");
        j0 j0Var6 = new j0();
        j0Var6.a(6);
        f = builder6.withProperty(j0Var6.b()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("detectedBarcodeValueTypes");
        j0 j0Var7 = new j0();
        j0Var7.a(7);
        g = builder7.withProperty(j0Var7.b()).build();
    }

    @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        crc crcVar = (crc) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(f41304a, crcVar.c());
        objectEncoderContext2.add(b, (Object) null);
        objectEncoderContext2.add(c, crcVar.e());
        objectEncoderContext2.add(d, (Object) null);
        objectEncoderContext2.add(e, crcVar.d());
        objectEncoderContext2.add(f, crcVar.a());
        objectEncoderContext2.add(g, crcVar.b());
    }
}
