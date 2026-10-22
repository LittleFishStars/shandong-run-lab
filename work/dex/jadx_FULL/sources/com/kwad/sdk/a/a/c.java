package com.kwad.sdk.a.a;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import com.kwad.sdk.utils.i;
import com.kwad.sdk.utils.y;
import com.kwad.sdk.wrapper.m;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class c {
    private e aHc;
    private final Map<String, Integer> aHd;
    private final Map<String, Integer> aHe;
    private final Stack<AdTemplate> aHf;
    private volatile boolean aHg;
    public volatile boolean aHh;
    public volatile boolean aHi;

    public static final class a {
        static final c aHn = new c(0);
    }

    public /* synthetic */ c(byte b) {
        this();
    }

    public static c Hl() {
        return a.aHn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hp() {
        if (!this.aHh && com.kwad.sdk.a.a.a.b.dV() <= 0) {
            by.runOnUiThread(new Runnable() { // from class: com.kwad.sdk.a.a.c.6
                @Override // java.lang.Runnable
                @SuppressLint({"WrongConstant"})
                public final void run() {
                    try {
                        AdTemplate adTemplateHj = b.Hi().Hj();
                        if (adTemplateHj == null || com.kwad.sdk.core.config.e.JG() == 0) {
                            return;
                        }
                        c.this.aHh = true;
                        com.kwad.sdk.core.c.b.LW();
                        com.kwad.sdk.a.a.a.b.J(com.kwad.sdk.core.c.b.getCurrentActivity());
                        c.this.bz(adTemplateHj);
                    } catch (Throwable th) {
                        com.kwad.components.core.d.a.reportSdkCaughtException(th);
                    }
                }
            });
        }
    }

    public static /* synthetic */ e a(c cVar, e eVar) {
        cVar.aHc = null;
        return null;
    }

    private static boolean bu(AdTemplate adTemplate) {
        String strJ;
        if (adTemplate == null) {
            return false;
        }
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        if (au.ax(ServiceProvider.getContext(), com.kwad.sdk.core.response.helper.a.aE(adInfoEO)) || (strJ = com.kwad.sdk.core.download.a.J(adInfoEO)) == null || TextUtils.isEmpty(strJ)) {
            return false;
        }
        return new File(strJ).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bz(final AdTemplate adTemplate) {
        a(adTemplate, (DialogInterface.OnDismissListener) null, new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.a.a.c.7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                try {
                    if (i == -1) {
                        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                        bVar.ee(29);
                        bVar.el(23);
                        com.kwad.sdk.core.adlog.c.e(adTemplate, null, bVar);
                        com.kwad.sdk.a.a.a.Hf();
                    } else {
                        if (i != -2) {
                            return;
                        }
                        c cVar = c.this;
                        c.k(adTemplate, 1);
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        by.runOnUiThreadDelay(new bi() { // from class: com.kwad.sdk.a.a.c.8
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                if (com.kwad.sdk.a.a.a.Hf()) {
                    c cVar = c.this;
                    c.k(adTemplate, 2);
                }
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final AdTemplate adTemplate, final boolean z) {
        by.runOnUiThread(new bi() { // from class: com.kwad.sdk.a.a.c.3
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                int iJF = com.kwad.sdk.core.config.e.JF();
                boolean z2 = z;
                if (z2 && iJF == 2) {
                    c.this.a(adTemplate, (DialogInterface.OnDismissListener) null, new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.a.a.c.3.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (i == -1) {
                                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                                bVar.ee(29);
                                bVar.el(23);
                                com.kwad.sdk.core.adlog.c.e(adTemplate, null, bVar);
                                com.kwad.sdk.a.a.a.Hf();
                                return;
                            }
                            if (i == -2) {
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                c cVar = c.this;
                                c.k(adTemplate, 1);
                            }
                        }
                    });
                } else {
                    c.this.a(adTemplate, z2, iJF, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.adlog.c.e(adTemplate, null, new com.kwad.sdk.core.adlog.c.b().ee(69).el(23).ep(i));
    }

    @Nullable
    public final AdTemplate Hm() {
        AdTemplate adTemplate = null;
        while (!this.aHf.isEmpty()) {
            AdTemplate adTemplatePop = this.aHf.pop();
            if (bu(adTemplatePop)) {
                adTemplate = adTemplatePop;
            }
        }
        if (adTemplate != null) {
            this.aHf.add(0, adTemplate);
        }
        return adTemplate;
    }

    @SuppressLint({"WrongConstant"})
    public final void Hn() {
        b.Hi().a(new b.a() { // from class: com.kwad.sdk.a.a.c.4
            @Override // com.kwad.sdk.a.a.b.a
            public final void Hk() {
                com.kwad.sdk.core.d.c.d("InstallTipsManager", "showInitDelayDialog failed");
            }

            @Override // com.kwad.sdk.a.a.b.a
            public final void hK() {
                by.runOnUiThreadDelay(new bi() { // from class: com.kwad.sdk.a.a.c.4.1
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        if (c.this.aHg) {
                            c.this.aHi = true;
                        } else {
                            c.this.Hp();
                        }
                    }
                }, com.kwad.sdk.core.config.e.JH());
            }
        });
    }

    public final void Ho() {
        bB(false);
        if (this.aHh || !this.aHi) {
            return;
        }
        by.runOnUiThreadDelay(new bi() { // from class: com.kwad.sdk.a.a.c.5
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                c.this.Hp();
            }
        }, 5000L);
    }

    public final void Hq() {
        this.aHc = null;
    }

    public final void bB(boolean z) {
        this.aHg = z;
    }

    public final void bv(AdTemplate adTemplate) {
        if (bu(adTemplate)) {
            this.aHf.add(adTemplate);
        }
    }

    public final void bw(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        this.aHf.remove(adTemplate);
    }

    public final void bx(final AdTemplate adTemplate) {
        int iIntValue;
        int iJE = com.kwad.sdk.core.config.e.JE();
        if (adTemplate == null || iJE <= 0) {
            return;
        }
        final AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        if (adTemplate.mAdScene.getAdStyle() == 0) {
            return;
        }
        String strValueOf = String.valueOf(com.kwad.sdk.core.response.helper.e.eY(adTemplate));
        if (this.aHd.containsKey(strValueOf)) {
            iIntValue = this.aHd.get(strValueOf).intValue();
            this.aHd.put(strValueOf, Integer.valueOf(iIntValue));
        } else {
            iIntValue = 0;
        }
        if (iIntValue > 0) {
            return;
        }
        i.schedule(new bi() { // from class: com.kwad.sdk.a.a.c.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                int i = adInfoEO.status;
                if (i == 12 || i == 10 || !y.hG(com.kwad.sdk.core.download.a.J(com.kwad.sdk.core.response.helper.e.eO(adTemplate)))) {
                    return;
                }
                c.this.f(adTemplate, true);
            }
        }, iJE, TimeUnit.SECONDS);
    }

    public final void by(final AdTemplate adTemplate) {
        int iIntValue;
        int iJR = com.kwad.sdk.core.config.e.JR();
        if (iJR < 0) {
            return;
        }
        final AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        String strValueOf = String.valueOf(adInfoEO.adBaseInfo.creativeId);
        if (this.aHe.containsKey(strValueOf)) {
            iIntValue = this.aHe.get(strValueOf).intValue();
            this.aHe.put(strValueOf, Integer.valueOf(iIntValue));
        } else {
            iIntValue = 0;
        }
        if (iIntValue > 0) {
            return;
        }
        i.schedule(new Runnable() { // from class: com.kwad.sdk.a.a.c.2
            @Override // java.lang.Runnable
            public final void run() {
                if (au.ay(ServiceProvider.getContext(), com.kwad.sdk.core.response.helper.a.aE(adInfoEO)) == 1) {
                    return;
                }
                c.this.f(adTemplate, false);
            }
        }, iJR, TimeUnit.SECONDS);
    }

    public final void dismiss() {
        com.kwad.sdk.a.a.a.Hf();
        e eVar = this.aHc;
        if (eVar != null) {
            eVar.dismiss();
            this.aHc = null;
        }
    }

    private c() {
        this.aHd = new HashMap();
        this.aHe = new HashMap();
        this.aHf = new Stack<>();
        this.aHg = false;
        this.aHh = false;
        this.aHi = false;
    }

    @UiThread
    private void b(final AdTemplate adTemplate, boolean z, boolean z2, boolean z3) {
        Context context;
        Context contextWrapContextIfNeed;
        com.kwad.sdk.core.c.b.LW();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        if (currentActivity == null || (context = ((f) ServiceProvider.get(f.class)).getContext()) == null || (contextWrapContextIfNeed = m.wrapContextIfNeed(context)) == null) {
            return;
        }
        e eVar = new e(contextWrapContextIfNeed, adTemplate, z, z2, z3);
        View viewFindViewById = currentActivity.getWindow().getDecorView().findViewById(R.id.content);
        if (viewFindViewById instanceof FrameLayout) {
            eVar.b((FrameLayout) viewFindViewById);
            this.aHc = eVar;
            a(adTemplate, z, z3);
        }
        if (z3) {
            com.kwad.sdk.core.c.b.LW();
            com.kwad.sdk.a.a.a.b.J(com.kwad.sdk.core.c.b.getCurrentActivity());
            by.runOnUiThreadDelay(new bi() { // from class: com.kwad.sdk.a.a.c.9
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    if (c.this.aHc != null) {
                        c.this.aHc.dismiss();
                        c.a(c.this, (e) null);
                        c cVar = c.this;
                        c.k(adTemplate, 2);
                    }
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void a(AdTemplate adTemplate, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnClickListener onClickListener) {
        if (com.kwad.sdk.a.a.a.pG()) {
            return;
        }
        com.kwad.sdk.core.c.b.LW();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        if (currentActivity != null && com.kwad.sdk.a.a.a.a(currentActivity, adTemplate, onDismissListener, onClickListener)) {
            a(adTemplate, true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:11:0x0011  */
    @MainThread
    public void a(AdTemplate adTemplate, boolean z, int i, boolean z2) {
        boolean z3;
        if (this.aHc != null || com.kwad.components.core.e.c.b.pG()) {
            return;
        }
        if (z) {
            z3 = i == 1;
        }
        b(adTemplate, z, z3, z2);
    }

    private void a(AdTemplate adTemplate, boolean z, boolean z2) {
        String strValueOf = String.valueOf(com.kwad.sdk.core.response.helper.e.eY(adTemplate));
        if (z) {
            b(this.aHd, strValueOf);
            com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
            if (z2) {
                bVar.el(23);
                bVar.ee(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED);
            } else {
                bVar.ee(92);
            }
            com.kwad.sdk.core.adlog.c.d(adTemplate, (JSONObject) null, bVar);
            return;
        }
        com.kwad.sdk.core.adlog.c.c(adTemplate, 93, (JSONObject) null);
        b(this.aHe, strValueOf);
    }

    private static void b(Map<String, Integer> map, String str) {
        if (map.containsKey(str)) {
            map.put(str, Integer.valueOf(map.get(str).intValue() + 1));
        } else {
            map.put(str, 1);
        }
    }
}
