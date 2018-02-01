/*
 * wuff
 *
 * Copyright 2014-2015 Andrey Hihlovskiy and contributors.
 *
 * See the file "LICENSE" for copying and usage permission.
 */
package org.akhikhl.wuff

import org.akhikhl.unpuzzle.PlatformConfig

/**
 * Reads plugin configuration from the specified groovy script.
 * @author akhikhl
 */
final class ConfigReader {

  Config readFromResource(String resourceName) {
    Config config = new Config()
    Binding binding = new Binding()
    binding.wuff = { Closure closure ->
      closure.resolveStrategy = Closure.DELEGATE_FIRST
      closure.delegate = config
      closure()
    }
    binding.current_os = PlatformConfig.current_os
    binding.current_arch = PlatformConfig.current_arch
    binding.PluginUtils = PluginUtils.class
    GroovyShell shell = new GroovyShell(binding)
    this.getClass().getResourceAsStream(resourceName).withReader('UTF-8') {
      shell.evaluate(it)
    }
    return config
  }
}

