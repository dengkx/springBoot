package com.kylink.service;


import com.kylink.model.Law;

import java.util.List;

public interface LawService {

    /**
     * 高级检索
     *
     * @param index       索引库名称
     * @param list        查询列表
     * @param reFromTime  发布开始日期
     * @param reToTime    发布结束日期
     * @param reAuthority 发布机构
     * @param level       级别
     * @param area        区域
     * @param trade       行业
     * @param acFromTime  生效开始日期
     * @param acToTime    生效结束日期
     * @param faFromTime  失效开始日期
     * @param faToTime    失效结束日期
     * @return
     */
    //List<Law> serach(String index, List<String> list, String reAuthority, String level, String area, String trade
    List<Law> serach(String index, String reAuthority, String level, String area, String trade
            , String reFromTime, String reToTime, String acFromTime, String acToTime, String faFromTime, String faToTime);

    /**
     * 快速检索
     *
     * @param param 查询内容
     * @return list
     */
    List<Law> searchAll(String param);

    /**
     * 根据id查详情
     *
     * @param id    id
     * @param index 索引名称
     * @return list
     */
    Law getId(String id, String index);

    /**
     * @param law
     * @return success
     */
    void save(Law law);

    /**
     * @param params
     * @param page
     * @param pageSize
     * @return
     */
    public SearchResults<Law> searchAll1(String params, int page, int pageSize);


    /**
     * @param index
     * @param list
     * @param law
     * @param page
     * @param pageSize
     * @return
     */
    public SearchResults<Law> serach1(String index, List<String> list, Law law, int page, int pageSize);


}
