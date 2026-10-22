package com.alibaba.analytics.core.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Deprecated
public class b implements d.a {
    @Override // com.alibaba.analytics.core.a.d.a
    public void c(String str, String str2) {
        boolean z;
        if ("sw_plugin".equalsIgnoreCase(str)) {
            try {
                z = Boolean.parseBoolean(str2);
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            if (z) {
                com.alibaba.analytics.core.d.a().m117i();
            }
        }
    }
}
