package com.aliyun.svideosdk.common.struct.project;

import android.util.Log;
import com.aliyun.common.b.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ProjectUtil {
    public static JSONObject getJson(File file) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        if (file == null || !file.exists()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                } catch (Exception unused) {
                    if (bufferedReader == null) {
                        return null;
                    }
                    try {
                        bufferedReader.close();
                        return null;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            JSONObject jSONObject = new JSONObject(sb.toString());
            try {
                bufferedReader.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            return jSONObject;
        } catch (Exception unused2) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static AliyunEditorProject newProject(File file) {
        String name = file.getName();
        AliyunEditorProject aliyunEditorProject = new AliyunEditorProject();
        aliyunEditorProject.setProjectDir(file, AliyunEditorProject.getProjectFile(file));
        aliyunEditorProject.setTitle(name);
        aliyunEditorProject.setCreationTime(AliyunEditorProject.DATE_FORMAT.format(new Date()));
        aliyunEditorProject.setModifiedTime(aliyunEditorProject.getCreationTime());
        return aliyunEditorProject;
    }

    public static File newProjectDir(String str) {
        File file = new File(str, String.valueOf(System.currentTimeMillis()));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static AliyunEditorProject read(String str, a aVar) {
        try {
            return (AliyunEditorProject) aVar.readValue(str, AliyunEditorProject.class);
        } catch (Throwable th) {
            Log.v("Project", "error unmarshalling project", th);
            return null;
        }
    }

    public static AliyunEditorProject readProject(File file, a aVar) {
        AliyunEditorProject project;
        try {
            JSONObject json = getJson(file);
            if (json != null && json.has("mLayoutVersion")) {
                project = ProjectVersionUtil.readProject(file, json);
            } else {
                if (json.optInt("Version", 1) > 1) {
                    return null;
                }
                project = (AliyunEditorProject) aVar.readValue(file, AliyunEditorProject.class);
            }
            project.setProjectDir(file.getParentFile(), file);
            return project;
        } catch (Throwable th) {
            Log.e("Project", "error unmarshalling project", th);
            return null;
        }
    }

    public static String writeProject(AliyunEditorProject aliyunEditorProject, a aVar) {
        try {
            return aVar.writeValue(aliyunEditorProject);
        } catch (Throwable th) {
            Log.v("Project", "error marshalling project", th);
            return null;
        }
    }

    public static boolean writeProject(AliyunEditorProject aliyunEditorProject, File file, a aVar) {
        return writeProject(aliyunEditorProject, file, aVar, true);
    }

    public static boolean writeProject(AliyunEditorProject aliyunEditorProject, File file, a aVar, boolean z) {
        if (z) {
            try {
                aliyunEditorProject.setModifiedTime(AliyunEditorProject.DATE_FORMAT.format(new Date()));
            } catch (Throwable th) {
                Log.w("Project", "error marshalling project", th);
                return false;
            }
        }
        aVar.writeValue(file, aliyunEditorProject);
        return true;
    }
}
