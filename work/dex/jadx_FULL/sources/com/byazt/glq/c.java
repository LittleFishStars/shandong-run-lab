package com.byazt.glq;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.NativeModel;
import com.byazt.ddx.uj;
import com.byazt.ddx.x;
import com.byazt.eia.i;
import com.byazt.nr.m;
import com.byazt.omf.p;
import com.byazt.omf.rh;
import com.byazt.ppf.ve;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NOTIFY_SEI_IMMEDIATELY_BEFORE_FIRSTFRAME, 20})
public class c {
    public String c = "";

    public c c(String str) {
        this.c = str;
        return this;
    }

    public void c(final Context context, final Map<String, Object> map, final i iVar) {
        if (iVar == null || iVar.yp() == null) {
            return;
        }
        final String strTt = iVar.yp().tt();
        if (TextUtils.isEmpty(strTt)) {
            return;
        }
        rh.a().postDelayed(new Runnable() { // from class: com.byazt.glq.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(strTt));
                    intent.addFlags(268435456);
                    HashMap map2 = new HashMap();
                    map2.put("source", "LiveDoubleOpenProcessor");
                    map2.put(NativeModel.JSON_KEY_SCHEME, strTt);
                    uj.c(ve.c(iVar, (Map<String, Object>) map), c.this.c, (Map<String, Object>) map2, false);
                    com.byazt.nr.tt.c(context, intent, new com.byazt.nr.tt.c() { // from class: com.byazt.glq.c.1.1
                        @Override // com.byazt.nr.tt.c
                        public void c() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            uj.c(ve.c(iVar, (Map<String, Object>) map), c.this.c, (Throwable) null, false, true);
                            x xVarC = x.c();
                            AnonymousClass1 anonymousClass2 = AnonymousClass1.this;
                            xVarC.c(ve.c(iVar, (Map<String, Object>) map), c.this.c, false, false, null);
                        }

                        @Override // com.byazt.nr.tt.c
                        public void c(Throwable th) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            uj.c(ve.c(iVar, (Map<String, Object>) map), c.this.c, th, false, false);
                        }
                    }, TextUtils.equals(p.x, "internal"));
                } catch (Throwable th) {
                    m.c(th);
                }
            }
        }, 50L);
    }
}
