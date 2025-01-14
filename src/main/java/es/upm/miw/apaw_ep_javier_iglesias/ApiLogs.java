package es.upm.miw.apaw_ep_javier_iglesias;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ApiLogs {

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void allResources() {
        // Don't need code
    }

    @Before("allResources()")
    public void apiRequestLog(JoinPoint jp) {
        LogManager.getLogger(jp.getSignature().getDeclaringTypeName())
                .info("------------------------- o -------------------------");
        StringBuilder log = new StringBuilder(jp.getSignature().getName() + " >>>");
        for (Object arg : jp.getArgs()) {
            log.append("\n   ARG: ").append(arg);
        }
        LogManager.getLogger(jp.getSignature().getDeclaringTypeName()).info(log);
    }

    @AfterReturning(pointcut = "allResources()", returning = "result")
    public void apiResponseLog(JoinPoint jp, Object result) {
        ObjectMapper mapper = new ObjectMapper();
        String resultAsString;
        try {
            resultAsString = mapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            resultAsString = result.toString();
        }
        String log = "<<< Return << " + jp.getSignature().getName() + ": " + resultAsString;
        if (log.length() > 1000) {
            log = log.substring(0, 1000) + ".... (+" + log.length() + " characters)";
        }
        LogManager.getLogger(jp.getSignature().getDeclaringTypeName()).info(log);
    }

    @AfterThrowing(pointcut = "allResources()", throwing = "exception")
    public void apiResponseExceptionLog(JoinPoint jp, Exception exception) {
        String log = "<<< Return Exception << " + jp.getSignature().getName() + ": "
                + exception.getClass().getSimpleName() + "->" + exception.getMessage();
        LogManager.getLogger(jp.getSignature().getDeclaringTypeName()).info(log);
    }

}
