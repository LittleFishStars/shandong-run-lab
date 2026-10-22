package com.bumptech.glide.load.data.mediastore;

import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class FileService {
    public boolean exists(File file) {
        return file.exists();
    }

    public File get(String str) {
        return new File(str);
    }

    public long length(File file) {
        return file.length();
    }
}
