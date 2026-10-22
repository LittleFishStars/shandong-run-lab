package com.kwad.framework.filedownloader.f;

import android.annotation.SuppressLint;
import android.content.Context;
import com.kwad.framework.filedownloader.exception.PathConflictException;
import com.kwad.framework.filedownloader.y;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c {

    @SuppressLint({"StaticFieldLeak"})
    private static Context aDq;

    public interface a {
        int ab(long j);
    }

    public interface b {
        com.kwad.framework.filedownloader.a.b bX(String str);
    }

    /* JADX INFO: renamed from: com.kwad.framework.filedownloader.f.c$c, reason: collision with other inner class name */
    public interface InterfaceC1258c {
        com.kwad.framework.filedownloader.b.a Dy();
    }

    public interface d {
        int f(String str, String str2, boolean z);

        int g(String str, String str2, boolean z);
    }

    public interface e {
        com.kwad.framework.filedownloader.e.a c(File file);
    }

    public static Context Dx() {
        return aDq;
    }

    public static boolean a(int i, String str, boolean z, boolean z2) {
        if (!z && str != null) {
            File file = new File(str);
            if (file.exists()) {
                com.kwad.framework.filedownloader.message.e.CR().s(com.kwad.framework.filedownloader.message.f.a(i, file, z2));
                return true;
            }
        }
        return false;
    }

    public static void aY(Context context) {
        aDq = context;
    }

    public static boolean a(int i, com.kwad.framework.filedownloader.d.c cVar, y yVar, boolean z) {
        if (!yVar.a(cVar)) {
            return false;
        }
        com.kwad.framework.filedownloader.message.e.CR().s(com.kwad.framework.filedownloader.message.f.a(i, cVar.CX(), cVar.getTotal(), z));
        return true;
    }

    public static boolean a(int i, long j, String str, String str2, y yVar) {
        int iP;
        if (str2 == null || str == null || (iP = yVar.p(str, i)) == 0) {
            return false;
        }
        com.kwad.framework.filedownloader.message.e.CR().s(com.kwad.framework.filedownloader.message.f.a(i, j, new PathConflictException(iP, str, str2)));
        return true;
    }
}
