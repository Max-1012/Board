package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.awt.*;


// @Component 해서 Component 스캔 해줘도 되고, SpringConfig에 @Bean으로 직접 등록해줘도 되는데
// 직접 등록해주는 것을 추천
@Component
@Aspect
public class TimeTraceAop {

    // 원하는 곳에 공통 관심 사항 적용 하는 거니까 원하는 곳을 지정해줘야함!
    @Around("execution(* hello.hellospring..*(..))") // 클래스명, 파라미터 등 넣을 수 있는데 지금은 hellospring 패키지 하위에 다 적용
    public Object excute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START : "+joinPoint.toString());

        try {
            return  joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END : "+joinPoint.toString() + " " +timeMs +"ms");
        }


    }
}
