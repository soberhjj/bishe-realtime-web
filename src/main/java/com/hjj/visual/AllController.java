package com.hjj.visual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * @author soberhjj  2020/4/23 - 20:02
 */
@RestController
public class AllController {
    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String sayHello(){
        return "hello,nice to meet you ,springboot";
    }

    @RequestMapping(value="/index",method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("show2");
    }

    @Autowired
    CategoryClickCountDao categoryClickCountDao;

    @RequestMapping(value="/query",method = RequestMethod.POST)
    @ResponseBody
    public List<Long> categoryClickCount() throws IOException {
        List<Long> list=categoryClickCountDao.query();
        return list;
    }

}
