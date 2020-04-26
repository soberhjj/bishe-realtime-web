package com.hjj.visual;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author soberhjj  2020/4/25 - 10:53
 */
@Component
public class CategoryClickCountDao {

    private static String date=HbaseUtil.date;
    public List<Long> query() throws IOException {
        List<Long> list=new ArrayList<>();

        Map<String, Long> map = HbaseUtil.getInstance().query();

        list.add(map.get(date+"_donghua"));
        list.add(map.get(date+"_music"));
        list.add(map.get(date+"_dance"));
        list.add(map.get(date+"_technology"));
        list.add(map.get(date+"_life"));
        list.add(map.get(date+"_fasion"));
        list.add(map.get(date+"_ent"));
        list.add(map.get(date+"_cinema"));
        list.add(map.get(date+"_anime"));
        list.add(map.get(date+"_guochuang"));
        list.add(map.get(date+"_game"));
        list.add(map.get(date+"_digital"));

        return list;
    }

    public static void main(String[] args) throws IOException {
        List<Long> list=new CategoryClickCountDao().query();
        for (long l:list){
            System.out.println(l);
        }
    }

}
