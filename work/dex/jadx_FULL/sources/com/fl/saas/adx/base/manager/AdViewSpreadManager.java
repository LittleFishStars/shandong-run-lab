package com.fl.saas.adx.base.manager;

import com.fl.saas.AbstractC1409g;
import com.fl.saas.B;
import com.fl.saas.C1428p0;
import com.fl.saas.adx.base.base.builder.InnerSpreadBuilder;
import com.fl.saas.adx.base.bean.AdType;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.interfaces.AdViewSpreadListener;
import com.fl.saas.adx.base.manager.manager.BuilderLoadManager;
import com.fl.saas.adx.util.LogcatUtil;
import com.zj.adlib.cz;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdViewSpreadManager extends BuilderLoadManager<InnerSpreadBuilder<?>, AbstractC1409g, AdViewSpreadListener> {

    /* JADX INFO: renamed from: com.fl.saas.adx.base.manager.AdViewSpreadManager$1, reason: invalid class name */
    public class AnonymousClass1 implements AdViewSpreadListener {
        final /* synthetic */ InnerSpreadBuilder val$builder;

        public AnonymousClass1(InnerSpreadBuilder innerSpreadBuilder) {
            this.val$builder = innerSpreadBuilder;
        }

        public C1428p0 getSpreadListenerOpt() {
            return C1428p0.b(this.val$builder.getEventListener());
        }

        @Override // com.fl.saas.adx.base.base.listener.InnerSpreadListener
        public void onAdClick(final String str) {
            LogcatUtil.d("FLSDK-Spread", "adViewAdInterface onAdClick");
            getSpreadListenerOpt().a(new B() { // from class: com.fl.saas.adx.base.manager.b
                @Override // com.fl.saas.B
                public final void a(Object obj) {
                    ((AdViewSpreadListener) obj).onAdClick(str);
                }
            });
        }

        @Override // com.fl.saas.adx.base.base.listener.InnerSpreadListener
        public void onAdClose() {
            LogcatUtil.d("FLSDK-Spread", "adViewAdInterface onAdClose");
            getSpreadListenerOpt().a((B) new cz());
        }

        @Override // com.fl.saas.adx.base.base.listener.InnerSpreadListener
        public void onAdDisplay() {
            LogcatUtil.d("FLSDK-Spread", "adViewAdInterface onAdDisplay");
            getSpreadListenerOpt().a(new B() { // from class: com.zj.adlib.az
                @Override // com.fl.saas.B
                public final void a(Object obj) {
                    ((AdViewSpreadListener) obj).onAdDisplay();
                }
            });
        }

        @Override // com.fl.saas.adx.base.interfaces.AdViewListener
        public void onAdFailed(final FLError fLError) {
            LogcatUtil.d("FLSDK-Spread", "adViewAdInterface onAdFailed," + fLError.toString());
            getSpreadListenerOpt().a(new B() { // from class: com.fl.saas.adx.base.manager.a
                @Override // com.fl.saas.B
                public final void a(Object obj) {
                    ((AdViewSpreadListener) obj).onAdFailed(fLError);
                }
            });
        }
    }

    public AdViewSpreadManager() {
        super(AdType.Spread);
    }

    @Override // com.fl.saas.adx.base.manager.manager.BuilderLoadManager
    public AdViewSpreadListener initProxyEventListener(InnerSpreadBuilder<?> innerSpreadBuilder) {
        return new AnonymousClass1(innerSpreadBuilder);
    }
}
