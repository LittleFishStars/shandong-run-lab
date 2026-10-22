package com.ltmb.ltadsdk.api.internal;

import com.ali.auth.third.login.LoginConstants;
import com.czhj.sdk.common.Constants;
import com.google.android.exoplayer2.source.rtsp.j;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010%\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bn\u0010oJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001R$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\fR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\b\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\b\u001a\u0004\b\u001b\u0010\n\"\u0004\b\u001c\u0010\fR\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010)\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\"\u0010-\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010 \u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$R\"\u00101\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010 \u001a\u0004\b/\u0010\"\"\u0004\b0\u0010$R2\u00109\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010=\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010\b\u001a\u0004\b;\u0010\n\"\u0004\b<\u0010\fR\"\u0010E\u001a\u00020>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010M\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010Q\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010\b\u001a\u0004\bO\u0010\n\"\u0004\bP\u0010\fR$\u0010U\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010\b\u001a\u0004\bS\u0010\n\"\u0004\bT\u0010\fR$\u0010Y\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010H\u001a\u0004\bW\u0010J\"\u0004\bX\u0010LR$\u0010]\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010\b\u001a\u0004\b[\u0010\n\"\u0004\b\\\u0010\fR$\u0010e\u001a\u0004\u0018\u00010^8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR$\u0010i\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010\b\u001a\u0004\bg\u0010\n\"\u0004\bh\u0010\fR$\u0010m\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010\b\u001a\u0004\bk\u0010\n\"\u0004\bl\u0010\f¨\u0006p"}, d2 = {"Lcom/ltmb/ltadsdk/api/internal/AdEventParamsProxy;", "", "", CachedContentIndex.a.e, "value", "", "putExt", "a", "Ljava/lang/String;", "getRequestId", "()Ljava/lang/String;", "setRequestId", "(Ljava/lang/String;)V", "requestId", "b", "getCrequestId", "setCrequestId", "crequestId", "c", "getAdn", "setAdn", "adn", "d", "getSlotId", "setSlotId", "slotId", "e", "getAdCodeId", "setAdCodeId", "adCodeId", "", "f", "I", "getErrorCode", "()I", "setErrorCode", "(I)V", "errorCode", y6b.f, "getClickType", "setClickType", Constants.CLICK_TYPE, y6b.g, "getEcpm", "setEcpm", "ecpm", "i", "getBidType", "setBidType", "bidType", "", "j", "Ljava/util/Map;", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", LoginConstants.EXT, "k", "getMsg", "setMsg", "msg", "", t.d, "J", "getCost", "()J", "setCost", "(J)V", "cost", "", "m", "Ljava/lang/Boolean;", "getFullClick", "()Ljava/lang/Boolean;", "setFullClick", "(Ljava/lang/Boolean;)V", "fullClick", "n", "getData", "setData", "data", j.b, "getApi", "setApi", "api", "p", "getBlockClick", "setBlockClick", "blockClick", "q", "getDeep", "setDeep", "deep", "Lorg/json/JSONArray;", "r", "Lorg/json/JSONArray;", "getInstalled", "()Lorg/json/JSONArray;", "setInstalled", "(Lorg/json/JSONArray;)V", "installed", "s", "getPkgname", "setPkgname", "pkgname", "t", "getAdid", "setAdid", "adid", "<init>", "()V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public final class AdEventParamsProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public String requestId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @Nullable
    public String crequestId;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @Nullable
    public String adn;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @Nullable
    public String slotId;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @Nullable
    public String adCodeId;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @Nullable
    public Map<String, Object> ext;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @Nullable
    public String msg;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @Nullable
    public Boolean fullClick;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @Nullable
    public String data;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @Nullable
    public String api;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @Nullable
    public Boolean blockClick;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    @Nullable
    public String deep;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    @Nullable
    public JSONArray installed;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    @Nullable
    public String pkgname;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    @Nullable
    public String adid;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public int errorCode = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public int clickType = -1;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public int ecpm = -1;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public int bidType = -1;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public long cost = -1;

    @Nullable
    public final String getAdCodeId() {
        return this.adCodeId;
    }

    @Nullable
    public final String getAdid() {
        return this.adid;
    }

    @Nullable
    public final String getAdn() {
        return this.adn;
    }

    @Nullable
    public final String getApi() {
        return this.api;
    }

    public final int getBidType() {
        return this.bidType;
    }

    @Nullable
    public final Boolean getBlockClick() {
        return this.blockClick;
    }

    public final int getClickType() {
        return this.clickType;
    }

    public final long getCost() {
        return this.cost;
    }

    @Nullable
    public final String getCrequestId() {
        return this.crequestId;
    }

    @Nullable
    public final String getData() {
        return this.data;
    }

    @Nullable
    public final String getDeep() {
        return this.deep;
    }

    public final int getEcpm() {
        return this.ecpm;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    public final Map<String, Object> getExt() {
        return this.ext;
    }

    @Nullable
    public final Boolean getFullClick() {
        return this.fullClick;
    }

    @Nullable
    public final JSONArray getInstalled() {
        return this.installed;
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }

    @Nullable
    public final String getPkgname() {
        return this.pkgname;
    }

    @Nullable
    public final String getRequestId() {
        return this.requestId;
    }

    @Nullable
    public final String getSlotId() {
        return this.slotId;
    }

    public final void putExt(@NotNull String key, @NotNull Object value) {
        Intrinsics.checkNotNullParameter(key, CachedContentIndex.a.e);
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.ext == null) {
            this.ext = new LinkedHashMap();
        }
        Map<String, Object> map = this.ext;
        if (map != null) {
            map.put(key, value);
        }
    }

    public final void setAdCodeId(@Nullable String str) {
        this.adCodeId = str;
    }

    public final void setAdid(@Nullable String str) {
        this.adid = str;
    }

    public final void setAdn(@Nullable String str) {
        this.adn = str;
    }

    public final void setApi(@Nullable String str) {
        this.api = str;
    }

    public final void setBidType(int i) {
        this.bidType = i;
    }

    public final void setBlockClick(@Nullable Boolean bool) {
        this.blockClick = bool;
    }

    public final void setClickType(int i) {
        this.clickType = i;
    }

    public final void setCost(long j) {
        this.cost = j;
    }

    public final void setCrequestId(@Nullable String str) {
        this.crequestId = str;
    }

    public final void setData(@Nullable String str) {
        this.data = str;
    }

    public final void setDeep(@Nullable String str) {
        this.deep = str;
    }

    public final void setEcpm(int i) {
        this.ecpm = i;
    }

    public final void setErrorCode(int i) {
        this.errorCode = i;
    }

    public final void setExt(@Nullable Map<String, Object> map) {
        this.ext = map;
    }

    public final void setFullClick(@Nullable Boolean bool) {
        this.fullClick = bool;
    }

    public final void setInstalled(@Nullable JSONArray jSONArray) {
        this.installed = jSONArray;
    }

    public final void setMsg(@Nullable String str) {
        this.msg = str;
    }

    public final void setPkgname(@Nullable String str) {
        this.pkgname = str;
    }

    public final void setRequestId(@Nullable String str) {
        this.requestId = str;
    }

    public final void setSlotId(@Nullable String str) {
        this.slotId = str;
    }
}
