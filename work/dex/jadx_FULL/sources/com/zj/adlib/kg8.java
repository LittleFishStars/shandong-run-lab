package com.zj.adlib;

import androidx.annotation.Nullable;
import com.alibaba.android.arouter.utils.Consts;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class kg8 extends aa1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f42812a = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);
    public static final Pattern b = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);
    public static final Pattern c = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);
    public static final String g = ".exo";
    public static final String h = ".v3.exo";

    public kg8(String str, long j, long j2, long j3, @Nullable File file) {
        super(str, j, j2, j3, file);
    }

    @Nullable
    public static kg8 e(File file, long j, long j2, CachedContentIndex cachedContentIndex) {
        File file2;
        String strK;
        String name = file.getName();
        if (name.endsWith(h)) {
            file2 = file;
        } else {
            File fileJ = j(file, cachedContentIndex);
            if (fileJ == null) {
                return null;
            }
            file2 = fileJ;
            name = fileJ.getName();
        }
        Matcher matcher = c.matcher(name);
        if (!matcher.matches() || (strK = cachedContentIndex.k(Integer.parseInt((String) sb0.g(matcher.group(1))))) == null) {
            return null;
        }
        long length = j == -1 ? file2.length() : j;
        if (length == 0) {
            return null;
        }
        return new kg8(strK, Long.parseLong((String) sb0.g(matcher.group(2))), length, j2 == -9223372036854775807L ? Long.parseLong((String) sb0.g(matcher.group(3))) : j2, file2);
    }

    @Nullable
    public static kg8 f(File file, long j, CachedContentIndex cachedContentIndex) {
        return e(file, j, -9223372036854775807L, cachedContentIndex);
    }

    public static kg8 g(String str, long j, long j2) {
        return new kg8(str, j, j2, -9223372036854775807L, null);
    }

    public static kg8 h(String str, long j) {
        return new kg8(str, j, -1L, -9223372036854775807L, null);
    }

    public static File i(File file, int i, long j, long j2) {
        return new File(file, i + Consts.DOT + j + Consts.DOT + j2 + h);
    }

    @Nullable
    public static File j(File file, CachedContentIndex cachedContentIndex) {
        String strG1;
        String name = file.getName();
        Matcher matcher = b.matcher(name);
        if (matcher.matches()) {
            strG1 = gj9.G1((String) sb0.g(matcher.group(1)));
        } else {
            matcher = f42812a.matcher(name);
            strG1 = matcher.matches() ? (String) sb0.g(matcher.group(1)) : null;
        }
        if (strG1 == null) {
            return null;
        }
        File fileI = i((File) sb0.k(file.getParentFile()), cachedContentIndex.f(strG1), Long.parseLong((String) sb0.g(matcher.group(2))), Long.parseLong((String) sb0.g(matcher.group(3))));
        if (file.renameTo(fileI)) {
            return fileI;
        }
        return null;
    }

    public kg8 d(File file, long j) {
        sb0.i(((aa1) this).f15219a);
        return new kg8(this.f, ((aa1) this).f40491a, this.b, j, file);
    }
}
