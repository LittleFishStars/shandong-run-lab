package com.byazt.kk;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID, 13})
public class tt {

    public interface c {
        void c(com.byazt.va.uj ujVar, com.byazt.hm.tt ttVar);

        void c(com.byazt.va.uj ujVar, IOException iOException);
    }

    public static void c(String str, File file, String str2, final c cVar) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.va.tt ttVarUj = com.byazt.mf.c.c().ve().uj();
        ttVarUj.c(str);
        ttVarUj.c(file.getAbsolutePath(), str2);
        ttVarUj.c(new com.byazt.mh.c() { // from class: com.byazt.kk.tt.1
            @Override // com.byazt.mh.c
            public void c(com.byazt.va.uj ujVar, com.byazt.hm.tt ttVar) {
                c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.c(ujVar, ttVar);
                }
            }

            @Override // com.byazt.mh.c
            public void c(com.byazt.va.uj ujVar, IOException iOException) {
                c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.c(ujVar, iOException);
                }
            }
        });
    }
}
