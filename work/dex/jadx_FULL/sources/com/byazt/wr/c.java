package com.byazt.wr;

import com.aliyun.auth.common.AliyunVodHttpCommon;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1361, 20})
public class c implements com.byazt.yy.c, com.byazt.yy.tt {
    public final com.byazt.iy.ve c;
    public final boolean tt = false;

    public c(com.byazt.iy.ve veVar) {
        this.c = veVar;
    }

    @Override // com.byazt.yy.c
    public Map<String, Object> c(File file) {
        if (file.getName().endsWith(".prop")) {
            return new tt(this.c, this.tt).c(file);
        }
        File file2 = new File(file.getParent(), file.getName() + ".prop");
        if (file2.exists() && file2.length() > 0) {
            return new tt(this.c, this.tt).c(file2);
        }
        if (file.getName().endsWith(AliyunVodHttpCommon.Format.FORMAT_XML)) {
            return n.c() ? new n(this.c, this.tt).c(file) : new a(this.c, this.tt).c(file);
        }
        return new ConcurrentHashMap();
    }

    @Override // com.byazt.yy.tt
    public void c(Map<String, Object> map, File file) throws Throwable {
        if (!file.getName().endsWith(".prop")) {
            file = new File(file.getParent(), file.getName() + ".prop");
        }
        file.setReadable(true, false);
        new tt(this.c, this.tt).c(map, file);
    }
}
