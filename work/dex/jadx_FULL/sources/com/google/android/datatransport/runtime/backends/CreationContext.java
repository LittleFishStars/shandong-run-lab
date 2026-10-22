package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.auto.value.AutoValue;
import com.zj.adlib.li0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@AutoValue
public abstract class CreationContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30424a = "cct";

    public static CreationContext a(Context context, Clock clock, Clock clock2) {
        return new li0(context, clock, clock2, "cct");
    }

    public static CreationContext b(Context context, Clock clock, Clock clock2, String str) {
        return new li0(context, clock, clock2, str);
    }

    public abstract Context c();

    @NonNull
    public abstract String d();

    public abstract Clock e();

    public abstract Clock f();
}
