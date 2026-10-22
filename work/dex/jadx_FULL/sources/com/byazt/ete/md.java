package com.byazt.ete;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF})
public class md {
    public List<ir> c;

    public md(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        this.c = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            this.c.add(new ir(jSONArray.optJSONObject(i), 4));
        }
    }

    public static List<ir> c(ic icVar) {
        md mdVarZr;
        if (icVar == null || (mdVarZr = icVar.zr()) == null) {
            return null;
        }
        return mdVarZr.c;
    }

    public static boolean n(ic icVar) {
        return (icVar == null || ic.ve(icVar) || com.byazt.omf.gt.tt().iw() || !tt(icVar) || ve(icVar) == null) ? false : true;
    }

    public static boolean tt(ic icVar) {
        md mdVarZr;
        List<ir> list;
        return (icVar == null || (mdVarZr = icVar.zr()) == null || (list = mdVarZr.c) == null || list.isEmpty()) ? false : true;
    }

    public static List<ir> uj(ic icVar) {
        List<ir> listC;
        if (!tt(icVar) || (listC = c(icVar)) == null || listC.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ir irVar : listC) {
            if (irVar != null && irVar.t() && irVar.sp() == 0) {
                arrayList.add(irVar);
            }
        }
        return arrayList;
    }

    public static ir ve(ic icVar) {
        List<ir> listC;
        if (tt(icVar) && (listC = c(icVar)) != null && !listC.isEmpty()) {
            for (ir irVar : listC) {
                if (irVar != null && irVar.t()) {
                    boolean z = irVar.uj() == 1;
                    if (1 == irVar.sp() && z) {
                        return irVar;
                    }
                }
            }
        }
        return null;
    }
}
