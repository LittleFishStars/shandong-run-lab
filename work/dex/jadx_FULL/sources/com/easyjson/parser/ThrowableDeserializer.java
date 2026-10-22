package com.easyjson.parser;

import com.easyjson.JSON;
import com.easyjson.JSONException;
import com.easyjson.util.TypeUtils;
import com.google.common.net.c;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ThrowableDeserializer extends JavaBeanDeserializer {
    public ThrowableDeserializer(ParserConfig parserConfig, Class<?> cls) {
        super(parserConfig, cls, cls);
    }

    /* JADX WARN: Code duplicated, block: B:106:0x00d5 A[EDGE_INSN: B:106:0x00d5->B:56:0x00d5 BREAK  A[LOOP:0: B:20:0x003a->B:98:0x016d], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:18:0x0031  */
    /* JADX WARN: Code duplicated, block: B:88:0x0156 A[Catch: Exception -> 0x0163, TRY_LEAVE, TryCatch #0 {Exception -> 0x0163, blocks: (B:59:0x00e1, B:62:0x00ed, B:78:0x0127, B:65:0x00f8, B:68:0x0101, B:71:0x010d, B:73:0x0115, B:75:0x011e, B:80:0x012d, B:85:0x014f, B:88:0x0156, B:82:0x013c, B:84:0x0148), top: B:101:0x00e1 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x015c  */
    /* JADX WARN: Code duplicated, block: B:97:0x016c  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.reflect.Constructor] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.reflect.Constructor] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.reflect.Constructor] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    @Override // com.easyjson.parser.JavaBeanDeserializer, com.easyjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Class<?> clsLoadClass;
        Object objStringVal;
        ?? r11;
        Throwable th;
        Object objNewInstance;
        Object obj2;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token;
        Type type2 = null;
        if (i == 8) {
            jSONLexer.nextToken();
            return null;
        }
        if (defaultJSONParser.resolveStatus == 2) {
            defaultJSONParser.resolveStatus = 0;
        } else if (i != 12) {
            throw new JSONException("syntax error");
        }
        if (type == null || !(type instanceof Class)) {
            clsLoadClass = null;
        } else {
            clsLoadClass = (Class) type;
            if (!Throwable.class.isAssignableFrom(clsLoadClass)) {
                clsLoadClass = null;
            }
        }
        HashMap map = new HashMap();
        Throwable th2 = null;
        ?? r12 = 0;
        StackTraceElement[] stackTraceElementArr = null;
        while (true) {
            String strScanSymbol = jSONLexer.scanSymbol(defaultJSONParser.symbolTable);
            if (strScanSymbol == null) {
                int i2 = jSONLexer.token;
                if (i2 == 13) {
                    break;
                }
                if (i2 != 16 || (jSONLexer.features & Feature.AllowArbitraryCommas.mask) == 0) {
                }
                r12 = r12;
            }
            jSONLexer.nextTokenWithChar(c.b);
            if (!JSON.DEFAULT_TYPE_KEY.equals(strScanSymbol)) {
                if ("message".equals(strScanSymbol)) {
                    int i3 = jSONLexer.token;
                    if (i3 == 8) {
                        objStringVal = type2;
                    } else {
                        if (i3 != 4) {
                            throw new JSONException("syntax error");
                        }
                        objStringVal = jSONLexer.stringVal();
                    }
                    jSONLexer.nextToken();
                    r11 = objStringVal;
                } else if ("cause".equals(strScanSymbol)) {
                    th2 = (Throwable) deserialze(defaultJSONParser, type2, "cause");
                    r12 = r12;
                } else if ("stackTrace".equals(strScanSymbol)) {
                    stackTraceElementArr = (StackTraceElement[]) defaultJSONParser.parseObject((Class) StackTraceElement[].class);
                    r12 = r12;
                } else {
                    map.put(strScanSymbol, defaultJSONParser.parse());
                    r12 = r12;
                }
                if (jSONLexer.token == 13) {
                    break;
                }
                type2 = null;
                r12 = r12;
            } else {
                if (jSONLexer.token != 4) {
                    throw new JSONException("syntax error");
                }
                clsLoadClass = TypeUtils.loadClass(jSONLexer.stringVal(), defaultJSONParser.config.defaultClassLoader);
                jSONLexer.nextToken(16);
                r11 = r12;
            }
            r12 = r11;
            if (jSONLexer.token == 13) {
                break;
                break;
            }
            type2 = null;
            r12 = r12;
        }
        jSONLexer.nextToken(16);
        if (clsLoadClass == null) {
            obj2 = (T) new Exception(r12, th2);
        } else {
            try {
                Constructor<?>[] constructors = clsLoadClass.getConstructors();
                int length = constructors.length;
                Type type3 = type2;
                Type type4 = type3;
                ?? r7 = type4;
                int i4 = 0;
                ?? r5 = type3;
                ?? r6 = type4;
                while (i4 < length) {
                    Constructor<?> constructor = constructors[i4];
                    if (constructor.getParameterTypes().length == 0) {
                        r7 = constructor;
                    } else if (constructor.getParameterTypes().length == 1 && constructor.getParameterTypes()[0] == String.class) {
                        r6 = constructor;
                    } else if (constructor.getParameterTypes().length == 2 && constructor.getParameterTypes()[0] == String.class && constructor.getParameterTypes()[1] == Throwable.class) {
                        r5 = constructor;
                    }
                    i4++;
                    r5 = r5;
                    r6 = r6;
                    r7 = r7;
                }
                if (r5 != 0) {
                    objNewInstance = r5.newInstance(new Object[]{r12, th2});
                } else if (r6 != 0) {
                    objNewInstance = r6.newInstance(new Object[]{r12});
                } else {
                    if (r7 != 0) {
                        objNewInstance = r7.newInstance(new Object[0]);
                    } else {
                        th = null;
                    }
                    if (th == null) {
                        obj2 = (T) new Exception(r12, th2);
                    } else {
                        obj2 = (T) th;
                    }
                }
                th = (Throwable) objNewInstance;
                if (th == null) {
                    obj2 = (T) new Exception(r12, th2);
                } else {
                    obj2 = (T) th;
                }
            } catch (Exception e) {
                throw new JSONException("create instance error", e);
            }
        }
        if (stackTraceElementArr != null) {
            ((Throwable) obj2).setStackTrace(stackTraceElementArr);
        }
        return (T) obj2;
    }
}
