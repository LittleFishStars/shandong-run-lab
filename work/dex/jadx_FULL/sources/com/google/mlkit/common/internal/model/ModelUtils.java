package com.google.mlkit.common.internal.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.aliyun.openapiutil.Client;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.zj.adlib.e98;
import com.zj.adlib.hq5;
import com.zj.adlib.jz4;
import com.zj.adlib.pzc;
import com.zj.adlib.s8c;
import com.zj.adlib.su3;
import com.zj.adlib.u3d;
import com.zj.adlib.yw6;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
@WorkerThread
public class ModelUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final su3 f32447a = new su3("ModelUtils", "");

    @KeepForSdk
    public static abstract class AutoMLManifest {
        @NonNull
        @KeepForSdk
        public abstract String a();

        @NonNull
        @KeepForSdk
        public abstract String b();

        @NonNull
        @KeepForSdk
        public abstract String c();
    }

    @KeepForSdk
    public static abstract class ModelLoggingInfo {
        public static ModelLoggingInfo d(long j, @Nullable String str, boolean z) {
            return new b(j, s8c.b(str), z);
        }

        @NonNull
        @KeepForSdk
        public abstract String a();

        @KeepForSdk
        public abstract long b();

        @KeepForSdk
        public abstract boolean c();
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0106 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v2 */
    @Nullable
    @KeepForSdk
    public static ModelLoggingInfo a(@NonNull Context context, @NonNull jz4 jz4Var) throws Throwable {
        long length;
        String string;
        Throwable th;
        IOException e;
        InputStream inputStreamB;
        String strF;
        String strB = jz4Var.b();
        String strA = jz4Var.a();
        Uri uriC = jz4Var.c();
        ?? r5 = 0;
        if (strB != null) {
            if (jz4Var.d() && (strB = e(context, strB, true)) == null) {
                return null;
            }
            try {
                AssetFileDescriptor assetFileDescriptorOpenFd = context.getAssets().openFd(strB);
                try {
                    length = assetFileDescriptorOpenFd.getLength();
                    assetFileDescriptorOpenFd.close();
                } catch (Throwable th2) {
                    if (assetFileDescriptorOpenFd != null) {
                        try {
                            assetFileDescriptorOpenFd.close();
                        } catch (Throwable th3) {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th2, th3);
                        }
                    }
                    throw th2;
                }
            } catch (IOException e2) {
                f32447a.f("ModelUtils", "Failed to open model file", e2);
                return null;
            }
        } else if (strA != null) {
            if (jz4Var.d() && (strA = e(context, strA, false)) == null) {
                return null;
            }
            length = new File(strA).length();
        } else {
            if (uriC == null) {
                f32447a.e("ModelUtils", "Local model doesn't have any valid path.");
                return null;
            }
            try {
                AssetFileDescriptor assetFileDescriptorA = u3d.a(context, uriC, "r");
                try {
                    length = assetFileDescriptorA.getLength();
                    assetFileDescriptorA.close();
                } catch (Throwable th4) {
                    if (assetFileDescriptorA != null) {
                        try {
                            assetFileDescriptorA.close();
                        } catch (Throwable th5) {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th4, th5);
                        }
                    }
                    throw th4;
                }
            } catch (IOException e3) {
                f32447a.f("ModelUtils", "Failed to open model file", e3);
                return null;
            }
        }
        e98 e98Var = (e98) hq5.c().a(e98.class);
        if (strB != null) {
            string = strB;
        } else {
            string = strA != null ? strA : ((Uri) yw6.l(uriC)).toString();
        }
        String strQ = e98Var.q(string, length);
        if (strQ != null) {
            return ModelLoggingInfo.d(length, strQ, jz4Var.d());
        }
        try {
            try {
                if (strB != null) {
                    inputStreamB = context.getAssets().open(strB);
                } else if (strA != null) {
                    inputStreamB = new FileInputStream(new File(strA));
                } else {
                    Uri uri = (Uri) yw6.l(uriC);
                    int i = u3d.f45060a;
                    inputStreamB = u3d.b(context, uri, pzc.f44092a);
                }
                if (inputStreamB != null) {
                    try {
                        strF = f(inputStreamB);
                    } catch (IOException e4) {
                        e = e4;
                        f32447a.f("ModelUtils", "Failed to open model file", e);
                        if (inputStreamB != null) {
                            try {
                                inputStreamB.close();
                            } catch (IOException e5) {
                                f32447a.f("ModelUtils", "Failed to close model file", e5);
                            }
                        }
                        return null;
                    }
                } else {
                    strF = null;
                }
                if (strF != null) {
                    e98Var.r(string, length, strF);
                }
                ModelLoggingInfo modelLoggingInfoD = ModelLoggingInfo.d(length, strF, jz4Var.d());
                if (inputStreamB != null) {
                    try {
                        inputStreamB.close();
                    } catch (IOException e6) {
                        f32447a.f("ModelUtils", "Failed to close model file", e6);
                    }
                }
                return modelLoggingInfoD;
            } catch (Throwable th6) {
                th = th6;
                r5 = context;
                if (r5 != 0) {
                    try {
                        r5.close();
                    } catch (IOException e7) {
                        f32447a.f("ModelUtils", "Failed to close model file", e7);
                    }
                }
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            inputStreamB = null;
        } catch (Throwable th7) {
            th = th7;
            if (r5 != 0) {
                r5.close();
            }
            throw th;
        }
    }

    @Nullable
    @KeepForSdk
    public static String b(@NonNull File file) throws IllegalAccessException, InvocationTargetException {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                String strF = f(fileInputStream);
                fileInputStream.close();
                return strF;
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                }
                throw th;
            }
        } catch (IOException e) {
            f32447a.e("ModelUtils", "Failed to create FileInputStream for model: ".concat(e.toString()));
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002b, code lost:
    
        if (new java.io.File(r5).exists() == false) goto L10;
     */
    @Nullable
    @KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AutoMLManifest c(@NonNull String str, boolean z, @NonNull Context context) {
        byte[] bArr;
        String strValueOf = String.valueOf(str);
        su3 su3Var = f32447a;
        su3Var.c("ModelUtils", "Manifest file path: ".concat(strValueOf));
        if (z) {
            try {
                InputStream inputStreamOpen = context.getAssets().open(str);
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
            } catch (IOException unused) {
                f32447a.e("ModelUtils", "Manifest file does not exist.");
                return null;
            }
        }
        try {
            if (str.isEmpty()) {
                bArr = new byte[0];
            } else {
                InputStream inputStreamOpen2 = z ? context.getAssets().open(str) : new FileInputStream(new File(str));
                try {
                    int iAvailable = inputStreamOpen2.available();
                    byte[] bArr2 = new byte[iAvailable];
                    inputStreamOpen2.read(bArr2, 0, iAvailable);
                    inputStreamOpen2.close();
                    bArr = bArr2;
                } catch (Throwable th) {
                    if (inputStreamOpen2 != null) {
                        try {
                            inputStreamOpen2.close();
                        } catch (Throwable th2) {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                        }
                    }
                    throw th;
                }
            }
            String str2 = new String(bArr, "UTF-8");
            su3Var.c("ModelUtils", "Json string from the manifest file: " + str2);
            JSONObject jSONObject = new JSONObject(str2);
            return new a(jSONObject.getString("modelType"), jSONObject.getString("modelFile"), jSONObject.getString("labelsFile"));
        } catch (IOException | JSONException e) {
            f32447a.f("ModelUtils", "Error parsing the manifest file.", e);
            return null;
        }
    }

    public static boolean d(@NonNull File file, @NonNull String str) throws IllegalAccessException, InvocationTargetException {
        String strB = b(file);
        f32447a.c("ModelUtils", "Calculated hash value is: ".concat(String.valueOf(strB)));
        return str.equals(strB);
    }

    @Nullable
    public static String e(Context context, String str, boolean z) {
        AutoMLManifest autoMLManifestC = c(str, z, context);
        if (autoMLManifestC != null) {
            return new File(new File(str).getParent(), autoMLManifestC.b()).toString();
        }
        f32447a.e("ModelUtils", "Failed to parse manifest file.");
        return null;
    }

    @Nullable
    public static String f(InputStream inputStream) {
        int i;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Client.HASH_SHA256);
            byte[] bArr = new byte[1048576];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i2);
            }
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (IOException unused) {
            f32447a.e("ModelUtils", "Failed to read model file");
            return null;
        } catch (NoSuchAlgorithmException unused2) {
            f32447a.e("ModelUtils", "Do not have SHA-256 algorithm");
            return null;
        }
    }
}
