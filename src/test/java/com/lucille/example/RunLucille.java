package com.lucille.example;

import com.kmwllc.lucille.core.Runner;

/**
 * An alternative to using the lucille.sh. Use this test to be able to debug parts of your run configuration.
 */
public class RunLucille {
  public static void main(String[] args) throws Exception {
    // if no config.file is given to the run configuration, using example.conf
    String configFile = "conf/example.conf";
    System.getProperty("config.file", configFile);

    Runner.main(args);
  }

}
