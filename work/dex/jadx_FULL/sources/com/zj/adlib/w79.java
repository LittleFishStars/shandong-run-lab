package com.zj.adlib;

import com.google.common.net.c;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/zj/adlib/w79;", "", "", "millis", "", "a", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class w79 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final w79 f45538a = new w79();

    @NotNull
    public final String a(long millis) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        long j = 86400000;
        long j2 = millis / j;
        long j3 = 3600000;
        long j4 = (millis % j) / j3;
        long j5 = 60000;
        long j6 = (millis % j3) / j5;
        long j7 = (millis % j5) / ((long) 1000);
        if (j4 < 10) {
            sb = new StringBuilder();
            sb.append('0');
        } else {
            sb = new StringBuilder();
            sb.append("");
        }
        sb.append(j4);
        String string = sb.toString();
        if (j6 < 10) {
            sb2 = new StringBuilder();
            sb2.append('0');
        } else {
            sb2 = new StringBuilder();
            sb2.append("");
        }
        sb2.append(j6);
        String string2 = sb2.toString();
        if (j7 < 10) {
            sb3 = new StringBuilder();
            sb3.append('0');
        } else {
            sb3 = new StringBuilder();
            sb3.append("");
        }
        sb3.append(j7);
        return string + c.b + string2 + c.b + sb3.toString();
    }
}
