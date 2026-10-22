package com.huachenjie.common.aliyun.file_upload;

import com.zj.adlib.pf6;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface MultipleUploadCallback {
    default void a(int position, long currentSize, long totalSize) {
    }

    default void b(int position, String filePath) {
    }

    void c(List<pf6> fileInfoList);

    default void d(int position, pf6 fileInfo) {
    }
}
