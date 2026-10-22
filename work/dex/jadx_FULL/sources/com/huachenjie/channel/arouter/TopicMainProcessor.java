package com.huachenjie.channel.arouter;

import android.os.Bundle;
import com.alibaba.android.arouter.facade.Postcard;
import com.huachenjie.common.reconfig.coroutine.CoroutineExtKt;
import com.zj.adlib.yj7;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/channel/arouter/TopicMainProcessor;", "", "Lcom/alibaba/android/arouter/facade/Postcard;", "postcard", "", "a", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class TopicMainProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TopicMainProcessor f33016a = new TopicMainProcessor();

    public final void a(@Nullable Postcard postcard) {
        Bundle extras;
        String string;
        if (postcard == null || (extras = postcard.getExtras()) == null || (string = extras.getString(yj7.b.SUBJECT_NO)) == null) {
            return;
        }
        CoroutineExtKt.c(CoroutineExtKt.a(this), false, null, null, new TopicMainProcessor$process$1(string, null), 7, null);
    }
}
