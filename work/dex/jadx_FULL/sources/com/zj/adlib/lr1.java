package com.zj.adlib;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\n\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\tR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/zj/adlib/lr1;", "", "Landroid/content/BroadcastReceiver;", "receiver", "Landroid/content/IntentFilter;", "filter", "", "a", "", "Ljava/lang/String;", "TAG", "", "[Ljava/lang/String;", "invalidBroadCast", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class lr1 {

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String TAG = "ComplianceUtil";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final lr1 f43134a = new lr1();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String[] invalidBroadCast = {"android.intent.action.PACKAGE_ADDED", "android.intent.action.PACKAGE_REMOVED"};

    public final boolean a(@Nullable BroadcastReceiver receiver, @Nullable IntentFilter filter) {
        int iCountActions;
        if (filter != null) {
            try {
                iCountActions = filter.countActions();
            } catch (Exception e) {
                i4a.g(TAG, "checkBroadCastValid error: " + e.getMessage());
                return true;
            }
        } else {
            iCountActions = 0;
        }
        for (int i = 0; i < iCountActions; i++) {
            if (ArraysKt.contains(invalidBroadCast, filter != null ? filter.getAction(i) : null)) {
                StringBuilder sb = new StringBuilder();
                sb.append("非法广播 ");
                sb.append(filter != null ? filter.getAction(i) : null);
                i4a.g(TAG, sb.toString());
                return false;
            }
        }
        return true;
    }
}
