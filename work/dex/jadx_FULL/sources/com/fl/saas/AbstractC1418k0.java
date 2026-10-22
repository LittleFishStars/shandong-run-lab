package com.fl.saas;

import android.content.Context;
import com.fl.saas.adx.api.AdParams;
import com.fl.saas.adx.api.mixNative.NativeAd;
import com.fl.saas.adx.api.mixNative.NativeLoadListener;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.innterNative.NativeStyle;
import com.fl.saas.adx.util.CommConstant;
import com.fl.saas.adx.util.LogcatUtil;

/* JADX INFO: renamed from: com.fl.saas.k0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AbstractC1418k0 implements InterfaceC1416j0, NativeLoadListener {
    private Context b;
    private NativeLoadListener c;
    private String d;
    private String e;
    private String f;
    private C1415j g;
    private AdParams h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f30182a = CommConstant.getObjTag(com.ipd.dsp.internal.e1.i.g, this);
    private NativeStyle i = NativeStyle.NONE;
    private boolean j = false;
    private boolean k = false;

    public AdParams a() {
        return this.h;
    }

    public NativeStyle b() {
        if (this.i == NativeStyle.NONE) {
            this.i = NativeStyle.create(this.g.b());
        }
        return this.i;
    }

    public Context c() {
        return this.b;
    }

    @Override // com.fl.saas.InterfaceC1416j0
    public void clearCache() {
        this.j = false;
    }

    public String d() {
        return this.f;
    }

    @Override // com.fl.saas.InterfaceC1416j0
    public void destroy() {
        this.c = null;
    }

    public String e() {
        return this.e;
    }

    public boolean f() {
        return this.k;
    }

    public abstract void g();

    @Override // com.fl.saas.InterfaceC1416j0
    public C1415j getAdSource() {
        return this.g;
    }

    @Override // com.fl.saas.adx.base.interfaces.AdViewListener
    public void onAdFailed(final FLError fLError) {
        LogcatUtil.d(this.f30182a, "onAdFailed:" + fLError);
        a(new B() { // from class: com.zj.adlib.kgb
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                ((NativeLoadListener) obj).onAdFailed(fLError);
            }
        });
    }

    @Override // com.fl.saas.adx.api.mixNative.NativeLoadListener
    public void onNativeAdLoaded(final NativeAd nativeAd) {
        LogcatUtil.d(this.f30182a, "onNativeAdLoaded");
        a(new B() { // from class: com.zj.adlib.jgb
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                ((NativeLoadListener) obj).onNativeAdLoaded(nativeAd);
            }
        });
    }

    @Override // com.fl.saas.InterfaceC1416j0
    public void setCache() {
        this.j = true;
        this.c = null;
    }

    @Override // com.fl.saas.InterfaceC1416j0
    public InterfaceC1416j0 setContext(Context context) {
        this.b = context;
        return this;
    }

    @Override // com.fl.saas.InterfaceC1416j0
    public InterfaceC1416j0 setLinkId(String str) {
        this.f = str;
        return this;
    }

    private void a(B b) {
        C1428p0.b(this.c).a(b);
    }

    @Override // com.fl.saas.InterfaceC1416j0
    public void a(Context context) {
        if (this.b == null) {
            a("mContext is null");
            return;
        }
        try {
            g();
        } catch (Exception e) {
            a(e.getMessage());
            e.printStackTrace();
        }
    }

    public void a(String str) {
        LogcatUtil.e(this.f30182a, str);
        onAdFailed(FLError.create(20403, str));
    }

    @Override // com.fl.saas.InterfaceC1416j0
    public InterfaceC1416j0 a(String str, String str2) {
        this.d = str;
        this.e = str2;
        return this;
    }

    @Override // com.fl.saas.InterfaceC1416j0
    public InterfaceC1416j0 a(AdParams adParams) {
        this.h = adParams;
        return this;
    }

    public InterfaceC1416j0 a(C1415j c1415j) {
        this.g = c1415j;
        this.d = c1415j.b;
        this.e = c1415j.f;
        this.i = NativeStyle.create(c1415j.b());
        return this;
    }

    public AbstractC1418k0 a(NativeStyle nativeStyle) {
        this.i = nativeStyle;
        return this;
    }

    public void a(boolean z) {
        this.k = z;
    }

    @Override // com.fl.saas.InterfaceC1416j0
    public InterfaceC1416j0 a(NativeLoadListener nativeLoadListener) {
        this.c = nativeLoadListener;
        return this;
    }
}
