package com.byazt.pr;

import android.app.Dialog;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import com.byazt.nc.a;
import com.byazt.nr.m;
import java.lang.reflect.Field;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 794, 13})
public class tt {
    public final com.byazt.vo.tt c;
    public c tt;

    public interface c {
        void c(a aVar);
    }

    /* JADX INFO: renamed from: com.byazt.pr.tt$tt, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 794, 240})
    public static final class C0507tt implements AdapterView.OnItemClickListener {
        public final tt c;
        public final AdapterView.OnItemClickListener tt;

        private com.byazt.vo.ve c(Object obj) {
            if (obj == null) {
                return null;
            }
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++) {
                try {
                    declaredFields[i].setAccessible(true);
                    Object obj2 = declaredFields[i].get(obj);
                    if (obj2 instanceof a) {
                        return new com.byazt.vo.ve(((a) obj2).getId(), ((a) obj2).getName());
                    }
                    continue;
                } catch (Exception e) {
                    m.c(e);
                }
            }
            return null;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Adapter adapter = adapterView.getAdapter();
            if (adapter != null) {
                Object item = adapter.getItem(i);
                if (item instanceof Function) {
                    this.c.c(c(item));
                }
            }
            AdapterView.OnItemClickListener onItemClickListener = this.tt;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(adapterView, view, i, j);
            }
        }

        private C0507tt(AdapterView.OnItemClickListener onItemClickListener, tt ttVar) {
            this.c = ttVar;
            this.tt = onItemClickListener;
        }
    }

    public tt(com.byazt.vo.tt ttVar) {
        this.c = ttVar;
    }

    public void c(a aVar) {
        if (this.c != null && aVar != null) {
            com.byazt.pr.c.c().c(this.c, aVar);
        }
        c cVar = this.tt;
        if (cVar != null) {
            cVar.c(aVar);
        }
    }

    public static final void c(com.byazt.vo.tt ttVar, Dialog dialog, Integer[] numArr) {
        c(ttVar, dialog, numArr, null);
    }

    public static final void c(com.byazt.vo.tt ttVar, Dialog dialog, Integer[] numArr, c cVar) {
        if (numArr == null || numArr.length <= 0) {
            return;
        }
        tt ttVar2 = new tt(ttVar);
        ttVar2.tt = cVar;
        for (Integer num : numArr) {
            View viewFindViewById = dialog.findViewById(num.intValue());
            if (viewFindViewById instanceof ListView) {
                ListView listView = (ListView) viewFindViewById;
                listView.setOnItemClickListener(new C0507tt(listView.getOnItemClickListener(), ttVar2));
            }
        }
    }
}
