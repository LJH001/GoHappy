package com.demo.liujian.module.main.view;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.liujian.module.common.base.BaseActivity;
import com.demo.liujian.module.common.net.retrofit.CustomObserver;
import com.demo.liujian.module.common.net.retrofit.HttpThrow;
import com.demo.liujian.module.common.util.LogUtil;
import com.demo.liujian.module.main.R;
import com.demo.liujian.module.main.entity.ProgramEntity;
import com.demo.liujian.module.main.net.MainNetManager;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * descption:项目主页
 * <p>
 * packageName: com.demo.liujian.module.main
 * <p>
 * author:liujianhui
 * <p>
 * date:2018/12/27 15:20
 */
public class IndexActivity extends BaseActivity {
    private static final String TAG = IndexActivity.class.getSimpleName();
    private TextView maincontentTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_index;
    }

    @Override
    protected void initView() {
        maincontentTv = (TextView)findViewById(R.id.main_content_tv);
    }



    @Override
    protected void initEventAndData() {
         MainNetManager.getInstance()
                 .getObtainProgramApi()
                 .getProgramList()
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe( new CustomObserver<ProgramEntity>() {
                     @Override
                     public void onError(HttpThrow httpThrowable) {
                         maincontentTv.setText("throwable   err == "+httpThrowable.errMessage);
                     }

                     @Override
                     public void onResult(ProgramEntity result) {
                         maincontentTv.setText(" programEntity == "+result.getData());
                     }
                 });
    }
}
