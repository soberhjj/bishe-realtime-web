package com.hjj.visual;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author soberhjj  2020/4/23 - 10:55
 *
 * Hbase操作工具类 (使用单例模式封装)
 */
public class HbaseUtil {

    HBaseAdmin admin=null;
    Configuration configuration=null;

    public static String date=new SimpleDateFormat("yyyyMMdd").format(new Date());
    private static String tabelName="category_clickcount";
    private static String cf="info";
    private static String qualifier="click_count";

    //私有构造方法
    private HbaseUtil(){
        configuration=new Configuration();
        configuration.set("hbase.zookeeper.quorum","master:2181");
        configuration.set("hbase.rootdir","hdfs://master:9000/hbase");

        try {
            admin=new HBaseAdmin(configuration);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static HbaseUtil instance=null;

    public static synchronized HbaseUtil getInstance(){
        if (instance==null){
            instance=new HbaseUtil();
        }
        return instance;
    }

    /**
     * 根据表明获取到 HTable实例
     * @param tableName
     * @return
     */
    public HTable getHTable(String tableName){
        HTable table=null;

        try {
            table=new HTable(configuration,tableName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return table;
    }

    /**
     * 添加记录到hbase表
     * @param tableName
     * @param rowkey
     * @param cf
     * @param column
     * @param value
     */
    public void put(String tableName,String rowkey,String cf,String column,String value){
        HTable table=getHTable(tableName);

        Put put=new Put(rowkey.getBytes());
        put.add(cf.getBytes(),column.getBytes(),value.getBytes());

        try {
            table.put(put);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Map<String,Long> query() throws IOException {
        Map<String,Long> map=new HashMap<>();

        Scan scan=new Scan();

        Filter filter=new PrefixFilter(date.getBytes());
        scan.setFilter(filter);

        HTable table=getHTable(tabelName);
        ResultScanner rs = table.getScanner(scan);
        for (Result result:rs){
            String row= Bytes.toString(result.getRow());
            long clickcount = Bytes.toLong(result.getValue(cf.getBytes(), qualifier.getBytes()));
            map.put(row,clickcount);
        }

        return map;

    }

    public static void main(String[] args) throws IOException {
        Map<String,Long> map=HbaseUtil.getInstance().query();
        for (Map.Entry<String,Long> entry:map.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }



}
