package com.ltmb.ltadsdk.api.internal;

import com.google.android.exoplayer2.source.rtsp.j;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0010\t\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010K\u001a\u00020\u0002\u0012\b\b\u0002\u0010O\u001a\u00020\u001c¢\u0006\u0004\bP\u0010QR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\"\u0010\u0015\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\"\u0010/\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR\"\u00103\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\"\u00107\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0004\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\bR\"\u0010;\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0004\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR\"\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010\u0004\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR\"\u0010G\u001a\u00020@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010K\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010\u0004\u001a\u0004\bI\u0010\u0006\"\u0004\bJ\u0010\bR\"\u0010O\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010\u001e\u001a\u0004\bM\u0010 \"\u0004\bN\u0010\"¨\u0006R"}, d2 = {"Lcom/ltmb/ltadsdk/api/internal/AdCodeConfig;", "", "", "a", "I", "getAdType", "()I", "setAdType", "(I)V", "adType", "b", "getBidType", "setBidType", "bidType", "c", "getSortPrice", "setSortPrice", "sortPrice", "", "d", "Z", "isHeadBidding", "()Z", "setHeadBidding", "(Z)V", "e", "isBottom", "setBottom", "", "f", "Ljava/lang/String;", "getSlotId", "()Ljava/lang/String;", "setSlotId", "(Ljava/lang/String;)V", "slotId", y6b.f, "getSlotType", "setSlotType", "slotType", y6b.g, "getReqFreq", "setReqFreq", "reqFreq", "i", "getImpFreq", "setImpFreq", "impFreq", "j", "getMinReqInterval", "setMinReqInterval", "minReqInterval", "k", "getImpFreqByDay", "setImpFreqByDay", "impFreqByDay", t.d, "getImpFreqByHour", "setImpFreqByHour", "impFreqByHour", "m", "getMinImpInterval", "setMinImpInterval", "minImpInterval", "", "n", "J", "getExposeTime", "()J", "setExposeTime", "(J)V", "exposeTime", j.b, "getAdn", "setAdn", "adn", "p", "getAdCodeId", "setAdCodeId", "adCodeId", "<init>", "(ILjava/lang/String;)V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public final class AdCodeConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public int adType;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public int bidType;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public int sortPrice;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public boolean isHeadBidding;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public boolean isBottom;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public String slotId;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public int slotType;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public int reqFreq;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public int impFreq;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public int minReqInterval;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public int impFreqByDay;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public int impFreqByHour;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public int minImpInterval;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public long exposeTime;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public int adn;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @NotNull
    public String adCodeId;

    public AdCodeConfig(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "adCodeId");
        this.adn = i;
        this.adCodeId = str;
        this.slotId = "";
    }

    @NotNull
    public final String getAdCodeId() {
        return this.adCodeId;
    }

    public final int getAdType() {
        return this.adType;
    }

    public final int getAdn() {
        return this.adn;
    }

    public final int getBidType() {
        return this.bidType;
    }

    public final long getExposeTime() {
        return this.exposeTime;
    }

    public final int getImpFreq() {
        return this.impFreq;
    }

    public final int getImpFreqByDay() {
        return this.impFreqByDay;
    }

    public final int getImpFreqByHour() {
        return this.impFreqByHour;
    }

    public final int getMinImpInterval() {
        return this.minImpInterval;
    }

    public final int getMinReqInterval() {
        return this.minReqInterval;
    }

    public final int getReqFreq() {
        return this.reqFreq;
    }

    @NotNull
    public final String getSlotId() {
        return this.slotId;
    }

    public final int getSlotType() {
        return this.slotType;
    }

    public final int getSortPrice() {
        return this.sortPrice;
    }

    /* JADX INFO: renamed from: isBottom, reason: from getter */
    public final boolean getIsBottom() {
        return this.isBottom;
    }

    /* JADX INFO: renamed from: isHeadBidding, reason: from getter */
    public final boolean getIsHeadBidding() {
        return this.isHeadBidding;
    }

    public final void setAdCodeId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.adCodeId = str;
    }

    public final void setAdType(int i) {
        this.adType = i;
    }

    public final void setAdn(int i) {
        this.adn = i;
    }

    public final void setBidType(int i) {
        this.bidType = i;
    }

    public final void setBottom(boolean z) {
        this.isBottom = z;
    }

    public final void setExposeTime(long j) {
        this.exposeTime = j;
    }

    public final void setHeadBidding(boolean z) {
        this.isHeadBidding = z;
    }

    public final void setImpFreq(int i) {
        this.impFreq = i;
    }

    public final void setImpFreqByDay(int i) {
        this.impFreqByDay = i;
    }

    public final void setImpFreqByHour(int i) {
        this.impFreqByHour = i;
    }

    public final void setMinImpInterval(int i) {
        this.minImpInterval = i;
    }

    public final void setMinReqInterval(int i) {
        this.minReqInterval = i;
    }

    public final void setReqFreq(int i) {
        this.reqFreq = i;
    }

    public final void setSlotId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.slotId = str;
    }

    public final void setSlotType(int i) {
        this.slotType = i;
    }

    public final void setSortPrice(int i) {
        this.sortPrice = i;
    }

    public /* synthetic */ AdCodeConfig(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? "" : str);
    }
}
