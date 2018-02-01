/*
 * wuff
 *
 * Copyright 2014-2015 Andrey Hihlovskiy and contributors.
 *
 * See the file "LICENSE" for copying and usage permission.
 */
package org.akhikhl.wuff

/**
 *
 * @author ahi
 */
class SwtAppProductsExtension {

  boolean archiveProducts = false
  List productList = []
  List additionalProductFiles = []
  List excludeProductFile = []
  List launchParameters = []
  String jvmMinMemory
  String jvmMaxMemory

  void additionalProductFiles(newValue) {
    if(newValue instanceof Collection)
      additionalProductFiles.addAll newValue
    else
      additionalProductFiles.add newValue
  }

  void excludeProductFile(Closure newValue) {
    excludeProductFile.add newValue
  }

  void launchParameter(String newValue) {
    launchParameters.add newValue
  }

  void product(Map productSpec) {
    productList.add productSpec
  }
}

