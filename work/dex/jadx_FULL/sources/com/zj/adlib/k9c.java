package com.zj.adlib;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.google.android.gms.internal.mlkit_vision_common.a;
import com.google.android.gms.internal.mlkit_vision_common.zzag;
import com.google.android.gms.internal.mlkit_vision_common.zzah;
import com.google.android.gms.internal.mlkit_vision_common.zzai;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class k9c implements ObjectEncoderContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FieldDescriptor f42770a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Charset f17618a = Charset.forName("UTF-8");
    public static final FieldDescriptor b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final ObjectEncoder f17619b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ObjectEncoder f17620a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final y9c f17621a = new y9c(this);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OutputStream f17622a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map f17623a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Map f17624b;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder(CachedContentIndex.a.e);
        a aVar = new a();
        aVar.a(1);
        f42770a = builder.withProperty(aVar.b()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("value");
        a aVar2 = new a();
        aVar2.a(2);
        b = builder2.withProperty(aVar2.b()).build();
        f17619b = new ObjectEncoder() { // from class: com.zj.adlib.h9c
            @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
            public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
                k9c.g((Map.Entry) obj, objectEncoderContext);
            }
        };
    }

    public k9c(OutputStream outputStream, Map map, Map map2, ObjectEncoder objectEncoder) {
        this.f17622a = outputStream;
        this.f17623a = map;
        this.f17624b = map2;
        this.f17620a = objectEncoder;
    }

    public static /* synthetic */ void g(Map.Entry entry, ObjectEncoderContext objectEncoderContext) throws IOException {
        objectEncoderContext.add(f42770a, entry.getKey());
        objectEncoderContext.add(b, entry.getValue());
    }

    public static int h(FieldDescriptor fieldDescriptor) {
        zzai zzaiVar = (zzai) fieldDescriptor.getProperty(zzai.class);
        if (zzaiVar != null) {
            return zzaiVar.zza();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    public static zzai j(FieldDescriptor fieldDescriptor) {
        zzai zzaiVar = (zzai) fieldDescriptor.getProperty(zzai.class);
        if (zzaiVar != null) {
            return zzaiVar;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    public static ByteBuffer m(int i) {
        return ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
    }

    public final ObjectEncoderContext a(@NonNull FieldDescriptor fieldDescriptor, double d, boolean z) throws IOException {
        if (z && d == AudioStats.AUDIO_AMPLITUDE_NONE) {
            return this;
        }
        n((h(fieldDescriptor) << 3) | 1);
        this.f17622a.write(m(8).putDouble(d).array());
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, double d) throws IOException {
        a(fieldDescriptor, d, true);
        return this;
    }

    public final ObjectEncoderContext b(@NonNull FieldDescriptor fieldDescriptor, float f, boolean z) throws IOException {
        if (z && f == 0.0f) {
            return this;
        }
        n((h(fieldDescriptor) << 3) | 5);
        this.f17622a.write(m(4).putFloat(f).array());
        return this;
    }

    public final ObjectEncoderContext c(@NonNull FieldDescriptor fieldDescriptor, @Nullable Object obj, boolean z) throws IOException {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z && charSequence.length() == 0) {
                return this;
            }
            n((h(fieldDescriptor) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f17618a);
            n(bytes.length);
            this.f17622a.write(bytes);
            return this;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                c(fieldDescriptor, it.next(), false);
            }
            return this;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                k(f17619b, fieldDescriptor, (Map.Entry) it2.next(), false);
            }
            return this;
        }
        if (obj instanceof Double) {
            a(fieldDescriptor, ((Double) obj).doubleValue(), z);
            return this;
        }
        if (obj instanceof Float) {
            b(fieldDescriptor, ((Float) obj).floatValue(), z);
            return this;
        }
        if (obj instanceof Number) {
            e(fieldDescriptor, ((Number) obj).longValue(), z);
            return this;
        }
        if (obj instanceof Boolean) {
            d(fieldDescriptor, ((Boolean) obj).booleanValue() ? 1 : 0, z);
            return this;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z && bArr.length == 0) {
                return this;
            }
            n((h(fieldDescriptor) << 3) | 2);
            n(bArr.length);
            this.f17622a.write(bArr);
            return this;
        }
        ObjectEncoder objectEncoder = (ObjectEncoder) this.f17623a.get(obj.getClass());
        if (objectEncoder != null) {
            k(objectEncoder, fieldDescriptor, obj, z);
            return this;
        }
        ValueEncoder valueEncoder = (ValueEncoder) this.f17624b.get(obj.getClass());
        if (valueEncoder != null) {
            l(valueEncoder, fieldDescriptor, obj, z);
            return this;
        }
        if (obj instanceof zzag) {
            d(fieldDescriptor, ((zzag) obj).zza(), true);
            return this;
        }
        if (obj instanceof Enum) {
            d(fieldDescriptor, ((Enum) obj).ordinal(), true);
            return this;
        }
        k(this.f17620a, fieldDescriptor, obj, z);
        return this;
    }

    public final k9c d(@NonNull FieldDescriptor fieldDescriptor, int i, boolean z) throws IOException {
        if (z && i == 0) {
            return this;
        }
        zzai zzaiVarJ = j(fieldDescriptor);
        zzah zzahVar = zzah.DEFAULT;
        int iOrdinal = zzaiVarJ.zzb().ordinal();
        if (iOrdinal == 0) {
            n(zzaiVarJ.zza() << 3);
            n(i);
        } else if (iOrdinal == 1) {
            n(zzaiVarJ.zza() << 3);
            n((i + i) ^ (i >> 31));
        } else if (iOrdinal == 2) {
            n((zzaiVarJ.zza() << 3) | 5);
            this.f17622a.write(m(4).putInt(i).array());
        }
        return this;
    }

    public final k9c e(@NonNull FieldDescriptor fieldDescriptor, long j, boolean z) throws IOException {
        if (z && j == 0) {
            return this;
        }
        zzai zzaiVarJ = j(fieldDescriptor);
        zzah zzahVar = zzah.DEFAULT;
        int iOrdinal = zzaiVarJ.zzb().ordinal();
        if (iOrdinal == 0) {
            n(zzaiVarJ.zza() << 3);
            o(j);
        } else if (iOrdinal == 1) {
            n(zzaiVarJ.zza() << 3);
            o((j >> 63) ^ (j + j));
        } else if (iOrdinal == 2) {
            n((zzaiVarJ.zza() << 3) | 1);
            this.f17622a.write(m(8).putLong(j).array());
        }
        return this;
    }

    public final k9c f(@Nullable Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        ObjectEncoder objectEncoder = (ObjectEncoder) this.f17623a.get(obj.getClass());
        if (objectEncoder == null) {
            throw new EncodingException("No encoder for ".concat(String.valueOf(obj.getClass())));
        }
        objectEncoder.encode(obj, this);
        return this;
    }

    public final long i(ObjectEncoder objectEncoder, Object obj) throws IOException {
        p8c p8cVar = new p8c();
        try {
            OutputStream outputStream = this.f17622a;
            this.f17622a = p8cVar;
            try {
                objectEncoder.encode(obj, this);
                this.f17622a = outputStream;
                long jG = p8cVar.g();
                p8cVar.close();
                return jG;
            } catch (Throwable th) {
                this.f17622a = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                p8cVar.close();
            } catch (Throwable th3) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th2, th3);
                } catch (Exception unused) {
                }
            }
            throw th2;
        }
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext inline(@Nullable Object obj) throws IOException {
        f(obj);
        return this;
    }

    public final k9c k(ObjectEncoder objectEncoder, FieldDescriptor fieldDescriptor, Object obj, boolean z) throws IOException {
        long jI = i(objectEncoder, obj);
        if (z && jI == 0) {
            return this;
        }
        n((h(fieldDescriptor) << 3) | 2);
        o(jI);
        objectEncoder.encode(obj, this);
        return this;
    }

    public final k9c l(ValueEncoder valueEncoder, FieldDescriptor fieldDescriptor, Object obj, boolean z) throws IOException {
        this.f17621a.a(fieldDescriptor, z);
        valueEncoder.encode(obj, this.f17621a);
        return this;
    }

    public final void n(int i) throws IOException {
        while ((i & com.alipay.sdk.m.p.a.g) != 0) {
            this.f17622a.write((i & 127) | 128);
            i >>>= 7;
        }
        this.f17622a.write(i & 127);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext nested(@NonNull FieldDescriptor fieldDescriptor) throws IOException {
        throw new EncodingException("nested() is not implemented for protobuf encoding.");
    }

    public final void o(long j) throws IOException {
        while (((-128) & j) != 0) {
            this.f17622a.write((((int) j) & 127) | 128);
            j >>>= 7;
        }
        this.f17622a.write(((int) j) & 127);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, float f) throws IOException {
        b(fieldDescriptor, f, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext nested(@NonNull String str) throws IOException {
        return nested(FieldDescriptor.of(str));
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final /* synthetic */ ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, int i) throws IOException {
        d(fieldDescriptor, i, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final /* synthetic */ ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, long j) throws IOException {
        e(fieldDescriptor, j, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, @Nullable Object obj) throws IOException {
        c(fieldDescriptor, obj, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final /* synthetic */ ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, boolean z) throws IOException {
        d(fieldDescriptor, z ? 1 : 0, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull String str, double d) throws IOException {
        a(FieldDescriptor.of(str), d, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull String str, int i) throws IOException {
        d(FieldDescriptor.of(str), i, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull String str, long j) throws IOException {
        e(FieldDescriptor.of(str), j, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull String str, @Nullable Object obj) throws IOException {
        c(FieldDescriptor.of(str), obj, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull String str, boolean z) throws IOException {
        d(FieldDescriptor.of(str), z ? 1 : 0, true);
        return this;
    }
}
