package com.aliyun.ossutil;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.alipay.sdk.m.t.e;
import com.alipay.sdk.m.y.l;
import com.aliyun.credentials.utils.AuthConstant;
import com.aliyun.ossutil.Client;
import com.aliyun.ossutil.models.ErrorResponse;
import com.aliyun.tea.TeaRequest;
import com.aliyun.tea.utils.StringUtils;
import com.byazt.tk.AdBaseConstants;
import com.fl.saas.common.crash.CrashHandler;
import com.google.android.exoplayer2.util.FileTypes;
import com.google.common.reflect.a;
import com.ipd.dsp.internal.q.r;
import com.kuaishou.weapon.p0.d;
import com.zj.adlib.l72;
import com.zj.adlib.u15;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.function.BiConsumer;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Client {
    protected static final String _defaultUserAgent;
    private static char[] characters;
    private static Map<String, String> contentType = new HashMap();
    private static String[] signKeyList;
    private static Map<String, String> systemContenType;

    static {
        String property;
        HashMap map = new HashMap();
        systemContenType = map;
        characters = new char[]{'-', '_', '.', '~'};
        signKeyList = new String[]{RequestParameters.SUBRESOURCE_LOCATION, RequestParameters.SUBRESOURCE_CORS, RequestParameters.SUBRESOURCE_OBJECT_META, RequestParameters.UPLOAD_ID, RequestParameters.PART_NUMBER, RequestParameters.SECURITY_TOKEN, "position", "img", "style", "styleName", "replication", "replicationProgress", "replicationLocation", "cname", "qos", "startTime", "endTime", RequestParameters.X_OSS_SYMLINK, RequestParameters.X_OSS_PROCESS, RequestParameters.RESPONSE_HEADER_CONTENT_TYPE, RequestParameters.RESPONSE_HEADER_CONTENT_LANGUAGE, RequestParameters.RESPONSE_HEADER_EXPIRES, RequestParameters.RESPONSE_HEADER_CACHE_CONTROL, RequestParameters.RESPONSE_HEADER_CONTENT_DISPOSITION, RequestParameters.RESPONSE_HEADER_CONTENT_ENCODING, "udf", "udfName", "udfImage", "udfId", "udfImageDesc", "udfApplication", "udfApplicationLog", RequestParameters.X_OSS_RESTORE, RenderCallContext.TYPE_CALLBACK, "callback-var", AuthConstant.INI_POLICY, "encryption", "versions", "versioning", "versionId"};
        map.put(".323", "text/h323");
        systemContenType.put(".asx", "video/x-ms-asf");
        systemContenType.put(".acx", "application/internet-property-stream");
        systemContenType.put(".ai", "application/postscript");
        systemContenType.put(".aif", "audio/x-aiff");
        systemContenType.put(".aiff", "audio/aiff");
        systemContenType.put(".axs", "application/olescript");
        systemContenType.put(".aifc", "audio/aiff");
        systemContenType.put(".asr", "video/x-ms-asf");
        systemContenType.put(FileTypes.H, "video/x-msvideo");
        systemContenType.put(".asf", "video/x-ms-asf");
        systemContenType.put(".au", "audio/basic");
        systemContenType.put(".application", "application/x-ms-application");
        systemContenType.put(".bin", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        systemContenType.put(".bas", "text/plain");
        systemContenType.put(".bcpio", "application/x-bcpio");
        systemContenType.put(".bmp", "image/bmp");
        systemContenType.put(".cdf", "application/x-cdf");
        systemContenType.put(".cat", "application/vndms-pkiseccat");
        systemContenType.put(".crt", "application/x-x509-ca-cert");
        systemContenType.put(".c", "text/plain");
        systemContenType.put(".css", "text/css");
        systemContenType.put(".cer", "application/x-x509-ca-cert");
        systemContenType.put(".crl", "application/pkix-crl");
        systemContenType.put(".cmx", "image/x-cmx");
        systemContenType.put(".csh", "application/x-csh");
        systemContenType.put(".cod", "image/cis-cod");
        systemContenType.put(".cpio", "application/x-cpio");
        systemContenType.put(".clp", "application/x-msclip");
        systemContenType.put(".crd", "application/x-mscardfile");
        systemContenType.put(".deploy", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        systemContenType.put(".dll", "application/x-msdownload");
        systemContenType.put(".dot", "application/msword");
        systemContenType.put(".doc", "application/msword");
        systemContenType.put(".dvi", "application/x-dvi");
        systemContenType.put(".dir", "application/x-director");
        systemContenType.put(".dxr", "application/x-director");
        systemContenType.put(".der", "application/x-x509-ca-cert");
        systemContenType.put(".dib", "image/bmp");
        systemContenType.put(".dcr", "application/x-director");
        systemContenType.put(".disco", "text/xml");
        systemContenType.put(".exe", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        systemContenType.put(".etx", "text/x-setext");
        systemContenType.put(".evy", "application/envoy");
        systemContenType.put(".eml", "message/rfc822");
        systemContenType.put(".eps", "application/postscript");
        systemContenType.put(".flr", "x-world/x-vrml");
        systemContenType.put(".fif", "application/fractals");
        systemContenType.put(".gtar", "application/x-gtar");
        systemContenType.put(".gif", "image/gif");
        systemContenType.put(d.b, "application/x-gzip");
        systemContenType.put(".hta", "application/hta");
        systemContenType.put(".htc", "text/x-component");
        systemContenType.put(".htt", "text/webviewhtml");
        systemContenType.put(".h", "text/plain");
        systemContenType.put(".hdf", "application/x-hdf");
        systemContenType.put(".hlp", "application/winhlp");
        systemContenType.put(".html", "text/html");
        systemContenType.put(".htm", "text/html");
        systemContenType.put(".hqx", "application/mac-binhex40");
        systemContenType.put(".isp", "application/x-internet-signup");
        systemContenType.put(".iii", "application/x-iphone");
        systemContenType.put(".ief", "image/ief");
        systemContenType.put(".ivf", "video/x-ivf");
        systemContenType.put(".ins", "application/x-internet-signup");
        systemContenType.put(".ico", "image/x-icon");
        systemContenType.put(FileTypes.F, "image/jpeg");
        systemContenType.put(".jfif", "image/pjpeg");
        systemContenType.put(".jpe", "image/jpeg");
        systemContenType.put(".jpeg", "image/jpeg");
        systemContenType.put(".js", "application/x-javascript");
        systemContenType.put(".lsx", "video/x-la-asf");
        systemContenType.put(".latex", "application/x-latex");
        systemContenType.put(".lsf", "video/x-la-asf");
        systemContenType.put(".manifest", "application/x-ms-manifest");
        systemContenType.put(".mhtml", "message/rfc822");
        systemContenType.put(".mny", "application/x-msmoney");
        systemContenType.put(".mht", "message/rfc822");
        systemContenType.put(FileTypes.f5246j, "audio/mid");
        systemContenType.put(".mpv2", "video/mpeg");
        systemContenType.put(".man", "application/x-troff-man");
        systemContenType.put(".mvb", "application/x-msmediaview");
        systemContenType.put(FileTypes.w, "video/mpeg");
        systemContenType.put(".m3u", "audio/x-mpegurl");
        systemContenType.put(".mdb", "application/x-msaccess");
        systemContenType.put(".mpp", "application/vnd.ms-project");
        systemContenType.put(".m1v", "video/mpeg");
        systemContenType.put(".mpa", "video/mpeg");
        systemContenType.put(".me", "application/x-troff-me");
        systemContenType.put(".m13", "application/x-msmediaview");
        systemContenType.put(".movie", "video/x-sgi-movie");
        systemContenType.put(".m14", "application/x-msmediaview");
        systemContenType.put(".mpe", "video/mpeg");
        systemContenType.put(".mp2", "video/mpeg");
        systemContenType.put(".mov", "video/quicktime");
        systemContenType.put(FileTypes.f5253q, "audio/mpeg");
        systemContenType.put(FileTypes.x, "video/mpeg");
        systemContenType.put(".ms", "application/x-troff-ms");
        systemContenType.put(".nc", "application/x-netcdf");
        systemContenType.put(".nws", "message/rfc822");
        systemContenType.put(".oda", "application/oda");
        systemContenType.put(".ods", "application/oleobject");
        systemContenType.put(".pmc", "application/x-perfmon");
        systemContenType.put(".p7r", "application/x-pkcs7-certreqresp");
        systemContenType.put(".p7b", "application/x-pkcs7-certificates");
        systemContenType.put(".p7s", "application/pkcs7-signature");
        systemContenType.put(".pmw", "application/x-perfmon");
        systemContenType.put(FileTypes.v, "application/postscript");
        systemContenType.put(".p7c", "application/pkcs7-mime");
        systemContenType.put(".pbm", "image/x-portable-bitmap");
        systemContenType.put(".ppm", "image/x-portable-pixmap");
        systemContenType.put(".pub", "application/x-mspublisher");
        systemContenType.put(".pnm", "image/x-portable-anymap");
        systemContenType.put(".png", "image/png");
        systemContenType.put(".pml", "application/x-perfmon");
        systemContenType.put(".p10", "application/pkcs10");
        systemContenType.put(".pfx", "application/x-pkcs12");
        systemContenType.put(".p12", "application/x-pkcs12");
        systemContenType.put(".pdf", "application/pdf");
        systemContenType.put(".pps", "application/vnd.ms-powerpoint");
        systemContenType.put(".p7m", "application/pkcs7-mime");
        systemContenType.put(".pko", "application/vndms-pkipko");
        systemContenType.put(".ppt", "application/vnd.ms-powerpoint");
        systemContenType.put(".pmr", "application/x-perfmon");
        systemContenType.put(".pma", "application/x-perfmon");
        systemContenType.put(".pot", "application/vnd.ms-powerpoint");
        systemContenType.put(".prf", "application/pics-rules");
        systemContenType.put(".pgm", "image/x-portable-graymap");
        systemContenType.put(".qt", "video/quicktime");
        systemContenType.put(".ra", "audio/x-pn-realaudio");
        systemContenType.put(".rgb", "image/x-rgb");
        systemContenType.put(".ram", "audio/x-pn-realaudio");
        systemContenType.put(".rmi", "audio/mid");
        systemContenType.put(".ras", "image/x-cmu-raster");
        systemContenType.put(".roff", "application/x-troff");
        systemContenType.put(".rtf", "application/rtf");
        systemContenType.put(".rtx", "text/richtext");
        systemContenType.put(".sv4crc", "application/x-sv4crc");
        systemContenType.put(".spc", "application/x-pkcs7-certificates");
        systemContenType.put(".setreg", "application/set-registration-initiation");
        systemContenType.put(".snd", "audio/basic");
        systemContenType.put(".stl", "application/vndms-pkistl");
        systemContenType.put(".setpay", "application/set-payment-initiation");
        systemContenType.put(".stm", "text/html");
        systemContenType.put(".shar", "application/x-shar");
        systemContenType.put(".sh", "application/x-sh");
        systemContenType.put(".sit", "application/x-stuffit");
        systemContenType.put(".spl", "application/futuresplash");
        systemContenType.put(".sct", "text/scriptlet");
        systemContenType.put(".scd", "application/x-msschedule");
        systemContenType.put(".sst", "application/vndms-pkicertstore");
        systemContenType.put(".src", "application/x-wais-source");
        systemContenType.put(".sv4cpio", "application/x-sv4cpio");
        systemContenType.put(".tex", "application/x-tex");
        systemContenType.put(".tgz", "application/x-compressed");
        systemContenType.put(".t", "application/x-troff");
        systemContenType.put(".tar", "application/x-tar");
        systemContenType.put(".tr", "application/x-troff");
        systemContenType.put(".tif", "image/tiff");
        systemContenType.put(CrashHandler.FILE_NAME_SUFFIX, "text/plain");
        systemContenType.put(".texinfo", "application/x-texinfo");
        systemContenType.put(".trm", "application/x-msterminal");
        systemContenType.put(".tiff", "image/tiff");
        systemContenType.put(".tcl", "application/x-tcl");
        systemContenType.put(".texi", "application/x-texinfo");
        systemContenType.put(".tsv", "text/tab-separated-values");
        systemContenType.put(".ustar", "application/x-ustar");
        systemContenType.put(".uls", "text/iuls");
        systemContenType.put(".vcf", "text/x-vcard");
        systemContenType.put(".wps", "application/vnd.ms-works");
        systemContenType.put(FileTypes.B, "audio/wav");
        systemContenType.put(".wrz", "x-world/x-vrml");
        systemContenType.put(".wri", "application/x-mswrite");
        systemContenType.put(".wks", "application/vnd.ms-works");
        systemContenType.put(".wmf", "application/x-msmetafile");
        systemContenType.put(".wcm", "application/vnd.ms-works");
        systemContenType.put(".wrl", "x-world/x-vrml");
        systemContenType.put(".wdb", "application/vnd.ms-works");
        systemContenType.put(".wsdl", "text/xml");
        systemContenType.put(".xap", "application/x-silverlight-app");
        systemContenType.put(".xml", "text/xml");
        systemContenType.put(".xlm", "application/vnd.ms-excel");
        systemContenType.put(".xaf", "x-world/x-vrml");
        systemContenType.put(".xla", "application/vnd.ms-excel");
        systemContenType.put(".xls", "application/vnd.ms-excel");
        systemContenType.put(".xof", "x-world/x-vrml");
        systemContenType.put(".xlt", "application/vnd.ms-excel");
        systemContenType.put(".xlc", "application/vnd.ms-excel");
        systemContenType.put(".xsl", "text/xml");
        systemContenType.put(".xbm", "image/x-xbitmap");
        systemContenType.put(".xlw", "application/vnd.ms-excel");
        systemContenType.put(".xpm", "image/x-xpixmap");
        systemContenType.put(".xwd", "image/x-xwindowdump");
        systemContenType.put(".xsd", "text/xml");
        systemContenType.put(".z", "application/x-compress");
        systemContenType.put(".zip", "application/x-zip-compressed");
        systemContenType.put(".*", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        contentType.put(".xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        contentType.put(".xltx", "application/vnd.openxmlformats-officedocument.spreadsheetml.template");
        contentType.put(".potx", "application/vnd.openxmlformats-officedocument.presentationml.template");
        contentType.put(".ppsx", "application/vnd.openxmlformats-officedocument.presentationml.slideshow");
        contentType.put(".pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation");
        contentType.put(".sldx", "application/vnd.openxmlformats-officedocument.presentationml.slide");
        contentType.put(".docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        contentType.put(".dotx", "application/vnd.openxmlformats-officedocument.wordprocessingml.template");
        contentType.put(".xlam", "application/vnd.ms-excel.addin.macroEnabled.12");
        contentType.put(".xlsb", "application/vnd.ms-excel.sheet.binary.macroEnabled.12");
        contentType.put(".apk", AdBaseConstants.MIME_APK);
        contentType.put(".cpt", "application/mac-compactpro");
        contentType.put(".ogg", "application/ogg");
        contentType.put(".mif", "application/vnd.mif");
        contentType.put(".odc", "application/vnd.oasis.opendocument.chart");
        contentType.put(".odb", "application/vnd.oasis.opendocument.database");
        contentType.put(".odf", "application/vnd.oasis.opendocument.formula");
        contentType.put(".odg", "application/vnd.oasis.opendocument.graphics");
        contentType.put(".otg", "application/vnd.oasis.opendocument.graphics-template");
        contentType.put(".odi", "application/vnd.oasis.opendocument.image");
        contentType.put(".odp", "application/vnd.oasis.opendocument.presentation");
        contentType.put(".otp", "application/vnd.oasis.opendocument.presentation-template");
        contentType.put(".ots", "application/vnd.oasis.opendocument.spreadsheet-template");
        contentType.put(".odt", "application/vnd.oasis.opendocument.text");
        contentType.put(".odm", "application/vnd.oasis.opendocument.text-master");
        contentType.put(".ott", "application/vnd.oasis.opendocument.text-template");
        contentType.put(".oth", "application/vnd.oasis.opendocument.text-web");
        contentType.put(".sxw", "application/vnd.sun.xml.writer");
        contentType.put(".stw", "application/vnd.sun.xml.writer.template");
        contentType.put(".sxc", "application/vnd.sun.xml.calc");
        contentType.put(".stc", "application/vnd.sun.xml.calc.template");
        contentType.put(".sxd", "application/vnd.sun.xml.draw");
        contentType.put(".std", "application/vnd.sun.xml.draw.template");
        contentType.put(".sxi", "application/vnd.sun.xml.impress");
        contentType.put(".sti", "application/vnd.sun.xml.impress.template");
        contentType.put(".sxg", "application/vnd.sun.xml.writer.global");
        contentType.put(".sxm", "application/vnd.sun.xml.math");
        contentType.put(".sis", "application/vnd.symbian.install");
        contentType.put(".wbxml", "application/vnd.wap.wbxml");
        contentType.put(".wmlc", "application/vnd.wap.wmlc");
        contentType.put(".wmlsc", "application/vnd.wap.wmlscriptc");
        contentType.put(".torrent", "application/x-bittorrent");
        contentType.put(".bz2", "application/x-bzip2");
        contentType.put(".vcd", "application/x-cdlink");
        contentType.put(".pgn", "application/x-chess-pgn");
        contentType.put(".jar", "application/x-java-archive");
        contentType.put(".jnlp", "application/x-java-jnlp-file");
        contentType.put(".ksp", "application/x-kspread");
        contentType.put(".chrt", "application/x-kchart");
        contentType.put(".kil", "application/x-killustrator");
        contentType.put(".rpm", "application/x-rpm");
        contentType.put(".swf", "application/x-shockwave-flash");
        contentType.put(".ms", "application/x-troff-ms");
        contentType.put(".wma", "audio/x-ms-wma");
        contentType.put(".wax", "audio/x-ms-wax");
        contentType.put(".pdb", "chemical/x-pdb");
        contentType.put(".xyz", "chemical/x-xyz");
        contentType.put(".wbmp", r.l);
        contentType.put(".ras", "image/x-cmu-raster");
        contentType.put(".pnm", "image/x-portable-anymap");
        contentType.put(".pbm", "image/x-portable-bitmap");
        contentType.put(".pgm", "image/x-portable-graymap");
        contentType.put(".ppm", "image/x-portable-pixmap");
        contentType.put(".rgb", "image/x-rgb");
        contentType.put(".xbm", "image/x-xbitmap");
        contentType.put(".xpm", "image/x-xpixmap");
        contentType.put(".xwd", "image/x-xwindowdump");
        contentType.put(".css", "text/css");
        contentType.put(".rtx", "text/richtext");
        contentType.put(".tsv", "text/tab-separated-values");
        contentType.put(".jad", "text/vnd.sun.j2me.app-descriptor");
        contentType.put(".wml", "text/vnd.wap.wml");
        contentType.put(".wmls", "text/vnd.wap.wmlscript");
        contentType.put(".etx", "text/x-setext");
        contentType.put(".mxu", "video/vnd.mpegurl");
        contentType.put(FileTypes.f5245i, "video/x-flv");
        contentType.put(".wm", "video/x-ms-wm");
        contentType.put(".wmv", "video/x-ms-wmv");
        contentType.put(".wmx", "video/x-ms-wmx");
        contentType.put(".wvx", "video/x-ms-wvx");
        contentType.put(FileTypes.H, "video/x-msvideo");
        contentType.put(".movie", "video/x-sgi-movie");
        contentType.put(".ice", "x-conference/x-cooltalk");
        contentType.put(".3gp", "video/3gpp");
        contentType.put(".ai", "application/postscript");
        contentType.put(".aif", "audio/x-aiff");
        contentType.put(".aifc", "audio/x-aiff");
        contentType.put(".aiff", "audio/x-aiff");
        contentType.put(".asc", "text/plain");
        contentType.put(".atom", "application/atom+xml");
        contentType.put(".au", "audio/basic");
        contentType.put(".bin", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        contentType.put(".cdf", "application/x-netcdf");
        contentType.put(".cgm", "image/cgm");
        contentType.put(a.f6446a, OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        contentType.put(".dcr", "application/x-director");
        contentType.put(".dif", "video/x-dv");
        contentType.put(".dir", "application/x-director");
        contentType.put(".djv", "image/vnd.djvu");
        contentType.put(".djvu", "image/vnd.djvu");
        contentType.put(".dll", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        contentType.put(".dmg", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        contentType.put(".dms", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        contentType.put(".dtd", "application/xml-dtd");
        contentType.put(".dv", "video/x-dv");
        contentType.put(".dxr", "application/x-director");
        contentType.put(".eps", "application/postscript");
        contentType.put(".exe", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        contentType.put(".ez", "application/andrew-inset");
        contentType.put(".gram", "application/srgs");
        contentType.put(".grxml", "application/srgs+xml");
        contentType.put(d.b, "application/x-gzip");
        contentType.put(".htm", "text/html");
        contentType.put(".html", "text/html");
        contentType.put(".ico", "image/x-icon");
        contentType.put(".ics", "text/calendar");
        contentType.put(".ifb", "text/calendar");
        contentType.put(".iges", "model/iges");
        contentType.put(".igs", "model/iges");
        contentType.put(".jp2", "image/jp2");
        contentType.put(".jpe", "image/jpeg");
        contentType.put(".jpeg", "image/jpeg");
        contentType.put(FileTypes.F, "image/jpeg");
        contentType.put(".kar", "audio/midi");
        contentType.put(".lha", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        contentType.put(".lzh", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        contentType.put(".m4a", "audio/mp4a-latm");
        contentType.put(".m4p", "audio/mp4a-latm");
        contentType.put(".m4u", "video/vnd.mpegurl");
        contentType.put(".m4v", "video/x-m4v");
        contentType.put(".mac", "image/x-macpaint");
        contentType.put(".mathml", "application/mathml+xml");
        contentType.put(".mesh", "model/mesh");
        contentType.put(FileTypes.f5246j, "audio/midi");
        contentType.put(FileTypes.f5247k, "audio/midi");
        contentType.put(".mp4", "video/mp4");
        contentType.put(FileTypes.w, "video/mpeg");
        contentType.put(FileTypes.x, "video/mpeg");
        contentType.put(".mpga", "audio/mpeg");
        contentType.put(".msh", "model/mesh");
        contentType.put(".nc", "application/x-netcdf");
        contentType.put(".oda", "application/oda");
        contentType.put(".ogv", "video/ogv");
        contentType.put(".pct", "image/pict");
        contentType.put(".pic", "image/pict");
        contentType.put(".pict", "image/pict");
        contentType.put(".pnt", "image/x-macpaint");
        contentType.put(".pntg", "image/x-macpaint");
        contentType.put(FileTypes.v, "application/postscript");
        contentType.put(".qt", "video/quicktime");
        contentType.put(".qti", "image/x-quicktime");
        contentType.put(".qtif", "image/x-quicktime");
        contentType.put(".ram", "audio/x-pn-realaudio");
        contentType.put(".rdf", "application/rdf+xml");
        contentType.put(".rm", "application/vnd.rn-realmedia");
        contentType.put(".roff", "application/x-troff");
        contentType.put(".sgm", "text/sgml");
        contentType.put(".sgml", "text/sgml");
        contentType.put(".silo", "model/mesh");
        contentType.put(".skd", "application/x-koan");
        contentType.put(".skm", "application/x-koan");
        contentType.put(".skp", "application/x-koan");
        contentType.put(".skt", "application/x-koan");
        contentType.put(".smi", "application/smil");
        contentType.put(".smil", "application/smil");
        contentType.put(".snd", "audio/basic");
        contentType.put(".so", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        contentType.put(".svg", "image/svg+xml");
        contentType.put(".t", "application/x-troff");
        contentType.put(".texi", "application/x-texinfo");
        contentType.put(".texinfo", "application/x-texinfo");
        contentType.put(".tif", "image/tiff");
        contentType.put(".tiff", "image/tiff");
        contentType.put(".tr", "application/x-troff");
        contentType.put(CrashHandler.FILE_NAME_SUFFIX, "text/plain");
        contentType.put(".vrml", "model/vrml");
        contentType.put(".vxml", "application/voicexml+xml");
        contentType.put(FileTypes.f5250n, "video/webm");
        contentType.put(".wrl", "model/vrml");
        contentType.put(".xht", "application/xhtml+xml");
        contentType.put(".xhtml", "application/xhtml+xml");
        contentType.put(".xml", "application/xml");
        contentType.put(".xsl", "application/xml");
        contentType.put(".xslt", "application/xslt+xml");
        contentType.put(".xul", "application/vnd.mozilla.xul+xml");
        contentType.put(".webp", "image/webp");
        Properties properties = System.getProperties();
        Properties properties2 = new Properties();
        try {
            properties2.load(Client.class.getClassLoader().getResourceAsStream("project.properties"));
            property = properties2.getProperty("sdk.project.version");
        } catch (IOException e) {
            e.printStackTrace();
            property = "";
        }
        _defaultUserAgent = String.format("AlibabaCloud (%s; %s) Java/%s %s/%s", properties.getProperty("os.name"), properties.getProperty("os.arch"), properties.getProperty("java.runtime.version"), "oss-baseClient", property);
    }

    public static String UriEncode(String str, boolean z) {
        String str2 = "";
        for (char c : str.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || ((c >= 'A' && c <= 'Z') || ((c >= '0' && c <= '9') || charContains(c)))) {
                str2 = str2 + c;
            } else if (c != '/') {
                str2 = str2 + "%" + Integer.toHexString(c);
            } else if (z) {
                str2 = str2 + "%2F";
            } else {
                str2 = str2 + c;
            }
        }
        return str2;
    }

    public static boolean charContains(char c) {
        for (char c2 : characters) {
            if (c == c2) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002d  */
    public static String decode(String str, String str2) {
        byte b;
        if (str2 == null) {
            return str;
        }
        String[] strArrSplit = str.split(WVNativeCallbackUtil.SEPERATER);
        try {
            int iHashCode = str2.hashCode();
            if (iHashCode != -998442947) {
                if (iHashCode == 1206342685 && str2.equals("UrlDecode")) {
                    b = 1;
                } else {
                    b = -1;
                }
            } else if (str2.equals("Base64Decode")) {
                b = 0;
            } else {
                b = -1;
            }
            if (b == 0) {
                strArrSplit[strArrSplit.length - 1] = Base64.getEncoder().encodeToString(strArrSplit[strArrSplit.length - 1].getBytes("UTF-8"));
            } else if (b == 1) {
                strArrSplit[strArrSplit.length - 1] = URLEncoder.encode(strArrSplit[strArrSplit.length - 1], "UTF-8");
            }
            return String.join(WVNativeCallbackUtil.SEPERATER, strArrSplit);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002d  */
    public static String encode(String str, String str2) {
        byte b;
        if (str2 == null) {
            return str;
        }
        String[] strArrSplit = str.split(WVNativeCallbackUtil.SEPERATER);
        try {
            int iHashCode = str2.hashCode();
            if (iHashCode != 1243283525) {
                if (iHashCode == 1982630255 && str2.equals("Base64")) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str2.equals("UrlEncode")) {
                b = 1;
            } else {
                b = -1;
            }
            if (b == 0) {
                strArrSplit[strArrSplit.length - 1] = Base64.getEncoder().encodeToString(strArrSplit[strArrSplit.length - 1].getBytes("UTF-8"));
            } else if (b == 1) {
                strArrSplit[strArrSplit.length - 1] = URLEncoder.encode(strArrSplit[strArrSplit.length - 1], "UTF-8");
            }
            return String.join(WVNativeCallbackUtil.SEPERATER, strArrSplit);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getContentMD5(String str, boolean z) {
        try {
            return Base64.getEncoder().encodeToString(MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getContentType(String str) {
        String strSubstring = str.substring(str.lastIndexOf(Consts.DOT));
        String str2 = systemContenType.get(strSubstring);
        return str2 == null ? contentType.get(strSubstring) : str2;
    }

    public static Map<String, Object> getErrMessage(String str) {
        try {
            Map<String, Object> mapDeserializeXml = XmlUtil.DeserializeXml(str, ErrorResponse.class);
            return mapDeserializeXml.get("Error") == null ? mapDeserializeXml : (Map) mapDeserializeXml.get("Error");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getHost(String str, String str2, String str3, String str4) {
        if (StringUtils.isEmpty((CharSequence) str2)) {
            str2 = "cn-hangzhou";
        }
        if (StringUtils.isEmpty((CharSequence) str3)) {
            str3 = "oss-" + str2 + ".aliyuncs.com";
        }
        if (StringUtils.isEmpty((CharSequence) str)) {
            return str3;
        }
        if (LoginConstants.IP.equals(str4)) {
            return str3 + WVNativeCallbackUtil.SEPERATER + str;
        }
        if ("cname".equals(str4)) {
            return str3;
        }
        return str + Consts.DOT + str3;
    }

    public static String getOssSignature(String str, String str2) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(str.getBytes("UTF-8"), "HmacSHA256"));
            return l72.v(mac.doFinal(str2.getBytes("UTF-8")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getSignature(TeaRequest teaRequest, String str, String str2, String str3, String str4, List<String> list) {
        String[] strArr = list == null ? new String[0] : (String[]) list.toArray(new String[0]);
        if (!"V2".equals(str4.toUpperCase())) {
            return "OSS " + str2 + u15.f19942b + getSignatureV1(teaRequest, str, str3) + "";
        }
        if (ifListEmpty(list)) {
            return "OSS2 AccessKeyId:" + str2 + ",Signature:" + getSignatureV2(teaRequest, str, str3, strArr) + "";
        }
        return "OSS2 AccessKeyId:" + str2 + ",AdditionalHeaders:" + String.join(l.b, list) + ",Signature:" + getSignatureV2(teaRequest, str, str3, strArr) + "";
    }

    public static String getSignatureV1(TeaRequest teaRequest, String str, String str2) {
        String str3 = (StringUtils.isEmpty((CharSequence) str) ? "" : WVNativeCallbackUtil.SEPERATER + str) + teaRequest.pathname;
        if (teaRequest.query != null) {
            List listAsList = Arrays.asList(signKeyList);
            for (Map.Entry<String, String> entry : teaRequest.query.entrySet()) {
                if (listAsList.contains(entry.getKey()) && !StringUtils.isEmpty((CharSequence) entry.getValue())) {
                    str3 = str3 + "&" + entry.getKey() + "=" + entry.getValue();
                }
            }
        }
        return getSignedStrV1(teaRequest, str3, str2);
    }

    public static String getSignatureV2(TeaRequest teaRequest, String str, String str2, String[] strArr) {
        String str3;
        String str4 = teaRequest.pathname;
        if (!StringUtils.isEmpty((CharSequence) str)) {
            str4 = WVNativeCallbackUtil.SEPERATER + str + str4;
        }
        String[] strArr2 = new String[0];
        Map<String, String> map = teaRequest.query;
        if (map != null) {
            strArr2 = (String[]) map.keySet().toArray(new String[0]);
        }
        String[] strArrSplit = str4.split("\\?");
        String str5 = "" + UriEncode(strArrSplit[0], true);
        if (str4.contains("?")) {
            strArr2 = (String[]) Arrays.copyOf(strArr2, strArr2.length + 1);
            strArr2[strArr2.length - 1] = strArrSplit[1];
        }
        Arrays.sort(strArr2);
        if (strArr2.length > 0) {
            str5 = str5 + "?";
        }
        for (String str6 : strArr2) {
            if (StringUtils.isEmpty((CharSequence) teaRequest.query.get(str6))) {
                str3 = str5.endsWith("?") ? str5 + UriEncode(str6, true) : str5 + "&" + UriEncode(str6, true);
            } else if (str5.endsWith("?")) {
                str3 = str5 + UriEncode(str6, true) + "=" + UriEncode(teaRequest.query.get(str6), true);
            } else {
                str3 = str5 + "&" + UriEncode(str6, true) + "=" + UriEncode(teaRequest.query.get(str6), true);
            }
            str5 = str3;
        }
        return getSignedStrV2(teaRequest, str5, str2, strArr);
    }

    public static String getSignedStrV1(TeaRequest teaRequest, String str, String str2) {
        HashMap map = new HashMap();
        for (Map.Entry<String, String> entry : teaRequest.headers.entrySet()) {
            if (entry.getKey().toLowerCase().startsWith(OSSHeaders.OSS_PREFIX) && entry.getValue() != null) {
                map.put(entry.getKey().toLowerCase(), entry.getValue());
            }
        }
        String[] strArr = (String[]) map.keySet().toArray(new String[0]);
        Arrays.sort(strArr);
        StringBuilder sb = new StringBuilder();
        for (String str3 : strArr) {
            sb.append(str3);
            sb.append(u15.f19942b);
            sb.append((String) map.get(str3));
            sb.append("\n");
        }
        String str4 = teaRequest.headers.get("date");
        String str5 = teaRequest.headers.get(e.f);
        if (str5 == null) {
            str5 = "";
        }
        String str6 = teaRequest.headers.get("content-md5");
        try {
            String str7 = teaRequest.method + "\n" + (str6 != null ? str6 : "") + "\n" + str5 + "\n" + str4 + "\n" + sb.toString() + str;
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(str2.getBytes("UTF-8"), "HmacSHA1"));
            return l72.v(mac.doFinal(str7.getBytes("UTF-8")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getSignedStrV2(TeaRequest teaRequest, String str, String str2, String[] strArr) {
        String[] strArr2;
        List listAsList;
        HashMap map = new HashMap();
        if (strArr == null) {
            listAsList = new ArrayList();
            strArr2 = new String[0];
        } else {
            strArr2 = strArr;
            listAsList = Arrays.asList(strArr);
        }
        for (Map.Entry<String, String> entry : teaRequest.headers.entrySet()) {
            if (entry.getValue() != null) {
                if (listAsList.contains(entry.getKey())) {
                    map.put(entry.getKey().toLowerCase(), entry.getValue());
                } else if (entry.getKey().toLowerCase().startsWith(OSSHeaders.OSS_PREFIX)) {
                    map.put(entry.getKey().toLowerCase(), entry.getValue());
                }
            }
        }
        String[] strArr3 = (String[]) map.keySet().toArray(new String[0]);
        Arrays.sort(strArr3);
        String str3 = "";
        for (String str4 : strArr3) {
            str3 = str3 + str4 + u15.f19942b + ((String) map.get(str4)) + "\n";
        }
        String str5 = teaRequest.headers.get("date");
        String str6 = teaRequest.headers.get(e.f);
        String str7 = teaRequest.headers.get("content-md5");
        if (str6 == null) {
            str6 = "";
        }
        return getOssSignature(str2, teaRequest.method + "\n" + (str7 != null ? str7 : "") + "\n" + str6 + "\n" + str5 + "\n" + str3 + String.join(l.b, strArr2) + "\n" + str);
    }

    public static String getUserAgent(String str) {
        if (StringUtils.isEmpty((CharSequence) str)) {
            return _defaultUserAgent;
        }
        return _defaultUserAgent + " " + str;
    }

    public static boolean ifListEmpty(List<String> list) {
        return list == null || list.size() <= 0;
    }

    public static InputStream inject(InputStream inputStream, Map<String, String> map) {
        try {
            return new VerifyInputStream(inputStream, map);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toQuery$0(Map map, String str, Object obj) {
    }

    public static Map<String, String> parseMeta(Map<String, ?> map, String str) {
        HashMap map2 = new HashMap();
        if (map == null) {
            return map2;
        }
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            if (entry.getKey().startsWith(str)) {
                map2.put(entry.getKey().replace(str, ""), String.valueOf(entry.getValue()));
            } else {
                map2.put(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return map2;
    }

    public static Map<String, String> toMeta(Map<String, ?> map, String str) {
        HashMap map2 = new HashMap();
        if (map == null) {
            return map2;
        }
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            if (entry.getKey().contains(str)) {
                map2.put(entry.getKey(), String.valueOf(entry.getValue()));
            } else {
                map2.put(str + entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return map2;
    }

    public static Map<String, String> toQuery(Map<String, Object> map) {
        final HashMap map2 = new HashMap(16);
        if (map != null) {
            map.forEach(new BiConsumer() { // from class: com.zj.adlib.cm1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    Client.lambda$toQuery$0(map2, (String) obj, obj2);
                }
            });
        }
        return map2;
    }
}
