package com.zj.adlib;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.config.EncoderConfig;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class tpc implements EncoderConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f44979a = 0;
    public static final ObjectEncoder b = new ObjectEncoder() { // from class: com.zj.adlib.ppc
        @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
            int i = tpc.f44979a;
            throw new EncodingException("Couldn't find encoder for type ".concat(String.valueOf(obj.getClass().getCanonicalName())));
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map f19877a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Map f19878b = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ObjectEncoder f19876a = b;

    public final xpc a() {
        return new xpc(new HashMap(this.f19877a), new HashMap(this.f19878b), this.f19876a);
    }

    @Override // com.google.firebase.encoders.config.EncoderConfig
    @NonNull
    public final /* bridge */ /* synthetic */ EncoderConfig registerEncoder(@NonNull Class cls, @NonNull ObjectEncoder objectEncoder) {
        this.f19877a.put(cls, objectEncoder);
        this.f19878b.remove(cls);
        return this;
    }

    @Override // com.google.firebase.encoders.config.EncoderConfig
    @NonNull
    public final /* bridge */ /* synthetic */ EncoderConfig registerEncoder(@NonNull Class cls, @NonNull ValueEncoder valueEncoder) {
        this.f19878b.put(cls, valueEncoder);
        this.f19877a.remove(cls);
        return this;
    }
}
