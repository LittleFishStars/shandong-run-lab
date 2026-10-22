package com.zj.adlib;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.huachenjie.base.broadcast.find_alumni.FindAlumniReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u0011\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0013\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/zj/adlib/yg3;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/base/broadcast/find_alumni/FindAlumniReceiver;", "receiver", "", "registerReceiver", "unregisterReceiver", "", "sourceType", "a", "Ljava/lang/String;", "RECEIVER_FIND_ALUMNI", "b", "SOURCE_TYPE", "c", "SOURCE_TYPE_SETTINGS", "d", "SOURCE_TYPE_MY_PAGE", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class yg3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final yg3 f46026a = new yg3();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String RECEIVER_FIND_ALUMNI = "com.huachenjie.shandong_school.receiver.find_alumni.interest_tags_set";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final String SOURCE_TYPE = "sourceType";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public static final String SOURCE_TYPE_SETTINGS = "settings";

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public static final String SOURCE_TYPE_MY_PAGE = "my_page";

    public final void a(@NotNull Context context, @NotNull String sourceType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sourceType, "sourceType");
        Intent intent = new Intent(RECEIVER_FIND_ALUMNI);
        intent.putExtra("sourceType", sourceType);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void registerReceiver(@NotNull Context context, @NotNull FindAlumniReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context).registerReceiver(receiver, new IntentFilter(RECEIVER_FIND_ALUMNI));
    }

    public final void unregisterReceiver(@NotNull Context context, @NotNull FindAlumniReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context).unregisterReceiver(receiver);
    }
}
