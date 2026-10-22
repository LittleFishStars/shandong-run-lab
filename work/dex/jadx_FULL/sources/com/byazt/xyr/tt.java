package com.byazt.xyr;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.pm.sl;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FIND_STREAM_INFO_PROBE_DURATION, 13})
public class tt extends com.byazt.ji.tt {
    public boolean sl;

    public tt(Context context) {
        super(context);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001b  */
    /* JADX WARN: Code duplicated, block: B:18:0x002d  */
    /* JADX WARN: Code duplicated, block: B:24:0x003f  */
    @Override // com.byazt.ji.tt
    public boolean c(Object... objArr) {
        String str;
        int iIntValue;
        int iIntValue2;
        int iC;
        Object obj;
        Map<String, Object> map = this.n;
        int iC2 = 0;
        if (map == null || map.isEmpty()) {
            return false;
        }
        if (objArr.length > 0) {
            Object obj2 = objArr[0];
            if (obj2 instanceof String) {
                str = (String) obj2;
            } else {
                str = "";
            }
        } else {
            str = "";
        }
        if (objArr.length > 1) {
            Object obj3 = objArr[1];
            if (obj3 instanceof Integer) {
                iIntValue = ((Integer) obj3).intValue();
            } else {
                iIntValue = 0;
            }
        } else {
            iIntValue = 0;
        }
        if (objArr.length > 2) {
            Object obj4 = objArr[2];
            if (obj4 instanceof Integer) {
                iIntValue2 = ((Integer) obj4).intValue();
            } else {
                iIntValue2 = 0;
            }
        } else {
            iIntValue2 = 0;
        }
        if (!TextUtils.equals((!this.n.containsKey("id") || (obj = this.n.get("id")) == null) ? "" : String.valueOf(obj), str)) {
            return false;
        }
        if (this.n.containsKey("state")) {
            Object obj5 = this.n.get("state");
            iC = com.byazt.cd.ve.c(obj5 != null ? String.valueOf(obj5) : "", 0);
        } else {
            iC = 0;
        }
        if (iC != iIntValue) {
            return false;
        }
        if (this.n.containsKey("repeat")) {
            Object obj6 = this.n.get("repeat");
            iC2 = com.byazt.cd.ve.c(obj6 != null ? String.valueOf(obj6) : "", 0);
        }
        if (iC != 1) {
            if (iC == 2) {
                float fC = 0.0f;
                if (this.n.containsKey("percent")) {
                    Object obj7 = this.n.get("percent");
                    fC = com.byazt.cd.ve.c(obj7 != null ? String.valueOf(obj7) : "", 0.0f);
                }
                if (iIntValue2 >= fC && (iC2 == 1 || !this.sl)) {
                    this.sl = true;
                    sl slVar = this.c;
                    if (slVar != null) {
                        slVar.c(this.tt, this.f28697a, this.ve.tt(), this.ve);
                    }
                }
            }
        } else if (iC2 == 1 || !this.sl) {
            this.sl = true;
            sl slVar2 = this.c;
            if (slVar2 != null) {
                slVar2.c(this.tt, this.f28697a, this.ve.tt(), this.ve);
            }
        }
        return true;
    }
}
