package com.kwad.components.core.proxy.launchdialog;

import android.app.Application;
import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e {
    private static e aji = new e();
    private List<b> ajj = new CopyOnWriteArrayList();
    private a ajk;
    private com.kwad.components.core.proxy.b ajl;

    public e() {
        a aVar = new a();
        this.ajk = aVar;
        this.ajl = new com.kwad.components.core.proxy.b(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.e(adTemplate, null, new com.kwad.sdk.core.adlog.c.b().ee(MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT).el(25));
        long jEY = com.kwad.sdk.core.response.helper.e.eY(adTemplate);
        Iterator<b> it = this.ajj.iterator();
        while (it.hasNext()) {
            it.next().b(jEY, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bc(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.e(adTemplate, null, new com.kwad.sdk.core.adlog.c.b().ee(231).el(25));
        long jEY = com.kwad.sdk.core.response.helper.e.eY(adTemplate);
        Iterator<b> it = this.ajj.iterator();
        while (it.hasNext()) {
            it.next().b(jEY, 3);
        }
    }

    public static e vJ() {
        return aji;
    }

    public final void ba(final AdTemplate adTemplate) {
        n(this.ajk.vD());
        vJ().a(DetectEventType.USER_CANCEL, new f() { // from class: com.kwad.components.core.proxy.launchdialog.e.1
            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void j(com.kwad.components.core.proxy.a aVar) {
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CANCEL PageLaunchDialogManager onContinue");
            }

            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void k(com.kwad.components.core.proxy.a aVar) {
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CANCEL PageLaunchDialogManager onComplete");
                e.this.bc(adTemplate);
                e.this.n(aVar);
            }

            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void l(com.kwad.components.core.proxy.a aVar) {
                e.this.n(aVar);
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CANCEL PageLaunchDialogManager onTimeout");
            }

            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void m(com.kwad.components.core.proxy.a aVar) {
                e.this.n(aVar);
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CANCEL PageLaunchDialogManager onNotMatch");
            }
        });
        vJ().a(DetectEventType.USER_CONFIRM, new f() { // from class: com.kwad.components.core.proxy.launchdialog.e.2
            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void j(com.kwad.components.core.proxy.a aVar) {
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CONFIRM PageLaunchDialogManager onContinue");
            }

            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void k(com.kwad.components.core.proxy.a aVar) {
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CONFIRM PageLaunchDialogManager onComplete");
                e.this.bb(adTemplate);
                e.this.n(aVar);
            }

            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void l(com.kwad.components.core.proxy.a aVar) {
                e.this.n(aVar);
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CONFIRM PageLaunchDialogManager onTimeout");
            }

            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void m(com.kwad.components.core.proxy.a aVar) {
                e.this.n(aVar);
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CONFIRM PageLaunchDialogManager onNotMatch");
            }
        });
        long jEY = com.kwad.sdk.core.response.helper.e.eY(adTemplate);
        Iterator<b> it = this.ajj.iterator();
        while (it.hasNext()) {
            it.next().b(jEY, 1);
        }
    }

    public final void init(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(this.ajl);
        }
    }

    public final void n(com.kwad.components.core.proxy.a aVar) {
        this.ajk.i(aVar);
        this.ajk.h(aVar);
    }

    public final void a(b bVar) {
        if (bVar != null) {
            this.ajj.add(bVar);
        }
    }

    public final void b(b bVar) {
        if (bVar != null) {
            this.ajj.remove(bVar);
        }
    }

    private void a(DetectEventType detectEventType, f fVar) {
        c cVarA = this.ajk.a(detectEventType);
        if (cVarA != null) {
            cVarA.a(fVar);
            cVarA.start();
        }
    }
}
