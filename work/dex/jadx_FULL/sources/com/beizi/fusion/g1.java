package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.link.LinkModel;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class g1 extends j1 {

    public class a extends hd {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f27311a;
        private WeakReference b;

        private a(b bVar) {
            this.f27311a = bVar;
        }

        @Override // com.beizi.fusion.hd
        public void a(Activity activity) {
            this.b = new WeakReference(activity);
        }

        @Override // com.beizi.fusion.hd
        public void b(Activity activity) {
            b0.a().b().a(this);
            WeakReference weakReference = this.b;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            this.f27311a.g();
        }

        @Override // com.beizi.fusion.hd
        public void d(Activity activity) {
            WeakReference weakReference = this.b;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            this.b = null;
            b0.a().b().a(this);
            this.f27311a.f();
        }
    }

    public class b implements wf.a {
        private b() {
        }

        @Override // com.beizi.fusion.wf.a
        public void a() {
            g1.this.a(x9.a.APP_NOT_INSTALLED);
        }

        @Override // com.beizi.fusion.wf.a
        public void b() {
            g1.this.a(x9.a.INVOKE_DEEPLINK);
        }

        @Override // com.beizi.fusion.wf.a
        public void c() {
            g1.this.a(x9.a.DEEPLINK_INVOKE_SUCCESS);
        }

        @Override // com.beizi.fusion.wf.a
        public void d() {
            g1.this.a(x9.a.APP_INSTALLED);
        }

        @Override // com.beizi.fusion.wf.a
        public void e() {
            g1.this.a(x9.a.DEEPLINK_INVOKE_FAILED);
        }

        public void f() {
            g1.this.a(x9.a.DEEPLINK_INVOKE_ASSUME_SUCCESS);
        }

        public void g() {
            g1.this.a(x9.a.DEEPLINK_INVOKE_ASSUME_REFUSE);
            if (g1.this.b == null || g1.this.b.getLink() == null) {
                return;
            }
            g1 g1Var = g1.this;
            g1Var.a(g1Var.c, g1.this.b.getLink());
        }
    }

    @Override // com.beizi.fusion.j1, com.beizi.fusion.ha
    public void a(LinkModel linkModel, View view, int i) {
        if (linkModel == null || view == null) {
            return;
        }
        String deeplink = linkModel.getDeeplink();
        if (TextUtils.isEmpty(deeplink) || !a(view.getContext(), deeplink)) {
            super.a(linkModel, view, i);
        }
    }

    public void b(Context context, String str) {
        a(context, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean a(Context context, String str) {
        b bVar = new b();
        b0.a().b().b(new a(bVar));
        return wf.a(context, str, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(x9.a aVar) {
        this.f27001a.a(aVar, null, null);
    }
}
