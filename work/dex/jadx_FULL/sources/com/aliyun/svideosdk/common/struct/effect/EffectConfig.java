package com.aliyun.svideosdk.common.struct.effect;

import android.util.Log;
import com.aliyun.Visible;
import com.aliyun.common.b.b;
import com.aliyun.common.utils.q;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class EffectConfig {
    private String module;
    private List<NodeBean> nodeTree;
    private int type;
    private int version;

    public static class NodeBean {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f25665a;
        private List<Textures> b;
        private List<Params> c;

        public static class Params {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @SerializedName("name")
            private String f25666a;
            private String b;
            private Object[] c;
            private int d;
            private Object[] e;
            private Object[] f;
            private transient ValueTypeEnum.Value g;
            private transient ValueTypeEnum h;
            private transient ValueTypeEnum.Value i;
            private transient ValueTypeEnum.Value j;

            public ValueTypeEnum.Value getMaxValue() {
                if (this.i == null) {
                    this.i = ValueTypeEnum.getValue(this.b, this.e);
                }
                return this.i;
            }

            public ValueTypeEnum.Value getMinValue() {
                if (this.j == null) {
                    this.j = ValueTypeEnum.getValue(this.b, this.f);
                }
                return this.j;
            }

            public String getName() {
                return this.f25666a;
            }

            public ValueTypeEnum getType() {
                if (this.h == null) {
                    this.h = ValueTypeEnum.typeOf(this.b);
                }
                return this.h;
            }

            public ValueTypeEnum.Value getValue() {
                if (this.g == null) {
                    this.g = ValueTypeEnum.getValue(this.b, this.c);
                }
                return this.g;
            }
        }

        public static class Textures {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @SerializedName("name")
            private String f25667a;
            private String b;
            private int c;

            public String getNameX() {
                return this.f25667a;
            }

            public int getNodeId() {
                return this.c;
            }

            public String getSrcType() {
                return this.b;
            }
        }

        public List<Params> getParams() {
            return this.c;
        }

        public List<Textures> getTextures() {
            return this.b;
        }
    }

    public List<NodeBean> getNodeTree() {
        return this.nodeTree;
    }

    public String getParamsJsonString() {
        ArrayList arrayList = new ArrayList();
        List<NodeBean> nodeTree = getNodeTree();
        if (nodeTree == null) {
            return null;
        }
        for (NodeBean nodeBean : nodeTree) {
            if (nodeBean.c != null) {
                for (NodeBean.Params params : nodeBean.c) {
                    params.d = nodeBean.f25665a;
                    if (params.g != null) {
                        System.arraycopy(params.g.getValue(), 0, params.c, 0, params.c.length);
                    }
                    arrayList.add(params);
                }
            }
        }
        try {
            return new b().writeValue(arrayList);
        } catch (Exception e) {
            Log.e("AliYunLog", "EffectConfig getParamsJsonString failure! msg : " + e.getMessage());
            return null;
        }
    }

    public void readParamsJson(String str) {
        List<NodeBean> nodeTree;
        if (q.b(str)) {
            return;
        }
        try {
            List<NodeBean.Params> list = (List) new b().readListValue(str, new TypeToken<List<NodeBean.Params>>(this) { // from class: com.aliyun.svideosdk.common.struct.effect.EffectConfig.1
            }.getType());
            if ((list == null || !list.isEmpty()) && (nodeTree = getNodeTree()) != null) {
                for (NodeBean nodeBean : nodeTree) {
                    if (nodeBean.c != null) {
                        for (NodeBean.Params params : nodeBean.c) {
                            for (NodeBean.Params params2 : list) {
                                if (params2.d == nodeBean.f25665a && params2.f25666a != null && params2.f25666a.equals(params.f25666a) && params2.c != null) {
                                    System.arraycopy(params2.c, 0, params.c, 0, params.c.length);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
