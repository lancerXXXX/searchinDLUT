package Util;

public class PaginationUtil {

    //数据总数
    private int totalCount;
    //每页数据数
    private int countPerPage;

    /**
     * 获取总页数
     *
     * @return
     */
    public int getPageCount() {
        return totalCount % countPerPage == 0 ? totalCount / countPerPage : totalCount / countPerPage + 1;
    }

    /**
     * 获取PageStart
     * @param currentPage
     * @return
     */
    public int getCurrentPageStart(int currentPage){
        if (currentPage < 1 || currentPage > getTotalCount()){
        }
        return (currentPage-1)*countPerPage;
    }

    /**
     * 获取PageEnd
     * @param currentPage
     * @return
     */
   public int getCurrentPageEnd(int currentPage){
        if (currentPage<1||currentPage>getTotalCount()){
        }
        return getCurrentPageStart(currentPage)+countPerPage>totalCount?totalCount:getCurrentPageStart(currentPage)+countPerPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCountPerPage() {
        return countPerPage;
    }

    public void setCountPerPage(int countPerPage) {
        this.countPerPage = countPerPage;
    }
}
