package com.byazt.xky;

import com.byazt.yj.or;
import com.byazt.yj.t;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 169, 54})
public class ve implements or {
    public static int c;
    public String n;
    public long tt = 0;
    public boolean uj;
    public long ve;

    public ve() {
        c++;
        this.n = "image_request_" + c;
    }

    private String c(String str, t tVar) {
        com.byazt.oz.c cVarT;
        if (str == null) {
            return str;
        }
        switch (str) {
            case "success":
                return "成功";
            case "raw_cache":
                return "查询RAW内存缓存";
            case "image_type":
                return "判断图片类型：";
            case "disk_cache":
                return "查询文件缓存";
            case "decode":
                return "解码";
            case "failed":
                if (!(tVar instanceof com.byazt.oz.ve) || (cVarT = ((com.byazt.oz.ve) tVar).t()) == null) {
                    return "失败";
                }
                Throwable thVe = cVarT.ve();
                StringBuilder sb = new StringBuilder("失败：code:");
                sb.append(cVarT.c());
                sb.append(", msg:");
                sb.append(cVarT.tt());
                sb.append(", exception:");
                sb.append(thVe != null ? thVe.getMessage() : "null \r\n");
                return sb.toString();
            case "check_duplicate":
                return "检查重复请求";
            case "memory_cache":
                return "查询Bitmap内存缓存";
            case "net_request":
                return "请求网络";
            case "generate_key":
                return "生成KEY:" + tVar.getMemoryCacheKey();
            case "cache_policy":
                return "查询缓存策略";
            default:
                return str;
        }
    }

    @Override // com.byazt.yj.or
    public void onStepEnd(String str, t tVar) {
        this.ve += System.currentTimeMillis() - this.tt;
        c(str, tVar);
    }

    @Override // com.byazt.yj.or
    public void onStepStart(String str, t tVar) {
        if (!this.uj) {
            tVar.getUrl();
            tVar.getWidth();
            tVar.getHeight();
            this.uj = true;
        }
        this.tt = System.currentTimeMillis();
        c(str, tVar);
    }
}
