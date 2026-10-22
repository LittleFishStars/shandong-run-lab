package com.zj.adlib;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.huachenjie.base.broadcast.post.PostOperateReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0013\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/zj/adlib/tv6;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/base/broadcast/post/PostOperateReceiver;", "receiver", "", "registerReceiver", "unregisterReceiver", "c", "", "postNo", "", "isChecked", "", "likeCount", "a", "b", "Ljava/lang/String;", "RECEIVER_POST", "POST_OPERATE_TYPE", "POST_NO", "d", "POST_LIKE_COUNT", "e", "POST_CHECKED", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class tv6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final tv6 f45013a = new tv6();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String RECEIVER_POST = "com.huachenjie.shandong_school.receiver.post.postOperate";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final String POST_OPERATE_TYPE = "postOperateType";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public static final String POST_NO = "postNo";

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public static final String POST_LIKE_COUNT = "postLikeCount";

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public static final String POST_CHECKED = "postChecked";

    public final void a(@NotNull Context context, @NotNull String postNo, boolean isChecked, int likeCount) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(postNo, "postNo");
        Intent intent = new Intent(RECEIVER_POST);
        intent.putExtra(POST_OPERATE_TYPE, 2);
        intent.putExtra("postNo", postNo);
        intent.putExtra(POST_LIKE_COUNT, likeCount);
        intent.putExtra(POST_CHECKED, isChecked);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(RECEIVER_POST);
        intent.putExtra(POST_OPERATE_TYPE, 3);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void c(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(RECEIVER_POST);
        intent.putExtra(POST_OPERATE_TYPE, 1);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void registerReceiver(@NotNull Context context, @NotNull PostOperateReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context).registerReceiver(receiver, new IntentFilter(RECEIVER_POST));
    }

    public final void unregisterReceiver(@NotNull Context context, @NotNull PostOperateReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context).unregisterReceiver(receiver);
    }
}
