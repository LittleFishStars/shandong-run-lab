package com.byazt.or;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.FileTypes;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 579, 72})
public class da {

    public enum c {
        HTML("text/html"),
        CSS("text/css"),
        JS("application/x-javascript"),
        IMAGE("image/*");

        public String n;

        c(String str) {
            this.n = str;
        }

        public String getType() {
            return this.n;
        }
    }

    public static c c(String str) {
        c cVar = c.IMAGE;
        if (!TextUtils.isEmpty(str)) {
            try {
                String path = Uri.parse(str).getPath();
                if (path != null) {
                    if (path.endsWith(".css")) {
                        cVar = c.CSS;
                    } else if (path.endsWith(".js")) {
                        cVar = c.JS;
                    } else if (!path.endsWith(FileTypes.F) && !path.endsWith(".gif") && !path.endsWith(".png") && !path.endsWith(".jpeg") && !path.endsWith(".webp") && !path.endsWith(".bmp") && !path.endsWith(".ico") && path.endsWith(".html")) {
                        cVar = c.HTML;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return cVar;
    }

    public static boolean tt(String str) {
        Uri uri;
        if (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null) {
            return false;
        }
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return path.endsWith(".gif");
    }
}
