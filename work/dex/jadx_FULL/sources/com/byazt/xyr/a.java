package com.byazt.xyr;

import android.content.Context;
import com.byazt.pm.sl;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FIND_STREAM_INFO_PROBE_DURATION, 34})
public class a extends com.byazt.ji.tt {
    public boolean sl;

    public a(Context context) {
        super(context);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001e  */
    /* JADX WARN: Code duplicated, block: B:18:0x0030  */
    @Override // com.byazt.ji.tt
    public boolean c(Object... objArr) {
        int iIntValue;
        int iIntValue2;
        Map<String, Object> map = this.n;
        if (map == null || map.isEmpty()) {
            return false;
        }
        if (objArr.length > 0) {
            Object obj = objArr[0];
            if (obj instanceof Integer) {
                iIntValue = ((Integer) obj).intValue();
            } else {
                iIntValue = -1;
            }
        } else {
            iIntValue = -1;
        }
        if (objArr.length > 1) {
            Object obj2 = objArr[1];
            if (obj2 instanceof Integer) {
                iIntValue2 = ((Integer) obj2).intValue();
            } else {
                iIntValue2 = -1;
            }
        } else {
            iIntValue2 = -1;
        }
        if (iIntValue <= 0) {
            this.sl = false;
        }
        if (this.n.containsKey("percent")) {
            Object obj3 = this.n.get("percent");
            float fC = com.byazt.cd.ve.c(obj3 != null ? String.valueOf(obj3) : "", -1.0f);
            if (fC >= 0.0f) {
                if (iIntValue >= (fC / 100.0f) * iIntValue2 && !this.sl) {
                    this.sl = true;
                    sl slVar = this.c;
                    if (slVar != null) {
                        slVar.c(this.tt, this.f28697a, this.ve.tt(), this.ve);
                    }
                }
            }
        } else {
            Object obj4 = this.n.get("interval");
            if (iIntValue >= com.byazt.cd.ve.c(obj4 != null ? String.valueOf(obj4) : "", -1) && !this.sl) {
                this.sl = true;
                sl slVar2 = this.c;
                if (slVar2 != null) {
                    slVar2.c(this.tt, this.f28697a, this.ve.tt(), this.ve);
                }
            }
        }
        return true;
    }
}
