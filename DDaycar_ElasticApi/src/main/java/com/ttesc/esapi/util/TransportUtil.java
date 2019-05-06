package com.ttesc.esapi.util;

import com.ttesc.esapi.model.BaseBean;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.WildcardQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2019/5/5 14:49
 */
public class TransportUtil {
    private Client client;
    public TransportUtil(String clusterName,String host,int port){
        //1、设置连接信息
        Settings settings=Settings.builder().put("cluster.name",clusterName).build();
        //2、创建客户端对象
        client=new PreBuiltTransportClient(settings).
                addTransportAddress(new TransportAddress(
                        new InetSocketAddress(host,port)));

    }
    //新增
    public boolean save(String index,String type,int id,String content){
       IndexResponse response= client.prepareIndex(index,type,id+"").setSource(content,XContentType.JSON).get();
       if(response.status().toString().equals("CREATED")){
           return true;
       }else {
           return false;
       }
    }
    //批量新增
    public boolean saveBatch(String index,String type,List<Integer> ids,List<String> contents){
        BulkRequestBuilder bulkRequestBuilder=client.prepareBulk();
        for(int i=0;i<ids.size();i++){
            bulkRequestBuilder.add(client.prepareIndex(index,type,ids.get(i)+"").setSource(contents.get(i),XContentType.JSON));
        }
        BulkResponse responses=bulkRequestBuilder.execute().actionGet();
        return !responses.hasFailures();
    }
    public boolean saveBatch(List<BaseBean> beans){
        BulkRequestBuilder bulkRequestBuilder=client.prepareBulk();
        for(int i=0;i<beans.size();i++){
            BaseBean baseBean=beans.get(i);
            bulkRequestBuilder.add(client.prepareIndex(baseBean.getIndex(),baseBean.getType(),baseBean.getId()+"").setSource(baseBean.getContent(),XContentType.JSON));
        }
        BulkResponse responses=bulkRequestBuilder.execute().actionGet();
        return !responses.hasFailures();
    }
    //删除数据
    public boolean delete(String index,String type,int id){
        DeleteResponse response= client.prepareDelete(index,type,id+"").get();
        if(response.status().toString().equals("OK")){
            return true;
        }else {
            return false;
        }
    }
    public boolean deleteBatch(List<BaseBean> beans){
        BulkRequestBuilder bulkRequestBuilder=client.prepareBulk();
        for(int i=0;i<beans.size();i++){
            BaseBean baseBean=beans.get(i);
            bulkRequestBuilder.add(client.prepareDelete(baseBean.getIndex(),baseBean.getType(),baseBean.getId()+""));
        }
        BulkResponse responses=bulkRequestBuilder.execute().actionGet();
        return !responses.hasFailures();
    }

    //查询单个
    public String queryByid(String index,String type,int id){
        GetResponse response=client.prepareGet(index,type,id+"").get();
        return response.getSourceAsString();
    }
    //删除索引


    //查询
    //分页查询
    public List<String> queryPage(String index,String type,int page,int limit){
        SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
        searchSourceBuilder.from((page-1)*limit);
        searchSourceBuilder.size(limit);
        SearchRequest request=new SearchRequest(index);
        request.types(type);
        request.source(searchSourceBuilder);
        SearchResponse response=client.search(request).actionGet();
        SearchHit[] arr=response.getHits().getHits();
        List<String> list=new ArrayList<>();
        for(SearchHit sh:arr){
            list.add(sh.getSourceAsString());
        }
        return list;
    }
    //模糊查询
    public List<String> queryLike(String index,String type,String field,String value) {
        WildcardQueryBuilder wildcardQueryBuilder=QueryBuilders.wildcardQuery(field,"*"+value+"*");
        SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
        searchSourceBuilder.query(wildcardQueryBuilder);
        SearchRequest request=new SearchRequest(index);
        request.types(type);
        request.source(searchSourceBuilder);
        SearchResponse response=client.search(request).actionGet();
        SearchHit[] arr=response.getHits().getHits();
        List<String> list=new ArrayList<>();
        for(SearchHit sh:arr){
            list.add(sh.getSourceAsString());
        }
        return list;
    }
}
