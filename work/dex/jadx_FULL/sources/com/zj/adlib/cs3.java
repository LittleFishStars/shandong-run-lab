package com.zj.adlib;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class cs3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41036a = "com.apple.iTunes";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Pattern f15884a = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public static final String b = "iTunSMPB";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f15885a = -1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f15886b = -1;

    public boolean a() {
        return (this.f15885a == -1 || this.f15886b == -1) ? false : true;
    }

    public final boolean b(String str) {
        Matcher matcher = f15884a.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            int i = Integer.parseInt((String) gj9.k(matcher.group(1)), 16);
            int i2 = Integer.parseInt((String) gj9.k(matcher.group(2)), 16);
            if (i <= 0 && i2 <= 0) {
                return false;
            }
            this.f15885a = i;
            this.f15886b = i2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public boolean c(Metadata metadata) {
        for (int i = 0; i < metadata.length(); i++) {
            Metadata.Entry entry = metadata.get(i);
            if (entry instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) entry;
                if (b.equals(commentFrame.description) && b(commentFrame.text)) {
                    return true;
                }
            } else if (entry instanceof InternalFrame) {
                InternalFrame internalFrame = (InternalFrame) entry;
                if (f41036a.equals(internalFrame.domain) && b.equals(internalFrame.description) && b(internalFrame.text)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public boolean d(int i) {
        int i2 = i >> 12;
        int i3 = i & 4095;
        if (i2 <= 0 && i3 <= 0) {
            return false;
        }
        this.f15885a = i2;
        this.f15886b = i3;
        return true;
    }
}
