package com.kwad.components.core.webview.tachikoma.d;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.proxy.j;
import com.kwad.components.core.webview.tachikoma.k;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class e extends j {
    public String Cd;
    private KSFrameLayout aif;
    public com.kwad.components.core.webview.tachikoma.f.c akL;
    protected StyleTemplate akN;
    protected com.kwad.components.core.webview.tachikoma.d.b auC;
    protected l auE;
    protected k auF;
    public boolean auG;
    public a auH;
    private com.kwad.components.core.webview.tachikoma.f.e auK;
    private d auN;
    protected List<DialogInterface.OnDismissListener> auO = new CopyOnWriteArrayList();
    public boolean auP = false;
    public AdResultData mAdResultData;
    private Presenter mPresenter;

    public interface a {
        boolean ho();
    }

    public static class b {
        private l auE;
        private boolean auG;
        private boolean auP;
        private StyleTemplate auR;
        private k auS;
        private AdResultData mAdResultData;
        private String templateId;

        public final void a(AdResultData adResultData) {
            this.mAdResultData = adResultData;
        }

        public final void bP(String str) {
            this.templateId = str;
        }

        public final void bo(boolean z) {
            this.auG = false;
        }

        public final void bp(boolean z) {
            this.auP = true;
        }

        public final String getTemplateId() {
            return this.templateId;
        }

        public final AdResultData iH() {
            return this.mAdResultData;
        }

        public final boolean lJ() {
            return this.auG;
        }

        public final boolean zz() {
            return this.auP;
        }

        public final void a(StyleTemplate styleTemplate) {
            this.auR = styleTemplate;
        }

        public final void c(l lVar) {
            this.auE = lVar;
        }

        public final void a(k kVar) {
            this.auS = kVar;
        }
    }

    private void G(View view) {
        if (this.auC == null) {
            this.auC = kQ();
        }
        kS();
        if (this.mPresenter == null) {
            Presenter presenterBJ = bJ();
            this.mPresenter = presenterBJ;
            presenterBJ.N(view);
        }
        this.mPresenter.q(this.auC);
    }

    public static e b(b bVar) {
        e eVar = new e();
        eVar.mAdResultData = bVar.iH();
        eVar.Cd = bVar.getTemplateId();
        eVar.auG = bVar.auG;
        eVar.auP = bVar.auP;
        eVar.akN = bVar.auR;
        eVar.auE = bVar.auE;
        eVar.auF = bVar.auS;
        Bundle bundle = new Bundle();
        bundle.putString("templateId", bVar.getTemplateId());
        eVar.setArguments(bundle);
        return eVar;
    }

    private Presenter bJ() {
        Presenter presenter = new Presenter();
        this.mPresenter = presenter;
        if (this.auC.auF != null) {
            presenter.a(zy());
        } else {
            presenter.a(kR());
        }
        return this.mPresenter;
    }

    private static boolean f(Activity activity) {
        return activity != null && (activity.getWindow().getAttributes().flags & 1024) == 1024;
    }

    private d zy() {
        if (this.auN == null) {
            this.auN = new d();
        }
        return this.auN;
    }

    public final void d(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.auO.add(onDismissListener);
        }
    }

    public final void e(DialogInterface.OnDismissListener onDismissListener) {
        this.auO.remove(onDismissListener);
    }

    public com.kwad.components.core.webview.tachikoma.d.b kQ() {
        return new com.kwad.components.core.webview.tachikoma.d.b();
    }

    public c kR() {
        return new c();
    }

    public void kS() {
        this.auC.a(this.mAdResultData);
        this.auC.mActivity = getActivity();
        com.kwad.components.core.webview.tachikoma.d.b bVar = this.auC;
        bVar.asx = this;
        bVar.auD = this.aif;
        bVar.Cd = this.Cd;
        bVar.akN = this.akN;
        bVar.auG = this.auG;
        bVar.auE = this.auE;
        bVar.auF = this.auF;
        bVar.auH = this.auH;
        bVar.akL = this.akL;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        Window window;
        Resources resources;
        int identifier;
        try {
            super.onActivityCreated(bundle);
        } catch (Throwable unused) {
        }
        if (getDialog() == null || (window = getDialog().getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.0f;
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        int dimensionPixelSize = 0;
        getDialog().setCanceledOnTouchOutside(false);
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        window.setSoftInputMode(16);
        if (f(getDialog().getOwnerActivity())) {
            window.setFlags(1024, 1024);
        }
        try {
            if (this.auE.isHideNavigationBar()) {
                if (getContext() != null && (resources = getContext().getResources()) != null && (identifier = resources.getIdentifier(com.gyf.immersionbar.b.f6803b, "dimen", "android")) > 0) {
                    dimensionPixelSize = getContext().getResources().getDimensionPixelSize(identifier);
                }
                if (dimensionPixelSize > 0) {
                    getDialog().getWindow().getDecorView().setSystemUiVisibility(5382);
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.core.webview.tachikoma.d.e.1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4 || keyEvent.getAction() != 0) {
                    return false;
                }
                e eVar = e.this;
                if (eVar.auP) {
                    return true;
                }
                if (eVar.auN != null) {
                    return e.this.auN.onBackPressed();
                }
                return false;
            }
        });
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.Cd = getArguments().getString("templateId");
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
            this.mPresenter = null;
        }
        com.kwad.components.core.webview.tachikoma.d.b bVar = this.auC;
        if (bVar != null) {
            bVar.release();
            this.auC = null;
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDestroyView() {
        try {
            super.onDestroyView();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e("TkDialogFragment", "destroy view failed:" + th);
        }
        KSFrameLayout kSFrameLayout = this.aif;
        if (kSFrameLayout != null && (kSFrameLayout.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.aif.getParent()).removeView(this.aif);
            this.aif = null;
        }
        com.kwad.components.core.webview.tachikoma.f.e eVar = this.auK;
        if (eVar != null) {
            eVar.hu();
        }
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        com.kwad.components.core.webview.tachikoma.f.c cVar = this.akL;
        if (cVar != null) {
            cVar.hu();
        }
        for (DialogInterface.OnDismissListener onDismissListener : this.auO) {
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
        }
        l lVar = this.auE;
        if (lVar != null) {
            lVar.callbackDialogDismiss();
        }
    }

    @Override // android.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        G(view);
        com.kwad.components.core.webview.tachikoma.f.c cVar = this.akL;
        if (cVar != null) {
            cVar.hm();
        }
        com.kwad.components.core.webview.tachikoma.f.e eVar = this.auK;
        if (eVar != null) {
            eVar.hm();
        }
    }

    public final void a(com.kwad.components.core.webview.tachikoma.f.e eVar) {
        this.auK = eVar;
    }

    @Override // com.kwad.components.core.proxy.j
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        if (this.aif == null) {
            this.aif = (KSFrameLayout) layoutInflater.inflate(R.layout.ksad_video_tk_dialog_layout, viewGroup, false);
        }
        return this.aif;
    }
}
