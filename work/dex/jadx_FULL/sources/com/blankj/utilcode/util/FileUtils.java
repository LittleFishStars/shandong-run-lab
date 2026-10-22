package com.blankj.utilcode.util;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.common.primitives.UnsignedBytes;
import com.ipd.dsp.internal.q.u;
import com.zj.adlib.ee7;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class FileUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f28136a = System.getProperty("line.separator");

    public interface OnReplaceListener {
        boolean a(File file, File file2);
    }

    public class a implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return true;
        }
    }

    public class b implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.isFile();
        }
    }

    public class c implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return true;
        }
    }

    public FileUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static File A(String str) {
        if (i.C0(str)) {
            return null;
        }
        return new File(str);
    }

    public static List<File> A0(File file, FileFilter fileFilter, boolean z) {
        File[] fileArrListFiles;
        ArrayList arrayList = new ArrayList();
        if (a0(file) && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (fileFilter.accept(file2)) {
                    arrayList.add(file2);
                }
                if (z && file2.isDirectory()) {
                    arrayList.addAll(A0(file2, fileFilter, true));
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public static String B(File file) throws Throwable {
        int i;
        if (file == null) {
            return "";
        }
        if (i0(file)) {
            return "UTF-8";
        }
        ?? r0 = 0;
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    i = (bufferedInputStream2.read() << 8) + bufferedInputStream2.read();
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e2) {
                    e = e2;
                    bufferedInputStream = bufferedInputStream2;
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    i = 0;
                } catch (Throwable th) {
                    th = th;
                    r0 = bufferedInputStream2;
                    if (r0 != 0) {
                        try {
                            r0.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            e = e5;
        }
        r0 = 65279;
        if (i != 65279) {
            return i != 65534 ? "GBK" : "Unicode";
        }
        return "UTF-16BE";
    }

    public static boolean B0(File file, File file2) {
        return C0(file, file2, null);
    }

    public static String C(String str) {
        return B(A(str));
    }

    public static boolean C0(File file, File file2, OnReplaceListener onReplaceListener) {
        if (file == null) {
            return false;
        }
        return file.isDirectory() ? F0(file, file2, onReplaceListener) : G0(file, file2, onReplaceListener);
    }

    public static String D(File file) {
        return file == null ? "" : E(file.getPath());
    }

    public static boolean D0(String str, String str2) {
        return C0(A(str), A(str2), null);
    }

    public static String E(String str) {
        if (i.C0(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(46);
        return (iLastIndexOf == -1 || str.lastIndexOf(File.separator) >= iLastIndexOf) ? "" : str.substring(iLastIndexOf + 1);
    }

    public static boolean E0(String str, String str2, OnReplaceListener onReplaceListener) {
        return C0(A(str), A(str2), onReplaceListener);
    }

    public static long F(File file) {
        if (file == null) {
            return -1L;
        }
        return file.lastModified();
    }

    public static boolean F0(File file, File file2, OnReplaceListener onReplaceListener) {
        return g(file, file2, onReplaceListener, true);
    }

    public static long G(String str) {
        return F(A(str));
    }

    public static boolean G0(File file, File file2, OnReplaceListener onReplaceListener) {
        return h(file, file2, onReplaceListener, true);
    }

    public static long H(File file) {
        if (c0(file)) {
            return file.length();
        }
        return -1L;
    }

    public static void H0(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.parse("file://" + file.getAbsolutePath()));
        Utils.a().sendBroadcast(intent);
    }

    public static long I(String str) {
        if (str.matches(ee7.g)) {
            try {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                httpsURLConnection.setRequestProperty("Accept-Encoding", HlsPlaylistParser.V);
                httpsURLConnection.connect();
                if (httpsURLConnection.getResponseCode() == 200) {
                    return httpsURLConnection.getContentLength();
                }
                return -1L;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return H(A(str));
    }

    public static void I0(String str) {
        H0(A(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public static int J(File file) throws Throwable {
        int i = 1;
        ?? r1 = 0;
        r1 = 0;
        r1 = 0;
        try {
            try {
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        byte[] bArr = new byte[1024];
                        if (!f28136a.endsWith("\n")) {
                            while (true) {
                                int i2 = bufferedInputStream.read(bArr, 0, 1024);
                                if (i2 == -1) {
                                    break;
                                }
                                for (int i3 = 0; i3 < i2; i3++) {
                                    if (bArr[i3] == 13) {
                                        i++;
                                    }
                                }
                            }
                        } else {
                            while (true) {
                                int i4 = bufferedInputStream.read(bArr, 0, 1024);
                                if (i4 == -1) {
                                    break;
                                }
                                for (int i5 = 0; i5 < i4; i5++) {
                                    if (bArr[i5] == 10) {
                                        i++;
                                    }
                                }
                            }
                        }
                        bufferedInputStream.close();
                        r1 = bArr;
                    } catch (IOException e) {
                        e = e;
                        r1 = bufferedInputStream;
                        e.printStackTrace();
                        if (r1 != 0) {
                            r1.close();
                            r1 = r1;
                        }
                        return i;
                    } catch (Throwable th) {
                        th = th;
                        r1 = bufferedInputStream;
                        if (r1 != 0) {
                            try {
                                r1.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            } catch (IOException e4) {
                e = e4;
            }
            return i;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean J0(File file, String str) {
        if (file == null || !file.exists() || i.C0(str)) {
            return false;
        }
        if (str.equals(file.getName())) {
            return true;
        }
        File file2 = new File(file.getParent() + File.separator + str);
        return !file2.exists() && file.renameTo(file2);
    }

    public static int K(String str) {
        return J(A(str));
    }

    public static boolean K0(String str, String str2) {
        return J0(A(str), str2);
    }

    /* JADX WARN: Code duplicated, block: B:44:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0048: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:34:0x0048 */
    public static byte[] L(File file) throws Throwable {
        InputStream inputStream;
        DigestInputStream digestInputStream;
        InputStream inputStream2 = null;
        try {
            if (file == null) {
                return null;
            }
            try {
                digestInputStream = new DigestInputStream(new FileInputStream(file), MessageDigest.getInstance("MD5"));
                try {
                    while (digestInputStream.read(new byte[262144]) > 0) {
                    }
                    byte[] bArrDigest = digestInputStream.getMessageDigest().digest();
                    try {
                        digestInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return bArrDigest;
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (digestInputStream != null) {
                        try {
                            digestInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                } catch (NoSuchAlgorithmException e4) {
                    e = e4;
                    e.printStackTrace();
                    if (digestInputStream != null) {
                        digestInputStream.close();
                    }
                    return null;
                }
            } catch (IOException e5) {
                e = e5;
                digestInputStream = null;
                e.printStackTrace();
                if (digestInputStream != null) {
                    digestInputStream.close();
                }
                return null;
            } catch (NoSuchAlgorithmException e6) {
                e = e6;
                digestInputStream = null;
                e.printStackTrace();
                if (digestInputStream != null) {
                    digestInputStream.close();
                }
                return null;
            } catch (Throwable th) {
                th = th;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = inputStream;
        }
    }

    public static byte[] M(String str) {
        return L(A(str));
    }

    public static String N(File file) {
        return i.k(L(file));
    }

    public static String O(String str) {
        return N(i.C0(str) ? null : new File(str));
    }

    public static String P(File file) {
        return file == null ? "" : Q(file.getAbsolutePath());
    }

    public static String Q(String str) {
        if (i.C0(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(File.separator);
        return iLastIndexOf == -1 ? str : str.substring(iLastIndexOf + 1);
    }

    public static String R(File file) {
        return file == null ? "" : S(file.getPath());
    }

    public static String S(String str) {
        if (i.C0(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(46);
        int iLastIndexOf2 = str.lastIndexOf(File.separator);
        if (iLastIndexOf2 == -1) {
            return iLastIndexOf == -1 ? str : str.substring(0, iLastIndexOf);
        }
        return (iLastIndexOf == -1 || iLastIndexOf2 > iLastIndexOf) ? str.substring(iLastIndexOf2 + 1) : str.substring(iLastIndexOf2 + 1, iLastIndexOf);
    }

    public static String T(File file) {
        long jH = H(file);
        return jH == -1 ? "" : i.h(jH);
    }

    public static long U(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        StatFs statFs = new StatFs(str);
        return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
    }

    public static long V(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        StatFs statFs = new StatFs(str);
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    public static long W(File file) {
        if (file == null) {
            return 0L;
        }
        return file.isDirectory() ? w(file) : H(file);
    }

    public static long X(String str) {
        return W(A(str));
    }

    public static String Y(File file) {
        if (file == null) {
            return "";
        }
        return file.isDirectory() ? z(file) : T(file);
    }

    public static String Z(String str) {
        return Y(A(str));
    }

    public static boolean a(File file, File file2) {
        return b(file, file2, null);
    }

    public static boolean a0(File file) {
        return file != null && file.exists() && file.isDirectory();
    }

    public static boolean b(File file, File file2, OnReplaceListener onReplaceListener) {
        if (file == null) {
            return false;
        }
        return file.isDirectory() ? e(file, file2, onReplaceListener) : f(file, file2, onReplaceListener);
    }

    public static boolean b0(String str) {
        return a0(A(str));
    }

    public static boolean c(String str, String str2) {
        return b(A(str), A(str2), null);
    }

    public static boolean c0(File file) {
        return file != null && file.exists() && file.isFile();
    }

    public static boolean d(String str, String str2, OnReplaceListener onReplaceListener) {
        return b(A(str), A(str2), onReplaceListener);
    }

    public static boolean d0(String str) {
        return c0(A(str));
    }

    public static boolean delete(String str) {
        return delete(A(str));
    }

    public static boolean e(File file, File file2, OnReplaceListener onReplaceListener) {
        return g(file, file2, onReplaceListener, false);
    }

    public static boolean e0(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        return f0(file.getAbsolutePath());
    }

    public static boolean f(File file, File file2, OnReplaceListener onReplaceListener) {
        return h(file, file2, onReplaceListener, false);
    }

    public static boolean f0(String str) {
        File fileA = A(str);
        if (fileA == null) {
            return false;
        }
        if (fileA.exists()) {
            return true;
        }
        return g0(str);
    }

    public static boolean g(File file, File file2, OnReplaceListener onReplaceListener, boolean z) {
        if (file == null || file2 == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(file.getPath());
        String str = File.separator;
        sb.append(str);
        String string = sb.toString();
        String str2 = file2.getPath() + str;
        if (str2.contains(string) || !file.exists() || !file.isDirectory() || !k(file2)) {
            return false;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file3 : fileArrListFiles) {
                File file4 = new File(str2 + file3.getName());
                if (file3.isFile()) {
                    if (!h(file3, file4, onReplaceListener, z)) {
                        return false;
                    }
                } else if (file3.isDirectory() && !g(file3, file4, onReplaceListener, z)) {
                    return false;
                }
            }
        }
        return !z || q(file);
    }

    public static boolean g0(String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = Utils.a().getContentResolver().openAssetFileDescriptor(Uri.parse(str), "r");
                if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                    return false;
                }
                try {
                    assetFileDescriptorOpenAssetFileDescriptor.close();
                    return true;
                } catch (IOException unused) {
                    return true;
                }
            } catch (FileNotFoundException unused2) {
            }
        }
        return false;
    }

    public static boolean h(File file, File file2, OnReplaceListener onReplaceListener, boolean z) {
        if (file != null && file2 != null && !file.equals(file2) && file.exists() && file.isFile()) {
            if (file2.exists()) {
                if (onReplaceListener != null && !onReplaceListener.a(file, file2)) {
                    return true;
                }
                if (!file2.delete()) {
                    return false;
                }
            }
            if (!k(file2.getParentFile())) {
                return false;
            }
            try {
                if (i.g1(file2.getAbsolutePath(), new FileInputStream(file))) {
                    return !z || r(file);
                }
                return false;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static int h0(byte[] bArr) {
        if (bArr.length > 3 && bArr[0] == -17 && bArr[1] == -69 && bArr[2] == -65) {
            return 100;
        }
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int length2 = 0;
        while (i < length) {
            byte b2 = bArr[i];
            if ((b2 & (-1)) == -1 || (b2 & (-2)) == -2) {
                return 0;
            }
            if (length2 == 0) {
                if ((b2 & 127) == b2 && b2 != 0) {
                    i2++;
                } else if ((b2 & u.n7) == -64) {
                    int i4 = length2;
                    for (int i5 = 0; i5 < 8; i5++) {
                        byte b3 = (byte) (128 >> i5);
                        if ((bArr[i] & b3) != b3) {
                            break;
                        }
                        i4 = i5;
                    }
                    i3++;
                    length2 = i4;
                }
                i++;
            } else {
                if (bArr.length - i <= length2) {
                    length2 = bArr.length - i;
                }
                boolean z = false;
                for (int i6 = 0; i6 < length2; i6++) {
                    byte b4 = bArr[i + i6];
                    if ((b4 & UnsignedBytes.f32243a) != -128) {
                        if ((b4 & 127) == b4 && bArr[i] != 0) {
                            i2++;
                        }
                        z = true;
                    }
                }
                if (z) {
                    i3--;
                    i++;
                } else {
                    i3 += length2;
                    i += length2;
                }
                length2 = 0;
            }
        }
        if (i2 == length) {
            return 100;
        }
        return (int) (((i3 + i2) / length) * 100.0f);
    }

    public static boolean i(File file) {
        if (file == null) {
            return false;
        }
        if ((file.exists() && !file.delete()) || !k(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean i0(File file) throws Throwable {
        if (file == null) {
            return false;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                byte[] bArr = new byte[24];
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    int i = bufferedInputStream2.read(bArr);
                    if (i == -1) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return false;
                    }
                    byte[] bArr2 = new byte[i];
                    System.arraycopy(bArr, 0, bArr2, 0, i);
                    boolean z = h0(bArr2) == 100;
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return z;
                } catch (IOException e3) {
                    e = e3;
                    bufferedInputStream = bufferedInputStream2;
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e6) {
            e = e6;
        }
    }

    public static boolean j(String str) {
        return i(A(str));
    }

    public static boolean j0(String str) {
        return i0(A(str));
    }

    public static boolean k(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    public static List<File> k0(File file) {
        return l0(file, null);
    }

    public static boolean l(String str) {
        return k(A(str));
    }

    public static List<File> l0(File file, Comparator<File> comparator) {
        return n0(file, false, comparator);
    }

    public static boolean m(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!k(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<File> m0(File file, boolean z) {
        return n0(file, z, null);
    }

    public static boolean n(String str) {
        return m(A(str));
    }

    public static List<File> n0(File file, boolean z, Comparator<File> comparator) {
        return v0(file, new c(), z, comparator);
    }

    public static boolean o(File file) {
        return u(file, new a());
    }

    public static List<File> o0(String str) {
        return p0(str, null);
    }

    public static boolean p(String str) {
        return o(A(str));
    }

    public static List<File> p0(String str, Comparator<File> comparator) {
        return n0(A(str), false, comparator);
    }

    public static boolean q(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    if (!file2.delete()) {
                        return false;
                    }
                } else if (file2.isDirectory() && !q(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static List<File> q0(String str, boolean z) {
        return m0(A(str), z);
    }

    public static boolean r(File file) {
        return file != null && (!file.exists() || (file.isFile() && file.delete()));
    }

    public static List<File> r0(String str, boolean z, Comparator<File> comparator) {
        return n0(A(str), z, comparator);
    }

    public static boolean s(File file) {
        return u(file, new b());
    }

    public static List<File> s0(File file, FileFilter fileFilter) {
        return v0(file, fileFilter, false, null);
    }

    public static boolean t(String str) {
        return s(A(str));
    }

    public static List<File> t0(File file, FileFilter fileFilter, Comparator<File> comparator) {
        return v0(file, fileFilter, false, comparator);
    }

    public static boolean u(File file, FileFilter fileFilter) {
        if (file == null || fileFilter == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length != 0) {
            for (File file2 : fileArrListFiles) {
                if (fileFilter.accept(file2)) {
                    if (file2.isFile()) {
                        if (!file2.delete()) {
                            return false;
                        }
                    } else if (file2.isDirectory() && !q(file2)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static List<File> u0(File file, FileFilter fileFilter, boolean z) {
        return v0(file, fileFilter, z, null);
    }

    public static boolean v(String str, FileFilter fileFilter) {
        return u(A(str), fileFilter);
    }

    public static List<File> v0(File file, FileFilter fileFilter, boolean z, Comparator<File> comparator) {
        List<File> listA0 = A0(file, fileFilter, z);
        if (comparator != null) {
            Collections.sort(listA0, comparator);
        }
        return listA0;
    }

    public static long w(File file) {
        long jW = 0;
        if (!a0(file)) {
            return 0L;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                jW += file2.isDirectory() ? w(file2) : file2.length();
            }
        }
        return jW;
    }

    public static List<File> w0(String str, FileFilter fileFilter) {
        return s0(A(str), fileFilter);
    }

    public static String x(File file) {
        return file == null ? "" : y(file.getAbsolutePath());
    }

    public static List<File> x0(String str, FileFilter fileFilter, Comparator<File> comparator) {
        return t0(A(str), fileFilter, comparator);
    }

    public static String y(String str) {
        int iLastIndexOf;
        return (i.C0(str) || (iLastIndexOf = str.lastIndexOf(File.separator)) == -1) ? "" : str.substring(0, iLastIndexOf + 1);
    }

    public static List<File> y0(String str, FileFilter fileFilter, boolean z) {
        return u0(A(str), fileFilter, z);
    }

    public static String z(File file) {
        long jW = w(file);
        return jW == -1 ? "" : i.h(jW);
    }

    public static List<File> z0(String str, FileFilter fileFilter, boolean z, Comparator<File> comparator) {
        return v0(A(str), fileFilter, z, comparator);
    }

    public static boolean delete(File file) {
        if (file == null) {
            return false;
        }
        return file.isDirectory() ? q(file) : r(file);
    }
}
