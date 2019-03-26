package com.kylink.util;

import com.alibaba.fastjson.JSONObject;
import com.kylink.model.Law;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EsConnect {
    /**
     * es连接
     *
     * @param clustname 集群名称
     * @param ip        ip
     * @param port      port
     * @return 客户端
     * @throws UnknownHostException
     */
    public static TransportClient connet(String clustname, String ip, int port) throws UnknownHostException {
        Settings settings = Settings.builder().put("cluster.name", clustname).build();
        TransportClient client = new PreBuiltTransportClient(settings).addTransportAddress(
                new TransportAddress(InetAddress.getByName(ip), port));
        return client;
    }

    /**
     * 返回数据
     *
     * @param client 客户端
     * @param qb     条件
     * @param indexs 索引名称
     * @return list
     */
    public static List<Law> getList(TransportClient client, QueryBuilder qb, String... indexs) {
        SearchRequestBuilder responsebuilder = client.prepareSearch(indexs).setTypes("_doc");
        HighlightBuilder highlightBuilder = new HighlightBuilder().field("*").requireFieldMatch(false);// .field("*").requireFieldMatch(true);
        highlightBuilder.preTags("<span style=\"color:red\">");
        highlightBuilder.postTags("</span>");

        SearchResponse myresponse = responsebuilder
                .setQuery(qb).highlighter(highlightBuilder).execute().actionGet();
        SearchHits hits = myresponse.getHits();
        List<Law> list = new ArrayList<>();
        for (int i = 0; i < hits.getHits().length; i++) {
            JSONObject jsonObject = (JSONObject) JSONObject.parse(hits.getHits()[i].getSourceAsString());
            Law law = new Law();
            System.out.println("111111=" + hits.getHits()[i].getHighlightFields().get("title"));
            hits.getHits()[i].getHighlightFields().get("title");
            HighlightField nameField = hits.getHits()[i].getHighlightFields().get("title");
            Text[] fragments = nameField.fragments();
            String nameTmp = "";
            for (Text text : fragments) {
                nameTmp += text;
            }
            System.out.println("2222=" + nameTmp);
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
        return list;
    }

    /**
     * @param dateDate 时间
     * @return string
     */
    public static String dateToStr(java.util.Date dateDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(dateDate);
        return dateString;
    }
}
