package com.byazt.pp;

import android.text.TextUtils;
import com.igexin.sdk.PushConsts;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1434, 20})
public class c {
    public int c;
    public Map<String, Object> n;
    public String tt;
    public String uj;
    public int ve;

    public c() {
        this(-99999, "no error message");
    }

    public static String c(int i) {
        switch (i) {
            case -2:
                return "检查一下网络连接是否正常或者查看是否设置了代理";
            case -1:
                return "检查是否在子线程调用了广告展示；检查注册点击事件时viewgroup是否传空 ";
            case 1:
                return "MSDK还未初始化";
            case 10003:
                return "load ad timeout !!!";
            case 10012:
                return "Adn超时后回调";
            case 10013:
                return "Adm数据异常";
            case PushConsts.ACTION_NOTIFICATION_ENABLE /* 10014 */:
                return "广告位不是内容混出广告位，请查看配置";
            case PushConsts.ACTION_POPUP_SHOW /* 10015 */:
                return "请先获取token相关信息";
            case 20005:
                return "广告位下全部代码位均请求失败，可在广告加载时通过自定义参数setExtraObject(\"show_adn_load_error_detail\", true)打开各ADN错误信息开关，并通过onError(int code, String message)方法获取加载失败ADN的相关错误信息进行问题排查";
            case 40044:
                return "可调整广告请求发起间隔解决";
            case 40045:
            case 840040:
                return "清理客户端缓存并调整广告请求在SDK初始化成功后；首次冷启动拉取不到配置导致，可参考文档解决  https://www.csjplatform.com/supportcenter/5885 ";
            case 40047:
                return "每次加载广告时需重新创建新的广告对象";
            case 40048:
                return "已经展示过的广告对象不可重复使用";
            case 40052:
                return "若为穿山甲广告可优先检查是否是调整了系统时间导致";
            case 40061:
                return "价格标签为空字符，无多阶底价权限或权限异常";
            case 40062:
                return "无法解析价格标签，请确认并更新平台配置";
            case 40063:
                return "非穿山甲给出的展示广告";
            case 40064:
                return "命中WF级别配置的ADN错误码，进入冷冻期，实际未发起请求";
            case 41005:
                return "请检查传入的context是否为null";
            case 41007:
                return "暂无公用缓存池访问权限";
            case 41008:
                return "暂无公用缓存池广告";
            case 41041:
                return "超过代码位层级规定的用户展示上限，实际未发起请求，请求失败";
            case 41042:
                return "未超过代码位层级规定的展示间隔，请求频繁，实际未发起请求";
            case 41043:
                return "请检查内存占用情况，如占比较高可提供日志广告ID提工单联系技术支持解决";
            case 41044:
                return "请勿重复调用destroy方法";
            case 44404:
                return "确保网络环境正常后重新发起请求";
            case 44405:
                return "检查网络环境是否正常，更换网络重新发起请求";
            case 49000:
                return "自定义ADN banner load失败";
            case 49001:
                return "自定义ADN banner show失败";
            case 49002:
                return "自定义ADN 插屏 load失败";
            case 49003:
                return "自定义ADN 插屏 show失败";
            case 49004:
                return "自定义ADN 激励视频 load失败";
            case 49005:
                return "自定义ADN 激励视频 show失败";
            case 49006:
                return "自定义ADN 全屏视频 load失败";
            case 49007:
                return "自定义ADN 全屏视频 show失败";
            case 49008:
                return "自定义ADN 开屏视频 load失败";
            case 49009:
                return "自定义ADN 开屏视频 show失败";
            case 49010:
                return "自定义ADN 信息流 load失败";
            case 49012:
                return "自定义ADN 信息流 视频播放失败";
            case 49015:
                return "自定义ADN draw load失败";
            case 49016:
                return "自定义ADN draw 视频播放失败";
            case 50100:
                return "本次出价低于竞价底价";
            case 81001:
                return "配置正在请求中，稍后重试";
            case 81002:
                return "无白名单权限";
            case 81003:
                return "传入的参数有误或为空，请检查参数";
            case 81004:
                return "CSJ4900已经移除旧插屏接口，但仍然有旧插屏代码位请求，请接入CSJ48xx或更换为新插屏代码位";
            case 81008:
                return "no ad";
            case 81009:
                return "only customAd";
            case 81010:
                return "adn impl changed";
            case 81011:
                return "adn本身问题，不支持轮播";
            case 81012:
                return "ui测试工具config为null";
            case 810085:
                return "命中请求过于频繁、无返回";
            case 840026:
                return "请检查Adslot是否为null";
            case 840027:
                return "请检查开屏广告自定义兜底参数是否正确";
            case 840028:
                return "检查应用ID与初始化的应用ID是否一致";
            case 840029:
                return "该广告暂无广告返回，请稍后重试";
            case 840030:
                return "Draw广告暂无广告返回，请稍后重试";
            case 840031:
                return "在ADN后台明确创建的广告类型，需确保与开发者平台设置的匹配";
            case 840032:
                return "Banner广告暂无广告返回，请稍后重试";
            case 840033:
                return "插屏广告暂无广告返回，请稍后重试";
            case 840034:
                return "开屏广告暂无广告返回，请稍后重试";
            case 840035:
                return "信息流广告暂无广告返回，请稍后重试";
            case 840036:
                return "激励视频广告暂无广告返回，请稍后重试";
            case 840037:
                return "全屏视频广告暂无广告返回，请稍后重试";
            case 840038:
                return "信息流广告暂无广告返回，请稍后重试";
            case 840039:
                return "插全屏广告暂无广告返回，请稍后重试";
            case 840041:
                return "可检查该广告位ID下的【瀑布流属性设置内】-【展示控制设置】-【天级别频控】是否达到上限";
            case 840042:
                return "展示控制错误码，无需调整，如占比较高可调高瀑布流属性设置中的展示上限及间隔";
            case 840043:
                return "如占比过高，请延长广告请求发起间隔，稍后重试";
            default:
                return "unknown error!";
        }
    }

    public void c(String str, Object obj) {
        if (this.n == null || TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        this.n.put(str, obj);
    }

    public String toString() {
        return "AdError{code=" + this.c + ", message='" + this.tt + "', thirdSdkErrorCode=" + this.ve + ", thirdSdkErrorMessage='" + this.uj + "'}";
    }

    public c(String str) {
        this(-99999, str);
    }

    public c(int i, String str) {
        this(i, str, i, str);
    }

    public Object c(String str) {
        if (this.n == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.n.get(str);
    }

    public c(int i, String str, int i2, String str2) {
        this.n = new ConcurrentHashMap(1);
        this.c = i;
        this.tt = str;
        this.ve = i2;
        this.uj = str2;
    }
}
