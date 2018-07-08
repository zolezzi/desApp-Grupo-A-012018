package edu.unq.desapp.grupo_a.backend.aspects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.joda.time.DateTime;

@Aspect
public class RepositoryAuditor {
    private static Logger log = Logger.getLogger(RepositoryAuditor.class.getName());

    public RepositoryAuditor() {
        PropertyConfigurator.configure("src/main/java/log4j.properties");
    }

    @Around("execution(* edu.unq.desapp.grupo_a.backend.repository..*(..))")
    public Object logAround(ProceedingJoinPoint jointPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) jointPoint.getSignature();
        DateTime initialTime = new DateTime();
        String nameMethod = signature.getMethod().getName();
        log.info("Start " + nameMethod + " in " + initialTime);
        this.printArguments(jointPoint.getArgs());
        Object response = jointPoint.proceed();
        DateTime endTime = new DateTime();
        log.info("End " + nameMethod + " in " + endTime);
        return response;
    }

    private void printArguments(Object[] arguments) {
        log.info("*****Arguments*****");
        for (Object o : arguments) {
            log.info(o.toString());
        }
    }
}
