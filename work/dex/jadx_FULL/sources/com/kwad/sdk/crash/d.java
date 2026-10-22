package com.kwad.sdk.crash;

import com.alibaba.ariver.kernel.RVParams;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class d {
    public static final double bdZ = Runtime.getRuntime().maxMemory();
    public static final Pattern bea = Pattern.compile("/data/user");
    public static final Pattern beb = Pattern.compile("/data");
    public static final Pattern bec = Pattern.compile("/data/data/(.*)/data/.*");
    public static final Pattern bed = Pattern.compile("/data/user/.*/(.*)/data/.*");
    public static int bee = 10;
    public static String bef = RVParams.SESSION_ID;
}
