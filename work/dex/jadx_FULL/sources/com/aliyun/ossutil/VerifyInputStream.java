package com.aliyun.ossutil;

import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class VerifyInputStream extends InputStream {
    private InputStream inputStream;
    private Map<String, String> map;
    private CRC64 crc64 = new CRC64();
    private MessageDigest md = MessageDigest.getInstance("MD5");

    public VerifyInputStream(InputStream inputStream, Map<String, String> map) throws NoSuchAlgorithmException {
        this.inputStream = inputStream;
        this.map = map;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.inputStream.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int i = this.inputStream.read(bArr);
        if (i != -1) {
            this.crc64.update(bArr, i);
            this.md.update(bArr, 0, i);
        } else {
            this.map.put("crc", this.crc64.getValue());
            this.map.put(TKDownloadReason.KSAD_TK_MD5, Base64.getEncoder().encodeToString(this.md.digest()));
        }
        return i;
    }
}
