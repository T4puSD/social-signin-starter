package com.tapusd.socialsigninstarter.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getIndex(@AuthenticationPrincipal OAuth2AuthenticatedPrincipal principal, Model model) {
        System.out.println(principal);
        String fullName = ((DefaultOidcUser) principal).getFullName();
        model.addAttribute("name", fullName);
        return "index";
    }
}
