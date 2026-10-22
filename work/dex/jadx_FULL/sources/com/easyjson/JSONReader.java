package com.easyjson;

import com.easyjson.parser.DefaultJSONParser;
import com.easyjson.parser.Feature;
import com.easyjson.parser.JSONLexer;
import com.easyjson.util.TypeUtils;
import com.zj.adlib.chb;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class JSONReader implements Closeable {
    private chb context;
    private final DefaultJSONParser parser;
    private Reader reader;

    public JSONReader(DefaultJSONParser defaultJSONParser) {
        this.parser = defaultJSONParser;
    }

    public JSONReader(JSONLexer jSONLexer) {
        this(new DefaultJSONParser(jSONLexer));
    }

    public JSONReader(Reader reader) {
        this(new JSONLexer(readAll(reader)));
        this.reader = reader;
    }

    private void endStructure() {
        int i;
        chb chbVar = this.context.f15815a;
        this.context = chbVar;
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

    private void readAfter() {
        int i;
        chb chbVar = this.context;
        int i2 = chbVar.f40970a;
        switch (i2) {
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
            case 1005:
                i = -1;
                break;
            default:
                throw new JSONException("illegal state : " + i2);
        }
        if (i != -1) {
            chbVar.f40970a = i;
        }
    }

    public static String readAll(Reader reader) {
        StringBuilder sb = new StringBuilder();
        try {
            char[] cArr = new char[2048];
            while (true) {
                int i = reader.read(cArr, 0, 2048);
                if (i < 0) {
                    return sb.toString();
                }
                sb.append(cArr, 0, i);
            }
        } catch (Exception e) {
            throw new JSONException("read string from reader error", e);
        }
    }

    private void readBefore() {
        DefaultJSONParser defaultJSONParser;
        int i;
        int i2 = this.context.f40970a;
        switch (i2) {
            case 1001:
            case 1004:
                return;
            case 1002:
                defaultJSONParser = this.parser;
                i = 17;
                break;
            case 1003:
            case 1005:
                defaultJSONParser = this.parser;
                i = 16;
                break;
            default:
                throw new JSONException("illegal state : " + i2);
        }
        defaultJSONParser.accept(i);
    }

    private void startStructure() {
        DefaultJSONParser defaultJSONParser;
        int i;
        switch (this.context.f40970a) {
            case 1001:
            case 1004:
                return;
            case 1002:
                defaultJSONParser = this.parser;
                i = 17;
                break;
            case 1003:
            case 1005:
                defaultJSONParser = this.parser;
                i = 16;
                break;
            default:
                throw new JSONException("illegal state : " + this.context.f40970a);
        }
        defaultJSONParser.accept(i);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.parser.lexer.close();
        Reader reader = this.reader;
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                throw new JSONException("closed reader error", e);
            }
        }
    }

    public void config(Feature feature, boolean z) {
        this.parser.config(feature, z);
    }

    public void endArray() {
        this.parser.accept(15);
        endStructure();
    }

    public void endObject() {
        this.parser.accept(13);
        endStructure();
    }

    public boolean hasNext() {
        if (this.context == null) {
            throw new JSONException("context is null");
        }
        int i = this.parser.lexer.token();
        int i2 = this.context.f40970a;
        switch (i2) {
            case 1001:
            case 1003:
                return i != 13;
            case 1002:
            default:
                throw new JSONException("illegal state : " + i2);
            case 1004:
            case 1005:
                return i != 15;
        }
    }

    public int peek() {
        return this.parser.lexer.token();
    }

    public Integer readInteger() {
        Object obj;
        if (this.context == null) {
            obj = this.parser.parse();
        } else {
            readBefore();
            obj = this.parser.parse();
            readAfter();
        }
        return TypeUtils.castToInt(obj);
    }

    public Long readLong() {
        Object obj;
        if (this.context == null) {
            obj = this.parser.parse();
        } else {
            readBefore();
            obj = this.parser.parse();
            readAfter();
        }
        return TypeUtils.castToLong(obj);
    }

    public Object readObject() {
        if (this.context == null) {
            return this.parser.parse();
        }
        readBefore();
        Object obj = this.parser.parse();
        readAfter();
        return obj;
    }

    public <T> T readObject(TypeReference<T> typeReference) {
        return (T) readObject(typeReference.type);
    }

    public <T> T readObject(Class<T> cls) {
        if (this.context == null) {
            return (T) this.parser.parseObject((Class) cls);
        }
        readBefore();
        T t = (T) this.parser.parseObject((Class) cls);
        readAfter();
        return t;
    }

    public <T> T readObject(Type type) {
        if (this.context == null) {
            return (T) this.parser.parseObject(type);
        }
        readBefore();
        T t = (T) this.parser.parseObject(type);
        readAfter();
        return t;
    }

    public Object readObject(Map map) {
        if (this.context == null) {
            return this.parser.parseObject(map);
        }
        readBefore();
        Object object = this.parser.parseObject(map);
        readAfter();
        return object;
    }

    public void readObject(Object obj) {
        if (this.context == null) {
            this.parser.parseObject(obj);
            return;
        }
        readBefore();
        this.parser.parseObject(obj);
        readAfter();
    }

    public String readString() {
        Object obj;
        if (this.context == null) {
            obj = this.parser.parse();
        } else {
            readBefore();
            obj = this.parser.parse();
            readAfter();
        }
        return TypeUtils.castToString(obj);
    }

    public void startArray() {
        chb chbVar;
        if (this.context == null) {
            chbVar = new chb(null, 1004);
        } else {
            startStructure();
            chbVar = new chb(this.context, 1004);
        }
        this.context = chbVar;
        this.parser.accept(14);
    }

    public void startObject() {
        chb chbVar;
        if (this.context == null) {
            chbVar = new chb(null, 1001);
        } else {
            startStructure();
            chbVar = new chb(this.context, 1001);
        }
        this.context = chbVar;
        this.parser.accept(12);
    }
}
