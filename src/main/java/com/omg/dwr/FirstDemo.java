package com.omg.dwr;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.dwr.Util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;

/**
 * Created by admin on 2017/1/11.
 */
public class FirstDemo {

    public void test(String msg){
        try {
            msg = URLEncoder.encode(msg, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        WebContext webContext = WebContextFactory.get();
        Collection sessions = webContext.getAllScriptSessions();
        ScriptBuffer sb = new ScriptBuffer();
        sb.appendScript("callback(\"");
        sb.appendScript(msg);
        sb.appendScript("\")");
        Util util = new Util(sessions);
        util.addScript(sb);
    }
}
