package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.model.impl.db.StrategyEventDBModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.bl.BlackListModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.ConfigResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.strategy.StrategyModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.strategy.filter.StrategyFilterModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.strategy.filter.frequency.StrategyFrequencyModel;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27665a;
    private final l b;
    private Map d;
    private final Map e = new HashMap();
    private final d c = new d();

    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int iC = q0.this.b.c(StrategyEventDBModel.class);
            if (iC > 1000) {
                long[] jArrA = q0.this.b.a(StrategyEventDBModel.class, iC / 2);
                if (jArrA == null || jArrA.length <= 0) {
                    return;
                }
                q0.this.b.a(StrategyEventDBModel.class, jArrA);
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StrategyEventDBModel f27667a;

        private b(StrategyEventDBModel strategyEventDBModel) {
            this.f27667a = strategyEventDBModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            q0.this.b.a(this.f27667a);
        }
    }

    public class c implements Runnable {
        private c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = q0.this.b;
            List<StrategyEventDBModel> listA = lVar.a(StrategyEventDBModel.class, lVar.d(StrategyEventDBModel.COLUMN_API_KEY), new String[]{f3.c(m0.a())}, q0.this.b.a(StrategyEventDBModel.COLUMN_EVENT_TIME), -1);
            if (listA != null) {
                for (StrategyEventDBModel strategyEventDBModel : listA) {
                    q0.this.a(strategyEventDBModel.getSpaceId(), strategyEventDBModel.getEventCode(), strategyEventDBModel);
                }
            }
        }
    }

    public q0(Context context) {
        this.f27665a = context;
        this.b = (l) m.a().b(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ((fb) cn.a().b(this.f27665a)).a(new a());
    }

    public synchronized void a(String str, u7 u7Var) {
        if (TextUtils.isEmpty(str) || u7Var == null || !a(str)) {
            return;
        }
        StrategyEventDBModel strategyEventDBModel = new StrategyEventDBModel();
        strategyEventDBModel.setApiKey(m0.a());
        strategyEventDBModel.setEventCode(u7Var.getEventCode());
        strategyEventDBModel.setEventTime(System.currentTimeMillis() + "");
        strategyEventDBModel.setSpaceId(str);
        a(str, u7Var.getEventCode(), strategyEventDBModel);
        a(strategyEventDBModel);
    }

    public synchronized List c() {
        JSONArray jSONArrayB;
        String strA = p0.a(this.f27665a, "BL_INFO", "bl", "");
        if (TextUtils.isEmpty(strA) || (jSONArrayB = mg.b(f3.b(strA))) == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayB.length(); i++) {
            String strOptString = jSONArrayB.optString(i);
            if (!TextUtils.isEmpty(strOptString)) {
                arrayList.add(strOptString);
            }
        }
        return arrayList;
    }

    public synchronized String d() {
        String strA = p0.a(this.f27665a, "BL_INFO", "blv", "0");
        return TextUtils.isEmpty(strA) ? "0" : strA;
    }

    public void e() {
        ((g) h.a().b(this.f27665a)).a(this.c);
        a();
    }

    public class d implements mc {
        private d() {
        }

        @Override // com.beizi.fusion.mc
        public void a(ConfigResponseModel configResponseModel, g.a aVar, boolean z) {
            if (configResponseModel != null) {
                q0.this.e.clear();
                q0.this.e.putAll(a(configResponseModel.getStrategyList()));
            }
            q0.this.b();
        }

        private Map a(List list) {
            HashMap map = new HashMap();
            if (list != null && !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    StrategyModel strategyModel = (StrategyModel) it.next();
                    if (strategyModel != null) {
                        String spaceID = strategyModel.getSpaceID();
                        StrategyFilterModel filter = strategyModel.getFilter();
                        if (!TextUtils.isEmpty(spaceID) && filter != null) {
                            map.put(strategyModel.getSpaceID(), filter);
                        }
                    }
                }
            }
            return map;
        }
    }

    public synchronized LinkedList b(String str, String str2) {
        Map map = this.d;
        if (map == null) {
            return null;
        }
        return (LinkedList) map.get(a(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, StrategyEventDBModel strategyEventDBModel) {
        String strA = a(str, str2);
        if (this.d == null) {
            this.d = new HashMap();
        }
        LinkedList linkedList = (LinkedList) this.d.get(strA);
        if (linkedList == null) {
            linkedList = new LinkedList();
        }
        linkedList.addFirst(strategyEventDBModel);
        this.d.put(strA, linkedList);
    }

    private void a(StrategyEventDBModel strategyEventDBModel) {
        ((fb) cn.a().b(this.f27665a)).a(new b(strategyEventDBModel));
        a(strategyEventDBModel.getSpaceId(), strategyEventDBModel.getEventCode(), strategyEventDBModel);
    }

    private String a(String str, String str2) {
        return String.format("HS_%s_%s", str, str2);
    }

    private void a() {
        ((fb) cn.a().b(this.f27665a)).a(new c());
    }

    private boolean a(String str) {
        StrategyFilterModel strategyFilterModel;
        List<StrategyFrequencyModel> frequencyModels;
        return (!this.e.containsKey(str) || (strategyFilterModel = (StrategyFilterModel) this.e.get(str)) == null || (frequencyModels = strategyFilterModel.getFrequencyModels()) == null || frequencyModels.isEmpty()) ? false : true;
    }

    public synchronized void a(BlackListModel blackListModel) {
        JSONArray jSONArrayA;
        if (blackListModel != null) {
            String version = blackListModel.getVersion();
            String strD = d();
            if (!TextUtils.isEmpty(version) && !strD.equals(version)) {
                JSONObject jSONObjectAsJsonObject = blackListModel.asJsonObject();
                if (jSONObjectAsJsonObject != null && (jSONArrayA = mg.a(jSONObjectAsJsonObject, GoodsSpecificationPreviewActivity.z)) != null && jSONArrayA.length() > 0) {
                    p0.b(this.f27665a, "BL_INFO", "bl", f3.c(jSONArrayA.toString()));
                }
                p0.b(this.f27665a, "BL_INFO", "blv", blackListModel.getVersion());
            }
        }
    }
}
