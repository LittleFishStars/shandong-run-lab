package com.beizi.fusion;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.WindowManager;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeExpressContainer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class e1 extends aa {

    public class a implements wm.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f27204a;

        public a(View view) {
            this.f27204a = view;
        }

        @Override // com.beizi.fusion.wm.e
        public void a(String str) {
            e1.this.a(this.f27204a, str);
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.beizi.fusion.dc
    public void a(View view, int i) {
        ScopeExpressContainer expressRoot;
        Context context;
        if (!(view instanceof zc) || (expressRoot = ((zc) view).getExpressRoot()) == null || expressRoot.getRootView() == null || (context = expressRoot.getRootView().getContext()) == null) {
            return;
        }
        a(context, view);
    }

    private void a(Context context, View view) {
        try {
            new wm.b(context).a(new a(view)).a().show();
        } catch (WindowManager.BadTokenException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(View view, String str) {
        ScopeExpressContainer expressRoot;
        if (view instanceof zc) {
            expressRoot = ((zc) view).getExpressRoot();
        } else {
            expressRoot = (ScopeExpressContainer) view.getTag(dm.a(this.c, "scope_root_container"));
        }
        if (expressRoot != null) {
            ScopeExpressContainer.d.a(expressRoot, str);
        }
        this.f27001a.a(x9.a.COMPLAIN_CONFIRM, view, null);
    }
}
