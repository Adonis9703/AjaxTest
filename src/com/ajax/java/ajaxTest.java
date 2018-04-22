package com.ajax.java;

import net.sf.json.JSONObject; //这个包很重要

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ajaxTest extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,IOException{

/********************************后端向前端通过JSON传值*******************************************/
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name","Adonis");
        jsonObject1.put("age",21);
        jsonObject1.put("gender","man");
        jsonObject1.put("info","我也爱学习");
        out.print(jsonObject1.toString());
        //out.write("test success");
        out.flush();
        out.close();
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{


     //   response.getWriter().write("success");
/********************************前端向后端通过JSON传值*******************************************/
        String jsonString = request.getParameter("mydata");       //json传回的是String类型字符串
        System.out.println("this is jsonString::::::::"+jsonString);

        JSONObject jsonObject = JSONObject.fromObject(jsonString);

        System.out.println(jsonObject.getString("name"));
        System.out.println(jsonObject.getInt("age"));
        System.out.println(jsonObject.getString("info"));
    }
}
