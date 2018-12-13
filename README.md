# spring-boot-webmvc

> 两个应用文的上下文

> ServletContextListener -> ContextLoaderListener -> Root WebApplicationContext

> DispatcherServlet -> Servlet WebApplicationContext

> Root WebApplicationContext 是低层  

> Servlet WebApplicationContext 是上层

## 请求映射

>  servlet 规范:  12.1精确匹配  模糊匹配  

### spring mvc 

> DispatcherServlet

```java
DispatcherServlet
    FrameworkServlet
        HttpServletBean
            HttpServlet

自动装配 : org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration
```

> HandlerMapping

> HandlerMapping寻找request URI ，匹配的 handler(处理的方法)

> handler是处理的方法，当然这是一种实例。  

> 整体流程：Request -> Handler -> 执行结果 -> 返回（REST） -> 普通的文本

> 请求处理映射：RequestMappingHandlerMapping

> 拦截器：HandlerInterceptor 可以理解 Handler 到底是什么

> 处理顺序：preHandle(true) -> Handler: HandlerMethod 执行(Method#invoke) -> postHandle -> afterCompletion
                    preHandle(false)


```java
public class DefaultHandlerInterceptor implements HandlerInterceptor {
  
}
```

> @PostMapping == @RequestMapping(method = RequestMethod.POST)  Create(C)

> @GetMapping == @RequestMapping(method = RequestMethod.GET) Read(R)

> @PutMapping == @RequestMapping(method = RequestMethod.PUT) Update(U)

> @DeleteMapping == @RequestMapping(method = RequestMethod.DELETE) Delete(D)

## 异常处理

### servlet

#### servlet规范

| 请求属性                               | 类型                  |
| ---------------------------------- | ------------------- |
| javax.servlet.error.status_code    | java.lang.Integer   |
| javax.servlet.error.exceptjavax.servlet.error.servlet_name ion_type | java.lang.Class     |
| javax.servlet.error.message        | java.lang.Class     |
| javax.servlet.error.exception      | java.lang.Throwable |
| javax.servlet.error.request_uri    | java.lang.String    |
|   | java.lang.String    |
|                                    |                     |

> 代码见 【servlet-error-handle】


### spring mvc

@ExceptionHandler

@RestControllerAdvice = @ControllerAdvice + @ResponseBody

@ControllerAdvice

### spring boot

实现 ErrorPageRegistrar

注册 ErrorPage 对象

实现 ErrorPage 对象中的Path 路径Web服务

###  servlet | spring mvc | spring boot 对比

###### servlet

优点：统一处理，业界标准

不足：灵活度不够，只能定义 web.xml文件里面

###### Spring Web MVC 

优点：易于理解，尤其是全局异常处理

不足：很难完全掌握所有的异常类型

###### spring boot

状态码：比较通用，不需要理解Spring WebMVC 异常体系

不足：页面处理的路径必须固定
