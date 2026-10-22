package com.kwad.components.core.offline.b.a;

import com.kwad.components.offline.api.core.api.IEncrypt;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.bh;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
final class d implements IEncrypt {
    @Override // com.kwad.components.offline.api.core.api.IEncrypt
    public final String getFileMD5(File file) {
        return com.kwad.sdk.utils.a.getFileMD5(file);
    }

    @Override // com.kwad.components.offline.api.core.api.IEncrypt
    public final byte[] getFileMD5Digest(File file) {
        try {
            return com.kwad.sdk.utils.a.getFileMD5Digest(file);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // com.kwad.components.offline.api.core.api.IEncrypt
    public final String getFileSha256(File file) {
        return bh.ae(file);
    }

    @Override // com.kwad.components.offline.api.core.api.IEncrypt
    public final String getMD5(String str) {
        return an.md5(str);
    }

    @Override // com.kwad.components.offline.api.core.api.IEncrypt
    public final String getResponseData(String str) {
        return com.kwad.sdk.core.a.d.getResponseData(str);
    }

    @Override // com.kwad.components.offline.api.core.api.IEncrypt
    public final String getSha256(String str) {
        return bh.ia(str);
    }
}
