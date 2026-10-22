package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.zj.adlib.ki0;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@AutoValue
@Encodable
public abstract class BatchedLogRequest {
    @NonNull
    public static BatchedLogRequest a(@NonNull List<LogRequest> list) {
        return new ki0(list);
    }

    @NonNull
    public static DataEncoder b() {
        return new JsonDataEncoderBuilder().configureWith(a.f1885a).ignoreNullValues(true).build();
    }

    @NonNull
    @Encodable.Field(name = "logRequest")
    public abstract List<LogRequest> c();
}
