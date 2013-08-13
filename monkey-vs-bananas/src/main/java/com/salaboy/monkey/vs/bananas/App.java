package com.salaboy.monkey.vs.bananas;

import com.salaboy.monkey.vs.bananas.model.Banana;
import com.salaboy.monkey.vs.bananas.model.Box;
import com.salaboy.monkey.vs.bananas.model.Monkey;
import java.io.PrintStream;
import javax.inject.Inject;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.kie.api.runtime.KieSession;

/**
 * Hello world!
 *
 */
public class App 
{
    @Inject
    KieSession kSession;

    public void go(PrintStream out) {
        Box box = new Box();
        box.setX(10);
        box.setY(10);
        Monkey monkey = new Monkey();
        
        
        Banana banana = new Banana();
        banana.setX(5);
        banana.setY(5);
        banana.setLevel("celing");
        
        
        kSession.insert(box);
        kSession.insert(monkey);
        kSession.insert(banana);
       
        kSession.fireAllRules();
        
        
    }

    public static void main(String[] args) {
        Weld w = new Weld();

        WeldContainer wc = w.initialize();
        App bean = wc.instance().select(App.class).get();
        bean.go(System.out);

        w.shutdown();
    }
}
