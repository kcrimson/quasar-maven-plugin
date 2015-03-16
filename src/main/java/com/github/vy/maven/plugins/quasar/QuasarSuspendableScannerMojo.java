/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.vy.maven.plugins.quasar;

import co.paralleluniverse.fibers.instrument.SuspendablesScanner;
import java.io.File;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 *
 * @author jaroslaw.palka@symentis.pl
 */
@Mojo(name = "scan", defaultPhase = LifecyclePhase.PROCESS_CLASSES)
public class QuasarSuspendableScannerMojo extends AbstractMojo{

    
    @Parameter(defaultValue = "${project.build.outputDirectory}")
    private File classes;
    
    @Parameter(defaultValue = "true")
    private String auto;
    
    @Parameter(defaultValue = "false")
    private String append;
    
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        
        SuspendablesScanner ss = new SuspendablesScanner(classes.toPath());
        System.out.println(classes);
        ss.setAuto(Boolean.valueOf(auto));
        ss.setAppend(Boolean.valueOf(append));
        
        ss.execute();

    }

    public File getClasses() {
        return classes;
    }

    public void setClasses(File classes) {
        this.classes = classes;
    }

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public String getAppend() {
        return append;
    }

    public void setAppend(String append) {
        this.append = append;
    }
    
    
    
}
