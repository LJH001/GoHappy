package com.demo.liujian.module.common.net;

import android.telecom.Call;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * 类名：com.lxg.http
 * 时间：2018/1/30 14:45
 * 描述：将返回过来的json字符串转换为实体类
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author Liu_xg
 */

//public abstract class JsonCallback<T> extends Call.Callback<T> {
//    private Type mType;
//    private Class<T> clazz;
//
//    public JsonCallback() {
//    }
//
//    public JsonCallback(Type type) {
//        mType = type;
//    }
//
//    public JsonCallback(Class<T> clazz) {
//        this.clazz = clazz;
//    }
//
//    @Override
//    public T convertResponse(Response response) throws Throwable {
//
//        ResponseBody body = response.body();
//        if (body == null) {
//            return null;
//        }
//        T data = null;
//        Gson gson = new Gson();
//        String str = response.body().string();
//        if (mType != null) {
//            data = gson.fromJson(str, mType);
//        }
//
//        clazz = anlysisObject(this);
//        if (clazz != null) {
//            data = gson.fromJson(str, clazz);
//        }
//        return data;
//    }
//
//
//    /**
//     *
//     * @param object
//     * @return
//     */
//    private static Class anlysisObject(Object object) {
//        Type type = object.getClass().getGenericSuperclass();
//        Type[] params = ((ParameterizedType)type).getActualTypeArguments();
//        return (Class) params[0];
//    }
//}
