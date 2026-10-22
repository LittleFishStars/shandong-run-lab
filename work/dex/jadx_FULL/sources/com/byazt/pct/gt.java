package com.byazt.pct;

import android.net.Uri;
import com.alibaba.android.arouter.utils.Consts;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 124, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO})
public class gt {
    public final Set<String> c;
    public sl.tt n;
    public final Set<String> tt;
    public final rl uj;
    public final qy ve = nu.c;

    public gt(rl rlVar, Set<String> set, Set<String> set2) {
        this.uj = rlVar;
        if (set == null || set.isEmpty()) {
            this.c = new LinkedHashSet();
        } else {
            this.c = new LinkedHashSet(set);
        }
        if (set2 == null || set2.isEmpty()) {
            this.tt = new LinkedHashSet();
        } else {
            this.tt = new LinkedHashSet(set2);
        }
    }

    public final synchronized gu c(boolean z, String str, tt ttVar) throws rl.c {
        sl.tt ttVar2;
        Uri uri = Uri.parse(str);
        String host = uri.getHost();
        if (host == null) {
            return null;
        }
        gu guVar = this.tt.contains(ttVar.c()) ? gu.PUBLIC : null;
        for (String str2 : this.c) {
            if (uri.getHost().equals(str2) || host.endsWith(Consts.DOT.concat(String.valueOf(str2)))) {
                guVar = gu.PRIVATE;
                break;
            }
        }
        if (guVar == null && (ttVar2 = this.n) != null && ttVar2.c(str)) {
            if (this.n.c(str, ttVar.c())) {
                return null;
            }
            guVar = gu.PRIVATE;
        }
        gu guVarC = z ? c(str, ttVar) : tt(str, ttVar);
        return guVarC != null ? guVarC : guVar;
    }

    public final synchronized gu tt(String str, tt ttVar) {
        return c(str, ttVar, false);
    }

    public void tt(qy.c cVar) {
        qy qyVar = this.ve;
        if (qyVar != null) {
            qyVar.tt(cVar);
        }
    }

    public final synchronized gu c(String str, tt ttVar) throws rl.c {
        return c(str, ttVar, true);
    }

    public void c(sl.tt ttVar) {
        this.n = ttVar;
    }

    public void c(qy.c cVar) {
        qy qyVar = this.ve;
        if (qyVar != null) {
            qyVar.c(cVar);
        }
    }

    private gu c(String str, tt ttVar, boolean z) {
        rl rlVar;
        if (!z || (rlVar = this.uj) == null) {
            return null;
        }
        rl.ve veVarC = rlVar.c(str, this.c);
        if (veVarC.ve.contains(ttVar.c())) {
            return null;
        }
        if (veVarC.tt.contains(ttVar.c())) {
            return gu.PRIVATE;
        }
        if (veVarC.c.compareTo(ttVar.tt()) < 0) {
            return null;
        }
        return veVarC.c;
    }
}
