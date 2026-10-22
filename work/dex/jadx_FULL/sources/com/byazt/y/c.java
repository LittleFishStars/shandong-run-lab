package com.byazt.y;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.byazt.ev.n;
import com.byazt.p.uj;
import com.byazt.zz.ve;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huachenjie.common.constants.UserConstants;
import com.igexin.assist.util.AssistUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AE_SRC_LUFS, 20})
public class c extends Fragment {
    private Intent a() {
        Context contextN = n();
        if (contextN == null) {
            return null;
        }
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        String packageName = contextN.getPackageName();
        intent.putExtra("package", packageName);
        intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
        intent.putExtra("app_package", packageName);
        int i = contextN.getApplicationInfo().uid;
        intent.putExtra(UserConstants.URL_PARAMS.b, i);
        intent.putExtra("app_uid", i);
        return intent;
    }

    private Context n() {
        Context contextIc = ve.ic();
        return (contextIc != null || getActivity() == null || getActivity().isFinishing()) ? contextIc : getActivity().getApplicationContext();
    }

    public static Intent uj() {
        return new Intent("android.settings.APPLICATION_SETTINGS");
    }

    public void c() {
        try {
            try {
                try {
                    startActivityForResult(a(), 1000);
                } catch (Throwable unused) {
                    startActivityForResult(ve(), 1000);
                }
            } catch (Throwable unused2) {
                startActivityForResult(uj(), 1000);
            }
        } catch (Throwable unused3) {
            startActivityForResult(tt(), 1000);
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (uj.c()) {
            uj.c(true);
        } else {
            uj.c(false);
        }
    }

    public Intent tt() {
        Context contextN = n();
        if (contextN == null) {
            return null;
        }
        String packageName = contextN.getPackageName();
        String str = Build.MANUFACTURER;
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.contains(n.ve)) {
                Intent intent = new Intent();
                intent.putExtra(ALPParamConstant.PACKAGENAME, packageName);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                return intent;
            }
            if (lowerCase.contains("vivo")) {
                Intent intent2 = new Intent();
                intent2.putExtra("packagename", packageName);
                intent2.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
                return intent2;
            }
            lowerCase.contains(AssistUtils.BRAND_MZ);
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + contextN.getPackageName()));
    }

    public Intent ve() {
        Context contextN = n();
        if (contextN == null) {
            return null;
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + contextN.getPackageName()));
    }
}
