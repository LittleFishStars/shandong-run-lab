package com.alipay.android.phone.mobilesdk.socketcraft.g;

import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidDataException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static CodingErrorAction f25311a = CodingErrorAction.REPORT;

    public static byte[] a(String str) {
        try {
            return str.getBytes("UTF8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] b(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static String b(byte[] bArr) {
        return a(ByteBuffer.wrap(bArr));
    }

    public static String a(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, i2, "ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String a(ByteBuffer byteBuffer) throws InvalidDataException {
        CharsetDecoder charsetDecoderNewDecoder = Charset.forName("UTF8").newDecoder();
        charsetDecoderNewDecoder.onMalformedInput(f25311a);
        charsetDecoderNewDecoder.onUnmappableCharacter(f25311a);
        try {
            byteBuffer.mark();
            String string = charsetDecoderNewDecoder.decode(byteBuffer).toString();
            byteBuffer.reset();
            return string;
        } catch (CharacterCodingException e) {
            throw new InvalidDataException(1007, e);
        }
    }
}
