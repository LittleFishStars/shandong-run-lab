package com.ltmb.ltadsdk.mediation.adx.adapter;

import android.app.Application;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.ltmb.ltadsdk.api.SYAdInitConfig;
import com.ltmb.ltadsdk.api.SYAdSdkInitCallback;
import com.ltmb.ltadsdk.api.internal.AdCodeConfig;
import com.ltmb.ltadsdk.api.mediation.AdnAdapter;
import com.ltmb.ltadsdk.api.mediation.AdnBaseAdLoader;
import com.ltmb.ltadsdk.pkg.cb;
import com.ltmb.ltadsdk.pkg.cc;
import com.ltmb.ltadsdk.pkg.d9;
import com.ltmb.ltadsdk.pkg.dc;
import com.ltmb.ltadsdk.pkg.e2;
import com.ltmb.ltadsdk.pkg.eb;
import com.ltmb.ltadsdk.pkg.ec;
import com.ltmb.ltadsdk.pkg.fb;
import com.ltmb.ltadsdk.pkg.fc;
import com.ltmb.ltadsdk.pkg.gc;
import com.ltmb.ltadsdk.pkg.hc;
import com.ltmb.ltadsdk.pkg.lc;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¨\u0006\u0015"}, d2 = {"Lcom/ltmb/ltadsdk/mediation/adx/adapter/SYMediationAdxAdapter;", "Lcom/ltmb/ltadsdk/api/mediation/AdnAdapter;", "Landroid/app/Application;", NativeCallContext.DOMAIN_APP, "Lcom/ltmb/ltadsdk/api/SYAdInitConfig;", "config", "Lcom/ltmb/ltadsdk/api/SYAdSdkInitCallback;", RenderCallContext.TYPE_CALLBACK, "", "init", "unInit", "", "getAdnType", "", "getSdkVersion", "Lcom/ltmb/ltadsdk/api/internal/AdCodeConfig;", "adConfig", "Lcom/ltmb/ltadsdk/api/mediation/AdnBaseAdLoader;", "generateAdLoader", "<init>", "()V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public final class SYMediationAdxAdapter implements AdnAdapter {
    @Override // com.ltmb.ltadsdk.api.mediation.AdnAdapter
    @Nullable
    public AdnBaseAdLoader generateAdLoader(@NotNull AdCodeConfig adConfig) {
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        if (adConfig.getAdType() == 2) {
            return new hc(adConfig);
        }
        if (adConfig.getAdType() == 4) {
            return new ec(adConfig);
        }
        if (adConfig.getAdType() == 5) {
            return new gc(adConfig);
        }
        if (adConfig.getAdType() == 1) {
            return new dc(adConfig);
        }
        if (adConfig.getAdType() == 3) {
            return new cc(adConfig);
        }
        if (adConfig.getAdType() == 6) {
            return new fc(adConfig);
        }
        return null;
    }

    @Override // com.ltmb.ltadsdk.api.mediation.AdnAdapter
    public int getAdnType() {
        return 0;
    }

    @Override // com.ltmb.ltadsdk.api.mediation.AdnAdapter
    @NotNull
    public String getSdkVersion() {
        Intrinsics.checkNotNullExpressionValue("2.4.7.3", "SYAdx.getSDKVersion()");
        return "2.4.7.3";
    }

    @Override // com.ltmb.ltadsdk.api.mediation.AdnAdapter
    public void init(@Nullable Application app, @NotNull SYAdInitConfig config, @Nullable SYAdSdkInitCallback callback) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (fb.b) {
            return;
        }
        d9 d9Var = d9.d;
        if (d9.a) {
            d9Var.a("syadx begin init");
        }
        if (app == null) {
            throw new IllegalArgumentException("Context is null, please check.");
        }
        if (config == null) {
            throw new IllegalArgumentException("SYAdInitConfig is null, please check.");
        }
        try {
            try {
                e2.d.a("yltmbadv2", new cb(app, config));
                fb.a = config;
                lc.i.d(new eb(app, config));
            } catch (Exception e) {
                d9.d.a(e);
            }
        } finally {
            fb.b = true;
        }
    }

    @Override // com.ltmb.ltadsdk.api.mediation.AdnAdapter
    public void unInit(@Nullable Application app) {
    }
}
