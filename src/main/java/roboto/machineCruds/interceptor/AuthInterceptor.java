package roboto.machineCruds.interceptor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import roboto.machineCruds.Repository.UserRepository;
import roboto.machineCruds.model.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("Request URL: " + request.getRequestURL().toString());

        HttpSession session = request.getSession(false);
        String token = (session != null) ? (String) session.getAttribute("token") : null;

        if (token == null) {
            response.sendRedirect("/login");
            return false;
        }

        Optional<User> user = userRepository.findByRememberToken(token);
        if (user.isPresent()) {

            return true;
        } else {
            response.sendRedirect("/login");
            return false;
        }
    }


    // Para despues de que el controlador procesado la solicitud
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // 
    }


}
