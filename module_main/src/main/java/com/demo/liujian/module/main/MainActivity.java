package com.demo.liujian.module.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.demo.liujian.module.common.util.LogUtil;
import com.demo.liujian.module.common.util.ToastUtil;

/**
  *descption:项目主页
  * <p>
  *packageName: com.demo.liujian.module.main
  * <p>
  *author:liujianhui
  *<p>
  *date:2018/12/27 15:20
*/
public class MainActivity extends AppCompatActivity {
    private TextView contentTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogUtil.e("MainActivity","MainActivity   onCreate =========    ");

        contentTv = (TextView) findViewById(R.id.tv_content);

    }
}
