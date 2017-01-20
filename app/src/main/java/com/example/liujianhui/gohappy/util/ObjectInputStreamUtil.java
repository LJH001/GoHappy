package com.example.liujianhui.gohappy.util;

import android.util.Log;

import com.google.gson.internal.LinkedTreeMap;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * IO流写文件 读取文件
 * Created by Administrator on 2015/11/16.
 */
public class ObjectInputStreamUtil {
    private static final String  TAG = ObjectInputStreamUtil.class.getSimpleName()+">>>";
    /**
     * 写文件
     * @param object 保存对象】、
     * @param path 保存路径
     */
    public static  void writeObject(Object object, String path) {
        try
        {
            FileOutputStream outStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outStream);
            objectOutputStream.writeObject(object);
            outStream.close();
            Log.d(TAG, "writeObject(写文件)==="+path+ ",object"+object.toString());

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
    /**
     * 读取文件
     *
     * @param path 保存路径
     */
    public static Object readObject(String path )
    {
        FileInputStream freader;

        try {

            freader = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(freader);
            Object obj =  objectInputStream.readObject();
            Log.d(TAG, "readObject(读取文件)==="+path+ ",object"+obj.toString());
            return obj;
        }
        catch (FileNotFoundException e)
        {
            Log.d(TAG,e.getMessage()+">>>>>>");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            Log.d(TAG,e.getMessage()+">>>>>>");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            Log.d(TAG,e.getMessage()+">>>>>>");
            e.printStackTrace();

        }
        return null;
    }
    /**
     * 保存集合对象
     *
     * @param list_data List对象
     * @param path 保存路径
     */
    public static boolean saveObject( List<LinkedTreeMap<String, Object>> list_data, String path) {  //保存网络数据
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            FileOutputStream outStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outStream);
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            for(int i=0;i<list_data.size();i++)
            {
                jsonArray.put(list_data.get(i));
            }
            jsonObject.put("cache_datas", jsonArray);
            oos.writeObject(jsonObject);
            oos.writeUTF(jsonObject.toString());
            oos.flush();
            return true;
        }
        catch (Exception e)
        {
            Log.d(TAG,e.getMessage()+">>>>>>");
            e.printStackTrace();
            return false;
        }
        finally
        {
            try
            {
                oos.close();
            }
            catch (Exception e)
            {
                Log.d(TAG,e.getMessage()+">>>>>>");
            }
            try
            {
                fos.close();
            }
            catch (Exception e)
            {
                Log.d(TAG,e.getMessage()+">>>>>>");
            }
        }
    }




}
