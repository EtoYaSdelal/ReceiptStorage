package app.aspect;

import app.model.Log;
import app.service.LogService;
import app.service.LogServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
@Aspect
public class LogAspect {

    @Autowired
    LogService logService;

    @Before("execution(* app.service.ReceiptRepositoryServiceImpl.*(..))")
    public void beforeServiceMethodInvocation(JoinPoint jp) {
        createLog(jp);
    }

    @Before("execution(* app.controller.*.*(..))")
    public void beforeControllerMethodInvocation(JoinPoint jp){
        createLog(jp);
    }

    private void createLog(JoinPoint jp) {
        Log log = new Log();
        log.setMessage("Invocation method sign " + jp.getSignature());
        log.setDate(LocalDate.now());
        log.setTime(LocalTime.now());
        logService.addLog(log);
        System.out.println("Invocation method sign " +
                "" + jp.getSignature() + " | " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}
