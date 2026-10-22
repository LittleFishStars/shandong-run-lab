package com.huachenjie.works.arouter;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.common.reconfig.coroutine.CoroutineExtKt;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/works/arouter/WorksDetailProcessor;", "", "Lcom/alibaba/android/arouter/facade/Postcard;", "postcard", "", "a", "c", "b", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class WorksDetailProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WorksDetailProcessor f36763a = new WorksDetailProcessor();

    public final void a(@Nullable Postcard postcard) {
        Bundle extras;
        String string;
        if (postcard == null || (extras = postcard.getExtras()) == null || (string = extras.getString(yj7.g.WORKS_NO)) == null) {
            return;
        }
        Bundle extras2 = postcard.getExtras();
        boolean z = extras2 != null ? extras2.getBoolean("fromMine", false) : false;
        Bundle extras3 = postcard.getExtras();
        boolean z2 = extras3 != null ? extras3.getBoolean(yj7.g.WORKS_LOAD_MORE, false) : false;
        Bundle extras4 = postcard.getExtras();
        CoroutineExtKt.c(CoroutineExtKt.a(this), false, null, null, new WorksDetailProcessor$process$1(string, z, z2, extras4 != null ? extras4.getInt(yj7.g.WORKS_TYPE, 0) : 0, null), 7, null);
    }

    public final void b(@Nullable Postcard postcard) {
        Bundle extras;
        String string;
        if (postcard == null || (extras = postcard.getExtras()) == null || (string = extras.getString("postNo")) == null) {
            return;
        }
        Bundle extras2 = postcard.getExtras();
        CoroutineExtKt.c(CoroutineExtKt.a(this), false, null, null, new WorksDetailProcessor$processPost$1(string, extras2 != null ? extras2.getBoolean("fromMine", false) : false, null), 7, null);
    }

    public final void c(@Nullable Postcard postcard) {
        String string;
        Bundle extras;
        if (postcard == null || (extras = postcard.getExtras()) == null || (string = extras.getString(yj7.g.BROADCAST_QUOTE_NO)) == null) {
            string = "";
        }
        if (TextUtils.isEmpty(string)) {
            ARouter.getInstance().build(zj7.i.BROADCAST_FLOOR).greenChannel().navigation();
        } else {
            CoroutineExtKt.c(CoroutineExtKt.a(this), false, null, null, new WorksDetailProcessor$processQuote$1(string, null), 7, null);
        }
    }
}
