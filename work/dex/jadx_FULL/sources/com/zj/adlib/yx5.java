package com.zj.adlib;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.network.FileExtension;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import com.alibaba.android.arouter.utils.Consts;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class yx5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LottieNetworkCacheProvider f46135a;

    public yx5(@NonNull LottieNetworkCacheProvider lottieNetworkCacheProvider) {
        this.f46135a = lottieNetworkCacheProvider;
    }

    public static String c(String str, FileExtension fileExtension, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? fileExtension.tempExtension() : fileExtension.extension);
        return sb.toString();
    }

    public void a() {
        File fileE = e();
        if (fileE.exists()) {
            File[] fileArrListFiles = fileE.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                for (File file : fileE.listFiles()) {
                    file.delete();
                }
            }
            fileE.delete();
        }
    }

    @Nullable
    @WorkerThread
    public Pair<FileExtension, InputStream> b(String str) {
        try {
            File fileD = d(str);
            if (fileD == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(fileD);
            FileExtension fileExtension = fileD.getAbsolutePath().endsWith(".zip") ? FileExtension.ZIP : FileExtension.JSON;
            g25.a("Cache hit for " + str + " at " + fileD.getAbsolutePath());
            return new Pair<>(fileExtension, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    @Nullable
    public final File d(String str) throws FileNotFoundException {
        File file = new File(e(), c(str, FileExtension.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(e(), c(str, FileExtension.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    public final File e() {
        File cacheDir = this.f46135a.getCacheDir();
        if (cacheDir.isFile()) {
            cacheDir.delete();
        }
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        return cacheDir;
    }

    public void f(String str, FileExtension fileExtension) {
        File file = new File(e(), c(str, fileExtension, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean zRenameTo = file.renameTo(file2);
        g25.a("Copying temp file to real file (" + file2 + ")");
        if (zRenameTo) {
            return;
        }
        g25.e("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + Consts.DOT);
    }

    public File g(String str, InputStream inputStream, FileExtension fileExtension) throws IOException {
        File file = new File(e(), c(str, fileExtension, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        inputStream.close();
                        return file;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            inputStream.close();
            throw th2;
        }
    }
}
