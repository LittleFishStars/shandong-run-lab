package android.taobao.windvane.base;

import android.taobao.windvane.config.WMLWrapData;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public abstract class k {

    public interface a {
        void a(int i);

        void a(WMLWrapData wMLWrapData);

        void a(String str, String str2);
    }

    public void a(String str, a aVar) {
        aVar.a("-2", "ZCache not support");
    }

    public void a(String str, boolean z) {
    }

    public void a(Set<String> set) {
    }

    public boolean a(String str) {
        return false;
    }

    public void b(String str) {
    }

    public void c(String str) {
    }

    public void d(String str) {
    }
}
