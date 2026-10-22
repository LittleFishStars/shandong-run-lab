package com.kwad.sdk.a.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.proxy.g;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.au;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class a extends g {

    @SuppressLint({"StaticFieldLeak"})
    private static a aGR;

    @Nullable
    private final DialogInterface.OnDismissListener aGS;
    private final AdTemplate mAdTemplate;

    @Nullable
    private final DialogInterface.OnClickListener mOnClickListener;

    private a(@NonNull Activity activity, @NonNull AdTemplate adTemplate, @Nullable DialogInterface.OnDismissListener onDismissListener, @Nullable DialogInterface.OnClickListener onClickListener) {
        super(activity);
        this.mAdTemplate = adTemplate;
        this.aGS = onDismissListener;
        this.mOnClickListener = onClickListener;
    }

    public static boolean Hf() {
        a aVar = aGR;
        if (aVar == null || !aVar.isShowing()) {
            return false;
        }
        aGR.dismiss();
        return true;
    }

    public static boolean pG() {
        a aVar = aGR;
        return aVar != null && aVar.isShowing();
    }

    @Override // com.kwad.components.core.proxy.g, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        try {
            super.dismiss();
            DialogInterface.OnDismissListener onDismissListener = this.aGS;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(this);
            }
            aGR = null;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.g
    public final void g(View view) {
        TextView textView = (TextView) view.findViewById(R.id.ksad_install_tips_content);
        TextView textView2 = (TextView) view.findViewById(R.id.ksad_install_cancel);
        TextView textView3 = (TextView) view.findViewById(R.id.ksad_install_tv);
        final AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate);
        String strH = d.H(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate));
        if (strH.equals("")) {
            strH = this.mContext.getString(R.string.ksad_install_tips, com.kwad.sdk.core.response.helper.a.aB(adInfoEO));
        }
        textView.setText(strH);
        textView3.setText(d.Hr());
        textView2.setText(d.Hs());
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.a.a.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a.this.dismiss();
                if (a.this.mOnClickListener != null) {
                    a.this.mOnClickListener.onClick(a.this, -2);
                }
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.a.a.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (a.this.mOnClickListener != null) {
                    a.this.mOnClickListener.onClick(a.this, -1);
                }
                au.a(com.kwad.sdk.core.download.a.J(adInfoEO), new au.a() { // from class: com.kwad.sdk.a.a.a.2.1
                    @Override // com.kwad.sdk.utils.au.a
                    public final void d(Throwable th) {
                        com.kwad.sdk.commercial.a.a.j(a.this.mAdTemplate, 100003, Log.getStackTraceString(th));
                    }

                    @Override // com.kwad.sdk.utils.au.a
                    public final void qD() {
                        com.kwad.sdk.core.adlog.c.l(a.this.mAdTemplate, 1);
                        com.kwad.sdk.commercial.a.a.bG(a.this.mAdTemplate);
                    }
                });
            }
        });
    }

    @Override // com.kwad.components.core.proxy.g
    public final int getLayoutId() {
        return R.layout.ksad_install_dialog;
    }

    public static boolean a(Activity activity, AdTemplate adTemplate, @Nullable DialogInterface.OnDismissListener onDismissListener, @Nullable DialogInterface.OnClickListener onClickListener) {
        if (activity != null && !activity.isFinishing() && adTemplate != null) {
            a aVar = aGR;
            if (aVar != null && aVar.isShowing()) {
                aGR.dismiss();
            }
            try {
                a aVar2 = new a(activity, adTemplate, onDismissListener, onClickListener);
                aVar2.show();
                aGR = aVar2;
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a(Activity activity, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnClickListener onClickListener) {
        AdTemplate adTemplateHm;
        if (activity == null || activity.isFinishing() || (adTemplateHm = c.Hl().Hm()) == null) {
            return false;
        }
        return a(activity, adTemplateHm, onDismissListener, onClickListener);
    }
}
