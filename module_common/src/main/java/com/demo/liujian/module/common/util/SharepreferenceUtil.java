package com.demo.liujian.module.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;

import com.demo.liujian.module.common.base.BaseApplication;
import com.demo.liujian.module.common.contants.AppConstant;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
   *Description:保存 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/3/8 0008 18:01
 */
public class SharepreferenceUtil {
    private static final boolean DEFAULT_NIGHT_MODE = false;

    public static SharedPreferences getAppSp() {
        return BaseApplication.getInstance().getSharedPreferences(AppConstant.KEY_SPF, Context.MODE_PRIVATE);
    }

    private static SharedPreferences sp;

    public SharepreferenceUtil() {
    }

    private static SharedPreferences getSp(Context context) {
        if (sp == null) {
            Class var1 = SharepreferenceUtil.class;
            synchronized(SharepreferenceUtil.class) {
                if (sp == null) {
                    sp = context.getSharedPreferences("SpUtil", 0);
                }
            }
        }

        return sp;
    }

    public static void putString(Context context, String key, String value) {
        SharedPreferences preferences = getSp(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getString(Context context, String key) {
        SharedPreferences preferences = getSp(context);
        return preferences.getString(key, "");
    }

    public static String getString(Context context, String key, String value) {
        SharedPreferences preferences = getSp(context);
        return preferences.getString(key, value);
    }

    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences sp = getSp(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        SharedPreferences sp = getSp(context);
        return sp.getBoolean(key, defValue);
    }

    public static void putLong(Context context, String key, long value) {
        SharedPreferences sp = getSp(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    public static long getLong(Context context, String key, long defValue) {
        SharedPreferences sp = getSp(context);
        return sp.getLong(key, defValue);
    }

    public static void putInt(Context context, String key, int value) {
        SharedPreferences sp = getSp(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static int getInt(Context context, String key, int defValue) {
        SharedPreferences sp = getSp(context);
        return sp.getInt(key, defValue);
    }

    public static <T extends Serializable> void putObject(Context context, String key, T obj) {
        try {
            put(context, key, obj);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public static <T extends Serializable> T getObject(Context context, String key) {
        try {
            return (T) get(context, key);
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static void putList(Context context, String key, List<? extends Serializable> list) {
        try {
            put(context, key, list);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public static <E extends Serializable> List<E> getList(Context context, String key) {
        try {
            return (List)get(context, key);
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static <K extends Serializable, V extends Serializable> void putMap(Context context, String key, Map<K, V> map) {
        try {
            put(context, key, map);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public static <K extends Serializable, V extends Serializable> Map<K, V> getMap(Context context, String key) {
        try {
            return (Map)get(context, key);
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    private static void put(Context context, String key, Object obj) throws IOException {
        if (obj != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = null;
            oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            String objectStr = new String(Base64.encode(baos.toByteArray(), 0));
            baos.close();
            oos.close();
            putString(context, key, objectStr);
        }
    }

    private static Object get(Context context, String key) throws IOException, ClassNotFoundException {
        String wordBase64 = getString(context, key);
        if (TextUtils.isEmpty(wordBase64)) {
            return null;
        } else {
            byte[] objBytes = Base64.decode(wordBase64.getBytes(), 0);
            ByteArrayInputStream bais = new ByteArrayInputStream(objBytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            Object obj = ois.readObject();
            bais.close();
            ois.close();
            return obj;
        }
    }
}
