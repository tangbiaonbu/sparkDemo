package com.ahua.demo.service;

import java.io.IOException;

public interface SparkLauncherService {

    /**
     *
     * @param jarPath
     * @param mainClass
     * @return
     * @throws IOException
     */
    int submit(String jarPath, String mainClass) throws IOException;
}

