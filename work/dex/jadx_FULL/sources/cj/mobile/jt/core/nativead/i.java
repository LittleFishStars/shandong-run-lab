package cj.mobile.jt.core.nativead;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import cj.mobile.jt.common.utils.l1;
import cj.mobile.jt.core.modle.AdErrorCode;
import cj.mobile.jt.core.modle.AppInformation;
import cj.mobile.jt.core.modle.IJuTuiBiddingAdData;
import cj.mobile.jt.core.modle.g0;
import cj.mobile.jt.core.modle.s;
import cj.mobile.jt.core.ui.widget.a0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public final class i implements JuTuiNativeAdData {
    public static final HashMap C = new HashMap();
    public boolean A;
    public l1 B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22532a;
    public final String b;
    public final int c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final ArrayList i;
    public final String j;
    public final long k;
    public final AppInformation l;
    public cj.mobile.jt.core.controller.f m;
    public h n;
    public final cj.mobile.jt.common.video.k o;
    public final g0 p;
    public NativeAdEventListener q;
    public final cj.mobile.jt.common.track.event.b r;
    public volatile boolean s;
    public volatile boolean t;
    public volatile boolean u;
    public volatile boolean v;
    public final String w;
    public final boolean x;
    public cj.mobile.jt.core.utils.h y;
    public a0 z;

    public i(g0 g0Var) {
    }

    @Override // cj.mobile.jt.core.nativead.JuTuiNativeAdData
    public final void bindAdToView(Context context, ViewGroup viewGroup, List list, View view) {
    }

    @Override // cj.mobile.jt.core.nativead.JuTuiNativeAdData
    public final void destroy() {
    }

    @Override // cj.mobile.jt.core.nativead.JuTuiNativeAdData
    public final int getAdMaterialType() {
        return this.c;
    }

    @Override // cj.mobile.jt.core.nativead.JuTuiNativeAdData
    public final View getAdMediaView() {
        return this.o;
    }

    @Override // cj.mobile.jt.core.nativead.JuTuiNativeAdData
    public final AppInformation getAppInformation() {
        return this.l;
    }

    @Override // cj.mobile.jt.core.nativead.JuTuiNativeAdData
    public final String getAppName() {
        return this.h;
    }

    @Override // cj.mobile.jt.core.nativead.JuTuiNativeAdData
    public final String getCreativeId() {
        return this.w;
    }

    @Override // cj.mobile.jt.core.nativead.JuTuiNativeAdData
    public final String getDescription() {
        return this.b;
    }

    @Override // cj.mobile.jt.core.nativead.JuTuiNativeAdData
    public final String getDownloadUrl() {
        return this.j;
    }

    @Override // cj.mobile.jt.core.modle.IJuTuiBiddingAdData
    public final long getEcpm() {
        return this.k;
    }

    @Override // cj.mobile.jt.core.modle.IJuTuiBiddingAdData
    public final Map getExtra() {
    }

    @Override // cj.mobile.jt.core.nativead.JuTuiNativeAdData
    public final String getImgUrl() {
        return this.e;
    }

    @Override // cj.mobile.jt.core.nativead.JuTuiNativeAdData
    public final List getImgUrls() {
        return this.i;
    }

    @Override // cj.mobile.jt.core.nativead.JuTuiNativeAdData
    public final String getLogoUrl() {
        return this.g;
    }

    @Override // cj.mobile.jt.core.nativead.JuTuiNativeAdData
    public final View getShakeView(Context context) {
    }

    @Override // cj.mobile.jt.core.nativead.JuTuiNativeAdData
    public final String getSource() {
        return this.d;
    }

    @Override // cj.mobile.jt.core.nativead.JuTuiNativeAdData
    public final String getTitle() {
        return this.f22532a;
    }

    @Override // cj.mobile.jt.core.nativead.JuTuiNativeAdData
    public final boolean isValid() {
        return true;
    }

    @Override // cj.mobile.jt.core.modle.IJuTuiBiddingAdData
    public final void notifyLoss(float f, IJuTuiBiddingAdData.LOSS_REASON loss_reason, String str) {
    }

    @Override // cj.mobile.jt.core.modle.IJuTuiBiddingAdData
    public final void notifyWin(float f) {
    }

    @Override // cj.mobile.jt.core.nativead.JuTuiNativeAdData
    public final void onPause() {
    }

    @Override // cj.mobile.jt.core.nativead.JuTuiNativeAdData
    public final void onResume() {
    }

    @Override // cj.mobile.jt.core.nativead.JuTuiNativeAdData
    public final void setNativeAdEventListener(NativeAdEventListener nativeAdEventListener) {
        this.q = nativeAdEventListener;
    }

    @Override // cj.mobile.jt.core.nativead.JuTuiNativeAdData
    public final void setVideoListener(NativeVideoListener nativeVideoListener) {
    }

    public final cj.mobile.jt.common.video.k a(Context context, s sVar) {
    }

    public final void a(AdErrorCode adErrorCode) {
    }

    public final void a(ViewGroup viewGroup) {
    }

    public static void a(i iVar, ViewGroup viewGroup) {
    }

    public final void a(ViewGroup viewGroup, List list, View view) {
    }

    public final void a() {
    }
}
