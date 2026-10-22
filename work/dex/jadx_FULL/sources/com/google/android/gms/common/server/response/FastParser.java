package com.google.android.gms.common.server.response;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.zj.adlib.cp4;
import com.zj.adlib.um0;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ShowFirstParty
@KeepForSdk
public class FastParser<T extends FastJsonResponse> {

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final char[] f5699d = {'u', 'l', 'l'};

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final char[] f5700e = {'r', 'u', 'e'};

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final char[] f5701f = {'r', 'u', 'e', '\"'};

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static final char[] f5702g = {'a', 'l', 's', 'e'};

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public static final char[] f5703h = {'a', 'l', 's', 'e', '\"'};
    public static final char[] i = {'\n'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zai f31315a = new a();
    public static final zai b = new b();
    public static final zai c = new c();
    public static final zai d = new d();
    public static final zai e = new e();
    public static final zai f = new f();
    public static final zai g = new g();
    public static final zai h = new h();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final char[] f5706a = new char[1];

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final char[] f5708b = new char[32];

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final char[] f5709c = new char[1024];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final StringBuilder f5704a = new StringBuilder(32);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final StringBuilder f5707b = new StringBuilder(1024);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Stack f5705a = new Stack();

    @ShowFirstParty
    @KeepForSdk
    public static class ParseException extends Exception {
        public ParseException(@NonNull String str) {
            super(str);
        }

        public ParseException(@NonNull String str, @NonNull Throwable th) {
            super("Error instantiating inner object", th);
        }

        public ParseException(@NonNull Throwable th) {
            super(th);
        }
    }

    public static final String b(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, @Nullable char[] cArr2) throws ParseException, IOException {
        sb.setLength(0);
        bufferedReader.mark(cArr.length);
        boolean z = false;
        boolean z2 = false;
        while (true) {
            int i2 = bufferedReader.read(cArr);
            if (i2 == -1) {
                throw new ParseException("Unexpected EOF while parsing string");
            }
            for (int i3 = 0; i3 < i2; i3++) {
                char c2 = cArr[i3];
                if (Character.isISOControl(c2)) {
                    if (cArr2 != null) {
                        int i4 = 0;
                        while (true) {
                            if (i4 <= 0) {
                                if (cArr2[i4] == c2) {
                                    break;
                                }
                                i4++;
                            }
                        }
                    }
                    throw new ParseException("Unexpected control character while reading string");
                }
                if (c2 != '\"') {
                    if (c2 == '\\') {
                        z2 = !z2;
                        z = true;
                    }
                } else if (!z2) {
                    sb.append(cArr, 0, i3);
                    bufferedReader.reset();
                    bufferedReader.skip(i3 + 1);
                    return z ? cp4.c(sb.toString()) : sb.toString();
                }
                z2 = false;
            }
            sb.append(cArr, 0, i2);
            bufferedReader.mark(cArr.length);
        }
    }

    public final boolean A(BufferedReader bufferedReader, boolean z) throws ParseException, IOException {
        char cK = k(bufferedReader);
        if (cK == '\"') {
            if (z) {
                throw new ParseException("No boolean value found in string");
            }
            return A(bufferedReader, true);
        }
        if (cK == 'f') {
            z(bufferedReader, z ? f5703h : f5702g);
            return false;
        }
        if (cK == 'n') {
            z(bufferedReader, f5699d);
            return false;
        }
        if (cK == 't') {
            z(bufferedReader, z ? f5701f : f5700e);
            return true;
        }
        throw new ParseException("Unexpected token: " + cK);
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0255  */
    /* JADX WARN: Code duplicated, block: B:129:0x026f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:130:0x0258 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:131:0x0253 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean B(BufferedReader bufferedReader, FastJsonResponse fastJsonResponse) throws ParseException, IOException {
        int i2;
        HashMap map;
        char cK;
        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
        String strS = s(bufferedReader);
        if (strS == null) {
            y(1);
            return false;
        }
        while (strS != null) {
            FastJsonResponse.Field<?, ?> field = fieldMappings.get(strS);
            if (field == null) {
                strS = t(bufferedReader);
            } else {
                this.f5705a.push(4);
                int i3 = field.zaa;
                switch (i3) {
                    case 0:
                        if (field.zab) {
                            fastJsonResponse.zav(field, w(bufferedReader, f31315a));
                        } else {
                            fastJsonResponse.zau(field, n(bufferedReader));
                        }
                        i2 = 4;
                        y(i2);
                        y(2);
                        cK = k(bufferedReader);
                        if (cK == ',') {
                            strS = s(bufferedReader);
                        } else {
                            if (cK != '}') {
                                throw new ParseException("Expected end of object or field separator, but found: " + cK);
                            }
                            strS = null;
                        }
                        break;
                    case 1:
                        if (field.zab) {
                            fastJsonResponse.zag(field, w(bufferedReader, g));
                        } else {
                            fastJsonResponse.zae(field, v(bufferedReader));
                        }
                        i2 = 4;
                        y(i2);
                        y(2);
                        cK = k(bufferedReader);
                        if (cK == ',') {
                            strS = s(bufferedReader);
                        } else {
                            if (cK != '}') {
                                throw new ParseException("Expected end of object or field separator, but found: " + cK);
                            }
                            strS = null;
                        }
                        break;
                    case 2:
                        if (field.zab) {
                            fastJsonResponse.zay(field, w(bufferedReader, b));
                        } else {
                            fastJsonResponse.zax(field, p(bufferedReader));
                        }
                        i2 = 4;
                        y(i2);
                        y(2);
                        cK = k(bufferedReader);
                        if (cK == ',') {
                            strS = s(bufferedReader);
                        } else {
                            if (cK != '}') {
                                throw new ParseException("Expected end of object or field separator, but found: " + cK);
                            }
                            strS = null;
                        }
                        break;
                    case 3:
                        if (field.zab) {
                            fastJsonResponse.zas(field, w(bufferedReader, c));
                        } else {
                            fastJsonResponse.zaq(field, m(bufferedReader));
                        }
                        i2 = 4;
                        y(i2);
                        y(2);
                        cK = k(bufferedReader);
                        if (cK == ',') {
                            strS = s(bufferedReader);
                        } else {
                            if (cK != '}') {
                                throw new ParseException("Expected end of object or field separator, but found: " + cK);
                            }
                            strS = null;
                        }
                        break;
                    case 4:
                        if (field.zab) {
                            fastJsonResponse.zao(field, w(bufferedReader, d));
                        } else {
                            fastJsonResponse.zam(field, l(bufferedReader));
                        }
                        i2 = 4;
                        y(i2);
                        y(2);
                        cK = k(bufferedReader);
                        if (cK == ',') {
                            strS = s(bufferedReader);
                        } else {
                            if (cK != '}') {
                                throw new ParseException("Expected end of object or field separator, but found: " + cK);
                            }
                            strS = null;
                        }
                        break;
                    case 5:
                        if (field.zab) {
                            fastJsonResponse.zac(field, w(bufferedReader, h));
                        } else {
                            fastJsonResponse.zaa(field, u(bufferedReader));
                        }
                        i2 = 4;
                        y(i2);
                        y(2);
                        cK = k(bufferedReader);
                        if (cK == ',') {
                            strS = s(bufferedReader);
                        } else {
                            if (cK != '}') {
                                throw new ParseException("Expected end of object or field separator, but found: " + cK);
                            }
                            strS = null;
                        }
                        break;
                    case 6:
                        if (field.zab) {
                            fastJsonResponse.zaj(field, w(bufferedReader, e));
                        } else {
                            fastJsonResponse.zai(field, A(bufferedReader, false));
                        }
                        i2 = 4;
                        y(i2);
                        y(2);
                        cK = k(bufferedReader);
                        if (cK == ',') {
                            strS = s(bufferedReader);
                        } else {
                            if (cK != '}') {
                                throw new ParseException("Expected end of object or field separator, but found: " + cK);
                            }
                            strS = null;
                        }
                        break;
                    case 7:
                        if (field.zab) {
                            fastJsonResponse.zaC(field, w(bufferedReader, f));
                        } else {
                            fastJsonResponse.zaA(field, q(bufferedReader));
                        }
                        i2 = 4;
                        y(i2);
                        y(2);
                        cK = k(bufferedReader);
                        if (cK == ',') {
                            strS = s(bufferedReader);
                        } else {
                            if (cK != '}') {
                                throw new ParseException("Expected end of object or field separator, but found: " + cK);
                            }
                            strS = null;
                        }
                        break;
                    case 8:
                        fastJsonResponse.zal(field, um0.a(r(bufferedReader, this.f5709c, this.f5707b, i)));
                        i2 = 4;
                        y(i2);
                        y(2);
                        cK = k(bufferedReader);
                        if (cK == ',') {
                            strS = s(bufferedReader);
                        } else {
                            if (cK != '}') {
                                throw new ParseException("Expected end of object or field separator, but found: " + cK);
                            }
                            strS = null;
                        }
                        break;
                    case 9:
                        fastJsonResponse.zal(field, um0.b(r(bufferedReader, this.f5709c, this.f5707b, i)));
                        i2 = 4;
                        y(i2);
                        y(2);
                        cK = k(bufferedReader);
                        if (cK == ',') {
                            strS = s(bufferedReader);
                        } else {
                            if (cK != '}') {
                                throw new ParseException("Expected end of object or field separator, but found: " + cK);
                            }
                            strS = null;
                        }
                        break;
                    case 10:
                        char cK2 = k(bufferedReader);
                        if (cK2 == 'n') {
                            z(bufferedReader, f5699d);
                            map = null;
                        } else {
                            if (cK2 != '{') {
                                throw new ParseException("Expected start of a map object");
                            }
                            this.f5705a.push(1);
                            map = new HashMap();
                            while (true) {
                                char cK3 = k(bufferedReader);
                                if (cK3 == 0) {
                                    throw new ParseException("Unexpected EOF");
                                }
                                if (cK3 == '\"') {
                                    String strB = b(bufferedReader, this.f5708b, this.f5704a, null);
                                    if (k(bufferedReader) != ':') {
                                        throw new ParseException("No map value found for key ".concat(String.valueOf(strB)));
                                    }
                                    if (k(bufferedReader) != '\"') {
                                        throw new ParseException("Expected String value for key ".concat(String.valueOf(strB)));
                                    }
                                    map.put(strB, b(bufferedReader, this.f5708b, this.f5704a, null));
                                    char cK4 = k(bufferedReader);
                                    if (cK4 != ',') {
                                        if (cK4 != '}') {
                                            throw new ParseException("Unexpected character while parsing string map: " + cK4);
                                        }
                                        y(1);
                                    }
                                } else if (cK3 == '}') {
                                    y(1);
                                }
                                i2 = 4;
                                y(i2);
                                y(2);
                                cK = k(bufferedReader);
                                if (cK == ',') {
                                    strS = s(bufferedReader);
                                } else {
                                    if (cK != '}') {
                                        throw new ParseException("Expected end of object or field separator, but found: " + cK);
                                    }
                                    strS = null;
                                }
                            }
                        }
                        fastJsonResponse.zaB(field, map);
                        i2 = 4;
                        y(i2);
                        y(2);
                        cK = k(bufferedReader);
                        if (cK == ',') {
                            strS = s(bufferedReader);
                        } else {
                            if (cK != '}') {
                                throw new ParseException("Expected end of object or field separator, but found: " + cK);
                            }
                            strS = null;
                        }
                        break;
                    case 11:
                        if (!field.zab) {
                            char cK5 = k(bufferedReader);
                            if (cK5 == 'n') {
                                z(bufferedReader, f5699d);
                                fastJsonResponse.addConcreteTypeInternal(field, field.zae, null);
                            } else {
                                this.f5705a.push(1);
                                if (cK5 != '{') {
                                    throw new ParseException("Expected start of object");
                                }
                                try {
                                    FastJsonResponse fastJsonResponseZad = field.zad();
                                    B(bufferedReader, fastJsonResponseZad);
                                    fastJsonResponse.addConcreteTypeInternal(field, field.zae, fastJsonResponseZad);
                                } catch (IllegalAccessException e2) {
                                    throw new ParseException("Error instantiating inner object", e2);
                                } catch (InstantiationException e3) {
                                    throw new ParseException("Error instantiating inner object", e3);
                                }
                            }
                            break;
                        } else {
                            char cK6 = k(bufferedReader);
                            if (cK6 == 'n') {
                                z(bufferedReader, f5699d);
                                fastJsonResponse.addConcreteTypeArrayInternal(field, field.zae, null);
                            } else {
                                this.f5705a.push(5);
                                if (cK6 != '[') {
                                    throw new ParseException("Expected array start");
                                }
                                fastJsonResponse.addConcreteTypeArrayInternal(field, field.zae, x(bufferedReader, field));
                            }
                        }
                        i2 = 4;
                        y(i2);
                        y(2);
                        cK = k(bufferedReader);
                        if (cK == ',') {
                            strS = s(bufferedReader);
                        } else {
                            if (cK != '}') {
                                throw new ParseException("Expected end of object or field separator, but found: " + cK);
                            }
                            strS = null;
                        }
                        break;
                    default:
                        throw new ParseException("Invalid field type " + i3);
                }
            }
        }
        y(1);
        return true;
    }

    @KeepForSdk
    public void a(@NonNull InputStream inputStream, @NonNull T t) throws ParseException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);
        try {
            try {
                this.f5705a.push(0);
                char cK = k(bufferedReader);
                if (cK == 0) {
                    throw new ParseException("No data to parse");
                }
                if (cK == '[') {
                    this.f5705a.push(5);
                    Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = t.getFieldMappings();
                    if (fieldMappings.size() != 1) {
                        throw new ParseException("Object array response class must have a single Field");
                    }
                    FastJsonResponse.Field<?, ?> value = fieldMappings.entrySet().iterator().next().getValue();
                    t.addConcreteTypeArrayInternal(value, value.zae, x(bufferedReader, value));
                } else {
                    if (cK != '{') {
                        throw new ParseException("Unexpected token: " + cK);
                    }
                    this.f5705a.push(1);
                    B(bufferedReader, t);
                }
                y(0);
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                    Log.w("FastParser", "Failed to close reader while parsing.");
                }
            } catch (IOException e2) {
                throw new ParseException(e2);
            }
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
                Log.w("FastParser", "Failed to close reader while parsing.");
            }
            throw th;
        }
    }

    public final char k(BufferedReader bufferedReader) throws ParseException, IOException {
        if (bufferedReader.read(this.f5706a) == -1) {
            return (char) 0;
        }
        while (Character.isWhitespace(this.f5706a[0])) {
            if (bufferedReader.read(this.f5706a) == -1) {
                return (char) 0;
            }
        }
        return this.f5706a[0];
    }

    public final double l(BufferedReader bufferedReader) throws ParseException, IOException {
        int iO = o(bufferedReader, this.f5709c);
        return iO == 0 ? AudioStats.AUDIO_AMPLITUDE_NONE : Double.parseDouble(new String(this.f5709c, 0, iO));
    }

    public final float m(BufferedReader bufferedReader) throws ParseException, IOException {
        int iO = o(bufferedReader, this.f5709c);
        if (iO == 0) {
            return 0.0f;
        }
        return Float.parseFloat(new String(this.f5709c, 0, iO));
    }

    public final int n(BufferedReader bufferedReader) throws ParseException, IOException {
        int i2;
        int i3;
        int iO = o(bufferedReader, this.f5709c);
        if (iO == 0) {
            return 0;
        }
        char[] cArr = this.f5709c;
        if (iO <= 0) {
            throw new ParseException("No number to parse");
        }
        char c2 = cArr[0];
        int i4 = c2 == '-' ? Integer.MIN_VALUE : -2147483647;
        int i5 = c2 == '-' ? 1 : 0;
        if (i5 < iO) {
            i3 = i5 + 1;
            int iDigit = Character.digit(cArr[i5], 10);
            if (iDigit < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            i2 = -iDigit;
        } else {
            i2 = 0;
            i3 = i5;
        }
        while (i3 < iO) {
            int i6 = i3 + 1;
            int iDigit2 = Character.digit(cArr[i3], 10);
            if (iDigit2 < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            if (i2 < -214748364) {
                throw new ParseException("Number too large");
            }
            int i7 = i2 * 10;
            if (i7 < i4 + iDigit2) {
                throw new ParseException("Number too large");
            }
            i2 = i7 - iDigit2;
            i3 = i6;
        }
        if (i5 == 0) {
            return -i2;
        }
        if (i3 > 1) {
            return i2;
        }
        throw new ParseException("No digits to parse");
    }

    public final int o(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i2;
        char cK = k(bufferedReader);
        if (cK == 0) {
            throw new ParseException("Unexpected EOF");
        }
        if (cK == ',') {
            throw new ParseException("Missing value");
        }
        if (cK == 'n') {
            z(bufferedReader, f5699d);
            return 0;
        }
        bufferedReader.mark(1024);
        if (cK == '\"') {
            i2 = 0;
            boolean z = false;
            while (i2 < 1024 && bufferedReader.read(cArr, i2, 1) != -1) {
                char c2 = cArr[i2];
                if (Character.isISOControl(c2)) {
                    throw new ParseException("Unexpected control character while reading string");
                }
                if (c2 != '\"') {
                    if (c2 == '\\') {
                        z = !z;
                    }
                    i2++;
                } else if (!z) {
                    bufferedReader.reset();
                    bufferedReader.skip(i2 + 1);
                    return i2;
                }
                z = false;
                i2++;
            }
        } else {
            cArr[0] = cK;
            i2 = 1;
            while (i2 < 1024 && bufferedReader.read(cArr, i2, 1) != -1) {
                char c3 = cArr[i2];
                if (c3 == '}' || c3 == ',' || Character.isWhitespace(c3) || cArr[i2] == ']') {
                    bufferedReader.reset();
                    bufferedReader.skip(i2 - 1);
                    cArr[i2] = 0;
                    return i2;
                }
                i2++;
            }
        }
        if (i2 == 1024) {
            throw new ParseException("Absurdly long value");
        }
        throw new ParseException("Unexpected EOF");
    }

    public final long p(BufferedReader bufferedReader) throws ParseException, IOException {
        long j;
        int i2;
        int iO = o(bufferedReader, this.f5709c);
        if (iO == 0) {
            return 0L;
        }
        char[] cArr = this.f5709c;
        if (iO <= 0) {
            throw new ParseException("No number to parse");
        }
        char c2 = cArr[0];
        long j2 = c2 == '-' ? Long.MIN_VALUE : -9223372036854775807L;
        int i3 = c2 == '-' ? 1 : 0;
        if (i3 < iO) {
            i2 = i3 + 1;
            int iDigit = Character.digit(cArr[i3], 10);
            if (iDigit < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            j = -iDigit;
        } else {
            j = 0;
            i2 = i3;
        }
        while (i2 < iO) {
            int i4 = i2 + 1;
            int iDigit2 = Character.digit(cArr[i2], 10);
            if (iDigit2 < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            if (j < com.airbnb.lottie.parser.moshi.a.b) {
                throw new ParseException("Number too large");
            }
            long j3 = j * 10;
            int i5 = iO;
            long j4 = iDigit2;
            if (j3 < j2 + j4) {
                throw new ParseException("Number too large");
            }
            j = j3 - j4;
            iO = i5;
            i2 = i4;
        }
        if (i3 == 0) {
            return -j;
        }
        if (i2 > 1) {
            return j;
        }
        throw new ParseException("No digits to parse");
    }

    @Nullable
    public final String q(BufferedReader bufferedReader) throws ParseException, IOException {
        return r(bufferedReader, this.f5708b, this.f5704a, null);
    }

    @Nullable
    public final String r(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, @Nullable char[] cArr2) throws ParseException, IOException {
        char cK = k(bufferedReader);
        if (cK == '\"') {
            return b(bufferedReader, cArr, sb, cArr2);
        }
        if (cK != 'n') {
            throw new ParseException("Expected string");
        }
        z(bufferedReader, f5699d);
        return null;
    }

    @Nullable
    public final String s(BufferedReader bufferedReader) throws ParseException, IOException {
        this.f5705a.push(2);
        char cK = k(bufferedReader);
        if (cK == '\"') {
            this.f5705a.push(3);
            String strB = b(bufferedReader, this.f5708b, this.f5704a, null);
            y(3);
            if (k(bufferedReader) == ':') {
                return strB;
            }
            throw new ParseException("Expected key/value separator");
        }
        if (cK == ']') {
            y(2);
            y(1);
            y(5);
            return null;
        }
        if (cK == '}') {
            y(2);
            return null;
        }
        throw new ParseException("Unexpected token: " + cK);
    }

    @Nullable
    public final String t(BufferedReader bufferedReader) throws ParseException, IOException {
        bufferedReader.mark(1024);
        char cK = k(bufferedReader);
        int i2 = 1;
        if (cK != '\"') {
            if (cK == ',') {
                throw new ParseException("Missing value");
            }
            if (cK == '[') {
                this.f5705a.push(5);
                bufferedReader.mark(32);
                if (k(bufferedReader) == ']') {
                    y(5);
                } else {
                    bufferedReader.reset();
                    boolean z = false;
                    boolean z2 = false;
                    while (i2 > 0) {
                        char cK2 = k(bufferedReader);
                        if (cK2 == 0) {
                            throw new ParseException("Unexpected EOF while parsing array");
                        }
                        if (Character.isISOControl(cK2)) {
                            throw new ParseException("Unexpected control character while reading array");
                        }
                        if (cK2 == '\"') {
                            if (!z2) {
                                z = !z;
                            }
                            cK2 = '\"';
                        }
                        if (cK2 == '[') {
                            if (!z) {
                                i2++;
                            }
                            cK2 = '[';
                        }
                        if (cK2 == ']' && !z) {
                            i2--;
                        }
                        z2 = (cK2 == '\\' && z) ? !z2 : false;
                    }
                    y(5);
                }
            } else if (cK != '{') {
                bufferedReader.reset();
                o(bufferedReader, this.f5709c);
            } else {
                this.f5705a.push(1);
                bufferedReader.mark(32);
                char cK3 = k(bufferedReader);
                if (cK3 == '}') {
                    y(1);
                } else {
                    if (cK3 != '\"') {
                        throw new ParseException("Unexpected token " + cK3);
                    }
                    bufferedReader.reset();
                    s(bufferedReader);
                    while (t(bufferedReader) != null) {
                    }
                    y(1);
                }
            }
        } else {
            if (bufferedReader.read(this.f5706a) == -1) {
                throw new ParseException("Unexpected EOF while parsing string");
            }
            char c2 = this.f5706a[0];
            boolean z3 = false;
            while (true) {
                if (c2 == '\"') {
                    if (!z3) {
                        break;
                    }
                    c2 = '\"';
                    z3 = true;
                }
                z3 = c2 == '\\' ? !z3 : false;
                if (bufferedReader.read(this.f5706a) == -1) {
                    throw new ParseException("Unexpected EOF while parsing string");
                }
                c2 = this.f5706a[0];
                if (Character.isISOControl(c2)) {
                    throw new ParseException("Unexpected control character while reading string");
                }
            }
        }
        char cK4 = k(bufferedReader);
        if (cK4 == ',') {
            y(2);
            return s(bufferedReader);
        }
        if (cK4 == '}') {
            y(2);
            return null;
        }
        throw new ParseException("Unexpected token " + cK4);
    }

    @Nullable
    public final BigDecimal u(BufferedReader bufferedReader) throws ParseException, IOException {
        int iO = o(bufferedReader, this.f5709c);
        if (iO == 0) {
            return null;
        }
        return new BigDecimal(new String(this.f5709c, 0, iO));
    }

    @Nullable
    public final BigInteger v(BufferedReader bufferedReader) throws ParseException, IOException {
        int iO = o(bufferedReader, this.f5709c);
        if (iO == 0) {
            return null;
        }
        return new BigInteger(new String(this.f5709c, 0, iO));
    }

    @Nullable
    public final ArrayList w(BufferedReader bufferedReader, zai zaiVar) throws ParseException, IOException {
        char cK = k(bufferedReader);
        if (cK == 'n') {
            z(bufferedReader, f5699d);
            return null;
        }
        if (cK != '[') {
            throw new ParseException("Expected start of array");
        }
        this.f5705a.push(5);
        ArrayList arrayList = new ArrayList();
        while (true) {
            bufferedReader.mark(1024);
            char cK2 = k(bufferedReader);
            if (cK2 == 0) {
                throw new ParseException("Unexpected EOF");
            }
            if (cK2 != ',') {
                if (cK2 == ']') {
                    y(5);
                    return arrayList;
                }
                bufferedReader.reset();
                arrayList.add(zaiVar.a(this, bufferedReader));
            }
        }
    }

    @Nullable
    public final ArrayList x(BufferedReader bufferedReader, FastJsonResponse.Field field) throws ParseException, IOException {
        ArrayList arrayList = new ArrayList();
        char cK = k(bufferedReader);
        if (cK == ']') {
            y(5);
            return arrayList;
        }
        if (cK == 'n') {
            z(bufferedReader, f5699d);
            y(5);
            return null;
        }
        if (cK != '{') {
            throw new ParseException("Unexpected token: " + cK);
        }
        this.f5705a.push(1);
        while (true) {
            try {
                FastJsonResponse fastJsonResponseZad = field.zad();
                if (!B(bufferedReader, fastJsonResponseZad)) {
                    return arrayList;
                }
                arrayList.add(fastJsonResponseZad);
                char cK2 = k(bufferedReader);
                if (cK2 != ',') {
                    if (cK2 == ']') {
                        y(5);
                        return arrayList;
                    }
                    throw new ParseException("Unexpected token: " + cK2);
                }
                if (k(bufferedReader) != '{') {
                    throw new ParseException("Expected start of next object in array");
                }
                this.f5705a.push(1);
            } catch (IllegalAccessException e2) {
                throw new ParseException("Error instantiating inner object", e2);
            } catch (InstantiationException e3) {
                throw new ParseException("Error instantiating inner object", e3);
            }
        }
    }

    public final void y(int i2) throws ParseException {
        if (this.f5705a.isEmpty()) {
            throw new ParseException("Expected state " + i2 + " but had empty stack");
        }
        int iIntValue = ((Integer) this.f5705a.pop()).intValue();
        if (iIntValue == i2) {
            return;
        }
        throw new ParseException("Expected state " + i2 + " but had " + iIntValue);
    }

    public final void z(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i2 = 0;
        while (true) {
            int length = cArr.length;
            if (i2 >= length) {
                return;
            }
            int i3 = bufferedReader.read(this.f5708b, 0, length - i2);
            if (i3 == -1) {
                throw new ParseException("Unexpected EOF");
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (cArr[i4 + i2] != this.f5708b[i4]) {
                    throw new ParseException("Unexpected character");
                }
            }
            i2 += i3;
        }
    }
}
