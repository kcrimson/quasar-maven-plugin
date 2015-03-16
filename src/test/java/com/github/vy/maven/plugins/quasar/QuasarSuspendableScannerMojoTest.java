/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.vy.maven.plugins.quasar;

import java.io.File;
import org.apache.maven.plugin.Mojo;
import org.apache.maven.plugin.testing.AbstractMojoTestCase;

/**
 *
 * @author jaroslaw.palka
 */
public class QuasarSuspendableScannerMojoTest extends AbstractMojoTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    public void testMojoGoal() throws Exception{
        File testFile = getTestFile("src/test/resources/testing-harness/pom.xml");
        Mojo lookupMojo = lookupMojo("scan", testFile);
        lookupMojo.execute();
    }

}
