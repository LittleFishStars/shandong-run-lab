package cn.jy.ad.sdk.jyact;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface JYTD {
    void onActivityResult(int i, int i2, Intent intent);

    void onAfterCreate(Bundle bundle, Intent intent);

    void onAttachedToWindow();

    boolean onBackPressed();

    void onBeforeCreate(Bundle bundle, Intent intent);

    void onConfigurationChanged(Configuration configuration);

    void onDestroy();

    void onDetachedFromWindow();

    void onPause();

    void onRestart();

    void onRestoreInstanceState(Bundle bundle);

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void onStart();

    void onStop();

    void setActivity(Activity activity);
}
