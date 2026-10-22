package com.zj.adlib;

import com.hp.hpl.sparta.EncodingMismatchException;
import com.hp.hpl.sparta.ParseException;
import com.hp.hpl.sparta.ParseHandler;
import com.hp.hpl.sparta.ParseLog;
import com.hp.hpl.sparta.ParseSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class qm6 implements ParseSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public rm6 f44244a;

    public qm6(String str, InputStream inputStream, ParseLog parseLog, String str2, ParseHandler parseHandler) throws ParseException, IOException {
        ParseLog parseLog2 = parseLog == null ? ParseSource.f6848a : parseLog;
        if (!inputStream.markSupported()) {
            throw new Error("Precondition violation: the InputStream passed to ParseByteStream must support mark");
        }
        inputStream.mark(ParseSource.f32694a);
        byte[] bArr = new byte[4];
        String strE = str2 == null ? e(str, bArr, inputStream.read(bArr), parseLog2) : str2;
        try {
            inputStream.reset();
            try {
                this.f44244a = new rm6(str, new InputStreamReader(inputStream, d(strE)), parseLog2, strE, parseHandler);
            } catch (IOException unused) {
                parseLog2.b("Problem reading with assumed encoding of " + strE + " so restarting with euc-jp", str, 1);
                inputStream.reset();
                try {
                    this.f44244a = new rm6(str, new InputStreamReader(inputStream, d("euc-jp")), parseLog2, (String) null, parseHandler);
                } catch (UnsupportedEncodingException unused2) {
                    throw new ParseException(parseLog2, str, 1, 0, "euc-jp", "\"euc-jp\" is not a supported encoding");
                }
            }
        } catch (EncodingMismatchException e) {
            String declaredEncoding = e.getDeclaredEncoding();
            parseLog2.b("Encoding declaration of " + declaredEncoding + " is different that assumed " + strE + " so restarting the parsing with the new encoding", str, 1);
            inputStream.reset();
            try {
                this.f44244a = new rm6(str, new InputStreamReader(inputStream, d(declaredEncoding)), parseLog2, (String) null, parseHandler);
            } catch (UnsupportedEncodingException unused3) {
                throw new ParseException(parseLog2, str, 1, 0, declaredEncoding, "\"" + declaredEncoding + "\" is not a supported encoding");
            }
        }
    }

    public static boolean b(byte[] bArr, int i) {
        return bArr[0] == ((byte) (i >>> 24)) && bArr[1] == ((byte) ((i >>> 16) & 255)) && bArr[2] == ((byte) ((i >>> 8) & 255)) && bArr[3] == ((byte) (i & 255));
    }

    public static boolean c(byte[] bArr, short s) {
        return bArr[0] == ((byte) (s >>> 8)) && bArr[1] == ((byte) (s & 255));
    }

    public static String d(String str) {
        return str.toLowerCase().equals("utf8") ? "UTF-8" : str;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00b8  */
    /* JADX WARN: Instruction removed from duplicated block: B:46:0x00b8, please report this as an issue */
    public static String e(String str, byte[] bArr, int i, ParseLog parseLog) throws IOException {
        String str2;
        String str3;
        if (i == 4) {
            if (b(bArr, 65279) || b(bArr, -131072) || b(bArr, 65534) || b(bArr, -16842752) || b(bArr, 60) || b(bArr, 1006632960) || b(bArr, 15360) || b(bArr, 3932160)) {
                str2 = "UCS-4";
            } else if (b(bArr, 3932223)) {
                str2 = "UTF-16BE";
            } else if (b(bArr, 1006649088)) {
                str2 = "UTF-16LE";
            } else if (!b(bArr, 1010792557)) {
                if (b(bArr, 1282385812)) {
                    str2 = "EBCDIC";
                } else if (c(bArr, (short) -2) || c(bArr, (short) -257)) {
                    str2 = "UTF-16";
                }
            }
            if (!str2.equals("UTF-8")) {
                parseLog.b("From start " + f(bArr[0]) + " " + f(bArr[1]) + " " + f(bArr[2]) + " " + f(bArr[3]) + " deduced encoding = " + str2, str, 1);
            }
            return str2;
        }
        if (i <= 0) {
            str3 = "no characters in input";
        } else {
            str3 = "less than 4 characters in input: \"" + new String(bArr, 0, i) + "\"";
        }
        parseLog.c(str3, str, 1);
        str2 = "UTF-8";
        if (!str2.equals("UTF-8")) {
            parseLog.b("From start " + f(bArr[0]) + " " + f(bArr[1]) + " " + f(bArr[2]) + " " + f(bArr[3]) + " deduced encoding = " + str2, str, 1);
        }
        return str2;
    }

    public static String f(byte b) {
        String hexString = Integer.toHexString(b);
        int length = hexString.length();
        if (length != 1) {
            return length != 2 ? hexString.substring(hexString.length() - 2) : hexString;
        }
        return "0" + hexString;
    }

    @Override // com.hp.hpl.sparta.ParseSource
    public int getLineNumber() {
        return this.f44244a.getLineNumber();
    }

    @Override // com.hp.hpl.sparta.ParseSource
    public String getSystemId() {
        return this.f44244a.getSystemId();
    }

    @Override // com.hp.hpl.sparta.ParseSource
    public String toString() {
        return this.f44244a.toString();
    }
}
