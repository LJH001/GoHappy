package com.example.liujianhui.gohappy.util;

/**
   *Description:日志打印类 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/1/18 0018 10:36
 */

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/**
   *Description: 日志记录工具类 可以通过修改是否启用调试模式、日志级别、是否记录日志到文件, 灵活的记录日志。
   *  记录日志到文件需要配置权限：android.permission.WRITE_EXTERNAL_STORAGE<br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/1/18 0018 11:36
 */

public class LogUtil {

    /**
     * 是否启用调试模式, 如果为false不记录任何日志
     */
    private static boolean ADB = true;

    /**
     * 日志级别
     */
    private static int LOG_DEGREE = Log.VERBOSE;

    /**
     * 是否需要记录日志到文件。默认需要输出到日志文件，是否真正的输出到了日志文件，取决于{@link #LOGFILENAME}变量的目录是否存在。
     */
    private static boolean IS_NEED_FILELOG = true;

    /**
     * 日志文件名称绝对路径
     */
    private static String LOGFILENAME = Environment.getExternalStorageDirectory().getPath() + "/gohappy/app_name/log/app_name.log";

    /**
     * 对于sd卡未准备好, 允许缓存的最大日志条数
     */
    private static final int MAX_CACHE_SIZE = 128;

    /**
     * 当前类记录日志的tag
     */
    private static final String TAG = "LogUtil";

    // init config params
    static {

        InputStream is = null;
        try {
            Properties p = new Properties();
            is = LogUtil.class.getResourceAsStream("/assets/gohy.properties");
            p.load(is);

            Log.d(TAG, "load config: " + p.toString());

            ADB = Boolean.parseBoolean(p.getProperty("gohy.log.ADB", "true"));
            LOG_DEGREE = Integer.parseInt(p.getProperty("gohy.log.LOG_DEGREE", "2"));
            String logName = p.getProperty("gohy.log.LOGFILENAME");

            if (!TextUtils.isEmpty(logName)) {
                LOGFILENAME = Environment.getExternalStorageDirectory().getPath() + "/" + logName;
            }

            Log.d(TAG, "ADB = " + ADB);
            Log.d(TAG, "LOG_DEGREE = " + LOG_DEGREE);
            Log.d(TAG, "LOGFILENAME = " + LOGFILENAME);

        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage(), e);
                }
            }
        }

    }

    /**
     * 记录V级别日志 在记录V级别日志时调用, 如果日志配置为不记录日志或日志级别高于V, 不记录日志<br>
     * 默认tag为调用方的类名
     *
     * @param msg 日志信息, 支持动态传参可以是一个或多个(避免日志信息的+操作过早的执行)
     */
    public static void v(String... msg) {
        doV(null, msg);
    }

    /**
     * 记录V级别日志 在记录V级别日志时调用, 如果日志配置为不记录日志或日志级别高于V, 不记录日志
     *
     * @param tag 日志tag
     * @param msg 日志信息, 支持动态传参可以是一个或多个(避免日志信息的+操作过早的执行)
     */
    public static void vt(String tag, String... msg) {
        doV(tag, msg);
    }
    /**
     * 记录V级别日志 在记录V级别日志时调用, 如果日志配置为不记录日志或日志级别高于V, 不记录日志
     *
     * @param tag 日志tag
     * @param msg 日志信息, 支持动态传参可以是一个或多个(避免日志信息的+操作过早的执行)
     */
    private static void doV(String tag, String... msg) {
        if (ADB && LOG_DEGREE <= Log.VERBOSE) {
            String msgStr = combineLogMsg(tag, msg);

            String logTag = tag==null?combineLogTag():tag;

            Log.v(logTag, msgStr);

            writeLogToFile(Log.VERBOSE, tag, msgStr, null);
        }
    }

    /**
     * 记录D级别日志 在记录D级别日志时调用, 如果日志配置为不记录日志或日志级别高于D, 不记录日志<br>
     * 默认tag为调用方的类名
     *
     * @param msg 日志信息, 支持动态传参可以是一个或多个(避免日志信息的+操作过早的执行)
     */
    public static void d(String... msg) {
        doD(null, msg);
    }

    /**
     * 记录D级别日志 在记录D级别日志时调用, 如果日志配置为不记录日志或日志级别高于D, 不记录日志
     *
     * @param tag 日志tag
     * @param msg 日志信息, 支持动态传参可以是一个或多个(避免日志信息的+操作过早的执行)
     */
    public static void dt(String tag, String... msg) {
        doD(tag, msg);
    }

    private static void doD(String tag, String... msg) {
        if (ADB && LOG_DEGREE <= Log.DEBUG) {
            String msgStr = combineLogMsg(tag, msg);

            String logTag = tag==null?combineLogTag():tag;

            Log.d(logTag, msgStr);

            writeLogToFile(Log.DEBUG, tag, msgStr, null);
        }
    }

    /**
     * 记录I级别日志 在记录I级别日志时调用, 如果日志配置为不记录日志或日志级别高于I, 不记录日志<br>
     * 默认tag为调用方的类名
     *
     * @param msg 日志信息, 支持动态传参可以是一个或多个(避免日志信息的+操作过早的执行)
     */
    public static void i(String... msg) {
        doI(null, msg);
    }

    /**
     * 记录I级别日志 在记录I级别日志时调用, 如果日志配置为不记录日志或日志级别高于I, 不记录日志
     *
     * @param tag 日志tag
     * @param msg 日志信息, 支持动态传参可以是一个或多个(避免日志信息的+操作过早的执行)
     */
    public static void it(String tag, String... msg) {
        doI(tag, msg);
    }

    /**
     * 执行I级别日志 在记录I级别日志时调用, 如果日志配置为不记录日志或日志级别高于I, 不记录日志
     *
     * @param tag 日志tag
     * @param msg 日志信息, 支持动态传参可以是一个或多个(避免日志信息的+操作过早的执行)
     */
    private static void doI(String tag, String... msg) {
        if (ADB && LOG_DEGREE <= Log.INFO) {
            String msgStr = combineLogMsg(tag, msg);

            String logTag = tag==null?combineLogTag():tag;

            Log.i(logTag, msgStr);

            writeLogToFile(Log.INFO, tag, msgStr, null);
        }
    }

    /**
     * 记录W级别日志 在记录W级别日志时调用, 如果日志配置为不记录日志或日志级别高于W, 不记录日志<br>
     * 默认tag为调用方的类名
     *
     * @param msg 日志信息, 支持动态传参可以是一个或多个(避免日志信息的+操作过早的执行)
     */
    public static void w(String... msg) {
        doW(null, msg);
    }

    /**
     * 记录W级别日志 在记录W级别日志时调用, 如果日志配置为不记录日志或日志级别高于W, 不记录日志
     *
     * @param tag 日志tag
     * @param msg 日志信息, 支持动态传参可以是一个或多个(避免日志信息的+操作过早的执行)
     */
    public static void wt(String tag, String... msg) {
        doW(tag, msg);
    }

    /**
     * 执行W级别日志 在记录W级别日志时调用, 如果日志配置为不记录日志或日志级别高于W, 不记录日志
     *
     * @param tag 日志tag
     * @param msg 日志信息, 支持动态传参可以是一个或多个(避免日志信息的+操作过早的执行)
     */
    private static void doW(String tag, String... msg) {
        if (ADB && LOG_DEGREE <= Log.WARN) {
            String msgStr = combineLogMsg(tag, msg);

            String logTag = tag==null?combineLogTag():tag;

            Log.w(logTag, msgStr);

            writeLogToFile(Log.WARN, tag, msgStr, null);
        }
    }

    /**
     * 记录E级别日志 在记录E级别日志时调用, 如果日志配置为不记录日志或日志级别高于E, 不记录日志<br>
     * 默认tag为调用方的类名
     *
     * @param msg 日志信息, 支持动态传参可以是一个或多个(避免日志信息的+操作过早的执行)
     */
    public static void e(String... msg) {
        doE(null, null, msg);
    }

    /**
     * 记录E级别日志 在记录E级别日志时调用, 如果日志配置为不记录日志或日志级别高于E, 不记录日志
     *
     * @param tag 日志tag
     * @param msg 日志信息, 支持动态传参可以是一个或多个(避免日志信息的+操作过早的执行)
     */
    public static void et(String tag, String... msg) {
        doE(tag, null, msg);
    }

    /**
     * 记录E级别日志 在记录E级别日志时调用, 如果日志配置为不记录日志或日志级别高于E, 不记录日志<br>
     * 默认tag为调用方的类名
     *
     * @param tr 异常对象
     * @param msg 日志信息, 支持动态传参可以是一个或多个(避免日志信息的+操作过早的执行)
     */
    public static void e(Throwable tr, String... msg) {
        doE(null, tr, msg);
    }

    /**
     * 记录E级别日志 在记录E级别日志时调用, 如果日志配置为不记录日志或日志级别高于E, 不记录日志
     *
     * @param tag 日志tag
     * @param tr 异常对象
     * @param msg 日志信息, 支持动态传参可以是一个或多个(避免日志信息的+操作过早的执行)
     */
    public static void et(String tag, Throwable tr, String... msg) {
        doE(tag, tr, msg);
    }

    private static void doE(String tag, Throwable tr, String... msg){
        if (ADB && LOG_DEGREE <= Log.ERROR) {
            String msgStr = combineLogMsg(tag, msg);

            String logTag = tag==null?combineLogTag():tag;

            Log.e(logTag, msgStr, tr);

            writeLogToFile(Log.ERROR, tag, msgStr, tr);

        }
    }

    private static StackTraceElement getStackTraceElement(){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        //这个值是根据堆栈的调用结构而定的，如果改了调用的深度则这个值就需要重新算一下
        int index = 6;
        return stackTrace[index];
    }

    /**
     * 获取当前调用的类名为日志的tag
     *
     * @return
     */
    private static String combineLogTag() {
        StackTraceElement stack = getStackTraceElement();
        String className = stack.getFileName();
        if(className == null){
            className = stack.getClassName();
        }
        return className;
    }

    /**
     * 组装动态传参的字符串 将动态参数的字符串拼接成一个字符串
     *
     * @param msg 动态参数
     * @return 拼接后的字符串
     */
    private static String combineLogMsg(String tag, String... msg) {

        StackTraceElement stack = getStackTraceElement();

        String methodName = stack.getMethodName();
        int lineNumber = stack.getLineNumber();

        StringBuilder sb = new StringBuilder();
        sb.append("[ (");

        String className = stack.getFileName();
        if(className == null){
            className = stack.getClassName();
        }
        sb.append(className).append(":");

        sb.append(lineNumber).append(")#").append(methodName).append(" ] ");

        if(msg != null){
            for (String s : msg) {
                sb.append(s);
            }
        } else {
            sb.append("Log with null Object");
        }

        return sb.toString();
    }

    /**
     * 锁对象, 在同步模块中使用
     */
    private static final Object lock = new Object();

    /**
     * 待记录到文件的日志队列, 需要支持同步
     */
    private static Queue<String> Logs = new ConcurrentLinkedQueue<String>();

    /**
     * 日志级别与其对应的字符标签
     */
    private static SparseArray<String> degreeLabel = new SparseArray<String>();

    /**
     * 初始化日志级别与其对应的字符标签
     */
    static {
        degreeLabel.put(Log.VERBOSE, "V");
        degreeLabel.put(Log.DEBUG, "D");
        degreeLabel.put(Log.INFO, "I");
        degreeLabel.put(Log.WARN, "W");
        degreeLabel.put(Log.ERROR, "E");
    }

    /**
     * 记录日志到文件 如果配置成需要记录日志到文件, 需要将日志数据拼接成一条日志记录, 首先放入到待记录的日志队列中, 再由异步线程记录到文件中。 日志格式定义为：yyyy-MM-dd HH:mm:ss.SSS, <D>degree, <T>tag, <M>message, <E>exception info
     *
     * @param degree 日志级别
     * @param tag 日志标签
     * @param msg 日志信息
     * @param tr 异常
     */
    private static void writeLogToFile(int degree, String tag, String msg, Throwable tr) {
        if (IS_NEED_FILELOG) {

            StringBuffer sb = new StringBuffer();

            // 拼接时间、日志级别、标签、信息
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
            sb.append(df.format(Calendar.getInstance().getTime())).append(", <D>").append(degreeLabel.get(degree)).append(", <T>").append(tag).append(", <M>").append(msg);

            // 如果有异常信息, 需要拼接异常信息, 拼接所有的堆栈信息
            if (null != tr) {
                // StackTraceElement[] stacks = tr.getStackTrace();
                // if (null != stacks) {
                // sb.append(", <E>").append(tr.getMessage()).append("\r\n");
                // for (int i = 0; i < stacks.length; i++) {
                // sb.append("\t\tat ").append(stacks[i].getClassName()).append(".").append(stacks[i].getMethodName()).append("(").append(stacks[i].getClassName())
                // .append(".java").append(" ").append(stacks[i].getLineNumber()).append(")").append("\r\n");
                // }
                // }

                sb.append(", <E>").append(Log.getStackTraceString(tr));
            }

            // 将日志信息增加到队列中
            Logs.add(sb.toString());

            synchronized (LogUtil.class) {
                // 如果日志线程没有初始化, 需要初始化并启动
                if (null == logThread) {
                    logThread = new LogThread();
                    logThread.start();
                } else {
                    // 通知日志线程写文件
                    synchronized (lock) {
                        if (Logs.size() > 0) {
                            lock.notify();
                        }
                    }
                }
            }

            // TODO 线程如何终止, 资源如何回收
        }
    }

    /**
     * 日志文件的输出流对象
     */
    private static BufferedWriter bw;

    /**
     * 日志线程对象
     */
    private static LogThread logThread = null;

    /**
     * 日志线程类 用于记录日志到文件的线程类
     *
     */
    private static class LogThread extends Thread {

        /**
         * 线程是否运行的标识位, 在start线程时置为true, 在终止线程(halt方法)时置为false
         */
        boolean isRunning = false;

        @Override
        public synchronized void start() {
            isRunning = true;

            // 启动日志线程时初始化文件输出流
            initWriter();

            super.start();
        }

        @Override
        public void run() {
            while (isRunning) {
                String log = null;

                if (null == bw) {
                    initWriter();
                }
                // writer初始化好了才记录日志
                else {

                    // 循环从日志队列中取出日志, 记录到文件中
                    while (null != (log = Logs.poll())) {

                        try {
                            bw.write(log);
                            bw.write("\r\n");
                            bw.flush();
                        } catch (IOException e) {
                            Log.e(TAG, e.getMessage(), e);

                            // 如果发生异常, 可能是sd卡不可用, 并尝试重新初始化输出流
                            initWriter();

                        }

                    }
                }

                // 处理完所有队列中的日志后, wait, 在有日志进入队列时被唤醒
                synchronized (lock) {
                    try {
                        if (Logs.size() == 0) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        Log.e(TAG, e.getMessage(), e);
                    }
                }

            }
        }

        /**
         * 终止线程时调用 用于终止线程, 将运行状态置为false
         *
         */
        @SuppressWarnings("unused")
        public synchronized void halt() {
            isRunning = false;
        }

    }

    /**
     * 初始化文件输出流对象 如果文件输出流已经初始化过, 需要先关闭输出流, 再创建新的输出流对象; 否则直接创建
     *
     */
    private synchronized static void initWriter() {

        // 只缓存允许的日志数目
        if (Logs.size() > MAX_CACHE_SIZE) {
            Logs.clear();
        }

        // 如果输出流初始化过, 需要先关闭输出流, 释放资源
        if (bw != null) {
            try {
                bw.close();
                bw = null;
            } catch (IOException e) {
                Log.e(TAG, e.getMessage(), e);
            }
        }

        try {

            @SuppressWarnings("unused")
            boolean mExternalStorageAvailable = false;
            boolean mExternalStorageWriteable = false;
            String state = Environment.getExternalStorageState();

            if (Environment.MEDIA_MOUNTED.equals(state)) {
                // We can read and write the media
                mExternalStorageAvailable = mExternalStorageWriteable = true;
            } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
                // We can only read the media
                mExternalStorageAvailable = true;
                mExternalStorageWriteable = false;
            } else {
                // Something else is wrong. It may be one of many other states,
                // but all we need
                // to know is we can neither read nor write
                mExternalStorageAvailable = mExternalStorageWriteable = false;
            }

            if (mExternalStorageWriteable) {

                File dir = new File(LOGFILENAME.substring(0, LOGFILENAME.lastIndexOf("/")));
                if (!dir.exists()) {
                    //发布时屏蔽
                    dir.mkdirs();
                    IS_NEED_FILELOG = true;
                    //     Logs.clear();
                    //     return;
                }

                // 创建文件输出流
                bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(LOGFILENAME, true), "UTF-8"));
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }
}
