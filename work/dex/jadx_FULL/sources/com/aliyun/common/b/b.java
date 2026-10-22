package com.aliyun.common.b;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Gson f25565a = new Gson();

    @Override // com.aliyun.common.b.a
    public <T> T readListValue(String str, Type type) throws Exception {
        return (T) this.f25565a.fromJson(str, type);
    }

    @Override // com.aliyun.common.b.a
    public <T> T readValue(File file, Class<? extends T> cls) throws Exception {
        return (T) readValue(new FileInputStream(file), cls);
    }

    @Override // com.aliyun.common.b.a
    public <T> T readValue(InputStream inputStream, Class<? extends T> cls) throws Exception {
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
        jsonReader.setLenient(true);
        try {
            try {
                T t = (T) this.f25565a.fromJson(jsonReader, cls);
                try {
                    jsonReader.close();
                } catch (IOException unused) {
                }
                return t;
            } catch (Exception e) {
                throw e;
            }
        } catch (Throwable th) {
            try {
                jsonReader.close();
            } catch (IOException unused2) {
            }
            throw th;
        }
    }

    @Override // com.aliyun.common.b.a
    public <T> T readValue(String str, Class<? extends T> cls) throws Exception {
        return (T) this.f25565a.fromJson(str, (Class) cls);
    }

    @Override // com.aliyun.common.b.a
    public <T> String writeValue(T t) throws Exception {
        return this.f25565a.toJson(t);
    }

    @Override // com.aliyun.common.b.a
    public <T> void writeValue(File file, T t) throws Exception {
        writeValue(new FileOutputStream(file), t);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x001c */
    @Override // com.aliyun.common.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> void writeValue(OutputStream outputStream, T t) throws Exception {
        JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(outputStream, "UTF-8"));
        try {
            this.f25565a.toJson(t, t.getClass(), jsonWriter);
            try {
                jsonWriter.flush();
            } catch (IOException unused) {
            }
            try {
                jsonWriter.close();
                return;
            } catch (IOException unused2) {
                return;
            }
        } catch (Exception e) {
            throw e;
        }
        try {
            jsonWriter.close();
            throw th;
        } catch (IOException unused3) {
            throw th;
        }
    }
}
