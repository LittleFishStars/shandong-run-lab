package com.getui.gtc.base.log.a;

import android.content.Context;
import com.getui.gtc.base.log.ILogController;
import com.getui.gtc.base.log.ILogFormatter;
import com.getui.gtc.base.util.CommonUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a implements ILogController {
    private static List<String> b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f30281a = "sdk.debug";
    private final Context c;
    private final ILogFormatter d;
    private boolean e;

    public a(Context context, ILogFormatter iLogFormatter) {
        this.c = context;
        this.d = (ILogFormatter) com.getui.gtc.base.log.e.a.a(iLogFormatter);
        a(this.f30281a);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00a4 A[EXC_TOP_SPLITTER, PHI: r4
      0x00a4: PHI (r4v5 java.io.InputStream) = (r4v4 java.io.InputStream), (r4v6 java.io.InputStream) binds: [B:35:0x00a9, B:31:0x00a2] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x00ac A[SYNTHETIC] */
    private static List<String> a(Context context) {
        InputStream inputStreamOpen;
        File file;
        ArrayList arrayList = new ArrayList();
        String str = context.getPackageName() + ".properties";
        File externalFilesDir = CommonUtil.getExternalFilesDir(context);
        for (int i = 0; i < 4; i++) {
            try {
                if (i == 0) {
                    try {
                        inputStreamOpen = context.getAssets().open(str);
                    } catch (Throwable unused) {
                        inputStreamOpen = null;
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (IOException unused2) {
                            }
                        }
                    }
                } else {
                    if (i == 1) {
                        file = new File(externalFilesDir, str);
                    } else if (i == 2) {
                        file = new File(context.getFilesDir(), str);
                    } else {
                        file = new File(externalFilesDir, context.getPackageName() + "-online.properties");
                    }
                    if (file.exists() && file.canRead()) {
                        inputStreamOpen = new FileInputStream(file);
                    }
                }
                Properties properties = new Properties();
                properties.load(inputStreamOpen);
                Enumeration enumerationKeys = properties.keys();
                while (enumerationKeys.hasMoreElements()) {
                    String str2 = (String) enumerationKeys.nextElement();
                    String property = properties.getProperty(str2);
                    if (property != null && Boolean.parseBoolean(property.trim()) && !arrayList.contains(str2)) {
                        arrayList.add(str2);
                    }
                }
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
            } catch (Throwable unused3) {
                if (inputStreamOpen != null) {
                }
            }
        }
        return arrayList;
    }

    private static boolean a(Context context, String str) {
        try {
            if (b == null) {
                synchronized (a.class) {
                    if (b == null) {
                        b = Collections.unmodifiableList(a(context));
                    }
                }
            }
            return b.contains(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public final void a(String str) {
        this.f30281a = str;
        this.e = a(this.c, str);
    }

    @Override // com.getui.gtc.base.log.ILogController
    public boolean isLoggable(int i, String str) {
        int i2 = i & 240;
        if (i2 == 0 || i2 == 32) {
            return this.e;
        }
        return false;
    }

    @Override // com.getui.gtc.base.log.ILogController
    public void log(int i, String str, String str2, Throwable th) {
        if ((i & 240) != 0) {
            i &= 15;
        }
        this.d.log(i, str, str2, th);
    }
}
