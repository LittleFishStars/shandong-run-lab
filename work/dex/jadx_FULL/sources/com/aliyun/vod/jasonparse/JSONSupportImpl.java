package com.aliyun.vod.jasonparse;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class JSONSupportImpl extends JSONSupport {
    private final Gson mGson = new Gson();

    public static String fileToStr(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return byteArrayOutputStream.toString();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    private byte[] getByteFromInputStream(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        while (true) {
            try {
                int i = inputStream.read(bArr, 0, 16384);
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        byteArrayOutputStream.flush();
        return bArr;
    }

    @Override // com.aliyun.vod.jasonparse.JSONSupport
    public <T> T readListValue(String str, Type type) throws Exception {
        return (T) this.mGson.fromJson(str, type);
    }

    @Override // com.aliyun.vod.jasonparse.JSONSupport
    public <T> T readValue(InputStream inputStream, Class<? extends T> cls) throws Exception {
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
        jsonReader.setLenient(true);
        T t = (T) this.mGson.fromJson(jsonReader, cls);
        jsonReader.close();
        return t;
    }

    @Override // com.aliyun.vod.jasonparse.JSONSupport
    public <T> void writeValue(OutputStream outputStream, T t) throws Exception {
        JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(outputStream, "UTF-8"));
        this.mGson.toJson(t, t.getClass(), jsonWriter);
        jsonWriter.flush();
        jsonWriter.close();
    }

    @Override // com.aliyun.vod.jasonparse.JSONSupport
    public <T> T readValue(File file, Class<? extends T> cls) throws Exception {
        return (T) readValue(new FileInputStream(file), cls);
    }

    @Override // com.aliyun.vod.jasonparse.JSONSupport
    public <T> void writeValue(File file, T t) throws Exception {
        writeValue(new FileOutputStream(file), t);
    }

    @Override // com.aliyun.vod.jasonparse.JSONSupport
    public <T> T readValue(String str, Class<? extends T> cls) throws Exception {
        return (T) this.mGson.fromJson(str, (Class) cls);
    }

    @Override // com.aliyun.vod.jasonparse.JSONSupport
    public <T> String writeValue(T t) throws Exception {
        return this.mGson.toJson(t);
    }
}
