package com.brocade.demo.antlr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class DemoTestTest {

    CommonTokenStream tokenStream;
    ParseTree tree;

    // This method is run before each method annotated with @Test below
    @Before
    public void setup() throws IOException {
        InputStream resourceAsStream = getClass().getResourceAsStream("/t.expr");
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(resourceAsStream);
    }

    @Test
    public void testListener() throws IOException {
        ParseTreeWalker walker = new ParseTreeWalker();
    }

    @Test
    public void testVisitor() throws IOException {
    }

}
