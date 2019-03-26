package com.kylink.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.kylink.model.Law;
import com.kylink.service.LawService;
import com.kylink.service.SearchResults;
import com.kylink.util.EsConnect;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.kylink.util.EsConnect.getList;


@Service("jobService")
public class LawServiceImpl implements LawService {

    @Override
    //public List<Law> serach(String index, List<String> list, String reAuthority, String level, String area, String trade, String reFromTime, String reToTime, String acFromTime, String acToTime, String faFromTime, String faToTime) {
    public List<Law> serach(String index, String reAuthority, String level, String area, String trade, String reFromTime, String reToTime, String acFromTime, String acToTime, String faFromTime, String faToTime) {
        QueryBuilder es1 = null;
        QueryBuilder es2 = null;
        QueryBuilder es3 = null;
        QueryBuilder es4 = null;
        QueryBuilder es5 = null;
        QueryBuilder es6 = null;
        QueryBuilder es7 = null;
        QueryBuilder es8 = null;
        try {
            TransportClient client = EsConnect.connet("ubilink", "114.116.71.224", 9300);
            QueryBuilder qb = QueryBuilders.boolQuery();
            //if (list.size() > 0) {
            //    for (int i = 0; i < list.size(); i++) {
            //        String[] param = list.get(i).split(",");
            //        String pa = param[0];
            //        String relation = param[1];
            //        String con = param[2];
            //        es1 = QueryBuilders.matchQuery(pa, con);
            //        if (relation.equals("must")) {
            //            ((BoolQueryBuilder) qb).must(es1);
            //        } else if (relation.equals("must_not")) {
            //
            //            ((BoolQueryBuilder) qb).mustNot(es1);
            //        } else if (relation.equals("should")) {
            //            ((BoolQueryBuilder) qb).should(es1);
            //        }
            //    }
            //}
            if (reAuthority != null && !"".equals(reAuthority)) {
                es2 = QueryBuilders.termQuery("reAuthority.keyword", reAuthority);
                ((BoolQueryBuilder) qb).must(es2);
            }

            if (level != null && !"".equals(level)) {
                es3 = QueryBuilders.termQuery("level.keyword", level);
                ((BoolQueryBuilder) qb).must(es3);
            }

            if (area != null && !"".equals(area)) {
                es4 = QueryBuilders.termQuery("area.keyword", area);
                ((BoolQueryBuilder) qb).must(es4);
            }
            if (trade != null && !"".equals(trade)) {
                es5 = QueryBuilders.termQuery("trade.keyword", trade);
                ((BoolQueryBuilder) qb).must(es5);
            }

            if ((reFromTime != null && !"".equals(reFromTime)) && (reToTime != null && !"".equals(reToTime))) {
                es6 = QueryBuilders.rangeQuery("reDate").from(reFromTime).to(reToTime);
                ((BoolQueryBuilder) qb).must(es6);
            }
            if ((acFromTime != null && !"".equals(acFromTime)) && (acToTime != null && !"".equals(acToTime))) {
                es7 = QueryBuilders.rangeQuery("acDate").from(acFromTime).to(acToTime);
                ((BoolQueryBuilder) qb).must(es7);
            }
            if ((faFromTime != null && !"".equals(faFromTime)) && (faToTime != null && !"".equals(faToTime))) {
                es8 = QueryBuilders.rangeQuery("failDate").from(faFromTime).to(faToTime);
                ((BoolQueryBuilder) qb).must(es8);
            }
            SearchRequestBuilder responsebuilder = client.prepareSearch(index).setTypes("_doc");
            SearchResponse myresponse = responsebuilder
                    .setQuery(qb).execute().actionGet();
            SearchHits hits = myresponse.getHits();
            List<Law> lawList = new ArrayList<>();
            for (int i = 0; i < hits.getHits().length; i++) {
                JSONObject jsonObject = (JSONObject) JSONObject.parse(hits.getHits()[i].getSourceAsString());
                Law law = new Law();
                law.setIndex(index);
                law.setId(hits.getHits()[i].getId());
                law.setTitle(jsonObject.getString("title"));
                law.setReDate(jsonObject.getDate("reDate"));
                law.setReNumber(jsonObject.getString("reNumber"));
                law.setReAuthority(jsonObject.getString("reAuthority"));
                law.setLevel(jsonObject.getString("level"));
                law.setArea(jsonObject.getString("area"));
                law.setTrade(jsonObject.getString("trade"));
                lawList.add(law);
            }
            return lawList;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SearchResults<Law> serach1(String index, List<String> list, Law law, int page, int pageSize) {
        QueryBuilder es1 = null;
        QueryBuilder es2 = null;
        QueryBuilder es3 = null;
        QueryBuilder es4 = null;
        QueryBuilder es5 = null;
        QueryBuilder es6 = null;
        QueryBuilder es7 = null;
        QueryBuilder es8 = null;
        try {
            TransportClient client = EsConnect.connet("ubilink", "114.116.71.224", 9300);
            QueryBuilder qb = QueryBuilders.boolQuery();
            if (list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    String[] param = list.get(i).split(",");
                    String pa = param[0];
                    String relation = param[1];
                    String con = param[2];
                    es1 = QueryBuilders.matchQuery(pa, con);
                    if (relation.equals("must")) {
                        ((BoolQueryBuilder) qb).must(es1);
                    } else if (relation.equals("must_not")) {

                        ((BoolQueryBuilder) qb).mustNot(es1);
                    } else if (relation.equals("should")) {
                        ((BoolQueryBuilder) qb).should(es1);
                    }
                }
            }
            if (law.getReAuthority() != null && !"".equals(law.getReAuthority())) {
                es2 = QueryBuilders.termQuery("reAuthority.keyword", law.getReAuthority());
                ((BoolQueryBuilder) qb).must(es2);
            }

            if (law.getLevel() != null && !"".equals(law.getLevel())) {
                es3 = QueryBuilders.termQuery("level.keyword", law.getLevel());
                ((BoolQueryBuilder) qb).must(es3);
            }

            if (law.getArea() != null && !"".equals(law.getArea())) {
                es4 = QueryBuilders.termQuery("area.keyword", law.getArea());
                ((BoolQueryBuilder) qb).must(es4);
            }
            if (law.getTrade() != null && !"".equals(law.getTrade())) {
                es5 = QueryBuilders.termQuery("trade.keyword", law.getTrade());
                ((BoolQueryBuilder) qb).must(es5);
            }


            if ((law.getReFromTime() != null) && (law.getReToTime() != null)) {
                es6 = QueryBuilders.rangeQuery("reDate").from(law.getAcFromTime()).to(law.getReToTime());
                ((BoolQueryBuilder) qb).must(es6);
            }
            if ((law.getAcFromTime() != null) && (law.getAcToTime() != null)) {
                es7 = QueryBuilders.rangeQuery("acDate").from(law.getAcFromTime()).to(law.getAcToTime());
                ((BoolQueryBuilder) qb).must(es7);
            }
            if ((law.getFaFromTime() != null) && (law.getFaToTime() != null)) {
                es8 = QueryBuilders.rangeQuery("failDate").from(law.getFaFromTime()).to(law.getFaToTime());
                ((BoolQueryBuilder) qb).must(es8);
            }
            SearchRequestBuilder responsebuilder = client.prepareSearch(index).setTypes("_doc");
            SearchResponse myresponse = responsebuilder
                    .setQuery(qb).setFrom((page - 1) * pageSize).
                            setSize(pageSize).execute().actionGet();
            SearchHits hits = myresponse.getHits();

            long tatol = hits.getTotalHits();
            List<Law> lawList = new ArrayList<>();
            for (int i = 0; i < hits.getHits().length; i++) {
                Law law1 = new Law();
                JSONObject jsonObject = (JSONObject) JSONObject.parse(hits.getHits()[i].getSourceAsString());
                law1.setIndex(index);
                law1.setId(hits.getHits()[i].getId());
                law1.setTitle(jsonObject.getString("title"));
                law1.setReDate(jsonObject.getDate("reDate"));
                law1.setReNumber(jsonObject.getString("reNumber"));
                law1.setReAuthority(jsonObject.getString("reAuthority"));
                law1.setLevel(jsonObject.getString("level"));
                law1.setArea(jsonObject.getString("area"));
                law1.setTrade(jsonObject.getString("trade"));
                lawList.add(law1);
            }
            SearchResultsImpl<Law> results = new SearchResultsImpl<>(lawList);
            results.setNumResults(tatol);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Law> searchAll(String params) {
        QueryBuilder es1 = null;
        QueryBuilder es2 = null;
        try {
            TransportClient client = EsConnect.connet("ubilink", "114.116.71.224", 9300);
            QueryBuilder qb;
            if (params != null && !"".equals(params)) {
                es1 = QueryBuilders.matchPhraseQuery("title", params);
                es2 = QueryBuilders.matchPhraseQuery("fulltext", params);
                qb = QueryBuilders.boolQuery().should(es1).should(es2);
            } else {
                return null;
            }
            String[] indexs = {"test"};
            List<Law> list = new ArrayList<>();
            list = getList(client, qb, indexs);
            return list;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public SearchResults<Law> searchAll1(String params, int page, int pageSize) {
        QueryBuilder es1 = null;
        try {
            TransportClient client = EsConnect.connet("ubilink", "114.116.71.224", 9300);
            QueryBuilder qb;
            if (params != null && !"".equals(params)) {
                es1 = QueryBuilders.matchPhraseQuery("title", params);
                qb = QueryBuilders.boolQuery().should(es1);
            } else {
                return null;
            }
            String[] indexs = {"test"};
            SearchRequestBuilder responsebuilder = client.prepareSearch(indexs).setTypes("_doc");

            HighlightBuilder highlightBuilder = new HighlightBuilder();
            highlightBuilder.preTags("<span style=\"color:red\">");
            highlightBuilder.postTags("</span>");
            highlightBuilder.field("title");
            responsebuilder.setFrom((page - 1) * pageSize).setSize(pageSize);
            SearchResponse myresponse = responsebuilder.setQuery(qb).highlighter(highlightBuilder).execute().actionGet();
            SearchHits hits = myresponse.getHits();
            long tatol = hits.getTotalHits();
            List<Law> list = new ArrayList<>();
            for (int i = 0; i < hits.getHits().length; i++) {

                JSONObject jsonObject = (JSONObject) JSONObject.parse(hits.getHits()[i].getSourceAsString());
                Law law = new Law();
                HighlightField nameField = hits.getHits()[i].getHighlightFields().get("title");
                Text[] fragments = nameField.fragments();
                String nameTmp = "";
                for (Text text : fragments) {
                    nameTmp += text;
                }
                law.setIndex(hits.getHits()[i].getIndex());
                law.setId(hits.getHits()[i].getId());
                law.setTitle(nameTmp);
                law.setReDate(jsonObject.getDate("reDate"));
                law.setAcDate(jsonObject.getDate("acDate"));
                law.setFailDate(jsonObject.getDate("failDate"));
                law.setReNumber(jsonObject.getString("reNumber"));
                law.setReAuthority(jsonObject.getString("reAuthority"));
                law.setLevel(jsonObject.getString("level"));
                law.setArea(jsonObject.getString("area"));
                law.setTrade(jsonObject.getString("trade"));
                law.setAntistop(jsonObject.getString("antistop"));
                law.setDescribe(jsonObject.getString("describe"));
                law.setFulltext(jsonObject.getString("fulltext"));
                list.add(law);

            }
            SearchResultsImpl<Law> results = new SearchResultsImpl<>(list);
            results.setNumResults(tatol);

            return results;


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Law getId(String id, String index) {
        try {
            TransportClient client = EsConnect.connet("ubilink", "114.116.71.224", 9300);
            QueryBuilder qb = QueryBuilders.matchQuery("_id", id);
            SearchRequestBuilder responsebuilder = client.prepareSearch(index).setTypes("_doc");
            responsebuilder.setQuery(qb);
            SearchResponse myresponse = responsebuilder.execute().actionGet();
            SearchHits hits = myresponse.getHits();
            Law law = new Law();
            for (int i = 0; i < hits.getHits().length; i++) {
                JSONObject jsonObject = (JSONObject) JSONObject.parse(hits.getHits()[i].getSourceAsString());
                law.setReDate(jsonObject.getDate("reDate"));
                law.setAcDate(jsonObject.getDate("acDate"));
                law.setFailDate(jsonObject.getDate("failDate"));
                law.setReNumber(jsonObject.getString("reNumber"));
                law.setReAuthority(jsonObject.getString("reAuthority"));
                law.setLevel(jsonObject.getString("level"));
                law.setArea(jsonObject.getString("area"));
                law.setTrade(jsonObject.getString("trade"));
                law.setAntistop(jsonObject.getString("antistop"));
                law.setDescribe(jsonObject.getString("describe"));
                law.setFulltext(jsonObject.getString("fulltext"));
            }
            return law;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Law law) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Map map = new HashMap<>();
        map.put("title", law.getTitle());
        map.put("reNumber", law.getReNumber());
        map.put("reAuthority", law.getReAuthority());
        map.put("level", law.getLevel());
        map.put("area", law.area);
        map.put("trade", law.trade);
        map.put("antistop", law.getAntistop());
        map.put("describe", law.getDescribe());
        if (law.getReDate() != null) {
            String reDate = formatter.format(law.getReDate());
            map.put("reDate", reDate);
        }
        if (law.getAcDate() != null) {
            String acDate = formatter.format(law.getAcDate());
            map.put("acDate", acDate);
        }
        if (law.getFailDate() != null) {
            String failDate = formatter.format(law.getFailDate());
            map.put("failDate", failDate);
        }
        map.put("fulltext", law.getFulltext());
        TransportClient client = null;
        try {
            client = EsConnect.connet("ubilink", "114.116.71.224", 9300);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        IndexResponse response = client.prepareIndex("test", "_doc")
                .setSource(map)
                .get();
        System.out.println("save success!!!");
    }

}
