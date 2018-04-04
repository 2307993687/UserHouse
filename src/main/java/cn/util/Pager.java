package cn.util;
import java.util.List;

/**
 *
 * 公共分页
 *
 */
public class Pager<T> {
    private int pargerIndex;//当前页数
    private int pargerSize;//每页条数
    private int pargerSum;//总共多少页
    private int pargerCount;//总条数
    private List<T> List;

    public int getPargerIndex() {
        return pargerIndex;
    }

    public void setPargerIndex(int pargerIndex) {
        this.pargerIndex = pargerIndex;
    }

    public int getPargerSize() {
        return pargerSize;
    }

    public void setPargerSize(int pargerSize) {
        this.pargerSize = pargerSize;
    }

    public int getPargerSum() {
        return pargerSum;
    }

    public void setPargerSum(int pargerSum) {
        this.pargerSum = pargerSum;
    }

    public int getPargerCount() {
        return pargerCount;
    }

    public void setPargerCount(int pargerCount) {
        this.pargerCount = pargerCount;
    }

    public java.util.List<T> getList() {
        return List;
    }

    public void setList(java.util.List<T> list) {
        List = list;
    }
}
