package com.byazt.zz;

import com.byazt.hs.IDownloadHttpService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface rl {

    @com.byazt.zqa.c(c = {0, 1, 189, 782})
    public static class c implements rl {
        @Override // com.byazt.zz.rl
        public com.byazt.m.sp c(Throwable th, String str) {
            return null;
        }

        @Override // com.byazt.zz.rl
        public boolean c() {
            return false;
        }

        @Override // com.byazt.zz.rl
        public boolean c(Throwable th) {
            return false;
        }

        @Override // com.byazt.zz.rl
        public IDownloadHttpService tt() {
            return null;
        }

        @Override // com.byazt.zz.rl
        public com.byazt.hs.x ve() {
            return null;
        }
    }

    com.byazt.m.sp c(Throwable th, String str);

    boolean c();

    boolean c(Throwable th);

    IDownloadHttpService tt();

    com.byazt.hs.x ve();
}
