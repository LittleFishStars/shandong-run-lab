package com.zj.adlib;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.huachenjie.base.broadcast.works.WorkOperateReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b$\u0010%J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ&\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000fJ'\u0010\u0017\u001a\u00020\u0006\"\b\b\u0000\u0010\u0015*\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000fR\u0014\u0010\u001c\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u001bR\u0014\u0010 \u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010!\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u001bR\u0014\u0010\"\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u001bR\u0014\u0010#\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u001b¨\u0006&"}, d2 = {"Lcom/zj/adlib/oz9;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/base/broadcast/works/WorkOperateReceiver;", "receiver", "", "a", y6b.g, y6b.f, "f", "", "workNo", "", "isChecked", "", "likeCount", "c", "collectedCount", "b", "Landroid/os/Parcelable;", "T", "worksDetail", "d", "(Landroid/content/Context;Landroid/os/Parcelable;)V", "visible", "e", "Ljava/lang/String;", "RECEIVER_WORK", "WORK_OPERATE_TYPE", "WORK_NO", "WORK_LIKE_COUNT", "WORK_COLLECTED_COUNT", "WORK_CHECKED", "WORK_PUBLISHED_WORKS_DETAIL", "WORK_VISIBLE", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class oz9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final oz9 f43864a = new oz9();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String RECEIVER_WORK = "com.huachenjie.shandong_school.receiver.works.worksOperate";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final String WORK_OPERATE_TYPE = "worksOperateType";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public static final String WORK_NO = "workNo";

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public static final String WORK_LIKE_COUNT = "workLikeCount";

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public static final String WORK_COLLECTED_COUNT = "workCollectedCount";

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public static final String WORK_CHECKED = "workChecked";

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public static final String WORK_PUBLISHED_WORKS_DETAIL = "publishedWorksDetail";

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public static final String WORK_VISIBLE = "workVisible";

    public final void a(@NotNull Context context, @NotNull WorkOperateReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context).registerReceiver(receiver, new IntentFilter(RECEIVER_WORK));
    }

    public final void b(@NotNull Context context, @NotNull String workNo, boolean isChecked, int collectedCount) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workNo, "workNo");
        Intent intent = new Intent(RECEIVER_WORK);
        intent.putExtra(WORK_OPERATE_TYPE, 3);
        intent.putExtra("workNo", workNo);
        intent.putExtra(WORK_COLLECTED_COUNT, collectedCount);
        intent.putExtra(WORK_CHECKED, isChecked);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void c(@NotNull Context context, @NotNull String workNo, boolean isChecked, int likeCount) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workNo, "workNo");
        Intent intent = new Intent(RECEIVER_WORK);
        intent.putExtra(WORK_OPERATE_TYPE, 2);
        intent.putExtra("workNo", workNo);
        intent.putExtra(WORK_LIKE_COUNT, likeCount);
        intent.putExtra(WORK_CHECKED, isChecked);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final <T extends Parcelable> void d(@NotNull Context context, @NotNull T worksDetail) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(worksDetail, "worksDetail");
        Intent intent = new Intent(RECEIVER_WORK);
        intent.putExtra(WORK_OPERATE_TYPE, 4);
        Bundle bundle = new Bundle();
        bundle.putParcelable(WORK_PUBLISHED_WORKS_DETAIL, worksDetail);
        intent.putExtras(bundle);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void e(@NotNull Context context, @NotNull String workNo, int visible) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workNo, "workNo");
        Intent intent = new Intent(RECEIVER_WORK);
        intent.putExtra(WORK_OPERATE_TYPE, 6);
        intent.putExtra("workNo", workNo);
        intent.putExtra(WORK_VISIBLE, visible);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void f(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(RECEIVER_WORK);
        intent.putExtra(WORK_OPERATE_TYPE, 5);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void g(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(RECEIVER_WORK);
        intent.putExtra(WORK_OPERATE_TYPE, 1);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void h(@NotNull Context context, @NotNull WorkOperateReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context).unregisterReceiver(receiver);
    }
}
