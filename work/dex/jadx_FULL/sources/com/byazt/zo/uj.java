package com.byazt.zo;

import android.content.Context;
import com.byazt.ete.ic;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, 15})
public class uj {
    public final Map<Class, c> c = new HashMap();

    private <T extends c> T tt(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (Throwable unused) {
            try {
                Constructor<T> declaredConstructor = cls.getDeclaredConstructor(ic.class, Context.class);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(null, null);
            } catch (Throwable unused2) {
                return null;
            }
        }
    }

    public ve c(ic icVar, Context context, com.byazt.hkv.uj ujVar, boolean z) {
        ve veVar = new ve(ujVar);
        com.byazt.wdw.c cVar = new com.byazt.wdw.c(icVar, context);
        this.c.put(com.byazt.wdw.c.class, cVar);
        tt ttVar = new tt(icVar, context);
        this.c.put(tt.class, ttVar);
        com.byazt.nat.c cVarC = c(icVar, context);
        this.c.put(com.byazt.nat.c.class, cVarC);
        com.byazt.vis.c cVar2 = new com.byazt.vis.c(icVar, context);
        this.c.put(com.byazt.vis.c.class, cVar2);
        com.byazt.vis.ve veVar2 = new com.byazt.vis.ve(icVar, context);
        this.c.put(com.byazt.vis.ve.class, veVar2);
        veVar.c(veVar2);
        veVar.c(cVar);
        veVar.c(ttVar);
        if (icVar == null || icVar.h() != 1) {
            veVar.c(cVarC);
            veVar.c(cVar2);
        } else {
            veVar.c(cVar2);
            veVar.c(cVarC);
        }
        return veVar;
    }

    private com.byazt.nat.c c(ic icVar, Context context) {
        com.byazt.nat.ve veVar = new com.byazt.nat.ve();
        veVar.c(icVar);
        veVar.c(context);
        return veVar;
    }

    public <T extends c> T c(Class<T> cls) {
        T t = (T) this.c.get(cls);
        return t == null ? (T) tt(cls) : t;
    }
}
