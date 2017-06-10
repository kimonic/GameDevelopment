package kimonik.com.gamedevelopment.base;

import android.os.Bundle;

/**
 * Created by 12348 on 2017/6/10 0010.
 * 控件的相关基础方法
 */

public interface BaseViewFeature {

    /**设置布局资源id*/
    int getLayoutResId();
    /**
     * 设置setcontentview
     */
    void initContentView();

    /**
     * 初始化ui控件方法
     */
    void initView();

    /**
     * 初始化事件监听方法
     */
    void initListener();

    /**
     * 初始化界面加载方法
     */
    void initLoad();
}
