package com.ltmb.ltadsdk.api.mediation;

import android.content.Context;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.ltmb.ltadsdk.api.SYAdLoadParams;
import com.ltmb.ltadsdk.api.internal.AdCodeConfig;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/ltmb/ltadsdk/api/mediation/AdnBaseAdLoader;", "", "", "requestId", "", "setRequestId", "Landroid/content/Context;", "context", "setContext", "Lcom/ltmb/ltadsdk/api/SYAdLoadParams;", "loadParams", "Lcom/ltmb/ltadsdk/api/mediation/AdnAdLoaderCallback;", RenderCallContext.TYPE_CALLBACK, "loadAd", "getContext", "Lcom/ltmb/ltadsdk/api/internal/AdCodeConfig;", "c", "Lcom/ltmb/ltadsdk/api/internal/AdCodeConfig;", "getAdCodeConfig", "()Lcom/ltmb/ltadsdk/api/internal/AdCodeConfig;", "setAdCodeConfig", "(Lcom/ltmb/ltadsdk/api/internal/AdCodeConfig;)V", "adCodeConfig", "<init>", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public abstract class AdnBaseAdLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public String f40339a;
    public WeakReference<Context> b;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public AdCodeConfig adCodeConfig;

    public AdnBaseAdLoader(@NotNull AdCodeConfig adCodeConfig) {
        Intrinsics.checkNotNullParameter(adCodeConfig, "adCodeConfig");
        this.adCodeConfig = adCodeConfig;
        this.f40339a = "";
    }

    @NotNull
    public final AdCodeConfig getAdCodeConfig() {
        return this.adCodeConfig;
    }

    @Nullable
    public final Context getContext() {
        WeakReference<Context> weakReference = this.b;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public abstract void loadAd(@NotNull SYAdLoadParams loadParams, @NotNull AdnAdLoaderCallback callback);

    public final void setAdCodeConfig(@NotNull AdCodeConfig adCodeConfig) {
        Intrinsics.checkNotNullParameter(adCodeConfig, "<set-?>");
        this.adCodeConfig = adCodeConfig;
    }

    public final void setContext(@Nullable Context context) {
        if (context != null) {
            this.b = new WeakReference<>(context);
        }
    }

    public final void setRequestId(@NotNull String requestId) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        this.f40339a = requestId;
    }
}
