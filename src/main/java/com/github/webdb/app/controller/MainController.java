package com.github.webdb.app.controller;

import com.github.webdb.app.pojo.vo.AjaxResult;
import com.github.webdb.app.pojo.vo.SqlExecuteContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    /**
     * 主页
     */
    @RequestMapping("/")
    public String index() {
        return "/index";
    }

    /**
     * 执行 sql, 通用简洁 API
     * @param context SqlExecuteContext
     * @return AjaxResult
     */
    @RequestMapping("/excute")
    @ResponseBody
    public AjaxResult excute(@RequestBody SqlExecuteContext context) {
        AjaxResult result = new AjaxResult();
        // todo：excute and fill result
        result.setResult(context);
        return result;
    }
}
