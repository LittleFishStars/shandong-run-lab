package com.ltmb.ltadsdk.api.internal;

import com.ltmb.ltadsdk.api.SYAdLoadParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/ltmb/ltadsdk/api/internal/AdLoadParamsExt;", "", "Lcom/ltmb/ltadsdk/api/SYAdLoadParams;", "a", "Lcom/ltmb/ltadsdk/api/SYAdLoadParams;", "getParams", "()Lcom/ltmb/ltadsdk/api/SYAdLoadParams;", "setParams", "(Lcom/ltmb/ltadsdk/api/SYAdLoadParams;)V", "params", "Lcom/ltmb/ltadsdk/api/internal/AdCodeConfig;", "b", "Lcom/ltmb/ltadsdk/api/internal/AdCodeConfig;", "getAdConfig", "()Lcom/ltmb/ltadsdk/api/internal/AdCodeConfig;", "setAdConfig", "(Lcom/ltmb/ltadsdk/api/internal/AdCodeConfig;)V", "adConfig", "", "c", "Ljava/lang/String;", "getRequestId", "()Ljava/lang/String;", "setRequestId", "(Ljava/lang/String;)V", "requestId", "<init>", "()V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public final class AdLoadParamsExt {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public SYAdLoadParams params;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public AdCodeConfig adConfig;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public String requestId = "";

    @NotNull
    public final AdCodeConfig getAdConfig() {
        AdCodeConfig adCodeConfig = this.adConfig;
        if (adCodeConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adConfig");
        }
        return adCodeConfig;
    }

    @NotNull
    public final SYAdLoadParams getParams() {
        SYAdLoadParams sYAdLoadParams = this.params;
        if (sYAdLoadParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
        }
        return sYAdLoadParams;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    public final void setAdConfig(@NotNull AdCodeConfig adCodeConfig) {
        Intrinsics.checkNotNullParameter(adCodeConfig, "<set-?>");
        this.adConfig = adCodeConfig;
    }

    public final void setParams(@NotNull SYAdLoadParams sYAdLoadParams) {
        Intrinsics.checkNotNullParameter(sYAdLoadParams, "<set-?>");
        this.params = sYAdLoadParams;
    }

    public final void setRequestId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.requestId = str;
    }
}
