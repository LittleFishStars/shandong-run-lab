package com.fl.saas;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.fl.saas.adx.api.mixNative.NativeAdAppInfo;
import com.fl.saas.adx.api.mixNative.NativeMaterial;
import com.fl.saas.adx.base.bean.MaterialBean;
import com.fl.saas.adx.base.bean.Size;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.innterNative.AdAppInfo;
import com.fl.saas.adx.base.innterNative.NativeStyle;
import com.fl.saas.adx.util.Check;
import com.fl.saas.adx.util.CommConstant;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.LogcatUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class J0 extends AbstractC1418k0 {
    private static final String m = CommConstant.getClassTag("S2S", J0.class);
    private K0 l;

    public class a implements InterfaceC1424n0 {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(C1415j c1415j) {
            if (J0.this.l == null) {
                J0.this.onAdFailed(new FLError(20403, "onLoadFailed, native is empty"));
                return;
            }
            if (J0.this.b() != NativeStyle.EXPRESS || !J0.this.a().isMixNative()) {
                J0 j0 = J0.this;
                j0.onNativeAdLoaded(j0.l);
            } else {
                int iDip2px = DeviceUtil.dip2px(J0.this.a().getExpressWidth());
                int iDip2px2 = DeviceUtil.dip2px(J0.this.a().getExpressHeight());
                J0 j1 = J0.this;
                j1.onNativeAdLoaded(new L0(j1.c(), J0.this.l, iDip2px, iDip2px2).a(c1415j.H));
            }
        }

        @Override // com.fl.saas.InterfaceC1424n0
        public void onAdFailed(FLError fLError) {
            J0.this.onAdFailed(fLError);
        }

        @Override // com.fl.saas.InterfaceC1424n0
        public void a(List list) {
            final C1415j c1415j = (C1415j) Check.findFirstNonNull(list);
            if (c1415j == null) {
                J0.this.onAdFailed(FLError.create(20401, "onNativeAdReceived but pojoList is empty"));
                return;
            }
            c1415j.j0 = J0.this.f();
            J0.this.a(c1415j);
            J0.this.l = new K0(J0.this.c(), c1415j, new G0() { // from class: com.fl.saas.j1
                @Override // com.fl.saas.G0
                public final void a() {
                    this.f30181a.a(c1415j);
                }
            });
            J0.this.l.c();
        }
    }

    public class b implements NativeMaterial {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List f30064a;
        Bitmap b;
        Bitmap c;
        private NativeAdAppInfo d;
        final /* synthetic */ C1415j e;
        final /* synthetic */ View f;

        public class a extends AdAppInfo {
            public a() {
            }

            @Override // com.fl.saas.adx.api.mixNative.NativeAdAppInfo
            public String getAppName() {
                return b.this.e.C0;
            }

            @Override // com.fl.saas.adx.api.mixNative.NativeAdAppInfo
            public String getAppPermissionUrl() {
                return b.this.e.G0;
            }

            @Override // com.fl.saas.adx.api.mixNative.NativeAdAppInfo
            public String getAppPrivacyUrl() {
                return b.this.e.H0;
            }

            @Override // com.fl.saas.adx.api.mixNative.NativeAdAppInfo
            public String getAppVersion() {
                return b.this.e.E0;
            }

            @Override // com.fl.saas.adx.api.mixNative.NativeAdAppInfo
            public String getFunctionUrl() {
                return b.this.e.J0;
            }

            @Override // com.fl.saas.adx.api.mixNative.NativeAdAppInfo
            public String getPublisher() {
                return b.this.e.D0;
            }
        }

        public b(C1415j c1415j, View view) {
            this.e = c1415j;
            this.f = view;
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeMaterial
        public NativeAdAppInfo getAdAppInfo() {
            if (this.d == null) {
                this.d = new a();
            }
            return this.d;
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeMaterial
        public Bitmap getAdLogo() {
            if (this.b == null) {
                try {
                    C1415j c1415j = this.e;
                    this.b = (c1415j.f30175a == 0 || "广告".equals(c1415j.y)) ? AbstractC1398a0.a(DeviceUtil.getContext(), R.mipmap.fl_adx_icon_logo) : AbstractC1398a0.a(this.e.y);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return this.b;
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeMaterial
        public Bitmap getAdLogoBitmap() {
            if (this.c == null) {
                try {
                    C1415j c1415j = this.e;
                    this.c = (c1415j.f30175a == 0 || "广告".equals(c1415j.y)) ? AbstractC1398a0.a(DeviceUtil.getContext(), R.mipmap.fl_adx_icon_no_text_logo) : AbstractC1398a0.a(this.e.y);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return this.c;
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeMaterial
        public String getAdLogoUrl() {
            return null;
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeMaterial
        public View getAdMediaView() {
            return this.f;
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeMaterial
        public int getAdType() {
            int i = this.e.P0.b;
            if (i != 1) {
                if (i == 2) {
                    return 3;
                }
                if (i != 3) {
                    return 0;
                }
            }
            return 1;
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeMaterial
        public String getCallToAction() {
            return TextUtils.equals("1", this.e.w0) ? com.ipd.dsp.internal.b1.b.a.l : "查看详情";
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeMaterial
        public String getDescription() {
            return this.e.s1;
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeMaterial
        public String getIconUrl() {
            return this.e.x1;
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeMaterial
        public List getImageUrlList() {
            if (this.f30064a == null) {
                ArrayList arrayList = new ArrayList();
                this.f30064a = arrayList;
                arrayList.add(this.e.p1);
            }
            return this.f30064a;
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeMaterial
        public String getMainImageUrl() {
            return this.e.p1;
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeMaterial
        public MaterialBean getMaterial() {
            MaterialBean materialBean = new MaterialBean();
            C1415j c1415j = this.e;
            if (c1415j != null && c1415j.x2 == 1) {
                materialBean.setId(c1415j.z);
                materialBean.setPlaceId(this.e.i);
                materialBean.setTitle(this.e.o0);
                materialBean.setDes(this.e.s1);
                materialBean.setImgUrl(this.e.p1);
                materialBean.setDeepLinkUrl(this.e.y0);
                materialBean.setLandPageUrl(this.e.x0);
                materialBean.setDownloadUrl(this.e.z0);
            }
            return materialBean;
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeMaterial
        public Size getSize() {
            C1415j.e eVar;
            C1415j c1415j = this.e;
            C1415j.c cVar = c1415j.P0;
            return (cVar.b != 2 || (eVar = cVar.g) == null) ? new Size(c1415j.v1, c1415j.w1) : new Size(eVar.b, eVar.c);
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeMaterial
        public String getTitle() {
            return this.e.o0;
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeMaterial
        public double getVideoDuration() {
            return this.e.X1 * 1000;
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeMaterial
        public String getVideoUrl() {
            return this.e.t1;
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeMaterial
        public boolean isNativeAppAd() {
            return !TextUtils.isEmpty(this.e.z0);
        }
    }

    @Override // com.fl.saas.AbstractC1418k0
    public void g() {
        LogcatUtil.d(m, "loadNative");
        R0.a().a(e(), d(), f(), new a());
    }

    public static NativeMaterial a(C1415j c1415j, View view) {
        return new b(c1415j, view);
    }
}
