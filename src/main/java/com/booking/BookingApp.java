package com.booking;

import com.booking.api.BookingAPI;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import io.muserver.MuServer;
import io.muserver.MuServerBuilder;
import io.muserver.rest.Authorizer;
import io.muserver.rest.BasicAuthSecurityFilter;
import io.muserver.rest.RestHandlerBuilder;
import io.muserver.rest.UserPassAuthenticator;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.singletonMap;


public class BookingApp {

    private static final Map<String, Map<String, List<String>>> usersToPasswordToRoles = new HashMap<>();

    public static void main(String[] args) {

        usersToPasswordToRoles.put("admin", singletonMap("admin123", List.of("Admin")));
        usersToPasswordToRoles.put("User", singletonMap("user123", List.of("User")));

        MyUserPassAuthenticator authenticator = new MyUserPassAuthenticator(usersToPasswordToRoles);
        MyAuthorizer authorizer = new MyAuthorizer();

        MuServer server = MuServerBuilder.httpServer().withHttpPort(8081)
                .addHandler(
                        RestHandlerBuilder.restHandler(new BookingAPI())
                                .addRequestFilter(new BasicAuthSecurityFilter("My-App", authenticator, authorizer))
                                .addCustomWriter(new JacksonJaxbJsonProvider())
                                .addCustomReader(new JacksonJaxbJsonProvider())
                )
                .start();

        System.out.println("Booking API : " + server.uri().resolve("/booking/"));
    }
}

class MyUser implements Principal {
    private final String name;
    private final List<String> roles;

    MyUser(String name, List<String> roles) {
        this.name = name;
        this.roles = roles;
    }

    @Override
    public String getName() {
        return name;
    }

    public boolean isInRole(String role) {
        return roles.contains(role);
    }
}

class MyUserPassAuthenticator implements UserPassAuthenticator {
    private final Map<String, Map<String, List<String>>> usersToPasswordToRoles;

    public MyUserPassAuthenticator(Map<String, Map<String, List<String>>> usersToPasswordToRoles) {
        this.usersToPasswordToRoles = usersToPasswordToRoles;
    }

    @Override
    public Principal authenticate(String username, String password) {
        Principal principal = null;
        Map<String, List<String>> user = usersToPasswordToRoles.get(username);
        if (user != null) {
            List<String> roles = user.get(password);
            if (roles != null) {
                principal = new MyUser(username, roles);
            }
        }
        return principal;
    }
}

class MyAuthorizer implements Authorizer {
    @Override
    public boolean isInRole(Principal principal, String role) {
        if (principal == null) {
            return false;
        }
        MyUser user = (MyUser) principal;
        return user.isInRole(role);
    }
}