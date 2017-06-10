package kimonik.com.gamedevelopment.base;

/**
 * Created by 12348 on 2017/6/10 0010.
 * 基础功能方法
 */

public interface BaseFeature {
    /**初始化数据*/
    void initData();
    /**获取网络数据*/
    String requestData();
    /**解析网络数据*/
    void parseData();

}
