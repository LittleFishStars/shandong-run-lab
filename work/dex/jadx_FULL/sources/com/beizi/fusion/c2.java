package com.beizi.fusion;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class c2 {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static List a(AdSpacesBean.ComponentBean componentBean, List list, String str) {
        String content;
        ArrayList arrayList = new ArrayList();
        if (componentBean != null && list != null && list.size() != 0 && (content = componentBean.getContent()) != null) {
            switch (content) {
                case "random":
                    a(componentBean, arrayList);
                    break;
                case "fail":
                    a(componentBean, list, str, arrayList, "280.500");
                    return arrayList;
                case "show":
                    a(componentBean, list, str, arrayList, "280.300");
                    return arrayList;
                case "click":
                    a(componentBean, list, str, arrayList, "290.300");
                    return arrayList;
                case "request":
                    a(componentBean, list, str, arrayList, "200.000");
                    return arrayList;
            }
        }
        return arrayList;
    }

    private static boolean b(List list, int i) {
        boolean z;
        if (list == null) {
            return false;
        }
        if (list.size() == 0) {
            jh.b("BeiZis", "enter rulesBeanList.size() == 0");
            z = true;
        } else {
            z = false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (a((AdSpacesBean.RulesBean) list.get(i2), i)) {
                return true;
            }
        }
        return z;
    }

    public static int c(String str) {
        String strB;
        if (str == null || (strB = b(str)) == null) {
            return -1;
        }
        return Integer.parseInt(strB);
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        if (oo.b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) {
            return BeiZiBiddingConstant.Adn.ADN_BZ;
        }
        if (str.equals("ADSCOPE")) {
            return "8888";
        }
        return null;
    }

    private static void a(AdSpacesBean.ComponentBean componentBean, List list, String str, List list2, String str2) {
        jh.b("BeiZis", "enter handleSpaceStrategyByEvent eventCode = " + str2);
        List<AdSpacesBean.ForwardBean> forward = componentBean.getForward();
        if (forward == null || forward.size() <= 0) {
            return;
        }
        int iA = j8.a(str, str2);
        if (!str2.equalsIgnoreCase("200.000")) {
            iA++;
        }
        for (int i = 0; i < forward.size(); i++) {
            AdSpacesBean.ForwardBean forwardBean = forward.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                AdSpacesBean.BuyerBean buyerBean = (AdSpacesBean.BuyerBean) list.get(i2);
                if (buyerBean.getId() != null && buyerBean.getId().equalsIgnoreCase(forwardBean.getBuyerId()) && buyerBean.getBuyerSpaceUuId() != null && buyerBean.getBuyerSpaceUuId().equalsIgnoreCase(forwardBean.getBuyerSpaceUuId())) {
                    jh.b("BeiZis", forwardBean.getBuyerId() + " handleSpaceRequestStrategy buyerBean match");
                    if (b(forwardBean.getRules(), iA)) {
                        jh.b("BeiZis", forwardBean.getBuyerId() + " enter rulesMatch");
                        list2.add(forwardBean);
                    }
                }
            }
        }
    }

    public static void a(AdSpacesBean.ComponentBean componentBean, List list) {
        List<AdSpacesBean.ForwardBean> forward = componentBean.getForward();
        int iRandom = (int) ((Math.random() * 100.0d) + 1.0d);
        jh.a("BeiZis", "AdForward random:" + iRandom);
        if (forward == null || forward.size() <= 0) {
            return;
        }
        int size = forward.size();
        for (int i = 0; i < size; i++) {
            AdSpacesBean.ForwardBean forwardBean = forward.get(i);
            List<AdSpacesBean.RulesBean> rules = forwardBean.getRules();
            if (rules != null && rules.size() > 0) {
                int size2 = rules.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    Integer[] results = rules.get(i2).getResults();
                    if (results != null && results.length >= 2) {
                        int iIntValue = results[0].intValue();
                        int iIntValue2 = results[1].intValue();
                        if (iIntValue <= iRandom && iRandom <= iIntValue2) {
                            list.add(forwardBean);
                        }
                    }
                }
            }
        }
    }

    private static boolean a(AdSpacesBean.RulesBean rulesBean, int i) {
        boolean z = false;
        if (rulesBean == null) {
            return false;
        }
        try {
            String strReplace = rulesBean.getFormula().replace("x", i + "");
            int iA = bl.a(strReplace);
            Integer[] results = rulesBean.getResults();
            jh.b("BeiZis", "formulaOrig = " + strReplace + ",isOneRuleMatch holderNum = " + i);
            if (results != null && results.length >= 2) {
                jh.b("BeiZis", "formulaResult = " + iA + ",results[0] = " + results[0] + ",results[1] = " + results[1]);
                if (iA >= results[0].intValue() && iA <= results[1].intValue()) {
                    z = true;
                }
            }
            return rulesBean.getRules() != null ? b(rulesBean.getRules(), i) & z : z;
        } catch (Exception unused) {
            jh.b("BeiZis", "execute formula error!");
            return z;
        }
    }

    public static void a(Context context, long j, AdSpacesBean.FilterBean filterBean, ik ikVar, String str, String str2, String str3, o1 o1Var) {
        boolean z;
        boolean z2;
        boolean z3;
        if (ikVar != null) {
            jh.a("BeiZis", "channel = " + str2 + ",observer.mPlatformFilterStatus.getStatus() = " + ikVar.d.a() + ",observer.mChannelFilterStatus.getStatus(channelId) = " + ikVar.f.a(str2));
        }
        boolean zIsEmpty = TextUtils.isEmpty(str2);
        if (ikVar != null) {
            boolean zA = true;
            if (ikVar.d.a() == 1 || ikVar.f.a(str2) == 2) {
                if (filterBean != null) {
                    List<String> privilege = filterBean.getPrivilege();
                    boolean zA2 = (privilege == null || privilege.size() <= 0) ? true : a(context, privilege);
                    z3 = false;
                    z2 = j > ((long) filterBean.getMinAdLoadTime());
                    try {
                        zA = j8.a(filterBean.getFrequency(), str, a(str2), str3);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    boolean z4 = zA;
                    zA = zA2;
                    z = z4;
                } else {
                    if (!zIsEmpty) {
                        ikVar.f.a(str2, 3);
                    } else {
                        ikVar.d.a(2);
                    }
                    z = true;
                    z2 = true;
                    z3 = true;
                }
                if (!zA) {
                    if (!zIsEmpty) {
                        ikVar.f.a(str2, 5);
                    } else {
                        ikVar.d.a(4);
                    }
                }
                if (!z2) {
                    if (!zIsEmpty) {
                        ikVar.f.a(str2, 6);
                    } else {
                        ikVar.d.a(5);
                    }
                }
                if (!z) {
                    if (!zIsEmpty) {
                        ikVar.f.a(str2, 7);
                    } else {
                        ikVar.d.a(6);
                    }
                }
                if (!z3 && zA && z2 && z) {
                    if (!zIsEmpty) {
                        ikVar.f.a(str2, 3);
                        return;
                    } else {
                        ikVar.d.a(2);
                        return;
                    }
                }
                return;
            }
        }
        if (ikVar != null) {
            if (!zIsEmpty) {
                ikVar.f.a(str2, -2);
                return;
            } else {
                ikVar.d.a(-2);
                return;
            }
        }
        if (o1Var == null || !zIsEmpty) {
            return;
        }
        o1Var.a("status not PlatformFilterStatus.kPlatformFilterStatusBegin");
    }

    private static boolean a(Context context, List list) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (-1 == packageManager.checkPermission(str, packageName)) {
                Log.d("lance", "required permission not granted . permission = " + str);
                return false;
            }
        }
        return true;
    }

    public static AdSpacesBean.BuyerBean a(String str, List list, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("buyerBeans != null ? ");
        sb.append(list != null);
        jh.b("BeiZis", sb.toString());
        if (list != null) {
            jh.b("BeiZis", "buyerBeans.size() = " + list.size());
        }
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            AdSpacesBean.BuyerBean buyerBean = (AdSpacesBean.BuyerBean) list.get(i);
            jh.b("BeiZis", "AdBuyer buyerBean.getUuid() = " + buyerBean.getBuyerSpaceUuId());
            if (buyerBean.getId() != null && buyerBean.getId().equals(str) && str2 != null && str2.equalsIgnoreCase(buyerBean.getBuyerSpaceUuId())) {
                return buyerBean;
            }
        }
        return null;
    }

    public static String a(List list, int i) {
        Integer[] results;
        if (list == null) {
            return null;
        }
        try {
            if (list.size() == 0) {
                return null;
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                AdSpacesBean.BuyerBean.RenderRulesBean renderRulesBean = (AdSpacesBean.BuyerBean.RenderRulesBean) list.get(i2);
                if (renderRulesBean != null && (results = renderRulesBean.getResults()) != null && results.length >= 2 && i >= results[0].intValue() && i <= results[1].intValue()) {
                    String type = renderRulesBean.getType();
                    jh.b("BeiZis", "type = " + type + ";holderNum:" + i);
                    return type;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String a(String str) {
        jh.a("BeiZis", "enter convertSelfChannel buyerId = " + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return oo.b().equals(str) ? "BEIZI" : str;
    }
}
