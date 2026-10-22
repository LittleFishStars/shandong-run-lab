package androidx.p002lifecycle;

import androidx.annotation.RequiresApi;
import com.alipay.sdk.m.o.b;
import java.time.Duration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(26)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Landroidx/lifecycle/Api26Impl;", "", "()V", "toMillis", "", b.r0, "Ljava/time/Duration;", "lifecycle-livedata-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Api26Impl {

    @NotNull
    public static final Api26Impl INSTANCE = new Api26Impl();

    private Api26Impl() {
    }

    public final long toMillis(@NotNull Duration timeout) {
        Intrinsics.checkNotNullParameter(timeout, b.r0);
        return timeout.toMillis();
    }
}
