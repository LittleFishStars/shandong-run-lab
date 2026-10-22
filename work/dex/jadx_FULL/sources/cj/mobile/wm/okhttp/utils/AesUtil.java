package cj.mobile.wm.okhttp.utils;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import cj.mobile.wm.dexc;
import com.zj.adlib.o61;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AesUtil {
    public static int decryptErrorCount;
    public static int decryptToByteErrorCount;
    public static int encryptBytErrorCount;
    public static int encryptBytStrErrorCount;
    public static int encryptStrErrorCount;
    public static String ivParameter;
    public static String sKey;
    public static final String TAG = dexc.dexa("XN`BftVujm");
    public static final String encodingFormat = dexc.dexa("vug.9");

    public static String base64Decode(String str) {
        try {
            return new String(Base64.decode(str, 0));
        } catch (Throwable th) {
            Log.e(TAG, dexc.dexa("cbtf75Efdpef!fssps!") + Log.getStackTraceString(th));
            return str;
        }
    }

    public static String base64Encode(String str) {
        try {
            return Base64.encodeToString(str.getBytes(), 0);
        } catch (Throwable th) {
            Log.e(TAG, dexc.dexa("cbtf75Fodpef!fssps!") + Log.getStackTraceString(th));
            return str;
        }
    }

    public static String decodeData(String str) {
        try {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] - 3);
            }
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (Throwable th) {
            Log.e(TAG, dexc.dexa("efdpefEbub!fssps!") + Log.getStackTraceString(th));
            return str;
        }
    }

    public static String decrypt(String str, String str2, String str3) {
        try {
            String strMd5Decode = md5Decode(str2);
            if (!TextUtils.isEmpty(strMd5Decode) && strMd5Decode.length() > 16) {
                sKey = strMd5Decode.substring(0, 16);
                ivParameter = strMd5Decode.substring(16, strMd5Decode.length());
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(sKey.getBytes(dexc.dexa("BTDJJ")), dexc.dexa("BFT"));
            Cipher cipher = Cipher.getInstance(dexc.dexa("BFT0DCD0QLDT6Qbeejoh"));
            cipher.init(2, secretKeySpec, new IvParameterSpec(ivParameter.getBytes()));
            return new String(cipher.doFinal(parseHexStr2Byte(str)), encodingFormat);
        } catch (Throwable th) {
            int i = decryptErrorCount + 1;
            decryptErrorCount = i;
            if (i >= 3) {
                return "";
            }
            Log.e(TAG, dexc.dexa(o61.h) + str3 + dexc.dexa("^!efdszqu!fssps!") + Log.getStackTraceString(th));
            return "";
        }
    }

    public static String decryptByte(byte[] bArr, String str) {
        try {
            String strMd5Decode = md5Decode(str);
            if (!TextUtils.isEmpty(strMd5Decode) && strMd5Decode.length() > 16) {
                sKey = strMd5Decode.substring(0, 16);
                ivParameter = strMd5Decode.substring(16, strMd5Decode.length());
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(sKey.getBytes(dexc.dexa("BTDJJ")), dexc.dexa("BFT"));
            Cipher cipher = Cipher.getInstance(dexc.dexa("BFT0DCD0QLDT6Qbeejoh"));
            cipher.init(2, secretKeySpec, new IvParameterSpec(ivParameter.getBytes()));
            return new String(cipher.doFinal(bArr), encodingFormat);
        } catch (Throwable th) {
            Log.e(TAG, dexc.dexa("efdszquCzuf!fssps!") + Log.getStackTraceString(th));
            return "";
        }
    }

    public static byte[] decryptToByte(byte[] bArr, String str, String str2) {
        try {
            String strMd5Decode = md5Decode(str);
            if (!TextUtils.isEmpty(strMd5Decode) && strMd5Decode.length() > 16) {
                sKey = strMd5Decode.substring(0, 16);
                ivParameter = strMd5Decode.substring(16, strMd5Decode.length());
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(sKey.getBytes(dexc.dexa("BTDJJ")), dexc.dexa("BFT"));
            Cipher cipher = Cipher.getInstance(dexc.dexa("BFT0DCD0QLDT6Qbeejoh"));
            cipher.init(2, secretKeySpec, new IvParameterSpec(ivParameter.getBytes(dexc.dexa("BTDJJ"))));
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            int i = decryptToByteErrorCount + 1;
            decryptToByteErrorCount = i;
            if (i < 3) {
                Log.e(TAG, dexc.dexa(o61.h) + str2 + dexc.dexa("^!efdszquUpCzuf!fssps!") + Log.getStackTraceString(th));
            }
            return new byte[0];
        }
    }

    public static String encodeData(String str) {
        try {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] + 3);
            }
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (Throwable th) {
            Log.e(TAG, dexc.dexa("fodpefEbub!fssps!") + Log.getStackTraceString(th));
            return str;
        }
    }

    public static String encrypt(String str, String str2, String str3) {
        try {
            String strMd5Decode = md5Decode(str2);
            if (!TextUtils.isEmpty(strMd5Decode) && strMd5Decode.length() > 16) {
                sKey = strMd5Decode.substring(0, 16);
                ivParameter = strMd5Decode.substring(16, strMd5Decode.length());
            }
            Cipher cipher = Cipher.getInstance(dexc.dexa("BFT0DCD0QLDT6Qbeejoh"));
            cipher.init(1, new SecretKeySpec(sKey.getBytes(), dexc.dexa("BFT")), new IvParameterSpec(ivParameter.getBytes()));
            return parseByte2HexStr(cipher.doFinal(str.getBytes(encodingFormat)));
        } catch (Throwable th) {
            int i = encryptStrErrorCount + 1;
            encryptStrErrorCount = i;
            if (i >= 3) {
                return "";
            }
            Log.e(TAG, dexc.dexa(o61.h) + str3 + dexc.dexa("^fodszqu!fssps!") + Log.getStackTraceString(th));
            return "";
        }
    }

    public static byte[] encryptByt(String str, String str2) {
        byte[] bArr = new byte[0];
        try {
            String strMd5Decode = md5Decode(str2);
            if (!TextUtils.isEmpty(strMd5Decode) && strMd5Decode.length() > 16) {
                sKey = strMd5Decode.substring(0, 16);
                ivParameter = strMd5Decode.substring(16, strMd5Decode.length());
            }
            Cipher cipher = Cipher.getInstance(dexc.dexa("BFT0DCD0QLDT6Qbeejoh"));
            cipher.init(1, new SecretKeySpec(sKey.getBytes(), dexc.dexa("BFT")), new IvParameterSpec(ivParameter.getBytes()));
            return cipher.doFinal(str.getBytes(encodingFormat));
        } catch (Throwable th) {
            int i = encryptBytStrErrorCount + 1;
            encryptBytStrErrorCount = i;
            if (i >= 3) {
                return bArr;
            }
            Log.e(TAG, dexc.dexa("fodszquCzu)tus*!fssps!") + Log.getStackTraceString(th));
            return bArr;
        }
    }

    public static byte[] encryptByt(byte[] bArr, String str) {
        try {
            String strMd5Decode = md5Decode(str);
            if (!TextUtils.isEmpty(strMd5Decode) && strMd5Decode.length() > 16) {
                sKey = strMd5Decode.substring(0, 16);
                ivParameter = strMd5Decode.substring(16, strMd5Decode.length());
            }
            Cipher cipher = Cipher.getInstance(dexc.dexa("BFT0DCD0QLDT6Qbeejoh"));
            cipher.init(1, new SecretKeySpec(sKey.getBytes(), dexc.dexa("BFT")), new IvParameterSpec(ivParameter.getBytes()));
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            int i = encryptBytErrorCount + 1;
            encryptBytErrorCount = i;
            if (i < 3) {
                Log.e(TAG, dexc.dexa("fodszquCzu)czuf*!fssps!") + Log.getStackTraceString(th));
            }
            return new byte[0];
        }
    }

    public static String md5Decode(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance(dexc.dexa("NE6")).digest(str.getBytes(dexc.dexa("VUG.9")));
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b : bArrDigest) {
                int i = b & 255;
                if (i < 16) {
                    sb.append(dexc.dexa("1"));
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (Throwable th) {
            Log.e(TAG, dexc.dexa("ne6Efdpef!fssps;") + Log.getStackTraceString(th));
            return "";
        }
    }

    public static String parseByte2HexStr(byte[] bArr) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            if (bArr != null) {
                for (byte b : bArr) {
                    String hexString = Integer.toHexString(b & 255);
                    if (hexString.length() == 1) {
                        hexString = '0' + hexString;
                    }
                    stringBuffer.append(hexString.toUpperCase());
                }
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            Log.w(TAG, dexc.dexa("qbstfCzuf3IfyTus!gbjm!") + Log.getStackTraceString(th));
            return "";
        }
    }

    public static byte[] parseHexStr2Byte(String str) {
        if (str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i2, i3), 16) * 16) + Integer.parseInt(str.substring(i3, i2 + 2), 16));
        }
        return bArr;
    }
}
