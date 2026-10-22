package com.google.zxing;

import com.zj.adlib.tv0;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface Writer {
    tv0 a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException;

    tv0 b(String str, BarcodeFormat barcodeFormat, int i, int i2) throws WriterException;
}
