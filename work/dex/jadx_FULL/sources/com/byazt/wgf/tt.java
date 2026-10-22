package com.byazt.wgf;

import com.byazt.nr.m;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 178, 13})
public class tt extends c {
    public int c;
    public int tt;
    public volatile boolean ve;

    public tt(int i, int i2) {
        this.c = 15;
        this.tt = 3;
        if (i <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.c = i;
        this.tt = i2;
    }

    private void uj(List<File> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                long jTt = tt(list);
                int size = list.size();
                boolean zC = c(jTt, size);
                if (zC) {
                    m.c("splashLoadAd", "不满足删除条件，不执行删除操作(true)".concat(String.valueOf(zC)));
                    return;
                }
                TreeMap treeMap = new TreeMap();
                for (File file : list) {
                    treeMap.put(Long.valueOf(file.lastModified()), file);
                }
                for (Map.Entry entry : treeMap.entrySet()) {
                    if (entry != null && !zC) {
                        m.uj("splashLoadAd", "LRUDeleteFile deleting fileTime ".concat(String.valueOf(((Long) entry.getKey()).longValue())));
                        File file2 = (File) entry.getValue();
                        long length = file2.length();
                        if (file2.delete()) {
                            size--;
                            jTt -= length;
                            m.c("splashLoadAd", "删除 一个 Cache file 当前总个数：".concat(String.valueOf(size)));
                        } else {
                            m.uj("splashLoadAd", "Error deleting file " + file2 + " for trimming cache");
                        }
                        if (c(file2, jTt, size)) {
                            m.c("splashLoadAd", "停止删除 当前总个数 totalCount：" + size + " 最大值存储上限个数 maxCount " + this.c + " 最小个数 " + this.tt);
                            return;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void ve(List<File> list) {
        long jTt = tt(list);
        int size = list.size();
        if (c(jTt, size)) {
            return;
        }
        for (File file : list) {
            long length = file.length();
            if (file.delete()) {
                size--;
                jTt -= length;
                m.c("TotalCountLruDiskFile", "Cache file " + file + " is deleted because it exceeds cache limit");
            } else {
                m.c("TotalCountLruDiskFile", "Error deleting file " + file + " for trimming cache");
            }
            if (c(file, jTt, size)) {
                return;
            }
        }
    }

    @Override // com.byazt.wgf.c
    public boolean c(long j, int i) {
        return i <= this.c;
    }

    @Override // com.byazt.wgf.c
    public boolean c(File file, long j, int i) {
        return i <= this.tt;
    }

    @Override // com.byazt.wgf.c
    public void c(List<File> list) {
        if (this.ve) {
            uj(list);
            this.ve = false;
        } else {
            ve(list);
        }
    }
}
