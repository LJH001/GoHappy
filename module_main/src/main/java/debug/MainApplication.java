package debug;


import com.demo.liujian.module.common.base.BaseApplication;
import com.demo.liujian.module.common.net.retrofit.NetworkManager;

public class MainApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        NetworkManager.getInstance().init();
    }

}
