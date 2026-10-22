package com.byazt.fd;

import android.text.TextUtils;
import com.byazt.fk.u;
import com.bykv.vk.component.ttvideo.DataLoaderHelper;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1032, 20})
public class c implements com.byazt.fk.c {
    public long c;
    public String tt = "tt_video_reward_full";
    public String ve = "tt_video_brand";
    public String uj = "tt_video_splash";
    public String n = "tt_video_default";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28537a = null;
    public String sp = null;
    public String x = null;
    public String i = null;
    public String da = null;
    public String sl = null;

    @Override // com.byazt.fk.c
    public void clearCache() {
    }

    @Override // com.byazt.fk.c
    public String getBrandCacheDir() {
        if (this.x == null) {
            this.x = this.sl + File.separator + this.ve;
            File file = new File(this.x);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.x;
    }

    @Override // com.byazt.fk.c
    public long getCachedSize(u uVar) {
        return this.c;
    }

    @Override // com.byazt.fk.c
    public String getOtherCacheDir() {
        if (this.da == null) {
            this.da = this.sl + File.separator + this.n;
            File file = new File(this.da);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.da;
    }

    @Override // com.byazt.fk.c
    public String getRewardFullCacheDir() {
        if (this.sp == null) {
            this.sp = this.sl + File.separator + this.tt;
            File file = new File(this.sp);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.sp;
    }

    @Override // com.byazt.fk.c
    public String getSplashCacheDir() {
        if (this.i == null) {
            this.i = this.sl + File.separator + this.uj;
            File file = new File(this.i);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.i;
    }

    @Override // com.byazt.fk.c
    public boolean isVideoCached(u uVar) {
        DataLoaderHelper.DataLoaderCacheInfo cacheInfoByFilePath = TTVideoEngine.getCacheInfoByFilePath(uVar.getFileNameKey(), uVar.getCacheParentDir());
        if (cacheInfoByFilePath != null) {
            boolean zIsPreloadAll = uVar.isPreloadAll();
            this.c = cacheInfoByFilePath.mCacheSizeFromZero;
            int pitayaCacheSize = uVar.getPitayaCacheSize() > 0 ? uVar.getPitayaCacheSize() : uVar.getPreloadSize();
            if (zIsPreloadAll) {
                pitayaCacheSize = (int) uVar.getVideoSize();
            }
            if (cacheInfoByFilePath.mCacheSizeFromZero >= pitayaCacheSize) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.fk.c
    public void setRootDir(String str) {
        if (!TextUtils.isEmpty(this.sl) && !this.sl.equals(str)) {
            this.f28537a = null;
            this.sp = null;
            this.x = null;
            this.i = null;
            this.da = null;
        }
        this.sl = str;
    }
}
