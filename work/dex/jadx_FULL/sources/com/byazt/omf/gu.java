package com.byazt.omf;

import android.util.SparseArray;
import com.byazt.ete.bm;
import com.byazt.ete.hq;
import com.byazt.ete.ic;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface gu<T> {

    public interface c {
        void c(boolean z, long j, long j2);
    }

    public interface n {
        void c(int i, String str);

        void c(gr.uj ujVar);
    }

    public interface tt {
        void c(int i, String str, com.byazt.ete.tt ttVar);

        void c(com.byazt.ete.c cVar, com.byazt.ete.tt ttVar);
    }

    public interface uj {
        void c(int i, String str);

        void c(gr.ve veVar);
    }

    public interface ve<T> {
        void c(int i, String str);

        void c(T t);
    }

    com.byazt.ete.uj c(ic icVar, String str);

    com.byazt.ku.c c(int i);

    String c(com.byazt.dj.tt ttVar);

    String c(com.byazt.dj.tt ttVar, boolean z, int i);

    void c(com.byazt.dj.tt ttVar, bm bmVar, int i, tt ttVar2);

    void c(hq hqVar, String str, String str2, ve veVar, int i, long j);

    void c(com.byazt.vo.tt ttVar, List<com.byazt.nc.a> list);

    void c(String str);

    void c(String str, String str2, c cVar);

    void c(Map<String, Object> map, Function<SparseArray<Object>, Object> function);

    void c(Function<SparseArray<Object>, Object> function);

    void c(JSONObject jSONObject, com.byazt.dbo.tt ttVar);

    void c(JSONObject jSONObject, n nVar);

    void c(JSONObject jSONObject, uj ujVar);

    void c(JSONObject jSONObject, ve<com.byazt.hm.tt> veVar);

    void tt(com.byazt.dj.tt ttVar, bm bmVar, int i, tt ttVar2);

    void ve(com.byazt.dj.tt ttVar, bm bmVar, int i, tt ttVar2);
}
