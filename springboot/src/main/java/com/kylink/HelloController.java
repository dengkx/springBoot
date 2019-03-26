package com.kylink;


import com.kylink.model.Law;
import com.kylink.service.LawService;
import com.kylink.service.SearchResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class HelloController {
    @Autowired
    public LawService lawService;

    /**
     * 查询全部
     *
     * @param page
     * @param pageSize
     * @param parm
     * @param servletRequest
     * @return
     */
    @RequestMapping("/search1")
    public String listLaw(int page, int pageSize, String parm, HttpServletRequest servletRequest) {
        SearchResults<Law> list = lawService.searchAll1(parm, page, pageSize);
        servletRequest.setAttribute("lawlist", list);
        return "page4";
    }

    /**
     * 精准查找
     *
     * @param index
     * @param list
     * @param page
     * @param pageSize
     * @param law
     * @param servletRequest
     * @return
     */
    @RequestMapping("/search2")
    public String list(String index, List<String> list, int page, int pageSize, Law law, HttpServletRequest servletRequest) {
        SearchResults<Law> lawlist = lawService.serach1(index, list, law, page, pageSize);
        servletRequest.setAttribute("lawlist", lawlist);
        return "page4";
    }

    /**
     * 首页
     *
     * @param map
     * @return
     */
    @RequestMapping("/view")
    public String view(Law law) {
        //map.put("name", "成龙11111");
        //map.put("date", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        law.setLevel("1级");
        law.setTrade("beijing");
        law.setTitle("sdsdsd");
        return "index1";
    }


    @RequestMapping("/get")
    public String getId(Law law, HttpServletRequest servletRequest) {
        Law object = lawService.getId(law.getId(), law.getIndex());
        servletRequest.setAttribute("name", object);
        return "page4";

    }

    @RequestMapping("/tt")
    public String tt(String context, HttpServletRequest request) {
        System.out.println(context);
        List<Law> listLaw = lawService.searchAll(context);
        System.out.println(listLaw.size());
        request.setAttribute("name", listLaw);
        System.out.println(context);
        return "page1";
    }

    @RequestMapping("/search")
    public String search(String index, String reAuthority, String level, String area, String trade
            , Date reFromTime, Date reToTime, Date acFromTime, Date acToTime, Date faFromTime, Date faToTime, HttpServletRequest request) {

        if (reAuthority == null) {
            reAuthority = "";
        }
        if (level == null) {
            level = "";
        }
        if (area == null) {
            area = "";
        }
        if (trade == null) {
            trade = "";
        }

        String reftime;
        if (reFromTime == null) {
            reftime = "";
        } else {
            reftime = dateToStr(reFromTime);
        }
        String rettime;
        if (reToTime == null) {
            rettime = "";
        } else {
            rettime = dateToStr(reToTime);
        }
        String acftime;
        if (acFromTime == null) {
            acftime = "";
        } else {
            acftime = dateToStr(acFromTime);
        }
        String acttime;
        if (acToTime == null) {
            acttime = "";
        } else {
            acttime = dateToStr(acToTime);
        }
        String fftime;
        if (faFromTime == null) {
            fftime = "";
        } else {
            fftime = dateToStr(faFromTime);
        }
        String fttime;
        if (faToTime == null) {
            fttime = "";
        } else {
            fttime = dateToStr(faToTime);
        }
        List<Law> listLaw = lawService.serach(index, reAuthority, level, area, trade,
                reftime, rettime, acftime, acttime, fftime
                , fttime);
        System.out.println(listLaw.size());
        request.setAttribute("name", listLaw);
        return "page2";
    }

    @RequestMapping("/save")
    public String save(Law law) {
        lawService.save(law);
        return "page3";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    public static String dateToStr(java.util.Date dateDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(dateDate);
        return dateString;
    }


}
