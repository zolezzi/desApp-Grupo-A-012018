package edu.unq.desapp.grupo_a.backend.aspects;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class WebServicesAuditor {
    private static Logger log = Logger.getLogger(WebServicesAuditor.class.getName());

    public WebServicesAuditor() {
        PropertyConfigurator.configure("src/main/java/log4j.properties");
    }

    @Before("execution(* edu.unq.desapp.grupo_a.backend.webservice..*(..))")
    public void auditRestMethod(JoinPoint jp) {
        String target = jp.getTarget().getClass().getName();
        String invokingMethodName = jp.getSignature().getName();
        Object[] signatureArgs = jp.getArgs();
        String args = buildStringArgs(signatureArgs);
        String toLog = target + "." + invokingMethodName + "(" + args + ")";
        log.info(toLog);
    }

    private String buildStringArgs(Object[] args) {
        if (args.length == 0) {
            return "";
        } else {
            List<String> stringArgs = new LinkedList<>();
            for (Object signatureArg: args) {
                stringArgs.add(signatureArg.toString());
            }
            return "Parameters: ".concat(String.join(", ", stringArgs));
        }
    }
}
