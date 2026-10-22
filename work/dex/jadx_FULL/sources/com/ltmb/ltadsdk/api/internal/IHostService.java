package com.ltmb.ltadsdk.api.internal;

import android.content.Context;
import android.content.Intent;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.heytap.mcssdk.constant.b;
import com.kuaishou.weapon.p0.t;
import com.ltmb.ltadsdk.api.SYLocation;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H&J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H&J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH&J\b\u0010\u0011\u001a\u00020\u0006H\u0016J6\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u000eH\u0016J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001fH&J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001fH&J\b\u0010#\u001a\u00020\u001aH&J\u0018\u0010'\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u000eH&J\b\u0010(\u001a\u00020\u000eH&J\b\u0010*\u001a\u00020)H&J\u001a\u0010.\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u00062\b\u0010-\u001a\u0004\u0018\u00010,H&J\n\u00100\u001a\u0004\u0018\u00010/H&J\n\u00101\u001a\u0004\u0018\u00010\u0006H&JV\u00109\u001a\u00020\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u00102\u001a\u0004\u0018\u00010\u00062\b\u00103\u001a\u0004\u0018\u00010\u00062\b\u00104\u001a\u0004\u0018\u00010\u00062\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u0001052\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u000107H&JH\u0010=\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010:\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020;2\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u0001052\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u000107H&¨\u0006>"}, d2 = {"Lcom/ltmb/ltadsdk/api/internal/IHostService;", "", "Lorg/json/JSONArray;", "getAppInventory", "Lcom/ltmb/ltadsdk/api/SYLocation;", "getLocation", "", "getUserAgent", "getAndroidId", "getIMEI", "getIPAddress", "getMacAddress", "getOAID", "getWXAppId", "", "isEnablePersonalRecommend", "isEnableShake", "getHostSDKVersion", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "landscape", "", "launcherMode", "translucent", "", "startPluginActivity", "obj", "bizKey", "wrapperContext", "Lcom/ltmb/ltadsdk/api/internal/IAppLifecycle;", RequestParameters.SUBRESOURCE_LIFECYCLE, "addAppLifecycle", "removeAppLifecycle", "requestUpdateAdConfig", "", "throwable", "error", "reportException", "isAppOnForeground", "", "getFirstInitTime", b.k, "Lcom/ltmb/ltadsdk/api/internal/AdEventParamsProxy;", "paramsProxy", "reportEvent", "Lcom/ltmb/ltadsdk/api/internal/IBridge;", "getBridge", "getDeviceId", "requestId", "slotId", "adid", "", "map", "Lcom/ltmb/ltadsdk/api/internal/AdCallback;", RenderCallContext.TYPE_CALLBACK, "showFeedback", t.q, "Lorg/json/JSONObject;", "data", "callStartD", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public interface IHostService {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        @NotNull
        public static String getAndroidId(@NotNull IHostService iHostService) {
            return "";
        }

        @NotNull
        public static String getHostSDKVersion(@NotNull IHostService iHostService) {
            return "";
        }

        @NotNull
        public static String getIMEI(@NotNull IHostService iHostService) {
            return "";
        }

        @NotNull
        public static String getIPAddress(@NotNull IHostService iHostService) {
            return "";
        }

        @NotNull
        public static String getOAID(@NotNull IHostService iHostService) {
            return "";
        }

        public static boolean isEnablePersonalRecommend(@NotNull IHostService iHostService) {
            return true;
        }

        public static void startPluginActivity(@NotNull IHostService iHostService, @NotNull Context context, @NotNull Intent intent, boolean z, int i, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
        }

        public static /* synthetic */ void startPluginActivity$default(IHostService iHostService, Context context, Intent intent, boolean z, int i, boolean z2, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startPluginActivity");
            }
            iHostService.startPluginActivity(context, intent, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? false : z2);
        }

        @Nullable
        public static Context wrapperContext(@NotNull IHostService iHostService, @NotNull Object obj, @NotNull String str) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            Intrinsics.checkNotNullParameter(str, "bizKey");
            return null;
        }
    }

    void addAppLifecycle(@NotNull IAppLifecycle lifecycle);

    boolean callStartD(@Nullable Context context, boolean dp, @NotNull JSONObject data, @Nullable Map<String, Object> map, @Nullable AdCallback<Boolean> callback);

    @NotNull
    String getAndroidId();

    @NotNull
    JSONArray getAppInventory();

    @Nullable
    IBridge getBridge();

    @Nullable
    String getDeviceId();

    long getFirstInitTime();

    @NotNull
    String getHostSDKVersion();

    @NotNull
    String getIMEI();

    @NotNull
    String getIPAddress();

    @Nullable
    SYLocation getLocation();

    @NotNull
    String getMacAddress();

    @NotNull
    String getOAID();

    @NotNull
    String getUserAgent();

    @NotNull
    String getWXAppId();

    boolean isAppOnForeground();

    boolean isEnablePersonalRecommend();

    boolean isEnableShake();

    void removeAppLifecycle(@NotNull IAppLifecycle lifecycle);

    void reportEvent(@NotNull String eventId, @Nullable AdEventParamsProxy paramsProxy);

    void reportException(@NotNull Throwable throwable, boolean error);

    void requestUpdateAdConfig();

    void showFeedback(@Nullable Context context, @Nullable String requestId, @Nullable String slotId, @Nullable String adid, @Nullable Map<String, Object> map, @Nullable AdCallback<Boolean> callback);

    void startPluginActivity(@NotNull Context context, @NotNull Intent intent, boolean landscape, int launcherMode, boolean translucent);

    @Nullable
    Context wrapperContext(@NotNull Object obj, @NotNull String bizKey);
}
