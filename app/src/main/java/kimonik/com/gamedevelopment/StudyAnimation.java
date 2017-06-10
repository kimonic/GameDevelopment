package kimonik.com.gamedevelopment;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/**
 * Created by 12348 on 2017/6/10 0010.
 * animation学习
 */

public class StudyAnimation extends AppCompatActivity {

    public void study(){
        /**
         * 透明度动画
         * 参数1--动画开始时的透明度
         * 参数--动画结束时的透明度
         * 取值范围(0,1]
         */
        Animation animationAlpha=new AlphaAnimation(0,1);
        /**
         * 缩放动画
         * 参数1--动画起始时x坐标上的伸缩比例
         * 参数2--动画结束时x坐标上的伸缩比例
         * 参数3--动画起始时y坐标上的伸缩比例
         * 参数4--动画结束时y坐标上的伸缩比例
         * 参数5--动画在x轴相对于物体的位置类型
         * 参数6--动画相对于物体x坐标的位置
         * 参数7--动画在y轴相对于物体的位置类型
         * 参数8--动画相对于物体y坐标的位置
         * 位置类型有一下三种
         * Animation.ABSOLUTE---相对位置是屏幕左上角,绝对位置
         Animation.RELATIVE_TO_SELF--相对位置是自身view,取值为0时,标识相对于是自身左上角,
         取值为1时是相对于自身的右下角

         Animation.RELATIVE_TO_PARENT---相对父类view的位置
         *
         */

        Animation animationScale=new ScaleAnimation(0.0f,2.0f,1.5f,1.5f,Animation.RELATIVE_TO_PARENT,
                0.5f,Animation.RELATIVE_TO_PARENT,0.0f);
        /**
         * 移动动画
         ** 参数1--动画起始时x坐标上的位置
         * 参数2--动画结束时x坐标上的位置
         * 参数3--动画起始时y坐标上的位置
         * 参数4--动画结束时x坐标上的位置
         */
        Animation animationTranslate=new TranslateAnimation(0,0,20,20);
        /**
         * 旋转动画
         * 参数1--动画起始时的旋转角度
         * 参数2--动画旋转到的角度
         * 参数3--动画在x轴相对于物件位置类型
         * 参数4--动画相对于物体的x坐标的开始位置
         * 参数5--动画在y轴相对于物件位置类型
         * 参数6--动画相对于物体的y坐标的开始位置
         */
        Animation animationRotate=new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);

        /**华府动画的初始化状态*/
        animationRotate.reset();
        /**设置动画的持续时长*/
        animationRotate.setDuration(3000);

        /**view启动动画*/
        View view=new View(this);
        view.startAnimation(animationAlpha);
        /**动画监听*/
        animationAlpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //动画开始时调用
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //动画结束时调用
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //动画重复播放时调用
            }
        });


    }
}
