package com.byazt.vm;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 165, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public final class gr extends ve<com.byazt.fp.tt> {
    public gr() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // com.byazt.vm.ve
    public zm.tt<com.byazt.fp.tt, String> c() {
        return new zm.tt<com.byazt.fp.tt, String>() { // from class: com.byazt.vm.gr.1
            @Override // com.byazt.vm.zm.tt
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public com.byazt.fp.tt tt(IBinder iBinder) {
                return com.byazt.fp.tt.c.c(iBinder);
            }

            @Override // com.byazt.vm.zm.tt
            public String c(com.byazt.fp.tt ttVar) throws Exception {
                return ttVar.c();
            }
        };
    }

    @Override // com.byazt.vm.ve
    public Intent c(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return intent;
    }
}
