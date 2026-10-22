package com.kwad.components.offline.api.core.api;

import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface IEncrypt {
    String getFileMD5(File file);

    byte[] getFileMD5Digest(File file);

    String getFileSha256(File file);

    String getMD5(String str);

    String getResponseData(String str);

    String getSha256(String str);
}
