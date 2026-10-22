package com.byazt.jt;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_START_TIME, 54})
public class ve {
    public static final SparseArray<Object> c(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        com.byazt.rl.ve veVarC = com.byazt.rl.ve.c();
        if (mediationConfigUserInfoForSegment == null) {
            return null;
        }
        veVarC.c(265007, mediationConfigUserInfoForSegment.getCustomInfos());
        veVarC.c(265001, mediationConfigUserInfoForSegment.getUserId());
        veVarC.c(265002, mediationConfigUserInfoForSegment.getChannel());
        veVarC.c(265003, mediationConfigUserInfoForSegment.getSubChannel());
        veVarC.c(265004, mediationConfigUserInfoForSegment.getAge());
        veVarC.c(265005, mediationConfigUserInfoForSegment.getGender());
        veVarC.c(265006, mediationConfigUserInfoForSegment.getUserValueGroup());
        return veVarC.tt().sparseArray();
    }
}
