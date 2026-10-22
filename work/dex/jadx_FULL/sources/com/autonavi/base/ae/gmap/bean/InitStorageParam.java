package com.autonavi.base.ae.gmap.bean;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@JBindingInclude
public class InitStorageParam {
    private static final String DIR_NAME = "terrain_dem_files";
    private static final String INIT_STORAGE_DIR = "mapcache";

    @JBindingInclude
    private int maxFileCount;

    @JBindingInclude
    private long maxFileSize;

    @JBindingInclude
    private String path;

    @JBindingInclude
    private int version;

    public static class Holder {
        private static String sPath;

        public static void initPath(String str) {
            File file = new File(str);
            File file2 = new File(file, InitStorageParam.INIT_STORAGE_DIR);
            if (file.isDirectory()) {
                if (!file2.exists()) {
                    file2.mkdir();
                }
                File file3 = new File(file2, InitStorageParam.DIR_NAME);
                if (!file3.exists()) {
                    file3.mkdir();
                }
                sPath = file3.getAbsolutePath();
            }
        }
    }

    private InitStorageParam(int i, String str, int i2, long j) {
        this.version = i;
        this.path = str;
        this.maxFileCount = i2;
        this.maxFileSize = j;
    }

    @JBindingInclude
    public static InitStorageParam obtain() {
        return new InitStorageParam();
    }

    @JBindingInclude
    public int getMaxFileCount() {
        return this.maxFileCount;
    }

    @JBindingInclude
    public long getMaxFileSize() {
        return this.maxFileSize;
    }

    @JBindingInclude
    public String getPath() {
        return this.path;
    }

    @JBindingInclude
    public int getVersion() {
        return this.version;
    }

    @JBindingInclude
    public void setMaxFileCount(int i) {
        this.maxFileCount = i;
    }

    @JBindingInclude
    public void setMaxFileSize(long j) {
        this.maxFileSize = j;
    }

    @JBindingInclude
    public void setPath(String str) {
        this.path = str;
    }

    @JBindingInclude
    public void setVersion(int i) {
        this.version = i;
    }

    public String toString() {
        return "InitStorageParam{version=" + this.version + ", maxFileCount=" + this.maxFileCount + ", maxFileSize=" + this.maxFileSize + ", path='" + this.path + "'}";
    }

    @JBindingInclude
    public static InitStorageParam obtain(int i, String str, int i2, long j) {
        return new InitStorageParam(i, str, i2, j);
    }

    private InitStorageParam() {
        this(1, Holder.sPath, 1000, 300000L);
    }
}
