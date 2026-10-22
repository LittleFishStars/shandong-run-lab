package com.ltmb.ltadsdk.api.internal;

import android.app.Activity;
import android.content.Context;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.kuaishou.weapon.p0.t;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J.\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\bH&JD\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\bH&J6\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bH&J6\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bH&¨\u0006\u0010"}, d2 = {"Lcom/ltmb/ltadsdk/api/internal/IRemoteOpen;", "", "Landroid/content/Context;", "context", "", AliyunLogCommon.LogLevel.INFO, "", t.q, "Lcom/ltmb/ltadsdk/api/internal/AdCallback;", RenderCallContext.TYPE_CALLBACK, "open", "", "map", "Landroid/app/Activity;", "openOnly", "Lorg/json/JSONObject;", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public interface IRemoteOpen {
    boolean open(@NotNull Context context, @NotNull String info, boolean dp, @NotNull AdCallback<Boolean> callback);

    boolean open(@NotNull Context context, @NotNull String info, boolean dp, @Nullable Map<String, Object> map, @NotNull AdCallback<Boolean> callback);

    boolean openOnly(@NotNull Activity context, @NotNull String info, boolean dp, @Nullable Map<String, Object> map);

    boolean openOnly(@NotNull Activity context, @NotNull JSONObject info, boolean dp, @Nullable Map<String, Object> map);
}
