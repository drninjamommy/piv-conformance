/*
 * wuff
 *
 * Copyright 2014-2015 Andrey Hihlovskiy and contributors.
 *
 * See the file "LICENSE" for copying and usage permission.
 */
package org.akhikhl.wuff

import org.gradle.api.Project

/**
 *
 * @author akhikhl
 */
class EclipseIdeBundleConfigurer extends EclipseBundleConfigurer {

  EclipseIdeBundleConfigurer(Project project) {
    super(project)
  }

  @Override
  protected List<String> getModules() {
    return super.getModules() + [ 'eclipseIdeBundle' ]
  }
}
