package com.huachenjie.im.page.base;

import android.view.View;
import android.widget.TextView;
import com.zj.adlib.fv5;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface InputPanelCallback {
    void a(String str);

    default void b(View view) {
    }

    default boolean c() {
        return false;
    }

    default void d(String str) {
        fv5.b("当前界面不支持发送自定义表情哦！");
    }

    void e(File file, long j);

    default void f(String str, TextView textView) {
    }

    void g(String str);

    default int h() {
        return 1;
    }

    default boolean i() {
        return true;
    }
}
