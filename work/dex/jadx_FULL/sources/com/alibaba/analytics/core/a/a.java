package com.alibaba.analytics.core.a;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.analytics.a.x;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements d.a {
    public a() {
        k(d.a().get("audid"));
    }

    private void a(final Context context, final boolean z) {
        x.a().submit(new Runnable() { // from class: com.alibaba.analytics.core.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    File fileStreamPath = context.getFileStreamPath("3c9b584e65e6c983");
                    if (fileStreamPath.exists()) {
                        if (!z) {
                            fileStreamPath.delete();
                        }
                    } else if (z) {
                        fileStreamPath.createNewFile();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    private void k(String str) {
        com.alibaba.analytics.a.j.d("AudidConfigListener", "parseConfig value", str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("0".equalsIgnoreCase(str)) {
            a(com.alibaba.analytics.core.d.a().getContext(), true);
        } else {
            a(com.alibaba.analytics.core.d.a().getContext(), false);
        }
    }

    @Override // com.alibaba.analytics.core.a.d.a
    public void c(String str, String str2) {
        k(str2);
    }
}
