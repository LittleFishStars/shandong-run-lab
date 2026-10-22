package com.ipd.dsp.internal.j0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38362a = 0;

    /* JADX INFO: renamed from: com.ipd.dsp.internal.j0.a$a, reason: collision with other inner class name */
    public interface InterfaceC0886a {
        @Nullable
        String a(String str);

        String b();

        InputStream c() throws IOException;

        @Nullable
        Map<String, List<String>> e();

        int f() throws IOException;
    }

    public interface b {
        a a(String str) throws IOException;
    }

    void a();

    void a(String str, String str2);

    boolean b(@NonNull String str) throws ProtocolException;

    String c(String str);

    Map<String, List<String>> d();

    InterfaceC0886a g() throws IOException;
}
