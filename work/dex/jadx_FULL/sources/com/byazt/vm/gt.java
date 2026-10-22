package com.byazt.vm;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kc.openset.constant.DeviceIdType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 165, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO})
public final class gt {
    public final SharedPreferences c;

    @WorkerThread
    public gt(Context context) {
        this.c = com.byazt.nys.tt.tt(context, "device_register_oaid_refine", 0);
    }

    @WorkerThread
    public void c(@Nullable my myVar) {
        if (myVar == null) {
            return;
        }
        this.c.edit().putString(DeviceIdType.OAID, myVar.tt().toString()).apply();
    }

    @Nullable
    @WorkerThread
    public my c() {
        return my.c(this.c.getString(DeviceIdType.OAID, ""));
    }
}
