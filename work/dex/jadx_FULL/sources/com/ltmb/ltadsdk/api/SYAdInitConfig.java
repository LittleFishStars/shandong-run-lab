package com.ltmb.ltadsdk.api;

import com.ali.auth.third.login.LoginConstants;
import com.alibaba.alibclinkpartner.smartlink.constants.ALPUserTrackConstant;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.heytap.mcssdk.constant.b;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.y6b;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u000245B\u0011\b\u0002\u0012\u0006\u00101\u001a\u000200¢\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0017\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001a\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u001eR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0005\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010+R\u0019\u0010/\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u0014\u001a\u0004\b.\u0010\u0016¨\u00066"}, d2 = {"Lcom/ltmb/ltadsdk/api/SYAdInitConfig;", "", "", "toString", "a", "Ljava/lang/String;", "getAppId", "()Ljava/lang/String;", "appId", "b", "getAppSecret", b.A, "Lcom/ltmb/ltadsdk/api/SYCustomController;", "c", "Lcom/ltmb/ltadsdk/api/SYCustomController;", "getController", "()Lcom/ltmb/ltadsdk/api/SYCustomController;", "controller", "", "d", "Z", "getDebug", "()Z", AliyunLogCommon.LogLevel.DEBUG, "e", "getAllowShowNotification", "allowShowNotification", "f", "getSupportMultiProcess", "setSupportMultiProcess", "(Z)V", "supportMultiProcess", "Lcom/ltmb/ltadsdk/api/SYAdInitConfig$Ext;", y6b.f, "Lcom/ltmb/ltadsdk/api/SYAdInitConfig$Ext;", "getExt", "()Lcom/ltmb/ltadsdk/api/SYAdInitConfig$Ext;", "setExt", "(Lcom/ltmb/ltadsdk/api/SYAdInitConfig$Ext;)V", LoginConstants.EXT, y6b.g, "getWxAppId", "setWxAppId", "(Ljava/lang/String;)V", "wxAppId", "i", "getNpCheck", "npCheck", "Lcom/ltmb/ltadsdk/api/SYAdInitConfig$Builder;", "builder", "<init>", "(Lcom/ltmb/ltadsdk/api/SYAdInitConfig$Builder;)V", "Builder", "Ext", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public final class SYAdInitConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final String appId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final String appSecret;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @Nullable
    public final SYCustomController controller;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final boolean debug;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final boolean allowShowNotification;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public boolean supportMultiProcess;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public Ext ext;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public String wxAppId;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final boolean npCheck;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b7\u00108J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\nJ\u0006\u0010\u0018\u001a\u00020\u0017R$\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR$\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R$\u0010\r\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b(\u0010%\u001a\u0004\b)\u0010'R(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R$\u00100\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b.\u0010%\u001a\u0004\b/\u0010'R$\u00103\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b1\u0010\u001b\u001a\u0004\b2\u0010\u001dR$\u00106\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b4\u0010%\u001a\u0004\b5\u0010'¨\u00069"}, d2 = {"Lcom/ltmb/ltadsdk/api/SYAdInitConfig$Builder;", "", "", "appId", "setAppId", b.A, "setAppSecret", "Lcom/ltmb/ltadsdk/api/SYCustomController;", "controller", "setCustomController", "", AliyunLogCommon.LogLevel.DEBUG, "setDebug", "allowShowNotification", "setAllowShowNotification", "Lcom/ltmb/ltadsdk/api/SYAdInitConfig$Ext;", LoginConstants.EXT, "setExt", "support", "setSupportMultiProcess", "setWxAppId", "check", "setNPCheck", "Lcom/ltmb/ltadsdk/api/SYAdInitConfig;", ALPUserTrackConstant.METHOD_BUILD, "<set-?>", "a", "Ljava/lang/String;", "getAppId", "()Ljava/lang/String;", "b", "getAppSecret", "c", "Lcom/ltmb/ltadsdk/api/SYCustomController;", "getController", "()Lcom/ltmb/ltadsdk/api/SYCustomController;", "d", "Z", "getDebug", "()Z", "e", "getAllowShowNotification", "f", "Lcom/ltmb/ltadsdk/api/SYAdInitConfig$Ext;", "getExt", "()Lcom/ltmb/ltadsdk/api/SYAdInitConfig$Ext;", y6b.f, "getSupportMultiProcess", "supportMultiProcess", y6b.g, "getWxAppId", "wxAppId", "i", "getNpCheck", "npCheck", "<init>", "()V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        @Nullable
        public SYCustomController controller;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        public boolean debug;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        @Nullable
        public Ext ext;

        /* JADX INFO: renamed from: g, reason: from kotlin metadata */
        public boolean supportMultiProcess;

        /* JADX INFO: renamed from: i, reason: from kotlin metadata */
        public boolean npCheck;

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public String appId = "";

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        @NotNull
        public String appSecret = "";

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        public boolean allowShowNotification = true;

        /* JADX INFO: renamed from: h, reason: from kotlin metadata */
        @NotNull
        public String wxAppId = "";

        @NotNull
        public final SYAdInitConfig build() {
            return new SYAdInitConfig(this, null);
        }

        public final boolean getAllowShowNotification() {
            return this.allowShowNotification;
        }

        @NotNull
        public final String getAppId() {
            return this.appId;
        }

        @NotNull
        public final String getAppSecret() {
            return this.appSecret;
        }

        @Nullable
        public final SYCustomController getController() {
            return this.controller;
        }

        public final boolean getDebug() {
            return this.debug;
        }

        @Nullable
        public final Ext getExt() {
            return this.ext;
        }

        public final boolean getNpCheck() {
            return this.npCheck;
        }

        public final boolean getSupportMultiProcess() {
            return this.supportMultiProcess;
        }

        @NotNull
        public final String getWxAppId() {
            return this.wxAppId;
        }

        @NotNull
        public final Builder setAllowShowNotification(boolean allowShowNotification) {
            this.allowShowNotification = allowShowNotification;
            return this;
        }

        @NotNull
        public final Builder setAppId(@NotNull String appId) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            this.appId = appId;
            return this;
        }

        @NotNull
        public final Builder setAppSecret(@NotNull String appSecret) {
            Intrinsics.checkNotNullParameter(appSecret, b.A);
            this.appSecret = appSecret;
            return this;
        }

        @NotNull
        public final Builder setCustomController(@NotNull SYCustomController controller) {
            Intrinsics.checkNotNullParameter(controller, "controller");
            this.controller = controller;
            return this;
        }

        @NotNull
        public final Builder setDebug(boolean debug) {
            this.debug = debug;
            return this;
        }

        @NotNull
        public final Builder setExt(@NotNull Ext ext) {
            Intrinsics.checkNotNullParameter(ext, LoginConstants.EXT);
            this.ext = ext;
            return this;
        }

        @NotNull
        public final Builder setNPCheck(boolean check) {
            this.npCheck = check;
            return this;
        }

        @NotNull
        public final Builder setSupportMultiProcess(boolean support) {
            this.supportMultiProcess = support;
            return this;
        }

        @NotNull
        public final Builder setWxAppId(@NotNull String appId) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            this.wxAppId = appId;
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J\t\u0010\t\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001J\t\u0010\r\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000e\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/ltmb/ltadsdk/api/SYAdInitConfig$Ext;", "", "", CachedContentIndex.a.e, "value", "addExtValue", "getExtValue", "", "component1", "component2", "ageGroup", "gender", OperatePopupWindow.g, "toString", "hashCode", "other", "", "equals", "b", "I", "getAgeGroup", "()I", "setAgeGroup", "(I)V", "c", "getGender", "setGender", "<init>", "(II)V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
    public static final /* data */ class Ext {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HashMap<String, Object> f40326a;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        public int ageGroup;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
        public int gender;

        /* JADX WARN: Illegal instructions before constructor call */
        public Ext() {
            int i = 0;
            this(i, i, 3, null);
        }

        public Ext(int i, int i2) {
            this.ageGroup = i;
            this.gender = i2;
        }

        public static /* synthetic */ Ext copy$default(Ext ext, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = ext.ageGroup;
            }
            if ((i3 & 2) != 0) {
                i2 = ext.gender;
            }
            return ext.copy(i, i2);
        }

        @NotNull
        public final Ext addExtValue(@NotNull String key, @Nullable Object value) {
            Intrinsics.checkNotNullParameter(key, CachedContentIndex.a.e);
            if (value != null) {
                try {
                    if (this.f40326a == null) {
                        this.f40326a = new HashMap<>();
                    }
                    HashMap<String, Object> map = this.f40326a;
                    if (map != null) {
                        map.put(key, value);
                    }
                } catch (Throwable unused) {
                }
            }
            return this;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getAgeGroup() {
            return this.ageGroup;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getGender() {
            return this.gender;
        }

        @NotNull
        public final Ext copy(int ageGroup, int gender) {
            return new Ext(ageGroup, gender);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Ext)) {
                return false;
            }
            Ext ext = (Ext) other;
            return this.ageGroup == ext.ageGroup && this.gender == ext.gender;
        }

        public final int getAgeGroup() {
            return this.ageGroup;
        }

        @Nullable
        public final Object getExtValue(@NotNull String key) {
            Intrinsics.checkNotNullParameter(key, CachedContentIndex.a.e);
            try {
                HashMap<String, Object> map = this.f40326a;
                if (map != null) {
                    return map.get(key);
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        public final int getGender() {
            return this.gender;
        }

        public int hashCode() {
            return (Integer.hashCode(this.ageGroup) * 31) + Integer.hashCode(this.gender);
        }

        public final void setAgeGroup(int i) {
            this.ageGroup = i;
        }

        public final void setGender(int i) {
            this.gender = i;
        }

        @NotNull
        public String toString() {
            return "Ext(ageGroup=" + this.ageGroup + ", gender=" + this.gender + ")";
        }

        public /* synthetic */ Ext(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 18 : i, (i3 & 2) != 0 ? 0 : i2);
        }
    }

    public SYAdInitConfig(Builder builder) {
        Ext ext;
        this.appId = builder.getAppId();
        this.appSecret = builder.getAppSecret();
        this.controller = builder.getController();
        this.debug = builder.getDebug();
        this.allowShowNotification = builder.getAllowShowNotification();
        this.supportMultiProcess = builder.getSupportMultiProcess();
        if (builder.getExt() == null) {
            int i = 0;
            ext = new Ext(i, i, 3, null);
        } else {
            ext = builder.getExt();
            Intrinsics.checkNotNull(ext);
        }
        this.ext = ext;
        this.wxAppId = builder.getWxAppId();
        this.npCheck = builder.getNpCheck();
    }

    public final boolean getAllowShowNotification() {
        return this.allowShowNotification;
    }

    @NotNull
    public final String getAppId() {
        return this.appId;
    }

    @NotNull
    public final String getAppSecret() {
        return this.appSecret;
    }

    @Nullable
    public final SYCustomController getController() {
        return this.controller;
    }

    public final boolean getDebug() {
        return this.debug;
    }

    @NotNull
    public final Ext getExt() {
        return this.ext;
    }

    public final boolean getNpCheck() {
        return this.npCheck;
    }

    public final boolean getSupportMultiProcess() {
        return this.supportMultiProcess;
    }

    @NotNull
    public final String getWxAppId() {
        return this.wxAppId;
    }

    public final void setExt(@NotNull Ext ext) {
        Intrinsics.checkNotNullParameter(ext, "<set-?>");
        this.ext = ext;
    }

    public final void setSupportMultiProcess(boolean z) {
        this.supportMultiProcess = z;
    }

    public final void setWxAppId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.wxAppId = str;
    }

    @NotNull
    public String toString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appId", this.appId);
        jSONObject.put(b.A, this.appSecret);
        jSONObject.put(AliyunLogCommon.LogLevel.DEBUG, this.debug);
        jSONObject.put("allowShowNotification", this.allowShowNotification);
        jSONObject.put("supportMultiProcess", this.supportMultiProcess);
        return "SYAdInitConfig = " + jSONObject;
    }

    public /* synthetic */ SYAdInitConfig(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }
}
