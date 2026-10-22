package com.easyjson;

import com.easyjson.serializer.JSONSerializer;
import com.easyjson.serializer.SerializeWriter;
import com.easyjson.serializer.SerializerFeature;
import com.zj.adlib.chb;
import java.io.Closeable;
import java.io.Flushable;
import java.io.Writer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class JSONWriter implements Closeable, Flushable {
    private chb context;
    private JSONSerializer serializer;
    private SerializeWriter writer;

    public JSONWriter(Writer writer) {
        SerializeWriter serializeWriter = new SerializeWriter(writer);
        this.writer = serializeWriter;
        this.serializer = new JSONSerializer(serializeWriter);
    }

    private void afterWriter() {
        int i;
        chb chbVar = this.context;
        if (chbVar == null) {
            return;
        }
        switch (chbVar.f40970a) {
            case 1001:
            case 1003:
                i = 1002;
                break;
            case 1002:
                i = 1003;
                break;
            case 1004:
                i = 1005;
                break;
            default:
                i = -1;
                break;
        }
        if (i != -1) {
            chbVar.f40970a = i;
        }
    }

    private void beforeWrite() {
        SerializeWriter serializeWriter;
        int i;
        chb chbVar = this.context;
        if (chbVar == null) {
            return;
        }
        int i2 = chbVar.f40970a;
        if (i2 == 1002) {
            serializeWriter = this.writer;
            i = 58;
        } else {
            if (i2 != 1003 && i2 != 1005) {
                return;
            }
            serializeWriter = this.writer;
            i = 44;
        }
        serializeWriter.write(i);
    }

    private void beginStructure() {
        SerializeWriter serializeWriter;
        int i;
        int i2 = this.context.f40970a;
        switch (i2) {
            case 1001:
            case 1004:
                return;
            case 1002:
                serializeWriter = this.writer;
                i = 58;
                break;
            case 1003:
            default:
                throw new JSONException("illegal state : " + i2);
            case 1005:
                serializeWriter = this.writer;
                i = 44;
                break;
        }
        serializeWriter.write(i);
    }

    private void endStructure() {
        chb chbVar = this.context.f15815a;
        this.context = chbVar;
        if (chbVar == null) {
            return;
        }
        int i = chbVar.f40970a;
        int i2 = 1002;
        if (i != 1001) {
            if (i != 1002) {
                i2 = i != 1004 ? -1 : 1005;
            } else {
                i2 = 1003;
            }
        }
        if (i2 != -1) {
            chbVar.f40970a = i2;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.writer.close();
    }

    public void config(SerializerFeature serializerFeature, boolean z) {
        this.writer.config(serializerFeature, z);
    }

    public void endArray() {
        this.writer.write(93);
        endStructure();
    }

    public void endObject() {
        this.writer.write(125);
        endStructure();
    }

    @Override // java.io.Flushable
    public void flush() {
        this.writer.flush();
    }

    public void startArray() {
        if (this.context != null) {
            beginStructure();
        }
        this.context = new chb(this.context, 1004);
        this.writer.write(91);
    }

    public void startObject() {
        if (this.context != null) {
            beginStructure();
        }
        this.context = new chb(this.context, 1001);
        this.writer.write(123);
    }

    public void writeKey(String str) {
        writeObject(str);
    }

    public void writeObject(Object obj) {
        beforeWrite();
        this.serializer.write(obj);
        afterWriter();
    }

    public void writeObject(String str) {
        beforeWrite();
        this.serializer.write(str);
        afterWriter();
    }

    public void writeValue(Object obj) {
        writeObject(obj);
    }
}
