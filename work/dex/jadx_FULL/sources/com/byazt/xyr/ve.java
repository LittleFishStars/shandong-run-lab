package com.byazt.xyr;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.pm.sl;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FIND_STREAM_INFO_PROBE_DURATION, 54})
public class ve extends com.byazt.ji.tt {
    public String sl;

    public ve(Context context) {
        super(context);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001d  */
    /* JADX WARN: Code duplicated, block: B:7:0x000f  */
    @Override // com.byazt.ji.tt
    public boolean c(Object... objArr) {
        String str;
        String str2;
        if (objArr.length > 0) {
            Object obj = objArr[0];
            if (obj instanceof String) {
                str = (String) obj;
            } else {
                str = "";
            }
        } else {
            str = "";
        }
        if (objArr.length > 1) {
            Object obj2 = objArr[1];
            if (obj2 instanceof String) {
                str2 = (String) obj2;
            } else {
                str2 = "";
            }
        } else {
            str2 = "";
        }
        Map<String, Object> map = this.n;
        if (map != null && map.size() > 0) {
            Object obj3 = this.n.get("id");
            String strValueOf = obj3 != null ? String.valueOf(obj3) : "";
            Object obj4 = this.n.get("state");
            this.sl = obj4 != null ? String.valueOf(obj4) : "";
            if (TextUtils.isEmpty(strValueOf)) {
                return false;
            }
            com.byazt.xj.ve veVar = this.tt;
            if (veVar.tt(veVar) != null && TextUtils.equals(str, strValueOf) && TextUtils.equals(str2, this.sl)) {
                sl slVar = this.c;
                if (slVar != null) {
                    slVar.c(this.tt, this.f28697a, this.ve.tt(), this.ve);
                }
                return true;
            }
        }
        return false;
    }
}
