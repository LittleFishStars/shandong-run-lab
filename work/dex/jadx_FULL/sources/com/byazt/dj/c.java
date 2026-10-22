package com.byazt.dj;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, 20})
public class c {
    public final PluginValueSet c;

    public c(SparseArray<Object> sparseArray) {
        this.c = com.byazt.rl.c.c(sparseArray).tt();
    }

    public int a() {
        return this.c.intValue(261006);
    }

    public String c() {
        return (String) this.c.objectValue(261001, String.class);
    }

    public boolean da() {
        return this.c.booleanValue(261011);
    }

    public int[] i() {
        return (int[]) this.c.objectValue(261009, int[].class);
    }

    public boolean m() {
        return this.c.booleanValue(261017);
    }

    public String n() {
        return (String) this.c.objectValue(261005, String.class);
    }

    public Map<String, Object> nu() {
        return (Map) this.c.objectValue(261018, Map.class);
    }

    public Function<SparseArray<Object>, Object> rh() {
        Map<String, Object> mapNu = nu();
        if (mapNu != null && !mapNu.isEmpty()) {
            Object obj = mapNu.get("qa_common_tool");
            if (obj instanceof Function) {
                return (Function) obj;
            }
        }
        return null;
    }

    public uj sl() {
        SparseArray sparseArray = (SparseArray) this.c.objectValue(261012, SparseArray.class);
        if (sparseArray != null) {
            return new uj(sparseArray);
        }
        return null;
    }

    public boolean sp() {
        return this.c.booleanValue(261007);
    }

    public int t() {
        return this.c.intValue(261013);
    }

    public String tt() {
        return (String) this.c.objectValue(261002, String.class);
    }

    public int u() {
        return this.c.intValue(261014);
    }

    public String uj() {
        return (String) this.c.objectValue(261004, String.class);
    }

    public boolean ve() {
        return this.c.booleanValue(261003);
    }

    public boolean x() {
        return this.c.booleanValue(261008);
    }

    public int yp() {
        return this.c.intValue(261015);
    }

    public com.byazt.je.c z() {
        SparseArray sparseArray = (SparseArray) this.c.objectValue(261016, SparseArray.class);
        if (sparseArray != null) {
            return new com.byazt.je.c(sparseArray);
        }
        return null;
    }
}
