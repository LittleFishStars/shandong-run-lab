package com.byazt.lj;

import android.util.SparseArray;
import com.byazt.it.n;
import com.byazt.nr.gr;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.yxi.uj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SCFG_ADDRESS, 54})
public class ve implements Function<SparseArray<Object>, Object> {
    public static Function<SparseArray<Object>, Object> c;

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SCFG_ADDRESS, 24})
    public static class c {
        public static final ve c = new ve();
    }

    private static void c() {
        if (c == null) {
            return;
        }
        gr.c().c(true);
        gr.c().c(new gr.c() { // from class: com.byazt.lj.ve.1
            @Override // com.byazt.nr.gr.c
            public void c(int i, Map<String, Object> map) {
                if (map != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        for (String str : map.keySet()) {
                            jSONObject.put(str, map.get(str));
                        }
                        ve.notifyCommonEvent(1, jSONObject);
                    } catch (Exception e) {
                        m.c(e);
                    }
                }
            }
        });
    }

    public static ve getInstance() {
        return c.c;
    }

    public static void notifyCommonEvent(int i, JSONObject jSONObject) {
        if (c != null) {
            uj ujVarC = uj.c();
            ujVarC.c(10005).c(Void.class);
            ujVarC.c(20004, Integer.valueOf(i));
            ujVarC.c(20005, jSONObject);
            c.apply(ujVarC.tt());
        }
    }

    public static void reportEvent(com.byazt.fo.c cVar) {
        if (c != null) {
            uj ujVarC = uj.c();
            ujVarC.c(10001).c(Void.class);
            ujVarC.c(20001, cVar.sp());
            c.apply(ujVarC.tt());
        }
    }

    public static void setQATool(Function<SparseArray<Object>, Object> function) {
        c = function;
        c();
    }

    private ve() {
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
        if (pluginValueSetTt.intValue(-99999987) != 10003) {
            return null;
        }
        c((Map) pluginValueSetTt.objectValue(20003, Map.class));
        return null;
    }

    private void c(Map<String, String> map) {
        n nVar = gt.tt().f28865a;
        if (map == null || nVar == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            nVar.put(key + "_qa_modify_setting", entry.getValue());
        }
    }
}
