package cj.mobile.ad.supply.interstitial;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import cj.mobile.ad.supply.Bean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class InterstitialDialog extends Dialog {
    public Bean bean;
    public String cjPosId;
    public ImageView iv;
    public cj.mobile.d.b listener;
    public String requestId;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterstitialDialog f22076a;

        public a(InterstitialDialog interstitialDialog) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterstitialDialog f22077a;

        public b(InterstitialDialog interstitialDialog) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public InterstitialDialog(@NonNull Context context, Bean bean, String str, String str2, cj.mobile.d.b bVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void task(String str) {
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
    }

    @Override // android.app.Dialog
    public void onStart() {
    }
}
