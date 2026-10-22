package com.alibaba.alibcprotocol.container.callback;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface AlibcComponentViewHolder {
    View getContentView();

    Bundle getRestoreBundle();

    void onActivityResult(int i, int i2, Intent intent);

    void onDestroy();

    void onPause();

    void onResume();

    void onStop();
}
