package com.Htmlgame.Htmlgame.Rest;

import com.Htmlgame.Htmlgame.Dao.Dao;
import com.Htmlgame.Htmlgame.Entity.Web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api")
public class DemoRest {

    String newline = System.lineSeparator();
    private final Dao dao;

    @Autowired
    public DemoRest(Dao dao) {
        this.dao = dao;
    }

    @GetMapping("/open")
    public String getOpen() {
        System.out.println(newline+"SignUp Page Open"+newline);
        return "signup";
    }

    @PostMapping("/signup")
    public String getSignUp(@RequestParam("username") String username,
                            @RequestParam("email") String email,
                            @RequestParam("password") String password){
        System.out.println(newline+"Username: " + username + newline + "Email:" + email + newline + "Password:" + password + newline);
        if(dao.findByEmail(email)!=null){
            System.out.println(newline + "SignUp Error Occur" + newline);
            return "error";
        }

        Web emp=new Web(username,email,password);
        emp.setUsername(username);
        emp.setEmail(email);
        emp.setPassword(password);

        dao.save(emp);

        System.out.println("Successfully SignUp"+newline);

        return "game";
    }

    @PostMapping("/login")
    public String getLogin(@RequestParam("login_email") String email,
                           @RequestParam("login_password") String password) {
        System.out.println(newline+"Email: " + email + newline + "Password:" + password + newline);
        if (dao.findByLogin(email, password) != null) {
            System.out.println("Successfully Login"+newline);
            return "game";
        }
        System.out.println("Login Error Occur"+newline);
    return "error";
    }
}
