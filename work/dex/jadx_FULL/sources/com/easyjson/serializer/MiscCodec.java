package com.easyjson.serializer;

import com.ali.auth.third.login.LoginConstants;
import com.easyjson.JSON;
import com.easyjson.JSONAware;
import com.easyjson.JSONException;
import com.easyjson.JSONStreamAware;
import com.easyjson.parser.DefaultJSONParser;
import com.easyjson.parser.Feature;
import com.easyjson.parser.JSONLexer;
import com.easyjson.parser.JSONToken;
import com.easyjson.parser.deserializer.ObjectDeserializer;
import com.easyjson.util.TypeUtils;
import com.google.common.net.c;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Enumeration;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class MiscCodec implements ObjectSerializer, ObjectDeserializer {
    public static final MiscCodec instance = new MiscCodec();

    private MiscCodec() {
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [T, java.text.DateFormat, java.text.SimpleDateFormat] */
    @Override // com.easyjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Object obj2;
        if (type == StackTraceElement.class) {
            return (T) parseStackTraceElement(defaultJSONParser);
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (defaultJSONParser.resolveStatus == 2) {
            defaultJSONParser.resolveStatus = 0;
            defaultJSONParser.accept(16);
            if (jSONLexer.token() != 4) {
                throw new JSONException("syntax error");
            }
            if (!"val".equals(jSONLexer.stringVal())) {
                throw new JSONException("syntax error");
            }
            jSONLexer.nextToken();
            defaultJSONParser.accept(17);
            obj2 = defaultJSONParser.parse();
            defaultJSONParser.accept(13);
        } else {
            obj2 = defaultJSONParser.parse();
        }
        if (obj2 == null) {
            return null;
        }
        if (!(obj2 instanceof String)) {
            throw new JSONException("except string value");
        }
        String str = (String) obj2;
        if (str.length() == 0) {
            return null;
        }
        if (type == UUID.class) {
            return (T) UUID.fromString(str);
        }
        if (type == Class.class) {
            return (T) TypeUtils.loadClass(str, defaultJSONParser.config.defaultClassLoader);
        }
        if (type == Locale.class) {
            String[] strArrSplit = str.split(LoginConstants.UNDER_LINE);
            if (strArrSplit.length == 1) {
                return (T) new Locale(strArrSplit[0]);
            }
            return strArrSplit.length == 2 ? (T) new Locale(strArrSplit[0], strArrSplit[1]) : (T) new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
        }
        if (type == URI.class) {
            return (T) URI.create(str);
        }
        if (type == URL.class) {
            try {
                return (T) new URL(str);
            } catch (MalformedURLException e) {
                throw new JSONException("create url error", e);
            }
        }
        if (type == Pattern.class) {
            return (T) Pattern.compile(str);
        }
        if (type == Charset.class) {
            return (T) Charset.forName(str);
        }
        if (type == Currency.class) {
            return (T) Currency.getInstance(str);
        }
        if (type != SimpleDateFormat.class) {
            return (type == Character.TYPE || type == Character.class) ? (T) TypeUtils.castToChar(str) : (T) TimeZone.getTimeZone(str);
        }
        ?? r7 = (T) new SimpleDateFormat(str, defaultJSONParser.lexer.locale);
        r7.setTimeZone(defaultJSONParser.lexer.timeZone);
        return r7;
    }

    public <T> T parseStackTraceElement(DefaultJSONParser defaultJSONParser) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
            return null;
        }
        if (jSONLexer.token() != 12 && jSONLexer.token() != 16) {
            throw new JSONException("syntax error: " + JSONToken.name(jSONLexer.token()));
        }
        int iIntValue = 0;
        String strStringVal = null;
        String strStringVal2 = null;
        String strStringVal3 = null;
        while (true) {
            String strScanSymbol = jSONLexer.scanSymbol(defaultJSONParser.symbolTable);
            if (strScanSymbol == null) {
                if (jSONLexer.token() == 13) {
                    break;
                }
                if (jSONLexer.token() != 16 || (jSONLexer.features & Feature.AllowArbitraryCommas.mask) == 0) {
                }
            }
            jSONLexer.nextTokenWithChar(c.b);
            if ("className".equals(strScanSymbol)) {
                if (jSONLexer.token() == 8) {
                    strStringVal = null;
                } else {
                    if (jSONLexer.token() != 4) {
                        throw new JSONException("syntax error");
                    }
                    strStringVal = jSONLexer.stringVal();
                }
            } else if ("methodName".equals(strScanSymbol)) {
                if (jSONLexer.token() == 8) {
                    strStringVal2 = null;
                } else {
                    if (jSONLexer.token() != 4) {
                        throw new JSONException("syntax error");
                    }
                    strStringVal2 = jSONLexer.stringVal();
                }
            } else if ("fileName".equals(strScanSymbol)) {
                if (jSONLexer.token() == 8) {
                    strStringVal3 = null;
                } else {
                    if (jSONLexer.token() != 4) {
                        throw new JSONException("syntax error");
                    }
                    strStringVal3 = jSONLexer.stringVal();
                }
            } else if ("lineNumber".equals(strScanSymbol)) {
                if (jSONLexer.token() == 8) {
                    iIntValue = 0;
                } else {
                    if (jSONLexer.token() != 2) {
                        throw new JSONException("syntax error");
                    }
                    iIntValue = jSONLexer.intValue();
                }
            } else if ("nativeMethod".equals(strScanSymbol)) {
                if (jSONLexer.token() != 8 && jSONLexer.token() != 6 && jSONLexer.token() != 7) {
                    throw new JSONException("syntax error");
                }
                jSONLexer.nextToken(16);
            } else {
                if (strScanSymbol != JSON.DEFAULT_TYPE_KEY) {
                    throw new JSONException("syntax error : " + strScanSymbol);
                }
                if (jSONLexer.token() == 4) {
                    String strStringVal4 = jSONLexer.stringVal();
                    if (!strStringVal4.equals("java.lang.StackTraceElement")) {
                        throw new JSONException("syntax error : " + strStringVal4);
                    }
                } else if (jSONLexer.token() != 8) {
                    throw new JSONException("syntax error");
                }
            }
            if (jSONLexer.token() == 13) {
                break;
            }
        }
        jSONLexer.nextToken(16);
        return (T) new StackTraceElement(strStringVal, strStringVal2, strStringVal3, iIntValue);
    }

    @Override // com.easyjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) {
        String string;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            if (type == Character.TYPE || type == Character.class) {
                jSONSerializer.write("");
                return;
            } else if ((serializeWriter.features & SerializerFeature.WriteNullListAsEmpty.mask) == 0 || !Enumeration.class.isAssignableFrom(TypeUtils.getClass(type))) {
                serializeWriter.writeNull();
                return;
            } else {
                serializeWriter.write("[]");
                return;
            }
        }
        if (obj instanceof Pattern) {
            string = ((Pattern) obj).pattern();
        } else if (obj instanceof TimeZone) {
            string = ((TimeZone) obj).getID();
        } else if (obj instanceof Currency) {
            string = ((Currency) obj).getCurrencyCode();
        } else if (obj instanceof Class) {
            string = ((Class) obj).getName();
        } else if (obj instanceof Character) {
            Character ch = (Character) obj;
            string = ch.charValue() == 0 ? "\u0000" : ch.toString();
        } else {
            int i = 0;
            if (obj instanceof SimpleDateFormat) {
                String pattern = ((SimpleDateFormat) obj).toPattern();
                if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) == 0 || obj.getClass() == type) {
                    serializeWriter.writeString(pattern);
                    return;
                }
                serializeWriter.write(123);
                serializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY, false);
                jSONSerializer.write(obj.getClass().getName());
                serializeWriter.write(44);
                serializeWriter.writeFieldName("val", false);
                serializeWriter.writeString(pattern);
                serializeWriter.write(125);
                return;
            }
            if (obj instanceof JSONStreamAware) {
                ((JSONStreamAware) obj).writeJSONString(serializeWriter);
                return;
            }
            if (obj instanceof JSONAware) {
                serializeWriter.write(((JSONAware) obj).toJSONString());
                return;
            }
            if (obj instanceof JSONSerializable) {
                ((JSONSerializable) obj).write(jSONSerializer, obj2, type);
                return;
            }
            if (obj instanceof Enumeration) {
                Type type2 = ((serializeWriter.features & SerializerFeature.WriteClassName.mask) == 0 || !(type instanceof ParameterizedType)) ? null : ((ParameterizedType) type).getActualTypeArguments()[0];
                Enumeration enumeration = (Enumeration) obj;
                SerialContext serialContext = jSONSerializer.context;
                jSONSerializer.setContext(serialContext, obj, obj2, 0);
                try {
                    serializeWriter.write(91);
                    while (enumeration.hasMoreElements()) {
                        Object objNextElement = enumeration.nextElement();
                        int i2 = i + 1;
                        if (i != 0) {
                            serializeWriter.write(44);
                        }
                        if (objNextElement == null) {
                            serializeWriter.writeNull();
                        } else {
                            jSONSerializer.config.get(objNextElement.getClass()).write(jSONSerializer, objNextElement, Integer.valueOf(i2 - 1), type2);
                        }
                        i = i2;
                    }
                    serializeWriter.write(93);
                    return;
                } finally {
                    jSONSerializer.context = serialContext;
                }
            }
            string = obj.toString();
        }
        jSONSerializer.write(string);
    }
}
