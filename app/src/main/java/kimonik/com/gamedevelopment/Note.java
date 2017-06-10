package kimonik.com.gamedevelopment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 12348 on 2017/6/10 0010.
 * bitmap学习
 *
 */

public class Note extends AppCompatActivity{
    /**bitmap类简介*/
    /**画布*/
    Canvas canvas=new Canvas();
    Paint paint=new Paint();
    /**位图的宽和高*/
    private int bitmapWidth,bitmapHeight;
    /**参数1--资源实例,参数2---资源id*/
    Bitmap bitmap= BitmapFactory.decodeResource(this.getResources(),R.drawable.yu01);
    public void test(){
        bitmapWidth=bitmap.getWidth();
        bitmapHeight=bitmap.getHeight();


        /**第一个参数--bitmap对象,第二三个参数--位图的xy坐标,默认为位图左上角的坐标,
         * 第四个参数---- 画笔实例
         */
        canvas.drawBitmap(bitmap,0,0,paint);
        /**位图旋转*/
        /**第一个参数--画布旋转的角度,大于零--顺时针旋转,小于零---逆时针旋转
         * 第二个,第三个参数---画布旋转的参照点
         * 该函数是对整个画布进行旋转,即画布上所有绘制的元素都会因画布的旋转而进行相应的旋转
         * */
        canvas.rotate(30,bitmap.getWidth()/2,bitmap.getHeight()/2);
        canvas.drawBitmap(bitmap,0,0,paint);

        /**保存当前画布的状态,save函数出现的次数不能大于restore函数的出现次数*/
        canvas.save();
        /**恢复上次保存的画布状态*/
        canvas.restore();
        /**使用矩阵类对位图进行旋转*/
        Matrix matrix=new Matrix();
        /**参数--旋转角度,旋转参照点x坐标,旋转参照点y坐标*/
        matrix.preRotate(30,bitmap.getWidth()/2,bitmap.getHeight()/2);
        canvas.drawBitmap(bitmap,matrix,paint);
        /**平移位图*
         * 参数1---x轴平移画布的距离,大于零正方向
         * 参数2---y轴平移画布的距离,小于零负方向
         */
        canvas.translate(10,10);
        canvas.drawBitmap(bitmap,0,0,paint);

        /**利用矩阵平移位图
         * * 参数1---x轴平移画布的距离,大于零正方向
         * 参数2---y轴平移画布的距离,小于零负方向
         * */
        matrix.postTranslate(10,10);
        canvas.drawBitmap(bitmap,matrix,paint);
        /**绘制位图都是默认从位图的左上角开始绘制
         * 位图的绘制点其实坐标加上位图的宽和高的一半,即为位图的中心点
         * */
        /**
         * 缩放位图
         * 对画布进行缩放
         * 第一个参数-对画布x轴的缩放比例,大于1时表示放大
         * 第二个参数-对画布y轴的缩放比例,(0,1)时表示缩小,1时表示不变
         * 第三四个参数,对画布缩放的起始点
         */
        canvas.scale(2f,2f,50+bitmapWidth/2,50+bitmapHeight/2);
        canvas.drawBitmap(bitmap,50,50,paint);

        /**利用矩阵对位图进行缩放
         * 第一个参数-对x轴的缩放比例,大于1时表示放大
         * 第二个参数-对y轴的缩放比例,(0,1)时表示缩小,1时表示不变
         * 小于零时是对镜像后的位图进行缩放,小于-1是对镜像后放大,反之
         * 第三四个参数,对画布缩放的起始点
         *
         * 使用矩阵时的默认绘制点是(0,0),必须使用移动配合对位图进行相应操作
         */
        matrix.postScale(1,-1,bitmapWidth,bitmapHeight);
        canvas.drawBitmap(bitmap,matrix,paint);
        /**
         * .png图片支持透明度
         * .jpg图片不支持透明度
         */
        /**裁剪画布
         * 参数一二---左上角坐标
         * 参数三四--右下角坐标
         * 画布裁剪后除裁剪可视区域外,其他区域都不可见
         */
        canvas.clipRect(0,0,20,20);
        /**使用path进行裁剪*/
        Path path=new Path();
        path.addCircle(50,50,50, Path.Direction.CCW);
        canvas.clipPath(path);
        /**弃用方法,知道即可*/
        canvas.clipRegion(new Region());



    }
}





















