package com.template.common.utils;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.template.common.req.PageReq;
import com.template.common.vo.PageVO;

import java.util.Collections;

public class PageUtil {
    public static <T> Page<T> createPage(PageReq req) {
        return createPage(req, true);
    }

    public static <T> Page<T> createPage(PageReq req, boolean searchCount) {
        Page<T> page = Page.of(req.getCurrentPage(), req.getPageSize(), searchCount);
        if (StringUtils.isNotBlank(req.getOrderBy()) && req.getAsc() != null) {
            OrderItem orderItem = new OrderItem();
            orderItem.setColumn(PageUtil.humpToUnderline(req.getOrderBy()));
            orderItem.setAsc(req.getAsc());
            page.setOrders(Collections.singletonList(orderItem));
        }
        return page;
    }

    public static <V, E> PageVO<V> createPageVO(Page<E> pageEntity) {
        PageVO<V> pageVO = new PageVO<>();
        pageVO.setCurrentPage(pageEntity.getCurrent());
        pageVO.setTotal(pageEntity.getTotal());
        pageVO.setPageSize(pageEntity.getSize());
        pageVO.setTotalPage(pageEntity.getTotal() % pageEntity.getSize() == 0 ?
                pageEntity.getTotal() / pageEntity.getSize() : pageEntity.getTotal() / pageEntity.getSize() + 1);
        return pageVO;
    }

    /**
     * 驼峰转下划线
     * userName ----> user_name
     * user_name ----> user_name
     *
     * @param humpName 驼峰命名
     * @return 带下滑线的String
     */
    public static String humpToUnderline(String humpName) {
        //截取下划线分成数组，
        char[] charArray = humpName.toCharArray();
        StringBuilder buffer = new StringBuilder();
        //处理字符串
        for (int i = 0, l = charArray.length; i < l; i++) {
            if (charArray[i] >= 65 && charArray[i] <= 90) {
                buffer.append("_").append(charArray[i] += 32);
            } else {
                buffer.append(charArray[i]);
            }
        }
        return buffer.toString();
    }

}
