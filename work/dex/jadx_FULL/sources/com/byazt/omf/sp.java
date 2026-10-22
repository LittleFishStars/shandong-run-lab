package com.byazt.omf;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 31, 91})
public class sp {
    public static String c(int i) {
        if (i == -16) {
            return "重复渲染";
        }
        if (i == 113 || i == 123) {
            return "解析错误";
        }
        if (i == 20001) {
            return "没有广告";
        }
        if (i == 40046) {
            return "bidding 过期";
        }
        if (i == 50001) {
            return "出现频率较高可通过工单联系技术支持处理";
        }
        if (i == 60007) {
            return "服务异常或者访问超时导致，出现频率较高";
        }
        if (i == 117) {
            return "解析超时";
        }
        if (i == 118) {
            return "渲染失败";
        }
        if (i == 127) {
            return "解析超时";
        }
        if (i == 128) {
            return "渲染失败";
        }
        if (i == 201) {
            return "icon加载response错误";
        }
        if (i == 202) {
            return "icon图标加载失败";
        }
        switch (i) {
            case com.heytap.mcssdk.constant.a.InterfaceC0776a.n /* -14 */:
                return "开屏视频加载失败";
            case -13:
                return "广告请求使用了错误代码位";
            case -12:
                return "缓存中没有开屏广告";
            case -11:
            case -10:
                return "请重新发起广告请求";
            case -9:
                return "请求实体为空";
            case -8:
                return "客户端单用户维度广告请求的频率低于50次请求/10s时，可缓解此问题";
            case -7:
                return "可重新发起广告请求，面向API级别28或更高级别的应用，请校验是否使用了明文网络流量默认为“false”，可在application标签中添加 anddroid:usesCleartextTraffic=“true”解决";
            case -6:
                return "插屏广告图片加载失败";
            case -5:
                return "Banner广告加载图片失败";
            case -4:
                return "返回数据缺少必要字段";
            case -3:
                return "没有解析到广告";
            case -2:
                return "网络请求失败";
            case -1:
                return "检查下是否有在在子线程调用了show的情况；注册点击事件时viewgroup的值是否传了空；在onFeedLoaded回调里的业务逻辑发生了异常,导致SDK走到了onError回调中。若排查后依然没有解决可以联系技术支持处理";
            default:
                switch (i) {
                    case 101:
                        return "渲染结果数据解析失败";
                    case 102:
                        return "主模板无效";
                    case 103:
                        return "模板差量无效";
                    case 104:
                        return "模板物料数据异常";
                    case 105:
                        return "模板数据解析异常";
                    case 106:
                        return "渲染未知报错";
                    case 107:
                        return "渲染超时未回调";
                    case 108:
                        return "模板广告加载超时无返回";
                    case 109:
                        return "模板主引擎加载失败";
                    case 110:
                        return "模板广告请求参数不合法，如传入宽度不大于0";
                    default:
                        switch (i) {
                            case 40000:
                                return "http conent_type错误";
                            case 40001:
                                return "检查一下 useData中个性化设置personal_ads_type对应的value的类型是否为String";
                            case 40002:
                                return "请求app不能为空 ";
                            case 40003:
                                return "请求wap不能为空";
                            case 40004:
                                return "广告位不能为空";
                            case 40005:
                                return "请检查广告请求设置的尺寸是否正确。如排查后仍无法解决，请联系对应的技术支持人员或通过工单进行反馈。";
                            case 40006:
                                return "请检查代码位ID状态是否为运行中，新建代码位20min后生效；若代码位ID开启了聚合，要确保初始化参数中聚后合功能参数设置正确。详情可参考：https://www.csjplatform.com/supportcenter/5421";
                            case 40007:
                                return "检查设置的广告请求条数，SDK支持的数量为1-3条";
                            case 40008:
                                return "检查广告请求传入的广告尺寸是否正确，传入的尺寸超过10000会导致该问题";
                            case 40009:
                                return "媒体ID不合法";
                            case 40010:
                                return "媒体类型不合法";
                            case 40011:
                                return "广告类型不合法";
                            case 40012:
                            case 40017:
                                return "媒体接入类型不合法";
                            case 40013:
                                return "检查请求广告使用的代码位ID是否正确,开屏代码位ID为8开头的九位数字";
                            case 40014:
                                return "redirect参数不正确";
                            case 40015:
                                return "媒体整改超过期限，请求非法";
                            case 40016:
                                return "检查代码中设置的应用ID与代码位ID是否匹配且传入的值无误，并保证在广告请求之前完成SDK初始化完成";
                            case 40018:
                                return "开发者需要确保广告请求时携带的包名和在平台上创建应用时填写的包名的一致性";
                            case 40019:
                                return "检查广告请求的接口与实际的代码位类型是否匹配，例如创建了开屏代码位但代码中调用了Banner的请求接口";
                            case 40020:
                                return "可以平稳放量，限制会被逐渐放开";
                            case 40021:
                                return "检查实际发出广告请求应用的SHA1值和在平台上创建应用时填写的SHA1值是否匹配。部分商店会对第一次上线的APP进行二签，二签后sha1如果发生变化，需在平台更新sha1值";
                            case 40022:
                                return "确保创建的代码位渲染方式与广告请求类型相匹配。如创建了自渲染或者模板渲染的代码位,而使用了非原生Banner、插屏的广告请求方法";
                            case 40023:
                                return "os字段填的不对";
                            case 40024:
                                return "请至开发者平台获取最新SDK版本进行更新";
                            default:
                                switch (i) {
                                    case 60001:
                                        return "show event处理错误";
                                    case 60002:
                                        return "click event处理错误";
                                    default:
                                        return "未知报错";
                                }
                        }
                }
        }
    }
}
