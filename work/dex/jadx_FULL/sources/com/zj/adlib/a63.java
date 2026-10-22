package com.zj.adlib;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huachenjie.sport.bean.ExamQuestionData;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class a63 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f40458a = "ExamInfoStorage";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Map<String, Map<Long, Set<Long>>> f15159a = new HashMap();
    public static final Map<String, ExamQuestionData> b = new HashMap();

    public class a extends TypeToken<Map<Long, Set<Long>>> {
    }

    public static void a() {
        Map<String, ExamQuestionData> map = b;
        if (map != null) {
            map.clear();
        }
        Map<String, Map<Long, Set<Long>>> map2 = f15159a;
        if (map2 != null) {
            map2.clear();
        }
        zr8.c(f40458a).a();
    }

    public static String b(Long l) {
        return ys8.c("AnswerData_%s_%d", ai9.e().getUserId(), l);
    }

    public static String c(Long l) {
        return ys8.c("ExamQuestion_%s_%d", ai9.e().getUserId(), l);
    }

    public static Map<Long, Set<Long>> d(Long l) {
        if (l == null || l.longValue() == 0) {
            return null;
        }
        Map<String, Map<Long, Set<Long>>> map = f15159a;
        if (!map.containsKey(b(l))) {
            map.put(b(l), (Map) new Gson().fromJson((String) zr8.c(f40458a).h(b(l), ""), new a().getType()));
        }
        return map.get(b(l));
    }

    public static ExamQuestionData e(Long l) {
        if (l == null || l.longValue() == 0) {
            return null;
        }
        Map<String, ExamQuestionData> map = b;
        if (!map.containsKey(c(l))) {
            map.put(c(l), (ExamQuestionData) new Gson().fromJson((String) zr8.c(f40458a).h(c(l), ""), ExamQuestionData.class));
        }
        return map.get(c(l));
    }

    public static void f(Context context) {
        zr8.f(f40458a, new p55(context, f40458a), new wp());
    }

    public static void g(Long l, Map<Long, Set<Long>> map) {
        if (l == null || l.longValue() == 0) {
            return;
        }
        if (map == null) {
            f15159a.remove(b(l));
            zr8.c(f40458a).l(b(l));
        } else {
            f15159a.put(b(l), map);
            zr8.c(f40458a).j(b(l), new Gson().toJson(map));
        }
    }

    public static void h(Long l, ExamQuestionData examQuestionData) {
        if (l == null || l.longValue() == 0) {
            return;
        }
        if (examQuestionData == null) {
            b.remove(c(l));
            zr8.c(f40458a).l(c(l));
        } else {
            b.put(c(l), examQuestionData);
            zr8.c(f40458a).j(c(l), new Gson().toJson(examQuestionData));
        }
    }
}
