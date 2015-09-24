package com.flaviussana.demo.service;

//~--- JDK imports ------------------------------------------------------------

import java.io.Serializable;

import java.util.List;


public final class CacheManagerInformation implements Serializable {

private static final long serialVersionUID = -1;
private List<CacheInformation> cacheInformation;
private String cacheManagerId;

/**
 * Method getCacheInformation.
 *
 * @return The information about he caches
 */
public List<CacheInformation> getCacheInformation() {

  return cacheInformation;
}

/**
 * Method setCacheInformation.
 *
 * @param pCacheInformation The information about he caches
 */
public void setCacheInformation(final List<CacheInformation> pCacheInformation) {
  this.cacheInformation = pCacheInformation;
}

/**
 * Method getCacheManagerId.
 *
 * @return The class name and object id
 */
public String getCacheManagerId() {

  return cacheManagerId;
}

/**
 * Method setCacheManagerId.
 *
 * @param cacheManagerId The class name and object id
 */
public void setCacheManagerId(final String cacheManagerId) {
  this.cacheManagerId = cacheManagerId;
}
}
