package kimonik.com.gamedevelopment;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import kimonik.com.gamedevelopment.base.BaseActivity;

public class GuideActivity extends BaseActivity {

    static {
        System.loadLibrary("native-lib");
    }

    @BindView(R.id.sample_text)
    TextView tv;


    @Override
    public int getLayoutResId() {
        return R.layout.act_guide;
    }



    @Override
    public void onClick(View v) {

    }

    @Override
    public void initData() {

    }

    @Override
    public String requestData() {
        return null;
    }

    @Override
    public void parseData() {

    }

    @Override
    public void initView() {
        tv.setText(stringFromJNI());
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initLoad() {

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
