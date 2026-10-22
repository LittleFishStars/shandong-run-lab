package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MapDeserializer extends ContextObjectDeserializer implements ObjectDeserializer {
    public static MapDeserializer instance = new MapDeserializer();

    public static Map parseMap(DefaultJSONParser defaultJSONParser, Map<String, Object> map, Type type, Object obj) {
        return parseMap(defaultJSONParser, map, type, obj, 0);
    }

    public Map<Object, Object> createMap(Type type) {
        return createMap(type, JSON.DEFAULT_GENERATE_FEATURE);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, String str, int i) {
        if (type == JSONObject.class && defaultJSONParser.getFieldTypeResolver() == null) {
            return (T) defaultJSONParser.parseObject();
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        boolean z = (type instanceof Class) && "java.util.Collections$UnmodifiableMap".equals(((Class) type).getName());
        Map<Object, Object> mapCreateMap = (jSONLexer.getFeatures() & Feature.OrderedField.mask) != 0 ? createMap(type, jSONLexer.getFeatures()) : createMap(type);
        ParseContext context = defaultJSONParser.getContext();
        try {
            defaultJSONParser.setContext(context, mapCreateMap, obj);
            Map map = (T) deserialze(defaultJSONParser, type, obj, mapCreateMap, i);
            if (z) {
                map = (T) Collections.unmodifiableMap(map);
            }
            return (T) map;
        } finally {
            defaultJSONParser.setContext(context);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    /* JADX WARN: Code duplicated, block: B:130:0x021f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:0x0226 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x01eb A[Catch: all -> 0x0255, TRY_ENTER, TryCatch #0 {all -> 0x0255, blocks: (B:25:0x00a6, B:29:0x00b9, B:33:0x00ce, B:58:0x0164, B:60:0x0176, B:62:0x017e, B:64:0x0184, B:68:0x019b, B:71:0x01a6, B:74:0x01ad, B:75:0x01b5, B:77:0x01bd, B:79:0x01c6, B:82:0x01cd, B:84:0x01da, B:86:0x01de, B:87:0x01e1, B:90:0x01eb, B:92:0x01f0, B:93:0x01f3, B:95:0x01fb, B:97:0x0204, B:103:0x021f, B:96:0x0200, B:36:0x00e1, B:37:0x00f9, B:40:0x00fe, B:45:0x0112, B:47:0x011a, B:50:0x012c, B:51:0x0144, B:52:0x0145, B:53:0x014a, B:54:0x014b, B:56:0x0153, B:109:0x022e, B:110:0x024e, B:111:0x024f, B:112:0x0254), top: B:117:0x00a6 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x01f0 A[Catch: all -> 0x0255, TryCatch #0 {all -> 0x0255, blocks: (B:25:0x00a6, B:29:0x00b9, B:33:0x00ce, B:58:0x0164, B:60:0x0176, B:62:0x017e, B:64:0x0184, B:68:0x019b, B:71:0x01a6, B:74:0x01ad, B:75:0x01b5, B:77:0x01bd, B:79:0x01c6, B:82:0x01cd, B:84:0x01da, B:86:0x01de, B:87:0x01e1, B:90:0x01eb, B:92:0x01f0, B:93:0x01f3, B:95:0x01fb, B:97:0x0204, B:103:0x021f, B:96:0x0200, B:36:0x00e1, B:37:0x00f9, B:40:0x00fe, B:45:0x0112, B:47:0x011a, B:50:0x012c, B:51:0x0144, B:52:0x0145, B:53:0x014a, B:54:0x014b, B:56:0x0153, B:109:0x022e, B:110:0x024e, B:111:0x024f, B:112:0x0254), top: B:117:0x00a6 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x01fb A[Catch: all -> 0x0255, TryCatch #0 {all -> 0x0255, blocks: (B:25:0x00a6, B:29:0x00b9, B:33:0x00ce, B:58:0x0164, B:60:0x0176, B:62:0x017e, B:64:0x0184, B:68:0x019b, B:71:0x01a6, B:74:0x01ad, B:75:0x01b5, B:77:0x01bd, B:79:0x01c6, B:82:0x01cd, B:84:0x01da, B:86:0x01de, B:87:0x01e1, B:90:0x01eb, B:92:0x01f0, B:93:0x01f3, B:95:0x01fb, B:97:0x0204, B:103:0x021f, B:96:0x0200, B:36:0x00e1, B:37:0x00f9, B:40:0x00fe, B:45:0x0112, B:47:0x011a, B:50:0x012c, B:51:0x0144, B:52:0x0145, B:53:0x014a, B:54:0x014b, B:56:0x0153, B:109:0x022e, B:110:0x024e, B:111:0x024f, B:112:0x0254), top: B:117:0x00a6 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x0200 A[Catch: all -> 0x0255, TryCatch #0 {all -> 0x0255, blocks: (B:25:0x00a6, B:29:0x00b9, B:33:0x00ce, B:58:0x0164, B:60:0x0176, B:62:0x017e, B:64:0x0184, B:68:0x019b, B:71:0x01a6, B:74:0x01ad, B:75:0x01b5, B:77:0x01bd, B:79:0x01c6, B:82:0x01cd, B:84:0x01da, B:86:0x01de, B:87:0x01e1, B:90:0x01eb, B:92:0x01f0, B:93:0x01f3, B:95:0x01fb, B:97:0x0204, B:103:0x021f, B:96:0x0200, B:36:0x00e1, B:37:0x00f9, B:40:0x00fe, B:45:0x0112, B:47:0x011a, B:50:0x012c, B:51:0x0144, B:52:0x0145, B:53:0x014a, B:54:0x014b, B:56:0x0153, B:109:0x022e, B:110:0x024e, B:111:0x024f, B:112:0x0254), top: B:117:0x00a6 }] */
    public static Map parseMap(DefaultJSONParser defaultJSONParser, Map<String, Object> map, Type type, Object obj, int i) {
        String strScanSymbolUnQuoted;
        Object object;
        int i2;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i3 = jSONLexer.token();
        int i4 = 0;
        if (i3 != 12) {
            if (i3 == 4) {
                String strStringVal = jSONLexer.stringVal();
                if (strStringVal.length() == 0 || strStringVal.equals("null")) {
                    return null;
                }
            }
            String str = "syntax error, expect {, actual " + jSONLexer.tokenName();
            if (obj instanceof String) {
                str = (str + ", fieldName ") + obj;
            }
            String str2 = (str + ", ") + jSONLexer.info();
            if (i3 != 4) {
                JSONArray jSONArray = new JSONArray();
                defaultJSONParser.parseArray(jSONArray, obj);
                if (jSONArray.size() == 1) {
                    Object obj2 = jSONArray.get(0);
                    if (obj2 instanceof JSONObject) {
                        return (JSONObject) obj2;
                    }
                }
            }
            throw new JSONException(str2);
        }
        ParseContext context = defaultJSONParser.getContext();
        while (true) {
            try {
                jSONLexer.skipWhitespace();
                char current = jSONLexer.getCurrent();
                if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                    while (current == ',') {
                        jSONLexer.next();
                        jSONLexer.skipWhitespace();
                        current = jSONLexer.getCurrent();
                    }
                }
                if (current == '\"') {
                    strScanSymbolUnQuoted = jSONLexer.scanSymbol(defaultJSONParser.getSymbolTable(), '\"');
                    jSONLexer.skipWhitespace();
                    if (jSONLexer.getCurrent() != ':') {
                        throw new JSONException("expect ':' at " + jSONLexer.pos());
                    }
                } else {
                    if (current == '}') {
                        jSONLexer.next();
                        jSONLexer.resetStringPosition();
                        jSONLexer.nextToken(16);
                        defaultJSONParser.setContext(context);
                        return map;
                    }
                    if (current == '\'') {
                        if (!jSONLexer.isEnabled(Feature.AllowSingleQuotes)) {
                            throw new JSONException("syntax error");
                        }
                        strScanSymbolUnQuoted = jSONLexer.scanSymbol(defaultJSONParser.getSymbolTable(), '\'');
                        jSONLexer.skipWhitespace();
                        if (jSONLexer.getCurrent() != ':') {
                            throw new JSONException("expect ':' at " + jSONLexer.pos());
                        }
                    } else {
                        if (!jSONLexer.isEnabled(Feature.AllowUnQuotedFieldNames)) {
                            throw new JSONException("syntax error");
                        }
                        strScanSymbolUnQuoted = jSONLexer.scanSymbolUnQuoted(defaultJSONParser.getSymbolTable());
                        jSONLexer.skipWhitespace();
                        char current2 = jSONLexer.getCurrent();
                        if (current2 != ':') {
                            throw new JSONException("expect ':' at " + jSONLexer.pos() + ", actual " + current2);
                        }
                    }
                }
                jSONLexer.next();
                jSONLexer.skipWhitespace();
                jSONLexer.getCurrent();
                jSONLexer.resetStringPosition();
                if (strScanSymbolUnQuoted != JSON.DEFAULT_TYPE_KEY) {
                    jSONLexer.nextToken();
                    if (i4 != 0) {
                        defaultJSONParser.setContext(context);
                    }
                    if (jSONLexer.token() == 8) {
                        jSONLexer.nextToken();
                        object = null;
                    } else {
                        object = defaultJSONParser.parseObject(type, strScanSymbolUnQuoted);
                    }
                    map.put(strScanSymbolUnQuoted, object);
                    defaultJSONParser.checkMapResolve(map, strScanSymbolUnQuoted);
                    defaultJSONParser.setContext(context, object, strScanSymbolUnQuoted);
                    defaultJSONParser.setContext(context);
                    i2 = jSONLexer.token();
                    if (i2 != 20) {
                        if (i2 == 13) {
                            jSONLexer.nextToken();
                            defaultJSONParser.setContext(context);
                            return map;
                        }
                    }
                    defaultJSONParser.setContext(context);
                    return map;
                }
                Feature feature = Feature.DisableSpecialKeyDetect;
                if (jSONLexer.isEnabled(feature) || Feature.isEnabled(i, feature)) {
                    jSONLexer.nextToken();
                    if (i4 != 0) {
                        defaultJSONParser.setContext(context);
                    }
                    if (jSONLexer.token() == 8) {
                        jSONLexer.nextToken();
                        object = null;
                    } else {
                        object = defaultJSONParser.parseObject(type, strScanSymbolUnQuoted);
                    }
                    map.put(strScanSymbolUnQuoted, object);
                    defaultJSONParser.checkMapResolve(map, strScanSymbolUnQuoted);
                    defaultJSONParser.setContext(context, object, strScanSymbolUnQuoted);
                    defaultJSONParser.setContext(context);
                    i2 = jSONLexer.token();
                    if (i2 != 20 && i2 != 15) {
                        if (i2 == 13) {
                            jSONLexer.nextToken();
                            defaultJSONParser.setContext(context);
                            return map;
                        }
                    }
                    defaultJSONParser.setContext(context);
                    return map;
                }
                String strScanSymbol = jSONLexer.scanSymbol(defaultJSONParser.getSymbolTable(), '\"');
                ParserConfig config = defaultJSONParser.getConfig();
                Class<?> clsCheckAutoType = HashMap.class;
                if (!strScanSymbol.equals("java.util.HashMap")) {
                    if (strScanSymbol.equals("java.util.LinkedHashMap")) {
                        clsCheckAutoType = LinkedHashMap.class;
                    } else if (!config.isSafeMode()) {
                        try {
                            clsCheckAutoType = config.checkAutoType(strScanSymbol, null, jSONLexer.getFeatures());
                        } catch (JSONException unused) {
                        }
                    }
                }
                if (!Map.class.isAssignableFrom(clsCheckAutoType)) {
                    ObjectDeserializer deserializer = config.getDeserializer(clsCheckAutoType);
                    jSONLexer.nextToken(16);
                    defaultJSONParser.setResolveStatus(2);
                    if (context != null && !(obj instanceof Integer)) {
                        defaultJSONParser.popContext();
                    }
                    Map map2 = (Map) deserializer.deserialze(defaultJSONParser, clsCheckAutoType, obj);
                    defaultJSONParser.setContext(context);
                    return map2;
                }
                jSONLexer.nextToken(16);
                if (jSONLexer.token() == 13) {
                    jSONLexer.nextToken(16);
                    defaultJSONParser.setContext(context);
                    return map;
                }
                i4++;
            } catch (Throwable th) {
                defaultJSONParser.setContext(context);
                throw th;
            }
        }
    }

    public Map<Object, Object> createMap(Type type, int i) {
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
        if (type == Map.class) {
            return (Feature.OrderedField.mask & i) != 0 ? new LinkedHashMap() : new HashMap();
        }
        if (type == HashMap.class) {
            return new HashMap();
        }
        if (type == LinkedHashMap.class) {
            return new LinkedHashMap();
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            return EnumMap.class.equals(rawType) ? new EnumMap((Class) parameterizedType.getActualTypeArguments()[0]) : createMap(rawType, i);
        }
        Class cls = (Class) type;
        if (cls.isInterface()) {
            throw new JSONException("unsupport type " + type);
        }
        if ("java.util.Collections$UnmodifiableMap".equals(cls.getName())) {
            return new HashMap();
        }
        try {
            return (Map) cls.newInstance();
        } catch (Exception e) {
            throw new JSONException("unsupport type " + type, e);
        }
    }

    public Object deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, Map map) {
        return deserialze(defaultJSONParser, type, obj, map, 0);
    }

    public Object deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, Map map, int i) {
        Type type2;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type type3 = parameterizedType.getActualTypeArguments()[0];
            if (map.getClass().getName().equals("org.springframework.util.LinkedMultiValueMap")) {
                type2 = List.class;
            } else {
                type2 = parameterizedType.getActualTypeArguments()[1];
            }
            if (String.class == type3) {
                return parseMap(defaultJSONParser, (Map<String, Object>) map, type2, obj, i);
            }
            return parseMap(defaultJSONParser, (Map<Object, Object>) map, type3, type2, obj);
        }
        return defaultJSONParser.parseObject(map, obj);
    }

    public static Object parseMap(DefaultJSONParser defaultJSONParser, Map<Object, Object> map, Type type, Type type2, Object obj) {
        Object objDeserialze;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() != 12 && jSONLexer.token() != 16) {
            throw new JSONException("syntax error, expect {, actual " + jSONLexer.tokenName());
        }
        ObjectDeserializer deserializer = defaultJSONParser.getConfig().getDeserializer(type);
        ObjectDeserializer deserializer2 = defaultJSONParser.getConfig().getDeserializer(type2);
        jSONLexer.nextToken(deserializer.getFastMatchToken());
        ParseContext context = defaultJSONParser.getContext();
        while (jSONLexer.token() != 13) {
            try {
                Object obj2 = null;
                if (jSONLexer.token() == 4 && jSONLexer.isRef() && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                    jSONLexer.nextTokenWithColon(4);
                    if (jSONLexer.token() == 4) {
                        String strStringVal = jSONLexer.stringVal();
                        if ("..".equals(strStringVal)) {
                            obj2 = context.parent.object;
                        } else if ("$".equals(strStringVal)) {
                            ParseContext parseContext = context;
                            while (true) {
                                ParseContext parseContext2 = parseContext.parent;
                                if (parseContext2 == null) {
                                    break;
                                }
                                parseContext = parseContext2;
                            }
                            obj2 = parseContext.object;
                        } else {
                            defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(context, strStringVal));
                            defaultJSONParser.setResolveStatus(1);
                        }
                        jSONLexer.nextToken(13);
                        if (jSONLexer.token() == 13) {
                            jSONLexer.nextToken(16);
                            defaultJSONParser.setContext(context);
                            return obj2;
                        }
                        throw new JSONException("illegal ref");
                    }
                    throw new JSONException("illegal ref, " + JSONToken.name(jSONLexer.token()));
                }
                if (map.size() == 0 && jSONLexer.token() == 4 && JSON.DEFAULT_TYPE_KEY.equals(jSONLexer.stringVal()) && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                    jSONLexer.nextTokenWithColon(4);
                    jSONLexer.nextToken(16);
                    if (jSONLexer.token() == 13) {
                        jSONLexer.nextToken();
                        defaultJSONParser.setContext(context);
                        return map;
                    }
                    jSONLexer.nextToken(deserializer.getFastMatchToken());
                }
                if (jSONLexer.token() == 4 && (deserializer instanceof JavaBeanDeserializer)) {
                    String strStringVal2 = jSONLexer.stringVal();
                    jSONLexer.nextToken();
                    DefaultJSONParser defaultJSONParser2 = new DefaultJSONParser(strStringVal2, defaultJSONParser.getConfig(), defaultJSONParser.getLexer().getFeatures());
                    defaultJSONParser2.setDateFormat(defaultJSONParser.getDateFomartPattern());
                    objDeserialze = deserializer.deserialze(defaultJSONParser2, type, null);
                } else {
                    objDeserialze = deserializer.deserialze(defaultJSONParser, type, null);
                }
                if (jSONLexer.token() == 17) {
                    jSONLexer.nextToken(deserializer2.getFastMatchToken());
                    Object objDeserialze2 = deserializer2.deserialze(defaultJSONParser, type2, objDeserialze);
                    defaultJSONParser.checkMapResolve(map, objDeserialze);
                    map.put(objDeserialze, objDeserialze2);
                    if (jSONLexer.token() == 16) {
                        jSONLexer.nextToken(deserializer.getFastMatchToken());
                    }
                } else {
                    throw new JSONException("syntax error, expect :, actual " + jSONLexer.token());
                }
            } catch (Throwable th) {
                defaultJSONParser.setContext(context);
                throw th;
            }
        }
        jSONLexer.nextToken(16);
        defaultJSONParser.setContext(context);
        return map;
    }
}
