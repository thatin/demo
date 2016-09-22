package com.brocade.demo.antlr.bvm;

import com.brocade.demo.antlr.InterfaceLexer;
import com.brocade.demo.antlr.InterfaceParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by nthatiko on 9/18/2016.
 */
public class RunningConfigTest {


    public static void main(String[] args) throws Exception {

        String fileName = "C:\\BVM\\antlr\\demo-antlr-test\\src\\main\\resources\\running-config";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(s -> parseConfig(s));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void parseConfig(String configInstruction) {
        // Get our lexer
        InterfaceLexer lexer = new InterfaceLexer(new ANTLRInputStream(configInstruction));

        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Pass the tokens to the parser
        InterfaceParser parser = new InterfaceParser(tokens);

        // Specify our entry point
        InterfaceParser.RunningConfigContext interfaceSentenceContext = parser.runningConfig();

        // Walk it and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        BVMInterfaceListener listener = new BVMInterfaceListener();
        walker.walk(listener, interfaceSentenceContext);
    }


    public static void parseCustomConfig(String configInstruction) {
        // Get our lexer
        InterfaceLexer lexer = new InterfaceLexer(new ANTLRInputStream(configInstruction));

        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Pass the tokens to the parser
        InterfaceParser parser = new InterfaceParser(tokens);


        // Specify our entry point
        InterfaceParser.RunningConfigContext interfaceSentenceContext = parser.runningConfig();

        // Walk it and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        BVMInterfaceListener listener = new BVMInterfaceListener();
        walker.walk(listener, interfaceSentenceContext);
    }
}
