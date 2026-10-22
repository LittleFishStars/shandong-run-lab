package cj.mobile.wm.common;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface WMAdActListener {
    void adOnActivityResult(int i, int i2, Intent intent);

    void adOnConfigurationChanged(Configuration configuration);

    boolean adOnKeyDown(int i, KeyEvent keyEvent);

    Resources getAdResources();

    void onAdCreate(Bundle bundle);

    void onAdDestroy();

    void onAdPause();

    void onAdRestart();

    void onAdResume();

    void onAdStart();

    void onAdStop();
}
