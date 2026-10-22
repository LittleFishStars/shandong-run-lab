package com.byazt.gc;

import android.text.TextUtils;
import com.byazt.ha.ve;
import com.byazt.ip.n;
import com.byazt.qcl.tt;
import com.byazt.qcl.uj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 20})
public class c {
    public static void c(Map<String, Object> map, String str) {
        ve veVar;
        List<tt> list;
        if (map == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.ip.tt context = n.c(1).getContext(str);
        if (!(context instanceof ve) || (list = (veVar = (ve) context).f28600a) == null || list.isEmpty()) {
            return;
        }
        map.put("node_line", uj.c(list));
        map.put("node_line_detail", uj.tt(list));
        map.put("unexpected_type", Integer.valueOf(veVar.da));
        if (!TextUtils.isEmpty(veVar.c())) {
            map.put("ad_show_id", veVar.c());
        }
        if (TextUtils.isEmpty(veVar.c)) {
            return;
        }
        map.put("ad_load_id", veVar.c);
    }
}
