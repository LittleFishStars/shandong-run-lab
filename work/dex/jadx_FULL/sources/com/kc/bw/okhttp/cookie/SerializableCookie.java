package com.kc.bw.okhttp.cookie;

import android.content.ContentValues;
import android.database.Cursor;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Locale;
import okhttp3.Cookie;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SerializableCookie implements Serializable {
    public static final long serialVersionUID = 6374381323722046732L;
    public transient Cookie clientCookie;
    public transient Cookie cookie;
    public String domain;
    public String host;
    public String name;
    public static final String HOST = dexg.dexa("iptu");
    public static final String NAME = dexg.dexa("obnf");
    public static final String DOMAIN = dexg.dexa("epnbjo");
    public static final String COOKIE = dexg.dexa("dppljf");

    public SerializableCookie(String str, Cookie cookie) {
        this.cookie = cookie;
        this.host = str;
        this.name = cookie.name();
        this.domain = cookie.domain();
    }

    public static String byteArrayToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            int i = b & 255;
            if (i < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(i));
        }
        return sb.toString().toUpperCase(Locale.US);
    }

    public static Cookie bytesToCookie(byte[] bArr) {
        try {
            return ((SerializableCookie) new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject()).getCookie();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static byte[] cookieToBytes(String str, Cookie cookie) {
        SerializableCookie serializableCookie = new SerializableCookie(str, cookie);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(serializableCookie);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            return null;
        }
    }

    public static Cookie decodeCookie(String str) {
        return bytesToCookie(hexStringToByteArray(str));
    }

    public static String encodeCookie(String str, Cookie cookie) {
        if (cookie == null) {
            return null;
        }
        return byteArrayToHexString(cookieToBytes(str, cookie));
    }

    public static ContentValues getContentValues(SerializableCookie serializableCookie) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(HOST, serializableCookie.host);
        contentValues.put(NAME, serializableCookie.name);
        contentValues.put(DOMAIN, serializableCookie.domain);
        contentValues.put(COOKIE, cookieToBytes(serializableCookie.host, serializableCookie.getCookie()));
        return contentValues;
    }

    public static byte[] hexStringToByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    public static SerializableCookie parseCursorToBean(Cursor cursor) {
        return new SerializableCookie(cursor.getString(cursor.getColumnIndex(HOST)), bytesToCookie(cursor.getBlob(cursor.getColumnIndex(COOKIE))));
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        String str = (String) objectInputStream.readObject();
        String str2 = (String) objectInputStream.readObject();
        long j = objectInputStream.readLong();
        String str3 = (String) objectInputStream.readObject();
        String str4 = (String) objectInputStream.readObject();
        boolean z = objectInputStream.readBoolean();
        boolean z2 = objectInputStream.readBoolean();
        boolean z3 = objectInputStream.readBoolean();
        objectInputStream.readBoolean();
        Cookie.Builder builderExpiresAt = new Cookie.Builder().name(str).value(str2).expiresAt(j);
        Cookie.Builder builderPath = (z3 ? builderExpiresAt.hostOnlyDomain(str3) : builderExpiresAt.domain(str3)).path(str4);
        if (z) {
            builderPath = builderPath.secure();
        }
        if (z2) {
            builderPath = builderPath.httpOnly();
        }
        this.clientCookie = builderPath.build();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.cookie.name());
        objectOutputStream.writeObject(this.cookie.value());
        objectOutputStream.writeLong(this.cookie.expiresAt());
        objectOutputStream.writeObject(this.cookie.domain());
        objectOutputStream.writeObject(this.cookie.path());
        objectOutputStream.writeBoolean(this.cookie.secure());
        objectOutputStream.writeBoolean(this.cookie.httpOnly());
        objectOutputStream.writeBoolean(this.cookie.hostOnly());
        objectOutputStream.writeBoolean(this.cookie.persistent());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SerializableCookie.class != obj.getClass()) {
            return false;
        }
        SerializableCookie serializableCookie = (SerializableCookie) obj;
        String str = this.host;
        if (str == null ? serializableCookie.host != null : !str.equals(serializableCookie.host)) {
            return false;
        }
        String str2 = this.name;
        if (str2 == null ? serializableCookie.name != null : !str2.equals(serializableCookie.name)) {
            return false;
        }
        String str3 = this.domain;
        String str4 = serializableCookie.domain;
        if (str3 != null) {
            return str3.equals(str4);
        }
        return str4 == null;
    }

    public Cookie getCookie() {
        Cookie cookie = this.cookie;
        Cookie cookie2 = this.clientCookie;
        return cookie2 != null ? cookie2 : cookie;
    }

    public int hashCode() {
        String str = this.host;
        int iHashCode = str != null ? str.hashCode() : 0;
        String str2 = this.name;
        int iHashCode2 = str2 != null ? str2.hashCode() : 0;
        String str3 = this.domain;
        return (((iHashCode * 31) + iHashCode2) * 31) + (str3 != null ? str3.hashCode() : 0);
    }
}
