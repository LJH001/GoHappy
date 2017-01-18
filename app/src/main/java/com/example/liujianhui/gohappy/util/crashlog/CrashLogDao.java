
package com.example.liujianhui.gohappy.util.crashlog;

import android.content.Context;
import android.content.SharedPreferences;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.liujianhui.gohappy.util.LogUtil;

import java.util.ArrayList;

/**
   *Description:存储崩溃日志的Dao<br>
  * 提供对崩溃日志的增、删、查的操作 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/1/18 0018 17:03
 */

class CrashLogDao {

    private static final String SP_NAME = "sp_crashlog";

    private static final String SP_KEY_CONTENT = "sp_key_content";
    
    /**
     * 判断是否有崩溃日志
     * 
     * @param ctx
     * @return true-存在，false-不存在
     */
    public boolean hasCrashLog(Context ctx){
        String crashLog = ctx.getSharedPreferences(SP_NAME, 0).getString(SP_KEY_CONTENT, null);
        return crashLog != null;
    }
    
    
    /**
     * 将崩溃日志插入到SharedPreferences中
     * 
     * @param entity 存储的日志实体
     * @param ctx 上下文对象
     * @return true-存储成功，false-存储失败
     */
    public boolean insert(CrashLog entity, Context ctx) {
        if (entity == null || ctx == null) {
            LogUtil.e("存储异常日志失败，传递的参数不能为null");
            return false;
        }

        SharedPreferences sp = ctx.getSharedPreferences(SP_NAME, 0);
        String oldContent = sp.getString(SP_KEY_CONTENT, null);

        //判断当前存储的日志是否超过最大数量
        ArrayList<CrashLog> crashLogs = new ArrayList<CrashLog>();
        if (oldContent != null) {
            crashLogs = JSON.parseObject(oldContent, new TypeReference<ArrayList<CrashLog>>(){});
            int max = CrashLogManager.getInstance().getMaxCrashLogSize();
            if (crashLogs.size() >= max) {
                int removeLen = crashLogs.size() - max + 1;
                for (int i = 0; i < removeLen; i++) {
                    crashLogs.remove(0);
                }
            }
        }
        
        //存储日志
        crashLogs.add(entity);
        String crashLogsStr = JSON.toJSONString(crashLogs);
        sp.edit().putString(SP_KEY_CONTENT, crashLogsStr).commit();
        return true;
    }

    /**
     * 从SharedPreferences存储中获取崩溃日志数组
     * 
     * @param ctx 上下文对象
     * @return 返回存储的日志列表，如果没有则返回null
     */
    public CrashLog[] getCrashLogList(Context ctx) {
        SharedPreferences sp = ctx.getSharedPreferences(SP_NAME, 0);
        String crashLogsStr = sp.getString(SP_KEY_CONTENT, null);
        if (crashLogsStr != null) {
            ArrayList<CrashLog> crashLogs = JSON.parseObject(crashLogsStr, new TypeReference<ArrayList<CrashLog>>(){});
            return crashLogs.toArray(new CrashLog[crashLogs.size()]);
        }
        return null;
    }

    /**
     * 清空崩溃日志
     * 
     * @param ctx 上下文对象
     */
    public void clearCrashLog(Context ctx) {
        ctx.getSharedPreferences(SP_NAME, 0).edit().clear().commit();
    }

}
