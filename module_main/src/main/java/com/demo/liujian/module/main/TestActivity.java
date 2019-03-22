package com.demo.liujian.module.main;

import android.os.Bundle;
import android.widget.TextView;

import com.demo.liujian.module.common.base.BaseActivity;
import com.demo.liujian.module.common.net.HttpHelper;
import com.demo.liujian.module.common.net.ICallback;
import com.demo.liujian.module.common.net.OkGoProcess;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class TestActivity extends BaseActivity {

    @InjectView(R.id.tv_news)
    TextView tvNews;


    /**
     * 获取数据
     */
    private void obtainData() {
        String url = "http://v.juhe.cn/toutiao/index";

        Map<String,String> map = new HashMap<>();
        map.put("type", "top");
        map.put("key", "dc22f2ee5be360ecd9618570bfd018b3");
         HttpHelper.getInstance().post(url,map,new ICallback<NewsEntity>() {

            @Override
            public void onSuccess(NewsEntity response) {
                tvNews.setText("请求成功数据：  "+response.getResult().getStat());
            }

            @Override
            public void onError(Throwable errorMsg) {
                tvNews.setText("请求成功数据：  "+errorMsg.getMessage());
            }
        });

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_test;
    }

    @Override
    protected void initView() {
        obtainData();
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OkGo.getInstance().cancelTag(this);
    }
}
