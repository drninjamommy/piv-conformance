/*
 * wuff
 *
 * Copyright 2014-2015 Andrey Hihlovskiy and contributors.
 *
 * See the file "LICENSE" for copying and usage permission.
 */
package org.akhikhl.wuff

import spock.lang.Specification

/**
 *
 * @author akhikhl
 */
class ConfigReaderTest extends Specification {

  ConfigReader reader

  def setup() {
    reader = new ConfigReader()
  }

  def 'should read empty configuration'() {
  when:
    Config config = reader.readFromResource('emptyConfig.groovy')
  then:
    config.selectedEclipseVersion == null
    config.versionConfigs.isEmpty()
  }

  def 'should read selected eclipse version'() {
  when:
    Config config = reader.readFromResource('selectedEclipseVersionConfig.groovy')
  then:
    config.selectedEclipseVersion == '4.3.2'
    config.versionConfigs.isEmpty()
  }

  def 'should read eclipse versions configuration'() {
  when:
    Config config = reader.readFromResource('eclipseVersionsConfig.groovy')
  then:
    config.versionConfigs.size() == 3
    config.versionConfigs.containsKey('3.7.2')
    config.versionConfigs['3.7.2'].eclipseMavenGroup == 'eclipse-indigo'
    config.versionConfigs.containsKey('4.2.2')
    config.versionConfigs['4.2.2'].eclipseMavenGroup == 'eclipse-juno'
    config.versionConfigs.containsKey('4.3.2')
    config.versionConfigs['4.3.2'].eclipseMavenGroup == 'eclipse-kepler'
  }

  def 'should read eclipse modules configuration'() {
  when:
    Config config = reader.readFromResource('eclipseModulesConfig.groovy')
  then:
    config.versionConfigs.size() == 3
    config.versionConfigs['3.7.2'].lazyModules.size() == 2
    config.versionConfigs['3.7.2'].lazyModules.containsKey('moduleA')
    config.versionConfigs['3.7.2'].lazyModules.containsKey('moduleB')
    config.versionConfigs['4.2.2'].lazyModules.size() == 2
    config.versionConfigs['4.2.2'].lazyModules.containsKey('moduleC')
    config.versionConfigs['4.2.2'].lazyModules.containsKey('moduleD')
    config.versionConfigs['4.3.2'].lazyModules.size() == 2
    config.versionConfigs['4.3.2'].lazyModules.containsKey('moduleE')
    config.versionConfigs['4.3.2'].lazyModules.containsKey('moduleF')
  }
}
