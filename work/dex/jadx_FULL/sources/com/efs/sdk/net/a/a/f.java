package com.efs.sdk.net.a.a;

import java.io.InputStream;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface f {

    public interface a {
        String a(int i);

        String b(int i);

        int e();
    }

    public interface b extends c {
        String b();

        String c();

        @Nullable
        byte[] d();
    }

    public interface c extends a {
        String a();
    }

    public interface d extends e {
    }

    public interface e extends a {
        String a();

        int b();
    }

    @Nullable
    InputStream a(String str, @Nullable String str2, @Nullable String str3, @Nullable InputStream inputStream);

    void a();

    void a(b bVar);

    void a(d dVar);

    String b();
}
