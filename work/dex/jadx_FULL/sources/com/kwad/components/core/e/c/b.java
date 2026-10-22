package com.kwad.components.core.e.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.proxy.g;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.wrapper.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends g {

    @Nullable
    private static b Qv;
    private boolean QA;

    @NonNull
    private final C1200b Qw;
    private com.kwad.components.core.e.c.a Qz;

    public static class a {

        @Nullable
        private DialogInterface.OnShowListener QC;

        @Nullable
        private DialogInterface.OnDismissListener QD;
        private AdTemplate adTemplate;
        private String url;

        public final a aH(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final a ao(String str) {
            this.url = str;
            return this;
        }

        public final C1200b pJ() {
            if (com.kwad.components.core.a.pe.booleanValue() && (this.adTemplate == null || TextUtils.isEmpty(this.url))) {
                throw new IllegalArgumentException("param is error, please check it");
            }
            return new C1200b(this, (byte) 0);
        }

        public final a a(@Nullable DialogInterface.OnShowListener onShowListener) {
            this.QC = onShowListener;
            return this;
        }

        public final a c(@Nullable DialogInterface.OnDismissListener onDismissListener) {
            this.QD = onDismissListener;
            return this;
        }
    }

    /* JADX INFO: renamed from: com.kwad.components.core.e.c.b$b, reason: collision with other inner class name */
    public static class C1200b {

        @Nullable
        protected DialogInterface.OnShowListener QC;

        @Nullable
        protected DialogInterface.OnDismissListener QD;
        protected final AdTemplate adTemplate;
        protected String url;

        public /* synthetic */ C1200b(a aVar, byte b) {
            this(aVar);
        }

        private C1200b(a aVar) {
            this.adTemplate = aVar.adTemplate;
            this.url = aVar.url;
            this.QC = aVar.QC;
            this.QD = aVar.QD;
        }
    }

    private b(Activity activity, @NonNull C1200b c1200b) {
        super(activity);
        this.QA = false;
        this.Qw = c1200b;
        if (com.kwad.sdk.c.a.a.f(activity)) {
            getWindow().addFlags(1024);
        }
        setOnShowListener(c1200b.QC);
        setOnDismissListener(c1200b.QD);
    }

    public static boolean a(Context context, C1200b c1200b) {
        Activity activityFromContext;
        b bVar = Qv;
        if ((bVar == null || !bVar.isShowing()) && context != null && (activityFromContext = m.getActivityFromContext(context)) != null && !activityFromContext.isFinishing()) {
            com.kwad.sdk.a.a.c.Hl().dismiss();
            try {
                b bVar2 = new b(activityFromContext, c1200b);
                Qv = bVar2;
                bVar2.show();
                com.kwad.sdk.core.adlog.c.b(c1200b.adTemplate, 86, (JSONObject) null);
                return true;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
        }
        return false;
    }

    public static boolean pG() {
        b bVar = Qv;
        if (bVar != null) {
            return bVar.isShowing();
        }
        return false;
    }

    public final void an(boolean z) {
        this.QA = z;
        dismiss();
    }

    @Override // com.kwad.components.core.proxy.g
    public final ViewGroup dC() {
        com.kwad.components.core.e.c.a aVar = new com.kwad.components.core.e.c.a(this.mContext, this, this.Qw);
        this.Qz = aVar;
        return aVar;
    }

    @Override // com.kwad.components.core.proxy.g, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        Qv = null;
    }

    @Override // com.kwad.components.core.proxy.g
    public final void g(View view) {
        this.Qz.setChangeListener(new com.kwad.components.core.e.c.a.InterfaceC1199a() { // from class: com.kwad.components.core.e.c.b.1
            @Override // com.kwad.components.core.e.c.a.InterfaceC1199a
            public final void pF() {
                b.this.dismiss();
            }
        });
    }

    @Override // com.kwad.components.core.proxy.g
    public final int getLayoutId() {
        return 0;
    }

    @Override // android.app.Dialog
    public final boolean isShowing() {
        return super.isShowing();
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        super.onBackPressed();
        com.kwad.sdk.core.adlog.c.cx(this.Qw.adTemplate);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Qv = null;
    }

    @Override // com.kwad.components.core.proxy.g, android.app.Dialog
    public final void onStart() {
        super.onStart();
        b bVar = Qv;
        if (bVar != null) {
            bVar.setTitle((CharSequence) null);
        }
    }

    @Override // com.kwad.components.core.proxy.g
    public final boolean pH() {
        return true;
    }

    public final boolean pI() {
        return this.QA;
    }

    @Override // android.app.Dialog
    public final void show() {
        Resources resources;
        int identifier;
        try {
            super.show();
            try {
                if (((getContext() == null || (resources = getContext().getResources()) == null || (identifier = resources.getIdentifier(com.gyf.immersionbar.b.f6803b, "dimen", "android")) <= 0) ? 0 : getContext().getResources().getDimensionPixelSize(identifier)) > 0) {
                    getWindow().getDecorView().setSystemUiVisibility(5382);
                    return;
                }
                return;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                return;
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
        com.kwad.sdk.core.d.c.printStackTraceOnly(e);
    }
}
