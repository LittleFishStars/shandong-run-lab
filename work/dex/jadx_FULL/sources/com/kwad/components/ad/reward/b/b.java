package com.kwad.components.ad.reward.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.core.proxy.j;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends j implements com.kwad.components.ad.reward.b.a.b {
    private AdTemplate mAdTemplate;
    private int[] uG;
    private com.kwad.components.ad.reward.b.a uW;
    private a uX;

    public interface a {
        /* JADX INFO: renamed from: if, reason: not valid java name */
        void mo1058if();
    }

    public static void a(Activity activity, AdTemplate adTemplate, a aVar, int[] iArr) {
        if (adTemplate == null || activity == null) {
            return;
        }
        String string = adTemplate.toJson().toString();
        Bundle bundle = new Bundle();
        bundle.putString("key_template_json", string);
        bundle.putIntArray("key_end_location", iArr);
        b bVar = new b();
        bVar.a(aVar);
        bVar.setArguments(bundle);
        bVar.show(activity.getFragmentManager(), "rewardCoupon");
    }

    @Override // com.kwad.components.ad.reward.b.a.b
    /* JADX INFO: renamed from: if */
    public final void mo1057if() {
        dismiss();
        a aVar = this.uX;
        if (aVar != null) {
            aVar.mo1058if();
        }
    }

    @Override // com.kwad.components.ad.reward.b.a.b
    public final void ig() {
        dismiss();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey("key_template_json")) {
                try {
                    String string = arguments.getString("key_template_json");
                    AdTemplate adTemplate = new AdTemplate();
                    this.mAdTemplate = adTemplate;
                    adTemplate.parseJson(new JSONObject(string));
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                }
            }
            if (arguments.containsKey("key_end_location")) {
                this.uG = arguments.getIntArray("key_end_location");
            }
        }
    }

    private void a(a aVar) {
        this.uX = aVar;
    }

    @Override // com.kwad.components.core.proxy.j
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        com.kwad.components.ad.reward.b.a aVar = new com.kwad.components.ad.reward.b.a(layoutInflater.getContext(), viewGroup, this.uG);
        this.uW = aVar;
        aVar.a(this);
        Window window = getDialog().getWindow();
        if (window != null) {
            window.getDecorView().setPadding(0, 0, 0, 0);
            getDialog().setCanceledOnTouchOutside(false);
            window.setLayout(-1, -1);
            window.setDimAmount(0.0f);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        this.uW.b(r.ah(this.mAdTemplate));
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.ad.reward.b.b.1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 4 && keyEvent.getAction() == 0;
            }
        });
        return this.uW.ib();
    }
}
