package com.zj.adlib;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.internal.model.ModelUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
@WorkerThread
public class hi0 {
    @NonNull
    @KeepForSdk
    public static String[] a(@NonNull Context context, @NonNull jz4 jz4Var, boolean z) throws IOException {
        String string;
        String string2 = z ? (String) yw6.l(jz4Var.b()) : (String) yw6.l(jz4Var.a());
        if (jz4Var.d()) {
            ModelUtils.AutoMLManifest autoMLManifestC = ModelUtils.c(string2, z, context);
            if (autoMLManifestC == null) {
                throw new IOException("Failed to parse manifest file.");
            }
            yw6.t(qt1.d.equals(autoMLManifestC.c()), "Model type should be: %s.", qt1.d);
            string2 = new File(new File(string2).getParent(), autoMLManifestC.b()).toString();
            string = new File(new File(string2).getParent(), autoMLManifestC.a()).toString();
        } else {
            string = "";
        }
        return new String[]{string2, string};
    }

    @NonNull
    @KeepForSdk
    public static List<String> b(@NonNull Context context, @NonNull String str, boolean z) throws IOException {
        ArrayList arrayList = new ArrayList();
        InputStream inputStreamOpen = z ? context.getAssets().open(str) : new FileInputStream(new File(str));
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, "UTF-8"));
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                arrayList.add(line);
            }
            if (inputStreamOpen != null) {
                inputStreamOpen.close();
            }
            return arrayList;
        } catch (Throwable th) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (Throwable th2) {
                    try {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                    } catch (Exception unused) {
                    }
                }
            }
            throw th;
        }
    }
}
