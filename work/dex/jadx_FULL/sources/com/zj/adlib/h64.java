package com.zj.adlib;

import android.view.View;
import androidx.coroutines.BindingAdapter;
import com.huachenjie.im.view.PublishAudioView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class h64 {
    @BindingAdapter(requireAll = false, value = {"audioPath", "audioBubble", "audioDuration", "showAudioDelete", "audioCanClick", "audioCenter", "audioDefault"})
    public static void a(View view, String str, String str2, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        if (view instanceof PublishAudioView) {
            ((PublishAudioView) view).setData(str, str2, i, z, z2, z3, z4);
        }
    }
}
