package main.controllers;

import main.models.jdbc.UserDaoJdbc;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * ServletFilter реализует интерфейс Filter
 */
@WebFilter("/ServletFilter")
public class ServletFilter implements Filter
{
    private static Logger logger = Logger.getLogger(ServletFilter.class);
    private FilterConfig filterConfig;
    private static ArrayList<String> pages;  // хранилище страниц

    /**
     * Конструктор по умолчанию
     */
    public ServletFilter()
    {
        // Создание хранилища страниц
        if (pages == null)
            pages = new ArrayList<String>();
        logger.trace("try filter!!!!!    ServletFilter()");
    }

    /**
     * Метод освобождения ресурсов
     * @see Filter#destroy()
     */
    @Override
    public void destroy() {}

    /**
     * Метод инициализации фильтра
     * @see Filter#init(FilterConfig)
     */
    @Override
    public void init(FilterConfig fConfig) throws ServletException
    {
        filterConfig = fConfig;
        logger.trace("try filter!!!!!    init");
    }
    /**
     * Метод фильтрации
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException
    {
        logger.trace("try filter!!!!!");
        // Если фильтр активной, то выполнить проверку
        if (filterConfig.getInitParameter("active").equalsIgnoreCase("true")) {
            HttpServletRequest req = (HttpServletRequest)request;
            // Раскладываем адрес на составляющие
            String[] list = req.getRequestURI().split("/");
            // Извлекаем наименование страницы

            String page = null;
            if (list[list.length - 1].indexOf(".jsp") > 0)
                page = list[list.length - 1];
                else
                page = list[list.length - 1];

            logger.trace(page + " list.size() " + list.length + " " + Arrays.deepToString(list));
            // Если открывается главная страница, то выполняем проверку
            if ((page != null) && page.equalsIgnoreCase("users")) {
                // Если была предварительно открыта одна из страниц
                // login.jsp или registration.jsp, то передаем управление
                // следующему элементу цепочки фильтра
                if (UserDaoJdbc.getAuth() && (pages.contains("login.jsp") || pages.contains("registration.jsp"))) {
                    logger.trace(pages.contains("login.jsp") + " login.jspc= "+ pages.contains("registration.jsp"));
                            filterChain.doFilter(request, response);
                    return;
                } else {
                    logger.trace("page" );
                    // Перенаправление на страницу login.jsp
                    ServletContext ctx = filterConfig.getServletContext();
                    RequestDispatcher dispatcher = ctx.getRequestDispatcher("/login.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
            } else if (page != null) {
                // Добавляем страницу в список
                if (!pages.contains(page))
                    pages.add(page);
            }
        }
        filterChain.doFilter(request, response);
    }
}