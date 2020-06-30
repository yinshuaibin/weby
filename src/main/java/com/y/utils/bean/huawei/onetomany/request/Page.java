package com.y.utils.bean.huawei.onetomany.request;

/**
 * @author yinshuaibin
 * @date 2020/6/12 10:58
 */
public class Page {

    /**
     * M
     * 单次查询页码编号
     * 为正整数。
     */
    private String no;

    /**
     * M
     * 单页内显示记录数
     * 取值范围[1,1000]
     * 分页查询总数，即no*size不能大于10000
     */
    private String size;


    /**
     * M
     * 排序方式
     * asc（升序），desc（降序）
     */
    private String sort;

    /**
     * M
     * 按指定字段进行排序，支持的字段为name、time、similarity，name表示名称排序，字符串排序，time表示按照创建时间排序，similarity表示按相似度排序，数字排序。
     * 当前结构化检索只支持name、time排序，以图搜图检索只支持similarity排序。
     */
    private String orderName;

    public Page(String no, String size, String sort, String orderName) {
        this.no = no;
        this.size = size;
        this.sort = sort;
        this.orderName = orderName;
    }

    public Page(){

    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public String toString() {
        return "Page{" +
                "no='" + no + '\'' +
                ", size='" + size + '\'' +
                ", sort='" + sort + '\'' +
                ", orderName='" + orderName + '\'' +
                '}';
    }
}
