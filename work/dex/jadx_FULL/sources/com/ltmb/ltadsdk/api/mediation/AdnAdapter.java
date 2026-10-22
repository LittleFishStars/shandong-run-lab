package com.ltmb.ltadsdk.api.mediation;

import android.app.Application;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.ltmb.ltadsdk.api.SYAdInitConfig;
import com.ltmb.ltadsdk.api.SYAdSdkInitCallback;
import com.ltmb.ltadsdk.api.internal.AdCodeConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\rH&J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u000fH&¨\u0006\u0013"}, d2 = {"Lcom/ltmb/ltadsdk/api/mediation/AdnAdapter;", "", "Landroid/app/Application;", NativeCallContext.DOMAIN_APP, "Lcom/ltmb/ltadsdk/api/SYAdInitConfig;", "config", "Lcom/ltmb/ltadsdk/api/SYAdSdkInitCallback;", RenderCallContext.TYPE_CALLBACK, "", "init", "unInit", "", "getAdnType", "", "getSdkVersion", "Lcom/ltmb/ltadsdk/api/internal/AdCodeConfig;", "adConfig", "Lcom/ltmb/ltadsdk/api/mediation/AdnBaseAdLoader;", "generateAdLoader", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public interface AdnAdapter {
    @Nullable
    AdnBaseAdLoader generateAdLoader(@NotNull AdCodeConfig adConfig);

    int getAdnType();

    @NotNull
    String getSdkVersion();

    void init(@Nullable Application app, @NotNull SYAdInitConfig config, @Nullable SYAdSdkInitCallback callback);

    void unInit(@Nullable Application app);
}
