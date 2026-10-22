package com.czhj.volley.toolbox;

import com.czhj.volley.VolleyError;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class DownloadItem {
    public VolleyError error;
    public String filePath;
    public String md5;
    public String message;
    public long networkMs;
    public long size;
    public int status;
    public FileType type;
    public String url;
    public boolean userRange = true;

    public enum FileType {
        VIDEO(1),
        PICTURE(2),
        FILE(3),
        APK(8),
        OTHER(9),
        ZIP_FILE(10),
        MRAID_VIDEO(11);

        private int mType;

        FileType(int i) {
            this.mType = i;
        }

        public int getType() {
            return this.mType;
        }
    }
}
