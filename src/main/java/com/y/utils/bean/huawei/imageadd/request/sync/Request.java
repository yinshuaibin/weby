package com.y.utils.bean.huawei.imageadd.request.sync;

import com.y.utils.bean.huawei.imageadd.request.Peoples;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author yinshuaibin
 * @date 2020/6/15 10:47
 */
@XmlRootElement
public class Request {

    /**
     * M
     * 静态库id
     * 该参数为path请求参数
     */
    private String libraryid;

    /**
     * O
     * 用来指明黑名单添加的结果是否同步通知：
     * true：同步调用
     * false：异步调用（默认）
     */
    private String sync;

    /**
     * O
     *用于订阅特征提取的结果，当系统提取特征完成或特征提取失败时，主动通知到订阅者。不订阅则不通知。
     */
    private String callbackURL;

    /**
     * M
     * 人员信息
     * 在同步调用时最大规格为10张且不能大于15M，单次请求中携带的图片越多则系统处理的是时间越长。
     * 在异步调用场景下，单次可以提交500张且总大小不能大于15M。添加名单的最终执行结果可通过callbackurl通知。
     */
    private Peoples peoples;

    public String getLibraryid() {
        return libraryid;
    }

    public void setLibraryid(String libraryid) {
        this.libraryid = libraryid;
    }

    public String getSync() {
        return sync;
    }

    public void setSync(String sync) {
        this.sync = sync;
    }

    public String getCallbackURL() {
        return callbackURL;
    }

    public void setCallbackURL(String callbackURL) {
        this.callbackURL = callbackURL;
    }

    public Peoples getPeoples() {
        return peoples;
    }

    public void setPeoples(Peoples peoples) {
        this.peoples = peoples;
    }

    @Override
    public String toString() {
        return "Request{" +
                "libraryid='" + libraryid + '\'' +
                ", sync='" + sync + '\'' +
                ", callbackURL='" + callbackURL + '\'' +
                ", peoples=" + peoples +
                '}';
    }
}
