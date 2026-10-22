package com.beizi.fusion;

import android.view.View;
import com.beizi.ad.lance.ApkBean;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface mi {

    public enum a {
        CONTENT,
        APP_INSTALL
    }

    on.e a();

    void a(int i);

    void a(View view, String str, String str2, String str3, String str4, int i, ji jiVar);

    boolean a(View view, ji jiVar);

    boolean a(View view, oi oiVar);

    boolean a(View view, List list, ji jiVar);

    String b();

    void b(int i);

    String c();

    String d();

    void destroy();

    String e();

    boolean f();

    String g();

    String getAppName();

    String getIconUrl();

    String getImageUrl();

    boolean h();

    String i();

    ArrayList j();

    String k();

    ArrayList l();

    int m();

    on.e n();

    int o();

    ApkBean p();

    String q();
}
