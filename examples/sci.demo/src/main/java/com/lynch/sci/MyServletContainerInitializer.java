package com.lynch.sci;


import com.lynch.sci.service.CalcService;
import com.lynch.sci.service.HelloService;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.EnumSet;
import java.util.Set;

@HandlesTypes(value={HelloService.class, CalcService.class,
UserFilter.class, UserListener.class, UserServlet.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> arg0, ServletContext ctx) throws ServletException {
        for (Class<?> klass : arg0) {
            System.out.println(klass);

            if(klass.equals(HelloService.class)){
                try {
                   Method method = klass.getDeclaredMethod("say",new Class<?>[]{});
                   method.invoke(klass.newInstance(),new Object[]{});
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            if(klass.equals(CalcService.class)){
                try {
                    Method method = klass.getDeclaredMethod("add",int.class, int.class);
                    int result =  (int)method.invoke(klass.newInstance(),12,40);
                    System.out.println("calc result: "+ result);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        //注册组件  ServletRegistration
        ServletRegistration.Dynamic servlet = ctx.addServlet("userServlet", new UserServlet());
        //配置servlet的映射信息
        servlet.addMapping("/user");

        //注册Listener
        ctx.addListener(UserListener.class);

        //注册Filter  FilterRegistration
        FilterRegistration.Dynamic filter = ctx.addFilter("userFilter", UserFilter.class);
        //配置Filter的映射信息
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");

    }
}
