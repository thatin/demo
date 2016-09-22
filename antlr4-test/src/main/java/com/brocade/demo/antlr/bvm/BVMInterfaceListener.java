package com.brocade.demo.antlr.bvm;

import com.brocade.demo.antlr.InterfaceBaseListener;
import com.brocade.demo.antlr.InterfaceParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nthatiko on 9/18/2016.
 */
public class BVMInterfaceListener extends InterfaceBaseListener {

    private List<String> ports = new ArrayList<>();

    @Override public void enterPortNumber(InterfaceParser.PortNumberContext ctx) {
        ports.add(ctx.getText());

    }

    @Override public void enterRunningConfig(InterfaceParser.RunningConfigContext ctx) {
        //System.out.println(ctx.getText());
    }

    @Override public void exitRunningConfig(InterfaceParser.RunningConfigContext ctx) {
        ports.stream().forEach(System.out::println);
    }
}
