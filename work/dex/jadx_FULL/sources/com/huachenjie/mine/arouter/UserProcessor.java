package com.huachenjie.mine.arouter;

import android.os.Bundle;
import com.alibaba.android.arouter.facade.Postcard;
import com.huachenjie.common.reconfig.coroutine.CoroutineExtKt;
import com.zj.adlib.yj7;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/mine/arouter/UserProcessor;", "", "Lcom/alibaba/android/arouter/facade/Postcard;", "postcard", "", "b", "a", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
public final class UserProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final UserProcessor f35287a = new UserProcessor();

    public final void a(@Nullable Postcard postcard) {
        Bundle extras;
        if ((postcard == null || (extras = postcard.getExtras()) == null) ? false : extras.getBoolean(yj7.f.DRESS_TABLE_NEED_INFO)) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            CoroutineExtKt.c(CoroutineExtKt.a(this), false, null, new UserProcessor$processDressTable$1(objectRef, null), new UserProcessor$processDressTable$2(objectRef, null), 3, null);
        }
    }

    public final void b(@Nullable Postcard postcard) {
        Bundle extras;
        String string;
        if (postcard == null || (extras = postcard.getExtras()) == null || (string = extras.getString("appUserCode")) == null) {
            return;
        }
        CoroutineExtKt.c(CoroutineExtKt.a(this), false, null, null, new UserProcessor$processUser$1(string, postcard, null), 7, null);
    }
}
