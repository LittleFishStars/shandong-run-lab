package com.byazt.nr;

import android.content.Context;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 91})
public final class sp {
    public static File c(Context context, boolean z, String str) {
        File fileC;
        if (context == null || (fileC = com.byazt.nys.tt.c(context)) == null) {
            return null;
        }
        if (!z || TextUtils.isEmpty(str)) {
            return fileC;
        }
        return new File(fileC.getParent(), fileC.getName() + LoginConstants.UNDER_LINE + str);
    }

    public static File tt(Context context, boolean z, String str) {
        File fileTt;
        if (context == null || (fileTt = com.byazt.nys.tt.tt(context)) == null) {
            return null;
        }
        if (!z || TextUtils.isEmpty(str)) {
            return fileTt;
        }
        return new File(fileTt.getParent(), fileTt.getName() + LoginConstants.UNDER_LINE + str);
    }

    public static File uj(Context context, boolean z, String str) {
        File fileVe;
        if (context == null || (fileVe = com.byazt.nys.tt.ve(context)) == null) {
            return null;
        }
        if (!z || TextUtils.isEmpty(str)) {
            return fileVe;
        }
        return new File(fileVe.getParent(), fileVe.getName() + LoginConstants.UNDER_LINE + str);
    }

    public static File ve(Context context, boolean z, String str) {
        return c(context, null, z, str);
    }

    public static File c(Context context, String str, boolean z, String str2) {
        File fileC;
        if (context == null || (fileC = com.byazt.nys.tt.c(context, str)) == null) {
            return null;
        }
        if (!z || TextUtils.isEmpty(str2)) {
            return fileC;
        }
        return new File(fileC.getParent(), fileC.getName() + LoginConstants.UNDER_LINE + str2);
    }
}
