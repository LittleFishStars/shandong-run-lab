package com.zj.adlib;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import cn.hzjizhun.admin.ad.bean.JZUnifiedAdInfo;
import com.huachenjie.ad.impl.JzAdLoader;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ip4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile ip4 f42412a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AtomicBoolean f17250a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public JZUnifiedAdInfo f17249a = null;

    public class a extends pi4 {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ pi4 f17251a;

        public a(pi4 pi4Var) {
            this.f17251a = pi4Var;
        }

        @Override // com.zj.adlib.pi4
        public void b() {
            ip4.this.f17250a.set(false);
        }

        @Override // com.zj.adlib.pi4
        public void c(JZUnifiedAdInfo jZUnifiedAdInfo) {
            ip4.this.e(jZUnifiedAdInfo);
            ip4.this.f17250a.set(false);
            pi4 pi4Var = this.f17251a;
            if (pi4Var != null) {
                pi4Var.c(jZUnifiedAdInfo);
            }
        }
    }

    public static ip4 b() {
        if (f42412a == null) {
            synchronized (ip4.class) {
                if (f42412a == null) {
                    f42412a = new ip4();
                }
            }
        }
        return f42412a;
    }

    @Nullable
    public JZUnifiedAdInfo c() {
        return this.f17249a;
    }

    public void d(FragmentActivity fragmentActivity, pi4 pi4Var) {
        JzAdLoader jzAdLoaderF = ew.f();
        if (jzAdLoaderF == null || this.f17250a.get() || this.f17249a != null) {
            return;
        }
        this.f17250a.set(true);
        jzAdLoaderF.i(fragmentActivity, hp4.g, new a(pi4Var));
    }

    public void e(JZUnifiedAdInfo jZUnifiedAdInfo) {
        this.f17249a = jZUnifiedAdInfo;
    }
}
