package com.aliyun.vod.jasonparse;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class JSONSupport {
    public abstract <T> T readListValue(String str, Type type) throws Exception;

    public abstract <T> T readValue(File file, Class<? extends T> cls) throws Exception;

    public abstract <T> T readValue(InputStream inputStream, Class<? extends T> cls) throws Exception;

    public abstract <T> T readValue(String str, Class<? extends T> cls) throws Exception;

    public abstract <T> String writeValue(T t) throws Exception;

    public abstract <T> void writeValue(File file, T t) throws Exception;

    public abstract <T> void writeValue(OutputStream outputStream, T t) throws Exception;
}
