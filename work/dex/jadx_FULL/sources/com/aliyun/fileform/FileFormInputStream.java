package com.aliyun.fileform;

import com.aliyun.fileform.models.FileField;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FileFormInputStream extends InputStream {
    private String boundary;
    private ByteArrayInputStream endInputStream;
    private Map<String, Object> form;
    private String[] keys;
    private int keyIndex = 0;
    private int fileNumber = 0;
    private ArrayList<FileField> files = new ArrayList<>();
    private ByteArrayInputStream fileBodyStream = new ByteArrayInputStream(new byte[0]);
    private InputStream temporaryStream = new ByteArrayInputStream(new byte[0]);
    private ByteArrayInputStream temporaryEndStream = new ByteArrayInputStream(new byte[0]);

    public FileFormInputStream(Map<String, Object> map, String str) {
        this.boundary = str;
        this.form = map;
        this.keys = (String[]) map.keySet().toArray(new String[0]);
        try {
            this.endInputStream = new ByteArrayInputStream(("--" + str + "--\r\n").getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // java.io.InputStream
    public int read() {
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        int i;
        try {
            int i2 = this.fileBodyStream.read(bArr);
            if (i2 != -1) {
                return i2;
            }
            int i3 = this.temporaryStream.read(bArr);
            if (i3 != -1) {
                return i3;
            }
            int i4 = this.temporaryEndStream.read(bArr);
            if (i4 != -1) {
                return i4;
            }
            int i5 = this.keyIndex;
            String[] strArr = this.keys;
            if (i5 < strArr.length) {
                Object obj = this.form.get(strArr[i5]);
                if (obj == null) {
                    this.keyIndex++;
                    return read(bArr);
                }
                StringBuilder sb = new StringBuilder();
                if (obj instanceof FileField) {
                    this.files.add((FileField) obj);
                    this.fileNumber++;
                } else {
                    sb.append("--");
                    sb.append(this.boundary);
                    sb.append("\r\n");
                    sb.append("Content-Disposition: form-data; name=\"");
                    sb.append(this.keys[this.keyIndex]);
                    sb.append("\"\r\n\r\n");
                    sb.append(obj);
                    sb.append("\r\n");
                }
                this.fileBodyStream = new ByteArrayInputStream(sb.toString().getBytes("UTF-8"));
                this.keyIndex++;
                return read(bArr);
            }
            if (i5 < strArr.length || (i = this.fileNumber) <= 0) {
                int i6 = this.endInputStream.read(bArr);
                if (i6 != -1) {
                    return i6;
                }
                return -1;
            }
            FileField fileField = this.files.get(i - 1);
            this.fileNumber--;
            if (fileField.content instanceof InputStream) {
                this.temporaryStream = fileField.content;
                this.temporaryEndStream = new ByteArrayInputStream("\r\n".getBytes("UTF-8"));
                this.fileBodyStream = new ByteArrayInputStream(("--" + this.boundary + "\r\nContent-Disposition: form-data; name=\"file\"; filename=\"" + fileField.filename + "\"\r\nContent-Type: " + fileField.contentType + "\r\n\r\n").getBytes("UTF-8"));
            }
            return read(bArr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // java.io.InputStream
    public void reset() {
        this.keyIndex = 0;
        this.fileNumber = 0;
        this.files.clear();
        this.fileBodyStream = new ByteArrayInputStream(new byte[0]);
        this.temporaryStream = new ByteArrayInputStream(new byte[0]);
        this.temporaryEndStream = new ByteArrayInputStream(new byte[0]);
        this.endInputStream.reset();
    }
}
