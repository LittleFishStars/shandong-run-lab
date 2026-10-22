package com.byazt.cty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import androidx.annotation.Nullable;
import com.byazt.aas.nb;
import com.byazt.ete.ic;
import com.byazt.nr.m;
import com.byazt.omf.rl;
import com.byazt.ukr.yp;
import com.byazt.zqa.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE, 310})
public class BaseThemeActivity extends Activity {
    public ic qp;

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Window window;
        super.onCreate(bundle);
        ic icVarTt = nb.tt(getIntent());
        this.qp = icVarTt;
        if (icVarTt == null) {
            m.tt("BaseLandingPageActivity", "物料为空,退出落地页!");
            yp.c().c("meta_null", (Throwable) null);
        } else {
            if (!icVarTt.d() || (window = getWindow()) == null) {
                return;
            }
            window.addFlags(512);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        String stringExtra;
        super.onDestroy();
        Intent intent = getIntent();
        if (intent == null || (stringExtra = intent.getStringExtra("multi_process_materialmeta_key")) == null) {
            return;
        }
        rl.tt(stringExtra, ic.class);
    }
}
