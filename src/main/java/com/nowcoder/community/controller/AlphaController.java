package com.nowcoder.community.controller;

import com.nowcoder.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author HQ
 * @program: community
 * @description: controller
 * @date 2022-05-29 11:49:22
 */
@Controller
@RequestMapping("/alpha")
public class AlphaController {


    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/hello")
    @ResponseBody
    public String saveHello() {
        return "hello 1111";
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + " " + value);
        }

        System.out.println(request.getParameter("code"));

        //
        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.write("<h1>牛客网</h1>");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("response.getStatus() " + response.getStatus());
    }

    //Get请求

    //查询所有学生
    @RequestMapping(path = "/student", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@RequestParam(name = "current", required = false, defaultValue = "1") int current, @RequestParam(name = "current", required = false, defaultValue = "1") int limit) {
        System.out.println(current);
        System.out.println(limit);
        return "someStudent";
    }

    //
    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getStudetn2(@PathVariable("id") int id) {
        System.out.println(id);
        return "student";
    }

    //
    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String getStudetn3(String name,  int age) {
        System.out.println(name);
        System.out.println(age);
        return "student : " + name + " " + age;
    }

    // 响应HTML
    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name","zhangsan");
        mav.addObject("age",20);
        mav.setViewName("/demo/view");
        return mav;
    }

    // 响应HTML
    @RequestMapping(path = "/school",method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name","北京大学");
        model.addAttribute("age","1000");
        return "/demo/view";
    }

    //响应JSON数据（异步请求）
    //Java对象 -> JSON字符串 -> JS对象
    @RequestMapping(path = "" +
            "", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmp(){
        Map<String, Object> emp = new HashMap<>();
        emp.put("name","zhangsan");
        emp.put("age","20");
        emp.put("salary","8000");
        return emp;
    }

    //响应JSON数据（异步请求）
    //Java对象 -> JSON字符串 -> JS对象
    @RequestMapping(path = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getEmp1(){
        List<Map<String,Object>> res = new ArrayList<>();
        Map<String, Object> emp = new HashMap<>();
        emp.put("name","zhangsan");
        emp.put("age","20");
        emp.put("salary","8000");
        res.add(emp);
        Map<String, Object> emp1 = new HashMap<>();
        emp.put("name","lisi");
        emp.put("age","70");
        emp.put("salary","4000");
        res.add(emp1);
        emp = new HashMap<>();
        emp.put("name","wangwu");
        emp.put("age","150");
        emp.put("salary","5000");
        res.add(emp);
        return res;
    }
}

