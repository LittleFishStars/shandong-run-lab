package com.easyjson.parser;

import com.easyjson.JSONArray;
import com.easyjson.JSONException;
import com.easyjson.parser.deserializer.FieldDeserializer;
import com.easyjson.parser.deserializer.ObjectDeserializer;
import com.easyjson.util.FieldInfo;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class b extends FieldDeserializer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObjectDeserializer f29556a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Type f1518a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f1519a;

    public b(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        Type type;
        super(cls, fieldInfo, 14);
        Type type2 = fieldInfo.fieldType;
        Class<?> cls2 = fieldInfo.fieldClass;
        if (type2 instanceof ParameterizedType) {
            type = ((ParameterizedType) type2).getActualTypeArguments()[0];
        } else {
            if (cls2.isArray()) {
                this.f1518a = cls2.getComponentType();
                this.f1519a = true;
                return;
            }
            type = Object.class;
        }
        this.f1518a = type;
        this.f1519a = false;
    }

    public final void a(DefaultJSONParser defaultJSONParser, Type type, Collection collection) {
        int i;
        Type type2 = this.f1518a;
        ObjectDeserializer deserializer = this.f29556a;
        if ((type2 instanceof TypeVariable) && (type instanceof ParameterizedType)) {
            TypeVariable typeVariable = (TypeVariable) type2;
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class cls = parameterizedType.getRawType() instanceof Class ? (Class) parameterizedType.getRawType() : null;
            if (cls == null) {
                i = -1;
                break;
            }
            int length = cls.getTypeParameters().length;
            i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (cls.getTypeParameters()[i].getName().equals(typeVariable.getName())) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                type2 = parameterizedType.getActualTypeArguments()[i];
                if (!type2.equals(this.f1518a)) {
                    deserializer = defaultJSONParser.config.getDeserializer(type2);
                }
            }
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token != 14) {
            String str = "exepct '[', but " + JSONToken.name(jSONLexer.token);
            if (type != null) {
                str = str + ", type : " + type;
            }
            throw new JSONException(str);
        }
        if (deserializer == null) {
            deserializer = defaultJSONParser.config.getDeserializer(type2);
            this.f29556a = deserializer;
        }
        char c = jSONLexer.ch;
        if (c == '[') {
            int i2 = jSONLexer.bp + 1;
            jSONLexer.bp = i2;
            jSONLexer.ch = i2 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i2);
            jSONLexer.token = 14;
        } else if (c == '{') {
            int i3 = jSONLexer.bp + 1;
            jSONLexer.bp = i3;
            jSONLexer.ch = i3 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i3);
            jSONLexer.token = 12;
        } else if (c == '\"') {
            jSONLexer.scanString();
        } else if (c == ']') {
            int i4 = jSONLexer.bp + 1;
            jSONLexer.bp = i4;
            jSONLexer.ch = i4 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i4);
            jSONLexer.token = 15;
        } else {
            jSONLexer.nextToken();
        }
        int i5 = 0;
        while (true) {
            int i6 = jSONLexer.token;
            if (i6 == 16) {
                if ((Feature.AllowArbitraryCommas.mask & jSONLexer.features) != 0) {
                    jSONLexer.nextToken();
                }
            }
            if (i6 == 15) {
                break;
            }
            collection.add(deserializer.deserialze(defaultJSONParser, type2, Integer.valueOf(i5)));
            if (defaultJSONParser.resolveStatus == 1) {
                defaultJSONParser.checkListResolve(collection);
            }
            if (jSONLexer.token == 16) {
                char c2 = jSONLexer.ch;
                if (c2 == '[') {
                    int i7 = jSONLexer.bp + 1;
                    jSONLexer.bp = i7;
                    jSONLexer.ch = i7 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i7);
                    jSONLexer.token = 14;
                } else if (c2 == '{') {
                    int i8 = jSONLexer.bp + 1;
                    jSONLexer.bp = i8;
                    jSONLexer.ch = i8 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i8);
                    jSONLexer.token = 12;
                } else if (c2 == '\"') {
                    jSONLexer.scanString();
                } else {
                    jSONLexer.nextToken();
                }
            }
            i5++;
        }
        if (jSONLexer.ch != ',') {
            jSONLexer.nextToken();
            return;
        }
        int i9 = jSONLexer.bp + 1;
        jSONLexer.bp = i9;
        jSONLexer.ch = i9 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i9);
        jSONLexer.token = 16;
    }

    @Override // com.easyjson.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        List arrayList;
        JSONArray jSONArray;
        Object array;
        if (defaultJSONParser.lexer.token == 8) {
            setValue(obj, (Object) null);
            defaultJSONParser.lexer.nextToken();
            return;
        }
        if (this.f1519a) {
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.setComponentType(this.f1518a);
            jSONArray = jSONArray2;
            arrayList = jSONArray2;
        } else {
            arrayList = new ArrayList();
            jSONArray = null;
        }
        ParseContext parseContext = defaultJSONParser.contex;
        defaultJSONParser.setContext(parseContext, obj, this.fieldInfo.name);
        a(defaultJSONParser, type, arrayList);
        defaultJSONParser.setContext(parseContext);
        Object obj2 = arrayList;
        if (this.f1519a) {
            array = arrayList.toArray((Object[]) Array.newInstance((Class<?>) this.f1518a, arrayList.size()));
            jSONArray.setRelatedArray(array);
        }
        if (obj == null) {
            obj2 = array;
            map.put(this.fieldInfo.name, obj2);
        } else {
            obj2 = array;
            setValue(obj, obj2);
        }
    }
}
