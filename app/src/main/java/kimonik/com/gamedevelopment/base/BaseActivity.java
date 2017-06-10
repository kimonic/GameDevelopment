package kimonik.com.gamedevelopment.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 12348 on 2017/6/10 0010.
 * activity 基类
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseFeature, BaseViewFeature ,View.OnClickListener{

    /**布局文件资源id*/
    private int resId;
    private Unbinder unbind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.resId=getLayoutResId();
        initContentView();
        initData();
        initView();
        initListener();
        initLoad();
    }

    @Override
    public abstract int getLayoutResId();


    @Override
    public void initContentView() {
        setContentView(resId);
        unbind= ButterKnife.bind(this);
    }


    /**启动下一个activity*/
    protected void openActivity(Class<? extends BaseActivity> toActivity) {
        openActivity(toActivity, null);
    }

    /**启动下一个activity*/
    protected void openActivity(Class<? extends BaseActivity> toActivity, Bundle parameter) {
        Intent intent = new Intent(this, toActivity);
        if (parameter != null) {
            intent.putExtras(parameter);
        }
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        unbind.unbind();
        super.onDestroy();
    }
}
