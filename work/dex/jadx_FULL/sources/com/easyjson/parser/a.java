package com.easyjson.parser;

import com.easyjson.JSON;
import com.easyjson.JSONException;
import com.easyjson.JSONObject;
import com.easyjson.parser.deserializer.ObjectDeserializer;
import com.easyjson.util.TypeUtils;
import com.google.common.net.c;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a implements ObjectDeserializer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f29555a = new a();

    /* JADX WARN: Code duplicated, block: B:35:0x0094 A[Catch: all -> 0x012b, TRY_LEAVE, TryCatch #0 {all -> 0x012b, blocks: (B:9:0x0039, B:11:0x003f, B:16:0x004d, B:18:0x0053, B:20:0x005b, B:22:0x0062, B:24:0x006e, B:25:0x0070, B:33:0x008d, B:35:0x0094, B:38:0x009b, B:39:0x00a2, B:26:0x0074, B:29:0x007d, B:32:0x0083, B:40:0x00a3, B:41:0x00bd, B:42:0x00be, B:46:0x00c8, B:48:0x00d2, B:50:0x00da, B:52:0x00e4, B:55:0x00eb, B:56:0x00ee, B:58:0x00f8, B:60:0x0103, B:61:0x0106, B:63:0x010d, B:64:0x0112, B:65:0x012a), top: B:69:0x0039 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x009b A[Catch: all -> 0x012b, TRY_ENTER, TryCatch #0 {all -> 0x012b, blocks: (B:9:0x0039, B:11:0x003f, B:16:0x004d, B:18:0x0053, B:20:0x005b, B:22:0x0062, B:24:0x006e, B:25:0x0070, B:33:0x008d, B:35:0x0094, B:38:0x009b, B:39:0x00a2, B:26:0x0074, B:29:0x007d, B:32:0x0083, B:40:0x00a3, B:41:0x00bd, B:42:0x00be, B:46:0x00c8, B:48:0x00d2, B:50:0x00da, B:52:0x00e4, B:55:0x00eb, B:56:0x00ee, B:58:0x00f8, B:60:0x0103, B:61:0x0106, B:63:0x010d, B:64:0x0112, B:65:0x012a), top: B:69:0x0039 }] */
    public static Object a(DefaultJSONParser defaultJSONParser, Map<Object, Object> map, Type type, Type type2, Object obj) {
        ParseContext parseContext;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token;
        if (i != 12 && i != 16) {
            throw new JSONException("syntax error, expect {, actual " + JSONToken.name(i));
        }
        ObjectDeserializer deserializer = defaultJSONParser.config.getDeserializer(type);
        ObjectDeserializer deserializer2 = defaultJSONParser.config.getDeserializer(type2);
        jSONLexer.nextToken();
        ParseContext parseContext2 = defaultJSONParser.contex;
        while (true) {
            try {
                int i2 = jSONLexer.token;
                if (i2 == 13) {
                    jSONLexer.nextToken(16);
                    defaultJSONParser.setContext(parseContext2);
                    return map;
                }
                Object obj2 = null;
                if (i2 == 4 && jSONLexer.isRef() && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                    jSONLexer.nextTokenWithChar(c.b);
                    if (jSONLexer.token != 4) {
                        throw new JSONException("illegal ref, " + JSONToken.name(i2));
                    }
                    String strStringVal = jSONLexer.stringVal();
                    if (!"..".equals(strStringVal)) {
                        if ("$".equals(strStringVal)) {
                            parseContext = parseContext2;
                            while (true) {
                                ParseContext parseContext3 = parseContext.parent;
                                if (parseContext3 == null) {
                                    break;
                                }
                                parseContext = parseContext3;
                            }
                        } else {
                            defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(parseContext2, strStringVal));
                            defaultJSONParser.resolveStatus = 1;
                        }
                        jSONLexer.nextToken(13);
                        if (jSONLexer.token == 13) {
                            throw new JSONException("illegal ref");
                        }
                        jSONLexer.nextToken(16);
                        defaultJSONParser.setContext(parseContext2);
                        return obj2;
                    }
                    parseContext = parseContext2.parent;
                    obj2 = parseContext.object;
                    jSONLexer.nextToken(13);
                    if (jSONLexer.token == 13) {
                        throw new JSONException("illegal ref");
                    }
                    jSONLexer.nextToken(16);
                    defaultJSONParser.setContext(parseContext2);
                    return obj2;
                }
                if (map.size() == 0 && i2 == 4 && JSON.DEFAULT_TYPE_KEY.equals(jSONLexer.stringVal()) && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                    jSONLexer.nextTokenWithChar(c.b);
                    jSONLexer.nextToken(16);
                    if (jSONLexer.token == 13) {
                        jSONLexer.nextToken();
                        defaultJSONParser.setContext(parseContext2);
                        return map;
                    }
                    jSONLexer.nextToken();
                }
                Object objDeserialze = deserializer.deserialze(defaultJSONParser, type, null);
                if (jSONLexer.token != 17) {
                    throw new JSONException("syntax error, expect :, actual " + jSONLexer.token);
                }
                jSONLexer.nextToken();
                Object objDeserialze2 = deserializer2.deserialze(defaultJSONParser, type2, objDeserialze);
                if (defaultJSONParser.resolveStatus == 1) {
                    defaultJSONParser.checkMapResolve(map, objDeserialze);
                }
                map.put(objDeserialze, objDeserialze2);
                if (jSONLexer.token == 16) {
                    jSONLexer.nextToken();
                }
            } catch (Throwable th) {
                defaultJSONParser.setContext(parseContext2);
                throw th;
            }
        }
    }

    public static Map b(DefaultJSONParser defaultJSONParser, Map<String, Object> map, Type type, Object obj) {
        String strScanSymbolUnQuoted;
        Object object;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token != 12) {
            throw new JSONException("syntax error, expect {, actual " + jSONLexer.token);
        }
        ParseContext parseContext = defaultJSONParser.contex;
        while (true) {
            try {
                jSONLexer.skipWhitespace();
                char c = jSONLexer.ch;
                if ((jSONLexer.features & Feature.AllowArbitraryCommas.mask) != 0) {
                    while (c == ',') {
                        jSONLexer.next();
                        jSONLexer.skipWhitespace();
                        c = jSONLexer.ch;
                    }
                }
                if (c == '\"') {
                    strScanSymbolUnQuoted = jSONLexer.scanSymbol(defaultJSONParser.symbolTable, '\"');
                    jSONLexer.skipWhitespace();
                    if (jSONLexer.ch != ':') {
                        throw new JSONException("syntax error, " + jSONLexer.info());
                    }
                } else {
                    if (c == '}') {
                        jSONLexer.next();
                        jSONLexer.sp = 0;
                        jSONLexer.nextToken(16);
                        defaultJSONParser.setContext(parseContext);
                        return map;
                    }
                    if (c == '\'') {
                        if ((jSONLexer.features & Feature.AllowSingleQuotes.mask) == 0) {
                            throw new JSONException("syntax error, " + jSONLexer.info());
                        }
                        strScanSymbolUnQuoted = jSONLexer.scanSymbol(defaultJSONParser.symbolTable, '\'');
                        jSONLexer.skipWhitespace();
                        if (jSONLexer.ch != ':') {
                            throw new JSONException("syntax error, " + jSONLexer.info());
                        }
                    } else {
                        if ((jSONLexer.features & Feature.AllowUnQuotedFieldNames.mask) == 0) {
                            throw new JSONException("syntax error");
                        }
                        strScanSymbolUnQuoted = jSONLexer.scanSymbolUnQuoted(defaultJSONParser.symbolTable);
                        jSONLexer.skipWhitespace();
                        char c2 = jSONLexer.ch;
                        if (c2 != ':') {
                            throw new JSONException("expect ':' at " + jSONLexer.pos + ", actual " + c2);
                        }
                    }
                }
                jSONLexer.next();
                jSONLexer.skipWhitespace();
                jSONLexer.sp = 0;
                if (strScanSymbolUnQuoted != JSON.DEFAULT_TYPE_KEY || jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                    jSONLexer.nextToken();
                    defaultJSONParser.setContext(parseContext);
                    if (jSONLexer.token == 8) {
                        jSONLexer.nextToken();
                        object = null;
                    } else {
                        object = defaultJSONParser.parseObject(type, strScanSymbolUnQuoted);
                    }
                    map.put(strScanSymbolUnQuoted, object);
                    if (defaultJSONParser.resolveStatus == 1) {
                        defaultJSONParser.checkMapResolve(map, strScanSymbolUnQuoted);
                    }
                    defaultJSONParser.setContext(parseContext, object, strScanSymbolUnQuoted);
                    int i = jSONLexer.token;
                    if (i != 20 && i != 15) {
                        if (i == 13) {
                            jSONLexer.nextToken();
                            defaultJSONParser.setContext(parseContext);
                            return map;
                        }
                    }
                    defaultJSONParser.setContext(parseContext);
                    return map;
                }
                Class<?> clsLoadClass = TypeUtils.loadClass(jSONLexer.scanSymbol(defaultJSONParser.symbolTable, '\"'), defaultJSONParser.config.defaultClassLoader);
                if (clsLoadClass != map.getClass()) {
                    ObjectDeserializer deserializer = defaultJSONParser.config.getDeserializer(clsLoadClass);
                    jSONLexer.nextToken(16);
                    defaultJSONParser.resolveStatus = 2;
                    if (parseContext != null && !(obj instanceof Integer)) {
                        defaultJSONParser.popContext();
                    }
                    Map map2 = (Map) deserializer.deserialze(defaultJSONParser, clsLoadClass, obj);
                    defaultJSONParser.setContext(parseContext);
                    return map2;
                }
                jSONLexer.nextToken(16);
                if (jSONLexer.token == 13) {
                    jSONLexer.nextToken(16);
                    defaultJSONParser.setContext(parseContext);
                    return map;
                }
            } catch (Throwable th) {
                defaultJSONParser.setContext(parseContext);
                throw th;
            }
        }
    }

    @Override // com.easyjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        if (type == JSONObject.class && defaultJSONParser.fieldTypeResolver == null) {
            return (T) defaultJSONParser.parseObject();
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        Map<?, ?> mapKdsksdda = kdsksdda(type);
        ParseContext parseContext = defaultJSONParser.contex;
        try {
            defaultJSONParser.setContext(parseContext, mapKdsksdda, obj);
            if (!(type instanceof ParameterizedType)) {
                return (T) defaultJSONParser.parseObject(mapKdsksdda, obj);
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            return String.class == type2 ? (T) b(defaultJSONParser, mapKdsksdda, type3, obj) : (T) a(defaultJSONParser, mapKdsksdda, type2, type3, obj);
        } finally {
            defaultJSONParser.setContext(parseContext);
        }
    }

    public Map<?, ?> kdsksdda(Type type) {
        if (type == Properties.class) {
            return new Properties();
        }
        if (type == Hashtable.class) {
            return new Hashtable();
        }
        if (type == IdentityHashMap.class) {
            return new IdentityHashMap();
        }
        if (type == SortedMap.class || type == TreeMap.class) {
            return new TreeMap();
        }
        if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
            return new ConcurrentHashMap();
        }
        if (type == Map.class || type == HashMap.class) {
            return new HashMap();
        }
        if (type == LinkedHashMap.class) {
            return new LinkedHashMap();
        }
        if (type == JSONObject.class) {
            return new JSONObject();
        }
        if (type instanceof ParameterizedType) {
            return kdsksdda(((ParameterizedType) type).getRawType());
        }
        Class cls = (Class) type;
        if (cls.isInterface()) {
            throw new JSONException("unsupport type " + type);
        }
        try {
            return (Map) cls.newInstance();
        } catch (Exception e) {
            throw new JSONException("unsupport type " + type, e);
        }
    }
}
