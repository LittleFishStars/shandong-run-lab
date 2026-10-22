package com.zj.adlib;

import android.content.Context;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.huachenjie.common.bean.CommonUserInfo;
import com.umeng.analytics.MobclickAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ0\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0007J\u001a\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u001c\u0010\r\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000bH\u0002¨\u0006\u0010"}, d2 = {"Lcom/zj/adlib/kq5;", "", "Landroid/content/Context;", "context", "", IpcMessageConstants.EXTRA_EVENT, "", "args", "", "b", "c", "", "argTemp", "a", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class kq5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final kq5 f42887a = new kq5();

    /* JADX WARN: Code duplicated, block: B:6:0x000d A[Catch: Exception -> 0x001a, TryCatch #0 {Exception -> 0x001a, blocks: (B:4:0x0007, B:7:0x0012, B:6:0x000d), top: B:10:0x0007 }] */
    @JvmStatic
    public static final void b(@Nullable Context context, @NotNull String eventName, @Nullable Map<String, String> args) {
        Map<String, String> mutableMap;
        Intrinsics.checkNotNullParameter(eventName, IpcMessageConstants.EXTRA_EVENT);
        if (args != null) {
            try {
                mutableMap = MapsKt.toMutableMap(args);
                if (mutableMap == null) {
                    mutableMap = new LinkedHashMap<>();
                }
            } catch (Exception unused) {
                return;
            }
        } else {
            mutableMap = new LinkedHashMap<>();
        }
        f42887a.a(mutableMap);
        MobclickAgent.onEvent(context, eventName, mutableMap);
    }

    @JvmStatic
    public static final void c(@Nullable Context context, @NotNull String eventName) {
        Intrinsics.checkNotNullParameter(eventName, IpcMessageConstants.EXTRA_EVENT);
        b(context, eventName, null);
    }

    public final void a(Map<String, String> argTemp) {
        CommonUserInfo commonUserInfoE = ai9.e();
        String userId = commonUserInfoE != null ? commonUserInfoE.getUserId() : null;
        argTemp.put("t", String.valueOf(System.currentTimeMillis()));
        if (userId == null || userId.length() == 0) {
            return;
        }
        argTemp.put("userId", userId);
    }
}
