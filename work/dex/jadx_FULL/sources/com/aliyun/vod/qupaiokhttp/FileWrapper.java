package com.aliyun.vod.qupaiokhttp;

import java.io.File;
import okhttp3.MediaType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class FileWrapper {
    public File file;
    public String fileName;
    private long fileSize;
    public MediaType mediaType;

    public FileWrapper(File file, MediaType mediaType) {
        this.file = file;
        this.fileName = file.getName();
        this.mediaType = mediaType;
        this.fileSize = file.length();
    }

    public File getFile() {
        return this.file;
    }

    public String getFileName() {
        String str = this.fileName;
        return str != null ? str : "nofilename";
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public MediaType getMediaType() {
        return this.mediaType;
    }
}
