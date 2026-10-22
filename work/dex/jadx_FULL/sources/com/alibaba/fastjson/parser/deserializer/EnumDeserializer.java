package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class EnumDeserializer implements ObjectDeserializer {
    protected final Class<?> enumClass;
    protected long[] enumNameHashCodes;
    protected final Enum[] enums;
    protected final Enum[] ordinalEnums;

    public EnumDeserializer(Class<?> cls) {
        JSONField jSONField;
        this.enumClass = cls;
        this.ordinalEnums = (Enum[]) cls.getEnumConstants();
        HashMap map = new HashMap();
        int i = 0;
        while (true) {
            Enum[] enumArr = this.ordinalEnums;
            if (i >= enumArr.length) {
                break;
            }
            Enum r5 = enumArr[i];
            String strName = r5.name();
            JSONField jSONField2 = null;
            try {
                jSONField = (JSONField) TypeUtils.getAnnotation(cls.getField(strName), JSONField.class);
                if (jSONField != null) {
                    try {
                        String strName2 = jSONField.name();
                        if (strName2 != null && strName2.length() > 0) {
                            strName = strName2;
                        }
                    } catch (Exception unused) {
                        jSONField2 = jSONField;
                        jSONField = jSONField2;
                    }
                }
            } catch (Exception unused2) {
            }
            int i2 = 0;
            long j = TypeUtils.fnv1a_64_magic_hashcode;
            long j2 = TypeUtils.fnv1a_64_magic_hashcode;
            while (i2 < strName.length()) {
                int iCharAt = strName.charAt(i2);
                long j3 = ((long) iCharAt) ^ j;
                if (iCharAt >= 65 && iCharAt <= 90) {
                    iCharAt += 32;
                }
                long j4 = j3 * TypeUtils.fnv1a_64_magic_prime;
                j2 = (((long) iCharAt) ^ j2) * TypeUtils.fnv1a_64_magic_prime;
                i2++;
                j = j4;
            }
            map.put(Long.valueOf(j), r5);
            if (j != j2) {
                map.put(Long.valueOf(j2), r5);
            }
            if (jSONField != null) {
                String[] strArrAlternateNames = jSONField.alternateNames();
                int length = strArrAlternateNames.length;
                int i3 = 0;
                while (i3 < length) {
                    String str = strArrAlternateNames[i3];
                    int i4 = 0;
                    long jCharAt = TypeUtils.fnv1a_64_magic_hashcode;
                    while (i4 < str.length()) {
                        jCharAt = (jCharAt ^ ((long) str.charAt(i4))) * TypeUtils.fnv1a_64_magic_prime;
                        i4++;
                        i = i;
                    }
                    int i5 = i;
                    if (jCharAt != j && jCharAt != j2) {
                        map.put(Long.valueOf(jCharAt), r5);
                    }
                    i3++;
                    i = i5;
                }
            }
            i++;
        }
        this.enumNameHashCodes = new long[map.size()];
        Iterator it = map.keySet().iterator();
        int i6 = 0;
        while (it.hasNext()) {
            this.enumNameHashCodes[i6] = ((Long) it.next()).longValue();
            i6++;
        }
        Arrays.sort(this.enumNameHashCodes);
        this.enums = new Enum[this.enumNameHashCodes.length];
        int i7 = 0;
        while (true) {
            long[] jArr = this.enumNameHashCodes;
            if (i7 >= jArr.length) {
                return;
            }
            this.enums[i7] = (Enum) map.get(Long.valueOf(jArr[i7]));
            i7++;
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        try {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            int i = jSONLexer.token();
            if (i == 2) {
                int iIntValue = jSONLexer.intValue();
                jSONLexer.nextToken(16);
                if (iIntValue >= 0) {
                    Object[] objArr = this.ordinalEnums;
                    if (iIntValue < objArr.length) {
                        return (T) objArr[iIntValue];
                    }
                }
                throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + iIntValue);
            }
            if (i != 4) {
                if (i == 8) {
                    jSONLexer.nextToken(16);
                    return null;
                }
                throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + defaultJSONParser.parse());
            }
            String strStringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            if (strStringVal.length() == 0) {
                return null;
            }
            long j = TypeUtils.fnv1a_64_magic_hashcode;
            long j2 = -3750763034362895579L;
            for (int i2 = 0; i2 < strStringVal.length(); i2++) {
                int iCharAt = strStringVal.charAt(i2);
                long j3 = j ^ ((long) iCharAt);
                if (iCharAt >= 65 && iCharAt <= 90) {
                    iCharAt += 32;
                }
                j = j3 * TypeUtils.fnv1a_64_magic_prime;
                j2 = (j2 ^ ((long) iCharAt)) * TypeUtils.fnv1a_64_magic_prime;
            }
            T t = (T) getEnumByHashCode(j);
            if (t == null && j2 != j) {
                t = (T) getEnumByHashCode(j2);
            }
            if (t == null && jSONLexer.isEnabled(Feature.ErrorOnEnumNotMatch)) {
                throw new JSONException("not match enum value, " + this.enumClass.getName() + " : " + strStringVal);
            }
            return t;
        } catch (JSONException e) {
            throw e;
        } catch (Exception e2) {
            throw new JSONException(e2.getMessage(), e2);
        }
    }

    public Enum getEnumByHashCode(long j) {
        int iBinarySearch;
        if (this.enums != null && (iBinarySearch = Arrays.binarySearch(this.enumNameHashCodes, j)) >= 0) {
            return this.enums[iBinarySearch];
        }
        return null;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    public Enum<?> valueOf(int i) {
        return this.ordinalEnums[i];
    }
}
